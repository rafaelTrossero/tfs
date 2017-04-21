/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.Grupo;
import entidad.Permiso;
import entidad.TipoOperacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author AFerSor
 */
@Stateless
public class GrupoFacade extends AbstractFacade<Grupo> implements GrupoFacadeLocal {

    @PersistenceContext(unitName = "tfs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GrupoFacade() {
        super(Grupo.class);
    }

    @Override
    public Boolean bFindByGrupoPantallaPermitido(Long idGrupo, String pantalla) throws Exception {
        Query q = em.createNamedQuery("Grupo.bFindByGrupoPantallaPermitido");

        q.setParameter("idGrupo", idGrupo);
        q.setParameter("pantalla", pantalla);

        if (q.getResultList().size() > 0) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }//fin findByGrupoPantallaPermitido

    @Override
    public List<Permiso> findPermisosByGrupo(Long idGrupo) throws Exception {
        Query q = em.createNamedQuery("Grupo.findPermisosByGrupo");
        q.setParameter("idGrupo", idGrupo);
        return q.getResultList();
    }

    @Override
    public Boolean bFindByPermiso(Long idGrupo, String pantalla, TipoOperacion tipoOperacion) throws Exception {
        Query q = em.createNamedQuery("Grupo.bFindByPermiso");
        q.setParameter("idGrupo", idGrupo);
        q.setParameter("pantalla", pantalla);
        q.setParameter("tipoOperacion", tipoOperacion);
        try {
            q.getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }//fin bFindCrear

    @Override
    public Grupo findByGrupo(Integer grupo) throws Exception {
try {
            Query q = em.createNamedQuery("Grupo.findByGrupo");

            q.setParameter("id", grupo);
           
            return (Grupo) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
