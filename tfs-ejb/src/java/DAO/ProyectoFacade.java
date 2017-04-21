/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.Carrera;
import entidad.Estado;
import entidad.Proyecto;

import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author jorge
 */
@Stateless
public class ProyectoFacade extends AbstractFacade<Proyecto> implements ProyectoFacadeLocal {
    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;
    
    private List<Proyecto> lstProyecto;
    private List<Proyecto> lstProyecto2;
    private Proyecto proy;
    
     private Date fechaActual;
    
    SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy"); 
    
    Calendar calendar = Calendar.getInstance(); 
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

      public void setFechaActual(Date fechaActual) throws InstantiationException, IllegalAccessException {
       // this.fechaActual = Date.from(Instant.now());
        this.fechaActual  = Date.class.newInstance();
    }

    public List<Proyecto> getLstProyecto() {
        return lstProyecto;
    }

    public void setLstProyecto(List<Proyecto> lstProyecto) {
        this.lstProyecto = lstProyecto;
    }

    public List<Proyecto> getLstProyecto2() {
        return lstProyecto2;
    }

    public void setLstProyecto2(List<Proyecto> lstProyecto2) {
        this.lstProyecto2 = lstProyecto2;
    }

    public ProyectoFacade() {
        super(Proyecto.class);
         proy = new Proyecto();
         lstProyecto = new ArrayList<Proyecto>();
         lstProyecto2 = new ArrayList<Proyecto>();
    }
     @Override
    public void activate(Proyecto p, Boolean bEstado) throws Exception {
        Query q = em.createNamedQuery("Proyecto.ActualizarEstado");
        q.setParameter("active", bEstado);
        q.setParameter("id", p.getId());
        
        q.executeUpdate();
    }

    @Override
    public Estado findByEstado(Integer estado) throws Exception {

    try {
            Query q = em.createNamedQuery("Estado.findByEstado");

            q.setParameter("id", estado);
           
            return (Estado) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Proyecto findProyectoName(Proyecto proy) throws Exception {
 try {
            Query q = em.createNamedQuery("Proyecto.FindProyectoName");

            q.setParameter("titulo", proy.getTitulo());
           
            return (Proyecto) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    
    }

    @Override
    public List<Proyecto> findProyByEstado(Integer estado) {
        
        try {
            Query q = em.createNamedQuery("Proyecto.findProyByEstado");

            q.setParameter("estado", estado);
           
            return (List<Proyecto>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    
    }






    @Override
    public List<Proyecto> findProyectosAtrasados(Integer estado, Integer dias) {
           try {
               setLstProyecto(findProyByEstado(estado));
               
                 if (lstProyecto != null) {
                    Iterator<Proyecto> it = lstProyecto.iterator();

                    while (it.hasNext()) {
                        proy = it.next();
                        System.out.println("hola" + proy.getTitulo());

                        setFechaActual(Date.class.newInstance());
                        
                        calendar.setTime(proy.getFecha_ingreso()); 
                         calendar.add(Calendar.DATE, dias);
                         
                        Query q = em.createNamedQuery("Proyecto.findProyectosAtrasados");
            
                        System.out.println("---------FACADE PROYECTO ----> La fecha que se manda a la consulta es ---->>>" +calendar.getTime());

                         q.setParameter("estado", estado);
                          System.out.println("111111111111");
                         q.setParameter("fechaActual", fechaActual);
                           System.out.println("22222222222" +fechaActual);
                         q.setParameter("fechaLimite", calendar.getTime());
                           System.out.println("333333333333");
                         
                         lstProyecto2.add((Proyecto) q.getSingleResult());
                         
                         System.out.println("LSTPROYECTO TIENEEE -->" +lstProyecto);
               System.out.println("LSTPROYECTO2 TIENEEE -->" +lstProyecto2);
                    }
                    

                }
               System.out.println("LSTPROYECTO TIENEEE -->" +lstProyecto);
               System.out.println("LSTPROYECTO2 TIENEEE -->" +lstProyecto2);
           
            return lstProyecto2;
            
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public List<Proyecto> findProyByCarrera(Carrera carrera) {
     try {
            Query q = em.createNamedQuery("Proyecto.FindCarrera");

            q.setParameter("carrera", carrera);
           
            return (List<Proyecto>) q.getResultList();
        } catch (Exception e) {
            return null;
        }

    
    }

    
    
    
    
    
}
