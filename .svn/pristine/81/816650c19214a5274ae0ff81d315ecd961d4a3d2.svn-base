/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import RN.ProfesionRNLocal;

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
public class ProfesionBean {

    
    @ManagedProperty("#{listaProfesionBean}")
    private ListaProfesionBean listaProfesionBean;
    
    private Profesion profesion;
        
    @EJB
    private ProfesionRNLocal profesionRNbeanLocal;
    
    
    
    public ProfesionBean() {
        this.profesion = new Profesion();
       }

    public ListaProfesionBean getListaProfesionBean() {
        return listaProfesionBean;
    }

    public void setListaProfesionBean(ListaProfesionBean listaProfesionBean) {
        this.listaProfesionBean = listaProfesionBean;
    }

    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }
    
    public void create() {
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {
            profesionRNbeanLocal.create(profesion);
            
            sMensaje = "El dato fue guardado";
            severity = FacesMessage.SEVERITY_INFO;

            //agregar a la lista
            this.getListaProfesionBean().getLstProfesion().add(profesion);
            

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
        this.profesion = new Profesion();
    }
    
}
