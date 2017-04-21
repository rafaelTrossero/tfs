/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import entidad.Presentacion;
import entidad.Proyecto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jorge
 */
@Local
public interface PresentacionRNLocal {

    void create(Presentacion p) throws Exception;

    void remove(Presentacion p) throws Exception;

    void edit(Presentacion p) throws Exception;

    List<Presentacion> findAll() throws Exception;

    public List<Presentacion> findPresentacion(Proyecto pro, String cert, String nota, String notadir) throws Exception;

    public Long findPresCodigo(Proyecto proy, boolean requisito) throws Exception;

    public Presentacion findByPresentacion(Long codigo) throws Exception;
}
