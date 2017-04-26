/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import RN.EstadoRNLocal;
import entidad.Estado;
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
public class estadosBean {

    /**
     * Creates a new instance of estadosBean
     */
   
   @ManagedProperty("#{listaEstadoBean}")
    private ListaEstadoBean listaEstadoBean;
    private Estado estado;
    private CommandButton cbAction;
    private Boolean bCamposEditables;
    @EJB
    private EstadoRNLocal estadoRNbeanLocal;
    
    public estadosBean() {
        this.estado = new Estado();
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public EstadoRNLocal getEstadoRNbeanLocal() {
        return estadoRNbeanLocal;
    }

    public void setEstadoRNbeanLocal(EstadoRNLocal estadoRNbeanLocal) {
        this.estadoRNbeanLocal = estadoRNbeanLocal;
    }

    public ListaEstadoBean getListaEstadoBean() {
        return listaEstadoBean;
    }

    public void setListaEstadoBean(ListaEstadoBean listaEstadoBean) {
        this.listaEstadoBean = listaEstadoBean;
    }

    
    public void actionBtn() {

        switch (this.getListaEstadoBean().getiActionBtnSelect()) {
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
                //this.activate(Boolean.FALSE);
                break;
            case 3:
                //habilita el campo
               // this.activate(Boolean.TRUE);
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
            this.getListaEstadoBean().setiActionBtnSelect(0);
           
            //campos requeridos
            //this.setbCamposRequeridos(true);

        } else if (btnSelect.getId().equals("cbEdit")) {
            this.getCbAction().setValue("Modificar");
            this.getListaEstadoBean().setiActionBtnSelect(1);
            
            
            

            //campos requeridos
            // this.setbCamposRequeridos(true);
        } else if (btnSelect.getId().equals("cbDeshabilitado")) {
            this.getListaEstadoBean().setiActionBtnSelect(2);

            this.setbCamposEditables(true);
            this.getCbAction().setValue("Desactivar");

        } else if (btnSelect.getId().equals("cbHabilitado")) {
            this.getListaEstadoBean().setiActionBtnSelect(3);

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
             System.out.println("Entro al create");
            
            estadoRNbeanLocal.create(estado);
            sMensaje = "El dato fue guardado";
            severity = FacesMessage.SEVERITY_INFO;
            this.getCbAction().setDisabled(true);

            //agregar a la lista
            this.getListaEstadoBean().getLstEstado().add(estado);

            //limpiar campos
            this.limpiar();
             RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgEstados'}.hide()");

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
            
            
            estadoRNbeanLocal.edit(this.getEstado());
          

            sMensaje = "Datos actualizados correctamente";
            severity = FacesMessage.SEVERITY_INFO;

            //elimino y agrego el organismo modificado a la lista
            int iPos = this.getListaEstadoBean().getLstEstado().indexOf(this.getEstado());
            this.getListaEstadoBean().getLstEstado().remove(iPos);
            this.getListaEstadoBean().getLstEstado().add(iPos, this.getEstado());

            this.getCbAction().setValue("Update");
            this.getCbAction().setDisabled(true);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgEstados'}.hide()");

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
     /*
      public void activate(Boolean bEstado) {
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;

        try {
            
            comisionRNbeanLocal.activate(this.getComision(), bEstado);

            //elimino el organismo de la lista

            int iPos = this.getListaComisionBean().getLstComision().indexOf(this.getComision());
            
            this.setComision(this.getListaComisionBean().getLstComision().get(iPos));
            this.getComision().setActive(bEstado);
            this.getListaComisionBean().getLstComision().remove(iPos);
            this.getListaComisionBean().getLstComision().add(iPos, this.getComision());

            if (!bEstado) {
                sMensaje = "Comision deshabilitada correctamente";
            } else {
                sMensaje = "Comision habilitada correctamente";
            }
            severity = FacesMessage.SEVERITY_INFO;

            this.getCbAction().setDisabled(true);

            //limíar campos
           this.clear();
           RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgComision'}.hide();");
           // this.setbCamposRequeridos(false);

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Ocurrio un error duracte la operacion: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin recuperar
      */
      
     private void limpiar() {
        this.estado = new Estado();
    }       
    //fin limpiar
    
}
