/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.Codirector;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Trossero
 */
@Local
public interface CodirectorRNLocal {
    
    void create(Codirector c) throws Exception;

    void remove(Codirector c) throws Exception;

    void edit(Codirector c) throws Exception;

    List<Codirector> findAll() throws Exception;   
}
