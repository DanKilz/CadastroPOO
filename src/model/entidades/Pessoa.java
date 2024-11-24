package model.entidades;

import java.io.Serializable;

public class Pessoa implements Serializable {
    // Atributos
    private int id;
    private String nome;
    
    // Construtores
    public Pessoa() {}
    
    public Pessoa(int id, String nome){
        this.id = id;
        this.nome = nome;
    }
    
    // Getters e setters
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public  void setNome(String nome) {
        this.nome = nome;
    }
    
    // Métodos
    public void exibir() {
        System.out.println("ID: " + getId());
        System.out.println("NOME: " + getNome());
    }
}
