/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
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

/**
 *
 * @author cristian
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Objetivos.findByProyectoId", query = "SELECT u FROM Objetivos u WHERE u.proyecto=:proyectoId"),
    @NamedQuery(name = "Objetivos.findObjGeneralByProyectoId", query = "SELECT u FROM Objetivos u WHERE u.proyecto=:proyecto and u.tipo=:tipo"),
    @NamedQuery(name = "Objetivos.findObjEspecificosByProyectoId", query = "SELECT u FROM Objetivos u WHERE u.proyecto=:proyecto and u.tipo=:tipo"),
    @NamedQuery(name = "Objetivos.findAllById", query = "SELECT u FROM Objetivos u WHERE u.proyecto=:proyecto"),})
public class Objetivos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    private String objetivo;
    private String tipo;
//to do con cod_proyecto

    @ManyToOne
    @JoinColumn(name = "proyecto_id", referencedColumnName = "id", nullable = false)
    private Proyecto proyecto;
    
     @OneToMany(mappedBy="objetivos")
    private List<EvaluacionAspectos> lstEvaluacionAspectos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<EvaluacionAspectos> getLstEvaluacionAspectos() {
        return lstEvaluacionAspectos;
    }

    public void setLstEvaluacionAspectos(List<EvaluacionAspectos> lstEvaluacionAspectos) {
        this.lstEvaluacionAspectos = lstEvaluacionAspectos;
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
        if (!(object instanceof Objetivos)) {
            return false;
        }
        Objetivos other = (Objetivos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Objetivos[ id=" + id + " ]";
    }

}
