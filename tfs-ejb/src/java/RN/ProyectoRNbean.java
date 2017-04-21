/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.ProyectoFacadeLocal;
import entidad.Carrera;
import entidad.Estado;
import entidad.Proyecto;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import recursos.cadenas;

/**
 *
 * @author jorge
 */
@Stateless
public class ProyectoRNbean implements ProyectoRNbeanLocal {

    @EJB
    private ProyectoFacadeLocal proyectoFacadeLocal;

    @Override
    public void create(Proyecto proyecto) throws Exception {
        this.convertir_strings(proyecto);
           this.validar(proyecto, 0);
        this.proyectoFacadeLocal.create(proyecto);
    }

    @Override
    public void remove(Proyecto proyecto) throws Exception {
        this.proyectoFacadeLocal.remove(proyecto);
    }

    @Override
    public void edit(Proyecto proyecto) throws Exception {
         this.validar(proyecto, 1);
        this.proyectoFacadeLocal.edit(proyecto);
        System.out.println("ENTRO AL EDIT DE PROYECTORNBEAN ----" + proyecto.getTitulo());
    }

    @Override
    public List<Proyecto> findAll() throws Exception {
        return (this.proyectoFacadeLocal.findAll());
    }

    @Override
    public void activate(Proyecto p, Boolean bEstado) throws Exception {
        proyectoFacadeLocal.activate(p, bEstado);
    }

    @Override
    public Estado findByEstado(Integer estado) throws Exception {
        return proyectoFacadeLocal.findByEstado(estado);
    }

    @Override
    public Proyecto findProyectoName(Proyecto proy) throws Exception {
        return proyectoFacadeLocal.findProyectoName(proy);
    }

    @Override
    public List<Proyecto> findProyByEstado(Integer estado) throws Exception {
        return proyectoFacadeLocal.findProyByEstado(estado);
    }
    private void convertir_strings(Proyecto p) {
    p.setTitulo(cadenas.convertir(p.getTitulo()));
      

  }
 
 private void validar(Proyecto p, int op) throws Exception {
    //verifica si el código es menor o igual a cero
   

    //verifica si es una línea en blanco
    if (p.getTitulo().trim().length() == 0) {
      throw new Exception("El titulo del proyecto no puede estar vacio no puede estar vacio");
    }
    if(!cadenas.es_letras(p.getTitulo())){
        throw new Exception("El nombre del profesional deben ser caracteres alfabéticos");
    }
    if (p.getFecha_ingreso() == null) {
      throw new Exception("debe ingresar la fecha de ingreso");
    }
    if (p.getCarrera() == null) {
      throw new Exception("debe seleccionar una carrera de ingreso");
    }
   
    
     
    
    
    
//Valida si contine letras
   
     
 
//Valida si contine letras
   
    
    
         
    //verificando duplicados  
    /*if (paisDAOFacadeLocal.bFindByCodigoPais(p, op)) {
      throw new Exception("Ya existe un país con ese código");
    }//fin if
    if (paisDAOFacadeLocal.bFindByNombrePais(p, op)) {
      throw new Exception("Ya existe un país con ese nombre");
    }//fin if
*/
  }//fin validar


    



    @Override
    public List<Proyecto> findProyectosAtrasados(Integer estado, Integer dias) throws Exception {
        return proyectoFacadeLocal.findProyectosAtrasados(estado, dias);
    }


    @Override
    public List<Proyecto> findProyByCarrera(Carrera carrera) throws Exception {
        return proyectoFacadeLocal.findProyByCarrera(carrera);
    }



}
