/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.ProyectosInvestigacionRNLocal;
import entidad.ProyectosInvestigacion;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author WalterVergara
 */
@ManagedBean
@SessionScoped
public class ListaProyectosInvestigacionBean {
   @EJB
    private ProyectosInvestigacionRNLocal proyectoInvestigacionRNLocal;
    private List<ProyectosInvestigacion> lstProyectoInvestigacion;
    private List<SelectItem> lstSIProyectoInvestigacion;
    private List<ProyectosInvestigacion> lstProyectosInvestigacionActiva;
    private List<SelectItem> lstSIProyectosInvestigacionActiva;
     private ProyectosInvestigacion selectedProyectoInvestigacion = new ProyectosInvestigacion();
    
    private int iActionBtnSelect;
    /**
     * Creates a new instance of ListaProyectosInvestigacion
     */
    
    public ListaProyectosInvestigacionBean() {
        this.lstProyectoInvestigacion = new ArrayList<ProyectosInvestigacion>();
         this.lstProyectosInvestigacionActiva = new ArrayList<ProyectosInvestigacion>();
         selectedProyectoInvestigacion = new ProyectosInvestigacion();
        
    }
    @PostConstruct
    void init() {
        System.out.println("PostConstructor ListaProyectosInvestigacionBean");
       
        this.cargar_ProyectosInvestigacion();
        
        this.cargar_SI_proyectosInvestigacion();
        
         this.cargar_proyectosInvestigacion_activas();
       
        this.cargar_SI_proyectosInvestigacion_activas();
        System.out.println("Departamentos: " + this.getLstProyectoInvestigacion());
    }

    public ProyectosInvestigacion getSelectedProyectoInvestigacion() {
        return selectedProyectoInvestigacion;
    }

    public void setSelectedProyectoInvestigacion(ProyectosInvestigacion selectedProyectoInvestigacion) {
        this.selectedProyectoInvestigacion = selectedProyectoInvestigacion;
    }

    public ProyectosInvestigacionRNLocal getProyectoInvestigacionRNLocal() {
        return proyectoInvestigacionRNLocal;
    }

    public void setProyectoInvestigacionRNLocal(ProyectosInvestigacionRNLocal proyectoInvestigacionRNLocal) {
        this.proyectoInvestigacionRNLocal = proyectoInvestigacionRNLocal;
    }

    

    public List<ProyectosInvestigacion> getLstProyectoInvestigacion() {
        return lstProyectoInvestigacion;
    }

    public void setLstProyectoInvestigacion(List<ProyectosInvestigacion> lstProyectoInvestigacion) {
        this.lstProyectoInvestigacion = lstProyectoInvestigacion;
    }

    public List<SelectItem> getLstSIProyectoInvestigacion() {
        return lstSIProyectoInvestigacion;
    }

    public void setLstSIProyectoInvestigacion(List<SelectItem> lstSIProyectoInvestigacion) {
        this.lstSIProyectoInvestigacion = lstSIProyectoInvestigacion;
    }

    public List<ProyectosInvestigacion> getLstProyectosInvestigacionActiva() {
        return lstProyectosInvestigacionActiva;
    }

    public void setLstProyectosInvestigacionActiva(List<ProyectosInvestigacion> lstProyectosInvestigacionActiva) {
        this.lstProyectosInvestigacionActiva = lstProyectosInvestigacionActiva;
    }

    public List<SelectItem> getLstSIProyectosInvestigacionActiva() {
        return lstSIProyectosInvestigacionActiva;
    }

    public void setLstSIProyectosInvestigacionActiva(List<SelectItem> lstSIProyectosInvestigacionActiva) {
        this.lstSIProyectosInvestigacionActiva = lstSIProyectosInvestigacionActiva;
    }

   

    public int getiActionBtnSelect() {
        return iActionBtnSelect;
    }

    public void setiActionBtnSelect(int iActionBtnSelect) {
        this.iActionBtnSelect = iActionBtnSelect;
    }
    
    public void limpiar() {
        this.lstProyectoInvestigacion = new ArrayList<ProyectosInvestigacion>();
        this.lstProyectosInvestigacionActiva = new ArrayList<ProyectosInvestigacion>();
    }

    public void cargar_ProyectosInvestigacion() {
        try {
            this.setLstProyectoInvestigacion(proyectoInvestigacionRNLocal.findAll());
        } catch (Exception ex) {
            System.out.println("Error al cargar carreras -> Causa: "
                    + ex.getMessage());
        }
    }

    public void cargar_SI_proyectosInvestigacion() {
        this.setLstSIProyectoInvestigacion(new ArrayList<SelectItem>());

        for (ProyectosInvestigacion d : this.getLstProyectoInvestigacion()) {
            SelectItem si = new SelectItem(d, d.getTitulo());
            this.getLstSIProyectoInvestigacion().add(si);
        }
    }
     public void cargar_proyectosInvestigacion_activas() {
        try {
            this.setLstProyectosInvestigacionActiva(this.proyectoInvestigacionRNLocal.findAllActivo());
        } catch (Exception ex) {
            System.out.println("Error al cargar Departamentos activos " + ex.toString());
        }
    }
     
     public void cargar_SI_proyectosInvestigacion_activas() {
        this.setLstSIProyectosInvestigacionActiva(new ArrayList<SelectItem>());

        for (ProyectosInvestigacion a : this.getLstProyectosInvestigacionActiva()) {
            SelectItem ai = new SelectItem(a,a.getTitulo());
            this.getLstSIProyectosInvestigacionActiva().add(ai);
        }
    }//fin for
     
}
