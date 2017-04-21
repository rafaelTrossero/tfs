/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import RN.EspecialidadRNLocal;
import RN.ProfesionRNLocal;
import entidad.Especialidad;
import entidad.Profesion;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Trossero
 */
@ManagedBean
@RequestScoped
public class EspecialidadBean {

      
    @ManagedProperty("#{listaEspecialidadBean}")
    private ListaEspecialidadBean listaEspecialidadBean;
    
    private Especialidad especialidad;
        
    @EJB
    private EspecialidadRNLocal especialidadRNbeanLocal;
    
    
    
    public EspecialidadBean() {
        this.especialidad = new Especialidad();
       
    }

    public ListaEspecialidadBean getListaEspecialidadBean() {
        return listaEspecialidadBean;
    }

    public void setListaEspecialidadBean(ListaEspecialidadBean listaEspecialidadBean) {
        this.listaEspecialidadBean = listaEspecialidadBean;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public EspecialidadRNLocal getEspecialidadRNbeanLocal() {
        return especialidadRNbeanLocal;
    }

    public void setEspecialidadRNbeanLocal(EspecialidadRNLocal especialidadRNbeanLocal) {
        this.especialidadRNbeanLocal = especialidadRNbeanLocal;
    }
    
     public void create() {
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {
            especialidadRNbeanLocal.create(especialidad);
            
            sMensaje = "El dato fue guardado";
            severity = FacesMessage.SEVERITY_INFO;

            //agregar a la lista
            this.getListaEspecialidadBean().getLstEspecialidad().add(especialidad);
            

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
    
    private void limpiar() {
        this.especialidad = new Especialidad();
    }
    
}
