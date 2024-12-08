package model.gerenciadores;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import model.entidades.PessoaJuridica;

public class PessoaJuridicaRepo {
    // Atributos
    private List<PessoaJuridica> pessoasJuridicas = new ArrayList<>();
    
    // Métodos
    public void inserir(PessoaJuridica pessoa) {
        pessoasJuridicas.add(pessoa);
    }
    
    public void alterar(PessoaJuridica pessoa) {
        pessoasJuridicas.set(pessoasJuridicas.indexOf(pessoa), pessoa);
    }
    
    public void excluir(int id) {
        pessoasJuridicas.removeIf(pessoa -> pessoa.getId() == id);
    }
    
    public PessoaJuridica obter(int id) {
        return pessoasJuridicas.stream()
                .filter(pessoa -> pessoa.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    public List<PessoaJuridica> obterTodos() {
        // Retorna uma cópia para evitar modificações externas da lista original.
        return new ArrayList<>(pessoasJuridicas);
    }
    
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(pessoasJuridicas);
            System.out.println("Dados de Pessoa Juridica Armazenados!");
        }
    }
    
    public void recuperar(String nomeArquivo)  throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            pessoasJuridicas = (List<PessoaJuridica>) ois.readObject();
            System.out.println("Dados de Pessoa Juridica Recuperados!");
        }
    }        
}
