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
 * @author WalterVergara
 */
@Entity
@NamedQueries({
    
    
    @NamedQuery(name = "ProyectosInvestigacion.ActualizarEstado", query = "UPDATE ProyectosInvestigacion u SET u.active =:active WHERE u.id =:id "),
    @NamedQuery(name = "ProyectosInvestigacion.SelectAll", query = "SELECT u FROM ProyectosInvestigacion u WHERE u.active =:active "),
    
    
})
public class ProyectosInvestigacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String titulo;
    
   @OneToOne
    @JoinColumn(name = "director_id", referencedColumnName = "id", nullable = true)
    private Docente director;
   
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_presentacion;
    
    @ManyToOne
    @JoinColumn(name = "carrera_id", referencedColumnName = "id", nullable = false)
    private Carrera carrera;

    
    @Column(name = "active", length = 100, nullable = false)
    private Boolean active;
        
           

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Docente getDirector() {
        return director;
    }

    public void setDirector(Docente director) {
        this.director = director;
    }

    public Date getFecha_presentacion() {
        return fecha_presentacion;
    }

    public void setFecha_presentacion(Date fecha_presentacion) {
        this.fecha_presentacion = fecha_presentacion;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    

    
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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
        if (!(object instanceof ProyectosInvestigacion)) {
            return false;
        }
        ProyectosInvestigacion other = (ProyectosInvestigacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.ProyectosInvestigacion[ id=" + id + " ]";
    }
    
}
