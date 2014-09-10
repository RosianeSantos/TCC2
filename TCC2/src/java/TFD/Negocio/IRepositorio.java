/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Negocio;

import java.util.List;

/**
 *
 * @author Rosy
 */
interface IRepositorio<T> {
     T Salvar(T obj);
    boolean Apagar(T obj);
    T Abrir(Long id);
    List<T> Buscar(T obj);
}
