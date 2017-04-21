/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.CarreraRNLocal;
import entidad.Carrera;
import entidad.Depto;
import entidad.Especialidad;
import entidad.Profesion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author jmoreno
 */
@ManagedBean
@SessionScoped
public class ListaCarreraBean implements Serializable {

    @EJB
    private CarreraRNLocal carreraRNLocal;
    private List<Carrera> lstCarrera;
    private List<SelectItem> lstSICarrera;
    private List<Carrera> lstCarreraActiva;
    private List<SelectItem> lstSICarreraActiva;
    
    private int iActionBtnSelect;

    /**
     * Creates a new instance of ListaCarreraBean
     */
    public ListaCarreraBean() {
        this.lstCarrera = new ArrayList<Carrera>();
    }

    @PostConstruct
    private void init() {
      // this.limpiar();
    // this.cargar_carreras();
     //this.cargar_SI_carreras();
    }

    public List<SelectItem> getLstSICarrera() {
        return lstSICarrera;
    }

    public void setLstSICarrera(List<SelectItem> lstSICarrera) {
        this.lstSICarrera = lstSICarrera;
    }

    public List<Carrera> getLstCarrera() {
        return lstCarrera;
    }

    public void setLstCarrera(List<Carrera> lstCarrera) {
        this.lstCarrera = lstCarrera;
    }

    public List<Carrera> getLstCarreraActiva() {
        return lstCarreraActiva;
    }

    public void setLstCarreraActiva(List<Carrera> lstCarreraActiva) {
        this.lstCarreraActiva = lstCarreraActiva;
    }

    public List<SelectItem> getLstSICarreraActiva() {
        return lstSICarreraActiva;
    }

    public void setLstSICarreraActiva(List<SelectItem> lstSICarreraActiva) {
        this.lstSICarreraActiva = lstSICarreraActiva;
    }
    

    public int getiActionBtnSelect() {
        return iActionBtnSelect;
    }

    public void setiActionBtnSelect(int iActionBtnSelect) {
        this.iActionBtnSelect = iActionBtnSelect;
    }


    

    public void limpiar() {
        this.lstCarrera = new ArrayList<Carrera>();
        this.lstCarreraActiva = new ArrayList<Carrera>();
    }

    public void cargar_carreras() {
        try {
            this.setLstCarrera(carreraRNLocal.findAll());
        } catch (Exception ex) {
            System.out.println("Error al cargar carreras -> Causa: "
                    + ex.getMessage());
        }
    }

    public void cargar_SI_carreras() {
        this.setLstSICarrera(new ArrayList<SelectItem>());

        for (Carrera d : this.getLstCarrera()) {
            SelectItem si = new SelectItem(d, d.getCarrera());
            this.getLstSICarrera().add(si);
        }
    }
     public void cargar_carreras_activas() {
        try {
            this.setLstCarreraActiva(this.carreraRNLocal.findAllActivo());
        } catch (Exception ex) {
            System.out.println("Error al cargar Departamentos activos " + ex.toString());
        }
    }
     
     public void cargar_SI_carreras_activas() {
        this.setLstSICarreraActiva(new ArrayList<SelectItem>());

        for (Carrera a : this.getLstCarreraActiva()) {
            SelectItem ai = new SelectItem(a,a.getCarrera()+ " - Plan " +a.getPlan());
            this.getLstSICarreraActiva().add(ai);
        }
    }//fin for
     
     
     public void recuperarCarreras(ValueChangeEvent event) {

        try {

            if (event.getNewValue() != null) {
                if (!"0".equals(event.getNewValue().toString())) {
                    Depto departamento = (Depto) event.getNewValue();

                    System.out.println("departamento; " + departamento);
                    limpiar();
                    this.setLstCarreraActiva(this.carreraRNLocal.findAlldepartamento(departamento.getId()));
                   
                   this.cargar_SI_carreras_activas();
                  
                } else {
                    this.setLstCarreraActiva(new ArrayList<Carrera>());
                   
                   
                }

            }//fin if
        } catch (Exception ex) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error al cargar las carreras: " + ex,
                    null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }

        //this.cargarProvincias();
    }
}