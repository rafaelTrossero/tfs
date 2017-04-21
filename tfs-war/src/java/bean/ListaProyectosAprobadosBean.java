/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.DefensaFinalRNLocal;
import RN.PaisRNLocal;
import entidad.DefensaFinal;
import entidad.Pais;
import entidad.Proyecto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author WalterVergara
 */
@ManagedBean
@SessionScoped
public class ListaProyectosAprobadosBean {

    private List<DefensaFinal> lstProyectosAprobados;
    private List<SelectItem> lstSIProyectosAprobados;
    @EJB
    private DefensaFinalRNLocal defensafinalRNLocal;
    
    @EJB
    private DefensaFinalRNLocal defensafinalRNbeanLocal;
    
     public Date fecha1;
    public Date fecha2;
    
    public ListaProyectosAprobadosBean() {
        lstProyectosAprobados = new ArrayList<DefensaFinal>();
    }

    public List<DefensaFinal> getLstProyectosAprobados() {
        return lstProyectosAprobados;
    }

    public void setLstProyectosAprobados(List<DefensaFinal> lstProyectosAprobados) {
        this.lstProyectosAprobados = lstProyectosAprobados;
    }

    public List<SelectItem> getLstSIProyectosAprobados() {
        return lstSIProyectosAprobados;
    }

    public void setLstSIProyectosAprobados(List<SelectItem> lstSIProyectosAprobados) {
        this.lstSIProyectosAprobados = lstSIProyectosAprobados;
    }

    public DefensaFinalRNLocal getDefensafinalRNLocal() {
        return defensafinalRNLocal;
    }

    public void setDefensafinalRNLocal(DefensaFinalRNLocal defensafinalRNLocal) {
        this.defensafinalRNLocal = defensafinalRNLocal;
    }

    public Date getFecha1() {
        return fecha1;
    }

    public void setFecha1(Date fecha1) {
        this.fecha1 = fecha1;
    }

    public Date getFecha2() {
        return fecha2;
    }

    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
    }
    
    public void cargarProyectosAprobadoslista() {
        try {
            this.setLstProyectosAprobados(defensafinalRNLocal.findAll());
        } catch (Exception ex) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error al cargar los paises: " + ex,
                    null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin cargarNacionalidad
    
      public void cargarSIProyectosAprobadoslista() {

        this.setLstSIProyectosAprobados(new ArrayList<SelectItem>());

        for (DefensaFinal p : this.getLstProyectosAprobados()) {
            
                SelectItem si = new SelectItem(p, p.getProyecto().getTitulo());
                this.getLstSIProyectosAprobados().add(si);
            
        }//fin for
        System.out.println("Termino cargar Pais: " + this.getLstSIProyectosAprobados());
    }
    public void cargarProyectosAprobados() {
         
        try {
            System.out.println("ENTRO ACA A CARGAR PROYECTOS APROBAdOS");
            //this.setListaProyectosAprobadosBean((ListaProyectosAprobadosBean) this.defensafinalRNbeanLocal.findProyAprobados(this.fecha1, this.fecha2));
            //this.getListaProyectosAprobadosBean().setLstProyectosAprobados(this.defensafinalRNbeanLocal.findProyAprobados(this.fecha1, this.fecha2));
            
            System.out.println("fecha1 = "+ this.getFecha1() + "fecha2 = "+ fecha2 );
            this.setLstProyectosAprobados(this.defensafinalRNbeanLocal.findProyAprobados(this.fecha1, this.fecha2));
            System.out.println("ELLOS SON"+ this.lstProyectosAprobados );
        } catch (Exception ex) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error: " + ex.getMessage(), null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }

    }
}
