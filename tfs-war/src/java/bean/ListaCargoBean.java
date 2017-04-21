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

    
    
    /**
     * Creates a new instance of ListaCargoBean
     */
    

    private void cargar_cargos() {
         try {
            this.setLstCargo(cargoRNLocal.findAll());
        } catch (Exception ex) {
            System.out.println("Error al cargar cargos -> Causa: " + ex.getMessage());
        }
    }

    private void cargar_SI_cargos() {
        this.setLstSICargos(new ArrayList<SelectItem>());

        for (Cargo d : this.getLstCargo()) {
            SelectItem si = new SelectItem(d, d.getDescripcion());
           
            this.getLstSICargos().add(si);
        }
    
    }
    
}
