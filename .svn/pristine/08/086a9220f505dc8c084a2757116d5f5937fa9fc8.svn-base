/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.ProyectosInvestigacionFacadeLocal;
import entidad.ProyectosInvestigacion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import recursos.cadenas;

/**
 *
 * @author WalterVergara
 */
@Stateless
public class ProyectosInvestigacionRN implements ProyectosInvestigacionRNLocal {

    
    @EJB
    private ProyectosInvestigacionFacadeLocal proyectoFacadeLocal;
    
    @Override
    public void create(ProyectosInvestigacion proyectoInvestigacion) throws Exception {
        this.convertir_strings(proyectoInvestigacion);
           this.validar(proyectoInvestigacion, 0);
        this.proyectoFacadeLocal.create(proyectoInvestigacion);
    }

    @Override
    public void remove(ProyectosInvestigacion proyectoInvestigacion) throws Exception {
           this.proyectoFacadeLocal.remove(proyectoInvestigacion);
    }

    @Override
    public void edit(ProyectosInvestigacion proyectoInvestigacion) throws Exception {
        this.convertir_strings(proyectoInvestigacion);
        this.validar(proyectoInvestigacion, 1);
        this.proyectoFacadeLocal.edit(proyectoInvestigacion);
        
    }

    @Override
    public List<ProyectosInvestigacion> findAll() throws Exception {
        return (this.proyectoFacadeLocal.findAll());
    }
    
    private void convertir_strings(ProyectosInvestigacion p) {
    p.setTitulo(cadenas.convertir(p.getTitulo()));
      

  }
 
 private void validar(ProyectosInvestigacion p, int op) throws Exception {
    //verifica si el código es menor o igual a cero
   

    //verifica si es una línea en blanco
    if (p.getTitulo().trim().length() == 0) {
      throw new Exception("El titulo del proyecto no puede estar vacio ");
    }
    if(!cadenas.es_letras(p.getTitulo())){
        throw new Exception("El nombre del proyecto debe ser caracteres alfabéticos");
    }
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

    @Override
    public List<ProyectosInvestigacion> findAllActivo() throws Exception {
        return (this.proyectoFacadeLocal.findAllActivo());
    }

    @Override
    public void activate(ProyectosInvestigacion c, Boolean bEstado) throws Exception {
        proyectoFacadeLocal.activate(c, bEstado);
    }
    
   
 }
 
