/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import RN.ProfesionalRNLocal;
import entidad.Profesional;
import java.io.Serializable;
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
public class ListaProfesionalBean implements Serializable {

    /**
     * Creates a new instance of ListaProfesionalBean
     */
    
    @EJB
    private ProfesionalRNLocal profesionalRNbeanLocal;
    
    private List<Profesional> lstProfesionalActivo;
     private List<Profesional> lstProfesional;
    private List<SelectItem> lstSIProfesional;
    private List<SelectItem> lstSIProfesionalActivo;
    private List<Profesional> selectedCodirector; 
    private List<Profesional> selectedAsesor;
    private int iActionBtnSelect;

    public ListaProfesionalBean() {
        System.out.println("Constructor ListaProfesionalBean");
        lstProfesional = new ArrayList<Profesional>();
    }

    public ProfesionalRNLocal getProfesionalRNbeanLocal() {
        return profesionalRNbeanLocal;
    }

    public void setProfesionalRNbeanLocal(ProfesionalRNLocal profesionalRNbeanLocal) {
        this.profesionalRNbeanLocal = profesionalRNbeanLocal;
    }

    public List<Profesional> getLstProfesional() {
        return lstProfesional;
    }

    public List<Profesional> getLstProfesionalActivo() {
        return lstProfesionalActivo;
    }

    public void setLstProfesionalActivo(List<Profesional> lstProfesionalActivo) {
        this.lstProfesionalActivo = lstProfesionalActivo;
    }

    public List<SelectItem> getLstSIProfesionalActivo() {
        return lstSIProfesionalActivo;
    }

    public void setLstSIProfesionalActivo(List<SelectItem> lstSIProfesionalActivo) {
        this.lstSIProfesionalActivo = lstSIProfesionalActivo;
    }

    public void setLstProfesional(List<Profesional> lstProfesional) {
        this.lstProfesional = lstProfesional;
    }

    public int getiActionBtnSelect() {
        return iActionBtnSelect;
    }

    public void setiActionBtnSelect(int iActionBtnSelect) {
        this.iActionBtnSelect = iActionBtnSelect;
    }

    public List<SelectItem> getLstSIProfesional() {
        return lstSIProfesional;
    }

    public void setLstSIProfesional(List<SelectItem> lstSIProfesional) {
        this.lstSIProfesional = lstSIProfesional;
    }

    public List<Profesional> getSelectedCodirector() {
        return selectedCodirector;
    }

    public void setSelectedCodirector(List<Profesional> selectedCodirector) {
        this.selectedCodirector = selectedCodirector;
    }

    public List<Profesional> getSelectedAsesor() {
        return selectedAsesor;
    }

    public void setSelectedAsesor(List<Profesional> selectedAsesor) {
        this.selectedAsesor = selectedAsesor;
    }

   
    
     @PostConstruct
    void init() {
        System.out.println("PostConstructor ListaProfesionalBean");
        this.limpiar();
        cargar_profesionales();
        cargar_SI_profesionales();
        cargar_profesionales_activos();
        cargar_SI_profesionales_activos();
        System.out.println("Profesionales: " + this.getLstProfesional());
    }

    public void cargar_profesionales() {
       try {
            this.setLstProfesional(this.profesionalRNbeanLocal.findAll());
        } catch (Exception ex) {
            System.out.println("Error al cargar Profesionales " + ex.toString());
        }
    }
     public void cargar_profesionales_activos() {
       try {
            this.setLstProfesionalActivo(this.profesionalRNbeanLocal.findAllActivo());
        } catch (Exception ex) {
            System.out.println("Error al cargar Profesionales activos " + ex.toString());
        }
    }
    
    public void cargar_SI_profesionales() {
        this.setLstSIProfesional(new ArrayList<SelectItem>());

        for (Profesional p : this.getLstProfesional()) {
            SelectItem si = new SelectItem(p, p.getApellido()+","+ p.getNombre());
            this.getLstSIProfesional().add(si);
        }
    }
    
      public void cargar_SI_profesionales_activos() {
        this.setLstSIProfesionalActivo(new ArrayList<SelectItem>());

        for (Profesional a : this.getLstProfesionalActivo()) {
            SelectItem pi = new SelectItem(a, a.getApellido()+","+ a.getNombre());
            this.getLstSIProfesionalActivo().add(pi);
        }
    }
    public void limpiar() {
        lstProfesional = new ArrayList<Profesional>();
    }
   
    
}
