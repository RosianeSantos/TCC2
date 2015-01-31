/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TFD.Presentation.Relatorio;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author HOME
 */

public abstract class RelatorioGenericoController<T> implements Serializable {
    
    private String caminhoRelatorio;
    
    private String nomeRelatorio;
   
    public abstract List<T> getDados();
    
    
    public RelatorioGenericoController() {
       
    }
    
    
    public void executaRelatorioPDF() throws JRException, IOException {
 
        InputStream reportStream = null;
        try {
            reportStream = getClass().getResourceAsStream(getCaminhoRelatorio());
 
            JRDataSource ds = new JRBeanCollectionDataSource(getDados(), true);
 
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, null, ds);
 
            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + getNomeRelatorio() + ".pdf");
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
            FacesContext.getCurrentInstance().responseComplete();
 
        } catch (JRException ex) {
            Logger.getLogger(RelatorioGenericoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getCaminhoRelatorio() {
        return caminhoRelatorio;
    }

    public void setCaminhoRelatorio(String caminhoRelatorio) {
        this.caminhoRelatorio = caminhoRelatorio;
    }

    public String getNomeRelatorio() {
        return nomeRelatorio;
    }

    public void setNomeRelatorio(String nomeRelatorio) {
        this.nomeRelatorio = nomeRelatorio;
    }
    
    
}
