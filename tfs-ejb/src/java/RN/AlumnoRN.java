/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.AlumnoFacadeLocal;
import DAO.CarreraFacadeLocal;
import entidad.Alumno;
import entidad.Persona;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import recursos.cadenas;

/**
 *
 * @author cristian
 */
@Stateless
public class AlumnoRN implements AlumnoRNLocal {

    @EJB
    private AlumnoFacadeLocal alumnoFacadeLocal;

    @Override
    public void create(Alumno p) throws Exception {
        this.convertir_strings(p);
        this.validar(p, 0);
        this.alumnoFacadeLocal.create(p);

        //cadenas.es_numero(p.getMatricula().toString());
        //cadenas.es_numero(p.getId().toString());
    }

    @Override
    public void remove(Alumno p) throws Exception {
        this.alumnoFacadeLocal.remove(p);
    }

    @Override
    public void edit(Alumno p) throws Exception {
        this.convertir_strings(p);
        this.validar(p, 1);
        this.alumnoFacadeLocal.edit(p);
    }

    @Override
    public List<Alumno> findAll() throws Exception {
        return (this.alumnoFacadeLocal.findAll());
    }

    @Override
    public Alumno findByAlumno(Integer matricula) throws Exception {
// return autosFacadeLocal.findByUserPassword(codigo);
        return alumnoFacadeLocal.findByAlumno(matricula);
    }

    @Override
    public void activate(Alumno al, Boolean bEstado) throws Exception {
        alumnoFacadeLocal.activate(al, bEstado);
    }

    private void validar(Alumno p, int op) throws Exception {
        //verifica si el código es menor o igual a cero
        if (p.getMatricula() <= 0) {
            throw new Exception("El código debe ser mayor o igual a cero");
        }

        //verifica si es una línea en blanco
        if (p.getNombre().trim().length() == 0) {
            throw new Exception("El nombre del alumno no puede estar vacio");
        }
        if (!cadenas.es_letras(p.getNombre())) {
            throw new Exception("El nombre del alumno debe contener solo caracteres alfabeticos");
        }
        if (p.getApellido().trim().length() == 0) {
            throw new Exception("El apellido del alumno no puede estar vacio");
        }
        if (!cadenas.es_letras(p.getApellido())) {
            throw new Exception("El apellido del alumno debe contener solo caracteres alfabeticos");
        }
//Valida si contine letras
       

        if (p.getDomicilio().trim().length() == 0) {
            throw new Exception("Debe ingresar el domicilio");
        }
        if (!cadenas.es_letras(p.getDomicilio())) {
            throw new Exception("El domicilio debe contener solo caracteres alfabeticos");
        }
        if (p.getEmail().trim().length() == 0) {
            throw new Exception("Debe ingresar la direccion de mail");
        }
        if (!cadenas.es_email(p.getEmail())) {
            throw new Exception("Los caracteres ingresados en el mail no son validos");
        }
         if (p.getUsername().trim().length() == 0) {
            throw new Exception("El campo Nombre de usuario no puede estar vacio");
        }
          if (p.getPassword().trim().length() == 0) {
            throw new Exception("El campo Password no puede estar vacio");
        }

    //verificando duplicados  
       if (alumnoFacadeLocal.bFindByDni(p, op)) {
         throw new Exception("Ya existe un alumno con ese dni");
         }//fin if
         
       if (alumnoFacadeLocal.bFindByUserName(p, op)) {
         throw new Exception("Ya existe un alumno con ese nombre de usuario");
         }
       /*if (paisDAOFacadeLocal.bFindByNombrePais(p, op)) {
         throw new Exception("Ya existe un país con ese nombre");
         }//fin if
         */
    }//fin validar

    private void convertir_strings(Alumno p) {
        p.setNombre(cadenas.convertir(p.getNombre()));
        p.setApellido(cadenas.convertir(p.getApellido()));
        p.setDomicilio(cadenas.convertir(p.getDomicilio()));

    }

}
