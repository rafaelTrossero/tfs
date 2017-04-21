/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.AlumnoCarreraRNLocal;
import RN.AlumnoRNLocal;
import RN.GrupoRNLocal;
import RN.ProfesionalRNLocal;
import entidad.Alumno;
import entidad.AlumnoCarrera;
import entidad.Grupo;
import entidad.Profesional;
import entidad.tipoUsuario;
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
import recursos.Encriptacion;

/**
 *
 * @author WalterVergara
 */
@ManagedBean
@RequestScoped
public class AlumnoBean {

 @ManagedProperty("#{listaAlumnoBean}")
    private ListaAlumnoBean listaAlumnoBean;
 @ManagedProperty("#{listaAlumnoCarreraBean}")
    private ListaAlumnoCarreraBean listaAlumnoCarreraBean;

    private Alumno alumno;
    private Alumno a;
    private Grupo grupo1;
    private Encriptacion encript = new Encriptacion();
   
    private AlumnoCarrera alumnoCarrera;
        private AlumnoCarrera aluCar;
        private Boolean bCamposEditables;

    @EJB
    private AlumnoRNLocal alumnoRNbeanLocal;
    @EJB
    private AlumnoCarreraRNLocal alumnoCarreraRNbeanLocal;
    @EJB
    private GrupoRNLocal grupoRNbeanLocal;
    private CommandButton cbAction;
    
    public AlumnoBean() {   
        this.alumno = new Alumno();
        this.alumnoCarrera=new AlumnoCarrera();
    }

    public AlumnoCarrera getAlumnoCarrera() {
        return alumnoCarrera;
    }

