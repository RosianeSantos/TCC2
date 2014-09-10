/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Negocio;

import TFD.Entidade.Funcionario;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Rosy
 */

public class FuncionarioDAO {

    EntityManager ge = DAOGenerico.getGerenciadorEntidade();
    
    /**
     * Metodo com a finalidade apenas de salvar um usuario.
     * @param funcionario  Objeto do tipo usuario.
     */
    
    public void cadastrarFuncionario(Funcionario funcionario){
        ge.getTransaction().begin();
        ge.persist(funcionario);
        ge.getTransaction().commit();
    }

  
}
