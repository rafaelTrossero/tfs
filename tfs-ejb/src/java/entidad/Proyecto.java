/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author jorge
 */
@Entity
@NamedQueries({
           
           @NamedQuery(name="Estado.findByEstado", query = "SELECT u FROM Estado u WHERE u.id=:id"),
           @NamedQuery (name="Proyecto.findProyByEstado", query="SELECT u FROM Proyecto u Where u.estado.id=:estado"),
           
           @NamedQuery(name = "Proyecto.ActualizarEstado", query = "UPDATE Proyecto u SET u.active =:active WHERE u.id =:id "),
           @NamedQuery(name = "Proyecto.FindProyectoName", query = "SELECT u FROM Proyecto u WHERE u.titulo = :titulo"),

            @NamedQuery(name = "Proyecto.findProyectosAtrasados", query = "SELECT u FROM Proyecto u WHERE u.estado.id = :estado and :fechaActual > :fechaLimite"),

           @NamedQuery(name = "Proyecto.FindCarrera", query = "SELECT u FROM Proyecto u WHERE u.carrera = :carrera"),

})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private int cod_carrera;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_ingreso;
    
    @Column(nullable = false)
    private String titulo;
    
    @Column(nullable = false)
    private String ruta;

    @OneToOne
    @JoinColumn(name = "estado_id", referencedColumnName = "id", nullable = false)
    private Estado estado;
    
    @ManyToOne
    @JoinColumn(name = "carrera_id", referencedColumnName = "id", nullable = false)
    private Carrera carrera;
    
    /*@OneToOne(mappedBy="proyecto")
    private Director director;*/
    @OneToMany(mappedBy = "proyecto")
   private List<ProyectoDirector> lstProy_director;
    
      @OneToMany(mappedBy = "proyecto")
   private List<ProyectoCodirector> lstProy_codirector;  
   /* @OneToMany(mappedBy="proyecto")
    private List<Codirector> codirector;*/
     @OneToMany(mappedBy = "proyecto")
   private List<ProyectoAsesor> lstProy_ascesor;
     
      @OneToMany(mappedBy = "proyecto")
    private List<ProyectoAlumno> lstAlumnos;
      
       @OneToMany(mappedBy = "proyecto")
    private List<ProyectoObjetivos> lstProy_objetivos;
    /*@OneToMany (mappedBy = "proyecto")
    private List<Asesor> asesor;*/
      

    @OneToOne(mappedBy = "proyecto")
    private Cronograma cronograma;

    @OneToMany(mappedBy = "proyecto")
    private List<ProyectoOperacion> lisProy_operacion; // listado de operaciones realizadas sobre el proyecto

    @OneToMany(mappedBy = "proyecto")
    private List<Presentacion> listPresentacion;

    @OneToMany(mappedBy = "proyecto")
    private List<Borrador> listBorrador;
    
 

    @OneToMany(mappedBy = "proyecto")
    private List<Objetivos> lstObjetivos;
    
   
            
    @OneToOne (mappedBy="proyecto")
    private Presentacion presentacion;
    
   

    @OneToOne(mappedBy = "proyecto")
    private DefensaFinal defensa_final;

      @OneToMany(mappedBy = "proyecto")
    private List<Aceptacion>  aceptacion;
        @OneToMany(mappedBy = "proyecto")
    private List<EvaluacionProyecto>  evaluacion_Proyecto;
        
       
     @Column(name = "active", length = 100, nullable = false)
    private Boolean active;
     
     @OneToMany(mappedBy = "proyecto")
   private List<ProyectoTribunal> lstProy_tribunal;
     
     @OneToMany(mappedBy = "proyecto")
    private List<ProyectoTags> lstProyectoTags;

     
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

 
  

 

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


    public Cronograma getCronograma() {
        return cronograma;
    }

    public void setCronograma(Cronograma cronograma) {
        this.cronograma = cronograma;
    }

    public List<ProyectoDirector> getLstProy_director() {
        return lstProy_director;
    }

    public void setLstProy_director(List<ProyectoDirector> lstProy_director) {
        this.lstProy_director = lstProy_director;
    }

    public List<ProyectoCodirector> getLstProy_codirector() {
        return lstProy_codirector;
    }

    public void setLstProy_codirector(List<ProyectoCodirector> lstProy_codirector) {
        this.lstProy_codirector = lstProy_codirector;
    }

    public List<ProyectoOperacion> getLisProy_operacion() {
        return lisProy_operacion;
    }

    public void setLisProy_operacion(List<ProyectoOperacion> lisProy_operacion) {
        this.lisProy_operacion = lisProy_operacion;
    }

    public List<Presentacion> getListPresentacion() {
        return listPresentacion;
    }

    public void setListPresentacion(List<Presentacion> listPresentacion) {
        this.listPresentacion = listPresentacion;
    }

    public List<Borrador> getListBorrador() {
        return listBorrador;
    }

    public void setListBorrador(List<Borrador> listBorrador) {
        this.listBorrador = listBorrador;
    }

    public List<Objetivos> getLstObjetivos() {
        return lstObjetivos;
    }

    public void setLstObjetivos(List<Objetivos> lstObjetivos) {
        this.lstObjetivos = lstObjetivos;
    }


    public DefensaFinal getDefensa_final() {
        return defensa_final;
    }

    public void setDefensa_final(DefensaFinal defensa_final) {
        this.defensa_final = defensa_final;
    }

    public List<ProyectoAlumno> getLstAlumnos() {
        return lstAlumnos;
    }

    public void setLstAlumnos(List<ProyectoAlumno> lstAlumnos) {
        this.lstAlumnos = lstAlumnos;
    }

    public List<ProyectoAsesor> getLstProy_ascesor() {
        return lstProy_ascesor;
    }

    public void setLstProy_ascesor(List<ProyectoAsesor> lstProy_ascesor) {
        this.lstProy_ascesor = lstProy_ascesor;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public List<Aceptacion> getAceptacion() {
        return aceptacion;
    }

    public void setAceptacion(List<Aceptacion> aceptacion) {
        this.aceptacion = aceptacion;
    }

    public Presentacion getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Presentacion presentacion) {
        this.presentacion = presentacion;
    }

    public List<EvaluacionProyecto> getEvaluacion_Proyecto() {
        return evaluacion_Proyecto;
    }

    public void setEvaluacion_Proyecto(List<EvaluacionProyecto> evaluacion_Proyecto) {
        this.evaluacion_Proyecto = evaluacion_Proyecto;
    }

    public List<ProyectoTribunal> getLstProy_tribunal() {
        return lstProy_tribunal;
    }

    public void setLstProy_tribunal(List<ProyectoTribunal> lstProy_tribunal) {
        this.lstProy_tribunal = lstProy_tribunal;
    }

    public List<ProyectoObjetivos> getLstProy_objetivos() {
        return lstProy_objetivos;
    }

    public void setLstProy_objetivos(List<ProyectoObjetivos> lstProy_objetivos) {
        this.lstProy_objetivos = lstProy_objetivos;
    }

    public List<ProyectoTags> getLstProyectoTags() {
        return lstProyectoTags;
    }

    public void setLstProyectoTags(List<ProyectoTags> lstProyectoTags) {
        this.lstProyectoTags = lstProyectoTags;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    

   


    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Proyectos[ id=" + id + " ]";
    }
}
