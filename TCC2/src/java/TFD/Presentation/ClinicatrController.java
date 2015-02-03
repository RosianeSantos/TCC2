/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;

import TFD.DomainModel.Clinicatr;
import TFD.DomainModel.ClinicatrRepositorio;
import TFD.DomainModel.Especialidade;
import TFD.DomainModel.EspecialidadeRepositorio;
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
@Named(value = "clinicatrController")
@SessionScoped
public class ClinicatrController extends ControllerGenerico<Clinicatr> implements Serializable {
    
    
     @EJB
     ClinicatrRepositorio dao;
    
    
    public ClinicatrController() {
        entidade = new Clinicatr();
        filtro = new Clinicatr();
    }

    
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
    
    
//    public void exibirMensagem(String msg) {
//        FacesContext context = FacesContext.getCurrentInstance();
//        context.addMessage(null, new FacesMessage(msg));
//    } 

     
     
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
        return "Clinicatr.xhtml";
    }
    
   
    public String novo(){
        entidade = new Clinicatr();
        return "Clinicatr.xhtml";
    }
    
    @Override
    public String abrir() {
        return "Clinicatr.xhtml";
    }

   
    public String criar() {
        entidade = new Clinicatr();
        return "ListagemClinicatr.xhtml";
    }

    @Override
    public String cancelar() {
        return "ListagemClinicatr.xhtml";
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
    
   
    
     public ClinicatrRepositorio getDao() {
        return dao;
    }

    public void setDao(ClinicatrRepositorio dao) {
        this.dao = dao;
    }
}
