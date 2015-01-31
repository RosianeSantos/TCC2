/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation.Relatorio;

import TFD.Presentation.Relatorio.RelatorioGenericoController;
import TFD.DomainModel.Paciente;
import TFD.DomainModel.PacienteRepositorio;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Rosy
 */
@Named(value = "listagempacienteController")
@SessionScoped
public class ListagemDePacienteController extends RelatorioGenericoController<Paciente> implements Serializable{
    
    Paciente filtro;
    
    @EJB
    PacienteRepositorio dao; 
    
    
   
    public ListagemDePacienteController() {
     setCaminhoRelatorio("PacienteTeste.jasper");
     setNomeRelatorio("PacienteTeste");
     filtro = new Paciente();
    }
    
   public List<Paciente> getDados(){
       return dao.Buscar(filtro);   
   }

    public Paciente getFiltro() {
        return filtro;
    }

    public void setFiltro(Paciente filtro) {
        this.filtro = filtro;
    }

}
