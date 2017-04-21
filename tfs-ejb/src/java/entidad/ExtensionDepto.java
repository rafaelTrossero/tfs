/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author cristian
 */
@Entity
public class ExtensionDepto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
     private Integer cod_departamento;
    private Integer cod_docente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCod_departamento() {
        return cod_departamento;
    }

    public void setCod_departamento(Integer cod_departamento) {
        this.cod_departamento = cod_departamento;
    }

    public Integer getCod_docente() {
        return cod_docente;
    }

    public void setCod_docente(Integer cod_docente) {
        this.cod_docente = cod_docente;
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
        if (!(object instanceof ExtensionDepto)) {
            return false;
        }
        ExtensionDepto other = (ExtensionDepto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Extension_Dpto[ id=" + id + " ]";
    }
    
}
