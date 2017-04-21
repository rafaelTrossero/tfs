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
import entidad.Profesional;
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
 * @author cristian
 */
@Stateless
public class ProyectoCodirectorRN implements ProyectoCodirectorRNLocal {

    private List<ProyectoAsesor> proyAsesor;
    private Profesional proyAsesorActivo;
    private Profesional proyCodirecActivo;
    private Profesional proyAsesorActivo1;
    private Profesional proyCodirecActivo1;
    private List<ProyectoCodirector> proyCodirector;
     private ProyectoDirector proyDirectorActivo;
    private ProyectoAsesor proyAsesorActivo2;
  
    private ProyectoCodirector proyCodirectorActivo;


    @EJB
    private ProyectoDirectorFacadeLocal proyectoDirectorDAOfacadeLocal;
    @EJB
    private ProyectoCodirectorFacadeLocal proyectoCodirectorDAOfacadeLocal;
    @EJB
    private ProyectoAsesorFacadeLocal proyectoAsesorDAOfacadeLocal;

    public List<ProyectoAsesor> getProyAsesor() {
        return proyAsesor;
    }

    public void setProyAsesor(List<ProyectoAsesor> proyAsesor) {
        this.proyAsesor = proyAsesor;
    }

    public List<ProyectoCodirector> getProyCodirector() {
        return proyCodirector;
    }

    public void setProyCodirector(List<ProyectoCodirector> proyCodirector) {
        this.proyCodirector = proyCodirector;
    }

    public Profesional getProyAsesorActivo() {
        return proyAsesorActivo;
    }

    public void setProyAsesorActivo(Profesional proyAsesorActivo) {
        this.proyAsesorActivo = proyAsesorActivo;
    }

    public ProyectoAsesor getProyAsesorActivo2() {
        return proyAsesorActivo2;
    }

    public void setProyAsesorActivo2(ProyectoAsesor proyAsesorActivo2) {
        this.proyAsesorActivo2 = proyAsesorActivo2;
    }

    public ProyectoDirector getProyDirectorActivo() {
        return proyDirectorActivo;
    }

    public void setProyDirectorActivo(ProyectoDirector proyDirectorActivo) {
        this.proyDirectorActivo = proyDirectorActivo;
    }

   

    public ProyectoCodirector getProyCodirectorActivo() {
        return proyCodirectorActivo;
    }

    public void setProyCodirectorActivo(ProyectoCodirector proyCodirectorActivo) {
        this.proyCodirectorActivo = proyCodirectorActivo;
    }

    public ProyectoDirectorFacadeLocal getProyectoDirectorDAOfacadeLocal() {
        return proyectoDirectorDAOfacadeLocal;
    }

    public void setProyectoDirectorDAOfacadeLocal(ProyectoDirectorFacadeLocal proyectoDirectorDAOfacadeLocal) {
        this.proyectoDirectorDAOfacadeLocal = proyectoDirectorDAOfacadeLocal;
    }

    public ProyectoCodirectorFacadeLocal getProyectoCodirectorDAOfacadeLocal() {
        return proyectoCodirectorDAOfacadeLocal;
    }

    public void setProyectoCodirectorDAOfacadeLocal(ProyectoCodirectorFacadeLocal proyectoCodirectorDAOfacadeLocal) {
        this.proyectoCodirectorDAOfacadeLocal = proyectoCodirectorDAOfacadeLocal;
    }

    public ProyectoAsesorFacadeLocal getProyectoAsesorDAOfacadeLocal() {
        return proyectoAsesorDAOfacadeLocal;
    }

    public void setProyectoAsesorDAOfacadeLocal(ProyectoAsesorFacadeLocal proyectoAsesorDAOfacadeLocal) {
        this.proyectoAsesorDAOfacadeLocal = proyectoAsesorDAOfacadeLocal;
    }

