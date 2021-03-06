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
 * @author Trossero
 */
@Entity
@NamedQueries({
   
    @NamedQuery(name = "evaluacionBorrador.findByEvaluacionBorrador", query = "SELECT u FROM BorradorEvaluacion u WHERE u.proyecto =:proyecto"),
    @NamedQuery(name = "evaluacionBorrador.findByProyectoYcalif", query = "SELECT u FROM BorradorEvaluacion u WHERE u.proyecto =:proyecto and u.calificacion.id =:calificacion and u.borrador.id = :borrador"),
})
public class BorradorEvaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    // TO DO
    // relacionar con proyecto, borrador, y calificacion
    /*
     private int cod_proyecto;

     private int cod_borrador;

     private int cod_calificacion;*/
  
    @Column(nullable = true) 
    @Temporal(javax.persistence.TemporalType.DATE)
     private Date fecha;
    
    @Column(nullable = false) 
     private Long presidente;
    @Column(nullable = false) 
     private Long vocal1;
    @Column(nullable = false) 
     private Long vocal2;
    
    @OneToOne
    @JoinColumn(name = "borr_cod",referencedColumnName = "id",nullable = false)
    private Borrador borrador;
    /*@OneToMany(mappedBy = " brr_evaluacion")
    private List<Proy_brr_evaluacion_obs> proy_brr_evaluacion_obs;*/
   
    @OneToOne
    @JoinColumn(name="calificacion_id", referencedColumnName="id", nullable=false)
    private Calificacion calificacion;
    
    @ManyToOne
    @JoinColumn (name="proyecto_id" , referencedColumnName="id" , nullable=false)
    private Proyecto proyecto;
    
    @ManyToOne
    @JoinColumn (name="tribunal_id" , referencedColumnName="id" , nullable=false)
    private Tribunal tribunal;
    
    
     
    @OneToMany(mappedBy="brr_evaluacion")
    private List<ProyectoBorradorEvaluacionObservaciones> lstProy_brr_evaluacion_obs;
    
    @OneToMany(mappedBy="borradorEvaluacion")
    private List<EvaluacionAspectos> lstEvaluacionAspectos;
    
     @OneToMany(mappedBy ="borrador_evaluacion")
    private List<GuiaEvaluacion2_3_indicadores> ltsIndicadoresGuia2_3 ;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Tribunal getTribunal() {
        return tribunal;
    }

    public void setTribunal(Tribunal tribunal) {
        this.tribunal = tribunal;
    }

    public Long getPresidente() {
        return presidente;
    }

    public void setPresidente(Long presidente) {
        this.presidente = presidente;
    }

    public Long getVocal1() {
        return vocal1;
    }

    public void setVocal1(Long vocal1) {
        this.vocal1 = vocal1;
    }

    public Long getVocal2() {
        return vocal2;
    }

    public void setVocal2(Long vocal2) {
        this.vocal2 = vocal2;
    }


  
  
    public Borrador getBorrador() {
        return borrador;
    }

    public void setBorrador(Borrador borrador) {
        this.borrador = borrador;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    public List<ProyectoBorradorEvaluacionObservaciones> getLstProy_brr_evaluacion_obs() {
        return lstProy_brr_evaluacion_obs;
    }

    public void setLstProy_brr_evaluacion_obs(List<ProyectoBorradorEvaluacionObservaciones> lstProy_brr_evaluacion_obs) {
        this.lstProy_brr_evaluacion_obs = lstProy_brr_evaluacion_obs;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public List<EvaluacionAspectos> getLstEvaluacionAspectos() {
        return lstEvaluacionAspectos;
    }

    public void setLstEvaluacionAspectos(List<EvaluacionAspectos> lstEvaluacionAspectos) {
        this.lstEvaluacionAspectos = lstEvaluacionAspectos;
    }

    public List<GuiaEvaluacion2_3_indicadores> getLtsIndicadoresGuia2_3() {
        return ltsIndicadoresGuia2_3;
    }

    public void setLtsIndicadoresGuia2_3(List<GuiaEvaluacion2_3_indicadores> ltsIndicadoresGuia2_3) {
        this.ltsIndicadoresGuia2_3 = ltsIndicadoresGuia2_3;
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
        if (!(object instanceof BorradorEvaluacion)) {
            return false;
        }
        BorradorEvaluacion other = (BorradorEvaluacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Brr_evaluacion[ id=" + id + " ]";
    }
    
}
