/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.CatedraFacadeLocal;
import entidad.Catedra;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import recursos.cadenas;

/**
 *
 * @author RafaTrossero
 */
@Stateless
public class CatedraRN implements CatedraRNLocal {

     @EJB
    private CatedraFacadeLocal catedraFacadeLocal;
    
    @Override
    public void create(Catedra c) throws Exception {
        this.convertir_strings(c);
        this.validar(c, 0);
       catedraFacadeLocal.create(c);
    }

    @Override
    public void remove(Catedra c) throws Exception {
        this.catedraFacadeLocal.remove(c);
    }

    @Override
    public void edit(Catedra c) throws Exception {
        this.catedraFacadeLocal.edit(c);
    }

    @Override
    public List<Catedra> findAll() throws Exception {
        return(this.catedraFacadeLocal.findAll());
    }

    @Override
    public void activate(Catedra c, Boolean bEstado) throws Exception {
        catedraFacadeLocal.activate(c, bEstado);
    }

    @Override
    public List<Catedra> findAllActivo() throws Exception {
       return (this.catedraFacadeLocal.findAllActivo());
    }

    private void validar(Catedra c, int op) throws Exception {
    //verifica si el código es menor o igual a cero

        //verifica si es una línea en blanco
        if (c.getNombre().trim().length() == 0) {
            throw new Exception("El campo Carrera no puede estar vacío");
        }
        

    //verificando duplicados  

        if (catedraFacadeLocal.findByCarrearaName(c, op)) {
            throw new Exception("Ya existe una carrera con ese nombre");
        }//fin if 

    }//fin validar */
    private void convertir_strings(Catedra c) {
        c.setNombre(cadenas.convertir(c.getNombre()));

    }

    @Override
    public List<Catedra> findAllcatedra(Long id) throws Exception {
         return (this.catedraFacadeLocal.findAllCarrera(id));
    }

    @Override
    public List<Catedra> finCatedraCuro(String curso) throws Exception {
     return (this.catedraFacadeLocal.findCatedraCuro(curso));
    }

    @Override
    public List<Catedra> findAllcatedraLIKE(String a) throws Exception {
       return(this.catedraFacadeLocal.findAllcatedraLIKE(a));
    }
}
