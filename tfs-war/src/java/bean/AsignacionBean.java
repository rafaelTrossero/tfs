/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.AceptacionRNLocal;
import RN.DocenteRNLocal;
import RN.ProyectoAlumnoRNLocal;
import RN.ProyectoDirectorRNLocal;
import RN.ProyectoTribunalRNLocal;
import RN.ProyectoRNbeanLocal;
import RN.TribunalRNLocal;
import entidad.Aceptacion;
import entidad.Docente;
import entidad.Estado;
import entidad.Profesional;
import entidad.ProyectoAlumno;
import entidad.ProyectoDirector;
import entidad.ProyectoTribunal;
import entidad.Proyecto;
import entidad.Tribunal;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author WalterVergara
 */
@ManagedBean
@RequestScoped
public class AsignacionBean {

    @ManagedProperty("#{listaProyectoBean}")
    private ListaProyectoBean listaProyectoBean;
    @ManagedProperty("#{navegarBean}")
    private navegarBean navegarBean;
    @ManagedProperty("#{fileUploadController}")
    private FileUploadController fileUploadController;
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
    private Tribunal tribunal;
    private List<Docente> lstDocenteTribunal;
    private Tribunal resulTribunal;
    private Estado estado;

   
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
    private ProyectoTribunalRNLocal proy_tribunalRNbeanLocal;
    @EJB
    private ProyectoRNbeanLocal proyectoRNbeanLocal;

    private Docente Docente;
    private Docente docente;
    private ProyectoTribunal proy_tribunal;

    public AsignacionBean() {
        tribunal = new Tribunal();
        this.proy_tribunal = new ProyectoTribunal();
    }

    public List<Docente> getLstDocenteTribunal() {
        return lstDocenteTribunal;
    }

    public void setLstDocenteTribunal(List<Docente> lstDocenteTribunal) {
        this.lstDocenteTribunal = lstDocenteTribunal;
    }

    public ListaProyectoBean getListaProyectoBean() {
        return listaProyectoBean;
    }

