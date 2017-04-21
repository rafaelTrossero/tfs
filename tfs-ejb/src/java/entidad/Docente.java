/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import static entidad.Depto_.departamento;
import java.io.Serializable;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NamedQuery(name = "Docente.findByDocente", query = "SELECT u FROM Docente u WHERE u.cuil =:cuil"),
    @NamedQuery(name = "Docente.findByCuilID", query = "SELECT u FROM Docente u WHERE u.cuil = :cuil  AND u.id <>:id ORDER BY u.apellido"),
    @NamedQuery(name = "Docente.ActualizarEstado", query = "UPDATE Docente u SET u.active =:active WHERE u.id =:id "),
    @NamedQuery(name = "Docente.findById", query = "SELECT u FROM Docente u WHERE u.id=:id"),
    @NamedQuery(name = "Docente.SeleccionarTodo", query = "SELECT u FROM Docente u INNER JOIN DocenteCatedra z INNER JOIN DocenteComision w"),
    @NamedQuery(name = "Docente.findByCuil", query = "SELECT u FROM Docente u WHERE u.cuil=:cuil"),
    @NamedQuery(name = "Docente.findByDocenteTribunal", query = "SELECT u FROM Docente u WHERE u.id =:preID or u.id =:voc1ID or u.id =:voc2ID or u.id =:sup1ID or u.id =:sup2ID "),
    @NamedQuery(name = "Docente.SelectDepartamento", query = "SELECT u FROM Docente u WHERE u.cuil=:cuil"),
    @NamedQuery(name = "Docente.SelectDepartamento2", query = "SELECT u FROM DocenteDepartamento u WHERE u.departamento.id =:idDepartamento"),
})

    @NamedQuery(name = "Docente.SelectAll", query = "SELECT u FROM Docente u WHERE u.active =:active ")



public class Docente extends Profesional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cuil;
    private String email;
    /*
    @Column(nullable = true)
    private Integer externo;*/
   
    @OneToMany(mappedBy = "docente")
    private List<ProyectoDirector> lstProy_director;
    /*
    @ManyToOne
    @JoinColumn(name = "departamento_id", referencedColumnName = "id", nullable = false)
    private Depto departamento;*/
    @OneToOne(mappedBy = "director")
    private Depto deparatamento;
    
   @ManyToMany
   private List<Carrera> lstcarrera;
   
    @OneToMany(mappedBy = "docente")
    private List<DocenteComision> lstComision;

   @OneToMany(mappedBy = "docente")
    private List<DocenteCatedra> lstCatedra;

    @ManyToMany
    private List<Carrera> lstCarrera;
    
     
    
       @OneToMany(mappedBy = "docente")
    private List<DocenteDepartamento> DocenteDepartamento;
    
    /* public Depto getDepartamento() {
     return departamento;
     }

     public void setDepartamento(Depto departamento) {
     this.departamento = departamento;
     }
     */
    //to do extends profesional
   

  

    public List<Carrera> getLstcarrera() {
        return lstcarrera;
    }

    public void setLstcarrera(List<Carrera> lstcarrera) {
        this.lstcarrera = lstcarrera;
    }

    public List<DocenteCatedra> getLstCatedra() {
        return lstCatedra;
    }

    public void setLstCatedra(List<DocenteCatedra> lstCatedra) {
        this.lstCatedra = lstCatedra;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

  
    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public List<ProyectoDirector> getLstProy_director() {
        return lstProy_director;
    }

    public void setLstProy_director(List<ProyectoDirector> lstProy_director) {
        this.lstProy_director = lstProy_director;
    }

    public Depto getDeparatamento() {
        return deparatamento;
    }

    public void setDeparatamento(Depto deparatamento) {
        this.deparatamento = deparatamento;
    }

    public List<DocenteComision> getLstComision() {
        return lstComision;
    }

    public void setLstComision(List<DocenteComision> lstComision) {
        this.lstComision = lstComision;
    }

   
    public List<Carrera> getLstCarrera() {
        return lstCarrera;
    }

    public void setLstCarrera(List<Carrera> lstCarrera) {
        this.lstCarrera = lstCarrera;
    }

    public List<DocenteDepartamento> getDocenteDepartamento() {
        return DocenteDepartamento;
    }

    public void setDocenteDepartamento(List<DocenteDepartamento> DocenteDepartamento) {
        this.DocenteDepartamento = DocenteDepartamento;
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
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Docente[ id=" + id + " ]";
    }
}