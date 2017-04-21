/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.ProfesionalFacadeLocal;
import entidad.Profesional;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import recursos.cadenas;

/**
 *
 * @author jorge
 */
@Stateless
public class ProfesionalRN implements ProfesionalRNLocal {

    private Integer azul;
    @EJB
    private ProfesionalFacadeLocal profesionalFacadeLocal;

    @Override
    public void create(Profesional pro) throws Exception {
        this.convertir_strings(pro);
        this.validar(pro, 0);
        this.profesionalFacadeLocal.create(pro);
    }

    @Override
    public void remove(Profesional pro) throws Exception {
        this.profesionalFacadeLocal.remove(pro);
    }

    @Override
    public void edit(Profesional pro) throws Exception {
        this.convertir_strings(pro);
        this.validar(pro, 1);
        this.profesionalFacadeLocal.edit(pro);
    }

    @Override
    public List<Profesional> findAll() throws Exception {
        return (this.profesionalFacadeLocal.findAll());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Profesional findByDni(Integer dni) throws Exception {
        return profesionalFacadeLocal.findByDni(dni);
    }

    @Override
    public void activate(Profesional profesional, Boolean bEstado) throws Exception {

        profesionalFacadeLocal.activate(profesional, bEstado);
    }

    private void convertir_strings(Profesional p) {
        p.setNombre(cadenas.convertir(p.getNombre()));
        p.setApellido(cadenas.convertir(p.getApellido()));
        p.setDomicilio(cadenas.convertir(p.getDomicilio()));

    }

    private void validar(Profesional p, int op) throws Exception {
    //verifica si el código es menor o igual a cero

        //verifica si es una línea en blanco
        if (p.getNombre().trim().length() == 0) {
            throw new Exception("El campo Nombre no puede estar vacío");
        }
        if (!cadenas.es_letras(p.getNombre())) {
            throw new Exception("El campo Nombre debe contener solo campos alfabéticos");
        }
        if (p.getApellido().trim().length() == 0) {
            throw new Exception("El campo Apellido no puede estar vacío");
        }
//Valida si contine letras
        if (!cadenas.es_letras(p.getApellido())) {
            throw new Exception("El campo Apellido debe contener solo campos alfabéticos");
        }
        if (p.getDomicilio().trim().length() == 0) {
            throw new Exception("El campo Domicilio no puede estar vacío");
        }
        if (!cadenas.es_letras(p.getDomicilio())) {
            throw new Exception("El campo Domicilio debe contener solo caracteres alfabéticos");
        }
         if (p.getLocalidad() == null) {
            throw new Exception("El campo localidad no puede ser nulo");
        }
         if (p.getEmail().trim().length() == 0) {
            throw new Exception("El campo Email no puede estar vacío");
        }

        if (p.getProfesion() == null) {
            throw new Exception("Debe seleccionar una profesión");
        }
        if (p.getEspecialidad() == null) {
            throw new Exception("Debe seleccionar una especialidad");
        }
        if (p.getMat_profesional() == null) {
            throw new Exception("El campo Matricula Profesional no puede estar vacío");
        }
        if (!cadenas.es_numero(p.getMat_profesional().toString())) {
            throw new Exception("El campo Matricula profesional debe contener solo caracteres numéricos");
        }

//Valida si contine letras
        
        if (!cadenas.es_email(p.getEmail())) {
            throw new Exception("Los caracteres ingresados en el email no son validos");
        }

       
        if (p.getPassword().trim().length() == 0) {
            throw new Exception("El campo Contraseña no puede estar vacío");
        }
        if (p.getLocalidad() == null) {
            throw new Exception("El campo localidad no puede ser nulo");
        }

    //verificando duplicados  
        if (profesionalFacadeLocal.bFindByCuilProfesional(p, op)) {
            throw new Exception("Ya existe un profesional con ese número de cuil");
        }

        /*if (paisDAOFacadeLocal.bFindByCodigoPais(p, op)) {
         throw new Exception("Ya existe un país con ese código");
         }//fin if
         if (paisDAOFacadeLocal.bFindByNombrePais(p, op)) {
         throw new Exception("Ya existe un país con ese nombre");
         }//fin if
         */
    }//fin validar

    @Override
    public List<Profesional> findAllActivo() throws Exception {
        return (this.profesionalFacadeLocal.findAllActivo());
    }
}
