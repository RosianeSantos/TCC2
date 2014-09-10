/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Entidade;

/**
 *
 * @author Rosy
 */
public class Cidade {
    
    private Long Id;
    private String Nome;
    private String Estado;

    /**
     *
     * @return
     */
    public Long getId() {
        return Id;
    }

    /**
     *
     * @param Id
     */
    public void setId(Long Id) {
        this.Id = Id;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return Nome;
    }

    /**
     *
     * @param Nome
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     *
     * @return
     */
    public String getEstado() {
        return Estado;
    }

    /**
     *
     * @param Estado
     */
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
}
