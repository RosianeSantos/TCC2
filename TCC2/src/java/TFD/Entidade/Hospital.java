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
public class Hospital {
    
    private Long Id;
    private String Nome;
    private String Endereço;
    private String Telefone;

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
    public String getEndereço() {
        return Endereço;
    }

    /**
     *
     * @param Endereço
     */
    public void setEndereço(String Endereço) {
        this.Endereço = Endereço;
    }

    /**
     *
     * @return
     */
    public String getTelefone() {
        return Telefone;
    }

    /**
     *
     * @param Telefone
     */
    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }
   
    
}
