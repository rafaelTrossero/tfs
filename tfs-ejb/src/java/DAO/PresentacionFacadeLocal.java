/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.Presentacion;
import entidad.Proyecto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jorge
 */
@Local
public interface PresentacionFacadeLocal {

    void create(Presentacion presentacion);

    void edit(Presentacion presentacion);

    void remove(Presentacion presentacion);

    Presentacion find(Object id);

    List<Presentacion> findAll();

    List<Presentacion> findRange(int[] range);

    int count();

    public List<Presentacion> findPresentacion(Proyecto pro, String cert, String nota, String notadir);

    public Long findPresCodigo(Proyecto proy, boolean requisito) throws Exception;

    public Presentacion findByPresentacion(long codigo) throws Exception;

}
