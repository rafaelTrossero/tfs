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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author cristian
 */
@Entity
@NamedQueries({
           
           @NamedQuery(name="AlumnoCarrera.findByAlumnoCarrera", query = "SELECT u FROM AlumnoCarrera u WHERE u.alumno=:aluID " ),
            @NamedQuery(name = "AlumnoCarrera.findByCodigoCarrera", query = "SELECT u FROM AlumnoCarrera u WHERE u.alumno = :aluId AND u.carrera =:carId"),
})
public class AlumnoCarrera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "alumno_id", referencedColumnName = "id")
    private Alumno alumno;
    @ManyToOne(optional = false)
    @JoinColumn(name = "carrera_id", referencedColumnName = "id")
    private Carrera carrera;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
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
        if (!(object instanceof AlumnoCarrera)) {
            return false;
        }
        AlumnoCarrera other = (AlumnoCarrera) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Alumno_Carrera[ id=" + id + " ]";
    }
    
}
