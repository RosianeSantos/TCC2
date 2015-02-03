/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation.Relatorio;


import TFD.DomainModel.Agendamento;
import TFD.DomainModel.AgendamentoRepositorio;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Rosy
 */
@Named(value = "relatoriopagamentoController")
@SessionScoped
public class RelatorioPagamentoController extends RelatorioGenericoController<Agendamento> implements Serializable {
    
     Agendamento filtro;
    
    @EJB
    AgendamentoRepositorio dao; 
    
    
   
    public RelatorioPagamentoController() {
     setCaminhoRelatorio("RelatorioPagamento.jasper");
     setNomeRelatorio("Relatorio de Pagamento");
     filtro = new Agendamento();
    }
    
   public List<Agendamento> getDados(){
       return dao.Buscar(filtro);   
   }

    public Agendamento getFiltro() {
        return filtro;
    }

    public void setFiltro(Agendamento filtro) {
        this.filtro = filtro;
    }
}
