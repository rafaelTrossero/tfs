/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes.bean;

import entidad.Proyecto;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import reportes.AbstractReportBean;
 
@ManagedBean(name = "reportsBean")
@SessionScoped
 
public class ReportsBean extends AbstractReportBean {
 
    private final String COMPILE_FILE_NAME = "report1";
 
    @Override
    protected String getCompileFileName() {
        return COMPILE_FILE_NAME;
    }
 
    public void setear(long idProyecto) throws JRException, IOException {

        String path;
        //List<Object[]> l = turnoRNLocal.findHistorialTurnosServicios(1, this.getFechaInicio(), this.getFechaFin());
        System.out.println("funcionando");
        
        
        try {
            path = "reports\\reporteProyecto.jasper";
            FacesContext context = FacesContext.getCurrentInstance();
            System.out.println("entrooooooooooooooooooooooooooooooo1"+path);
            String reportPath = context.getExternalContext().getRealPath(path);
            System.out.println("entrooooooooooooooooooooooooooooooo2"+reportPath);

           

            HashMap parametro = new HashMap();
            System.out.println("entrooooooooooooooooooooooooooooooo3"+reportPath);
            parametro.put("titulo", "Estados");
            parametro.put("idProyecto",idProyecto);

            System.out.println("entroooooooooooo000oooooooooooooooo4" + parametro);
            
            

            JRBeanCollectionDataSource beanCollectionDataSource = null;
            System.out.println("entroooooooooooooooooooooooooooo5" + parametro);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, parametro, beanCollectionDataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, context.getExternalContext().getRealPath("reports\\proyecto_carrera.pdf"));
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
    @Override
    protected Map<String, Object> getReportParameters() {
        Map<String, Object> reportParameters = new HashMap<String, Object>();
 
        reportParameters.put("rtitle", "Hello JasperReports");
 
        return reportParameters;
    }
 
    public String execute(Long idProy) {
        System.out.println("el proyecto tiene como id"+ idProy);
        try {
            super.prepareReport(idProy);
        } catch (Exception e) {
            // make your own exception handling
            e.printStackTrace();
        }
 
        return null;
    }
    
     public void obtenerReporte(Long idProy) throws SQLException, JRException {
      
       
       
        Connection conect;
        conect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tfs-ftyca", "postgres", "123456");

        JasperReport rn = null;
        Map parametro = new HashMap();
        parametro.put("idProyecto",idProy );             
       
        rn = (JasperReport) JRLoader.loadObjectFromFile("C:\\Users\\RafaTrossero\\Documents\\NetBeansProjects\\tfs\\tfs-war\\web\\reporteProyecto.jasper");
        
        JasperPrint jp = JasperFillManager.fillReport(rn, parametro, conect);
        JasperViewer jv = new JasperViewer(jp,false);
        jv.setVisible(true);

    }
     
     public void imprimeRelatorio2(Long idProy) throws SQLException {
     
         imprimeRelatorio(idProy);
     }
     
     
    
    public void imprimeRelatorio(Long idProy) throws SQLException {
        try{
            String pathFile = "C:\\Users\\RafaTrossero\\Documents\\NetBeansProjects\\tfs\\tfs-war\\web\\reporteProyecto.jasper";
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            
            InputStream file = getClass().getClassLoader().getResourceAsStream(pathFile);
            
            Connection conect;
            conect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tfs-ftyca", "postgres", "123456");
            
            JasperReport rn = null;
        Map parametro = new HashMap();
        parametro.put("idProyecto",idProy );
        
            JasperReport pathReport = JasperCompileManager.compileReport(file);
            JasperPrint preencher = JasperFillManager.fillReport(pathReport,parametro,conect);
            JasperExportManager.exportReportToPdfStream(preencher,null);
            JasperViewer.viewReport(preencher, false);
          
            context.renderResponse();
            context.responseComplete();
        } catch (JRException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }       

    }
     
     
    
}