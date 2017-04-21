/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.DocenteCatedraRNLocal;
import RN.DocenteComisionRNLocal;
import RN.DocenteDepartamentoRNLocal;
import RN.DocenteRNLocal;
import RN.ProyectoAsesorRNLocal;
import RN.ProyectoCodirectorRNLocal;
import RN.ProyectoDirectorRNLocal;
import entidad.Catedra;
import entidad.Departamento;
import entidad.Depto;
import entidad.Docente;
import entidad.DocenteCatedra;
import entidad.DocenteDepartamento;
import entidad.Profesional;
import entidad.Proyecto;
import entidad.ProyectoAsesor;
import entidad.ProyectoCodirector;
import entidad.ProyectoDirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author cristian
 */
@ManagedBean
@SessionScoped
public class ListaDocenteBean {

    private int iActionBtnSelect;
    @EJB
    private DocenteRNLocal docenteRNLocal;
    @EJB
    private DocenteCatedraRNLocal docenteCatedraRNLocal;
    @EJB
    private DocenteComisionRNLocal docenteComisionRNLocal;
    private List<Docente> lstDocenteParaTribunal;
    private List<SelectItem> lstSIDocenteParaTribunal;
    private List<ProyectoDirector> lstProyDirector;
    private ProyectoDirector proyDir;
    private ProyectoCodirector proyCodir;
    private ProyectoAsesor proyAs;
    private List<ProyectoCodirector> lstproyCodir;
    private List<ProyectoAsesor> lstproyAs;
    private List<Docente> lstDocente;
    private List<Docente> lstDocente1;
    private List<DocenteDepartamento> lstDocenteDepartamento;
    private List<Object> lstDocenteCompleto;
    private Docente docente;
    private List<Docente> lstDocenteActivo;
    private List<SelectItem> lstSIDocente;
    private List<SelectItem> lstSIDocenteDepartamento;
    private List<SelectItem> lstSIDocenteActivo;

    private List<DocenteCatedra> lstDocenteCatedra;

    private List<Docente> lstDocenteByComision;
    private List<SelectItem> lstSIDocenteByComision;
    @EJB
    private ProyectoDirectorRNLocal proy_directorRNbeanLocal;
    @EJB
    private ProyectoCodirectorRNLocal proy_codirectorRNLocal;
    @EJB
    private ProyectoAsesorRNLocal proy_asesorRNLocal;
    

    private DocenteCatedra selectedDocenteCatedra;
    private DocenteCatedra docenteCatedraObj;
    private DocenteDepartamento docenteDepartmaento;
    private List<DocenteCatedra> listaDocCat;
    private List<DocenteDepartamento> listaDocenteDepartamento;

    /**
     * Creates a new instance of ListaCarreraBean
     */
    public ListaDocenteBean() {
        this.lstDocente = new ArrayList<Docente>();
        this.lstDocenteDepartamento = new ArrayList<DocenteDepartamento>();
        this.lstDocenteByComision = new ArrayList<Docente>();
        this.lstDocenteParaTribunal = new ArrayList<Docente>();
        this.lstDocenteActivo = new ArrayList<Docente>();
        this.lstDocenteCompleto = new ArrayList<Object>();
        this.lstDocenteCatedra = new ArrayList<DocenteCatedra>();
        this.listaDocCat = new ArrayList<DocenteCatedra>();
        this.docenteCatedraObj = new DocenteCatedra();
        this.docente = new Docente();
        this.docenteDepartmaento = new DocenteDepartamento();
        this.listaDocenteDepartamento = new ArrayList <DocenteDepartamento>();
         this.lstDocenteParaTribunal = new ArrayList<Docente>();
        this.lstDocente1 = new ArrayList<Docente>();
       
        this.lstproyAs = new ArrayList<ProyectoAsesor>();
        this.lstproyCodir = new ArrayList<ProyectoCodirector>();
    }

