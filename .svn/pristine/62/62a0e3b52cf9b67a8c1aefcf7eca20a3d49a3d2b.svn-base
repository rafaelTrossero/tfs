/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import DAO.CodirectorFacadeLocal;
import entidad.Codirector;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Trossero
 */
@Stateless
public class CodirectorRN implements CodirectorRNLocal {

    @EJB
    private CodirectorFacadeLocal codirectorFacadeLocal;
    
    @Override
    public void create(Codirector c) throws Exception {
        this.codirectorFacadeLocal.create(c);
    }

    @Override
    public void remove(Codirector c) throws Exception {
        this.codirectorFacadeLocal.remove(c);
    }

    @Override
    public void edit(Codirector c) throws Exception {
        this.codirectorFacadeLocal.edit(c);
    }

    @Override
    public List<Codirector> findAll() throws Exception {
        return (this.codirectorFacadeLocal.findAll());
        
    }

    
}