    public ProyectoCodirectorFacadeLocal getProy_codirectorFacadeLocal() {
        return proy_codirectorFacadeLocal;
    }

    public void setProy_codirectorFacadeLocal(ProyectoCodirectorFacadeLocal proy_codirectorFacadeLocal) {
        this.proy_codirectorFacadeLocal = proy_codirectorFacadeLocal;
    }

  

    public Profesional getProyCodirecActivo() {
        return proyCodirecActivo;
    }

    public void setProyCodirecActivo(Profesional proyCodirecActivo) {
        this.proyCodirecActivo = proyCodirecActivo;
    }

    public Profesional getProyAsesorActivo1() {
        return proyAsesorActivo1;
    }

    public void setProyAsesorActivo1(Profesional proyAsesorActivo1) {
        this.proyAsesorActivo1 = proyAsesorActivo1;
    }

    public Profesional getProyCodirecActivo1() {
        return proyCodirecActivo1;
    }

    public void setProyCodirecActivo1(Profesional proyCodirecActivo1) {
        this.proyCodirecActivo1 = proyCodirecActivo1;
    }

    @EJB
    private ProyectoCodirectorFacadeLocal proy_codirectorFacadeLocal;

    @Override
    public void create(ProyectoCodirector a) throws Exception {
        this.validar1(a, 1);
        this.proy_codirectorFacadeLocal.create(a);
    }

    @Override
    public void remove(ProyectoCodirector a) throws Exception {
        this.proy_codirectorFacadeLocal.remove(a);
    }

    @Override
    public void edit(ProyectoCodirector a) throws Exception {
        this.revalidar(a,1);
        this.proy_codirectorFacadeLocal.edit(a);
    }

    @Override
    public List<ProyectoCodirector> findAll() throws Exception {
        return (this.proy_codirectorFacadeLocal.findAll());
    }

   @Override
    public void validar(Docente proDirec, List<Profesional> proyAsesor, List<Profesional> proyCodirector) throws Exception {
      
        if (proDirec != null) {
            Iterator<Profesional> as = proyAsesor.iterator();
            while (as.hasNext()) {
                proyAsesorActivo = as.next();
                System.out.println("uuuuuuuuuuuuuuuuASESORuuuuuuuuuuuuuuuu" + proyAsesorActivo);
                if (proDirec.getId().equals(proyAsesorActivo.getId())) {

                    throw new Exception("El profesional" + proyAsesorActivo.getApellido() + "," + proyAsesorActivo.getNombre() + " ya ha sido seleccionado como director del proyecto");
                }

            }
            Iterator<Profesional> codirec = proyCodirector.iterator();
            while (codirec.hasNext()) {
                proyCodirecActivo = codirec.next();
                System.out.println("uuuuuuuuuuuuuuuuCODIRECTORuuuuuuuuuuuuuuuu" + proyCodirecActivo);
                if (proDirec.getId().equals(proyCodirecActivo.getId())) {

                    throw new Exception("El profesional" + proyCodirecActivo.getApellido() + "," + proyCodirecActivo.getNombre() + " ya ha sido seleccionado como director del proyecto");
                }

            }
            
            Iterator<Profesional> codirector = proyCodirector.iterator();
            Iterator<Profesional> asesor = proyAsesor.iterator();
            while (asesor.hasNext()) {

                proyAsesorActivo1 = asesor.next();
                while (codirector.hasNext()) {
                    proyCodirecActivo1 = codirector.next();
                    System.out.println("los docentes son " + proyCodirecActivo1 + "," + proyAsesorActivo1);

                    if (proyCodirecActivo1.getId().equals(proyAsesorActivo1.getId())) {

                        throw new Exception("El profesional" + proyAsesorActivo1.getApellido() + "," + proyAsesorActivo1.getNombre() + " ya ha sido seleccionado como asesor del proyecto");
                    }

                }
            }

        } //else {
           // throw new Exception("debe ingresar el director del proyecto");
       // }
    }

