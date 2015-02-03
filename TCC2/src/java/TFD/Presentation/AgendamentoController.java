/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;

import TFD.DomainModel.Agendamento;
import TFD.DomainModel.AgendamentoRepositorio;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Rosy
 */
@Named(value = "agendamentoController")
@SessionScoped
public class AgendamentoController extends ControllerGenerico<Agendamento>  implements Serializable {
    
    @EJB
    AgendamentoRepositorio dao;
    

    /**
     * Creates a new instance of FuncionarioController
     */
    public AgendamentoController() {
        entidade = new Agendamento();
        filtro = new Agendamento();
    }

    /**
     *
     */
    
     public void validarEspacoEmBranco(FacesContext contexto, UIComponent componente, Object valor) {
        String valorString = (String) valor;
        if (valorString.trim().equals("")) {
            ((UIInput) componente).setValid(false);
            String mensagem = componente.getAttributes().get("label")
                    + ":Não é permitido espaço em branco. ";
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
            contexto.addMessage(componente.getClientId(contexto), facesMessage);
        }

    }
    
    
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    } 

    /**
     *
     Criando o Metodo de salvar */
   public void salvar() {
        if(dao.Salvar(entidade)){
            listagem = null; 
        } else {
            //mensagem de erro
        }
    }

   
    public String editar() {
        return "Recibo.xhtml";
    }
    
   
    public String novo(){
        entidade = new Agendamento();
        return "Recibo.xhtml";
    }
    
    @Override
    public String abrir() {
        return "Recibo.xhtml";
    }

   
    public String criar() {
        entidade = new Agendamento();
        return "ListagemRecibo.xhtml";
    }

    @Override
    public String cancelar() {
        return "ListagemRecibo.xhtml";
    }
   
    @Override
    public String excluir() {
        if(dao.Apagar(entidade)){
            listagem = null; 
            return "";
        } else {
            return "";
        }
    }

  
    @Override
    public void filtrar() {
        listagem = dao.Buscar(filtro);
    }

    
//    public String voltar() {
//        lista = null;
//        return "EspecialidadeListar.xhtml";
//    }
    
   
    
     public AgendamentoRepositorio getDao() {
        return dao;
    }

    public void setDao(AgendamentoRepositorio dao) {
        this.dao = dao;
    }
}
