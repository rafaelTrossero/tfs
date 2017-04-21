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
 * @author cristian
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "evaluacion.findByEvaluacion", query = "SELECT u FROM EvaluacionProyecto u WHERE u.proyecto =:proyecto and u.presentacion =:presentacion"),
    @NamedQuery(name = "evaluacion.findByEvaluacionByProyecto", query = "SELECT u FROM EvaluacionProyecto u WHERE u.proyecto =:proyecto"),
    @NamedQuery(name = "evaluacion.findByProyectoYcalif", query = "SELECT u FROM EvaluacionProyecto u WHERE u.proyecto =:proyecto and u.calificacion.id =:calificacion"),
})
public class EvaluacionProyecto implements Serializable {

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

    @ManyToOne
    @JoinColumn(name = "presentacion_id", referencedColumnName = "id", nullable = true)
    private Presentacion presentacion;
    @ManyToOne
    @JoinColumn(name = "proyecto_id", referencedColumnName = "id", nullable = true)
    private Proyecto proyecto;

    @OneToMany(mappedBy = "evaluacion_proyecto")
    private List<ProyectoEvaluacionObservaciones> listProy_evaluacion_obs;

    @OneToOne
    @JoinColumn(name = "calificacion_id", referencedColumnName = "id", nullable = true)
    private Calificacion calificacion;
    @OneToOne
    @JoinColumn(name = "tribunal_id", referencedColumnName = "id", nullable = true)
    private Tribunal tribunal;
    
     @OneToMany(mappedBy ="evaluacion_proyecto")
    private List<GuiaEvaluacion2_2_indicadores> ltsIndicadoresGuia2_2 ;

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
    

    public Presentacion getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Presentacion presentacion) {
        this.presentacion = presentacion;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public List<ProyectoEvaluacionObservaciones> getListProy_evaluacion_obs() {
        return listProy_evaluacion_obs;
    }

    public void setListProy_evaluacion_obs(List<ProyectoEvaluacionObservaciones> listProy_evaluacion_obs) {
        this.listProy_evaluacion_obs = listProy_evaluacion_obs;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    public Tribunal getTribunal() {
        return tribunal;
    }

    public void setTribunal(Tribunal tribunal) {
        this.tribunal = tribunal;
    }

    public List<GuiaEvaluacion2_2_indicadores> getLtsIndicadoresGuia2_2() {
        return ltsIndicadoresGuia2_2;
    }

    public void setLtsIndicadoresGuia2_2(List<GuiaEvaluacion2_2_indicadores> ltsIndicadoresGuia2_2) {
        this.ltsIndicadoresGuia2_2 = ltsIndicadoresGuia2_2;
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
        if (!(object instanceof EvaluacionProyecto)) {
            return false;
        }
        EvaluacionProyecto other = (EvaluacionProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Evaluacion_Proyecto[ id=" + id + " ]";
    }

}
