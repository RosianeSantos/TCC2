/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Negocio;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Rosy
 *
 */
public class DAOGenerico{
     private static EntityManager gerenciadorEntidade = null;
  
    
    /**
     * Metodo criado com a finalidade de retornar o gerenciador de entidade.
     * @return um objeto do tipo EntityManager, Reponsal por gerenciar o Banco de dados.
     */
    public static EntityManager getGerenciadorEntidade(){
        if (gerenciadorEntidade == null || !gerenciadorEntidade.isOpen()){
            gerenciadorEntidade = Persistence.createEntityManagerFactory("TCC2PU").createEntityManager();
        }
        return gerenciadorEntidade;
    }
}
