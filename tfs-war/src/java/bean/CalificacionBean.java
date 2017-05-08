/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.CalificacionRNLocal;
import RN.CargoRNLocal;
import entidad.Calificacion;
import entidad.Cargo;
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
 * @author USUARIO
 */
@ManagedBean
@RequestScoped
public class CalificacionBean {

    /**
     * Creates a new instance of CalificacionBean
     */
    
     @ManagedProperty("#{listaCalificacioBean}")
    private ListaCalificacioBean listaCalificacionBean;
    private Calificacion calificacion;
    private CommandButton cbAction;
    private Boolean bCamposEditables;
    
    @EJB
    private CalificacionRNLocal calificacionRNbeanLocal;
    
   public CalificacionBean() {
       this.calificacion = new Calificacion();
    }
    

   

   
    public Boolean isbCamposEditables() {
        return bCamposEditables;
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

    public ListaCalificacioBean getListaCalificacionBean() {
        return listaCalificacionBean;
    }

    public void setListaCalificacionBean(ListaCalificacioBean listaCalificacionBean) {
        this.listaCalificacionBean = listaCalificacionBean;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    public CalificacionRNLocal getCalificacionRNbeanLocal() {
        return calificacionRNbeanLocal;
    }

    public void setCalificacionRNbeanLocal(CalificacionRNLocal calificacionRNbeanLocal) {
        this.calificacionRNbeanLocal = calificacionRNbeanLocal;
    }

   
    public void actionBtn() {

        switch (this.getListaCalificacionBean().getiActionBtnSelect()) {
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
               // this.activate(Boolean.FALSE);
                break;
            case 3:
                //habilita el campo
              //  this.activate(Boolean.TRUE);
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

        if (btnSelect.getId().equals("cbCreate")) {
             this.getCbAction().setValue("Guardar");
            this.getListaCalificacionBean().setiActionBtnSelect(0);
           
            //campos requeridos
            //this.setbCamposRequeridos(true);

        } else if (btnSelect.getId().equals("cbEdit")) {
            this.getCbAction().setValue("Modificar");
            this.getListaCalificacionBean().setiActionBtnSelect(1);
            
            
            

            //campos requeridos
            // this.setbCamposRequeridos(true);
        } else if (btnSelect.getId().equals("cbDeshabilitado")) {
            this.getListaCalificacionBean().setiActionBtnSelect(2);

            this.setbCamposEditables(true);
            this.getCbAction().setValue("Desactivar");

        } else if (btnSelect.getId().equals("cbHabilitado")) {
            this.getListaCalificacionBean().setiActionBtnSelect(3);

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
            
            
            calificacionRNbeanLocal.create(calificacion);
            sMensaje = "El dato fue guardado";
            severity = FacesMessage.SEVERITY_INFO;
            this.getCbAction().setDisabled(true);

            //agregar a la lista
            this.getListaCalificacionBean().getLstCalificacion().add(calificacion);

            //limpiar campos
            this.limpiar();
             RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgCalificacion').hide()");

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al crear: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }// fin crear
     
       public void edit() {
        System.out.println("Entro al edit");
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {
          
            calificacionRNbeanLocal.edit(this.getCalificacion());
          

            sMensaje = "Datos actualizados correctamente";
            severity = FacesMessage.SEVERITY_INFO;

            //elimino y agrego el organismo modificado a la lista
            int iPos = this.getListaCalificacionBean().getLstCalificacion().indexOf(this.getCalificacion());
            this.getListaCalificacionBean().getLstCalificacion().remove(iPos);
            this.getListaCalificacionBean().getLstCalificacion().add(iPos, this.getCalificacion());

            this.getCbAction().setValue("Update");
            this.getCbAction().setDisabled(true);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgCalificacion').hide()");

          //  this.setbCamposRequeridos(false);

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Actualizacion error: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin edit
     
     
      
     private void limpiar() {
        this.calificacion = new Calificacion();
    }
    
     //fin limpiar
}
