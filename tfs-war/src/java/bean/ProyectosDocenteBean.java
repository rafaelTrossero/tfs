/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.ProyectoRNbeanLocal;
import entidad.Carrera;
import entidad.Depto;
import entidad.Docente;
import entidad.docente_proyecto;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

/**
 *
 * @author Cristian PC
 */
@ManagedBean
@RequestScoped
public class ProyectosDocenteBean {

    @ManagedProperty("#{listaProyectoBean}")
    private ListaProyectoBean listaProyectoBean;
    private Carrera carrera;
    private Depto departamento;
    private Docente docente;
    private docente_proyecto doc_proyecto;
    private List<docente_proyecto> lstdoc_proyecto;
     private final String escudo1 = FacesContext.getCurrentInstance().getExternalContext().getRealPath("\\Imagenes\\nuevoLogoFacultad2.jpg");
    private final String escudo2 = FacesContext.getCurrentInstance().getExternalContext().getRealPath("\\Imagenes\\escudo.jpg");
      private final String sub_report1= FacesContext.getCurrentInstance().getExternalContext().getRealPath("\\reports");
      private final String sub_report2= FacesContext.getCurrentInstance().getExternalContext().getRealPath("\\reports\\proyecto_como_codirector");
       private final String sub_report3= FacesContext.getCurrentInstance().getExternalContext().getRealPath("\\reports\\proyecto_como_asesor");
     
     public ProyectosDocenteBean() {
        carrera = new Carrera();
        departamento = new Depto();
        docente = new Docente();
        doc_proyecto = new docente_proyecto();
        lstdoc_proyecto = new ArrayList<docente_proyecto>();
    }

    @EJB
    private ProyectoRNbeanLocal proyectoRNbeanLocal;

    /**
     * Creates a new instance of ProyectosCarreraBean
     */
    public ListaProyectoBean getListaProyectoBean() {
        return listaProyectoBean;
    }

