/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.ProyectoAsesorFacadeLocal;
import DAO.ProyectoCodirectorFacadeLocal;
import DAO.ProyectoDirectorFacadeLocal;
import entidad.Docente;
import entidad.Proyecto;
import entidad.ProyectoAsesor;
import entidad.ProyectoCodirector;
import entidad.ProyectoDirector;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jorge
 */
@Stateless
public class ProyectoDirectorRN implements ProyectoDirectorRNLocal {
   @EJB
    private ProyectoDirectorFacadeLocal proyectoDirectorDAOfacadeLocal;

    @EJB
    private ProyectoCodirectorFacadeLocal proyectoCodirectorDAOfacadeLocal;

    @EJB
    private ProyectoAsesorFacadeLocal proyectoAsesorDAOfacadeLocal;

    private List<ProyectoAsesor> proyAsesor;
    private ProyectoAsesor proyAsesorActivo;
    private List<ProyectoCodirector> proyCodirector;
    private ProyectoCodirector proyCodirectorActivo;
    @EJB
    private ProyectoDirectorFacadeLocal proy_directorFacadeLocal;

    @Override
    public void create(ProyectoDirector director) throws Exception {
        this.validar(director,1);
        this.proy_directorFacadeLocal.create(director);
    }

    @Override
    public void remove(ProyectoDirector director) throws Exception {
        this.proy_directorFacadeLocal.remove(director);
    }

    @Override
    public void edit(ProyectoDirector director) throws Exception {
      
        this.proy_directorFacadeLocal.edit(director);
    }

    @Override
    public List<ProyectoDirector> findAll() throws Exception {
        return (this.proy_directorFacadeLocal.findAll());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List<ProyectoDirector> findByProyDirector(Proyecto pro) throws Exception {
        return (this.proy_directorFacadeLocal.findByProyDirector(pro));

    }

    @Override
    public ProyectoDirector findProyDirectorActivo(Proyecto pro, boolean activo) throws Exception {
      return proy_directorFacadeLocal.findProyDirectorActivo(pro, activo);
    }

    private void validar(ProyectoDirector a, int i) throws Exception {
         if(a.getDocente() == null){
             throw new Exception("se debe seleccionar al menos un profesional");
         }
        if (proyectoDirectorDAOfacadeLocal.findProyDirectorActivo(a.getProyecto(), true) == null )
              {
                  proyAsesor = proyectoAsesorDAOfacadeLocal.findByProyAsesor(a.getProyecto(), true);
        proyCodirector = proyectoCodirectorDAOfacadeLocal.findCodirectorActivo(a.getProyecto(), true);

        //recorre el list de los asesores afectados en el proyecto
        Iterator<ProyectoAsesor> as = proyAsesor.iterator();

        while (as.hasNext()) {
            proyAsesorActivo = as.next();
            System.out.println("uuuuuuuuuuuuuuuuASESORuuuuuuuuuuuuuuuu" + proyAsesorActivo.getProfesional().getId());
            if (proyAsesorActivo.getProfesional().getId().equals(a.getDocente().getId()))
                    {

                throw new Exception("El docente " + proyAsesorActivo.getProfesional().getApellido()+ ", "
                    + proyAsesorActivo.getProfesional().getNombre()
                    + " es un  asesor del proyecto");
            }

        }

        //recorre el list de los codirectores afectados en el proyecto
        Iterator<ProyectoCodirector> cod = proyCodirector.iterator();

        while (cod.hasNext()) {
            proyCodirectorActivo = cod.next();
            System.out.println("uuuuuuuuuuuuuuuuCODIRECTORuuuuuuuuuuuuuuuu" + proyCodirectorActivo.getProfesional().getId());
            if (proyCodirectorActivo.getProfesional().getId().equals(a.getDocente().getId())) {

                throw new Exception("El docente " + proyCodirectorActivo.getProfesional().getApellido()+ ", "
                    + proyCodirectorActivo.getProfesional().getNombre()
                    + " no puede ser seleccionado ya que es codirector del proyecto");
            }
        }
        
            
        }
        else {
        throw new Exception("El proyecto ya tiene un director asignado");
        
        }

       

    }

    @Override
    public List<ProyectoDirector> findByProyectoDirector(long doc) throws Exception {
        return (this.proy_directorFacadeLocal.findByProyectoDirector(doc));
    }

    @Override
    public List<ProyectoDirector> findProyByDocente(Docente docente) throws Exception {
      return (this.proy_directorFacadeLocal.findProydirector(docente));
    }
   
   
}
