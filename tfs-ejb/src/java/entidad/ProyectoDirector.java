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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author jorge
 */
@Entity
@NamedQueries({
           
    @NamedQuery(name="ProyectoDirector.findByProyDirector", query = "SELECT u FROM ProyectoDirector u WHERE u.proyecto =:proID and u.active =:estado" ),
    @NamedQuery(name="ProyectoDirector.findDirectorActivo", query = "SELECT u FROM ProyectoDirector u WHERE u.proyecto =:proID and u.active =:estado " ),
    @NamedQuery(name = "Proyecto.FindDocenteDirector", query = "SELECT u FROM ProyectoDirector u WHERE u.docente = :docente")

})
public class ProyectoDirector implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private int cod_proyecto;
    //private int cod_director;
   private Boolean active;
    @Column(nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @Column(nullable = true)
    private String observacion_baja;
    
@ManyToOne(optional = false)
    @JoinColumn(name = "proyecto_id", referencedColumnName = "id")
    private Proyecto proyecto;
    @ManyToOne(optional = false)
    @JoinColumn(name = "doc_id", referencedColumnName = "id")
    private Docente docente;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion_baja() {
        return observacion_baja;
    }

    public void setObservacion_baja(String observacion_baja) {
        this.observacion_baja = observacion_baja;
    }

   
    
    

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
  public Boolean getActive() {
        return active;
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
        if (!(object instanceof ProyectoDirector)) {
            return false;
        }
        ProyectoDirector other = (ProyectoDirector) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Proy_director[ id=" + id + " ]";
    }
    
}
