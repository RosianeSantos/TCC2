/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;


import TFD.DomainModel.Funcionario;
import TFD.DomainModel.Hospital;
import TFD.DomainModel.HospitalRepositorio;
import java.io.Serializable;
import java.util.List;
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
@Named(value = "hospitalController")
@SessionScoped
public class HospitalController extends ControllerGenerico<Hospital> implements Serializable {

//    Hospital entidade;
//    Hospital filtro;
//    List<Hospital> lista;

    @EJB
    HospitalRepositorio dao;
    
    
     public HospitalController() {
        entidade = new Hospital();
        filtro = new Hospital();
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
        return "Hospital.xhtml";
    }
    
   
    public String novo(){
        entidade = new Hospital();
        return "Hospital.xhtml";
    }
    
    @Override
    public String abrir() {
        return "Hospital.xhtml";
    }

   
    public String criar() {
        entidade = new Hospital();
        return "ListagemHospital.xhtml";
    }

    @Override
    public String cancelar() {
        return "ListagemHospital.xhtml";
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
    
   
    
     public HospitalRepositorio getDao() {
        return dao;
    }

    public void setDao(HospitalRepositorio dao) {
        this.dao = dao;
    }

}