    @PostConstruct
    private void init() {

        this.limpiar();
        this.cargar_Docentes();
        this.cargar_DocentesCatedra();
        cargar_SI_docentes();
        this.cargar_DocentesByComision();

    }

    public DocenteRNLocal getDocenteRNLocal() {
        return docenteRNLocal;
    }

    public void setDocenteRNLocal(DocenteRNLocal docenteRNLocal) {
        this.docenteRNLocal = docenteRNLocal;
    }

    public DocenteCatedraRNLocal getDocenteCatedraRNLocal() {
        return docenteCatedraRNLocal;
    }

    public void setDocenteCatedraRNLocal(DocenteCatedraRNLocal docenteCatedraRNLocal) {
        this.docenteCatedraRNLocal = docenteCatedraRNLocal;
    }

    public DocenteComisionRNLocal getDocenteComisionRNLocal() {
        return docenteComisionRNLocal;
    }

    public void setDocenteComisionRNLocal(DocenteComisionRNLocal docenteComisionRNLocal) {
        this.docenteComisionRNLocal = docenteComisionRNLocal;
    }

    public List<DocenteDepartamento> getLstDocenteDepartamento() {
        return lstDocenteDepartamento;
    }

    public void setLstDocenteDepartamento(List<DocenteDepartamento> lstDocenteDepartamento) {
        this.lstDocenteDepartamento = lstDocenteDepartamento;
    }

  

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

 
    public List<SelectItem> getLstSIDocenteDepartamento() {
        return lstSIDocenteDepartamento;
    }

    public void setLstSIDocenteDepartamento(List<SelectItem> lstSIDocenteDepartamento) {
        this.lstSIDocenteDepartamento = lstSIDocenteDepartamento;
    }

    public DocenteCatedra getDocenteCatedraObj() {
        return docenteCatedraObj;
    }

    public void setDocenteCatedraObj(DocenteCatedra docenteCatedraObj) {

    }

    public DocenteDepartamento getDocenteDepartmaento() {
        return docenteDepartmaento;
    }

    public void setDocenteDepartmaento(DocenteDepartamento docenteDepartmaento) {
        this.docenteDepartmaento = docenteDepartmaento;
    }

    public List<DocenteDepartamento> getListaDocenteDepartamento() {
        return listaDocenteDepartamento;
    }

    public void setListaDocenteDepartamento(List<DocenteDepartamento> listaDocenteDepartamento) {
        this.listaDocenteDepartamento = listaDocenteDepartamento;
    }

    public List<Docente> getLstDocenteParaTribunal() {
        return lstDocenteParaTribunal;
    }

    public void setLstDocenteParaTribunal(List<Docente> lstDocenteParaTribunal) {
        this.lstDocenteParaTribunal = lstDocenteParaTribunal;
    }

    public List<SelectItem> getLstSIDocenteParaTribunal() {
        return lstSIDocenteParaTribunal;
    }

    public void setLstSIDocenteParaTribunal(List<SelectItem> lstSIDocenteParaTribunal) {
        this.lstSIDocenteParaTribunal = lstSIDocenteParaTribunal;
    }

    public List<ProyectoDirector> getLstProyDirector() {
        return lstProyDirector;
    }

    public void setLstProyDirector(List<ProyectoDirector> lstProyDirector) {
        this.lstProyDirector = lstProyDirector;
    }

    public ProyectoDirector getProyDir() {
        return proyDir;
    }

    public void setProyDir(ProyectoDirector proyDir) {
        this.proyDir = proyDir;
    }

    public ProyectoCodirector getProyCodir() {
        return proyCodir;
    }

    public void setProyCodir(ProyectoCodirector proyCodir) {
        this.proyCodir = proyCodir;
    }

    public ProyectoAsesor getProyAs() {
        return proyAs;
    }

    public void setProyAs(ProyectoAsesor proyAs) {
        this.proyAs = proyAs;
    }

