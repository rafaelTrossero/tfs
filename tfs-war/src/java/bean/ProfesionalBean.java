/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.ProfesionalRNLocal;
import entidad.Profesional;
import entidad.tipoUsuario;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.context.RequestContext;
import recursos.Encriptacion;

/**
 *
 * @author Trossero
 */
@ManagedBean
@RequestScoped
public class ProfesionalBean {

    @ManagedProperty("#{listaProfesionalBean}")
    private ListaProfesionalBean listaProfesionalBean;
    private Profesional profesional;
     private Boolean bCamposEditables;
     private Encriptacion encript = new Encriptacion();

    @EJB
    private ProfesionalRNLocal profesionalRNbeanLocal;
    private CommandButton cbAction;

    public ProfesionalBean() {

        this.profesional = new Profesional();

    }

    public ListaProfesionalBean getListaProfesionalBean() {
        return listaProfesionalBean;
    }

    public Boolean isbCamposEditables() {
        return bCamposEditables;
    }

    public Boolean getbCamposEditables() {
        return bCamposEditables;
    }

    public Encriptacion getEncript() {
        return encript;
    }

    public void setEncript(Encriptacion encript) {
        this.encript = encript;
    }
    

    public void setbCamposEditables(Boolean bCamposEditables) {
        this.bCamposEditables = bCamposEditables;
    }

    public void setListaProfesionalBean(ListaProfesionalBean listaProfesionalBean) {
        this.listaProfesionalBean = listaProfesionalBean;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public CommandButton getCbAction() {
        return cbAction;
    }

    public void setCbAction(CommandButton cbAction) {
        this.cbAction = cbAction;
    }

    public void actionBtn() {

        switch (this.getListaProfesionalBean().getiActionBtnSelect()) {
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

        if (btnSelect.getId().equals("cbNuevo") ) {
            this.getListaProfesionalBean().setiActionBtnSelect(0);
            this.getCbAction().setValue("Guardar");
            //campos requeridos
           // this.setbCamposRequeridos(true);

        } else if (btnSelect.getId().equals("cbEditar")) {
            this.getCbAction().setValue("Modificar");
            this.getListaProfesionalBean().setiActionBtnSelect(1);

            //campos requeridos
            //this.setbCamposRequeridos(true);
        } else if (btnSelect.getId().equals("cbDeshabilitado")) {
            this.getListaProfesionalBean().setiActionBtnSelect(2);

            this.setbCamposEditables(true);
            this.getCbAction().setValue("Desactivar");

        } else if (btnSelect.getId().equals("cbHabilitado")) {
            this.getListaProfesionalBean().setiActionBtnSelect(3);

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

            profesional.setActive(Boolean.TRUE);
            System.out.println("Paso por acá");
            profesional.setTipousuario(tipoUsuario.PROFESIONAL);
            profesional.setUsername(this.profesional.getCuil());

            if (profesional.getCuil().isEmpty()) {
                throw new Exception("Debe ingresar el numero de cuil");
            }else{
            profesional.setDni(Integer.parseInt(this.profesional.getCuil().substring(3, 11)));
            System.out.println("::::::::::el DNI es ---> " +profesional.getDni() );
            }
            String encriptMD5Alu= encript.hash(profesional.getPassword());
            profesional.setPassword(encriptMD5Alu);

            profesionalRNbeanLocal.create(profesional);
            sMensaje = "Profesional guardado exitosamente";
            severity = FacesMessage.SEVERITY_INFO;
            this.getCbAction().setDisabled(true);
            //agregar a la lista
            this.getListaProfesionalBean().getLstProfesional().add(profesional);

            //limpiar campos
            this.limpiar();
            
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgProfesional').hide();");

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al crear: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, "");
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
            profesional.setActive(Boolean.TRUE);
             profesional.setTipousuario(tipoUsuario.PROFESIONAL);
            profesional.setUsername(this.profesional.getCuil());

           //  Profesional prof_modificado = profesionalRNbeanLocal.findByDni(this.getProfesional().getDni());
            if (profesional.getCuil().isEmpty()) {
                throw new Exception("Debe ingresar el numero de cuil");
            }else{
            profesional.setDni(Integer.parseInt(this.profesional.getCuil().substring(3, 11)));
            System.out.println("::::::::::el DNI es ---> " +profesional.getDni() );
            }
            profesionalRNbeanLocal.edit(this.getProfesional());
          
            
            sMensaje = "Datos actualizados correctamente";
            severity = FacesMessage.SEVERITY_INFO;

            //elimino y agrego el organismo modificado a la lista
            int iPos = this.getListaProfesionalBean().getLstProfesional().indexOf(this.getProfesional());

            this.getListaProfesionalBean().getLstProfesional().remove(iPos);
            this.getListaProfesionalBean().getLstProfesional().add(iPos,this.getProfesional());

            //this.getCbAction().setValue("Update");
            this.getCbAction().setDisabled(true);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("dlgProfesional.hide()");

          //this.setbCamposRequeridos(false);

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

            profesionalRNbeanLocal.activate(this.getProfesional(), bEstado);

            //elimino el organismo de la lista

            int iPos = this.getListaProfesionalBean().getLstProfesional().indexOf(this.getProfesional());
            
            this.setProfesional(this.getListaProfesionalBean().getLstProfesional().get(iPos));
            this.getProfesional().setActive(bEstado);
            this.getListaProfesionalBean().getLstProfesional().remove(iPos);
            this.getListaProfesionalBean().getLstProfesional().add(iPos, this.getProfesional());

            if (!bEstado) {
                sMensaje = "Profesional deshabilitado correctamente";
            } else {
                sMensaje = "Profesional habilitado correctamente";
            }
            severity = FacesMessage.SEVERITY_INFO;

            this.getCbAction().setDisabled(true);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("dlgProfesional.hide()");

            //limíar campos
          
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
        this.profesional = new Profesional();
    }

   
        private void clear() {
            this.setProfesional(new Profesional());
        
    }//fin limpiar
    }


