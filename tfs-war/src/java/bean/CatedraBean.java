/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.CatedraRNLocal;
import RN.Horario_catedra_semanalRNLocal;
import RN.horario_catedraRNLocal;
import entidad.Catedra;
import entidad.DocenteCatedra;
import entidad.Horario_catedra;
import entidad.Horario_semanal_catedra;
import entidad.rutasArchivos;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.context.RequestContext;

/**
 *
 * @author RafaTrossero
 */
@ManagedBean
@RequestScoped
public class CatedraBean {

    
    @ManagedProperty("#{listaCatedraBean}")
    private ListaCatedraBean listaCatedraBean;
    @ManagedProperty("#{listaHorarioBean}")
    private ListaHorarioBean listaHorarioBean;
    @ManagedProperty("#{fileUploadController}")
    private FileUploadController fileUploadControler;
    
    private Catedra catedra;
    private Boolean bCamposEditables;
    private Horario_catedra horario_catedra;
    private Horario_semanal_catedra hora_sem_catedra;
   
    private CommandButton cbAction;
    
    @EJB
    private CatedraRNLocal catedraRNLocal;
     @EJB
    private horario_catedraRNLocal Horario_catedra_semanalRNLocal;
       @EJB
       private Horario_catedra_semanalRNLocal objeto_hora_semanal;
    /**
     * Creates a new instance of CatedraBean
     */
    public CatedraBean() {
        this.catedra = new Catedra();
         this.horario_catedra = new Horario_catedra();
         this.hora_sem_catedra = new Horario_semanal_catedra();
    }

   

    public Horario_catedra_semanalRNLocal getObjeto_hora_semanal() {
        return objeto_hora_semanal;
    }

    public void setObjeto_hora_semanal(Horario_catedra_semanalRNLocal objeto_hora_semanal) {
        this.objeto_hora_semanal = objeto_hora_semanal;
    }

    public FileUploadController getFileUploadControler() {
        return fileUploadControler;
    }

    public void setFileUploadControler(FileUploadController fileUploadControler) {
        this.fileUploadControler = fileUploadControler;
    }
    
    

    public ListaCatedraBean getListaCatedraBean() {
        return listaCatedraBean;
    }

    public ListaHorarioBean getListaHorarioBean() {
        return listaHorarioBean;
    }

    public Horario_semanal_catedra getHora_sem_catedra() {
        return hora_sem_catedra;
    }

    public void setHora_sem_catedra(Horario_semanal_catedra hora_sem_catedra) {
        this.hora_sem_catedra = hora_sem_catedra;
    }

    public void setListaHorarioBean(ListaHorarioBean listaHorarioBean) {
        this.listaHorarioBean = listaHorarioBean;
    }

    public void setListaCatedraBean(ListaCatedraBean listaCatedraBean) {
        this.listaCatedraBean = listaCatedraBean;
    }

    public Horario_catedra getHorario_catedra() {
        return horario_catedra;
    }

    public void setHorario_catedra(Horario_catedra horario_catedra) {
        this.horario_catedra = horario_catedra;
    }

    public horario_catedraRNLocal getHorario_catedra_semanalRNLocal() {
        return Horario_catedra_semanalRNLocal;
    }

    public void setHorario_catedra_semanalRNLocal(horario_catedraRNLocal Horario_catedra_semanalRNLocal) {
        this.Horario_catedra_semanalRNLocal = Horario_catedra_semanalRNLocal;
    }

    

    public Catedra getCatedra() {
        return catedra;
    }

    public void setCatedra(Catedra catedra) {
        this.catedra = catedra;
    }

    public Boolean getbCamposEditables() {
        return bCamposEditables;
    }

    public void setbCamposEditables(Boolean bCamposEditables) {
        this.bCamposEditables = bCamposEditables;
    }

    public CommandButton getCbAction() {
        return cbAction;
    }

    public void setCbAction(CommandButton cbAction) {
        this.cbAction = cbAction;
    }

    public CatedraRNLocal getCatedraRNLocal() {
        return catedraRNLocal;
    }

