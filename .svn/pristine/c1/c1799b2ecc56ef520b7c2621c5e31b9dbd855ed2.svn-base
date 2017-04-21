/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import DAO.BorradorFacadeLocal;
import entidad.Borrador;
import entidad.Proyecto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Trossero
 */
@Stateless
public class BorradorRN implements BorradorRNLocal {
    @EJB
    private BorradorFacadeLocal borradorFacadeLocal;
    
    @Override
    public void create(Borrador b) throws Exception {
        validar(b,1);
        this.borradorFacadeLocal.create(b);
    }

    @Override
    public void remove(Borrador b) throws Exception {
        this.borradorFacadeLocal.remove(b);
    }

    @Override
    public void edit(Borrador b) throws Exception {
        this.borradorFacadeLocal.edit(b);
    }

    @Override
    public List<Borrador> findAll() throws Exception {
        return (this.borradorFacadeLocal.findAll());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Long findByProyecto(Proyecto proyecto) throws Exception {
        return (this.borradorFacadeLocal.findByProyecto(proyecto));
    }

    @Override
    public Borrador findById(Long id) throws Exception {
        
        return (this.borradorFacadeLocal.findById(id));
    }
   
     private void validar(Borrador b, int op) throws Exception {
    //verifica si el código es menor o igual a cero

        //verifica si es una línea en blanco
       

        if (b.getFecha() == null) {
            throw new Exception("El campo fecha no puede estar vacío");
        }

    }//fin validar
}
