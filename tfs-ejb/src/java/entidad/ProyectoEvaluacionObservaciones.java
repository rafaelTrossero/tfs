/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidad;

import java.io.Serializable; 
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author jorge
 */
@Entity
public class ProyectoEvaluacionObservaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @Column(nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Fecha;
    //private int cod_evaluacion;
    @Column(nullable = true)
    private String observacion;
    
    @ManyToOne
    @JoinColumn(name = "evaluacion_id",referencedColumnName = "id",nullable = true)
    private EvaluacionProyecto evaluacion_proyecto;
    


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

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public EvaluacionProyecto getEvaluacion_proyecto() {
        return evaluacion_proyecto;
    }

    public void setEvaluacion_proyecto(EvaluacionProyecto evaluacion_proyecto) {
        this.evaluacion_proyecto = evaluacion_proyecto;
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
        if (!(object instanceof ProyectoEvaluacionObservaciones)) {
            return false;
        }
        ProyectoEvaluacionObservaciones other = (ProyectoEvaluacionObservaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Proy_evaluacion_obs[ id=" + id + " ]";
    }
    
}
