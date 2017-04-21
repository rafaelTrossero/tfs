/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.Grupo;
import entidad.Permiso;
import entidad.TipoOperacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface GrupoFacadeLocal {

    void create(Grupo grupo);

    void edit(Grupo grupo);

    void remove(Grupo grupo);

    Grupo find(Object id);

    List<Grupo> findAll();

    List<Grupo> findRange(int[] range);

    int count();

    public Boolean bFindByGrupoPantallaPermitido(Long idGrupo, String pantalla) throws Exception;

    public List<Permiso> findPermisosByGrupo(Long idGrupo) throws Exception;

    public Boolean bFindByPermiso(Long idGrupo, String pantalla, TipoOperacion tipoOperacion) throws Exception;
    public Grupo findByGrupo(Integer grupo) throws Exception;

}