    public List<ProyectoCodirector> getLstproyCodir() {
        return lstproyCodir;
    }

    public void setLstproyCodir(List<ProyectoCodirector> lstproyCodir) {
        this.lstproyCodir = lstproyCodir;
    }

    public List<ProyectoAsesor> getLstproyAs() {
        return lstproyAs;
    }

    public void setLstproyAs(List<ProyectoAsesor> lstproyAs) {
        this.lstproyAs = lstproyAs;
    }
    

    public void agregar(DocenteCatedra docenteCatedraObj) {

        System.out.println("EL DEPARTAMENTO ES:" + docenteCatedraObj.getCatedra().getCarrera().getDepartamento().getDepartamento());
        System.out.println("LA CARRERA ES:" + docenteCatedraObj.getCatedra().getCarrera().getCarrera());
        docenteDepartmaento.setDepartamento(docenteCatedraObj.getCatedra().getCarrera().getDepartamento());
        System.out.println("DOCENTE DEPARTAMENTO TIENE :::-->" + docenteDepartmaento.getDepartamento().getDepartamento());
        listaDocenteDepartamento.add(docenteDepartmaento);

        docenteCatedraObj.setDocente(docente);
        System.out.println("la materia tildada es:" + docenteCatedraObj.getCatedra().getNombre());
        listaDocCat.add(docenteCatedraObj);

        Iterator<DocenteCatedra> it = listaDocCat.iterator();

        DocenteCatedra a;
        while (it.hasNext()) {
            a = it.next();

            System.out.println("el objeto tiene como catedra " + a.getCatedra().getNombre());
        }

        limpiar3();
    }

    public void limpiar3() {
        this.docenteCatedraObj = new DocenteCatedra();
        this.docenteDepartmaento = new DocenteDepartamento();

    }

    public List<DocenteCatedra> getListaDocCat() {
        return listaDocCat;
    }

    public void setListaDocCat(List<DocenteCatedra> listaDocCat) {
        this.listaDocCat = listaDocCat;
    }

    public List<Docente> getLstDocente() {
        return lstDocente;
    }

    public void setLstDocente(List<Docente> lstDocente) {
        this.lstDocente = lstDocente;
    }

    public List<SelectItem> getLstSIDocenteActivo() {
        return lstSIDocenteActivo;
    }

    public void setLstSIDocenteActivo(List<SelectItem> lstSIDocenteActivo) {
        this.lstSIDocenteActivo = lstSIDocenteActivo;
    }

    public List<Docente> getLstDocenteActivo() {
        return lstDocenteActivo;
    }

    public void setLstDocenteActivo(List<Docente> lstDocenteActivo) {
        this.lstDocenteActivo = lstDocenteActivo;
    }

    public int getiActionBtnSelect() {
        return iActionBtnSelect;
    }

    public void setiActionBtnSelect(int iActionBtnSelect) {
        this.iActionBtnSelect = iActionBtnSelect;
    }

    public void limpiar() {
        this.lstDocente = new ArrayList<Docente>();
        this.lstDocenteByComision = new ArrayList<Docente>();
    }

    public void limpiar1() {
        this.lstDocenteDepartamento = new ArrayList<DocenteDepartamento>();

    }

    public List<SelectItem> getLstSIDocente() {
        return lstSIDocente;
    }

    public void setLstSIDocente(List<SelectItem> lstSIDocente) {
        this.lstSIDocente = lstSIDocente;
    }

    public List<Docente> getLstDocenteByComision() {
        return lstDocenteByComision;
    }

    public void setLstDocenteByComision(List<Docente> lstDocenteByComision) {
        this.lstDocenteByComision = lstDocenteByComision;
    }

    public List<SelectItem> getLstSIDocenteByComision() {
        return lstSIDocenteByComision;
    }

