/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import RN.CalificacionRNLocal;
import entidad.Aceptacion;
import entidad.Calificacion;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Cristian PC
 */
@ManagedBean
@SessionScoped
public class ListaCalificacioBean {
    
    
    private AceptacionBean aceptacionBean;

     @EJB
    private CalificacionRNLocal calificacionRNbeanLocal;
    private List<Calificacion> lstCalificacion;
    
    private List<SelectItem> lstSICalificacion;
    
    public Boolean isAprobado;
    
    public Boolean isAprobado2;
    
    

  
    /**
     * Creates a new instance of ListaCalificacioBean
     */
    public ListaCalificacioBean() {
        System.out.println("Constructor ListaCalificacionBean");
        lstCalificacion = new ArrayList<Calificacion>();
        
    }
 @PostConstruct
    void init() {
        System.out.println("PostConstructor ListaDepartamentoBean");
        this.cargar_Calificaciones();
        this.cargar_SI_Calificaciones();
        
        System.out.println("Calificaciones: " + this.getLstCalificacion());
    }
    public List<Calificacion> getLstCalificacion() {
        return lstCalificacion;
    }

    public void setLstCalificacion(List<Calificacion> lstCalificacion) {
        this.lstCalificacion = lstCalificacion;
    }

    public List<SelectItem> getLstSICalificacion() {
        return lstSICalificacion;
    }

    public void setLstSICalificacion(List<SelectItem> lstSICalificacion) {
        this.lstSICalificacion = lstSICalificacion;
    }

    public Boolean getIsAprobado() {
        return isAprobado;
    }

    public void setIsAprobado(Boolean isAprobado) {
        this.isAprobado = isAprobado;
    }

    public Boolean getIsAprobado2() {
        return isAprobado2;
    }

    public void setIsAprobado2(Boolean isAprobado2) {
        this.isAprobado2 = isAprobado2;
    }

    public AceptacionBean getAceptacionBean() {
        return aceptacionBean;
    }

    public void setAceptacionBean(AceptacionBean aceptacionBean) {
        this.aceptacionBean = aceptacionBean;
    }

   
    
     public void cargar_Calificaciones() {
        try {
            this.setLstCalificacion(this.calificacionRNbeanLocal.findAll());
            
            System.out.println("EL LISTADO ES "+ lstCalificacion);
        } catch (Exception ex) {
            System.out.println("Error al cargar Calificaciones " + ex.toString());
            
        }
    }

    public void cargar_SI_Calificaciones() {
        this.setLstSICalificacion(new ArrayList<SelectItem>());

        for (Calificacion d : this.getLstCalificacion()) {
            SelectItem si = new SelectItem(d, d.getCalificacion());
            this.getLstSICalificacion().add(si);
        }
    }//fin for

    public void limpiar() {
        lstCalificacion = new ArrayList<Calificacion>();
    }
    
    public Calificacion findById (Long id){
        
         try {
             return(this.calificacionRNbeanLocal.findById(id));
         } catch (Exception ex) {
            return null;
         }
    }
    
    public void control_calificacion(Calificacion calif) {
        System.out.println("ENTRO A CONTROL CALIFICACION ..... ->");
        if (calif.getId().equals(1L)) {
           
            this.setIsAprobado(Boolean.TRUE);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgCronograma').show();");
             this.setIsAprobado2(Boolean.FALSE);
             System.out.println("LO QUE TIENE IS APROBADO ES ..... ->" +isAprobado2);
        }
        
       
    }
    
    
    
    
    
}
