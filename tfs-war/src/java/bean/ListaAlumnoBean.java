/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.AlumnoRNLocal;
import RN.ProyectoAlumnoRNLocal;
import entidad.Alumno;
import entidad.NotaFinalAlumno;
import entidad.Profesional;
import entidad.Proyecto;
import entidad.ProyectoAlumno;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author WalterVergara
 */
@ManagedBean
@SessionScoped
public class ListaAlumnoBean implements Serializable {

    private int iActionBtnSelect;
    @EJB
    private AlumnoRNLocal alumnoRNbeanLocal;
    @EJB
    private ProyectoAlumnoRNLocal proyectoAlumnoRNbeanLocal;

    private List<Alumno> lstAlumno;
    private List<ProyectoAlumno> lstAlumnoProyecto;
     private List<NotaFinalAlumno> lstAlumnoProyectoNota;
    private List<Alumno> lstAlumnoFinal;
    private List<SelectItem> lstSIAlumno;
    private List<SelectItem> lstSIProyectoAlumno;
    private List<SelectItem> lstSIAlumnoProyectoBy;
    private List<Alumno> selectedAlu;
    private List<ProyectoAlumno> lstProyectoAlumno;
    private Alumno alu;
    private Alumno alu1;
    private ProyectoAlumno proAlu;
     private ProyectoAlumno proyAlumno;
      public List<NotaFinalAlumno> lstAlumnoNotas2;
      
    
    public NotaFinalAlumno notaFinalAlu;
    

    public ListaAlumnoBean() {
        System.out.println("Constructor ListaAlumnoBean");
        lstAlumno = new ArrayList<Alumno>();
        lstAlumnoProyecto = new ArrayList<ProyectoAlumno>();
        lstAlumnoProyectoNota = new ArrayList<NotaFinalAlumno>();
        lstAlumnoFinal = new ArrayList<Alumno>();
        alu1 = new Alumno();
        proAlu = new ProyectoAlumno();
         this.proyAlumno = new ProyectoAlumno();
           this.lstAlumnoNotas2 = new ArrayList<NotaFinalAlumno>();
        this.notaFinalAlu = new NotaFinalAlumno();
         
    }

    public ProyectoAlumnoRNLocal getProyectoAlumnoRNbeanLocal() {
        return proyectoAlumnoRNbeanLocal;
    }

    public List<SelectItem> getLstSIProyectoAlumno() {
        return lstSIProyectoAlumno;
    }

    public void setLstSIProyectoAlumno(List<SelectItem> lstSIProyectoAlumno) {
        this.lstSIProyectoAlumno = lstSIProyectoAlumno;
    }

    public Alumno getAlu1() {
        return alu1;
    }

    public void setAlu1(Alumno alu1) {
        this.alu1 = alu1;
    }

    public ProyectoAlumno getProAlu() {
        return proAlu;
    }

    public void setProAlu(ProyectoAlumno proAlu) {
        this.proAlu = proAlu;
    }

    public void setProyectoAlumnoRNbeanLocal(ProyectoAlumnoRNLocal proyectoAlumnoRNbeanLocal) {
        this.proyectoAlumnoRNbeanLocal = proyectoAlumnoRNbeanLocal;
    }

    public List<ProyectoAlumno> getLstProyectoAlumno() {
        return lstProyectoAlumno;
    }

    public void setLstProyectoAlumno(List<ProyectoAlumno> lstProyectoAlumno) {
        this.lstProyectoAlumno = lstProyectoAlumno;
    }

    public List<Alumno> getLstAlumnoFinal() {
        return lstAlumnoFinal;
    }

    public void setLstAlumnoFinal(List<Alumno> lstAlumnoFinal) {
        this.lstAlumnoFinal = lstAlumnoFinal;
    }

    public AlumnoRNLocal getAlumnoRNbeanLocal() {
        return alumnoRNbeanLocal;
    }

    public void setAlumnoRNbeanLocal(AlumnoRNLocal alumnoRNbeanLocal) {
        this.alumnoRNbeanLocal = alumnoRNbeanLocal;
    }

    public List<Alumno> getLstAlumno() {
        return lstAlumno;
    }

