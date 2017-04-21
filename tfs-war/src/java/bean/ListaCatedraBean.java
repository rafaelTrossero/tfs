/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.CatedraRNLocal;
import RN.DocenteCatedraRNLocal;
import RN.Horario_catedra_semanalRNLocal;
import RN.horario_catedraRNLocal;
import entidad.Carrera;
import entidad.Catedra;
import entidad.Depto;
import entidad.DocenteCatedra;
import entidad.Horario_catedra;
import entidad.Horario_semanal_catedra;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author RafaTrossero
 */
@ManagedBean
@SessionScoped
public class ListaCatedraBean implements Serializable {

    @EJB
    private CatedraRNLocal catedraRNLocal;
    @EJB
    private horario_catedraRNLocal horario_catedraRnLocal;
    @EJB
    private Horario_catedra_semanalRNLocal horariocatedra_semanalRNLocal;
    @EJB
    private DocenteCatedraRNLocal docenteCatedraRNLocal;
    private List<Catedra> lstCatedra;
    private List<SelectItem> lstSICatedra;
    private List<Catedra> lstCatedraActiva;
    private List<Catedra> lstCatedraCurso;
    private List<SelectItem> lstSICatedraActiva;
    private Catedra selectedCatedra = new Catedra();
    private Horario_catedra horario_catedra;
    private List<Horario_semanal_catedra> lstHorario_semanal_catedra;
    private List<DocenteCatedra> lstDocentCatedra;
    private List<SelectItem> lstSIcatedraLike;
    private int iActionBtnSelect;

    /**
     * Creates a new instance of ListaCatedraBean
     */
    public ListaCatedraBean() {
        this.lstCatedra = new ArrayList<Catedra>();
        this.lstCatedraCurso = new ArrayList<Catedra>();
        selectedCatedra = new Catedra();
        this.horario_catedra = new Horario_catedra();
        lstHorario_semanal_catedra = new ArrayList<Horario_semanal_catedra>();
        lstDocentCatedra = new ArrayList<DocenteCatedra>();
        lstSIcatedraLike = new ArrayList<SelectItem>();
    }

    public CatedraRNLocal getCatedraRNLocal() {
        return catedraRNLocal;
    }

    public horario_catedraRNLocal getHorario_catedraRnLocal() {
        return horario_catedraRnLocal;
    }

    public Horario_catedra_semanalRNLocal getHorariocatedra_semanalRNLocal() {
        return horariocatedra_semanalRNLocal;
    }

    public void setHorariocatedra_semanalRNLocal(Horario_catedra_semanalRNLocal horariocatedra_semanalRNLocal) {
        this.horariocatedra_semanalRNLocal = horariocatedra_semanalRNLocal;
    }

    public DocenteCatedraRNLocal getDocenteCatedraRNLocal() {
        return docenteCatedraRNLocal;
    }

    public void setDocenteCatedraRNLocal(DocenteCatedraRNLocal docenteCatedraRNLocal) {
        this.docenteCatedraRNLocal = docenteCatedraRNLocal;
    }

    public List<DocenteCatedra> getLstDocentCatedra() {
        return lstDocentCatedra;
    }

    public void setLstDocentCatedra(List<DocenteCatedra> lstDocentCatedra) {
        this.lstDocentCatedra = lstDocentCatedra;
    }

    public void setHorario_catedraRnLocal(horario_catedraRNLocal horario_catedraRnLocal) {
        this.horario_catedraRnLocal = horario_catedraRnLocal;
    }

    public List<Horario_semanal_catedra> getLstHorario_semanal_catedra() {
        return lstHorario_semanal_catedra;
    }

    public void setLstHorario_semanal_catedra(List<Horario_semanal_catedra> lstHorario_semanal_catedra) {
        this.lstHorario_semanal_catedra = lstHorario_semanal_catedra;
    }

    public void setCatedraRNLocal(CatedraRNLocal catedraRNLocal) {
        this.catedraRNLocal = catedraRNLocal;
    }

    public List<Catedra> getLstCatedra() {
        return lstCatedra;
    }

    public void setLstCatedra(List<Catedra> lstCatedra) {
        this.lstCatedra = lstCatedra;
    }

    public List<SelectItem> getLstSICatedra() {
        return lstSICatedra;
    }

    public void setLstSICatedra(List<SelectItem> lstSICatedra) {
        this.lstSICatedra = lstSICatedra;
    }

    public List<Catedra> getLstCatedraActiva() {
        return lstCatedraActiva;
    }

    public List<Catedra> getLstCatedraCurso() {
        return lstCatedraCurso;
    }

    public void setLstCatedraCurso(List<Catedra> lstCatedraCurso) {
        this.lstCatedraCurso = lstCatedraCurso;
    }

