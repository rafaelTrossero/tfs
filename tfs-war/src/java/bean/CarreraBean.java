/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.CarreraRNLocal;
import entidad.Carrera;
import entidad.Profesional;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.component.commandbutton.CommandButton;

/**
 *
 * @author jmoreno
 */
@ManagedBean
@RequestScoped
public class CarreraBean {

    @ManagedProperty("#{listaCarreraBean}")
    private ListaCarreraBean listaCarreraBean;
    private Carrera carrera;
    private Boolean bCamposEditables;
    
    private CommandButton cbAction;
    
    @EJB
    private CarreraRNLocal carreraRNLocal;

    /**
     * Creates a new instance of CarreraBean
     */
    public CarreraBean() {
        this.carrera = new Carrera();
    }

    public Carrera getCarrera() {
        return carrera;
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

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public ListaCarreraBean getListaCarreraBean() {
        return listaCarreraBean;
    }

    public void setListaCarreraBean(ListaCarreraBean listaCarreraBean) {
        this.listaCarreraBean = listaCarreraBean;
    }

    public CommandButton getCbAction() {
        return cbAction;
    }

    public void setCbAction(CommandButton cbAction) {
        this.cbAction = cbAction;
    }
    
    
    public void actionBtn() {

        switch (this.getListaCarreraBean().getiActionBtnSelect()) {
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
            this.getListaCarreraBean().setiActionBtnSelect(0);
           
            //campos requeridos
            //this.setbCamposRequeridos(true);

        } else if (btnSelect.getId().equals("cbEditar")) {
            this.getCbAction().setValue("Modificar");
            this.getListaCarreraBean().setiActionBtnSelect(1);
            
            
            System.out.println("valor del boton: " + listaCarreraBean.getiActionBtnSelect());

            //campos requeridos
            // this.setbCamposRequeridos(true);
        } else if (btnSelect.getId().equals("cbDeshabilitado")) {
            this.getListaCarreraBean().setiActionBtnSelect(2);

            this.setbCamposEditables(true);
            this.getCbAction().setValue("Desactivar");

        } else if (btnSelect.getId().equals("cbHabilitado")) {
            this.getListaCarreraBean().setiActionBtnSelect(3);

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
            carrera.setActive(Boolean.TRUE);
            carreraRNLocal.create(carrera);
            sMensaje = "Carrera guardada exitosamente";
            severity = FacesMessage.SEVERITY_INFO;
             this.getCbAction().setDisabled(true);
            //agregar a la lista
            this.getListaCarreraBean().getLstCarrera().add(carrera);
             this.getCbAction().setDisabled(true);
            //limpiar campos
            this.limpiar();

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
            //get la fila seleccionada   
            carrera.setActive(Boolean.TRUE);

            
            carreraRNLocal.edit(this.getCarrera());
          

            sMensaje = "Datos actualizados correctamente";
            severity = FacesMessage.SEVERITY_INFO;

            //elimino y agrego el organismo modificado a la lista
            int iPos = this.getListaCarreraBean().getLstCarrera().indexOf(this.getCarrera());
            this.getListaCarreraBean().getLstCarrera().remove(iPos);
            this.getListaCarreraBean().getLstCarrera().add(iPos, this.getCarrera());

            //this.getCbAction().setValue("Update");
            this.getCbAction().setDisabled(true);

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

            carreraRNLocal.activate(this.getCarrera(), bEstado);

            //elimino el organismo de la lista

            int iPos = this.getListaCarreraBean().getLstCarrera().indexOf(this.getCarrera());
            
            this.setCarrera(this.getListaCarreraBean().getLstCarrera().get(iPos));
            this.getCarrera().setActive(bEstado);
            this.getListaCarreraBean().getLstCarrera().remove(iPos);
            this.getListaCarreraBean().getLstCarrera().add(iPos, this.getCarrera());

            if (!bEstado) {
                sMensaje = "Carrera deshabilitada correctamente";
            } else {
                sMensaje = "Carrera habilitada correctamente";
            }
            severity = FacesMessage.SEVERITY_INFO;

            this.getCbAction().setDisabled(true);

            //limíar campos
           this.clear();
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
        this.carrera = new Carrera();
    }
    
      private void clear() {
          this.setCarrera(new Carrera());
        
    }//fin limpiar
}