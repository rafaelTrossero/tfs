/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.CarreraFacadeLocal;
import entidad.Carrera;
import entidad.Depto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless; 
import recursos.cadenas;

/**
 *
 * @author Trossero
 */
@Stateless
public class CarreraRN implements CarreraRNLocal {

    @EJB
    private CarreraFacadeLocal carreraFacadeLocal;

    @Override
    public void create(Carrera c) throws Exception {

        this.convertir_strings(c);
        this.validar(c, 0);

        carreraFacadeLocal.create(c);
    }

    @Override
    public void remove(Carrera c) throws Exception {
        this.carreraFacadeLocal.remove(c);
    }

    @Override
    public void edit(Carrera c) throws Exception {

        this.convertir_strings(c);
        this.validar(c, 1);
        this.carreraFacadeLocal.edit(c);
    }

    @Override
    public List<Carrera> findAll() throws Exception {
        return (this.carreraFacadeLocal.findAll());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void activate(Carrera c, Boolean bEstado) throws Exception {
        carreraFacadeLocal.activate(c, bEstado);
    }

    private void validar(Carrera c, int op) throws Exception {
    //verifica si el código es menor o igual a cero

        //verifica si es una línea en blanco
        if (c.getCarrera().trim().length() == 0) {
            throw new Exception("El campo Carrera no puede estar vacío");
        }
         if (c.getPlan()== null){
            throw new Exception("El campo plan no puede estar vacío");
        }
//Valida si contine letras
        if (!cadenas.es_letras(c.getCarrera())) {
            throw new Exception("El nombre de la carrera debe contener solo caracteres alfabéticos");
        }
        if (!cadenas.es_numero(c.getPlan().toString())) {
            throw new Exception("El plan debe contener solo números");
        }
    //verificando duplicados  

        if (carreraFacadeLocal.findByCarrearaName(c, op)) {
            throw new Exception("Ya existe una carrera con ese nombre");
        }//fin if 

    }//fin validar */

    private void convertir_strings(Carrera c) {
        c.setCarrera(cadenas.convertir(c.getCarrera()));

    }

    @Override
    public List<Carrera> findAllActivo() throws Exception {
        
    return (this.carreraFacadeLocal.findAllActivo());
    
    }

    @Override
    public List<Carrera> findAlldepartamento(Long id) throws Exception {
    return (this.carreraFacadeLocal.findAllDepartamento(id));
    }

}
