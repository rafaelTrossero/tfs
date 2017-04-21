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
   @NamedQuery(name = "Especialidad.findByProfesion", query = "SELECT e FROM Especialidad e WHERE e.profesion.id = :idProfesion ORDER BY e.especialidad"),
   })
public class Especialidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String  especialidad;
    
   /*@OneToMany(mappedBy = "especialidad")    
    private List<Profesional> lstProfesional;
    
   @OneToMany(mappedBy = "especialidad")    
    private List<ProfesionEspecialidad> lstProfesion_Especialidad;
   */
    @ManyToOne
    @JoinColumn(name = "profesion_id", referencedColumnName = "id")
    private Profesion profesion;
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.especialidad = Especialidad;
    }

    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
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
        if (!(object instanceof Especialidad)) {
            return false;
        }
        Especialidad other = (Especialidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Especialidad[ id=" + id + " ]";
    }
    
}
