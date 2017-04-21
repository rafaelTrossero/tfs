/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.GrupoFacadeLocal;
import entidad.Grupo;
import entidad.Permiso;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AFerSor
 */
@Stateless
public class GrupoRN implements GrupoRNLocal {

    @EJB
    private GrupoFacadeLocal grupoFacadeLocal;

    @Override
    public void create(Grupo grupo) throws Exception {
        grupoFacadeLocal.create(grupo);
    }

    @Override
    public void edit(Grupo grupo) throws Exception {
        grupoFacadeLocal.edit(grupo);
    }

    @Override
    public void remove(Grupo grupo) throws Exception {
        grupoFacadeLocal.remove(grupo);
    }

    @Override
    public List<Grupo> findAll() throws Exception {
        return grupoFacadeLocal.findAll();
    }

    @Override
    public Boolean bFindByGrupoPantallaPermitido(Long idGrupo, String pantalla) throws Exception {
        return grupoFacadeLocal.bFindByGrupoPantallaPermitido(idGrupo, pantalla);
    }//fin findByGrupoPantallaPermitido

    @Override
    public List<Permiso> findPermisosByGrupo(Long idGrupo) throws Exception {
        return grupoFacadeLocal.findPermisosByGrupo(idGrupo);
    }

    @Override
    public Grupo findByGrupo(Integer grupo) throws Exception {
      return grupoFacadeLocal.findByGrupo(grupo);
    }
}
