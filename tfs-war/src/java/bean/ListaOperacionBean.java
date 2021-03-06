/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import RN.CalificacionRNLocal;
import RN.OperacionRNLocal;
import entidad.Calificacion;
import entidad.Operacion;
import entidad.ProyectoAsesor;
import entidad.ProyectoCodirector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Trossero
 */
@ManagedBean
@SessionScoped
public class ListaOperacionBean implements Serializable {

    
     @EJB
    private OperacionRNLocal operacionRNbeanlocal;
    private List<Operacion> lstOperacion;
    
    private List<SelectItem> lstSIOperacion;
    
    public Operacion selectedOpe;
     private List<ProyectoAsesor> lstProyAsesor;
     private List<ProyectoCodirector> lstProyCodirector;
    private ProyectoAsesor proy_asesor;
    private List<SelectItem> lstSIasesor;
    private ProyectoCodirector proy_codirector;
    private List<SelectItem> lstSIcodirector;
     private int iActionBtnSelect;
     
    public ListaOperacionBean() {
        lstOperacion = new ArrayList<Operacion>();
    }

 @PostConstruct
    void init() {
        System.out.println("PostConstructor ListaOperacionBean");
        this.cargar_Operaciones();
        this.cargar_SI_Operaciones();
        
        
        
    }
    
    public OperacionRNLocal getOperacionRNbeanlocal() {
        return operacionRNbeanlocal;
    }

    public void setOperacionRNbeanlocal(OperacionRNLocal operacionRNbeanlocal) {
        this.operacionRNbeanlocal = operacionRNbeanlocal;
    }

    public List<Operacion> getLstOperacion() {
        return lstOperacion;
    }

    public void setLstOperacion(List<Operacion> lstOperacion) {
        this.lstOperacion = lstOperacion;
    }

    public List<SelectItem> getLstSIOperacion() {
        return lstSIOperacion;
    }

    public void setLstSIOperacion(List<SelectItem> lstSIOperacion) {
        this.lstSIOperacion = lstSIOperacion;
    }

    public Operacion getSelectedOpe() {
        return selectedOpe;
    }

    public void setSelectedOpe(Operacion selectedOpe) {
        this.selectedOpe = selectedOpe;
    }

    public List<ProyectoAsesor> getLstProyAsesor() {
        return lstProyAsesor;
    }

    public void setLstProyAsesor(List<ProyectoAsesor> lstProyAsesor) {
        this.lstProyAsesor = lstProyAsesor;
    }

    public ProyectoCodirector getProy_codirector() {
        return proy_codirector;
    }

    public void setProy_codirector(ProyectoCodirector proy_codirector) {
        this.proy_codirector = proy_codirector;
    }

    public List<SelectItem> getLstSIcodirector() {
        return lstSIcodirector;
    }

    public void setLstSIcodirector(List<SelectItem> lstSIcodirector) {
        this.lstSIcodirector = lstSIcodirector;
    }
    

    public List<ProyectoCodirector> getLstProyCodirector() {
        return lstProyCodirector;
    }

    public void setLstProyCodirector(List<ProyectoCodirector> lstProyCodirector) {
        this.lstProyCodirector = lstProyCodirector;
    }
    

    public ProyectoAsesor getProy_asesor() {
        return proy_asesor;
    }

    public void setProy_asesor(ProyectoAsesor proy_asesor) {
        this.proy_asesor = proy_asesor;
    }

    public List<SelectItem> getLstSIasesor() {
        return lstSIasesor;
    }

    public void setLstSIasesor(List<SelectItem> lstSIasesor) {
        this.lstSIasesor = lstSIasesor;
    }

    public int getiActionBtnSelect() {
        return iActionBtnSelect;
    }

    public void setiActionBtnSelect(int iActionBtnSelect) {
        this.iActionBtnSelect = iActionBtnSelect;
    }
    
    
    public void cargar_Operaciones() {
        try {
            this.setLstOperacion(this.operacionRNbeanlocal.findAll());
            
            System.out.println("EL LISTADO ES "+ lstOperacion);
        } catch (Exception ex) {
            System.out.println("Error al cargar operaciones " + ex.toString());
            
        }
    }

    public void cargar_SI_Operaciones() {
        
        System.out.println("entroooooooo");
        this.setLstSIOperacion(new ArrayList<SelectItem>());

        for (Operacion o : this.getLstOperacion()) {
            SelectItem si = new SelectItem(o, o.getOperacion());
            this.getLstSIOperacion().add(si);
            
        }
         System.out.println("EL LISTADO SI ES "+ lstSIOperacion);
    }//fin for
      public void cargar_SI_asesor() {
        System.out.println("si pasa para cargar los asesores");
        this.setLstSIasesor(new ArrayList<SelectItem>());

        for (ProyectoAsesor d : this.getLstProyAsesor()) {
            System.out.println("los archivos son" + this.getLstProyAsesor());

            SelectItem si = new SelectItem(d, d.getProfesional().getApellido());

            this.getLstSIasesor().add(si);
            System.out.println("el selectitem" + si);

        }

    }
          public void cargar_SI_codirector() {
        System.out.println("si pasa para cargar los codirectores");
        this.setLstSIcodirector(new ArrayList<SelectItem>());

        for (ProyectoCodirector d : this.getLstProyCodirector()) {
            System.out.println("los CODIRECTORES son" + this.getLstProyCodirector());

            SelectItem si = new SelectItem(d, d.getProfesional().getApellido());

            this.getLstSIcodirector().add(si);
            System.out.println("el selectitem DE CODIRECTOR ES" + si);

        }

    }
    public void limpiar() {
        lstOperacion = new ArrayList<Operacion>();
    }
    
}
