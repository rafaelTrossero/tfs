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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author jorge
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "tribunal.findByTribunal", query = "SELECT u FROM Tribunal u WHERE u.resolucion =:resolucion and u.presidente =:preID and u.vocal1 =:voc1ID and u.vocal2 =:voc2ID and u.suplente1 =:sup1ID and u.suplente2 =:sup2ID "),
    @NamedQuery(name = "Proy_Tribunal.findByProyTribunal", query = "SELECT u FROM ProyectoTribunal u WHERE u.proyecto =:proyecto and u.active = :active"),
    @NamedQuery(name = "Proy_Tribunal.findTribunalByDocente", query = "SELECT u FROM Tribunal u WHERE u.presidente=:idDoc or u.vocal1=:idDoc or u.vocal2=:idDoc or u.suplente1=:idDoc or u.suplente2=:idDoc"),
})
public class Tribunal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private Integer cod_proyecto;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    private String resolucion;
    private Long presidente;
    private Long vocal1;
    private Long vocal2;
    private Long suplente1;
    private Long suplente2;

    @OneToOne(mappedBy = "tribunal")
    private EvaluacionProyecto evaluacion_proyecto;

    @OneToOne(mappedBy = "tribunal")
    private DefensaFinal defensa_final;

    @OneToMany(mappedBy = "tribunal")
    private List<BorradorEvaluacion> brr_evaluacion;

    @OneToMany(mappedBy = "tribunal")
    private List<ProyectoTribunal> lstProy_tribunal;
    
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

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
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

    public EvaluacionProyecto getEvaluacion_proyecto() {
        return evaluacion_proyecto;
    }

    public void setEvaluacion_proyecto(EvaluacionProyecto evaluacion_proyecto) {
        this.evaluacion_proyecto = evaluacion_proyecto;
    }

    public DefensaFinal getDefensa_final() {
        return defensa_final;
    }

    public void setDefensa_final(DefensaFinal defensa_final) {
        this.defensa_final = defensa_final;
    }

    public List<BorradorEvaluacion> getBrr_evaluacion() {
        return brr_evaluacion;
    }

    public void setBrr_evaluacion(List<BorradorEvaluacion> brr_evaluacion) {
        this.brr_evaluacion = brr_evaluacion;
    }

    public List<ProyectoTribunal> getLstProy_tribunal() {
        return lstProy_tribunal;
    }

    public void setLstProy_tribunal(List<ProyectoTribunal> lstProy_tribunal) {
        this.lstProy_tribunal = lstProy_tribunal;
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
        if (!(object instanceof Tribunal)) {
            return false;
        }
        Tribunal other = (Tribunal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Tribunal[ id=" + id + " ]";
    }

}
