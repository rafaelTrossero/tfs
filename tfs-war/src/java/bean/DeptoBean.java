/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import RN.DeptoRNLocal;
import entidad.Depto;
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
 * @author cristian
 */
@ManagedBean
@RequestScoped
public class DeptoBean {
    @ManagedProperty("#{listaDeptoBean}")
    private ListaDeptoBean listaDeptoBean;
    private Depto departamento;
    private CommandButton cbAction;
    private String[] ok;
    
     private Boolean bCamposEditables;
    
    @EJB
    private DeptoRNLocal deptoRNLocal;

    /**
     * Creates a new instance of DeptoBean
     */
    public DeptoBean() {
        this.departamento= new Depto();
    }

    
    public ListaDeptoBean getListaDeptoBean() {
        return listaDeptoBean;
    }

    public void setListaDeptoBean(ListaDeptoBean listaDeptoBean) {
        this.listaDeptoBean = listaDeptoBean;
    }
    
    public Depto getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Depto departamento) {
        this.departamento = departamento;
    }

    public String[] getOk() {
        return ok;
    }

    public void setOk(String[] ok) {
        this.ok = ok;
    }

    public CommandButton getCbAction() {
        return cbAction;
    }

    public void setCbAction(CommandButton cbAction) {
        this.cbAction = cbAction;
    }

    public DeptoRNLocal getDeptoRNLocal() {
        return deptoRNLocal;
    }

    public void setDeptoRNLocal(DeptoRNLocal deptoRNLocal) {
        this.deptoRNLocal = deptoRNLocal;
    }

    public Boolean getbCamposEditables() {
        return bCamposEditables;
    }

    public void setbCamposEditables(Boolean bCamposEditables) {
        this.bCamposEditables = bCamposEditables;
    }
    
    public void actionBtn() {

        switch (this.getListaDeptoBean().getiActionBtnSelect()) {
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
        System.out.println("botoooon select: " + btnSelect.getId());
    //0 crea
        //1: edit
        //2 delete

        //activo el boton
        this.getCbAction().setDisabled(false);

        if (btnSelect.getId().equals("cbCreate")) {
            this.getListaDeptoBean().setiActionBtnSelect(0);
             this.getCbAction().setValue("Guardar");
             System.out.println("botoooon select: " + this.getListaDeptoBean().getiActionBtnSelect());
            
             
            
           
            //campos requeridos
            //this.setbCamposRequeridos(true);

        } else if (btnSelect.getId().equals("cbEditar")) {
            this.getCbAction().setValue("Modificar");
             this.getListaDeptoBean().setiActionBtnSelect(1);
            
            
            System.out.println("valor del boton: " + listaDeptoBean.getiActionBtnSelect());

            //campos requeridos
            // this.setbCamposRequeridos(true);
        } else if (btnSelect.getId().equals("cbDeshabilitado")) {
             this.getListaDeptoBean().setiActionBtnSelect(2);
            

            this.setbCamposEditables(true);
            this.getCbAction().setValue("Desactivar");

        } else if (btnSelect.getId().equals("cbHabilitado")) {
            this.getListaDeptoBean().setiActionBtnSelect(3);

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
            
            departamento.setActive(Boolean.TRUE);
            deptoRNLocal.create(departamento);
            sMensaje = "El Departamento fue guardado";
            severity = FacesMessage.SEVERITY_INFO;
             this.getCbAction().setDisabled(true);

            //agregar a la lista
            this.getListaDeptoBean().getLstDepartamento().add(departamento);
            
            
            //limpiar campos
            
                this.limpiar();
            
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("dlgDepartamento.hide()");
        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al crear: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }
    
    public void edit() {
        System.out.println("Entro al edit");
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {
            //get la fila seleccionada   
            departamento.setActive(Boolean.TRUE);

            
            deptoRNLocal.edit(this.getDepartamento());
          

            sMensaje = "Datos actualizados correctamente";
            severity = FacesMessage.SEVERITY_INFO;

            //elimino y agrego el organismo modificado a la lista
          
            int iPos = this.getListaDeptoBean().getLstDepartamento().indexOf(this.getDepartamento());
            this.getListaDeptoBean().getLstDepartamento().remove(iPos);
            this.getListaDeptoBean().getLstDepartamento().add(iPos, this.getDepartamento());

            //this.getCbAction().setValue("Update");
            this.getCbAction().setDisabled(true);
            this.limpiar();
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("dlgDepartamento.hide()");
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

            deptoRNLocal.activate(this.getDepartamento(), bEstado);

            //elimino el organismo de la lista

            
            int iPos = this.getListaDeptoBean().getLstDepartamento().indexOf(this.getDepartamento()); 
            
            this.setDepartamento(this.getListaDeptoBean().getLstDepartamento().get(iPos));
            this.getDepartamento().setActive(bEstado);
            this.getListaDeptoBean().getLstDepartamento().remove(iPos);
            this.getListaDeptoBean().getLstDepartamento().add(iPos, this.getDepartamento());

            if (!bEstado) {
                sMensaje = "Departamento deshabilitado correctamente";
            } else {
                sMensaje = "Departamento habilitado correctamente";
            }
            severity = FacesMessage.SEVERITY_INFO;

            this.getCbAction().setDisabled(true);

            //limíar campos
           this.clear();
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
        this.departamento = new Depto();
    }
    
      private void clear() {
          this.setDepartamento(new Depto());
        
    }//fin limpiar
    
    
}
