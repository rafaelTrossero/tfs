/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import RN.AceptacionRNLocal;
import RN.BorradorEvaluacionRNLocal;
import RN.BorradorRNLocal;
import RN.DocenteRNLocal;
import RN.EvaluacionProyectoRNLocal;
import RN.PresentacionRNLocal;
import RN.ProyectoAlumnoRNLocal;
import RN.ProyectoAsesorRNLocal;
import RN.ProyectoCodirectorRNLocal;
import RN.ProyectoDirectorRNLocal;
import RN.ProyectoRNbeanLocal;
import RN.ProyectoTribunalRNLocal;
import RN.TribunalRNLocal;
import entidad.Aceptacion;
import entidad.Borrador;
import entidad.BorradorEvaluacion;
import entidad.Docente;
import entidad.EvaluacionProyecto;
import entidad.Operacion;
import entidad.Presentacion;
import entidad.Profesional;
import entidad.Proyecto;
import entidad.ProyectoAlumno;
import entidad.ProyectoAsesor;
import entidad.ProyectoCodirector;
import entidad.ProyectoDirector;
import entidad.ProyectoTribunal;
import entidad.Tribunal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Cristian PC
 */
@ManagedBean
@SessionScoped
public class ListaMisProyectosBean implements Serializable {

    /**
     * Creates a new instance of ListaMisProyectosBean
     */
    
     @ManagedProperty("#{listaProyectoBean}")
    private ListaProyectoBean listaProyectoBean;
    @ManagedProperty("#{listaOperacionBean}")
    private ListaOperacionBean listaOperacionBean;
    @ManagedProperty("#{listaProfesionalBean}")
    private ListaProfesionalBean listaProfesionalBean;
    
    
    private List<ProyectoDirector> lstProyDirector;
    private ProyectoDirector proy_director;
    private List<ProyectoAsesor> lstProyAsesor;
    private List<ProyectoCodirector> lstProyCodirector;
    private ProyectoAsesor proy_asesor;
    private ProyectoCodirector proy_codirector;
    private ProyectoAsesor proy_asesnovo;
    private ProyectoCodirector proy_codirnovo;
    private List<SelectItem> lstSIasesor;
    private List<SelectItem> lstSIcodirector;
    private Profesional proy_ases;
    private Profesional proy_codir;
    private List<ProyectoAsesor> selectedAses;
    private List<ProyectoCodirector> selectedCodirectores;
    private List<Profesional> asesoresSelect;
    private List<Profesional> codirectoresSelect;
    private CommandButton cbAction;
    private String observacion;
    private String obs;
    private List<ProyectoAlumno> lstProyAlumno;
    private final boolean active= true;
    private EvaluacionProyecto evaluacion_Proyecto;
    private EvaluacionProyecto evaluacion;
    private BorradorEvaluacion brr_evaluacion;
    private Borrador borrador;
    private List<EvaluacionProyecto> lstevaluacion;
    private List<BorradorEvaluacion> lstBorradorEvaluacion;
     private List<Aceptacion> lstAceptacionProyecto;
    
    @EJB
    private ProyectoDirectorRNLocal proy_directorRNbeanLocal;
    @EJB
    private ProyectoAsesorRNLocal proy_asesorRNbeanLocal;
    @EJB
    private ProyectoCodirectorRNLocal proy_codirectorRNbeanLocal;
    @EJB
    private ProyectoRNbeanLocal proyectoRNbeanLocal;
    

    private ProyectoDirector proy_direc;
    private Proyecto proyecto;

    private String NuevoTitulo;
    private Tribunal resulTribunal;

    @EJB
    private TribunalRNLocal tribunalRNbeanLocal;
    @EJB
    private AceptacionRNLocal aceptacionRNbeanLocal;
     @EJB
    private PresentacionRNLocal presentacionRNbeanLocal;
    @EJB
    private DocenteRNLocal docenteRNLocal;
    @EJB
    private ProyectoTribunalRNLocal proy_tribunalRNbeanLocal;
     @EJB
    private ProyectoAlumnoRNLocal proy_alumnoRNbeanLocal;
       @EJB
    private EvaluacionProyectoRNLocal evaluacion_ProyectoRNeanLocal;
        @EJB
    private BorradorRNLocal borradorRNbeanLocal;
        @EJB
    private BorradorEvaluacionRNLocal brr_evaluacionRNbeanLocal;

    private Docente presidente;
    private Docente vocal1;
    private Docente vocal2;
    private Docente suplente1;
    private Docente suplente2;
    private Tribunal tribunal;
    private List<Docente> lstDocenteTribunal;
    private Aceptacion aceptacion;
    private Docente docente;
    private ProyectoTribunal proy_tribunal;
    private Date fecha_actual;
   private Long presentacionCodigo;
   private Long id_borrador;
   private final boolean requisito = true;
    private String observacionBaja;
    private String ObservacionBajaCodirector;
    private Presentacion presentacion;
    
    public ListaMisProyectosBean() {
        proyecto = new Proyecto();
        this.proy_direc = new ProyectoDirector();
        this.proy_director = new ProyectoDirector();
        this.proy_asesor = new ProyectoAsesor();
        this.proy_codirector = new ProyectoCodirector();
        this.selectedAses = new ArrayList<ProyectoAsesor>();
        this.selectedCodirectores = new ArrayList<ProyectoCodirector>();
        this.lstevaluacion = new ArrayList<EvaluacionProyecto>();
        this.proy_asesnovo = new ProyectoAsesor();
        this.proy_codirnovo = new ProyectoCodirector();
        this.proy_tribunal = new ProyectoTribunal();
        this.tribunal = new Tribunal();
        this.resulTribunal = new Tribunal();
        this.asesoresSelect = new ArrayList<Profesional>();
        this.evaluacion_Proyecto = new EvaluacionProyecto();
        this.evaluacion = new EvaluacionProyecto();
        this.docente = new Docente();
        this.brr_evaluacion = new BorradorEvaluacion();
        this.borrador = new Borrador();
    }

   
    public List<ProyectoAlumno> getLstProyAlumno() {
        return lstProyAlumno;
    }