    public void setListaProyectoBean(ListaProyectoBean listaProyectoBean) {
        this.listaProyectoBean = listaProyectoBean;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Depto getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Depto departamento) {
        this.departamento = departamento;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
    /*
     public docente_proyecto getDoc_proyecto() {
     return doc_proyecto;
     }

     public void setDoc_proyecto(docente_proyecto doc_proyecto) {
     this.doc_proyecto = doc_proyecto;
     }

     public List<docente_proyecto> getLstdoc_proyecto() {
     return lstdoc_proyecto;
     }

     public void setLstdoc_proyecto(List<docente_proyecto> lstdoc_proyecto) {
     this.lstdoc_proyecto = lstdoc_proyecto;
     }
     */

    public void crear() throws Exception {
        System.out.println("la carrera seleccionada es " + docente);
        listaProyectoBean.cargar_proyectos_director_docente(docente);
        listaProyectoBean.cargar_proyectos_codirector_docente(docente.getId());
        listaProyectoBean.cargar_proyectos_asesor_docente(docente.getId());
    }

    /**
     * Creates a new instance of ProyectosDocenteBean
     */
    public void imprimir() throws IOException {
        /*
        proyectodocente a = new proyectodocente();
        List<proyectodocente> lstproydocente = new ArrayList<proyectodocente>();
        doc_proyecto.setLstProyectoDirectorDocente(listaProyectoBean.getLstProyectoDirectorDocente());
        doc_proyecto.setLstProyectoCodirectorDocente(listaProyectoBean.getLstProyectoCodirectorDocente());
        doc_proyecto.setLstProyectoAsesorDocente(listaProyectoBean.getLstProyectoAsesorDocente());
        lstdoc_proyecto.add(doc_proyecto);
        for (int i = 0; i < listaProyectoBean.getLstProyectoDirectorDocente().size(); i++) {
            a.setProyecto(listaProyectoBean.getLstProyectoDirectorDocente().get(i).getProyecto().getTitulo());
            a.setRol("Director");
            lstproydocente.add(a);
        }
        a=new proyectodocente();
        for (int i = 0; i < listaProyectoBean.getLstProyectoCodirectorDocente().size(); i++) {
            a.setProyecto(listaProyectoBean.getLstProyectoCodirectorDocente().get(i).getProyecto().getTitulo());
            a.setRol("Co-director");
            lstproydocente.add(a);
        }
         a=new proyectodocente();
        for (int i = 0; i < listaProyectoBean.getLstProyectoAsesorDocente().size(); i++) {
            a.setProyecto(listaProyectoBean.getLstProyectoAsesorDocente().get(i).getProyecto().getTitulo());
            a.setRol("Asesor");
            lstproydocente.add(a);
        }
        String path;
        //List<Object[]> l = turnoRNLocal.findHistorialTurnosServicios(1, this.getFechaInicio(), this.getFechaFin());
        System.out.println("funcionando");

        try {
            path = "reports\\proyecto_docente.jasper";
            FacesContext context = FacesContext.getCurrentInstance();
            System.out.println("entrooooooooooooooooooooooooooooooo1" + path);
            String reportPath = context.getExternalContext().getRealPath(path);
            System.out.println("entrooooooooooooooooooooooooooooooo2" + reportPath);

            /*
             //HashMap parametro = new HashMap();
             //System.out.println("entrooooooooooooooooooooooooooooooo3"+reportPath);
             //parametro.put("lista_codirector",listaProyectoBean.getLstProyectoCodirectorDocente());
           
             */
            /*HashMap parametro = new HashMap();
            parametro.put("Docente",docente.getApellido() + " , " + docente.getNombre());
            parametro.put("Cantidad",listaProyectoBean.getLstProyectoDirectorDocente().size() + listaProyectoBean.getLstProyectoCodirectorDocente().size() +listaProyectoBean.getLstProyectoAsesorDocente().size());
            //System.out.println("entroooooooooooo000oooooooooooooooo4" + parametro);

            JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(lstproydocente);
            System.out.println("entroooooooooooooooooooooooooooo5" + parametro);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, parametro, beanCollectionDataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, context.getExternalContext().getRealPath("reports\\proyecto_docente.pdf"));
            System.out.println("entroooooooooooooooooooooooooooo6" + parametro);

            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());
            exporter.exportReport();
            context.responseComplete();

        } catch (Exception ex) {
            System.out.println(ex + "CAUSAaaaaaaaaaaaaaaaaaaaaaa: " + ex.getCause().getMessage());
        }
   */
    }
    public void setearDocenteProyecto() throws SQLException {
       
        Connection conect;
        conect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tfs-ftyca", "postgres", "123456");
         System.out.println("funcionando"+ conect);
        String path;
        //List<Object[]> l = turnoRNLocal.findHistorialTurnosServicios(1, this.getFechaInicio(), this.getFechaFin());
        System.out.println("funcionando");

        try {
            path = "reports\\proyecto_docente.jasper";
            FacesContext context = FacesContext.getCurrentInstance();
            System.out.println("entrooooooooooooooooooooooooooooooo1" + path);
            String reportPath = context.getExternalContext().getRealPath(path);
            System.out.println("entrooooooooooooooooooooooooooooooo2" + reportPath);

            HashMap parametro = new HashMap();
            System.out.println("entrooooooooooooooooooooooooooooooo3" + reportPath);
            parametro.put("Docente",docente.getId());
            parametro.put("nombre_docente",docente.getApellido() + " , " +docente.getNombre() );
            parametro.put("escudo1",escudo1 );
            parametro.put("escudo2",escudo2 );
            parametro.put("SUBREPORT_DIR",sub_report1+"\\" );
           parametro.put("sub_report2",sub_report2 );
           parametro.put("sub_report3",sub_report3 );
          
            System.out.println("entroooooooooooo000oooooooooooooooo4" + parametro);

            JRBeanCollectionDataSource beanCollectionDataSource = null;
            System.out.println("entroooooooooooooooooooooooooooo5" + parametro);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, parametro, conect);
            JasperExportManager.exportReportToPdfFile(jasperPrint, context.getExternalContext().getRealPath("reports\\proyecto_docente.pdf"));
            System.out.println("entroooooooooooooooooooooooooooo6" + parametro);

            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());
            exporter.exportReport();
            context.responseComplete();
           //conect.close();

        } catch (Exception ex) {
            System.out.println(ex + "CAUSAaaaaaaaaaaaaaaaaaaaaaa: " + ex.getCause().getMessage());
        }

    }
}
