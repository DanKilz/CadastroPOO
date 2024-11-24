package model.gerenciadores;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import model.entidades.PessoaFisica;


public class PessoaFisicaRepo {
    // Atributos
    private List<PessoaFisica> pessoasFisicas = new ArrayList<>();
    
    // Métodos
    public void inserir(PessoaFisica pessoa) {
        pessoasFisicas.add(pessoa);
    }
    
    public void alterar(PessoaFisica pessoa) {
        pessoasFisicas.set(pessoasFisicas.indexOf(pessoa), pessoa);
    }
    
    public void excluir(int id) {
        pessoasFisicas.removeIf(pessoa -> pessoa.getId() == id);
    }
    public PessoaFisica obter(int id) {
        return pessoasFisicas.stream()
                .filter(pessoa -> pessoa.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public List<PessoaFisica> obterTodos() {
        // Retorna uma cópia para evitar modificações externas da lista original.
        return new ArrayList<>(pessoasFisicas);
    }
    
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(pessoasFisicas);
            System.out.println("Dados de Pessoa Fisica Armazenados.");
        }
    }
    
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            pessoasFisicas = (List<PessoaFisica>) ois.readObject();
            System.out.println("Dados de Pessoa Fisica Recuperados.");
        }
    }
}
