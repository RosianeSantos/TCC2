/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.DataAcess;

import TFD.DomainModel.Categoria;
import TFD.DomainModel.CategoriaRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Rosy
 */
@Stateless(name = "CategoriaRepositorio")
public class CategoriaDAO extends DAOGenerico<Categoria>
        implements CategoriaRepositorio{
    
    public CategoriaDAO() {
        super(Categoria.class);
    }

    
    @Override
    public List<Categoria> Buscar(Categoria obj) {
        // Corpo da consulta
        String consulta = "select c from Categoria c";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj != null) {
            if (obj.getNome() != null && obj.getNome().length() > 0) {
                filtro += " lower(c.nome) like lower('%" + obj.getNome() + "%')";                
            }

            if (obj.getNome()!= null && obj.getNome().length() > 0) {
                if (filtro.length() > 0) {
                    filtro += " and ";
                }
                filtro += " c.nome=:nome ";
                parametros.put("nome", obj.getNome());
            }

            if (obj.getIdCategoria()!= null && obj.getIdCategoria()> 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " c.idCategoria =:idCategoria";
                parametros.put("idCategoria", obj.getIdCategoria());
            }

            if (obj.getQuantidade() != null && obj.getQuantidade().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " c.quantidade=:quantidade";
                parametros.put("quantidade", obj.getQuantidade());
            }

           // Se houver filtros, coloca o "where" na consulta
            if (filtro.length() > 0) {
                consulta = consulta + " where " + filtro;
            }
        }

        // Cria a consulta no JPA
        Query query = manager.createQuery(consulta);

        // Aplica os parâmetros da consulta
        for (String par : parametros.keySet()) {
            query.setParameter(par, parametros.get(par));
        }

        // Executa a consulta
        return query.getResultList();

    }
    
   

    
}
