/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DAO.DocenteFacadeLocal;
import RN.DocenteCatedraRNLocal;
import RN.DocenteComisionRNLocal;
import RN.DocenteDepartamentoRNLocal;
import RN.DocenteRNLocal;
import entidad.Carrera;
import entidad.Catedra;
import entidad.Docente;
import entidad.DocenteCatedra;
import entidad.DocenteComision;
import entidad.DocenteDepartamento;
import entidad.tipoUsuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.iterator;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.context.RequestContext;
import recursos.Encriptacion;

/**
 *
 * @author cristian
 */
@ManagedBean
@RequestScoped
public class DocenteBean {

    @ManagedProperty("#{listaDocenteBean}")
    private ListaDocenteBean listaDocenteBean;

    private Docente docente;
    private Docente d;
    private Encriptacion encript = new Encriptacion();
    private DocenteComision docente_comision;
    private DocenteCatedra docente_catedra;
     private DocenteDepartamento docente_departamento;
    private DocenteComision doc_comi;
    private List<Catedra> lstcatedra;
    @EJB
    private DocenteComisionRNLocal docente_comisionRNbeanLocal;
    @EJB
    private DocenteCatedraRNLocal docente_catedraRNbeanLocal;
    @EJB
    private DocenteRNLocal DocenteRNLocal;
    @EJB
    private DocenteFacadeLocal docenteFacadeLocal;
     @EJB
    private DocenteDepartamentoRNLocal docenteDepartamentoRNLocal;
    private CommandButton cbAction;
    private Boolean bCamposEditables;
    private Boolean bCampoPassword;

    private Catedra selectedCatedra;
    private Carrera selectedCarrera;

    /**
     * Creates a new instance of CarreraBean
     */
    public DocenteBean() {
        this.docente = new Docente();
        this.docente_comision = new DocenteComision();
        this.docente_catedra = new DocenteCatedra();
        this.docente_departamento = new DocenteDepartamento();
        this.lstcatedra = new ArrayList<Catedra>();
    }

    public ListaDocenteBean getListaDocenteBean() {
        return listaDocenteBean;
    }

    public void setListaDocenteBean(ListaDocenteBean listaDocenteBean) {
        this.listaDocenteBean = listaDocenteBean;
    }

    public CommandButton getCbAction() {
        return cbAction;
    }

    public Encriptacion getEncript() {
        return encript;
    }

    public void setEncript(Encriptacion encript) {
        this.encript = encript;
    }

    public void setCbAction(CommandButton cbAction) {
        this.cbAction = cbAction;
    }

    public Docente getD() {
        return d;
    }

    public void setD(Docente d) {
        this.d = d;
    }

    public DocenteComision getDoc_comi() {
        return doc_comi;
    }

    public void setDoc_comi(DocenteComision doc_comi) {
        this.doc_comi = doc_comi;
    }

    public DocenteComisionRNLocal getDocente_comisionRNbeanLocal() {
        return docente_comisionRNbeanLocal;
    }

    public void setDocente_comisionRNbeanLocal(DocenteComisionRNLocal docente_comisionRNbeanLocal) {
        this.docente_comisionRNbeanLocal = docente_comisionRNbeanLocal;
    }

    public DocenteRNLocal getDocenteRNLocal() {
        return DocenteRNLocal;
    }

    public void setDocenteRNLocal(DocenteRNLocal DocenteRNLocal) {
        this.DocenteRNLocal = DocenteRNLocal;
    }

    public Boolean isbCamposEditables() {
        return bCamposEditables;
    }

    public Boolean getbCamposEditables() {
        return bCamposEditables;
    }

    public Boolean getbCampoPassword() {
        return bCampoPassword;
    }

    public void setbCampoPassword(Boolean bCampoPassword) {
        this.bCampoPassword = bCampoPassword;
    }

    public List<Catedra> getLstcatedra() {
        return lstcatedra;
    }

    public void setLstcatedra(List<Catedra> lstcatedra) {
        this.lstcatedra = lstcatedra;
    }

