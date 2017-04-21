/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.AlumnoRNLocal;
import RN.AlumnoCarreraRNLocal;
import entidad.Alumno;
import entidad.AlumnoCarrera;
import entidad.Especialidad;
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
public class ListaAlumnoCarreraBean implements Serializable {

    @EJB
    private AlumnoCarreraRNLocal alumno_carreraRNbeanLocal;
    private List<AlumnoCarrera> lstAlumno_Carrera;
    private List<SelectItem> lstSIAlumno_Carrera;
    
    public ListaAlumnoCarreraBean() {
        lstAlumno_Carrera = new ArrayList<AlumnoCarrera>();
    }
       @PostConstruct
    void init() {
        System.out.println("PostConstructor ListaProfesionBean");
        cargar_alumno_carrera();
        //cargar_SI_alumno_carrera();
      
        System.out.println("Profesiones: " + this.getLstAlumno_Carrera());
    }

    public List<AlumnoCarrera> getLstAlumno_Carrera() {
        return lstAlumno_Carrera;
    }

    public void setLstAlumno_Carrera(List<AlumnoCarrera> lstAlumno_Carrera) {
        this.lstAlumno_Carrera = lstAlumno_Carrera;
    }

    public List<SelectItem> getLstSIAlumno_Carrera() {
        return lstSIAlumno_Carrera;
    }

    public void setLstSIAlumno_Carrera(List<SelectItem> lstSIAlumno_Carrera) {
        this.lstSIAlumno_Carrera = lstSIAlumno_Carrera;
    }
    
    public void cargar_alumno_carrera() {
        try {
            
            this.setLstAlumno_Carrera(this.alumno_carreraRNbeanLocal.findAll());
            
        } catch (Exception ex) {
            System.out.println("Error al cargar Profesiones " + ex.toString());
        }
    }
    
    public void cargar_SI_alumno_carrera() {
       
        this.setLstSIAlumno_Carrera(new ArrayList<SelectItem>());
        
        for (AlumnoCarrera ac : this.getLstAlumno_Carrera()){
            SelectItem si = new SelectItem(ac, ac.getCarrera().getCarrera());
            this.getLstSIAlumno_Carrera().add(si);
        }
    }//fin for
    
    public void limpiar() {
        lstAlumno_Carrera = new ArrayList<AlumnoCarrera>();
    }
    
}