    @Override
    public List<ProyectoCodirector> findByProyCodirector(Proyecto pro, boolean active) throws Exception {
        return (this.proy_codirectorFacadeLocal.findByProyCodirector(pro, active));
    }

    private void validar1(ProyectoCodirector a, int op) throws Exception {
        //verifica si el código es menor o igual a cero

        /*------------------------------------------------------------------------
         verifica que los asesores seleccionados no sean directores ni codirectores
         ---------------------------------------------------------------------------*/
        if (a.getProfesional() == null) {
            throw new Exception("se debe seleccionar al menos un profesional");
        }
        
        proyAsesor = proyectoAsesorDAOfacadeLocal.findByProyAsesor(a.getProyecto(), true);
        proyCodirector = proyectoCodirectorDAOfacadeLocal.findCodirectorActivo(a.getProyecto(), true);
        proyDirectorActivo = proyectoDirectorDAOfacadeLocal.findProyDirectorActivo(a.getProyecto(), true);
       // System.out.println("-------------------------------------------" + proyectoDirectorDAOfacadeLocal.findProyDirectorActivo(a.getProyecto(), true).getDocente().getId());
        
        if (proyDirectorActivo != null) {
            if (proyDirectorActivo.getDocente().getId().equals(a.getProfesional().getId())) {

                throw new Exception("El docente " + proyectoDirectorDAOfacadeLocal.findProyDirectorActivo(a.getProyecto(), true).getDocente().getNombre() + ", "
                        + proyectoDirectorDAOfacadeLocal.findProyDirectorActivo(a.getProyecto(), true).getDocente().getApellido()
                        + " no puede ser seleccionado ya que es el director del proyecto");
            }
            
            
        }

        
        if(proyAsesor != null){

        //recorre el list de los asesores afectados en el proyecto
        Iterator<ProyectoAsesor> as = proyAsesor.iterator();

        while (as.hasNext()) {
            proyAsesorActivo2 = as.next();
            System.out.println("uuuuuuuuuuuuuuuuASESORuuuuuuuuuuuuuuuu" + proyAsesorActivo2.getProfesional().getId());
            if (proyAsesorActivo2.getProfesional().getId().equals(a.getProfesional().getId()) ) {

                throw new Exception("El docente " + proyAsesorActivo2.getProfesional().getApellido() + ", "
                        + proyAsesorActivo2.getProfesional().getNombre()
                        + " ya es asesor del proyecto");
            }

        }
       }   
        //recorre el list de los codirectores afectados en el proyecto
        if(proyCodirector != null){
        Iterator<ProyectoCodirector> cod = proyCodirector.iterator();

        while (cod.hasNext()) {
            proyCodirectorActivo = cod.next();
            System.out.println("uuuuuuuuuuuuuuuuCODIRECTORuuuuuuuuuuuuuuuu" + proyCodirectorActivo.getProfesional().getId());
            if (proyCodirectorActivo.getProfesional().getId().equals(a.getProfesional().getId())) {

                throw new Exception("El docente " + proyCodirectorActivo.getProfesional().getApellido() + ", "
                        + proyCodirectorActivo.getProfesional().getNombre()
                        + " no puede ser seleccionado ya que es codirector del proyecto");
            }
        }
        }
    
    }
      private void revalidar(ProyectoCodirector a, int i) throws Exception {
    if(a.getProfesional() == null){
             throw new Exception("se debe seleccionar al menos un profesional");
         }
    }

    @Override
    public List<ProyectoCodirector> findByProyectoCodirector(long doc) throws Exception {
       return (this.proy_codirectorFacadeLocal.findByProyectoCodirector(doc));
    }

    @Override
    public List<ProyectoCodirector> findProyByDocenteCodirector(long docente) throws Exception {
         return (this.proy_codirectorFacadeLocal.findProyCodirector(docente));
    
    }
    }


