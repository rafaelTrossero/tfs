/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author cristian
 */
@Entity
public class ProyectoBorradorEvaluacionObservaciones implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 255)
    private Long id;
    //private Integer cod_evaluacion;
    @Column(nullable = false)
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "evaluacionBrr_id", referencedColumnName = "id", nullable = false)
    private BorradorEvaluacion brr_evaluacion;
    
   
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public BorradorEvaluacion getBrr_evaluacion() {
        return brr_evaluacion;
    }

    public void setBrr_evaluacion(BorradorEvaluacion brr_evaluacion) {
        this.brr_evaluacion = brr_evaluacion;
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
        if (!(object instanceof ProyectoBorradorEvaluacionObservaciones)) {
            return false;
        }
        ProyectoBorradorEvaluacionObservaciones other = (ProyectoBorradorEvaluacionObservaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.ProyectoBorradorEvaluacionObservaciones[ id=" + id + " ]";
    }
    
}