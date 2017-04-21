/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author cristian
 */

@Entity
@NamedQueries({
           
           @NamedQuery(name="Alumno.findByAlumno", query = "SELECT u FROM Alumno u WHERE u.matricula=:MATRICULA"),
           @NamedQuery(name = "Alumno.ActualizarEstado", query = "UPDATE Alumno u SET u.active =:active WHERE u.id =:id "),
           @NamedQuery(name = "Alumno.findByDni", query = "SELECT p FROM Alumno p WHERE p.dni = :dni ORDER BY p.apellido"),
           @NamedQuery(name = "Alumno.findByDniID", query = "SELECT p FROM Alumno p WHERE p.dni = :dni  AND p.id <>:id ORDER BY p.apellido"),
           @NamedQuery(name = "Alumno.findByNameUserID", query = "SELECT p FROM Usuario p WHERE p.username = :userName "),
            @NamedQuery(name = "Alumno.findByNameUser", query = "SELECT p FROM Usuario p WHERE p.username = :userName  AND p.id <>:id ")

})
public class Alumno extends Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
   
   private Integer matricula;
    
   
    @OneToMany(mappedBy="alumno")
    private List<ProyectoAlumno> proy_alumno;
    
    @OneToMany(mappedBy = "alumno")
   private List<AlumnoCarrera> lstAlumno_Carrera;
    
     @OneToOne(mappedBy = "alumno")
        private NotaFinalAlumno notaFinalAlumno;
   
    /* @ManyToMany
    @JoinTable(name="alumno_carrera",
    joinColumns={@JoinColumn(name="cod_alumno")},
    inverseJoinColumns={@JoinColumn(name="cod_carrera")})
    private List<Carrera> lstCarreras;
     */
    public List<ProyectoAlumno> getProy_alumno() {
        return proy_alumno;
    }

    public void setProy_alumno(List<ProyectoAlumno> proy_alumno) {
        this.proy_alumno = proy_alumno;
    }
   
   
    

    public List<AlumnoCarrera> getLstAlumno_Carrera() {
        return lstAlumno_Carrera;
    }

    public void setLstAlumno_Carrera(List<AlumnoCarrera> lstAlumno_Carrera) {
        this.lstAlumno_Carrera = lstAlumno_Carrera;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public NotaFinalAlumno getNotaFinalAlumno() {
        return notaFinalAlumno;
    }

    public void setNotaFinalAlumno(NotaFinalAlumno notaFinalAlumno) {
        this.notaFinalAlumno = notaFinalAlumno;
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
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Alumno[ id=" + id + " ]";
    }
    
}
