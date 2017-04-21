/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;


import DAO.NotaFinalAlumnoFacadeLocal;
import entidad.NotaFinalAlumno;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author RafaTrossero
 */
@Stateless
public class NotaFinalAlumnoRN implements NotaFinalAlumnoRNLocal {

     @EJB
    private NotaFinalAlumnoFacadeLocal notaFinalAlumnoFacadeLocal;
     
     
    @Override
    public void create(NotaFinalAlumno p) throws Exception {
        this.notaFinalAlumnoFacadeLocal.create(p);
    }

    @Override
    public void remove(NotaFinalAlumno p) throws Exception {
this.notaFinalAlumnoFacadeLocal.remove(p);
    }

    @Override
    public void edit(NotaFinalAlumno p) throws Exception {
        this.notaFinalAlumnoFacadeLocal.edit(p);
    }

    @Override
    public List<NotaFinalAlumno> findAll() throws Exception {
        return(this.notaFinalAlumnoFacadeLocal.findAll());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