    public void setbCamposEditables(Boolean bCamposEditables) {
        this.bCamposEditables = bCamposEditables;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public DocenteComision getDocente_comision() {
        return docente_comision;
    }

    public void setDocente_comision(DocenteComision docente_comision) {
        this.docente_comision = docente_comision;
    }

    public DocenteCatedra getDocente_catedra() {
        return docente_catedra;
    }

    public void setDocente_catedra(DocenteCatedra docente_catedra) {
        this.docente_catedra = docente_catedra;
    }

    public Catedra getSelectedCatedra() {
        return selectedCatedra;
    }

    public void setSelectedCatedra(Catedra selectedCatedra) {
        System.out.println("selected" + selectedCatedra.getNombre());

        this.selectedCatedra = selectedCatedra;
    }

    public DocenteDepartamento getDocente_departamento() {
        return docente_departamento;
    }

    public void setDocente_departamento(DocenteDepartamento docente_departamento) {
        this.docente_departamento = docente_departamento;
    }

    public DocenteCatedraRNLocal getDocente_catedraRNbeanLocal() {
        return docente_catedraRNbeanLocal;
    }

    public void setDocente_catedraRNbeanLocal(DocenteCatedraRNLocal docente_catedraRNbeanLocal) {
        this.docente_catedraRNbeanLocal = docente_catedraRNbeanLocal;
    }

    public DocenteFacadeLocal getDocenteFacadeLocal() {
        return docenteFacadeLocal;
    }

    public void setDocenteFacadeLocal(DocenteFacadeLocal docenteFacadeLocal) {
        this.docenteFacadeLocal = docenteFacadeLocal;
    }

    public Carrera getSelectedCarrera() {
        return selectedCarrera;
    }

    public void setSelectedCarrera(Carrera selectedCarrera) {
        this.selectedCarrera = selectedCarrera;
    }
    
    

    public void create() {
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {

            docente.setActive(Boolean.TRUE);

            docente.setTipousuario(tipoUsuario.DOCENTE);
            docente.setUsername(this.docente.getCuil());

            docente.setDni(Integer.parseInt(this.docente.getCuil().substring(3, 11)));
            System.out.println("::::::::::el DNI es ---> " + docente.getDni());
            String encriptMD5Alu = encript.hash(docente.getPassword());
            docente.setPassword(encriptMD5Alu);

            d = new Docente();
            DocenteRNLocal.create(docente);

            d = DocenteRNLocal.findByDocente(docente.getCuil());
           
            
            docente_comision.setDocente(d);
            docente_comisionRNbeanLocal.create(docente_comision);

            Iterator<Catedra> it = lstcatedra.iterator();

        //System.out.println("el codigo del proyecto es " + proy_ases.getProyecto().getTitulo());
            Iterator<DocenteCatedra> iterat = listaDocenteBean.getListaDocCat().iterator();
            
            while (iterat.hasNext()) {
                docente_catedra = iterat.next();
                docente_catedra.setDocente(d);
              
                docente_catedraRNbeanLocal.create(docente_catedra);
               

            }

               Iterator<DocenteDepartamento> ite = listaDocenteBean.getListaDocenteDepartamento().iterator();
            System.out.println("POR HACER EL CREATE EN DOCENTEDEPARTAMENTO");
            while (ite.hasNext()) {
                docente_departamento = ite.next();
                 System.out.println("estensiooon tiene:::>>>" + docente_departamento.getExtension());
                docente_departamento.setDocente(d);
              
                docenteDepartamentoRNLocal.create(docente_departamento);
               
                System.out.println("HACIENDO create EN DOCENTEDEPARTAMENTO");
            }
            
            
            sMensaje = "Docente guardado exitosamente";
            severity = FacesMessage.SEVERITY_INFO;
            this.getCbAction().setDisabled(true);

            //agregar a la lista
            this.getListaDocenteBean().getLstDocente().add(docente);

            //limpiar campos
            this.limpiar();
            listaDocenteBean.limpiarlistadoccat();

            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgDocente').hide();");
            

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, "");
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }// fin crear

    private void limpiar() {
        this.docente = new Docente();
    }

    public void setBtnSelect(ActionEvent e) {
        CommandButton btnSelect = (CommandButton) e.getSource();
        System.out.println("boton select: " + btnSelect.getId());
    //0 crea
        //1: edit
        //2 delete

        //activo el boton
        this.getCbAction().setDisabled(false);

        if (btnSelect.getId().equals("cbCreate") || btnSelect.getId().equals("cbNuevoUsers")) {
            this.getListaDocenteBean().setiActionBtnSelect(0);
            System.out.println("he si estoy aca" + this.getListaDocenteBean().getiActionBtnSelect());

            this.getCbAction().setValue("Guardar");
            //campos requeridos
            //this.setbCamposRequeridos(true);

        } else if (btnSelect.getId().equals("cbEdit")) {
            this.getCbAction().setValue("Modificar");
            this.setbCampoPassword(true);
            this.getListaDocenteBean().setiActionBtnSelect(1);

            //campos requeridos
            //this.setbCamposRequeridos(true);
        } else if (btnSelect.getId().equals("cbDeshabilitado")) {
            this.getListaDocenteBean().setiActionBtnSelect(2);

            this.setbCamposEditables(true);
            this.getCbAction().setValue("Desactivar");

        } else if (btnSelect.getId().equals("cbHabilitado")) {

            this.getListaDocenteBean().setiActionBtnSelect(3);
            this.setbCamposEditables(true);
            this.getCbAction().setValue("Reactivar");

        }

        //fin else
    }

    public void actionBtn() {
        //System.out.println("he si estoy aca" + this.getListaUsersBean().getiActionBtnSelect());
        switch (this.getListaDocenteBean().getiActionBtnSelect()) {
            case 0:
                create();
                //limíar campos
                //this.limpiar();
                break;
            case 1:
                this.edit();
                break;
            case 2:
                //deshabilita el campo
                this.activate(Boolean.FALSE);
                break;
            case 3:
                //habilita el campo
                this.activate(Boolean.TRUE);
                break;

        }//fin switch
    }

    public void edit() {
        System.out.println("Entro al edit");
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {
            //get la fila seleccionada 

            docente.setActive(Boolean.TRUE);

            docente.setTipousuario(tipoUsuario.DOCENTE);
            docente.setUsername(this.docente.getCuil());

            docente.setDni(Integer.parseInt(this.docente.getCuil().substring(3, 11)));

            DocenteRNLocal.edit(this.getDocente());
            docente_comision.setDocente(this.getDocente());
            doc_comi = docente_comisionRNbeanLocal.findByDocente(this.getDocente_comision());

            //aluCar = alumnoCarreraRNbeanLocal.findByAlumnoCarrera(this.getAlumno().getId(),alumnoCarrera.getCarrera().getId());
            docente_comision.setDocente(docente);
            docente_comision.setId(doc_comi.getId());

            docente_comisionRNbeanLocal.edit(docente_comision);

            sMensaje = "Información actualizada con éxito";
            severity = FacesMessage.SEVERITY_INFO;

            //elimino y agrego el organismo modificado a la lista
            int iPos = this.getListaDocenteBean().getLstDocente().indexOf(this.getDocente());

            this.getListaDocenteBean().getLstDocente().remove(iPos);
            this.getListaDocenteBean().getLstDocente().add(iPos, this.getDocente());

            this.getCbAction().setValue("Modificar");
            this.getCbAction().setDisabled(true);

            //this.setbCamposRequeridos(false);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgDocente').hide();");

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al actualizar:" + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, "");
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }

    public void activate(Boolean bEstado) {
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;

        try {

            DocenteRNLocal.activate(this.getDocente(), bEstado);
            //elimino el organismo de la lista

            int iPos = this.getListaDocenteBean().getLstDocente().indexOf(this.getDocente());

            this.setDocente(this.getListaDocenteBean().getLstDocente().get(iPos));
            this.getDocente().setActive(bEstado);

            this.getListaDocenteBean().getLstDocente().remove(iPos);
            this.getListaDocenteBean().getLstDocente().add(iPos, this.getDocente());

            if (!bEstado) {
                sMensaje = "Docente deshabilitado correctamente";
            } else {
                sMensaje = "Docente habilitado correctamente ";
            }
            severity = FacesMessage.SEVERITY_INFO;

            this.getCbAction().setDisabled(true);

            //limíar campos
            this.clear();
            //this.setbCamposRequeridos(false);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgDocente').hide();");

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "ERROR DURANTE LA OPERACION: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }

    private void clear() {
        this.setDocente(new Docente());

    }

    public void buttonAction(ActionEvent actionEvent) {
        System.out.println("entroooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
        addMessage("Welcome to CATEDRAS!!");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String seleccionar_operacion() throws Exception {

        System.out.println("HOLAAA  entrooooooooooooooooooooooooooooooooooooooooooooooooooo");
        return ("catedras.xhtml?faces-redirect=true");

    }

}
