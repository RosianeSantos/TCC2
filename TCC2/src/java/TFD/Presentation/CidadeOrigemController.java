/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;

import TFD.DomainModel.Cidade;
import TFD.DomainModel.ICidadeRepositorio;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Rosy
 */
@Named(value = "cidadeOrigemController")
@SessionScoped
public class CidadeOrigemController implements Serializable{
    Cidade entidade;
    Cidade filtro;
    List<Cidade> lista;
    @EJB
    ICidadeRepositorio dao;

    /**
* Creates a new instance of CidadeOrigemController
*/
    public CidadeOrigemController() {
        entidade = new Cidade();
        filtro = new Cidade();
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

    public void salvar() {
        dao.Salvar(entidade);
        lista = null;
        exibirMensagem("Salvo!");
    }

    public String editar() {
        return "CadastroCidade.xhtml";
    }

    public String criar() {
        entidade = new Cidade();
        return "CadastroCidade.xhtml";
    }

    public String apagar() {
        dao.Apagar(entidade);
        lista = null;
        exibirMensagem("Pronto!");
        return "CadastroCidadeListar.xhtml";
    }

    public String filtrar() {
        lista = dao.Buscar(filtro);
        return "CadastroCidadeListar";
    }

    public String voltar() {
        lista =null;
        return "CadastroCidadeListar.xhtml";
    }

    public Cidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Cidade entidade) {
        this.entidade = entidade;
    }

    public List<Cidade> getLista() {
        if (lista == null) {
            Cidade filtro = new Cidade();
            lista = dao.Buscar(filtro);
        }
        return lista;
    }

    public void setLista(List<Cidade> listagem) {
        this.lista = listagem;
    }

    public Cidade getFiltro() {
        return filtro;
    }

    public void setFiltro(Cidade filtro) {
        this.filtro = filtro;
    }
    
}