    public void setLstAlumno(List<Alumno> lstAlumno) {
        this.lstAlumno = lstAlumno;
    }

    public int getiActionBtnSelect() {
        return iActionBtnSelect;
    }

    public void setiActionBtnSelect(int iActionBtnSelect) {
        this.iActionBtnSelect = iActionBtnSelect;
    }

    public List<SelectItem> getLstSIAlumno() {
        return lstSIAlumno;
    }

    public void setLstSIAlumno(List<SelectItem> lstSIAlumno) {
        this.lstSIAlumno = lstSIAlumno;
    }

    public List<Alumno> getSelectedAlu() {
        return selectedAlu;
    }

    public void setSelectedAlu(List<Alumno> selectedAlu) {
        this.selectedAlu = selectedAlu;
    }

    public Alumno getAlu() {
        return alu;
    }

    public void setAlu(Alumno alu) {
        this.alu = alu;
    }

    public List<ProyectoAlumno> getLstAlumnoProyecto() {
        return lstAlumnoProyecto;
    }

    public void setLstAlumnoProyecto(List<ProyectoAlumno> lstAlumnoProyecto) {
        this.lstAlumnoProyecto = lstAlumnoProyecto;
    }

    public List<SelectItem> getLstSIAlumnoProyectoBy() {
        return lstSIAlumnoProyectoBy;
    }

    public void setLstSIAlumnoProyectoBy(List<SelectItem> lstSIAlumnoProyectoBy) {
        this.lstSIAlumnoProyectoBy = lstSIAlumnoProyectoBy;
    }

    public List<NotaFinalAlumno> getLstAlumnoProyectoNota() {
        return lstAlumnoProyectoNota;
    }

    public void setLstAlumnoProyectoNota(List<NotaFinalAlumno> lstAlumnoProyectoNota) {
        this.lstAlumnoProyectoNota = lstAlumnoProyectoNota;
    }

    public ProyectoAlumno getProyAlumno() {
        return proyAlumno;
    }

    public void setProyAlumno(ProyectoAlumno proyAlumno) {
        this.proyAlumno = proyAlumno;
    }

    public List<NotaFinalAlumno> getLstAlumnoNotas() {
        return lstAlumnoNotas2;
    }

    public void setLstAlumnoNotas(List<NotaFinalAlumno> lstAlumnoNotas) {
        this.lstAlumnoNotas2 = lstAlumnoNotas;
    }

    public NotaFinalAlumno getNotaFinalAlu() {
        return notaFinalAlu;
    }

    public void setNotaFinalAlu(NotaFinalAlumno notaFinalAlu) {
        this.notaFinalAlu = notaFinalAlu;
    }

    public List<NotaFinalAlumno> getLstAlumnoNotas2() {
        return lstAlumnoNotas2;
    }

    public void setLstAlumnoNotas2(List<NotaFinalAlumno> lstAlumnoNotas2) {
        this.lstAlumnoNotas2 = lstAlumnoNotas2;
    }

   
    /*
    @PostConstruct
    void init() {
        System.out.println("PostConstructor ListaProfesionalBean");
        this.limpiar();
        cargar_alumnos();
        cargar_SI_alumnos();
       // cargar_proyectos_alumnos();
      //  intercambiar();
     //  cargar_SI_proyecto_alumno();

    }*/

    public void cargar_alumnos() {
        try {
            this.setLstAlumno(this.alumnoRNbeanLocal.findAll());
        } catch (Exception ex) {
            System.out.println("Error al cargar alumnos " + ex.toString());
        }
    }

    public void cargar_SI_alumnos() {
        this.setLstSIAlumno(new ArrayList<SelectItem>());

        for (Alumno a : this.getLstAlumno()) {
            SelectItem si = new SelectItem(a, a.getApellido() + "," + a.getNombre());
            this.getLstSIAlumno().add(si);
        }
    }

    public void limpiar() {
       
        lstAlumnoProyecto = new ArrayList<ProyectoAlumno>();
        lstAlumnoProyectoNota = new ArrayList<NotaFinalAlumno>();
        lstAlumnoFinal = new ArrayList<Alumno>();
        alu1 = new Alumno();
        proAlu = new ProyectoAlumno();
         proyAlumno = new ProyectoAlumno();
           lstAlumnoNotas2 = new ArrayList<NotaFinalAlumno>();
        notaFinalAlu = new NotaFinalAlumno();
        
    }

