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

/**
 *
 * @author RafaTrossero
 */
@Entity
public class GuiaEvaluacion2_3_indicadores implements Serializable {
      private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn (name="borradorEvaluacion_id", referencedColumnName="id", nullable= true)
    private BorradorEvaluacion borrador_evaluacion;

    @Column(nullable = true) 
    private Integer numero;
    
    @Column(nullable = true) 
    private String condicion;
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public BorradorEvaluacion getBorrador_evaluacion() {
        return borrador_evaluacion;
    }

    public void setBorrador_evaluacion(BorradorEvaluacion borrador_evaluacion) {
        this.borrador_evaluacion = borrador_evaluacion;
    }

   

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

   

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GuiaEvaluacion2_3_indicadores)) {
            return false;
        }
        GuiaEvaluacion2_3_indicadores other = (GuiaEvaluacion2_3_indicadores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.GuiaEvaluacion2_3_indicadores[ id=" + id + " ]";
    }
    
}
