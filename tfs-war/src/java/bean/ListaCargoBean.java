/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;


import RN.CargoRNLocal;
import entidad.Cargo;
import entidad.Docente;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author cristian
 */
@ManagedBean
@SessionScoped
public class ListaCargoBean {
     @EJB
    private CargoRNLocal cargoRNLocal;
    private List<Cargo> lstCargo;
     private List<SelectItem> lstSICargos;
      private int iActionBtnSelect;

    /**
     * Creates a new instance of ListaCarreraBean
     */
    public ListaCargoBean() {
        this.lstCargo = new ArrayList<Cargo>();
    }

    @PostConstruct
    private void init() {
        this.limpiar();
        this.cargar_cargos();
         cargar_SI_cargos();
    }

    public List<Cargo> getLstCargo() {
        return lstCargo;
    }

    public void setLstCargo(List<Cargo> lstCargo) {
        this.lstCargo = lstCargo;
    }

    

    public void limpiar() {
        this.lstCargo = new ArrayList<Cargo>();
    }

    public List<SelectItem> getLstSICargos() {
        return lstSICargos;
    }

    public void setLstSICargos(List<SelectItem> lstSICargos) {
        this.lstSICargos = lstSICargos;
    }

    public CargoRNLocal getCargoRNLocal() {
        return cargoRNLocal;
    }

    public void setCargoRNLocal(CargoRNLocal cargoRNLocal) {
        this.cargoRNLocal = cargoRNLocal;
    }

    public int getiActionBtnSelect() {
        return iActionBtnSelect;
    }

    public void setiActionBtnSelect(int iActionBtnSelect) {
        this.iActionBtnSelect = iActionBtnSelect;
    }

    
    
    /**
     * Creates a new instance of ListaCargoBean
     */
    

    public void cargar_cargos() {
         try {
            this.setLstCargo(cargoRNLocal.findAll());
        } catch (Exception ex) {
            System.out.println("Error al cargar cargos -> Causa: " + ex.getMessage());
        }
    }

    public void cargar_SI_cargos() {
        this.setLstSICargos(new ArrayList<SelectItem>());

        for (Cargo d : this.getLstCargo()) {
            SelectItem si = new SelectItem(d, d.getDescripcion());
           
            this.getLstSICargos().add(si);
        }
    
    }
    
}
