/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.EstadoRNLocal;
import entidad.Estado;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author USUARIO
 */
@ManagedBean
@SessionScoped
public class ListaEstadoBean {

    /**
     * Creates a new instance of ListaEstadoBean
     */
     @EJB
    private EstadoRNLocal estadoRNbeanLocal;  
     private int iActionBtnSelect;
     private List<Estado> lstEstado;
   
    
      public ListaEstadoBean() {
    }
  

    @PostConstruct
    private void init() {
        
    }

  
    public int getiActionBtnSelect() {
        return iActionBtnSelect;
    }

    public void setiActionBtnSelect(int iActionBtnSelect) {
        this.iActionBtnSelect = iActionBtnSelect;
    }

    public List<Estado> getLstEstado() {
        return lstEstado;
    }

    public void setLstEstado(List<Estado> lstEstado) {
        this.lstEstado = lstEstado;
    }
    
    
    public void cargar_estados() {
        try {

            this.setLstEstado(estadoRNbeanLocal.findAll());
        } catch (Exception ex) {
            System.out.println("Error al cargar estados -> Causa: "
                    + ex.getMessage());
        }
    }
    
}
