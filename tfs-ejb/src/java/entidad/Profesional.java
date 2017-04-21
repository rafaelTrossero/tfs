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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author jorge
 */
@Entity

@NamedQueries({
    @NamedQuery(name = "Profesional.findByDni", query = "SELECT u FROM Profesional u WHERE u.dni=:DNI"),
    @NamedQuery(name = "Profesional.findByProfesional", query = "SELECT u FROM Profesional u WHERE u.cuil=:cuil"),
    @NamedQuery(name = "Profesional.findByCuilID", query = "SELECT u FROM Profesional u WHERE u.cuil = :cuil  AND u.id <>:id ORDER BY u.apellido"),
    @NamedQuery(name = "Profesional.ActualizarEstado", query = "UPDATE Profesional u SET u.active =:active WHERE u.id =:id "),
     @NamedQuery(name = "Profesional.SelectAll", query = "SELECT u FROM Profesional u WHERE u.active =:active "),
})

public class Profesional extends Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer mat_profesional;
    
    private String cuil;
   
    @ManyToOne
    @JoinColumn(name = "profesion_id", referencedColumnName = "id", nullable = false)
    private Profesion profesion;

    @ManyToOne
    @JoinColumn(name = "especialidad_id", referencedColumnName = "id", nullable = false)
    private Especialidad especialidad;

    @OneToMany(mappedBy = "profesional")
    private List<ProyectoAsesor> lstProy_ascesor;
    @OneToMany(mappedBy = "profesional")
    private List<ProyectoCodirector> lstProy_codirector;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMat_profesional() {
        return mat_profesional;
    }

    public void setMat_profesional(Integer mat_profesional) {
        this.mat_profesional = mat_profesional;
    }

  
  

    public Profesion getProfesion() {
        return profesion;
    }

    public List<ProyectoAsesor> getLstProy_ascesor() {
        return lstProy_ascesor;
    }

    public void setLstProy_ascesor(List<ProyectoAsesor> lstProy_ascesor) {
        this.lstProy_ascesor = lstProy_ascesor;
    }

    public List<ProyectoCodirector> getLstProy_codirector() {
        return lstProy_codirector;
    }

    public void setLstProy_codirector(List<ProyectoCodirector> lstProy_codirector) {
        this.lstProy_codirector = lstProy_codirector;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
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
        if (!(object instanceof Profesional)) {
            return false;
        }
        Profesional other = (Profesional) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Profesional[ id=" + id + " ]";
    }

}
