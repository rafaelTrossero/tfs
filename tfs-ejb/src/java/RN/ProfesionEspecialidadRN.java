/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.ProfesionEspecialidadFacadeLocal;
import entidad.ProfesionEspecialidad;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Trossero
 */
@Stateless
public class ProfesionEspecialidadRN implements ProfesionEspecialidadRNLocal {

    @EJB
    ProfesionEspecialidadFacadeLocal profesion_especialidadFacadeLocal;

    @Override
    public void create(ProfesionEspecialidad pro_esp) throws Exception {
        this.profesion_especialidadFacadeLocal.create(pro_esp);
    }

    @Override
    public void remove(ProfesionEspecialidad pro_esp) throws Exception {

        this.profesion_especialidadFacadeLocal.remove(pro_esp);
    }

    @Override
    public void edit(ProfesionEspecialidad pro_esp) throws Exception {
        this.profesion_especialidadFacadeLocal.edit(pro_esp);
    }

    @Override
    public List<ProfesionEspecialidad> findAll() throws Exception {

        return (this.profesion_especialidadFacadeLocal.findAll());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