    public void setListaProyectoBean(ListaProyectoBean listaProyectoBean) {
        this.listaProyectoBean = listaProyectoBean;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public navegarBean getNavegarBean() {
        return navegarBean;
    }

    public void setNavegarBean(navegarBean navegarBean) {
        this.navegarBean = navegarBean;
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

    public Tribunal getTribunal() {
        return tribunal;
    }

    public void setTribunal(Tribunal tribunal) {
        this.tribunal = tribunal;
    }

    public ProyectoTribunal getProy_tribunal() {
        return proy_tribunal;
    }

    public void setProy_tribunal(ProyectoTribunal proy_tribunal) {
        this.proy_tribunal = proy_tribunal;
    }

    public Tribunal getResulTribunal() {
        return resulTribunal;
    }

    public void setResulTribunal(Tribunal resulTribunal) {
        this.resulTribunal = resulTribunal;
    }

    public FileUploadController getFileUploadController() {
        return fileUploadController;
    }

    public void setFileUploadController(FileUploadController fileUploadController) {
        this.fileUploadController = fileUploadController;
    }

    public EnvioMailsBean getEnvioMailsBean() {
        return envioMailsBean;
    }

    public void setEnvioMailsBean(EnvioMailsBean envioMailsBean) {
        this.envioMailsBean = envioMailsBean;
    }
    
      public void limpiar() {
        this.presidente = new Docente();
        this.vocal1 = new Docente();
        this.vocal2 = new Docente();
        this.suplente1 = new Docente();
        this.suplente2 = new Docente();
        this.aceptacion = new Aceptacion();
        tribunal = new Tribunal();
        this.proy_tribunal = new ProyectoTribunal();

    }
    public void crear() throws Exception {

        System.out.println("hoooooooooooooooooooooooooooooooooooooooooooooollllllllllllllaaaaaaaaaaa");
        this.setLstProyAlumno(proy_alumnoRNbeanLocal.findByProyAlumno(proyecto));
        if (lstProyAlumno == null) {
            System.out.println("hoooooooooooooooooooooooooooooooooooooooooooooollllllllllllllaaaaaaaaaaa" + lstProyAlumno + proyecto.getId());

        } else {
            System.out.println(" else llllllllllllllaaaaaaaaaaa" + lstProyAlumno + proyecto.getId());
        }

        System.out.println("ahora para el proyecto");
        this.setLstProyDirector(proy_directorRNbeanLocal.findByProyDirector(proyecto));
        if (lstProyDirector == null) {
            System.out.println("h proyecto  no tiene nadallllllllllllllaaaaaaaaaaa" + lstProyDirector + proyecto.getId());

        } else {
            System.out.println("SI HAY UN PROTECTO" + lstProyDirector + proyecto.getId());
        }

        //conaulta devuelve el registro de aceptacion que pertenece al proyecto enviado y aemas cuya calificacion sea "aprobado"
        this.setAceptacion(aceptacionRNbeanLocal.findByProyAceptacion(proyecto, 1));
        if(aceptacion == null){
             this.setAceptacion(aceptacionRNbeanLocal.findByProyAceptacion(proyecto, 2));
        }

        System.out.println(" calificacion y proyecto " + aceptacion.getCalificacion() + aceptacion.getProyecto().getId() + aceptacion.getPresidente() + aceptacion.getVocal1() + aceptacion.getVocal2() + aceptacion.getSuplente1() + aceptacion.getSuplente2());
        //consulta devuelve los docentes que pertenecen al tribunal propuestop que se da en aceptacion del proyecto
        this.setLstDocenteTribunal(docenteRNLocal.findByDocenteTribunal(aceptacion.getPresidente(), aceptacion.getVocal1(), aceptacion.getVocal2(), aceptacion.getSuplente1(), aceptacion.getSuplente2()));
        // this.setLstDocenteTribunal(docenteRNLocal.findByDocenteTribunal(9, 6, 2, 4, 5)); 

        System.out.println(" lista docente tribunal " + lstDocenteTribunal);

        Iterator<Docente> it = lstDocenteTribunal.iterator();

        while (it.hasNext()) {
            docente = it.next();

            if (docente.getId().equals(aceptacion.getPresidente())) {
                System.out.println("pqpqpqpqppq" + docente.getId() + "asas" + aceptacion.getPresidente());
                this.setPresidente(docente);
            }
            if (docente.getId().equals(aceptacion.getVocal1())) {
                this.setVocal1(docente);
            }
            if (docente.getId().equals(aceptacion.getVocal2())) {
                this.setVocal2(docente);
            }
            if (docente.getId().equals(aceptacion.getSuplente1())) {
                this.setSuplente1(docente);
            }
            if (docente.getId().equals(aceptacion.getSuplente2())) {
                this.setSuplente2(docente);
            }

        }

    }

    public void create() {
        String sDetalle = "";
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {
            System.out.println("el docente seleccionado es " + presidente);
            System.out.println("si pasa x aca chango");
            System.out.println("si pasa x aca chango" + proyecto.getTitulo());

            tribunal.setPresidente(presidente.getId());

            tribunal.setVocal1(vocal1.getId());
            tribunal.setVocal2(vocal2.getId());
            tribunal.setSuplente1(suplente1.getId());
            tribunal.setSuplente2(suplente2.getId());
            
            tribunal.setRuta(fileUploadController.destino);

            tribunalRNbeanLocal.create(tribunal, proyecto);
            
            estado = proyectoRNbeanLocal.findByEstado(4);
            System.out.println("El estado esw:" + estado.getEstado());
            proyecto.setEstado(estado);
            System.out.println("hasta aca nomaaooooooojojojoojojojo :(" + proyecto.getEstado().getEstado());
            proyectoRNbeanLocal.edit(proyecto);
            
            resulTribunal = this.tribunalRNbeanLocal.findByTribunal(tribunal.getResolucion(), tribunal.getPresidente(), tribunal.getVocal1(), tribunal.getVocal2(), tribunal.getSuplente1(), tribunal.getSuplente2());
            System.out.println("hasta aca a llegaooooooooooo el codigo del tribunal es:::::::::" + resulTribunal);
            this.proy_tribunal.setTribunal(resulTribunal);
            this.proy_tribunal.setProyecto(proyecto);
            this.proy_tribunal.setActive(Boolean.TRUE);

            proy_tribunalRNbeanLocal.create(proy_tribunal);
            System.out.println("hasta aca tambien");
             sDetalle="El estado del proyecto es ahora : "+estado.getEstado();
             
             this.envioMailsBean.ReporteCambioDeEstado(proyecto);
             
            sMensaje = "tribunal fue guardado exitosamente";
            severity = FacesMessage.SEVERITY_INFO;
            
             navegarBean.entrarFormAsiganacionComisionEvaluadora();
             
             limpiar();
             RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgAsigComision').hide();");
            //agregar a la lista
            //limpiar campos
            // this.limpiar();
        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al crear tribunal de proyecto: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, sDetalle);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }

}
