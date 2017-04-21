/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.DeptoRNLocal;
import entidad.Depto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author jmoreno
 */
@ManagedBean
@SessionScoped
public class ListaDeptoBean {

    @EJB
    private DeptoRNLocal departamentoRNbeanLocal;
    private List<Depto> lstDepartamento;
    private List<SelectItem> lstSIDepartamento;
    private List<Depto> lstDepartamentoActivo;
    private List<SelectItem> lstSIDepartamentoActivo;
      private int iActionBtnSelect;

    public ListaDeptoBean() {
        System.out.println("Constructor ListaDepartamentoBean");
        lstDepartamento = new ArrayList<Depto>();
        lstDepartamentoActivo= new ArrayList<Depto>();
    }

    @PostConstruct
    void init() {
        System.out.println("PostConstructor ListaDepartamentoBean");
        this.cargar_departamentos();
        this.cargar_SI_departamentos();
         this.cargar_departamentos_activos();
        this.cargar_SI_departamentos_activos();
        System.out.println("Departamentos: " + this.getLstDepartamento());
    }

    public List<Depto> getLstDepartamento() {
        return lstDepartamento;
    }

    public List<Depto> getLstDepartamentoActivo() {
        return lstDepartamentoActivo;
    }

    public void setLstDepartamentoActivo(List<Depto> lstDepartamentoActivo) {
        this.lstDepartamentoActivo = lstDepartamentoActivo;
    }

    public List<SelectItem> getLstSIDepartamentoActivo() {
        return lstSIDepartamentoActivo;
    }

    public void setLstSIDepartamentoActivo(List<SelectItem> lstSIDepartamentoActivo) {
        this.lstSIDepartamentoActivo = lstSIDepartamentoActivo;
    }

    public void setLstDepartamento(List<Depto> lstDepartamento) {
        this.lstDepartamento = lstDepartamento;
    }

    public List<SelectItem> getLstSIDepartamento() {
        return lstSIDepartamento;
    }

    public void setLstSIDepartamento(List<SelectItem> lstSIDepartamento) {
        this.lstSIDepartamento = lstSIDepartamento;
    }

    public DeptoRNLocal getDepartamentoRNbeanLocal() {
        return departamentoRNbeanLocal;
    }

    public void setDepartamentoRNbeanLocal(DeptoRNLocal departamentoRNbeanLocal) {
        this.departamentoRNbeanLocal = departamentoRNbeanLocal;
    }

    public int getiActionBtnSelect() {
        return iActionBtnSelect;
    }

    public void setiActionBtnSelect(int iActionBtnSelect) {
        this.iActionBtnSelect = iActionBtnSelect;
    }
    
    

    public void cargar_departamentos() {
        try {
            this.setLstDepartamento(this.departamentoRNbeanLocal.findAll());
        } catch (Exception ex) {
            System.out.println("Error al cargar Departamentos " + ex.toString());
        }
    }
    public void cargar_departamentos_activos() {
        try {
            this.setLstDepartamentoActivo(this.departamentoRNbeanLocal.findAllActivo());
        } catch (Exception ex) {
            System.out.println("Error al cargar Departamentos activos " + ex.toString());
        }
    }

    public void cargar_SI_departamentos() {
        this.setLstSIDepartamento(new ArrayList<SelectItem>());

        for (Depto d : this.getLstDepartamento()) {
            SelectItem si = new SelectItem(d, d.getDepartamento());
            this.getLstSIDepartamento().add(si);
        }
    }//fin for
     public void cargar_SI_departamentos_activos() {
        this.setLstSIDepartamentoActivo(new ArrayList<SelectItem>());

        for (Depto a : this.getLstDepartamentoActivo()) {
            SelectItem ai = new SelectItem(a,a.getDepartamento() );
            this.getLstSIDepartamentoActivo().add(ai);
        }
    }//fin for

    public void limpiar() {
        lstDepartamento = new ArrayList<Depto>();
    }
}
