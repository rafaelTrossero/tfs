/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.AutoridadesDepartamentoRNLocal;
import entidad.Alumno;
import entidad.AutoridadesDepartamento;
import entidad.Docente;
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
 * @author RafaTrossero
 */
@ManagedBean
@RequestScoped
public class AutoridadesDeptoInfBean {

    /**
     * Creates a new instance of autoridadesDeptoInfBean
     */
    
    @ManagedProperty("#{listaAutoridadesDeptoInfBean}")
    private ListaAutoridadesDeptoInfBean listaAutoridadesDeptoInfBean;
    @EJB
    private AutoridadesDepartamentoRNLocal autoridadesRNbeanLocal;
      private CommandButton cbAction;
    
    
    private AutoridadesDepartamento autoridades;
    
    public AutoridadesDeptoInfBean() {
        
        this.autoridades = new AutoridadesDepartamento();
    }

   

    public AutoridadesDepartamento getAutoridades() {
        return autoridades;
    }

    public void setAutoridades(AutoridadesDepartamento autoridades) {
        this.autoridades = autoridades;
    }

    public ListaAutoridadesDeptoInfBean getListaAutoridadesDeptoInfBean() {
        return listaAutoridadesDeptoInfBean;
    }

    public void setListaAutoridadesDeptoInfBean(ListaAutoridadesDeptoInfBean listaAutoridadesDeptoInfBean) {
        this.listaAutoridadesDeptoInfBean = listaAutoridadesDeptoInfBean;
    }

    public AutoridadesDepartamentoRNLocal getAutoridadesRNbeanLocal() {
        return autoridadesRNbeanLocal;
    }

    public void setAutoridadesRNbeanLocal(AutoridadesDepartamentoRNLocal autoridadesRNbeanLocal) {
        this.autoridadesRNbeanLocal = autoridadesRNbeanLocal;
    }

    public CommandButton getCbAction() {
        return cbAction;
    }

    public void setCbAction(CommandButton cbAction) {
        this.cbAction = cbAction;
    }
    
    public void actionBtn() {

   
            switch (this.getListaAutoridadesDeptoInfBean().getiActionBtnSelect()) {
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
                //this.activate(Boolean.TRUE);
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
            this.getListaAutoridadesDeptoInfBean().setiActionBtnSelect(0);

            //campos requeridos
            //this.setbCamposRequeridos(true);
        } else if (btnSelect.getId().equals("cbEditar")) {
            this.getCbAction().setValue("Modificar");
            this.getListaAutoridadesDeptoInfBean().setiActionBtnSelect(1);


            //campos requeridos
            // this.setbCamposRequeridos(true);
        } else if (btnSelect.getId().equals("cbDeshabilitado")) {
            this.getListaAutoridadesDeptoInfBean().setiActionBtnSelect(2);
            

            //this.setbCamposEditables(true);
            this.getCbAction().setValue("Desactivar");

        } else if (btnSelect.getId().equals("cbHabilitado")) {
            this.getListaAutoridadesDeptoInfBean().setiActionBtnSelect(3);
            

            //this.setbCamposEditables(true);
            this.getCbAction().setValue("Reactivar");

        }

        //fin else
    }//fin setBtnSelect
    
     public void create() {
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {
           
            autoridadesRNbeanLocal.create(autoridades);
            
            sMensaje = "El dato fue guardado";
            severity = FacesMessage.SEVERITY_INFO;
           // this.getCbAction().setDisabled(true);

            //agregar a la lista
            //this.getListaComisionBean().getLstComision().add(comision);

            //limpiar campos
            //this.limpiar();

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
            //comision.setActive(Boolean.TRUE);

            autoridadesRNbeanLocal.edit(this.getAutoridades());
            
          

            sMensaje = "Datos actualizados correctamente";
            severity = FacesMessage.SEVERITY_INFO;
/*
            //elimino y agrego el organismo modificado a la lista
            int iPos = this.getListaComisionBean().getLstComision().indexOf(this.getComision());
            this.getListaComisionBean().getLstComision().remove(iPos);
            this.getListaComisionBean().getLstComision().add(iPos, this.getComision());
*/
            this.getCbAction().setValue("Update");
            this.getCbAction().setDisabled(true);

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
}
