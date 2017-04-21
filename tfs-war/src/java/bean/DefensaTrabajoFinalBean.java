/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.AceptacionRNLocal;
import RN.DefensaFinalObservacionesRNLocal;
import RN.DefensaFinalRNLocal;
import RN.DocenteRNLocal;
import RN.NotaFinalAlumnoRNLocal;
import RN.ProyectoAlumnoRNLocal;
import RN.ProyectoDirectorRNLocal;
import RN.ProyectoRNbeanLocal;
import RN.TribunalRNLocal;
import entidad.Aceptacion;
import entidad.Alumno;
import entidad.DefensaFinalObservaciones;
import entidad.DefensaFinal;
import entidad.Docente;
import entidad.Estado;
import entidad.NotaFinalAlumno;
import entidad.ProyectoAlumno;
import entidad.ProyectoDirector;
import entidad.ProyectoTribunal;
import entidad.Proyecto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.context.RequestContext;

@ManagedBean
@RequestScoped
public class DefensaTrabajoFinalBean {

    @ManagedProperty("#{listaProyectoBean}")
    private ListaProyectoBean listaProyectoBean;
    @ManagedProperty("#{listaAlumnoBean}")
    private ListaAlumnoBean listaAlumnoBean;
    @ManagedProperty("#{navegarBean}")
    private navegarBean navegarBean;
    @ManagedProperty("#{envioMailsBean}")
    private EnvioMailsBean envioMailsBean;
    private Proyecto proyecto;
    private Aceptacion aceptacion;
    private List<ProyectoAlumno> lstProyAlumno;
    private List<ProyectoDirector> lstProyDirector;
    private Docente presidente;
    private Docente vocal1;
    private Docente vocal2;
    private Docente suplente1;
    private Docente suplente2;
    //private Tribunal tribunal;
    private List<Docente> lstDocenteTribunal;
    private DefensaFinal defensaFinal;
    private DefensaFinal defeFinal;
    private DefensaFinalObservaciones defensaFinalObs;
    private Docente docente;
    private ProyectoAlumno proyAlumno;
    private ProyectoTribunal proy_tribunal;
    private ArrayList<Docente> tribunalViejo; // aca voy a tener los id de los docentes de la comision evaluadora
    private List<Docente> tribunalNuevo; // aca voy a tener los id de los docentes que evaluaron el borrador
    private List<Docente> vectorFalso;
    private List<SelectItem> lstSIProyectoAlumno;
    private List<NotaFinalAlumno> selectedAlu;

    private Estado estado;

    private ArrayList<Boolean> tribunal;

    private boolean value1;
    private boolean value2;
    private boolean value3;
    private boolean value4;
    private boolean value5;

    private boolean valor;

    public List<NotaFinalAlumno> lstAlumnoNotas;

    public NotaFinalAlumno notaFinalAlu;

    public NotaFinalAlumno notaFinalAlu2;

    @EJB
    private ProyectoAlumnoRNLocal proy_alumnoRNbeanLocal;
    @EJB
    private ProyectoDirectorRNLocal proy_directorRNbeanLocal;
    @EJB
    private TribunalRNLocal tribunalRNbeanLocal;
    @EJB
    private AceptacionRNLocal aceptacionRNbeanLocal;
    @EJB
    private DocenteRNLocal docenteRNLocal;
    @EJB
    private DefensaFinalRNLocal defensaFinalRNbeanLocal;
    @EJB
    private DefensaFinalObservacionesRNLocal def_final_obsRNbeanLocal;
    @EJB
    private ProyectoRNbeanLocal proyectoRNbeanLocal;
    @EJB
    public NotaFinalAlumnoRNLocal notaFinalAlumnoRNLocal;

