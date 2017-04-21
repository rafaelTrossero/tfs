/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.Docente;
import entidad.Proyecto;
import entidad.ProyectoDirector;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jorge
 */
@Local
public interface ProyectoDirectorFacadeLocal {

    void create(ProyectoDirector proy_director);

    void edit(ProyectoDirector proy_director);

    void remove(ProyectoDirector proy_director);

    ProyectoDirector find(Object id);

    List<ProyectoDirector> findAll();

    List<ProyectoDirector> findRange(int[] range);

    int count();
    public List<ProyectoDirector> findByProyDirector(Proyecto pro) throws Exception;
    public ProyectoDirector findProyDirectorActivo(Proyecto pro, boolean active) throws Exception;
    public List<ProyectoDirector> findByProyectoDirector (long idDoc) throws Exception;
    public List<ProyectoDirector> findProydirector(Docente docente);
}