    public void cargar_proyectos_alumnos() {
        try {
            this.setLstProyectoAlumno(this.proyectoAlumnoRNbeanLocal.findAll());
            System.out.println("los proyectos que tienen alumnos son" + lstProyectoAlumno);       
            intercambiar();
        } catch (Exception ex) {
            System.out.println("Error al cargar los alumnos que pertenecen a un proyecto" + ex.toString());
        }

    }
    
     public void cargar_proyectos_alumnos_byIdProy(Proyecto proy) {
         limpiar();
        try {
            
            this.setLstAlumnoProyecto(this.proyectoAlumnoRNbeanLocal.findByProyAlumno(proy));
            
                Iterator<ProyectoAlumno> it = lstAlumnoProyecto.iterator();

        while (it.hasNext()) {
            proyAlumno = it.next();

            notaFinalAlu.setAlumno(proyAlumno.getAlumno());
          
            lstAlumnoNotas2.add(notaFinalAlu);
             notaFinalAlu = new NotaFinalAlumno();
           
        }
        
        } catch (Exception ex) {
            System.out.println("Error al cargar los alumnos que pertenecen a un proyecto" + ex.toString());
        }
        
        cargar_SI_proyecto_alumnoByProy();

    }

    public void intercambiar() {
        if (!lstProyectoAlumno.isEmpty()) {
            System.out.println("entra por el if");

            for (Alumno alumnos : this.getLstAlumno()) {
                int i = 3;
                Iterator<ProyectoAlumno> p = lstProyectoAlumno.iterator();

                while (p.hasNext()) {
                    proAlu = p.next();
                    System.out.println("tripa");

                    if (!alumnos.getId().equals(proAlu.getAlumno().getId())) {
                        System.out.println("no son iguales");
                        i = 1;

                    } else {

                        System.out.println("son iguales");
                        i = 0;
                        break;

                    }

                }
                if (i == 1) {
                    lstAlumnoFinal.add(alumnos);
                }

            }
            System.out.println("el listado final es" + lstAlumnoFinal);

        } else {
            System.out.println("entra por el else");
            lstAlumnoFinal = lstAlumno;

        }

        /*
         if (lstProyectoAlumno != null) {
         int i = 0;
         Iterator<Alumno> a = lstAlumno.iterator();
         Iterator<ProyectoAlumno> p = lstProyectoAlumno.iterator();
         while (a.hasNext()) {
         if (i == 1) {

         lstAlumnoFinal.add(alu1);

         }

         alu1 = a.next();
         while (p.hasNext()) {
         proAlu = p.next();
         System.out.println("tripa");

         if (alu1.getId().equals(proAlu.getAlumno().getId())) {
         System.out.println("son iguales");
         i = 0;
         break;

         } else {
         System.out.println("no son iguales");
         i = 1;

         }

         }

         }
         System.out.println("los finales son" + lstAlumnoFinal);

         } else {
         lstAlumnoFinal = lstAlumno;
         }  */
    }

    public void cargar_SI_proyecto_alumno() {
        this.setLstSIProyectoAlumno(new ArrayList<SelectItem>());

        for (Alumno b : this.getLstAlumnoFinal()) {
            SelectItem vi = new SelectItem(b, b.getApellido() + "," + b.getNombre());
            this.getLstSIProyectoAlumno().add(vi);
        }

    }
    
      public void cargar_SI_proyecto_alumnoByProy() {
          
          
          this.setLstSIAlumnoProyectoBy(new ArrayList<SelectItem>());
        

        for (NotaFinalAlumno b : this.getLstAlumnoNotas2()) {
            
            SelectItem vi = new SelectItem(b, b.getAlumno().getApellido() + "," + b.getAlumno().getNombre());
            this.getLstSIAlumnoProyectoBy().add(vi);
        }
        

    }
      
     public String aluStyleClass(Alumno alu) {
         
    if(alu.getId().equals(3L)){
          return "colored";
    } 
    
    return null;
}
     

}