    public void setAlumnoCarrera(AlumnoCarrera alumnoCarrera) {
        this.alumnoCarrera = alumnoCarrera;
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
    

    public ListaAlumnoCarreraBean getListaAlumnoCarreraBean() {
        return listaAlumnoCarreraBean;
    }

    public void setListaAlumnoCarreraBean(ListaAlumnoCarreraBean listaAlumnoCarreraBean) {
        this.listaAlumnoCarreraBean = listaAlumnoCarreraBean;
    }

    public ListaAlumnoBean getListaAlumnoBean() {
        return listaAlumnoBean;
    }

    public void setListaAlumnoBean(ListaAlumnoBean listaAlumnoBean) {
        this.listaAlumnoBean = listaAlumnoBean;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public CommandButton getCbAction() {
        return cbAction;
    }

    public void setCbAction(CommandButton cbAction) {
        this.cbAction = cbAction;
    }
    
    
    public void actionBtn() {
        //System.out.println("he si estoy aca" + this.getListaUsersBean().getiActionBtnSelect());
        switch (this.getListaAlumnoBean().getiActionBtnSelect()) {
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
    }
    public void setBtnSelect(ActionEvent e) {
        CommandButton btnSelect = (CommandButton) e.getSource();
        System.out.println("boton select: " + btnSelect.getId());
    //0 crea
        //1: edit
        //2 delete

        //activo el boton
        this.getCbAction().setDisabled(false);

        if (btnSelect.getId().equals("cbCreate") || btnSelect.getId().equals("cbNuevoUsers")) {
            this.getListaAlumnoBean().setiActionBtnSelect(0);
             System.out.println("he si estoy aca" + this.getListaAlumnoBean().getiActionBtnSelect());

            this.getCbAction().setValue("Guardar");
            //campos requeridos
            //this.setbCamposRequeridos(true);

        } else if (btnSelect.getId().equals("cbEdit")) {
            this.getCbAction().setValue("Modificar");
            
            this.getListaAlumnoBean().setiActionBtnSelect(1);

            //campos requeridos
            //this.setbCamposRequeridos(true);
        } else if (btnSelect.getId().equals("cbDeshabilitado")) {
            this.getListaAlumnoBean().setiActionBtnSelect(2);
            this.setbCamposEditables(true);
            this.getCbAction().setValue("Desactivar");

        } else if (btnSelect.getId().equals("cbHabilitado")) {

            this.getListaAlumnoBean().setiActionBtnSelect(3);
            this.setbCamposEditables(true);
            this.getCbAction().setValue("Reactivar");

        }

        //fin else
    }
    public void create() {
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        
        try {
            alumno.setActive(Boolean.TRUE);
            String encriptMD5Alu= encript.hash(alumno.getPassword());
            alumno.setPassword(encriptMD5Alu);
            a = new Alumno();
            
            System.out.println("Paso por acá");
            
              alumno.setTipousuario(tipoUsuario.ALUMNO);
              
             //grupo1 = grupoRNbeanLocal.findByGrupo(1);
             //alumno.setGrupo(grupo1);
            //System.out.println("el grupo que devolvio es:  "+ grupo1.getDescripcion());
            alumnoRNbeanLocal.create(alumno);
            
            a =alumnoRNbeanLocal.findByAlumno(alumno.getMatricula());
            if(a==null){
                System.out.println("no devolvio nada");
            }
            else{System.out.println("si devuelve"+ a.getApellido()+ a.getDni());
            }
           //alumnoCarrera.setAlumno(a);
            //System.out.println("si esta:"+ alumnoCarrera.getCarrera().getCarrera());
            
            alumnoCarrera.setAlumno(a);
            alumnoCarreraRNbeanLocal.create(alumnoCarrera);
           
            sMensaje = "Alumno guardado exitosamente";
            severity = FacesMessage.SEVERITY_INFO;
            this.getCbAction().setDisabled(true);
            //agregar a la lista
            this.getListaAlumnoBean().getLstAlumno().add(alumno);
            this.getListaAlumnoCarreraBean().getLstAlumno_Carrera().add(alumnoCarrera);
        

            //limpiar campos
            this.limpiar();
            
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgAlumno').hide();");

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, "");
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }// fin crear
     private void limpiar() {
        this.alumno = new Alumno();
        
    }
     public void edit() {
        System.out.println("Entro al edit");
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {
            
            
            alumno.setActive(Boolean.TRUE);
            String encriptMD5Alu= encript.hash(alumno.getPassword());
            alumno.setPassword(encriptMD5Alu);
            
              alumno.setTipousuario(tipoUsuario.ALUMNO);
            //get la fila seleccionada           
            //users.setActive(Boolean.TRUE);
            
            //Alumno alumno_to_modified = AlumnoRNLocal.findByUserPassword(this.getUsers().getUserName(), this.getUsers().getUserPassword());
            //Alumno alumno_to_modified = alumnoRNbeanLocal.findByAlumno(this.getAlumno().getMatricula());
            //System.out.println("el objeto es:" + alumno_to_modified.getMatricula());
            
           alumnoRNbeanLocal.edit(this.getAlumno());
           alumnoCarrera.setAlumno(this.getAlumno());
           // alumnoCarrera.setId(this.alumnoCarrera.getId());
           aluCar= alumnoCarreraRNbeanLocal.findByAlumno(this.getAlumnoCarrera());
           //aluCar = alumnoCarreraRNbeanLocal.findByAlumnoCarrera(this.getAlumno().getId(),alumnoCarrera.getCarrera().getId());
           if(aluCar == null){
           System.out.println("somos muy buenos"+ aluCar.getId()+ aluCar.getCarrera()+ aluCar.getAlumno());
           }
           else {
          System.out.println("no loco"+ aluCar.getId()+ aluCar.getCarrera()+ aluCar.getAlumno());

           }
           
           alumnoCarrera.setAlumno(alumno);
           alumnoCarrera.setId(aluCar.getId());
           
           alumnoCarreraRNbeanLocal.edit(alumnoCarrera);
            //usersRNLocal.edit(this.getUsers());

            sMensaje = "Información actualizada con éxito";
            severity = FacesMessage.SEVERITY_INFO;

            //elimino y agrego el organismo modificado a la lista
            //int iPos = this.getListaAlumnoBean().getLstUsers().indexOf(this.getUsers());
           int iPos = this.getListaAlumnoBean().getLstAlumno().indexOf(this.getAlumno());

            this.getListaAlumnoBean().getLstAlumno().remove(iPos);
            this.getListaAlumnoBean().getLstAlumno().add(iPos, this.getAlumno());

            //this.getCbAction().setValue("Update");
            this.getCbAction().setDisabled(true);

            //this.setbCamposRequeridos(false);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgAlumno').hide();");
        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al actualizar: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, "");
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }
     public void activate(Boolean bEstado) {
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;

        try {
             alumnoRNbeanLocal.activate(this.getAlumno(), bEstado);
            

            //elimino el organismo de la lista
            //int iPos = this.getListaAlumnoBean().getLstAlumno()).indexOf(this.getAlumno());
            int iPos = this.getListaAlumnoBean().getLstAlumno().indexOf(this.getAlumno());

            this.setAlumno(this.getListaAlumnoBean().getLstAlumno().get(iPos));
            this.getAlumno().setActive(bEstado);
            
            this.getListaAlumnoBean().getLstAlumno().remove(iPos);
            this.getListaAlumnoBean().getLstAlumno().add(iPos, this.getAlumno());

            if (!bEstado) {
                sMensaje = "Alumno desactivado con éxito";
            } else {
                sMensaje = "Alumno reactivado con éxito ";
            }
            severity = FacesMessage.SEVERITY_INFO;

            this.getCbAction().setDisabled(true);

            //limíar campos
            this.clear();
            //this.setbCamposRequeridos(false);

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "An error ocurred during activation: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }
     
     private void clear() {
        this.setAlumno(new Alumno());
        
    }
     
     public String aluStyleClass(Alumno alu) {
         
    if(alu.getId().equals(3L)){
          return "colored";
    } 
    
    return null;
}
}