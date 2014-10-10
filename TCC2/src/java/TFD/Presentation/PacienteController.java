/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;


import TFD.DomainModel.Paciente;
import TFD.DomainModel.PacienteRepositorio;
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
@Named(value = "pacienteController")
@SessionScoped
public class PacienteController implements Serializable{
    
    Paciente entidade;
    Paciente filtro;
    List<Paciente> lista;

    @EJB
    PacienteRepositorio dao;
    

    /**
     * Creates a new instance of PacienteController
     */
    public PacienteController() {
        entidade = new Paciente();
        filtro = new Paciente();
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
     
     
     
    public  boolean validacpf(String strCpf){ // formato XXX.XXX.XXX-XX  
        if (! strCpf.substring(0,1).equals("")){  
            try{  
                boolean validado=true;  
                int     d1, d2;  
                int     digito1, digito2, resto;  
                int     digitoCPF;  
                String  nDigResult;  
                strCpf=strCpf.replace('.',' ');  
                strCpf=strCpf.replace('-',' ');  
                strCpf=strCpf.replaceAll(" ","");  
                d1 = d2 = 0;  
                digito1 = digito2 = resto = 0;  
                  
                for (int nCount = 1; nCount < strCpf.length() -1; nCount++) {  
                    digitoCPF = Integer.valueOf(strCpf.substring(nCount -1, nCount)).intValue();  
                      
                    //multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.  
                    d1 = d1 + ( 11 - nCount ) * digitoCPF;  
                      
                    //para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.  
                    d2 = d2 + ( 12 - nCount ) * digitoCPF;  
                };  
                  
                //Primeiro resto da divisão por 11.  
                resto = (d1 % 11);  
                  
                //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.  
                if (resto < 2)  
                    digito1 = 0;  
                else  
                    digito1 = 11 - resto;  
                  
                d2 += 2 * digito1;  
                  
                //Segundo resto da divisão por 11.  
                resto = (d2 % 11);  
                  
                //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.  
                if (resto < 2)  
                    digito2 = 0;  
                else  
                    digito2 = 11 - resto;  
                  
                //Digito verificador do CPF que está sendo validado.  
                String nDigVerific = strCpf.substring(strCpf.length()-2, strCpf.length());  
                  
                //Concatenando o primeiro resto com o segundo.  
                nDigResult = String.valueOf(digito1) + String.valueOf(digito2);  
                  
                //comparar o digito verificador do cpf com o primeiro resto + o segundo resto.  
                return nDigVerific.equals(nDigResult);  
            }catch (Exception e){  
                System.err.println("Erro !"+e);  
                return false;  
            }  
        }else return false;  
    }  
  

     
     
     
    
     
      public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    } 

    /**
     *
     Criando o Metodo de salvar */
    public void salvar() {
        dao.Salvar(entidade);
        lista = null;
        exibirMensagem("Salvo!");
    }

   
    public String editar() {
        return "PacienteEditar.xhtml";
    }
    
   
    public String novo(){
        return "PacienteEditar.xhtml";
    }

   
    public String criar() {
        entidade = new Paciente();
        return "PacienteEditar.xhtml";
    }

   
    public String apagar() {
        dao.Apagar(entidade);
        lista = null;
        exibirMensagem("Apagado com sucesso!");
        return "PacienteListagem.xhtml";
    }

  
    public String filtrar() {
        lista = dao.Buscar(filtro);
        return "PacienteListagem.xhtml";
    }

    
    public String voltar() {
        lista = null;
        return "PacienteListagem.xhtml";
    }
    
  
    public Paciente getEntidade() {
        return entidade;
    }

    public void setEntidade(Paciente entidade) {
        this.entidade = entidade;
    }

    public List<Paciente> getListagem() {
        if (lista == null) {
            Paciente filtro = new Paciente();
            lista = dao.Buscar(filtro);
        }
        return lista;
    }

  
    public void setListagem(List<Paciente> listagem) {
        this.lista = listagem;
    }

    
    public Paciente getFiltro() {
        return filtro;
    }

    
    public void setFiltro(Paciente filtro) {
        this.filtro = filtro;
    }
    
}
