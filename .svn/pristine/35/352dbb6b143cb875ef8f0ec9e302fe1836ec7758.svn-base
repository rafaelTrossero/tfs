/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.ExtensionDepto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cristian
 */
@Local
public interface ExtensionDeptoFacadeLocal {

    void create(ExtensionDepto extension_Dpto);

    void edit(ExtensionDepto extension_Dpto);

    void remove(ExtensionDepto extension_Dpto);

    ExtensionDepto find(Object id);

    List<ExtensionDepto> findAll();

    List<ExtensionDepto> findRange(int[] range);

    int count();

}
