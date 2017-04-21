/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.ProyectoAlumnoFacadeLocal;
import entidad.ProyectoAlumno;
import entidad.Proyecto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jorge
 */
@Stateless
public class ProyectoAlumnoRN implements ProyectoAlumnoRNLocal {

    @EJB
    private ProyectoAlumnoFacadeLocal proy_lumnoFacadeLocal;

    @Override
    public void create(ProyectoAlumno alu) throws Exception {
        this.proy_lumnoFacadeLocal.create(alu);
    }

    @Override
    public void remove(ProyectoAlumno alu) throws Exception {
        this.proy_lumnoFacadeLocal.remove(alu);
    }

    @Override
    public void edit(ProyectoAlumno alu) throws Exception {
        this.proy_lumnoFacadeLocal.edit(alu);
    }

    @Override
    public List<ProyectoAlumno> findAll() throws Exception {
        return (this.proy_lumnoFacadeLocal.findAll());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List<ProyectoAlumno> findByProyAlumno(Proyecto pro) throws Exception {
        return (this.proy_lumnoFacadeLocal.findByProyAlumno(pro));
    }

    @Override
    public ProyectoAlumno findByProyectoAlumno(long alu) throws Exception {
        return proy_lumnoFacadeLocal.findByProyectoAlumno(alu);
}
}
