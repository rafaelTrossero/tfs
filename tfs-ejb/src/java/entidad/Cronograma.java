/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author cristian
 */
@Entity
@NamedQueries({
           
    @NamedQuery(name="Cronograma.findByCronograma", query = "SELECT u FROM Cronograma u WHERE u.proyecto =:proID " )
     
})
public class Cronograma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @OneToOne
    @JoinColumn (name="proyecto_id", referencedColumnName="id", nullable=false)
    private Proyecto proyecto;
    
    @OneToMany(mappedBy ="cronograma")
    private List<CronogramaActividad> lstactividad;
    
    
    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public List<CronogramaActividad> getLstactividad() {
        return lstactividad;
    }

    public void setLstactividad(List<CronogramaActividad> lstactividad) {
        this.lstactividad = lstactividad;
    }
   
    
    
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

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cronograma)) {
            return false;
        }
        Cronograma other = (Cronograma) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Cronograma[ id=" + id + " ]";
    }
    
}