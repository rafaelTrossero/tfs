/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DAO.EstadoFacadeLocal;
import entidad.Estado;
import entidad.Proyecto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;


import recursos.EstadisticasBean;

/**
 *
 * @author Cristian PC
 */
@ManagedBean
@SessionScoped
public class ListaSeguimientoBean {

    @ManagedProperty("#{estadisticasBean}")
    private EstadisticasBean estadisticasBean;
    @ManagedProperty("#{listaEspecialidadBean}")
    private ListaEspecialidadBean listaEspecialidadBean;
    String path;
    @EJB
    private EstadoFacadeLocal estadoFacadeLocal;
    private List<Estado> est = new ArrayList<Estado>();

    /**
     * Creates a new instance of ListaSeguimientoBean
     */
    public ListaSeguimientoBean() {

        est = new ArrayList<Estado>();
    }

    public ListaEspecialidadBean getListaEspecialidadBean() {
        return listaEspecialidadBean;
    }

    public void setListaEspecialidadBean(ListaEspecialidadBean listaEspecialidadBean) {
        this.listaEspecialidadBean = listaEspecialidadBean;
    }

    public EstadoFacadeLocal getEstadoFacadeLocal() {
        return estadoFacadeLocal;
    }

    public void setEstadoFacadeLocal(EstadoFacadeLocal estadoFacadeLocal) {
        this.estadoFacadeLocal = estadoFacadeLocal;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Estado> getEst() {
        return est;
    }

    public void setEst(List<Estado> est) {
        this.est = est;
    }

    public EstadisticasBean getEstadisticasBean() {
        return estadisticasBean;
    }

    public void setEstadisticasBean(EstadisticasBean estadisticasBean) {
        this.estadisticasBean = estadisticasBean;
    }

    public void setear()  {

        String path;
        //List<Object[]> l = turnoRNLocal.findHistorialTurnosServicios(1, this.getFechaInicio(), this.getFechaFin());
        System.out.println("funcionando");
        
        
        try {
            path = "reports\\reporteEstados.jasper";
            FacesContext context = FacesContext.getCurrentInstance();
            System.out.println("entrooooooooooooooooooooooooooooooo1"+path);
            String reportPath = context.getExternalContext().getRealPath(path);
            System.out.println("entrooooooooooooooooooooooooooooooo2"+reportPath);

            this.setEst(this.estadoFacadeLocal.findAll());
            System.out.print("el resultado de la consulta es " + est);

            Long id = this.listaEspecialidadBean.getLstEspecialidad().get(0).getId();
            String estado = this.listaEspecialidadBean.getLstEspecialidad().get(0).getEspecialidad();
            System.out.print("el id y el esatdo son: " + id + "," + estado);

            HashMap parametro = new HashMap();
            System.out.println("entrooooooooooooooooooooooooooooooo3"+reportPath);
            parametro.put("titulo", "Estados");

            System.out.println("entroooooooooooo000oooooooooooooooo4" + parametro);
            
            

            JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(est);
            System.out.println("entroooooooooooooooooooooooooooo5" + parametro);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, parametro, beanCollectionDataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, context.getExternalContext().getRealPath("reports\\reporteSeguimiento.pdf"));
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

    }
    
    public void generar(String nombreReporte, Proyecto pro) throws SQLException {

        Connection conect;
        conect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tfs-ftyca", "postgres", "123456");
      
        System.out.println("funcionando");

        try {
            Map parametro = new HashMap();
        parametro.put("idProyecto", pro.getId());
       
            FacesContext context = FacesContext.getCurrentInstance();
            String reportPath = context.getExternalContext().getRealPath("\\reports\\" + nombreReporte);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, parametro, conect); //new JREmptyDataSource() si le pongo eso en vez de conect me devuelve null
            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            httpServletResponse.addHeader("Content-disposition", "filename=reporte.pdf");
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
            servletOutputStream.flush();
            servletOutputStream.close();
            FacesContext.getCurrentInstance().responseComplete();

        } catch (Exception ex) {
            System.out.println(ex + "CAUSA: " + ex.getCause());

        }
        //limpiar();
    }//fin generar  

}
