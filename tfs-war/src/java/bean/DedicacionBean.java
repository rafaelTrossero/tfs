/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import RN.DedicacionRNLocal;
import entidad.Dedicacion;
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
 * @author Trossero
 */
@ManagedBean
@RequestScoped
public class DedicacionBean {

     /**
     * Creates a new instance of Dedicacion
     */
    
     @ManagedProperty("#{listaDedicacionBean}")
    private ListaDedicacionBean listaDedicacionBean;
     
     private Dedicacion dedicacion;
     
    private CommandButton cbAction;
    private Boolean bCamposEditables;
    @EJB
    private DedicacionRNLocal dedicacionRNbeanLocal;

    public DedicacionBean() {
        this.dedicacion =  new Dedicacion();
    }
    
  
    public ListaDedicacionBean getListaDedicacionBean() {
        return listaDedicacionBean;
    }

    public void setListaDedicacionBean(ListaDedicacionBean listaDedicacionBean) {
        this.listaDedicacionBean = listaDedicacionBean;
    }

    

  

    public DedicacionRNLocal getDedicacionRNbeanLocal() {
        return dedicacionRNbeanLocal;
    }

    public void setDedicacionRNbeanLocal(DedicacionRNLocal dedicacionRNbeanLocal) {
        this.dedicacionRNbeanLocal = dedicacionRNbeanLocal;
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

    public Dedicacion getDedicacion() {
        return dedicacion;
    }

    public void setDedicacion(Dedicacion dedicacion) {
        this.dedicacion = dedicacion;
    }

    

   
    public void actionBtn() {

        switch (this.getListaDedicacionBean().getiActionBtnSelect()) {
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
            this.getListaDedicacionBean().setiActionBtnSelect(0);
           
            //campos requeridos
            //this.setbCamposRequeridos(true);

        } else if (btnSelect.getId().equals("cbEdit")) {
            this.getCbAction().setValue("Modificar");
            this.getListaDedicacionBean().setiActionBtnSelect(1);
            
            
            

            //campos requeridos
            // this.setbCamposRequeridos(true);
        } else if (btnSelect.getId().equals("cbDeshabilitado")) {
            this.getListaDedicacionBean().setiActionBtnSelect(2);

            this.setbCamposEditables(true);
            this.getCbAction().setValue("Desactivar");

        } else if (btnSelect.getId().equals("cbHabilitado")) {
            this.getListaDedicacionBean().setiActionBtnSelect(3);

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
            
            
            dedicacionRNbeanLocal.create(dedicacion);
            sMensaje = "El dato fue guardado";
            severity = FacesMessage.SEVERITY_INFO;
            this.getCbAction().setDisabled(true);

            //agregar a la lista
            this.getListaDedicacionBean().getLstDedicaciones().add(dedicacion);

            //limpiar campos
            this.limpiar();
             RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgDedicacion').hide()");

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
          
            dedicacionRNbeanLocal.edit(this.getDedicacion());
          

            sMensaje = "Datos actualizados correctamente";
            severity = FacesMessage.SEVERITY_INFO;

            //elimino y agrego el organismo modificado a la lista
            int iPos = this.getListaDedicacionBean().getLstDedicaciones().indexOf(this.getDedicacion());
            this.getListaDedicacionBean().getLstDedicaciones().remove(iPos);
            this.getListaDedicacionBean().getLstDedicaciones().add(iPos, this.getDedicacion());

            this.getCbAction().setValue("Update");
            this.getCbAction().setDisabled(true);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgDedicacion').hide()");

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
        this.dedicacion = new Dedicacion();
    }
    
     //fin limpiar
   
    
    
}
