package model.entidades;

import java.io.Serializable;

public class PessoaJuridica extends Pessoa implements Serializable {
    // Atributos
    private String cnpj;

    // Construtores
    public PessoaJuridica() {}
    
    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome);
        this.cnpj = cnpj;
    }
    
    // Getters e setters
    public String getCNPJ(){
        return this.cnpj;
    }
    
    public void setCNPJ(String cnpj) {
        this.cnpj = cnpj;
    }
    
    // Métodos
    @Override
    public void exibir() {
        System.out.println("ID: " + getId());
        System.out.println("NOME: " + getNome());
        System.out.println("CNPJ: " + getCNPJ());
    }
}