    public DefensaTrabajoFinalBean() {
        defensaFinal = new DefensaFinal();
        this.defeFinal = new DefensaFinal();
        this.defensaFinalObs = new DefensaFinalObservaciones();
        this.tribunalViejo = new ArrayList<Docente>();
        this.tribunalNuevo = new ArrayList<Docente>();
        this.tribunal = new ArrayList<Boolean>();
        this.vectorFalso = new ArrayList<Docente>();
        this.presidente = new Docente();
        this.vocal1 = new Docente();
        this.vocal2 = new Docente();
        this.suplente1 = new Docente();
        this.suplente2 = new Docente();
        this.lstAlumnoNotas = new ArrayList<NotaFinalAlumno>();
        this.notaFinalAlu = new NotaFinalAlumno();
        this.notaFinalAlu2 = new NotaFinalAlumno();
        this.proyAlumno = new ProyectoAlumno();

    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Aceptacion getAceptacion() {
        return aceptacion;
    }

    public void setAceptacion(Aceptacion aceptacion) {
        this.aceptacion = aceptacion;
    }

    public List<ProyectoAlumno> getLstProyAlumno() {
        return lstProyAlumno;
    }

    public void setLstProyAlumno(List<ProyectoAlumno> lstProyAlumno) {
        this.lstProyAlumno = lstProyAlumno;
    }

    public List<ProyectoDirector> getLstProyDirector() {
        return lstProyDirector;
    }

    public void setLstProyDirector(List<ProyectoDirector> lstProyDirector) {
        this.lstProyDirector = lstProyDirector;
    }

    public Docente getPresidente() {
        return presidente;
    }

    public void setPresidente(Docente presidente) {
        this.presidente = presidente;
    }

    public Docente getVocal1() {
        return vocal1;
    }

    public void setVocal1(Docente vocal1) {
        this.vocal1 = vocal1;
    }

    public Docente getVocal2() {
        return vocal2;
    }

    public void setVocal2(Docente vocal2) {
        this.vocal2 = vocal2;
    }

    public Docente getSuplente1() {
        return suplente1;
    }

    public void setSuplente1(Docente suplente1) {
        this.suplente1 = suplente1;
    }

    public Docente getSuplente2() {
        return suplente2;
    }

    public void setSuplente2(Docente suplente2) {
        this.suplente2 = suplente2;
    }

    public List<Docente> getLstDocenteTribunal() {
        return lstDocenteTribunal;
    }

    public void setLstDocenteTribunal(List<Docente> lstDocenteTribunal) {
        this.lstDocenteTribunal = lstDocenteTribunal;
    }

    public DefensaFinal getDefensaFinal() {
        return defensaFinal;
    }

    public void setDefensaFinal(DefensaFinal defensaFinal) {
        this.defensaFinal = defensaFinal;
    }

    public ProyectoTribunal getProy_tribunal() {
        return proy_tribunal;
    }

    public void setProy_tribunal(ProyectoTribunal proy_tribunal) {
        this.proy_tribunal = proy_tribunal;
    }

    public ArrayList<Docente> getTribunalViejo() {
        return tribunalViejo;
    }

    public void setTribunalViejo(ArrayList<Docente> tribunalViejo) {
        this.tribunalViejo = tribunalViejo;
    }

    public ArrayList<Boolean> getTribunal() {
        return tribunal;
    }

    public void setTribunal(ArrayList<Boolean> tribunal) {
        this.tribunal = tribunal;
    }

    public boolean isValue1() {
        return value1;
    }

    public void setValue1(boolean value1) {
        this.value1 = value1;
    }

    public boolean isValue2() {
        return value2;
    }

    public void setValue2(boolean value2) {
        this.value2 = value2;
    }

    public boolean isValue3() {
        return value3;
    }

    public void setValue3(boolean value3) {
        this.value3 = value3;
    }

    public boolean isValue4() {
        return value4;
    }

    public void setValue4(boolean value4) {
        this.value4 = value4;
    }

    public boolean isValue5() {
        return value5;
    }

    public void setValue5(boolean value5) {
        this.value5 = value5;
    }

    public boolean isValor() {
        return valor;
    }

    public void setValor(boolean valor) {
        this.valor = valor;
    }

    public List<Docente> getTribunalNuevo() {
        return tribunalNuevo;
    }

    public void setTribunalNuevo(List<Docente> tribunalNuevo) {
        this.tribunalNuevo = tribunalNuevo;
    }

    public ListaProyectoBean getListaProyectoBean() {
        return listaProyectoBean;
    }

    public void setListaProyectoBean(ListaProyectoBean listaProyectoBean) {
        this.listaProyectoBean = listaProyectoBean;
    }

    public DefensaFinal getDefeFinal() {
        return defeFinal;
    }

    public void setDefeFinal(DefensaFinal defeFinal) {
        this.defeFinal = defeFinal;
    }

    public DefensaFinalObservaciones getDefensaFinalObs() {
        return defensaFinalObs;
    }

    public void setDefensaFinalObs(DefensaFinalObservaciones defensaFinalObs) {
        this.defensaFinalObs = defensaFinalObs;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public List<Docente> getVectorFalso() {
        return vectorFalso;
    }

    public void setVectorFalso(List<Docente> vectorFalso) {
        this.vectorFalso = vectorFalso;
    }

    public void setNotaFinalAlu(NotaFinalAlumno notaFinalAlu) {
        this.notaFinalAlu = notaFinalAlu;
    }

    public List<SelectItem> getLstSIProyectoAlumno() {
        return lstSIProyectoAlumno;
    }

    public void setLstSIProyectoAlumno(List<SelectItem> lstSIProyectoAlumno) {
        this.lstSIProyectoAlumno = lstSIProyectoAlumno;
    }

    public navegarBean getNavegarBean() {
        return navegarBean;
    }

    public void setNavegarBean(navegarBean navegarBean) {
        this.navegarBean = navegarBean;
    }

    public ListaAlumnoBean getListaAlumnoBean() {
        return listaAlumnoBean;
    }

    public void setListaAlumnoBean(ListaAlumnoBean listaAlumnoBean) {
        this.listaAlumnoBean = listaAlumnoBean;
    }

    public ProyectoAlumno getProyAlumno() {
        return proyAlumno;
    }

    public void setProyAlumno(ProyectoAlumno proyAlumno) {
        this.proyAlumno = proyAlumno;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<NotaFinalAlumno> getLstAlumnoNotas() {
        return lstAlumnoNotas;
    }

    public void setLstAlumnoNotas(List<NotaFinalAlumno> lstAlumnoNotas) {
        this.lstAlumnoNotas = lstAlumnoNotas;
    }

    public NotaFinalAlumno getNotaFinalAlu2() {
        return notaFinalAlu2;
    }

    public void setNotaFinalAlu2(NotaFinalAlumno notaFinalAlu2) {
        this.notaFinalAlu2 = notaFinalAlu2;
    }

    public EnvioMailsBean getEnvioMailsBean() {
        return envioMailsBean;
    }

    public void setEnvioMailsBean(EnvioMailsBean envioMailsBean) {
        this.envioMailsBean = envioMailsBean;
    }

    public void limpiar() {
        defensaFinal = new DefensaFinal();
        this.defeFinal = new DefensaFinal();
        this.defensaFinalObs = new DefensaFinalObservaciones();
        this.tribunalViejo = new ArrayList<Docente>();
        this.tribunalNuevo = new ArrayList<Docente>();
        this.tribunal = new ArrayList<Boolean>();
        this.vectorFalso = new ArrayList<Docente>();
        this.presidente = new Docente();
        this.vocal1 = new Docente();
        this.vocal2 = new Docente();
        this.suplente1 = new Docente();
        this.suplente2 = new Docente();
        this.setValor(false);
        this.setValue1(false);
        this.setValue2(false);
        this.setValue3(false);
        this.setValue4(false);
        this.setValue5(false);
    }

    public void crear() throws Exception {

        this.setLstProyAlumno(proy_alumnoRNbeanLocal.findByProyAlumno(proyecto));
        if (lstProyAlumno == null) {

        } else {
            System.out.println(" else llllllllllllllaaaaaaaaaaa" + lstProyAlumno + proyecto.getId());
        }

        this.setLstProyDirector(proy_directorRNbeanLocal.findByProyDirector(proyecto));
        if (lstProyDirector == null) {
            System.out.println("h proyecto  no tiene nadallllllllllllllaaaaaaaaaa" + lstProyDirector + proyecto.getId());

        } else {
            System.out.println(" si hay un proyecto" + lstProyDirector + proyecto.getId());
        }
        setearAtributos();

        listaAlumnoBean.cargar_proyectos_alumnos_byIdProy(proyecto);

    }

    public void setearAtributos() throws Exception {

        proy_tribunal = this.tribunalRNbeanLocal.findByProy_Tribunal(proyecto, true);

        this.setLstDocenteTribunal(docenteRNLocal.findByDocenteTribunal(proy_tribunal.getTribunal().getPresidente(), proy_tribunal.getTribunal().getVocal1(), proy_tribunal.getTribunal().getVocal2(), proy_tribunal.getTribunal().getSuplente1(), proy_tribunal.getTribunal().getSuplente2()));
        // this.setLstDocenteTribunal(docenteRNLocal.findByDocenteTribunal(9, 6, 2, 4, 5)); 

        Iterator<Docente> it = lstDocenteTribunal.iterator();

        while (it.hasNext()) {
            docente = it.next();

            if (docente.getId().equals(proy_tribunal.getTribunal().getPresidente())) {

                this.setPresidente(docente);
            }
            if (docente.getId().equals(proy_tribunal.getTribunal().getVocal1())) {
                this.setVocal1(docente);
            }
            if (docente.getId().equals(proy_tribunal.getTribunal().getVocal2())) {
                this.setVocal2(docente);
            }
            if (docente.getId().equals(proy_tribunal.getTribunal().getSuplente1())) {
                this.setSuplente1(docente);
            }
            if (docente.getId().equals(proy_tribunal.getTribunal().getSuplente2())) {
                this.setSuplente2(docente);
            }

        }

        tribunalViejo.add(this.getPresidente());
        tribunalViejo.add(this.getVocal1());
        tribunalViejo.add(this.getVocal2());
        tribunalViejo.add(this.getSuplente1());
        tribunalViejo.add(this.getSuplente2());

    }

    public void setear_tribunal() {
        int i = 0;
        int j = 0;
        int k = 0;
        System.out.println("asdasd" + value1);
        System.out.println("jdjdfjdjdjdjd" + value2 + value3 + value4 + value5);
        System.out.println("asdasd" + tribunal);

        /*
         Agrego los values que se apretaron en los checkBoolean
         */
        tribunal.add(value1);
        tribunal.add(value2);
        tribunal.add(value3);
        tribunal.add(value4);
        tribunal.add(value5);

        //this.setTribunal(tribunal);
        System.out.println("aaaaaaaaaaaeee" + tribunal);

        /*
         Agrego los id de los docentes de la comision evaluadora
         */
        System.out.println("el archivo es " + tribunal.get(1));
        System.out.println("jdjdfjdjdjdjd" + tribunalViejo);

        /*
         Recorro el arrayList de los CheckBoolean (tribunal)
         */
        Iterator<Boolean> it = tribunal.iterator();
        System.out.println("el archivo es " + tribunal);

        while (it.hasNext()) {
            valor = it.next();
            System.out.println("hola" + valor + i);
            /*
             Cada vez que encuentra valor= true, es decir un checkBoolean seleccionado
             entra al if, el valor de la posicion i de tribunal viejo, se añade a la 
             posicion j del tribunal nuevo.
             */
            if (valor != false) {

                System.out.println("i" + valor + i);
                System.out.println("j" + valor + j);
                tribunalNuevo.add(j, tribunalViejo.get(i));
                j++;
            } else {
                System.out.println("entra al elsee ");
                vectorFalso.add(k, tribunalViejo.get(i));
                System.out.println("k" + vectorFalso.get(k) + k);
                k++;

            }
            i++;
        }

    }

    public void create() {
        String sMensaje = "";
        String sDetalle = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {

            setearAtributos();
            setear_tribunal();

            if (tribunalNuevo.size() == 5) {
                defensaFinal.setPresidente(tribunalNuevo.get(0).getId()); //presidente
                defensaFinal.setVocal1(tribunalNuevo.get(1).getId()); // vocal1
                defensaFinal.setVocal2(tribunalNuevo.get(2).getId()); // vocal2
                defensaFinal.setSuplente1(tribunalNuevo.get(3).getId());
                defensaFinal.setSuplente2(tribunalNuevo.get(4).getId());
            }

            if (tribunalNuevo.size() == 4) {
                defensaFinal.setPresidente(tribunalNuevo.get(0).getId()); //presidente
                defensaFinal.setVocal1(tribunalNuevo.get(1).getId()); // vocal1
                defensaFinal.setVocal2(tribunalNuevo.get(2).getId()); // vocal2
                defensaFinal.setSuplente1(tribunalNuevo.get(3).getId());
                defensaFinal.setSuplente2(vectorFalso.get(0).getId());
            }

            if (tribunalNuevo.size() == 3) {
                defensaFinal.setPresidente(tribunalNuevo.get(0).getId()); //presidente
                defensaFinal.setVocal1(tribunalNuevo.get(1).getId()); // vocal1
                defensaFinal.setVocal2(tribunalNuevo.get(2).getId()); // vocal2
                defensaFinal.setSuplente1(vectorFalso.get(0).getId());
                defensaFinal.setSuplente2(vectorFalso.get(1).getId());
            }

            defensaFinal.setTribunal(proy_tribunal.getTribunal());
            defensaFinal.setProyecto(proyecto);

            defensaFinalRNbeanLocal.create(defensaFinal);
            System.out.println("el objeto defensa final es " + defensaFinal);
            //cargando datos correspondientes a la clase aceptacion_obs
            defeFinal = this.defensaFinalRNbeanLocal.findByDefensa(proyecto, proy_tribunal.getTribunal());
            System.out.println("el objeto aceptacion es.............." + defeFinal);
            defensaFinalObs.setFecha(defeFinal.getFecha());
            defensaFinalObs.setDefensa_final(defeFinal);
            def_final_obsRNbeanLocal.create(defensaFinalObs);

            System.out.println("el objeto defensa  es " + defeFinal);

            /*
             ------------ Setear notas ---------------
             */
            Iterator<NotaFinalAlumno> it = listaAlumnoBean.getLstAlumnoNotas2().iterator();

            while (it.hasNext()) {
                notaFinalAlu2 = it.next();

                this.notaFinalAlu2.setDefensa_final(defeFinal);
                this.notaFinalAlumnoRNLocal.create(notaFinalAlu2);

            }

            /*
             --------- Fin seteo de notas -------------
             */
            estado = proyectoRNbeanLocal.findByEstado(15);
            System.out.println("El estado esw:" + estado.getEstado());
            proyecto.setEstado(estado);
            proyectoRNbeanLocal.edit(proyecto);
            sDetalle = "El estado del proyecto es ahora : " + estado.getEstado();

            sMensaje = "Defensa final fue guardado exitosamente";
            severity = FacesMessage.SEVERITY_INFO;

            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgDefensaFinal').hide();");
            this.limpiar();
            navegarBean.entrarFormDefensaFinal();

          this.envioMailsBean.ReporteCambioDeEstado(proyecto);
            listaAlumnoBean.limpiar();
            // this.limpiar();
        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error en defensa final de proyecto: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, sDetalle);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }

    public void cargar_SI_proyecto_alumno() {
        this.setLstSIProyectoAlumno(new ArrayList<SelectItem>());

        for (ProyectoAlumno b : this.getLstProyAlumno()) {
            SelectItem vi = new SelectItem(b, b.getAlumno().getApellido() + "," + b.getAlumno().getNombre());
            this.getLstSIProyectoAlumno().add(vi);
        }

    }
}
