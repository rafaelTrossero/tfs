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
import javax.persistence.OneToMany;

/**
 *
 * @author RafaTrossero
 */
@Entity
public class NotaFinalAlumno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Integer notaFinal;
    
    @ManyToOne
    @JoinColumn(name = "defensaFinal_id", referencedColumnName = "id", nullable = false)
    private DefensaFinal defensa_final;
    
    @ManyToOne
    @JoinColumn(name = "alumno_id", referencedColumnName = "id", nullable = false)
    private Alumno alumno;
    
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Integer notaFinal) {
        this.notaFinal = notaFinal;
    }

    public DefensaFinal getDefensa_final() {
        return defensa_final;
    }

    public void setDefensa_final(DefensaFinal defensa_final) {
        this.defensa_final = defensa_final;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
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
        if (!(object instanceof NotaFinalAlumno)) {
            return false;
        }
        NotaFinalAlumno other = (NotaFinalAlumno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.NotaFinalAlumno[ id=" + id + " ]";
    }
    
}