    public void setLstSIDocenteByComision(List<SelectItem> lstSIDocenteByComision) {
        this.lstSIDocenteByComision = lstSIDocenteByComision;
    }

    public List<Object> getLstDocenteCompleto() {
        return lstDocenteCompleto;
    }

    public void setLstDocenteCompleto(List<Object> lstDocenteCompleto) {
        this.lstDocenteCompleto = lstDocenteCompleto;
    }

    public List<DocenteCatedra> getLstDocenteCatedra() {
        return lstDocenteCatedra;
    }

    public void setLstDocenteCatedra(List<DocenteCatedra> lstDocenteCatedra) {
        this.lstDocenteCatedra = lstDocenteCatedra;
    }

    public DocenteCatedra getSelectedDocenteCatedra() {
        return selectedDocenteCatedra;
    }

    public void setSelectedDocenteCatedra(DocenteCatedra selectedDocenteCatedra) {
        System.out.println("HOLAAAAAAAAAAAAAAAAAAAAA!!!!!!!!!!!!!!!!!!!!");
        System.out.println("La catedra seleccionada es " + selectedDocenteCatedra.getCatedra().getNombre());
        this.selectedDocenteCatedra = selectedDocenteCatedra;
    }

    /**
     * Creates a new instance of ListaDocenteBean
     */
    public void cargar_Docentes() {
        try {
            this.setLstDocente(docenteRNLocal.findAll());
            System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE" + lstDocente);
        } catch (Exception ex) {
            System.out.println("Error al cargar docentes -> Causa: " + ex.getMessage());
        }
    }

    public void cargar_DocentesCatedra() {
        try {
            this.setLstDocenteCatedra(docenteCatedraRNLocal.findAll());

        } catch (Exception ex) {
            System.out.println("Error al cargar docentes -> Causa: " + ex.getMessage());
        }
    }

    public void cargar_docentes_activos() {
        try {
            this.setLstDocenteActivo(this.docenteRNLocal.findAllActivo());
        } catch (Exception ex) {
            System.out.println("Error al cargar Departamentos activos " + ex.toString());
        }
    }

    public void cargar_DocentesByComision() {
        try {

            this.setLstDocenteByComision(this.docenteComisionRNLocal.findDocentesbyComision(1L));
            System.out.println("paso por aca!");
        } catch (Exception ex) {
            System.out.println("++++++++++++++" + lstDocenteByComision);
            System.out.println("Error al cargar docentes -> Causaaaa: " + ex.getMessage());
        }
    }

    public void cargar_SI_docentes() {
        this.setLstSIDocente(new ArrayList<SelectItem>());

        for (Docente d : this.getLstDocente()) {
            SelectItem si = new SelectItem(d, d.getApellido() + ", " + d.getNombre());

            this.getLstSIDocente().add(si);
        }

    }

    public void cargar_SI_docentes_activos() {
        this.setLstSIDocenteActivo(new ArrayList<SelectItem>());

        for (Docente a : this.getLstDocenteActivo()) {
            SelectItem ai = new SelectItem(a, a.getApellido() + ", " + a.getNombre());
            this.getLstSIDocenteActivo().add(ai);
        }
    }

    public void cargar_SI_docentes_by_comision() {
        this.setLstSIDocenteByComision(new ArrayList<SelectItem>());

        for (Docente a : this.getLstDocenteByComision()) {
            SelectItem ai = new SelectItem(a, a.getApellido() + ", " + a.getNombre());
            this.getLstSIDocenteActivo().add(ai);
        }
    }

