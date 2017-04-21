/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.AutoridadesDepartamentoRNLocal;
import entidad.AutoridadesDepartamento;
import java.util.ArrayList;
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
public class ListaAutoridadesDeptoInfBean {

    /**
     * Creates a new instance of ListaAutoridadesDeptoInfBean
     */
    
    @EJB
    private AutoridadesDepartamentoRNLocal autoridadesRNbeanLocal;
    private int iActionBtnSelect;
    private List<AutoridadesDepartamento> lstAutoridades;
    
    
    public ListaAutoridadesDeptoInfBean() {
        
         this.lstAutoridades = new ArrayList<AutoridadesDepartamento>();
    }
     @PostConstruct
    private void init() {
        
        this.cargar_autoridades();
        
    }

    public int getiActionBtnSelect() {
        return iActionBtnSelect;
    }

    public void setiActionBtnSelect(int iActionBtnSelect) {
        this.iActionBtnSelect = iActionBtnSelect;
    }

    public List<AutoridadesDepartamento> getLstAutoridades() {
        return lstAutoridades;
    }

    public void setLstAutoridades(List<AutoridadesDepartamento> lstAutoridades) {
        this.lstAutoridades = lstAutoridades;
    }
    
     public void cargar_autoridades() {
        try {

            this.setLstAutoridades(autoridadesRNbeanLocal.findAll());
            
        } catch (Exception ex) {
            System.out.println("Error al cargar autoridades -> Causa: "
                    + ex.getMessage());
        }
    }
    
}
