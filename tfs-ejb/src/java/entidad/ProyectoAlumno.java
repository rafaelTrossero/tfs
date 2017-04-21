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
import javax.persistence.OneToOne;

/**
 *
 * @author jorge
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "ProyectoAlumno.findByProyAlumno", query = "SELECT u FROM ProyectoAlumno u WHERE u.proyecto =:proID "),
    @NamedQuery(name = "proyAlumno.findByproyectos", query = "SELECT u FROM ProyectoAlumno u WHERE u.alumno.id =:aluID "),
   })
public class ProyectoAlumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private Integer cod_proyecto;
    //private Integer cod_alumno;
    private String baja;

    /* @ManyToOne
     @JoinColumn(name = "proyecto_id", referencedColumnName = "id", nullable = true)
     //private Proyecto proyecto;
    
     @OneToOne
     @JoinColumn(name = "alumno_id", referencedColumnName = "id", nullable = true)
     //private Alumno alumno;*/
    @ManyToOne(optional = true)
    @JoinColumn(name = "proyecto_id", referencedColumnName = "id")
    private Proyecto proyecto;
    @ManyToOne(optional = true)
    @JoinColumn(name = "alumno_id", referencedColumnName = "id")
    private Alumno alumno;

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
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

    public String getBaja() {
        return baja;
    }

    public void setBaja(String baja) {
        this.baja = baja;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoAlumno)) {
            return false;
        }
        ProyectoAlumno other = (ProyectoAlumno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Proy_alumno[ id=" + id + " ]";
    }

}
