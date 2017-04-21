/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import DAO.CorreoElectronicoFacadeLocal;
import entidad.CorreoElectronico;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Trossero
 */
@Stateless
public class CorreoElectronicoRN implements CorreoElectronicoRNLocal {

    @EJB
    private CorreoElectronicoFacadeLocal correoElectronicoFacadeLocal;
    
    @Override
    public void create(CorreoElectronico c) throws Exception {
        correoElectronicoFacadeLocal.create(c);
    }

    @Override
    public void remove(CorreoElectronico c) throws Exception {
        correoElectronicoFacadeLocal.remove(c);
    }

    @Override
    public void edit(CorreoElectronico c) throws Exception {
        correoElectronicoFacadeLocal.edit(c);
    }

    @Override
    public List<CorreoElectronico> findAll() throws Exception {
       return(correoElectronicoFacadeLocal.findAll());
    }

    
}
