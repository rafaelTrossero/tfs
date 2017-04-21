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
           
           @NamedQuery (name="DefensaFinal.findProyAprobados", query="SELECT u FROM DefensaFinal u WHERE  u.fecha BETWEEN :fecha1 AND :fecha2 "),
           @NamedQuery(name = "Defensa_Final.findByDefensa", query = "SELECT u FROM DefensaFinal u WHERE u.proyecto = :proy and u.tribunal = :trib"),
           
}) 
public class DefensaFinal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)

  @Temporal(javax.persistence.TemporalType.DATE)
  private Date fecha;
    
    

  

  private Long presidente;

  private Long vocal1;

  private Long vocal2;
  
  private Long suplente1;
  
  private Long suplente2;
  
  @OneToOne
    @JoinColumn(name = "proy_id", referencedColumnName = "id", nullable = false)
    private Proyecto proyecto;
  
  @OneToMany(mappedBy = "defensa_final")
    private List<DefensaFinalObservaciones> lstObservaciones;
  
  
  @OneToOne
    @JoinColumn(name = "tribunal_id", referencedColumnName = "id", nullable = false)
    private Tribunal tribunal;
  
    @OneToMany(mappedBy = "defensa_final")
        private List<NotaFinalAlumno> lstNotaFinalAlumno;
    
    
    
  
  //to do  def_final_obs,
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
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

  

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public List<DefensaFinalObservaciones> getLstObservaciones() {
        return lstObservaciones;
    }

    public void setLstObservaciones(List<DefensaFinalObservaciones> lstObservaciones) {
        this.lstObservaciones = lstObservaciones;
    }

    public Tribunal getTribunal() {
        return tribunal;
    }

    public void setTribunal(Tribunal tribunal) {
        this.tribunal = tribunal;
    }
    
    
    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DefensaFinal)) {
            return false;
        }
        DefensaFinal other = (DefensaFinal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Defensa_Final[ id=" + id + " ]";
    }
    
}
