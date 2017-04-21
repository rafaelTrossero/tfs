/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.PresentacionRNLocal;
import RN.ProyectoAlumnoRNLocal;
import RN.ProyectoDirectorRNLocal;
import RN.ProyectoRNbeanLocal;
import entidad.Docente;
import entidad.Estado;
import entidad.Presentacion;
import entidad.ProyectoAlumno;
import entidad.ProyectoDirector;
import entidad.Proyecto;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.context.RequestContext;


/**
 *
 * @author Trossero
 */
@ManagedBean
@RequestScoped
public class PresentacionBean {
    
    @ManagedProperty("#{listaProyectoBean}")
    private ListaProyectoBean listaProyectoBean;
    @ManagedProperty("#{envioMailsBean}")
    private EnvioMailsBean envioMailsBean;
     @ManagedProperty("#{navegarBean}")
    private navegarBean navegarBean;
     @ManagedProperty("#{fileUploadController}")
    private FileUploadController fileUploadController;

    private Presentacion presentacion;
    private Proyecto proyecto;
    private Date fechaNewPresentacion;
  

    @EJB
    private PresentacionRNLocal presentacionRNbeanLocal;
    @EJB
    private ProyectoRNbeanLocal proyectoRNbeanLocal;
    
    private Estado estado;
    private boolean notaDirector;
    private boolean notaCodirector;
    private boolean notaAceptacion;
    private boolean certificadoRegular;
    public Integer i;
   
    

    private CommandButton cbAction;
    
      private List<ProyectoAlumno> lstProyAlumno;
    private List<ProyectoDirector> lstProyDirector;
  

    @EJB
    private ProyectoAlumnoRNLocal proy_alumnoRNbeanLocal;
    @EJB
    private ProyectoDirectorRNLocal proy_directorRNbeanLocal;
   
    
    public PresentacionBean() {
        this.presentacion = new Presentacion();
    }

