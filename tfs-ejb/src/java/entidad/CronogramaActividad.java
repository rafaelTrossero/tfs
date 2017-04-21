/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author Trossero
 */
@Entity
@NamedQueries({
           
    @NamedQuery(name="CronogramaActividad.findByCronogramaActividad", query = "SELECT u FROM CronogramaActividad u WHERE u.cronograma =:croID " ),
    @NamedQuery(name="CronogramaActividad.findByCronograma", query = "SELECT u FROM CronogramaActividad u WHERE u.id =:longID " ),
    @NamedQuery(name="CronogramaActividad.findByFueraDeFecha", query = "SELECT u FROM CronogramaActividad u WHERE u.fecha_fin < :fechaActual GROUP BY u.cronograma " )
     
})
public class CronogramaActividad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // cod de actividad

   //TO DO
    // relacionar con cronograma
  
    @ManyToOne
    @JoinColumn (name="cronograma_id", referencedColumnName="id", nullable= false)
    private Cronograma cronograma;
    
    @Column(nullable = true) 
    private Integer numero;
    
    @Column(nullable = false) 
    private String descripcion_act;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_inicio;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_fin;
   
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    

    
    public String getDescripcion_act() {
        return descripcion_act;
    }

    public void setDescripcion_act(String descripcion_act) {
        this.descripcion_act = descripcion_act;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }



    public Cronograma getCronograma() {
        return cronograma;
    }

    public void setCronograma(Cronograma cronograma) {
        this.cronograma = cronograma;
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
        if (!(object instanceof CronogramaActividad)) {
            return false;
        }
        CronogramaActividad other = (CronogramaActividad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.CronogramaActividad[ id=" + id + " ]";
    }
    
}
