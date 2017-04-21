/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.DeptoFacadeLocal;
import entidad.Alumno;
import entidad.Depto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import recursos.cadenas;

/**
 *
 * @author cristian
 */
@Stateless
public class DeptoRN implements DeptoRNLocal {

    @EJB
    private DeptoFacadeLocal departamentoFacadeLocal;

    @Override
    public void create(Depto p) throws Exception {
        this.convertir_strings(p);
        this.validar(p, 0);
        this.departamentoFacadeLocal.create(p);
    }

    @Override
    public void remove(Depto p) throws Exception {
        this.departamentoFacadeLocal.remove(p);
    }

    @Override
    public void edit(Depto p) throws Exception {
        this.convertir_strings(p);
        this.validar(p, 1);
        this.departamentoFacadeLocal.edit(p);
    }

    @Override
    public List<Depto> findAll() throws Exception {
        return (this.departamentoFacadeLocal.findAll());
    }

    @Override
    public void activate(Depto c, Boolean bEstado) throws Exception {
        departamentoFacadeLocal.activate(c, bEstado);
    }

    private void validar(Depto p, int op) throws Exception {
        //verifica si el código es menor o igual a cero
        //if (p.getId() <= 0) {
          //  throw new Exception("El ID debe ser mayor o igual a cero");
        //}

        //verifica si es una línea en blanco
        if (p.getDepartamento().trim().length() == 0) {
            throw new Exception("El nombre del departamento no puede estar vacio");
        }
        if (!cadenas.es_letras(p.getDepartamento())) {
            throw new Exception("El nombre del Departamento deben ser caracteres alfabéticos");
        }

//Valida si contine letras
        //verificando duplicados  
        if (departamentoFacadeLocal.bFindByNombreDepto(p, op)) {
            throw new Exception("Ya existe un Departamento con ese nombre");
        }//fin if

    }//fin validar

    private void convertir_strings(Depto p) {
        p.setDepartamento(cadenas.convertir(p.getDepartamento()));

    }

    @Override
    public List<Depto> findAllActivo() throws Exception {
   
    return (this.departamentoFacadeLocal.findAllActivo());
    }

}
