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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Trossero
 */
@Entity
@NamedQueries({
           
           
           @NamedQuery(name = "Aceptacion.findByAceptacion", query = "SELECT u FROM Aceptacion u WHERE u.proyecto = :proy and u.presentacion = :presentacion and u.calificacion = :calificacion"),
           @NamedQuery(name = "Aceptacion.findByProyAceptacion", query = "SELECT u FROM Aceptacion u WHERE u.proyecto = :proy and u.calificacion.id = :calificacion"),
           @NamedQuery(name = "Aceptacion.findByProyAceptacion1", query = "SELECT u FROM Aceptacion u WHERE u.proyecto = :proy"),
           @NamedQuery(name = "Aceptacion.findByAceptacion1", query = "SELECT u FROM Aceptacion u WHERE u.proyecto = :proy"),

})         

public class Aceptacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @Column(nullable = true)
    private Long presidente;
    @Column(nullable = true)
    private Long vocal1;
    @Column(nullable = true)
    private Long vocal2;
    @Column(nullable = true)
    private Long suplente1;
    @Column(nullable = true)
    private Long suplente2;

    @OneToMany(mappedBy = "aceptacion")
    private List<AceptacionObservaciones> lstAceptacion_obs; //observaciones

    @OneToOne
    @JoinColumn(name = "calificacion_id", referencedColumnName = "id", nullable = true)
    private Calificacion calificacion;
    
     @ManyToOne
    @JoinColumn(name = "proyecto_id", referencedColumnName = "id", nullable = true)
    private Proyecto proyecto;
    
     
     
      @ManyToOne
    @JoinColumn(name = "presentacion_id", referencedColumnName = "id", nullable = true)
    private Presentacion presentacion;
      
      @OneToMany(mappedBy ="aceptacion")
    private List<GuiaEvaluacion2_1_indicadores> ltsIndicadoresGuia2_1 ;
    // TO do
    // ligar con las demas clases
    /*  
    private Integer cod_proyecto;
    private Integer cod_presentacion;
    private Integer cod_calificacion; */
    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
     
     
     
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

    public Long getPresidente() {
        return presidente;
    }

    public void setPresidente(Long presidente) {
        this.presidente = presidente;
    }

    public Long getVocal1() {
        return vocal1;
    }

    public void setVocal1(Long vocal1) {
        this.vocal1 = vocal1;
    }

    public Long getVocal2() {
        return vocal2;
    }

    public void setVocal2(Long vocal2) {
        this.vocal2 = vocal2;
    }

    public Long getSuplente1() {
        return suplente1;
    }

    public void setSuplente1(Long suplente1) {
        this.suplente1 = suplente1;
    }

    public Long getSuplente2() {
        return suplente2;
    }

    public void setSuplente2(Long suplente2) {
        this.suplente2 = suplente2;
    }

   
   

    public List<AceptacionObservaciones> getLstAceptacion_obs() {
        return lstAceptacion_obs;
    }

    public void setLstAceptacion_obs(List<AceptacionObservaciones> lstAceptacion_obs) {
        this.lstAceptacion_obs = lstAceptacion_obs;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    public Presentacion getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Presentacion presentacion) {
        this.presentacion = presentacion;
    }

  

    public List<GuiaEvaluacion2_1_indicadores> getLtsIndicadoresGuia2_1() {
        return ltsIndicadoresGuia2_1;
    }

    public void setLtsIndicadoresGuia2_1(List<GuiaEvaluacion2_1_indicadores> ltsIndicadoresGuia2_1) {
        this.ltsIndicadoresGuia2_1 = ltsIndicadoresGuia2_1;
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
        if (!(object instanceof Aceptacion)) {
            return false;
        }
        Aceptacion other = (Aceptacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Aceptacion[ id=" + id + " ]";
    }

}
