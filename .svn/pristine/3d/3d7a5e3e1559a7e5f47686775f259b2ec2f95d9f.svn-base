/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.AlumnoCarreraRNLocal;
import entidad.AlumnoCarrera;
import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author WalterVergara
 */
@ManagedBean
@RequestScoped
public class AlumnoCarreraBean {

 @ManagedProperty("#{listaAlumnoCarreraBean}")
    private ListaAlumnoCarreraBean listaAlumnoCarreraBean;
    private AlumnoCarrera alumnoCarrera;
    
    @EJB
    private AlumnoCarreraRNLocal alumnoCarreraRNbeanLocal;
    
    
    public AlumnoCarreraBean() {
        
         this.alumnoCarrera = new AlumnoCarrera();
    }
    

    public ListaAlumnoCarreraBean getListaAlumnoCarreraBean() {
        return listaAlumnoCarreraBean;
    }

    public void setListaAlumnoCarreraBean(ListaAlumnoCarreraBean listaAlumnoCarreraBean) {
        this.listaAlumnoCarreraBean = listaAlumnoCarreraBean;
    }

    public AlumnoCarrera getAlumnoCarrera() {
        return alumnoCarrera;
    }

    public void setAlumnoCarrera(AlumnoCarrera alumnoCarrera) {
        this.alumnoCarrera = alumnoCarrera;
    }
    
    public void create() {
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {
            System.out.println("Paso por acá");
            alumnoCarreraRNbeanLocal.create(alumnoCarrera);
            sMensaje = "El dato fue guardado";
            severity = FacesMessage.SEVERITY_INFO;

            //agregar a la lista
            
            this.getListaAlumnoCarreraBean().getLstAlumno_Carrera().add(alumnoCarrera);
        

            //limpiar campos
            this.limpiar();

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Errooooooooor al crear: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }// fin crear
    
      private void limpiar() {
        this.alumnoCarrera = new AlumnoCarrera();
    }
    
}
