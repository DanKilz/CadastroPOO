package model.entidades;

import java.io.Serializable;

public class PessoaFisica extends Pessoa implements Serializable {
    // Atributos
    private String cpf;
    private int idade;
    
    // Construtores
    public PessoaFisica() {}
    
    public PessoaFisica(int id, String nome, String cpf, int idade) {
        super(id, nome);
        this.cpf = cpf;
        this.idade = idade;
    }
    
    // Getters e setters
    public String getCPF() {
        return this.cpf;
    }
    
    public void setCPF(String cpf) {
        this.cpf = cpf;
    }
    
    public int getIdade() {
        return this.idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    @Override
    public void exibir() {
        System.out.println("ID: " + getId());
        System.out.println("NOME: " + getNome());
        System.out.println("CPF: " + getCPF());
        System.out.println("IDADE: " + getIdade());
    }
}
