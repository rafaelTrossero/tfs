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
 *
 * @author jorge
 *
 */
@Entity
@NamedQueries({
    
    @NamedQuery(name = "Carrera.FindByCarreraName", query = "SELECT u FROM Carrera u WHERE u.carrera = :nombre ORDER BY u.carrera"),
    @NamedQuery(name = "Carrera.ActualizarEstado", query = "UPDATE Carrera u SET u.active =:active WHERE u.id =:id "),
    @NamedQuery(name = "Carrera.findByNombreCarreraID", query = "SELECT u FROM Carrera u WHERE u.carrera =:nombre  AND u.id <>:id ORDER BY u.carrera"),
    @NamedQuery(name = "Carrera.SelectAll", query = "SELECT u FROM Carrera u WHERE u.active =:active "),
    @NamedQuery(name = "Carrera.SelectDepartamento", query = "SELECT u FROM Carrera u WHERE u.departamento.id =:idDepartamento ORDER BY u.carrera ")
    
})
public class Carrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String carrera;
    private Integer plan;
    @Column(name = "active", length = 100, nullable = false)
    private Boolean active;
    @ManyToOne
    @JoinColumn(name = "departamento_id", referencedColumnName = "id", nullable = false)
    private Depto departamento;
    @OneToMany(mappedBy = "carrera")
    private List<AlumnoCarrera> lstAlumno_Carrera;
    @OneToMany(mappedBy = "carrera")
    private List<Proyecto> proyecto;
    @OneToMany(mappedBy = "carrera")
    private List<Catedra> catedra;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Integer getPlan() {
        return plan;
    }

    public void setPlan(Integer plan) {
        this.plan = plan;
    }

    public Depto getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Depto departamento) {
        this.departamento = departamento;
    }

    public Boolean isActive() {
        return active;
    }
    
    public Boolean getActive() {
        return active;
    }
    
    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<AlumnoCarrera> getLstAlumno_Carrera() {
        return lstAlumno_Carrera;
    }

    public void setLstAlumno_Carrera(List<AlumnoCarrera> lstAlumno_Carrera) {
        this.lstAlumno_Carrera = lstAlumno_Carrera;
    }

    public List<Proyecto> getProyecto() {
        return proyecto;
    }

    public void setProyecto(List<Proyecto> proyecto) {
        this.proyecto = proyecto;
    }

    public List<Catedra> getCatedra() {
        return catedra;
    }

    public void setCatedra(List<Catedra> catedra) {
        this.catedra = catedra;
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
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Carrera[ id=" + id + " ]";
    }
}
