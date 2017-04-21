/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import DAO.AlumnoCarreraFacadeLocal;
import entidad.AlumnoCarrera;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author cristian
 */
@Stateless
public class AlumnoCarreraRN implements AlumnoCarreraRNLocal {

    @EJB
    private AlumnoCarreraFacadeLocal alumno_CarreraFacadeLocal;
    @Override
    public void create(AlumnoCarrera a) throws Exception {
     this.alumno_CarreraFacadeLocal.create(a);
    }

    @Override
    public void remove(AlumnoCarrera a) throws Exception {
  this.alumno_CarreraFacadeLocal.remove(a);
    }

    @Override
    public void edit(AlumnoCarrera a) throws Exception {

    this.alumno_CarreraFacadeLocal.edit(a);
    }

    @Override
    public List<AlumnoCarrera> findAll() throws Exception {
   return(this.alumno_CarreraFacadeLocal.findAll());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public AlumnoCarrera findByAlumno(AlumnoCarrera alu) throws Exception {
return alumno_CarreraFacadeLocal.findByAlumno(alu);
    }

    @Override
    public AlumnoCarrera findByAlumnoCarrera(Long idAlu, long idCar) throws Exception {
 return alumno_CarreraFacadeLocal.findByAlumnoCarrera(idAlu, idCar);
    }

    @Override
    public List<AlumnoCarrera> findAlumnoCarrera(AlumnoCarrera alu_car) throws Exception {
return alumno_CarreraFacadeLocal.findAlumnoCarrera(alu_car);
    }
}
