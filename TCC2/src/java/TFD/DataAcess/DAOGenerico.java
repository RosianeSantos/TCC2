/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.DataAcess;

import TFD.DomainModel.Repositorio;
import TFD.DomainModel.Entidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Rosy
 *
 */
public abstract class DAOGenerico<T extends Entidade> implements Repositorio<T> {
  
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
    
    
    
   
    protected EntityManager manager;
    private Class tipo;
    public DAOGenerico (Class t) {
        tipo = t;
    }
    
 
    @Override
    public T Salvar(T obj) {
        try{
            if(manager.contains(obj) || (obj.getId() != null && obj.getId() > 0)) {
                obj = manager.merge(obj);
            }
            else {
                manager.persist(obj);
            }
            
            manager.flush();
            
        return obj;
        }catch (Exception ex){
        System.out.println(ex.getMessage());
        return null;
        }
    }
    
          
    
    @Override
    public T Abrir(Long id) {
        try {
            T obj = (T) manager.find(tipo, id);
            return obj;
            //abrir
        } catch (Exception ex) {
            return null;
        }
    }
    
    
    @Override
      public abstract List<T> Buscar(T obj);

    @Override
    public boolean Apagar(T obj) {
        try {
            manager.remove(manager.merge(obj));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
}

