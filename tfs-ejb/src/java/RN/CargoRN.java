/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import DAO.CargoFacadeLocal;
import entidad.Cargo;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author cristian
 */
@Stateless
public class CargoRN implements CargoRNLocal {

    @EJB
    private CargoFacadeLocal cargoFacadeLocal;
    @Override
    public void create(Cargo c) throws Exception {
   this.cargoFacadeLocal.create(c);
        }

    @Override
    public void remove(Cargo c) throws Exception {
         this.cargoFacadeLocal.remove(c);
    }

    @Override
    public void edit(Cargo c) throws Exception {
        this.cargoFacadeLocal.edit(c);
    }

    @Override
    public List<Cargo> findAll() throws Exception {
  return(this.cargoFacadeLocal.findAll());
    
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
