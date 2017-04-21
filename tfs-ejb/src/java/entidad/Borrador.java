/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Trossero
 */
@Entity
@NamedQueries({
           
           @NamedQuery(name="Borrador.findByProyecto", query = "SELECT MAX(u.id) FROM Borrador u WHERE u.proyecto=:proyecto"),
           @NamedQuery(name="Borrador.findById", query = "SELECT u FROM Borrador u WHERE u.id=:id"),
})
public class Borrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TO DO
    // relacionar con proyecto
    //  private int cod_proyecto;
    @Column(nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;

    private Boolean nota_director;
     private Boolean nota_codirector;
   @ManyToOne
    @JoinColumn(name = "proyect_id", referencedColumnName = "id", nullable = false)
    private Proyecto proyecto;
    @OneToOne(mappedBy = "borrador")
    private BorradorEvaluacion brr_evaluacion;

    @Column(nullable = false)
    private String ruta;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean isNota_director() {
        return nota_director;
    }

    public void setNota_director(Boolean nota_director) {
        this.nota_director = nota_director;
    }

    public Boolean getNota_codirector() {
        return nota_codirector;
    }

    public void setNota_codirector(Boolean nota_codirector) {
        this.nota_codirector = nota_codirector;
    }

 
    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public BorradorEvaluacion getBrr_evaluacion() {
        return brr_evaluacion;
    }

    public void setBrr_evaluacion(BorradorEvaluacion brr_evaluacion) {
        this.brr_evaluacion = brr_evaluacion;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
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
        if (!(object instanceof Borrador)) {
            return false;
        }
        Borrador other = (Borrador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Borrador[ id=" + id + " ]";
    }

}
