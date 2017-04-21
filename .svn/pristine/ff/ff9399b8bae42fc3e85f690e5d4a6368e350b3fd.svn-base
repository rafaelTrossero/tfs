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
 * @author RafaTrossero
 */
@Entity
@NamedQueries({
           
           @NamedQuery(name="DocenteCatedra.findByDocente", query = "SELECT u FROM DocenteCatedra u WHERE u.docente=:docID " ),
            @NamedQuery(name="DocenteCatedra.findByIdDocente", query = "SELECT u.catedra FROM DocenteCatedra u WHERE u.docente.id=:idDoc " ),
            @NamedQuery(name="DocenteCatedra.findDocentesByCatedra", query = "SELECT u.docente FROM DocenteCatedra u "),
            @NamedQuery(name="DocenteCatedra.BuscarCatedraDocente",query = "SELECT u FROM DocenteCatedra u WHERE u.catedra =:catedra ")

})          


public class DocenteCatedra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "docente_id", referencedColumnName = "id")
    private Docente docente;
    @ManyToOne(optional = false)
    @JoinColumn(name = "catedra_id", referencedColumnName = "id")
    private Catedra catedra;
    private int baja;
    @OneToOne
    @JoinColumn(name = "cargo_id", referencedColumnName = "id", nullable = false)
    private Cargo cargo;
    @OneToOne
    @JoinColumn(name = "dedicacion_id", referencedColumnName = "id", nullable = true)
    private Dedicacion dedicacion;
    
    
    public Long getId() {
        return id;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Dedicacion getDedicacion() {
        return dedicacion;
    }

    public void setDedicacion(Dedicacion dedicacion) {
        this.dedicacion = dedicacion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Catedra getCatedra() {
        return catedra;
    }

    public void setCatedra(Catedra catedra) {
        this.catedra = catedra;
    }

    public int getBaja() {
        return baja;
    }

    public void setBaja(int baja) {
        this.baja = baja;
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
        if (!(object instanceof DocenteCatedra)) {
            return false;
        }
        DocenteCatedra other = (DocenteCatedra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.DocenteCatedra[ id=" + id + " ]";
    }
    
}
