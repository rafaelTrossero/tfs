/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.AutoridadesDepartamentoFacade;
import DAO.AutoridadesDepartamentoFacadeLocal;
import entidad.AutoridadesDepartamento;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author RafaTrossero
 */
@Stateless
public class AutoridadesDepartamentoRN implements AutoridadesDepartamentoRNLocal {
    
    @EJB
    private AutoridadesDepartamentoFacadeLocal autoridadesDepartamentoFacadeLocal;
    
    

    @Override
    public void create(AutoridadesDepartamento n) throws Exception {
        this.autoridadesDepartamentoFacadeLocal.create(n);
    }

    @Override
    public void remove(AutoridadesDepartamento n) throws Exception {
        autoridadesDepartamentoFacadeLocal.remove(n);
    }

    @Override
    public void edit(AutoridadesDepartamento n) throws Exception {
        autoridadesDepartamentoFacadeLocal.edit(n);
    }

    @Override
    public List<AutoridadesDepartamento> findAll() throws Exception {
        return (autoridadesDepartamentoFacadeLocal.findAll());
    }

    @Override
    public void activate(AutoridadesDepartamento n, Boolean bEstado) throws Exception {
      
    }

    @Override
    public AutoridadesDepartamento findAutoridades() throws Exception {
        return (autoridadesDepartamentoFacadeLocal.findAutoridades());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
