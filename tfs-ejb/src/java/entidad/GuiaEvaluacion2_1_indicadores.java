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
public class GuiaEvaluacion2_1_indicadores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn (name="aceptacion_id", referencedColumnName="id", nullable= true)
    private Aceptacion aceptacion;

    @Column(nullable = true) 
    private Integer numero;
    
    @Column(nullable = true) 
    private Boolean Si;
    
    @Column(nullable = true) 
    private Boolean Noo;
    
    @Column(nullable = true) 
    private String observaciones;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aceptacion getAceptacion() {
        return aceptacion;
    }

    public void setAceptacion(Aceptacion Aceptacion) {
        this.aceptacion = Aceptacion;
    }

   

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Boolean getSi() {
        return Si;
    }

    public void setSi(Boolean Si) {
        this.Si = Si;
    }

    public Boolean getNoo() {
        return Noo;
    }

    public void setNoo(Boolean Noo) {
        this.Noo = Noo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
        if (!(object instanceof GuiaEvaluacion2_1_indicadores)) {
            return false;
        }
        GuiaEvaluacion2_1_indicadores other = (GuiaEvaluacion2_1_indicadores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.GuiaEvaluacion2_1_indicadores[ id=" + id + " ]";
    }
    
}