    public void setCatedraRNLocal(CatedraRNLocal catedraRNLocal) {
        this.catedraRNLocal = catedraRNLocal;
    }
    
    
     public void actionBtn() {

        switch (this.getListaCatedraBean().getiActionBtnSelect()) {
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
    }//fin actionBtn
     
     public void setBtnSelect(ActionEvent e) {
        CommandButton btnSelect = (CommandButton) e.getSource();
        System.out.println("boton select: " + btnSelect.getId());
    //0 crea
        //1: edit
        //2 delete

        //activo el boton
        this.getCbAction().setDisabled(false);

        if (btnSelect.getId().equals("cbNuevo")) {
             this.getCbAction().setValue("Guardar");
            this.getListaCatedraBean().setiActionBtnSelect(0);
           
            //campos requeridos
            //this.setbCamposRequeridos(true);

        } else if (btnSelect.getId().equals("cbEditar")) {
            this.getCbAction().setValue("Modificar");
            this.getListaCatedraBean().setiActionBtnSelect(1);
            
            
            System.out.println("valor del boton: " + listaCatedraBean.getiActionBtnSelect());

            //campos requeridos
            // this.setbCamposRequeridos(true);
        } else if (btnSelect.getId().equals("cbDeshabilitado")) {
            this.getListaCatedraBean().setiActionBtnSelect(2);

            this.setbCamposEditables(true);
            this.getCbAction().setValue("Desactivar");

        } else if (btnSelect.getId().equals("cbHabilitado")) {
            this.getListaCatedraBean().setiActionBtnSelect(3);

            this.setbCamposEditables(true);
            this.getCbAction().setValue("Reactivar");

        }

        //fin else
    }//fin setBtnSelect 
    
      public void create() {
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {
            
            catedra.setActive(Boolean.TRUE);
            catedra.setRuta(fileUploadControler.destino);
            catedraRNLocal.create(catedra);
            horario_catedra.setCatedra(catedra);
            Horario_catedra_semanalRNLocal.create(horario_catedra);
            setear_cronograma();
            
            System.out.println("el id de la catedra es:\t" + catedra.getId());
            sMensaje = "Cátedra guardada exitosamente";
            severity = FacesMessage.SEVERITY_INFO;
             this.getCbAction().setDisabled(true);
            //agregar a la lista
            this.getListaCatedraBean().getLstCatedra().add(catedra);
             this.getCbAction().setDisabled(true);
            //limpiar campos
            this.limpiar();
             
           listaHorarioBean.limpiar();
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgCatedra').hide()");

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al crear: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }// fin crear
      
      
      public void setear_cronograma() {

        

        /*
         Se recorre la lista que tiene las actividades insertados y se hace un create en la tabla
         por cada actividad de la lista
         */
        Iterator<Horario_semanal_catedra> it = listaHorarioBean.getLis_hor_sem().iterator();
        System.out.println("---------------los horarios son + " + listaHorarioBean.getLis_hor_sem());
        while (it.hasNext()) {
            hora_sem_catedra = it.next();
            this.setHora_sem_catedra(hora_sem_catedra);
            this.hora_sem_catedra.setHorario_catedra(horario_catedra);
            
            try {
                this.objeto_hora_semanal.create(hora_sem_catedra);

            } catch (Exception ex) {
                Logger.getLogger(CatedraBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
      public void edit() {
        System.out.println("Entro al edit");
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {
            //get la fila seleccionada   
            catedra.setActive(Boolean.TRUE);

            
            catedraRNLocal.edit(this.getCatedra());
          

            sMensaje = "Datos actualizados correctamente";
            severity = FacesMessage.SEVERITY_INFO;

            //elimino y agrego el organismo modificado a la lista
            int iPos = this.getListaCatedraBean().getLstCatedra().indexOf(this.getCatedra());
            this.getListaCatedraBean().getLstCatedra().remove(iPos);
            this.getListaCatedraBean().getLstCatedra().add(iPos, this.getCatedra());

            //this.getCbAction().setValue("Update");
            this.getCbAction().setDisabled(true);
            this.limpiar();
             
            listaHorarioBean.limpiar();
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgCatedra').hide()");
          //  this.setbCamposRequeridos(false);

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al actualizar: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin edit
      
       public void activate(Boolean bEstado) {
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;

        try {

            catedraRNLocal.activate(this.getCatedra(), bEstado);

            //elimino el organismo de la lista

            int iPos = this.getListaCatedraBean().getLstCatedra().indexOf(this.getCatedra());
            
            this.setCatedra(this.getListaCatedraBean().getLstCatedra().get(iPos));
            this.getCatedra().setActive(bEstado);
            this.getListaCatedraBean().getLstCatedra().remove(iPos);
            this.getListaCatedraBean().getLstCatedra().add(iPos, this.getCatedra());

            if (!bEstado) {
                sMensaje = "Cátedra deshabilitada correctamente";
            } else {
                sMensaje = "Cátedra habilitada correctamente";
            }
            severity = FacesMessage.SEVERITY_INFO;

            this.getCbAction().setDisabled(true);

            //limíar campos
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgCatedra').hide()");
           this.clear();
           listaHorarioBean.limpiar();
           // this.setbCamposRequeridos(false);

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Ocurrio un error duracte la operación: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin recuperar
       
           
    private void limpiar() {
        this.catedra = new Catedra();
    }
    
      private void clear() {
          this.setCatedra(new Catedra());
        
    }//fin limpiar
}