    public void setLstProyAlumno(List<ProyectoAlumno> lstProyAlumno) {
        this.lstProyAlumno = lstProyAlumno;
    }

    public List<EvaluacionProyecto> getLstevaluacion() {
        return lstevaluacion;
    }

    public void setLstevaluacion(List<EvaluacionProyecto> lstevaluacion) {
        this.lstevaluacion = lstevaluacion;
    }

    public List<BorradorEvaluacion> getLstBorradorEvaluacion() {
        return lstBorradorEvaluacion;
    }

    public void setLstBorradorEvaluacion(List<BorradorEvaluacion> lstBorradorEvaluacion) {
        this.lstBorradorEvaluacion = lstBorradorEvaluacion;
    }

    public List<Aceptacion> getLstAceptacionProyecto() {
        return lstAceptacionProyecto;
    }

    public void setLstAceptacionProyecto(List<Aceptacion> lstAceptacionProyecto) {
        this.lstAceptacionProyecto = lstAceptacionProyecto;
    }

  
    

    public BorradorEvaluacion getBrr_evaluacion() {
        return brr_evaluacion;
    }

    public void setBrr_evaluacion(BorradorEvaluacion brr_evaluacion) {
        this.brr_evaluacion = brr_evaluacion;
    }

    public Borrador getBorrador() {
        return borrador;
    }

    public void setBorrador(Borrador borrador) {
        this.borrador = borrador;
    }

    public Long getId_borrador() {
        return id_borrador;
    }

    public void setId_borrador(Long id_borrador) {
        this.id_borrador = id_borrador;
    }

    public EvaluacionProyecto getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(EvaluacionProyecto evaluacion) {
        this.evaluacion = evaluacion;
    }

    
    public EvaluacionProyecto getEvaluacion_Proyecto() {
        return evaluacion_Proyecto;
    }

    public void setEvaluacion_Proyecto(EvaluacionProyecto evaluacion_Proyecto) {
        this.evaluacion_Proyecto = evaluacion_Proyecto;
    }

    public Long getPresentacionCodigo() {
        return presentacionCodigo;
    }

    public void setPresentacionCodigo(Long presentacionCodigo) {
        this.presentacionCodigo = presentacionCodigo;
    }

