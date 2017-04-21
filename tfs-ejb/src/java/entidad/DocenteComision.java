/*
 * To change this template, choose Tools | Templates
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
 * @author jmoreno
 */
@Entity
@NamedQueries({
           
           @NamedQuery(name="DocenteComision.findByDocente", query = "SELECT u FROM DocenteComision u WHERE u.docente=:docID " ),
            @NamedQuery(name = "DocenteComision.findByCodigoComision", query = "SELECT u FROM DocenteComision u WHERE u.docente = :docId AND u.comision =:comId"),
            @NamedQuery(name="DocenteComision.findByIdDocente", query = "SELECT u.comision FROM DocenteComision u WHERE u.docente.id=:idDoc " ),
            @NamedQuery(name="DocenteComision.findDocentesByComision", query = "SELECT u.docente FROM DocenteComision u WHERE u.comision.id=:idComision"),
})
public class DocenteComision implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "docente_id", referencedColumnName = "id")
    private Docente docente;
    @ManyToOne(optional = false)
    @JoinColumn(name = "comision_id", referencedColumnName = "id")
    private Comision comision;
    private int baja;

    public int getBaja() {
        return baja;
    }

    public void setBaja(int baja) {
        this.baja = baja;
    }

    
    public Long getId() {
        return id;
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

    public Comision getComision() {
        return comision;
    }

    public void setComision(Comision comision) {
        this.comision = comision;
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
        if (!(object instanceof DocenteComision)) {
            return false;
        }
        DocenteComision other = (DocenteComision) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Docente_Comision[ id=" + id + " ]";
    }
}
