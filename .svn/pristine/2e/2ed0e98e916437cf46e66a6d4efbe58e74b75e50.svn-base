/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.CarreraRNLocal;
import RN.ComisionRNLocal;
import entidad.Carrera;
import entidad.Comision;
import javax.inject.Named;
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
 * @author WalterVergara
 */
@ManagedBean
@SessionScoped
public class ListaComisionBean implements Serializable {

    @EJB
    private ComisionRNLocal comisionRNbeanLocal;
    private List<Comision> lstComision;
    private List<SelectItem> lstSIComision;
    private int iActionBtnSelect;
   
    private List<Comision> lstComisionActiva;
    private List<SelectItem> lstSIComisionActiva;

    public ListaComisionBean() {
        this.lstComision = new ArrayList<Comision>();
    }

    @PostConstruct
    private void init() {
        this.limpiar();
        this.cargar_comision();
        this.cargar_SI_comisiones();
    }

    public List<Comision> getLstComision() {
        return lstComision;
    }

    public void setLstComision(List<Comision> lstComision) {
        this.lstComision = lstComision;
    }

    public List<Comision> getLstComisionActiva() {
        return lstComisionActiva;
    }

    public void setLstComisionActiva(List<Comision> lstComisionActiva) {
        this.lstComisionActiva = lstComisionActiva;
    }

    public List<SelectItem> getLstSIComisionActiva() {
        return lstSIComisionActiva;
    }

    public void setLstSIComisionActiva(List<SelectItem> lstSIComisionActiva) {
        this.lstSIComisionActiva = lstSIComisionActiva;
    }
    

    public List<SelectItem> getLstSIComision() {
        return lstSIComision;
    }

    public void setLstSIComision(List<SelectItem> lstSIComision) {
        this.lstSIComision = lstSIComision;
    }

    public ComisionRNLocal getComisionRNbeanLocal() {
        return comisionRNbeanLocal;
    }

    public void setComisionRNbeanLocal(ComisionRNLocal comisionRNbeanLocal) {
        this.comisionRNbeanLocal = comisionRNbeanLocal;
    }

    public int getiActionBtnSelect() {
        return iActionBtnSelect;
    }

    public void setiActionBtnSelect(int iActionBtnSelect) {
        this.iActionBtnSelect = iActionBtnSelect;
    }
    
    

    public void limpiar() {

        this.lstComision = new ArrayList<Comision>();
    }

    public void cargar_comision() {
        try {

            this.setLstComision(comisionRNbeanLocal.findAll());
        } catch (Exception ex) {
            System.out.println("Error al cargar comision -> Causa: "
                    + ex.getMessage());
        }
    }

    public void cargar_SI_comisiones() {

        this.setLstSIComision(new ArrayList<SelectItem>());

        for (Comision d : this.getLstComision()) {
            SelectItem si = new SelectItem(d, d.getComision());
            this.getLstSIComision().add(si);
        }
    }
       public void cargar_comisiones_activas() {
        try {
            this.setLstComisionActiva(this.comisionRNbeanLocal.findAllActivo());
        } catch (Exception ex) {
            System.out.println("Error al cargar Departamentos activos " + ex.toString());
        }
    }
     
     public void cargar_SI_comisiones_activas() {
        this.setLstSIComisionActiva(new ArrayList<SelectItem>());

        for (Comision a : this.getLstComisionActiva()) {
            SelectItem ai = new SelectItem(a,a.getComision());
            this.getLstSIComisionActiva().add(ai);
        }
    }//fin for

}
