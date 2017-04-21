/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author AFerSor
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Grupo.bFindByGrupoPantallaPermitido",
            query = "SELECT p FROM Grupo g, IN(g.lstPermiso) p WHERE g.id =:idGrupo AND  p.pantalla.url = :pantalla"),
    @NamedQuery(name = "Grupo.findPermisosByGrupo",
            query = "SELECT p FROM Grupo g, IN(g.lstPermiso) p WHERE g.id =:idGrupo"),
    @NamedQuery(name = "Grupo.bFindByPermiso",
            query = "SELECT p FROM Grupo g, IN(g.lstPermiso) p WHERE g.id =:idGrupo AND "
            + "p.tipoOperacion = :tipoOperacion AND  p.pantalla.url = :pantalla"),
   @NamedQuery(name="Grupo.findByGrupo", query = "SELECT u FROM Grupo u WHERE u.id=:id")
})
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    
    
   
    @ManyToMany
    private List<Permiso> lstPermiso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Permiso> getLstPermiso() {
        return lstPermiso;
    }

    public void setLstPermiso(List<Permiso> lstPermiso) {
        this.lstPermiso = lstPermiso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Grupo[ id=" + id + " ]";
    }
}
