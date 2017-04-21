/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author RafaTrossero
 */
@Entity
public class EvaluacionAspectos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
     @ManyToOne(optional = true)
    @JoinColumn(name = "borradorEvaluacion_id", referencedColumnName = "id")
     private BorradorEvaluacion borradorEvaluacion;
     
      @ManyToOne(optional = true)
    @JoinColumn(name = "aspecto_id", referencedColumnName = "id")
     private Objetivos objetivos;
      
      private Boolean calificacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BorradorEvaluacion getBorradorEvaluacion() {
        return borradorEvaluacion;
    }

    public void setBorradorEvaluacion(BorradorEvaluacion borradorEvaluacion) {
        this.borradorEvaluacion = borradorEvaluacion;
    }

    public Objetivos getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(Objetivos objetivos) {
        this.objetivos = objetivos;
    }

    public Boolean getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Boolean calificacion) {
        this.calificacion = calificacion;
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
        if (!(object instanceof EvaluacionAspectos)) {
            return false;
        }
        EvaluacionAspectos other = (EvaluacionAspectos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.EvaluacionAspectos[ id=" + id + " ]";
    }
    
}