    public Catedra getSelectedCatedra() {
        return selectedCatedra;

    }

    public Horario_catedra getHorario_catedra() {
        return horario_catedra;
    }

    public void setHorario_catedra(Horario_catedra horario_catedra) {
        this.horario_catedra = horario_catedra;
    }

    public void setSelectedCatedra(Catedra selectedCatedra) {
        this.selectedCatedra = selectedCatedra;
        System.out.println("catedra seleccionada get!!!!!!!!!!!!!!!!!!!!");
        System.out.println("La catedra seleccionada es " + selectedCatedra.getNombre());

    }

    public void setLstCatedraActiva(List<Catedra> lstCatedraActiva) {
        this.lstCatedraActiva = lstCatedraActiva;
    }

    public List<SelectItem> getLstSICatedraActiva() {
        return lstSICatedraActiva;
    }

    public void setLstSICatedraActiva(List<SelectItem> lstSICatedraActiva) {
        this.lstSICatedraActiva = lstSICatedraActiva;
    }

    public int getiActionBtnSelect() {
        return iActionBtnSelect;
    }

    public void setiActionBtnSelect(int iActionBtnSelect) {
        this.iActionBtnSelect = iActionBtnSelect;
    }

    public List<SelectItem> getLstSIcatedraLike() {
        return lstSIcatedraLike;
    }

    public void setLstSIcatedraLike(List<SelectItem> lstSIcatedraLike) {
        this.lstSIcatedraLike = lstSIcatedraLike;
    }

    public void limpiar() {
        this.lstCatedra = new ArrayList<Catedra>();
    }

    public void cargar_catedras() {
        try {
            this.setLstCatedra(catedraRNLocal.findAll());
        } catch (Exception ex) {
            System.out.println("Error al cargar cátedras -> Causa: "
                    + ex.getMessage());
        }
    }

    public void cargar_SI_catedras() {
        this.setLstSICatedra(new ArrayList<SelectItem>());

        for (Catedra d : this.getLstCatedra()) {
            SelectItem si = new SelectItem(d, d.getNombre());
            this.getLstSICatedra().add(si);
        }
    }

    public void cargar_catedras_activas() {
        try {
            this.setLstCatedraActiva(this.catedraRNLocal.findAllActivo());
        } catch (Exception ex) {
            System.out.println("Error al cargar cátedras activas " + ex.toString());
        }
    }

    public void cargar_SI_catedras_activas() {
        this.setLstSICatedraActiva(new ArrayList<SelectItem>());

        for (Catedra a : this.getLstCatedraActiva()) {
            SelectItem ai = new SelectItem(a, a.getNombre());
            this.getLstSICatedraActiva().add(ai);
        }
    }

//fin for
    public void recuperarCatedras(ValueChangeEvent event) {

        try {

            if (event.getNewValue() != null) {
                if (!"0".equals(event.getNewValue().toString())) {
                    Carrera carrera = (Carrera) event.getNewValue();

                    System.out.println("carrera; " + carrera);
                    limpiar();
                    this.setLstCatedraActiva(this.catedraRNLocal.findAllcatedra(carrera.getId()));

                    this.cargar_SI_catedras_activas();

                } else {
                    this.setLstCatedraActiva(new ArrayList<Catedra>());

                }

            }//fin if
        } catch (Exception ex) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error al cargar las catedras: " + ex,
                    null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }

        //this.cargarProvincias();
    }

    public void paso_porca() {

    }

    public List<Horario_semanal_catedra> buscarHorarios() {
        try {
            this.setHorario_catedra(horario_catedraRnLocal.buscarHorario(selectedCatedra));
            System.out.println("77777777777777777" + selectedCatedra.getNombre());
        } catch (Exception ex) {
            Logger.getLogger(ListaCatedraBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.setLstDocentCatedra(docenteCatedraRNLocal.findCatedra_docente(selectedCatedra));
        } catch (Exception ex) {
            Logger.getLogger(ListaCatedraBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("los docentes asociados a las catedras son:" + lstDocentCatedra);
        try {
            this.setLstHorario_semanal_catedra(horariocatedra_semanalRNLocal.buscarHorario(horario_catedra));
            System.out.println("---------------................\t" + lstHorario_semanal_catedra);
        } catch (Exception ex) {
            Logger.getLogger(ListaCatedraBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstHorario_semanal_catedra;
    }

    public List<Catedra> completeText(String query) {
        try {
            List<Catedra> results = catedraRNLocal.findAllcatedraLIKE(query);

            return results;
        } catch (Exception ex) {
            Logger.getLogger(ListaCatedraBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
