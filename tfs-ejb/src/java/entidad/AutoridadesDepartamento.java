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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author RafaTrossero
 */
@Entity
@NamedQueries({
    
    @NamedQuery(name = "AutoridadesDepartamento.findAutoridades", query = "SELECT u FROM AutoridadesDepartamento u"),})
public class AutoridadesDepartamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Docente director;
    private Docente profTitular;
    private Docente profSuplente1;
    private Docente profSuplente2;
    private Docente auxDocenteTitular;
    private Docente auxDocenteSuplente;
    private Alumno estudTitular1;
    private Alumno estudTitular2;
    private Alumno estudSuplente1;
    private Alumno estudSuplente2;
    private Alumno egresadoTitular;
    private Alumno egresadoSuplente;
    

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

    public Docente getDirector() {
        return director;
    }

    public void setDirector(Docente director) {
        this.director = director;
    }

    public Docente getProfTitular() {
        return profTitular;
    }

    public void setProfTitular(Docente profTitular) {
        this.profTitular = profTitular;
    }

    public Docente getProfSuplente1() {
        return profSuplente1;
    }

    public void setProfSuplente1(Docente profSuplente1) {
        this.profSuplente1 = profSuplente1;
    }

    public Docente getProfSuplente2() {
        return profSuplente2;
    }

    public void setProfSuplente2(Docente profSuplente2) {
        this.profSuplente2 = profSuplente2;
    }

    public Docente getAuxDocenteTitular() {
        return auxDocenteTitular;
    }

    public void setAuxDocenteTitular(Docente auxDocenteTitular) {
        this.auxDocenteTitular = auxDocenteTitular;
    }

    public Docente getAuxDocenteSuplente() {
        return auxDocenteSuplente;
    }

    public void setAuxDocenteSuplente(Docente auxDocenteSuplente) {
        this.auxDocenteSuplente = auxDocenteSuplente;
    }

    public Alumno getEstudTitular1() {
        return estudTitular1;
    }

    public void setEstudTitular1(Alumno estudTitular1) {
        this.estudTitular1 = estudTitular1;
    }

    public Alumno getEstudTitular2() {
        return estudTitular2;
    }

    public void setEstudTitular2(Alumno estudTitular2) {
        this.estudTitular2 = estudTitular2;
    }

    public Alumno getEstudSuplente1() {
        return estudSuplente1;
    }

    public void setEstudSuplente1(Alumno estudSuplente1) {
        this.estudSuplente1 = estudSuplente1;
    }

    public Alumno getEstudSuplente2() {
        return estudSuplente2;
    }

    public void setEstudSuplente2(Alumno estudSuplente2) {
        this.estudSuplente2 = estudSuplente2;
    }

    public Alumno getEgresadoTitular() {
        return egresadoTitular;
    }

    public void setEgresadoTitular(Alumno egresadoTitular) {
        this.egresadoTitular = egresadoTitular;
    }

    public Alumno getEgresadoSuplente() {
        return egresadoSuplente;
    }

    public void setEgresadoSuplente(Alumno egresadoSuplente) {
        this.egresadoSuplente = egresadoSuplente;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutoridadesDepartamento)) {
            return false;
        }
        AutoridadesDepartamento other = (AutoridadesDepartamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.AutoridadesDepartamento[ id=" + id + " ]";
    }
    
}
