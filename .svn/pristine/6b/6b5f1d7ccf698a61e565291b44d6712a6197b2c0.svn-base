/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.ExtensionDeptoFacadeLocal;
import entidad.ExtensionDepto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author cristian
 */
@Stateless
public class ExtensionDeptoRN implements ExtensionDeptoRNLocal {

    @EJB
    private ExtensionDeptoFacadeLocal extension_DptoFacadeLocal;

    @Override
    public void create(ExtensionDepto p) throws Exception {
        this.extension_DptoFacadeLocal.create(p);
    }

    @Override
    public void remove(ExtensionDepto p) throws Exception {
        this.extension_DptoFacadeLocal.remove(p);
    }

    @Override
    public void edit(ExtensionDepto p) throws Exception {
        this.extension_DptoFacadeLocal.edit(p);
    }

    @Override
    public List<ExtensionDepto> findAll() throws Exception {
        return (this.extension_DptoFacadeLocal.findAll());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
