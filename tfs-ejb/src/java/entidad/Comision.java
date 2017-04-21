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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Trossero
 */
@Entity
@NamedQueries({
    
   
    @NamedQuery(name = "Comision.ActualizarEstado", query = "UPDATE Comision u SET u.active =:active WHERE u.id =:id "),
    @NamedQuery(name = "Comision.FindByComisionName", query = "SELECT u FROM Comision u WHERE u.comision = :nombre ORDER BY u.comision"),
    @NamedQuery(name = "Comision.findByNombreComisionID", query = "SELECT u FROM Comision u WHERE u.comision =:nombre  AND u.id <>:id ORDER BY u.comision"),
    @NamedQuery(name = "Comision.SelectAll", query = "SELECT u FROM Comision u WHERE u.active =:active ")
})
public class Comision implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) 
    private String comision;
    
    @OneToMany(mappedBy = "comision")
   private List<DocenteComision> lstComision;
    
    @Column(name = "active", length = 100, nullable = false)
    private Boolean active;

   // @OneToOne(mappedBy="comision")
   //  private Doc_Comisiones doc_comisiones;
    
    /*
    @ManyToMany(mappedBy="lstComision")
    private List<Docente> lstDocente;
    */
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<DocenteComision> getLstComision() {
        return lstComision;
    }

    public void setLstComision(List<DocenteComision> lstComision) {
        this.lstComision = lstComision;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    

    public String getComision() {
        return comision;
    }

    public void setComision(String comision) {
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
        if (!(object instanceof Comision)) {
            return false;
        }
        Comision other = (Comision) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Comision[ id=" + id + " ]";
    }
    
}