    public Presentacion getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Presentacion presentacion) {
        this.presentacion = presentacion;
    }

    public Date getFechaNewPresentacion() {
        return fechaNewPresentacion;
    }

    public void setFechaNewPresentacion(Date fechaNewPresentacion) {
        this.fechaNewPresentacion = fechaNewPresentacion;
    }

    public boolean isNotaDirector() {
        return notaDirector;
    }

    public void setNotaDirector(boolean notaDirector) {
        this.notaDirector = notaDirector;
    }

    public boolean isNotaCodirector() {
        return notaCodirector;
    }

    public void setNotaCodirector(boolean notaCodirector) {
        this.notaCodirector = notaCodirector;
    }

    public boolean isNotaAceptacion() {
        return notaAceptacion;
    }

    public void setNotaAceptacion(boolean notaAceptacion) {
        this.notaAceptacion = notaAceptacion;
    }

    public boolean isCertificadoRegular() {
        return certificadoRegular;
    }

    public void setCertificadoRegular(boolean certificadoRegular) {
        this.certificadoRegular = certificadoRegular;
    }

   
    public CommandButton getCbAction() {
        return cbAction;
    }

    public void setCbAction(CommandButton cbAction) {
        this.cbAction = cbAction;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
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

    public ListaProyectoBean getListaProyectoBean() {
        return listaProyectoBean;
    }

    public void setListaProyectoBean(ListaProyectoBean listaProyectoBean) {
        this.listaProyectoBean = listaProyectoBean;
    }

    public EnvioMailsBean getEnvioMailsBean() {
        return envioMailsBean;
    }

    public void setEnvioMailsBean(EnvioMailsBean envioMailsBean) {
        this.envioMailsBean = envioMailsBean;
    }

    public navegarBean getNavegarBean() {
        return navegarBean;
    }

    public void setNavegarBean(navegarBean navegarBean) {
        this.navegarBean = navegarBean;
    }

    public FileUploadController getFileUploadController() {
        return fileUploadController;
    }

    public void setFileUploadController(FileUploadController fileUploadController) {
        this.fileUploadController = fileUploadController;
    }
    
    
    
    public void crear() throws Exception {

        System.out.println("hoooooooooooooooooooooooooooooooooooooooooooooollllllllllllllaaaaaaaaaaa" +proyecto.getEstado().getId());
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
            System.out.println(" si hay un proyecto" + lstProyDirector + proyecto.getId());
        }
    }
    
     public void create() {
        String sMensaje = "";
          String sDetalle = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {
            
            presentacion = new Presentacion();
            System.out.println("aa--------.------->>>>>>>>"+proyecto.getEstado().getId());
            presentacion.setProyecto(this.proyecto);
            Long id_estado = presentacion.getProyecto().getEstado().getId();
             presentacion.setRuta(fileUploadController.destino);
            System.out.println("holaaaaaaaaaaaaaaaa" + presentacion.getProyecto().getEstado().getId());
            System.out.println("holaaaaaaaaaaaaaaaa" + this.notaDirector);
            System.out.println("holaaaaaaaaaaaaaaaa" + this.notaCodirector);
             System.out.println("holeeeeeeeeeeeeeee" + this.certificadoRegular);
              System.out.println("holiiiiiiiiiiiiiii" + this.notaAceptacion);
            System.out.println("holuuuuuuuuuuuuuuuuuuuuuuu" + id_estado);
          
                  
           
             /* ----------------------------------------------------------
             Para la Nueva presentacion de Proyectos
             ----------------------------------------------------------------*/
            
            // si se cumplen con todos los requisitos el proyecto se da de alta con estado(en proceso de aceptacion de proyecto)
            if (this.notaDirector == true && this.notaCodirector == true && this.certificadoRegular == true && this.notaAceptacion == true) {
                System.out.println("pasaasasasasasasassa" + notaDirector + notaAceptacion + certificadoRegular);
                System.out.println("SI CUMPLE TODOS LOS REQUI" + notaDirector + notaAceptacion + certificadoRegular);
                //consulta me devuelve el registro del estado igual a 1 "en proceso de aceptacion de proyecto"
                estado = proyectoRNbeanLocal.findByEstado(1);
                System.out.println("El estado esw:" + estado.getEstado());
                proyecto.setEstado(estado);
                System.out.println("hasta aca nomaaa :(");
                //Realiza el alta de la presentacion
                proyectoRNbeanLocal.edit(proyecto);
                              
                presentacion.setProyecto(this.proyecto);
                System.out.println("El ESTADO ESSS " + proyecto.getEstado().getEstado());
                presentacion.setCertificados(this.certificadoRegular);
                presentacion.setNota_aprobacion(this.notaAceptacion);
                presentacion.setNota_director(this.notaDirector);
                presentacion.setNota_codirector(this.notaCodirector);
                System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
                System.out.println("LA FECHA QE TIENE fechaNewPresentacion ES :::::::::::::>>>>>>>>" + this.fechaNewPresentacion);
                presentacion.setFecha(fechaNewPresentacion);
              

                presentacionRNbeanLocal.create(presentacion);
                System.out.println("hasta aca nomaaooooooojojojoojojojo :(" + proyecto.getEstado().getEstado());
                
                System.out.println("hasta acaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + presentacion.getFecha());
                 sDetalle="El estado del proyecto es ahora : "+estado.getEstado();
                 this.envioMailsBean.ReporteCambioDeEstado(proyecto);
                 /*****/
            }
             // si NO se cumplen con todos los requisitos el proyecto se da de alta con estado(se requiere una nueva presentacion de proyecto)

            if (((this.notaDirector == false && this.notaCodirector == false)  && this.certificadoRegular == false || this.notaAceptacion == false) && presentacion.getProyecto().getEstado().getId().equals(3L)) {
                System.out.println(" segundo if" + notaDirector);
                //consulta me devuelve el registro del estado igual a 3
                estado = proyectoRNbeanLocal.findByEstado(3);
                System.out.println("El estado eeeS:" + estado.getEstado());
                proyecto.setEstado(estado);
                System.out.println("hasta aca nomaaa :(");
                //Realiza el alta de la presentacion
                proyectoRNbeanLocal.edit(proyecto);
                
                presentacion.setProyecto(this.proyecto);
                System.out.println("hasta aca nomaaa :(" + proyecto);
                presentacion.setCertificados(this.certificadoRegular);
                presentacion.setNota_aprobacion(this.notaAceptacion);
                presentacion.setNota_director(this.notaDirector);
                presentacion.setNota_codirector(this.notaCodirector);
                presentacion.setFecha(fechaNewPresentacion);
                
                presentacionRNbeanLocal.create(presentacion);
                System.out.println("hasta aca nomaaooooooojojojoojojojo :(" + proyecto.getEstado().getEstado());
                
                System.out.println("hasta auuuuuuuuuuuuuuuuuuuuuuuuuu" + presentacion.getFecha());
                 sDetalle="El estado del proyecto es ahora : "+estado.getEstado();
                 this.envioMailsBean.ReporteCambioDeEstado(proyecto);
            }
            if ((this.notaDirector == false && this.notaCodirector == false)  && this.certificadoRegular == true && this.notaAceptacion == true && presentacion.getProyecto().getEstado().getId().equals(3L)) {
                System.out.println(" tercer if" + notaDirector);
                //consulta me devuelve el registro del estado igual a 3
                estado = proyectoRNbeanLocal.findByEstado(3);
                System.out.println("El estado eeeS:" + estado.getEstado());
                proyecto.setEstado(estado);
                System.out.println("hasta aca nomaaa :(");
                //Realiza el alta de la presentacion
                proyectoRNbeanLocal.edit(proyecto);
                
                presentacion.setProyecto(this.proyecto);
                System.out.println("hasta aca nomaaa :(" + proyecto);
                presentacion.setCertificados(this.certificadoRegular);
                presentacion.setNota_aprobacion(this.notaAceptacion);
                presentacion.setNota_director(this.notaDirector);
                presentacion.setNota_codirector(this.notaCodirector);
                presentacion.setFecha(fechaNewPresentacion);

                presentacionRNbeanLocal.create(presentacion);
                System.out.println("hasta aca nomaaooooooojojojoojojojo :(" + proyecto.getEstado().getEstado());
                
                System.out.println("hasta auuuuuuuuuuuuuuuuuuuuuuuuuu" + presentacion.getFecha());
                 sDetalle="El estado del proyecto es ahora : "+estado.getEstado();
                 this.envioMailsBean.ReporteCambioDeEstado(proyecto);
            }
             if (((this.notaDirector == true || this.notaCodirector == true)  && this.certificadoRegular == true && this.notaAceptacion == true) && presentacion.getProyecto().getEstado().getId().equals(3L)) {
                System.out.println("cuarto if" + notaDirector);
                //consulta me devuelve el registro del estado igual a 3
                estado = proyectoRNbeanLocal.findByEstado(1);
                System.out.println("El estado eeeS:" + estado.getEstado());
                proyecto.setEstado(estado);
                System.out.println("hasta aca nomaaa :(");
                //Realiza el alta de la presentacion
                proyectoRNbeanLocal.edit(proyecto);
                
                presentacion.setProyecto(this.proyecto);
                System.out.println("hasta aca nomaaa :(" + proyecto);
                presentacion.setCertificados(this.certificadoRegular);
                presentacion.setNota_aprobacion(this.notaAceptacion);
                presentacion.setNota_director(this.notaDirector);
                presentacion.setNota_codirector(this.notaCodirector);
                presentacion.setFecha(fechaNewPresentacion);

                presentacionRNbeanLocal.create(presentacion);
                System.out.println("hasta aca nomaaooooooojojojoojojojo :(" + proyecto.getEstado().getEstado());
                
                System.out.println("hasta auuuuuuuuuuuuuuuuuuuuuuuuuu" + presentacion.getFecha());
                 sDetalle="El estado del proyecto es ahora : "+estado.getEstado();
                 this.envioMailsBean.ReporteCambioDeEstado(proyecto);
            }
            
                      /* ----------------------------------------------------------
             Para la presentacion de modificaciones de Proyectos
             ----------------------------------------------------------------*/
            
            if (presentacion.getProyecto().getEstado().getId().equals(6L) && (this.notaDirector == true || this.notaCodirector == true)) {

                System.out.println("%%%%%%%%% PASSA PARA LAS MODIFICACIONES");
                this.certificadoRegular = true;
                this.notaAceptacion = true;
                //consulta me devuelve el registro del estado igual a 4
                estado = proyectoRNbeanLocal.findByEstado(4);
                proyecto.setEstado(estado);
                 System.out.println("El Estado ES" + proyecto.getEstado().getEstado());
                //Realiza el alta de la presentacion
                presentacion.setProyecto(this.proyecto);
             
                presentacion.setCertificados(this.certificadoRegular);
                presentacion.setNota_aprobacion(this.notaAceptacion);
                presentacion.setNota_director(this.notaDirector);
                presentacion.setFecha(fechaNewPresentacion);

                presentacionRNbeanLocal.create(presentacion);
                
                proyectoRNbeanLocal.edit(proyecto);
                System.out.println("hasta acaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + presentacion.getFecha());
                 sDetalle="El estado del proyecto es ahora : "+ estado.getEstado();
                 this.envioMailsBean.ReporteCambioDeEstado(proyecto);
            }

            if (presentacion.getProyecto().getEstado().getId().equals(6L) && (this.notaDirector== false && this.notaCodirector == false)) {

                System.out.println(" NOO pasaasasasasasasassa MODIFICACIONESSS!!" + notaDirector);
                this.certificadoRegular = true;
                this.notaAceptacion = true;
                //consulta me devuelve el registro del estado igual a 6
                estado = proyectoRNbeanLocal.findByEstado(6);
                System.out.println("El estado esw:" + estado.getEstado());
                proyecto.setEstado(estado);
                System.out.println("hasta aca nomaaa :(");
                //Realiza el alta de la presentacion
                presentacion.setProyecto(this.proyecto);
                System.out.println("hasta aca nomaaa :(" + proyecto);
                presentacion.setCertificados(this.certificadoRegular);
                presentacion.setNota_aprobacion(this.notaAceptacion);
                presentacion.setNota_director(this.notaDirector);
                presentacion.setNota_codirector(this.notaCodirector);
                presentacion.setFecha(fechaNewPresentacion);

                presentacionRNbeanLocal.create(presentacion);
                System.out.println("hasta aca nomaaooooooojojojoojojo :(" + proyecto.getEstado().getEstado());
                proyectoRNbeanLocal.edit(proyecto);
                System.out.println("hasta acaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + presentacion.getFecha());
                 sDetalle="El estado del proyecto es ahora : "+estado.getEstado();
                 this.envioMailsBean.ReporteCambioDeEstado(proyecto);
 
            }
            
          

            //limpiar campos
           
            sMensaje = "Presentacion fue guardado exitosamente";
            severity = FacesMessage.SEVERITY_INFO;
            
            
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("dlgNuevaPres.hide()");
             this.limpiar();
             navegarBean.entrarFormPresentacion();
             navegarBean.entrarFormPresentacionModificacionesProyecto();
           

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, sDetalle);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }// fin crear
     
     private void limpiar() {
        this.presentacion = new Presentacion();
        this.setCertificadoRegular(false);
        this.setNotaAceptacion(false);
        this.setNotaDirector(false);
       
    }
}
