/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.ComisionRNLocal;
import entidad.Carrera;
import entidad.Comision;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.context.RequestContext;

/**
 *
 * @author WalterVergara
 */
@ManagedBean
@RequestScoped
public class ComisionBean {

    @ManagedProperty("#{listaComisionBean}")
    private ListaComisionBean listaComisionBean;
    private Comision comision;
    private CommandButton cbAction;
    private Boolean bCamposEditables;
    @EJB
    private ComisionRNLocal comisionRNbeanLocal;
    
    public ComisionBean() {
        this.comision = new Comision();
    }

    public ListaComisionBean getListaComisionBean() {
        return listaComisionBean;
    }

    public void setListaComisionBean(ListaComisionBean listaComisionBean) {
        this.listaComisionBean = listaComisionBean;
    }

    public Comision getComision() {
        return comision;
    }

    public void setComision(Comision comision) {
        this.comision = comision;
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

    public ComisionRNLocal getComisionRNbeanLocal() {
        return comisionRNbeanLocal;
    }

    public void setComisionRNbeanLocal(ComisionRNLocal comisionRNbeanLocal) {
        this.comisionRNbeanLocal = comisionRNbeanLocal;
    }
    public void actionBtn() {

        switch (this.getListaComisionBean().getiActionBtnSelect()) {
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

        if (btnSelect.getId().equals("cbCreate")) {
             this.getCbAction().setValue("Guardar");
            this.getListaComisionBean().setiActionBtnSelect(0);
           
            //campos requeridos
            //this.setbCamposRequeridos(true);

        } else if (btnSelect.getId().equals("cbEdit")) {
            this.getCbAction().setValue("Modificar");
            this.getListaComisionBean().setiActionBtnSelect(1);
            
            
            System.out.println("valor del boton: " + listaComisionBean.getiActionBtnSelect());

            //campos requeridos
            // this.setbCamposRequeridos(true);
        } else if (btnSelect.getId().equals("cbDeshabilitado")) {
            this.getListaComisionBean().setiActionBtnSelect(2);

            this.setbCamposEditables(true);
            this.getCbAction().setValue("Desactivar");

        } else if (btnSelect.getId().equals("cbHabilitado")) {
            this.getListaComisionBean().setiActionBtnSelect(3);

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
            comision.setActive(Boolean.TRUE);
            comisionRNbeanLocal.create(comision);
            sMensaje = "El dato fue guardado";
            severity = FacesMessage.SEVERITY_INFO;
            this.getCbAction().setDisabled(true);

            //agregar a la lista
            this.getListaComisionBean().getLstComision().add(comision);

            //limpiar campos
            this.limpiar();
             RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgComision'}.hide();");

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
            comision.setActive(Boolean.TRUE);

            
            comisionRNbeanLocal.edit(this.getComision());
          

            sMensaje = "Datos actualizados correctamente";
            severity = FacesMessage.SEVERITY_INFO;

            //elimino y agrego el organismo modificado a la lista
            int iPos = this.getListaComisionBean().getLstComision().indexOf(this.getComision());
            this.getListaComisionBean().getLstComision().remove(iPos);
            this.getListaComisionBean().getLstComision().add(iPos, this.getComision());

            this.getCbAction().setValue("Update");
            this.getCbAction().setDisabled(true);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgComision'}.hide();");

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
      
      
     private void limpiar() {
        this.comision = new Comision();
    }
    
       private void clear() {
          this.setComision(new Comision());
        
    }//fin limpiar
}