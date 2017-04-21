/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import RN.DedicacionRNLocal;
import entidad.Dedicacion;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Trossero
 */
@ManagedBean
@SessionScoped
public class ListaDedicacionBean {

 @EJB
    private DedicacionRNLocal dedicacionesRNbeanLocal;
    private List<Dedicacion> lstDedicaciones;
      private List<SelectItem> lstSIDedicacion;

   
      
    public ListaDedicacionBean() {
        this.lstDedicaciones = new ArrayList<Dedicacion>();
    }

    @PostConstruct
    private void init() {
        this.limpiar();
        this.cargar_dedicaciones();
        this.cargar_SI_dedicaciones();
    }

    public DedicacionRNLocal getDedicacionesRNbeanLocal() {
        return dedicacionesRNbeanLocal;
    }

    public void setDedicacionesRNbeanLocal(DedicacionRNLocal dedicacionesRNbeanLocal) {
        this.dedicacionesRNbeanLocal = dedicacionesRNbeanLocal;
    }

    public List<Dedicacion> getLstDedicaciones() {
        return lstDedicaciones;
    }

    public void setLstDedicaciones(List<Dedicacion> lstDedicaciones) {
        this.lstDedicaciones = lstDedicaciones;
    }

    public List<SelectItem> getLstSIDedicacion() {
        return lstSIDedicacion;
    }

    public void setLstSIDedicacion(List<SelectItem> lstSIDedicacion) {
        this.lstSIDedicacion = lstSIDedicacion;
    }

    

    public void cargar_dedicaciones() {
        try {
            this.setLstDedicaciones(dedicacionesRNbeanLocal.findAll());
        } catch (Exception ex) {
            System.out.println("Error al cargar dedicaciones -> Causa: " + ex.getMessage());
        }
    }
    
    public void cargar_SI_dedicaciones() {
        this.setLstSIDedicacion(new ArrayList<SelectItem>());

        for (Dedicacion d : this.getLstDedicaciones()) {
            SelectItem si = new SelectItem(d, d.getDescripcion());
            this.getLstSIDedicacion().add(si);
        }
    }//fin for
    
     public void limpiar() {
         this.lstDedicaciones = new ArrayList<Dedicacion>();
    }
}