    public void recuperarCarreras(ValueChangeEvent event) {
    System.out.println("deberia de pasar " +event.getNewValue().toString()  );
        try {

            if (event.getNewValue() != null) {
                if (!"0".equals(event.getNewValue().toString())) {
                    System.out.println("");
                    Depto departamento = (Depto) event.getNewValue();

                    System.out.println("departamento; " + departamento);
                    limpiar1();
                    this.setLstDocenteDepartamento(this.docenteRNLocal.findAlldepartamento(departamento.getId()));
                    System.out.println("primera lista de docentes" + lstDocenteDepartamento);
                    this.cargar_SI_docente_departamento();

                } else {
                    this.setLstDocenteDepartamento(new ArrayList<DocenteDepartamento>());

                }

            }//fin if
        } catch (Exception ex) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error al cargar las docentes por departamentos: " + ex,
                    null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }

        //this.cargarProvincias();
    }

    public void cargar_SI_docente_departamento() {
        System.out.println("llega a cargar los docentes" + lstDocenteDepartamento);
        this.setLstSIDocenteDepartamento(new ArrayList<SelectItem>());
        for(int p=0;p< lstDocenteDepartamento.size();p++){
            Docente a = lstDocenteDepartamento.get(p).getDocente();
            System.out.println("el docente es:" + docente.getApellido());
            SelectItem ai = new SelectItem(a, a.getApellido() + "," + a.getNombre());
            this.getLstSIDocenteDepartamento().add(ai);
        }

        
    }

    public void deleteAction(DocenteCatedra actividad) {
        int i = 0;

        //System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii:____" +(actividad.getNumero()));
        Iterator<DocenteCatedra> it = listaDocCat.iterator();
        // System.out.println("el archivo es " + listaCronActiv);
        DocenteCatedra doccat;
        while (it.hasNext()) {
            doccat = it.next();

            if (doccat.getCatedra().getNombre().equals(actividad.getCatedra().getNombre())) {
                listaDocCat.remove(i);
                break;
            }

            //realiza el alta en la tabla relacional proy_alumno dependiendo de cuantos alumnos se han seleccionado
            i = i + 1;
        }

    }

public void docenteParaTribunalPropuesto(Proyecto proyecto) {
        try {
            this.setLstDocenteParaTribunal(docenteRNLocal.findAllActivo());
            
            System.out.println("La lista de docente es ::::" + lstDocenteParaTribunal);
            proyDir = proy_directorRNbeanLocal.findProyDirectorActivo(proyecto, true);
            this.lstDocente1.add(docenteRNLocal.findById(proyDir.getId()));
            lstproyCodir = proy_codirectorRNLocal.findByProyCodirector(proyecto, true);
            Iterator<ProyectoCodirector> at = lstproyCodir.iterator();
            while (at.hasNext()) {
                proyCodir = at.next();
                this.lstDocente1.add(docenteRNLocal.findById(proyCodir.getId()));
            }
            lstproyAs = proy_asesorRNLocal.findByProyAsesor(proyecto, true);
            Iterator<ProyectoAsesor> as = lstproyAs.iterator();
            while (as.hasNext()) {
                proyAs = as.next();
                this.lstDocente1.add(docenteRNLocal.findById(proyAs.getId()));
            }
            lstDocenteParaTribunal.removeAll(lstDocente1);
            cargar_SI_docentes_para_tribunal();
            
            System.out.println("La lista de docente sin los docente del proyecto es ::::" + lstDocenteParaTribunal);
        } catch (Exception ex) {
            Logger.getLogger(AceptacionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void cargar_SI_docentes_para_tribunal() {
        this.setLstSIDocenteParaTribunal(new ArrayList<SelectItem>());

        for (Docente a : this.getLstDocenteParaTribunal()) {
            SelectItem ai = new SelectItem(a, a.getApellido() + ", " + a.getNombre());
            this.getLstSIDocenteParaTribunal().add(ai);
        }
        System.out.println("El selct item de trubunal es select item" + lstSIDocenteParaTribunal);
    }
    
    
    
    
    
    public void limpiarlistadoccat() {
        this.listaDocCat = new ArrayList<DocenteCatedra>();
        this.listaDocenteDepartamento = new ArrayList<DocenteDepartamento>();
        limpiar3();

    }

}
