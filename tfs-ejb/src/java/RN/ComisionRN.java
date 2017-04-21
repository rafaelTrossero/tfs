/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.ComisionFacadeLocal;
import entidad.Carrera;
import entidad.Comision;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import recursos.cadenas;

/**
 *
 * @author Trossero
 */
@Stateless
public class ComisionRN implements ComisionRNLocal {

    @EJB
    private ComisionFacadeLocal comisionFacadeLocal;

    @Override
    public void create(Comision c) throws Exception {
        this.convertir_strings(c);
        this.validar(c, 0);
        this.comisionFacadeLocal.create(c);
    }

    @Override
    public void remove(Comision c) throws Exception {
        this.comisionFacadeLocal.remove(c);
    }

    @Override
    public void edit(Comision c) throws Exception {
        this.convertir_strings(c);
        this.validar(c, 1);
        this.comisionFacadeLocal.edit(c);
    }

    @Override
    public List<Comision> findAll() throws Exception {
        return (this.comisionFacadeLocal.findAll());
    }

    @Override
    public void activate(Comision c, Boolean bEstado) throws Exception {
        comisionFacadeLocal.activate(c, bEstado);
    }

    private void validar(Comision c, int op) throws Exception {
    //verifica si el código es menor o igual a cero
    
    //verifica si es una línea en blanco
    if (c.getComision().trim().length() == 0) {
      throw new Exception("El nombre de la Comision no puede estar vacio");
    }
//Valida si contine letras
    if(!cadenas.es_letras(c.getComision())){
        throw new Exception("El nombre de la Comision deben ser caracteres alfabéticos");
    }
    
    //verificando duplicados  
    
    if (comisionFacadeLocal.findByComisionName(c, op)) {
      throw new Exception("Ya existe una comision con ese nombre");
    }//fin if 

  }//fin validar */

    private void convertir_strings(Comision c) {
    c.setComision(cadenas.convertir(c.getComision()));
   
  }
    @Override
    public List<Comision> findAllActivo() throws Exception {
        
    return (this.comisionFacadeLocal.findAllActivo());
    
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