    public Presentacion getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Presentacion presentacion) {
        this.presentacion = presentacion;
    }

    public PresentacionRNLocal getPresentacionRNbeanLocal() {
        return presentacionRNbeanLocal;
    }

    public void setPresentacionRNbeanLocal(PresentacionRNLocal presentacionRNbeanLocal) {
        this.presentacionRNbeanLocal = presentacionRNbeanLocal;
    }

    public EvaluacionProyectoRNLocal getEvaluacion_ProyectoRNeanLocal() {
        return evaluacion_ProyectoRNeanLocal;
    }

    public void setEvaluacion_ProyectoRNeanLocal(EvaluacionProyectoRNLocal evaluacion_ProyectoRNeanLocal) {
        this.evaluacion_ProyectoRNeanLocal = evaluacion_ProyectoRNeanLocal;
    }

    public BorradorRNLocal getBorradorRNbeanLocal() {
        return borradorRNbeanLocal;
    }

    public void setBorradorRNbeanLocal(BorradorRNLocal borradorRNbeanLocal) {
        this.borradorRNbeanLocal = borradorRNbeanLocal;
    }

       
    public ProyectoAlumnoRNLocal getProy_alumnoRNbeanLocal() {
        return proy_alumnoRNbeanLocal;
    }

    public void setProy_alumnoRNbeanLocal(ProyectoAlumnoRNLocal proy_alumnoRNbeanLocal) {
        this.proy_alumnoRNbeanLocal = proy_alumnoRNbeanLocal;
    }
    
    

    public CommandButton getCbAction() {
        return cbAction;
    }

    public void setCbAction(CommandButton cbAction) {
        this.cbAction = cbAction;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public ListaProfesionalBean getListaProfesionalBean() {
        return listaProfesionalBean;
    }

    public void setListaProfesionalBean(ListaProfesionalBean listaProfesionalBean) {
        this.listaProfesionalBean = listaProfesionalBean;
    }

    public List<Profesional> getAsesoresSelect() {
        return asesoresSelect;
    }

    public void setAsesoresSelect(List<Profesional> asesoresSelect) {
        this.asesoresSelect = asesoresSelect;
    }

    public List<ProyectoAsesor> getSelectedAses() {
        return selectedAses;
    }

    public void setSelectedAses(List<ProyectoAsesor> selectedAses) {
        this.selectedAses = selectedAses;
    }

    public TribunalRNLocal getTribunalRNbeanLocal() {
        return tribunalRNbeanLocal;
    }

    public void setTribunalRNbeanLocal(TribunalRNLocal tribunalRNbeanLocal) {
        this.tribunalRNbeanLocal = tribunalRNbeanLocal;
    }

    public AceptacionRNLocal getAceptacionRNbeanLocal() {
        return aceptacionRNbeanLocal;
    }

    public void setAceptacionRNbeanLocal(AceptacionRNLocal aceptacionRNbeanLocal) {
        this.aceptacionRNbeanLocal = aceptacionRNbeanLocal;
    }

    public DocenteRNLocal getDocenteRNLocal() {
        return docenteRNLocal;
    }

    public void setDocenteRNLocal(DocenteRNLocal docenteRNLocal) {
        this.docenteRNLocal = docenteRNLocal;
    }

    public ProyectoTribunalRNLocal getProy_tribunalRNbeanLocal() {
        return proy_tribunalRNbeanLocal;
    }

    public void setProy_tribunalRNbeanLocal(ProyectoTribunalRNLocal proy_tribunalRNbeanLocal) {
        this.proy_tribunalRNbeanLocal = proy_tribunalRNbeanLocal;
    }

    public String getObservacionBajaCodirector() {
        return ObservacionBajaCodirector;
    }

    public void setObservacionBajaCodirector(String ObservacionBajaCodirector) {
        this.ObservacionBajaCodirector = ObservacionBajaCodirector;
    }

    public List<ProyectoAsesor> getLstProyAsesor() {
        return lstProyAsesor;
    }

    public void setLstProyAsesor(List<ProyectoAsesor> lstProyAsesor) {
        this.lstProyAsesor = lstProyAsesor;
    }

    public ProyectoAsesor getProy_asesor() {
        return proy_asesor;
    }

    public void setProy_asesor(ProyectoAsesor proy_asesor) {
        this.proy_asesor = proy_asesor;
    }

    public Profesional getProy_ases() {
        return proy_ases;
    }

    public void setProy_ases(Profesional proy_ases) {
        this.proy_ases = proy_ases;
    }

    public ProyectoAsesor getProy_asesnovo() {
        return proy_asesnovo;
    }

    public void setProy_asesnovo(ProyectoAsesor proy_asesnovo) {
        this.proy_asesnovo = proy_asesnovo;
    }

    public List<SelectItem> getLstSIasesor() {
        return lstSIasesor;
    }

    public void setLstSIasesor(List<SelectItem> lstSIasesor) {
        this.lstSIasesor = lstSIasesor;
    }

    public List<SelectItem> getLstSIcodirector() {
        return lstSIcodirector;
    }

    public void setLstSIcodirector(List<SelectItem> lstSIcodirector) {
        this.lstSIcodirector = lstSIcodirector;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public ProyectoDirector getProy_direc() {
        return proy_direc;
    }

    public void setProy_direc(ProyectoDirector proy_direc) {
        this.proy_direc = proy_direc;
    }

    public List<ProyectoDirector> getLstProyDirector() {
        return lstProyDirector;
    }

    public void setLstProyDirector(List<ProyectoDirector> lstProyDirector) {
        this.lstProyDirector = lstProyDirector;
    }

    public ProyectoDirector getProy_director() {
        return proy_director;
    }

    public void setProy_director(ProyectoDirector proy_director) {
        this.proy_director = proy_director;
    }

    public ListaProyectoBean getListaProyectoBean() {
        return listaProyectoBean;
    }

    public void setListaProyectoBean(ListaProyectoBean listaProyectoBean) {
        this.listaProyectoBean = listaProyectoBean;
    }

    public ListaOperacionBean getListaOperacionBean() {
        return listaOperacionBean;
    }

    public void setListaOperacionBean(ListaOperacionBean listaOperacionBean) {
        this.listaOperacionBean = listaOperacionBean;
    }

    public String getNuevoTitulo() {
        return NuevoTitulo;
    }

    public void setNuevoTitulo(String NuevoTitulo) {
        this.NuevoTitulo = NuevoTitulo;
    }

    public List<ProyectoCodirector> getLstProyCodirector() {
        return lstProyCodirector;
    }

    public void setLstProyCodirector(List<ProyectoCodirector> lstProyCodirector) {
        this.lstProyCodirector = lstProyCodirector;
    }

    public List<ProyectoCodirector> getSelectedCodirectores() {
        return selectedCodirectores;
    }

    public void setSelectedCodirectores(List<ProyectoCodirector> selectedCodirectores) {
        this.selectedCodirectores = selectedCodirectores;
    }

    public ProyectoCodirector getProy_codirnovo() {
        return proy_codirnovo;
    }

    public void setProy_codirnovo(ProyectoCodirector proy_codirnovo) {
        this.proy_codirnovo = proy_codirnovo;
    }

    public Profesional getProy_codir() {
        return proy_codir;
    }

    public void setProy_codir(Profesional proy_codir) {
        this.proy_codir = proy_codir;
    }

    public List<Profesional> getCodirectoresSelect() {
        return codirectoresSelect;
    }

    public void setCodirectoresSelect(List<Profesional> codirectoresSelect) {
        this.codirectoresSelect = codirectoresSelect;
    }

    public ProyectoDirectorRNLocal getProy_directorRNbeanLocal() {
        return proy_directorRNbeanLocal;
    }

    public void setProy_directorRNbeanLocal(ProyectoDirectorRNLocal proy_directorRNbeanLocal) {
        this.proy_directorRNbeanLocal = proy_directorRNbeanLocal;
    }

    public ProyectoAsesorRNLocal getProy_asesorRNbeanLocal() {
        return proy_asesorRNbeanLocal;
    }

    public void setProy_asesorRNbeanLocal(ProyectoAsesorRNLocal proy_asesorRNbeanLocal) {
        this.proy_asesorRNbeanLocal = proy_asesorRNbeanLocal;
    }

    public ProyectoCodirectorRNLocal getProy_codirectorRNbeanLocal() {
        return proy_codirectorRNbeanLocal;
    }

    public void setProy_codirectorRNbeanLocal(ProyectoCodirectorRNLocal proy_codirectorRNbeanLocal) {
        this.proy_codirectorRNbeanLocal = proy_codirectorRNbeanLocal;
    }

    public ProyectoRNbeanLocal getProyectoRNbeanLocal() {
        return proyectoRNbeanLocal;
    }

    public void setProyectoRNbeanLocal(ProyectoRNbeanLocal proyectoRNbeanLocal) {
        this.proyectoRNbeanLocal = proyectoRNbeanLocal;
    }

    public ProyectoCodirector getProy_codirector() {
        return proy_codirector;
    }

    public void setProy_codirector(ProyectoCodirector proy_codirector) {
        this.proy_codirector = proy_codirector;
    }

    public Docente getPresidente() {
        return presidente;
    }

    public void setPresidente(Docente presidente) {
        this.presidente = presidente;
    }

    public Docente getVocal1() {
        return vocal1;
    }

    public void setVocal1(Docente vocal1) {
        this.vocal1 = vocal1;
    }

    public Docente getVocal2() {
        return vocal2;
    }

    public void setVocal2(Docente vocal2) {
        this.vocal2 = vocal2;
    }

    public Docente getSuplente1() {
        return suplente1;
    }

    public void setSuplente1(Docente suplente1) {
        this.suplente1 = suplente1;
    }

    public Docente getSuplente2() {
        return suplente2;
    }

    public void setSuplente2(Docente suplente2) {
        this.suplente2 = suplente2;
    }

    public Tribunal getTribunal() {
        return tribunal;
    }

    public void setTribunal(Tribunal tribunal) {
        this.tribunal = tribunal;
    }

    public List<Docente> getLstDocenteTribunal() {
        return lstDocenteTribunal;
    }

    public void setLstDocenteTribunal(List<Docente> lstDocenteTribunal) {
        this.lstDocenteTribunal = lstDocenteTribunal;
    }

    public Aceptacion getAceptacion() {
        return aceptacion;
    }

    public void setAceptacion(Aceptacion aceptacion) {
        this.aceptacion = aceptacion;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public ProyectoTribunal getProy_tribunal() {
        return proy_tribunal;
    }

    public void setProy_tribunal(ProyectoTribunal proy_tribunal) {
        this.proy_tribunal = proy_tribunal;
    }

    public Date getFecha_actual() {
        return fecha_actual;
    }

    public void setFecha_actual(Date fecha_actual) {
        this.fecha_actual = fecha_actual;
    }

    public String getObservacionBaja() {
        return observacionBaja;
    }

    public void setObservacionBaja(String observacionBaja) {
        this.observacionBaja = observacionBaja;
    }

    public Tribunal getResulTribunal() {
        return resulTribunal;
    }
    

    public void setResulTribunal(Tribunal resulTribunal) {
        this.resulTribunal = resulTribunal;
    }
    

    public void crear() throws Exception {
      
        this.setLstProyAlumno(proy_alumnoRNbeanLocal.findByProyAlumno(proyecto));
        if (lstProyAlumno == null) {
            System.out.println("hoooooooooooooooooooooooooooooooooooooooooooooollllllllllllllaaaaaaaaaaa" + lstProyAlumno + proyecto.getId());

        } else {
            System.out.println(" else llllllllllllllllaaaaaaaaaaa" + lstProyAlumno + proyecto.getId());
        }
        
        
        
        /* presentacionCodigo = this.presentacionRNbeanLocal.findPresCodigo(proyecto, requisito);
        
         if(presentacionCodigo != null){
          presentacion = this.presentacionRNbeanLocal.findByPresentacion(presentacionCodigo);
          evaluacion.setPresentacion(presentacion);
         this.setEvaluacion(evaluacion_ProyectoRNeanLocal.findByEvaluacionl(proyecto, evaluacion.getPresentacion()));
         }*/
        
        
        System.out.println("proID" + proyecto.getId());
        this.setLstevaluacion(evaluacion_ProyectoRNeanLocal.findByEvaluacionByProyecto(proyecto));
      //  this.setLstevaluacion(evaluacion_ProyectoRNeanLocal.findByEvaluacion(proyecto));
        if (lstevaluacion == null) {
            System.out.println("evaluacion" + lstevaluacion + proyecto.getId());

        } else {
            System.out.println(" si hay evaluaciones" + lstevaluacion + proyecto.getId());
        }
        
        System.out.println("proIDBorrador" + proyecto.getId());
        this.setLstBorradorEvaluacion(brr_evaluacionRNbeanLocal.findByEvaluacionBorrador(proyecto));
        if (lstBorradorEvaluacion == null) {
            System.out.println("borrador" + lstBorradorEvaluacion + proyecto.getId());

        } else {
            System.out.println(" si hay borradores" + lstBorradorEvaluacion + proyecto.getId());
        }
        
        //this.setAceptacion(aceptacionRNbeanLocal.findByProyAceptacion1(proyecto));
        
         System.out.println("proIDBorrador" + proyecto.getId());
        this.setLstAceptacionProyecto(aceptacionRNbeanLocal.findByAceptacion1(proyecto));
        if (lstAceptacionProyecto == null) {
            System.out.println("aceptacion" + lstAceptacionProyecto + proyecto.getId());

        } else {
            System.out.println(" si hay aceptaciones" + lstAceptacionProyecto + proyecto.getId());
        }
         
         /*id_borrador = borradorRNbeanLocal.findByProyecto(proyecto);
            System.out.println("hhhhhhhhhaaaaaaaaaaaaaahhhhhhhhhh" + id_borrador);
            if(id_borrador != null){
                
               borrador = this.borradorRNbeanLocal.findById(id_borrador);
            //brr_evaluacion.setBorrador(borradorRNbeanLocal.findById(id_borrador));
            brr_evaluacion.setBorrador(borrador);
            
            }*/
        cargarComision();
        creardirector() ;
        crearCodirector();
        crearasesor();

      /* 
         this.setProy_tribunal(tribunalRNbeanLocal.findByProy_Tribunal(proyecto, true));
        System.out.println(" LO QUE TIENE PROY_TRIBUNAL ES  " + proy_tribunal);
        //   this.setLstDocenteTribunal(docenteRNLocal.findByDocenteTribunal(proy_tribunal.getTribunal().getPresidente(), proy_tribunal.getTribunal().getVocal1(), proy_tribunal.getTribunal().getVocal2(), proy_tribunal.getTribunal().getSuplente1(), proy_tribunal.getTribunal().getSuplente2()));
        // this.setLstDocenteTribunal(docenteRNLocal.findByDocenteTribunal(9, 6, 2, 4, 5)); 

        System.out.println(" lista docente tribunal " + lstDocenteTribunal);

        Iterator<Docente> it = lstDocenteTribunal.iterator();

        while (it.hasNext()) {
            docente = it.next();

            if (docente.getId().equals(proy_tribunal.getTribunal().getPresidente())) {
                System.out.println("pqpqpqpqppq" + docente.getId() + "asas" + proy_tribunal.getTribunal().getPresidente());
                this.setPresidente(docente);
            }
            if (docente.getId().equals(proy_tribunal.getTribunal().getVocal1())) {
                this.setVocal1(docente);
            }
            if (docente.getId().equals(proy_tribunal.getTribunal().getVocal2())) {
                this.setVocal2(docente);
            }
            if (docente.getId().equals(proy_tribunal.getTribunal().getSuplente1())) {
                this.setSuplente1(docente);
            }
            if (docente.getId().equals(proy_tribunal.getTribunal().getSuplente2())) {
                this.setSuplente2(docente);
            }

        }
*/
    }
      public void cargarComision() throws Exception {

        proy_tribunal = this.tribunalRNbeanLocal.findByProy_Tribunal(proyecto, active);
         System.out.println(" registro proyectotribunal es,,," + proy_tribunal);
       
        if(proy_tribunal != null){
            
        this.setLstDocenteTribunal(docenteRNLocal.findByDocenteTribunal(proy_tribunal.getTribunal().getPresidente(), proy_tribunal.getTribunal().getVocal1(), proy_tribunal.getTribunal().getVocal2(), proy_tribunal.getTribunal().getSuplente1(), proy_tribunal.getTribunal().getSuplente2()));
        // this.setLstDocenteTribunal(docenteRNLocal.findByDocenteTribunal(9, 6, 2, 4, 5)); 

        System.out.println(" lista docente tribunal " + lstDocenteTribunal);

        Iterator<Docente> it = lstDocenteTribunal.iterator();

        while (it.hasNext()) {
            docente = it.next();

            if (docente.getId().equals(proy_tribunal.getTribunal().getPresidente())) {
                System.out.println("pqpqpqpqppq" + docente.getId() + "asas" + proy_tribunal.getTribunal().getPresidente());
                this.setPresidente(docente);
                System.out.println("el presi essss" + evaluacion_Proyecto.getPresidente() + "presiTribunal" + proy_tribunal.getTribunal().getPresidente());
            }
            if (docente.getId().equals(proy_tribunal.getTribunal().getVocal1())) {
               this.setVocal1(docente);
            }
            if (docente.getId().equals(proy_tribunal.getTribunal().getVocal2())) {
                this.setVocal2(docente);
            }
            if (docente.getId().equals(proy_tribunal.getTribunal().getSuplente1())) {
                this.setSuplente1(docente);
            }
            if (docente.getId().equals(proy_tribunal.getTribunal().getSuplente2())) {
                this.setSuplente2(docente);
            }

        }
         System.out.println("el objeto proy_tribunal es:::" + proy_tribunal);
        System.out.println("S1" + suplente1);}
      
    }
    
    public void crearCodirector() throws Exception {

        System.out.println("ahora para el proyecto");
        this.setLstProyDirector(proy_directorRNbeanLocal.findByProyDirector(proyecto));
        if (lstProyDirector == null) {
            System.out.println("h proyecto  no tiene nadallllllllllllllaaaaaaaaaaa" + lstProyDirector + proyecto.getId());

        } else {
            System.out.println(" SI HAY UN PROYECTO Y SU DIRECTOR ES" + lstProyDirector + proyecto.getId());
        }
        
        this.listaOperacionBean.setLstProyCodirector(proy_codirectorRNbeanLocal.findByProyCodirector(proyecto, true));
        System.out.println("LOS CODIRECTORES QUE ME TRAE SON" + lstProyCodirector);
        this.listaOperacionBean.cargar_SI_codirector();
        if (lstProyCodirector == null) {
            System.out.println("no hay CODIRECTORES cargados" + lstProyCodirector);

        } else {
            System.out.println(" si hay CODIRECTORES" + lstProyCodirector);

        }

      
    }

    public void creardirector() throws Exception {
        System.out.println("ahora para el proyecto");
        this.setLstProyDirector(proy_directorRNbeanLocal.findByProyDirector(proyecto));
        if (lstProyDirector == null) {
            System.out.println("h proyecto  no tiene nadallllllllllllllaaaaaaaaaaa" + lstProyDirector + proyecto.getId());

        } else {
            System.out.println(" SI HAY UN PROYECTO Y SU DIRECTOR ES" + lstProyDirector + proyecto.getId());
        }
    }

    public void crearasesor() throws Exception {
        this.listaOperacionBean.setLstProyAsesor(proy_asesorRNbeanLocal.findByProyAsesor(proyecto, true));
        System.out.println("LOS ASESORES QUE ME TRAE SON" + lstProyAsesor);
        this.listaOperacionBean.cargar_SI_asesor();
        if (lstProyAsesor == null) {
            System.out.println("no hay asesores cargados" + lstProyAsesor);

        } else {
            System.out.println(" si hay asesores" + lstProyAsesor);

        }

    }

    public void cargar_SI_asesor() {
        System.out.println("si pasa para cargar los asesores");
        this.setLstSIasesor(new ArrayList<SelectItem>());

        for (ProyectoAsesor d : this.getLstProyAsesor()) {
            System.out.println("los archivos son" + this.getLstProyAsesor());

            SelectItem si = new SelectItem(d, d.getProfesional().getApellido());

            this.getLstSIasesor().add(si);
            System.out.println("el selectitem" + si);

        }

    }

    public void cargar_SI_codirector() {
        System.out.println("si pasa para cargar los codirectores");
        this.setLstSIcodirector(new ArrayList<SelectItem>());

        for (ProyectoCodirector d : this.getLstProyCodirector()) {
            System.out.println("los CODIRECTORES son" + this.getLstProyCodirector());

            SelectItem si = new SelectItem(d, d.getProfesional().getApellido());

            this.getLstSIcodirector().add(si);
            System.out.println("el selectitem DE CODIRECTOR ES" + si);

        }

    }

    public void cargarOperacionSelect(SelectEvent event) {

        System.out.println(" entra a cargarOperacionSelect: ");
        Operacion operacion = ((Operacion) event.getObject());
        System.out.println(" operacion: " + operacion);

        this.getListaOperacionBean().setSelectedOpe(operacion);

        System.out.println(" operacion222222222: " + this.getListaOperacionBean().getSelectedOpe());

        /* if(selectedOpe.getId().equals(1L)){
         RequestContext context = RequestContext.getCurrentInstance();
       
         context.execute("dlgModProyecto1.show()");}*/
    }

    public void seleccionar_operacion() throws Exception {

        System.out.println("Posadasdasd" + this.getListaOperacionBean().getSelectedOpe());
        System.out.println("el proyecto es " + proyecto);
        if (this.getListaOperacionBean().getSelectedOpe().getId().equals(1L)) {

            RequestContext context = RequestContext.getCurrentInstance();

            context.execute("dlgModTitulo.show()");
            crear();
        }
        if (this.getListaOperacionBean().getSelectedOpe().getId().equals(2L)) {
            System.out.println("Pasapasapsasappsas");
            RequestContext context = RequestContext.getCurrentInstance();

            context.execute("dlgBajaDir.show()");
            creardirector();
        }
        if (this.getListaOperacionBean().getSelectedOpe().getId().equals(3L)) {
            System.out.println("Pasa para realizar el alta de codirector");
            RequestContext context = RequestContext.getCurrentInstance();

            context.execute("dlgAltaCodirector.show()");
             crearCodirector();
        }
        if (this.getListaOperacionBean().getSelectedOpe().getId().equals(4L)) {
            System.out.println("Pasa para realizar el alta de asesor");
            RequestContext context = RequestContext.getCurrentInstance();

            context.execute("dlgAltaAsesor.show()");
            crearasesor();
        }
        if (this.getListaOperacionBean().getSelectedOpe().getId().equals(5L)) {
            System.out.println("aquiaquiaquiaquiaqui");
            RequestContext context = RequestContext.getCurrentInstance();

            context.execute("dlgBajaDir2.show()");
            creardirector();
        }
        if (this.getListaOperacionBean().getSelectedOpe().getId().equals(6L)) {
            System.out.println("Pasa para realizar la baja de codirector");
            RequestContext context = RequestContext.getCurrentInstance();

            context.execute("dlgBajaCodirector.show()");
             crearCodirector();
        }
        if (this.getListaOperacionBean().getSelectedOpe().getId().equals(7L)) {
            System.out.println("asesorasesorasesor");
            RequestContext context = RequestContext.getCurrentInstance();

            context.execute("dlgBajaAsesor.show()");
            crearasesor();
        }
        if (this.getListaOperacionBean().getSelectedOpe().getId().equals(11L)) {

            RequestContext context = RequestContext.getCurrentInstance();

            context.execute("dlgBajaTribunal.show()");
            crear();
        }

        if (this.getListaOperacionBean().getSelectedOpe().getId().equals(10L)) {

            RequestContext context = RequestContext.getCurrentInstance();

            context.execute("dlgAltaTribunal.show()");

        }
         if (this.getListaOperacionBean().getSelectedOpe().getId().equals(13L)) {

            RequestContext context = RequestContext.getCurrentInstance();

            context.execute("dlgSeguimientoProyecto.show()");
            crear();
            creardirector();
            crearCodirector();
            crearasesor();
        }

    }

    public void alta_dir() throws Exception {
        System.out.println("Entro al alta dir");
        String sMensaje = "";
        String sDetalle = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {
            this.proy_direc.setProyecto(proyecto);
            this.proy_direc.setActive(Boolean.TRUE);

            proy_directorRNbeanLocal.create(proy_direc);

            sMensaje = "Director ha sido dado de alta correctamente";
            sDetalle = "El director que se dio de alta es :  " + proy_direc.getDocente().getApellido() + proy_direc.getDocente().getNombre();
            severity = FacesMessage.SEVERITY_INFO;
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("dlgBajaDir.hide()");

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al dar de alta: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, sDetalle);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }

    }

    public void baja_dir() throws Exception {
        System.out.println("Entro al baja dir");
        String sMensaje = "";
        String sDetalle = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {

            this.setProy_director(proy_directorRNbeanLocal.findProyDirectorActivo(proyecto, true));
            System.out.println("aaaaaaaaaaaaabbbbbbbbbbbbbbaccccccccc");
            if (proy_director == null) {

                throw new Exception("no se ha asignado un director");
            }

            System.out.println("el proyecto es" + proy_director.getProyecto().getTitulo());
            this.proy_director.setActive(Boolean.FALSE);
            System.out.println("el campo activo es" + proy_director.isActive());

            this.proy_director.setFecha(Date.class.newInstance());
            this.proy_director.setObservacion_baja(observacion);
            System.out.println("el campo observacion es " + proy_director.getObservacion_baja());
            System.out.println("el campo fecha es" + proy_director.getFecha());

            proy_directorRNbeanLocal.edit(proy_director);
            sDetalle = "El director que se dio de baja es :  " + proy_direc.getDocente().getApellido() + proy_direc.getDocente().getNombre();

            sMensaje = "Director ha sido dado de baja correctamente";
            severity = FacesMessage.SEVERITY_INFO;
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("dlgBajaDir2.hide()");

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al dar de baja: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, sDetalle);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }

    public void baja_as() throws Exception {
        System.out.println("::::::::::::::::ENTRO:::::::::::::::::::::::");
        System.out.println("el asesor seleccionado es: " + selectedAses);

    }

    public void baja_co() throws Exception {
        System.out.println("::::::::::::::::ENTRO:::::::::::::::::::::::");
        System.out.println("el codirector seleccionado es: " + selectedCodirectores);

    }

    public void alta_Asesor() throws Exception {
        System.out.println("Entro al alta asesor");
        String sMensaje = "";
        String sDetalle = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {

            System.out.println("el asesor seleccionado es: " + asesoresSelect);

            if (asesoresSelect == null) {
                throw new Exception("no se selecciono asesor");
            }

            Iterator<Profesional> ases = asesoresSelect.iterator();
            System.out.println("el archivo es " + asesoresSelect);

            while (ases.hasNext()) {
                this.proy_ases = new Profesional();
                proy_ases = ases.next();
                // System.out.println("hola" + alumno.getNombre());
                //proy_alu.setAlumno(alumno);
                proy_asesnovo.setProyecto(proyecto);
                proy_asesnovo.setActive(Boolean.TRUE);
                proy_asesnovo.setProfesional(proy_ases);

                System.out.println("los asesore que entran son::::::::::" + proy_asesnovo.getProfesional().getApellido() + proy_asesnovo.getProyecto().getTitulo() + proy_asesnovo.isActive());
                proy_asesorRNbeanLocal.create(proy_asesnovo);
                System.out.println("OOOKOKKKOOKKKOK" + proy_asesnovo.getProfesional().getApellido() + proy_asesnovo.getProyecto().getTitulo() + proy_asesnovo.isActive());
            }

            sMensaje = "asesor ha sido dado de alta correctamente";
            severity = FacesMessage.SEVERITY_INFO;

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al dar de alta: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, sDetalle);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }

    public void alta_Codirector() throws Exception {
        System.out.println("Entro al alta codirector");
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {

            System.out.println("el codirector seleccionado es: " + codirectoresSelect);

            Iterator<Profesional> codirector = codirectoresSelect.iterator();
            System.out.println("el archivo es " + codirectoresSelect);

            while (codirector.hasNext()) {
                this.proy_codir = new Profesional();
                proy_codir = codirector.next();
                // System.out.println("hola" + alumno.getNombre());
                //proy_alu.setAlumno(alumno);
                proy_codirnovo.setProyecto(proyecto);
                proy_codirnovo.setActive(Boolean.TRUE);
                proy_codirnovo.setProfesional(proy_codir);
                

                System.out.println("los asesore que entran son::::::::::" + proy_codirnovo.getProfesional().getApellido() + proy_codirnovo.getProyecto().getTitulo() + proy_codirnovo.isActive());
                proy_codirectorRNbeanLocal.create(proy_codirnovo);
                System.out.println("el archivo333 es " + proy_codirnovo.getProfesional());
            }

            sMensaje = "codirector ha sido dado de alta correctamente";
            severity = FacesMessage.SEVERITY_INFO;

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al dar de ALTA: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }

    public void baja_asesor() throws Exception {
        System.out.println("Entro al baja asesor");
        String sMensaje = "";
        FacesMessage fm;
        String sDetalle = "";
        FacesMessage.Severity severity = null;
        try {

            System.out.println("el asesor seleccionado es: " + selectedAses);
            if (selectedAses == null) {
                throw new Exception("no se selecciono asesor");
            }
            Iterator<ProyectoAsesor> it = selectedAses.iterator();
            System.out.println("el archivo es " + selectedAses);

            while (it.hasNext()) {
                proy_asesor = it.next();
                // System.out.println("hola" + alumno.getNombre());
                //proy_alu.setAlumno(alumno);
                proy_asesor.setActive(Boolean.FALSE);
                proy_asesor.setFecha_baja(Date.class.newInstance());
                proy_asesor.setObservacion_baja(obs);

                proy_asesorRNbeanLocal.edit(proy_asesor);
            }

            sMensaje = "asesor se ha dado de baja correctamente";
            severity = FacesMessage.SEVERITY_INFO;

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al dar de baja: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, sDetalle);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }

    public void baja_Codirector() throws Exception {
        System.out.println("Entro al baja codirector");
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {

            System.out.println("el codirector seleccionado es: " + selectedCodirectores);

            Iterator<ProyectoCodirector> cod = selectedCodirectores.iterator();
            System.out.println("el archivo es " + selectedCodirectores);

            while (cod.hasNext()) {
                proy_codirector = cod.next();
                // System.out.println("hola" + alumno.getNombre());
                //proy_alu.setAlumno(alumno);
                proy_codirector.setActive(Boolean.FALSE);
                proy_codirector.setObservacion_baja(ObservacionBajaCodirector);
                proy_codirector.setFecha_baja(Date.class.newInstance());

                proy_codirectorRNbeanLocal.edit(proy_codirector);
            }

            sMensaje = "codirector se ha dado de baja correctamente";
            severity = FacesMessage.SEVERITY_INFO;

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al dar de baja: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
        this.limpiar();
    }

    public void baja_tribunal() throws Exception {
        System.out.println("Entro al baja tribunal");
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {

            this.setProy_tribunal(tribunalRNbeanLocal.findByProy_Tribunal(proyecto, true));
            System.out.println("aaaaaaaaaaaaabbbbbbbbbbbbbbaccccccccc" + proy_tribunal);
            System.out.println("aaaaaaaaaaaaabbbbbbbbbbbbbbaccccccccc" + observacionBaja);
            //this.proy_tribunal.setFecha_baja(Date.from(Instant.now()));
            this.proy_tribunal.setActive(Boolean.FALSE);
            this.proy_tribunal.setObsevacion_baja(observacionBaja);

            proy_tribunalRNbeanLocal.edit(proy_tribunal);

            sMensaje = "Tribunal ha sido dado de baja correctamente";
            severity = FacesMessage.SEVERITY_INFO;

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al dar de baja: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
        this.limpiar();
    }

    public void alta_tribunal() throws Exception {
        System.out.println("Entro al alta tribunal");
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {

            tribunal.setPresidente(presidente.getId());

            tribunal.setVocal1(vocal1.getId());
            tribunal.setVocal2(vocal2.getId());
            tribunal.setSuplente1(suplente1.getId());
            tribunal.setSuplente2(suplente2.getId());

            tribunalRNbeanLocal.create(tribunal, proyecto);

            resulTribunal = this.tribunalRNbeanLocal.findByTribunal(tribunal.getResolucion(), tribunal.getPresidente(), tribunal.getVocal1(), tribunal.getVocal2(), tribunal.getSuplente1(), tribunal.getSuplente2());
            System.out.println("hasta aca a llegaooooooooooo el codigo del tribunal es:::::::::" + resulTribunal);
            this.proy_tribunal.setTribunal(resulTribunal);
            this.proy_tribunal.setProyecto(proyecto);
            this.proy_tribunal.setActive(Boolean.TRUE);

            proy_tribunalRNbeanLocal.create(proy_tribunal);

            sMensaje = "Tribunal ha sido dado de alta correctamente";
            severity = FacesMessage.SEVERITY_INFO;

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al dar de alta: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
        this.limpiar();

    }

    public void edit() {
        System.out.println("Entro al edit");
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {
            //get la fila seleccionada   

            System.out.println("el proyecto essssss" + this.getProyecto().getTitulo() + NuevoTitulo);
            proyecto.setActive(Boolean.TRUE);
            proyecto.setTitulo(NuevoTitulo);
            proyectoRNbeanLocal.edit(this.getProyecto());

            System.out.println("el TITULO NUEVO essssss" + this.getProyecto().getTitulo());

            sMensaje = "Datos actualizados correctamente";
            severity = FacesMessage.SEVERITY_INFO;

            //elimino y agrego el organismo modificado a la lista
            int iPos = this.getListaProyectoBean().getLstProyecto().indexOf(this.getProyecto());
            this.getListaProyectoBean().getLstProyecto().remove(iPos);
            this.getListaProyectoBean().getLstProyecto().add(iPos, this.getProyecto());

            //this.getCbAction().setValue("Update");
            //  this.setbCamposRequeridos(false);
        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Actualizacion error: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin edit

    public void activate() {
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;

        try {

            System.out.println("el asesor seleccionado es: " + proy_ases);

            sMensaje = "Director ha sido dado de baja correctamente";
            severity = FacesMessage.SEVERITY_INFO;
            /* alumnoRNbeanLocal.activate(this.getAlumno(), bEstado);
            

             //elimino el organismo de la lista
             //int iPos = this.getListaAlumnoBean().getLstAlumno()).indexOf(this.getAlumno());
             int iPos = this.getListaAlumnoBean().getLstAlumno().indexOf(this.getAlumno());

             this.setAlumno(this.getListaAlumnoBean().getLstAlumno().get(iPos));
             this.getAlumno().setActive(bEstado);
            
             this.getListaAlumnoBean().getLstAlumno().remove(iPos);
             this.getListaAlumnoBean().getLstAlumno().add(iPos, this.getAlumno());

             if (!bEstado) {
             sMensaje = "User desactivated succesfully";
             } else {
             sMensaje = "User reactivated succesfully ";
             }
             severity = FacesMessage.SEVERITY_INFO;

             this.getCbAction().setDisabled(true);

             //limíar campos
             this.clear();
             //this.setbCamposRequeridos(false);
             */

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "An error ocurred during activation: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }

    private void limpiar() {
        proyecto = new Proyecto();
        this.proy_direc = new ProyectoDirector();
        this.proy_director = new ProyectoDirector();
        this.proy_asesor = new ProyectoAsesor();
        this.proy_codirector = new ProyectoCodirector();
        this.selectedAses = new ArrayList<ProyectoAsesor>();
        this.selectedCodirectores = new ArrayList<ProyectoCodirector>();
        this.proy_asesnovo = new ProyectoAsesor();
        this.proy_codirnovo = new ProyectoCodirector();
        this.proy_tribunal = new ProyectoTribunal();
        this.tribunal = new Tribunal();
        this.resulTribunal = new Tribunal();
        this.presidente = new Docente();
        this.vocal1 = new Docente();
        this.vocal2 = new Docente();
        this.suplente1 = new Docente();
        this.suplente2 = new Docente();

    }
    
}
