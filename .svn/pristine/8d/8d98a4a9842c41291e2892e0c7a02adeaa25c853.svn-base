/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author RafaTrossero
 */
@Entity
public class FechasExamen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
     @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaEx;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ultimoDia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaEx() {
        return fechaEx;
    }

    public void setFechaEx(Date fechaEx) {
        this.fechaEx = fechaEx;
    }

    public Date getUltimoDia() {
        return ultimoDia;
    }

    public void setUltimoDia(Date ultimoDia) {
        this.ultimoDia = ultimoDia;
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
        if (!(object instanceof FechasExamen)) {
            return false;
        }
        FechasExamen other = (FechasExamen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.FechasExamen[ id=" + id + " ]";
    }
    
}
