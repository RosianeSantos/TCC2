/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.DomainModel;

import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author Rosy
 */
@Remote
public interface FuncionarioRepositorio 
     extends Repositorio<Funcionario>
     {
    
}
