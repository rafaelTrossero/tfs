/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import RN.ProfesionRNLocal;
import entidad.Profesion;
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
public class ListaProfesionBean {

   @EJB
   private ProfesionRNLocal profesionRNbeanLocal;
   private List<Profesion> lstProfesion;
   private List<SelectItem> lstSIProfesion;
   
    private int iActionBtnSelect;
   
   
    public ListaProfesionBean() {
        System.out.println("Constructor ListaProfesionBean");
        lstProfesion = new ArrayList<Profesion>();
    }
    
     @PostConstruct
    void init() {
        System.out.println("PostConstructor ListaProfesionBean");
        cargar_profesiones();
        cargar_SI_profesiones();
        System.out.println("Profesiones: " + this.getLstProfesion());
    }

    public List<Profesion> getLstProfesion() {
        return lstProfesion;
    }

    public int getiActionBtnSelect() {
        return iActionBtnSelect;
    }

    public void setiActionBtnSelect(int iActionBtnSelect) {
        this.iActionBtnSelect = iActionBtnSelect;
    }

    public void setLstProfesion(List<Profesion> lstProfesion) {
        this.lstProfesion = lstProfesion;
    }

    public List<SelectItem> getLstSIProfesion() {
        return lstSIProfesion;
    }

    public void setLstSIProfesion(List<SelectItem> lstSIProfesion) {
        this.lstSIProfesion = lstSIProfesion;
    }

    public void cargar_profesiones() {
        try {
            this.setLstProfesion(this.profesionRNbeanLocal.findAll());
            
        } catch (Exception ex) {
            System.out.println("Error al cargar Profesiones " + ex.toString());
        }
    }

    public void cargar_SI_profesiones() {
        this.setLstSIProfesion(new ArrayList<SelectItem>());
        

        for (Profesion p : this.getLstProfesion()) {
            SelectItem si = new SelectItem(p, p.getDescripcion());
            this.getLstSIProfesion().add(si);
        }
    }//fin for

    public void limpiar() {
        lstProfesion = new ArrayList<Profesion>();
    }
}
