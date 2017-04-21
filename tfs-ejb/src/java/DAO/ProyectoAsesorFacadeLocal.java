/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.Proyecto;
import entidad.ProyectoAsesor;
import static java.util.Collections.list;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cristian
 */
@Local
public interface ProyectoAsesorFacadeLocal {

    void create(ProyectoAsesor proy_ascesor);

    void edit(ProyectoAsesor proy_ascesor);

    void remove(ProyectoAsesor proy_ascesor);

    ProyectoAsesor find(Object id);

    List<ProyectoAsesor> findAll();

    List<ProyectoAsesor> findRange(int[] range);

    int count();

    public List<ProyectoAsesor> findByProyAsesor(Proyecto pro, boolean active ) throws Exception;
       public List<ProyectoAsesor> findByProyectoAsesor (long idDoc) throws Exception;
       public List<ProyectoAsesor> findProyAsesor(long docente);
}
