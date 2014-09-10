/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Negocio;

import TFD.Entidade.Funcionario;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Rosy
 */
@Remote
public interface IFuncionarioRepositorio 
    extends IRepositorio<Funcionario>{
    
    /**
     *
     * @param login
     * @return
     */
    public Funcionario porLogin(String login);
    public boolean login(String usuario, String senha);

    public List<Funcionario> Buscar(Funcionario obj);
   }
