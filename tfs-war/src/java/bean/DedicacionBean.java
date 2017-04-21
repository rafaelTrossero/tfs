/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import RN.DedicacionRNLocal;
import entidad.Dedicacion;
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
public class DedicacionBean {

    
    @ManagedProperty("#{listaDedicacionBean}")
    private ListaDedicacionBean listaDedicacionBean;
    private Dedicacion dedicacion;
    
    @EJB
    private DedicacionRNLocal dedicacionesRNbeanLocal;

    /**
     * Creates a new instance of CarreraBean
     */
    public DedicacionBean() {
        this.dedicacion = new Dedicacion();
    }

    public ListaDedicacionBean getListaDedicacionBean() {
        return listaDedicacionBean;
    }

    public void setListaDedicacionBean(ListaDedicacionBean listaDedicacionBean) {
        this.listaDedicacionBean = listaDedicacionBean;
    }

    public Dedicacion getDedicacion() {
        return dedicacion;
    }

    public void setDedicacion(Dedicacion dedicacion) {
        this.dedicacion = dedicacion;
    }

   
    
    public void create() {
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {
            dedicacionesRNbeanLocal.create(dedicacion);
            sMensaje = "El dato fue guardado";
            severity = FacesMessage.SEVERITY_INFO;

            //agregar a la lista
            this.getListaDedicacionBean().getLstDedicaciones().add(dedicacion);

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
       this.dedicacion = new Dedicacion();
    }
    
}
