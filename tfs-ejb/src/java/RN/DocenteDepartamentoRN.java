/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.DocenteDepartamentoFacadeLocal;
import entidad.DocenteDepartamento;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author RafaTrossero
 */
@Stateless
public class DocenteDepartamentoRN implements DocenteDepartamentoRNLocal {

     @EJB
    private DocenteDepartamentoFacadeLocal docenteDepartamentoFacadeLocal;
     
    @Override
    public void create(DocenteDepartamento p) throws Exception {
        docenteDepartamentoFacadeLocal.create(p);
    }

    @Override
    public void remove(DocenteDepartamento p) throws Exception {
        docenteDepartamentoFacadeLocal.remove(p);
    }

    @Override
    public void edit(DocenteDepartamento p) throws Exception {
        docenteDepartamentoFacadeLocal.edit(p);
    }

    @Override
    public List<DocenteDepartamento> findAll() throws Exception {
        return(docenteDepartamentoFacadeLocal.findAll());
    }

    @Override
    public DocenteDepartamento findByDocente(DocenteDepartamento doc) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DocenteDepartamento findByIdDocente(long idDoc) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DocenteDepartamento> findDocentesbyComision(long idComision) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
}
