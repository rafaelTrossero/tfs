/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.FechasExamenRNLocal;
import entidad.FechasExamen;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author RafaTrossero
 */
@ManagedBean
@SessionScoped
public class ListaFechasExamenBean implements Serializable {

    /**
     * Creates a new instance of ListaFechasExamenBean
     */
    @EJB
    private FechasExamenRNLocal fechasExamenRNLocal;
    
     private List<FechasExamen> lstFechasExamen;
     private int iActionBtnSelect;
     
    public ListaFechasExamenBean() {
        
        
    }

    @PostConstruct
    private void init() {
        this.cargar_fechasExamen();
    }
    public FechasExamenRNLocal getFechasExamenRNLocal() {
        return fechasExamenRNLocal;
    }

    public void setFechasExamenRNLocal(FechasExamenRNLocal fechasExamenRNLocal) {
        this.fechasExamenRNLocal = fechasExamenRNLocal;
    }

    public List<FechasExamen> getLstFechasExamen() {
        return lstFechasExamen;
    }

    public void setLstFechasExamen(List<FechasExamen> lstFechasExamen) {
        this.lstFechasExamen = lstFechasExamen;
    }

    public int getiActionBtnSelect() {
        return iActionBtnSelect;
    }

    public void setiActionBtnSelect(int iActionBtnSelect) {
        this.iActionBtnSelect = iActionBtnSelect;
    }
    
    public void cargar_fechasExamen() {
        try {
            System.out.println("entrooo1222121112121212");
            this.setLstFechasExamen(fechasExamenRNLocal.findAll());
        } catch (Exception ex) {
            System.out.println("Error al cargar fechas de examen -> Causa: "
                    + ex.getMessage());
        }
    }
}
