package cadastropoo;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import model.entidades.PessoaFisica;
import model.entidades.PessoaJuridica;
import model.gerenciadores.PessoaFisicaRepo;
import model.gerenciadores.PessoaJuridicaRepo;

public class CadastroPOO {
    // As variáveis aqui criadas estarão diposníveis tanto para a função "main" quanto para as demais.
    
    // Instanciação de objeto Scanner para receber as entradas de usuário.
    private static final Scanner scanner = new Scanner(System.in);
    
    // Repositórios
    private static final PessoaFisicaRepo repoPF = new PessoaFisicaRepo();
    private static final PessoaJuridicaRepo repoPJ = new PessoaJuridicaRepo();
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 1º Procedimento | Criação das Entidades e Sistema de Persistência
        System.out.println("Procedimento 1 | Criacao das Entidades e Sistema de Persistencia\n");
        
        // Pessoas Físicas
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();            
        repo1.inserir(new PessoaFisica(1, "Ana", "111.111.111-11", 25));
        repo1.inserir(new PessoaFisica(2, "Carlos", "222.222.222-22", 52));

        final String NOME_ARQUIVO_PF = "pessoas-fisicas.dat";

        try {
            repo1.persistir(NOME_ARQUIVO_PF);
        }
        catch (IOException e) {
            System.out.println("Erro ao gravar os dados: " + e.getMessage());
        }

        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        try {
            repo2.recuperar(NOME_ARQUIVO_PF);                
        }
        catch (Exception e) {
            System.out.println("Erro ao recuperar dados: " + e.getMessage());
        }

        List<PessoaFisica> pessoasFisicas = repo2.obterTodos();
        for (PessoaFisica pessoa : pessoasFisicas) {
            pessoa.exibir();
        }

        // Pessoas Jurídicas
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        repo3.inserir(new PessoaJuridica(3, "XPTO Sales", "33.333.333/3333-33"));
        repo3.inserir(new PessoaJuridica(4, "XPTO Solutions", "44.444.444/4444-44"));

        final String NOME_ARQUIVO_PJ = "pessoas-juridicas.dat";

        try {
            repo3.persistir(NOME_ARQUIVO_PJ);
        }
        catch (IOException e) {
            System.out.println("Erro ao gravar os dados: " + e.getMessage());
        }

        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        try {
            repo4.recuperar(NOME_ARQUIVO_PJ);
        }
        catch (Exception e) {
            System.out.println("Erro ao recuperar dados: " + e.getMessage());
        }

        List<PessoaJuridica> pessoasJuridicas = repo4.obterTodos();
        for (PessoaJuridica pessoa : pessoasJuridicas) {
            pessoa.exibir();
        }
        
        /**********************************************************************/
        System.out.println("\n==================================================\n");
        
        // 2º Procedimento | Criação do Cadastro em Modo Texto
        System.out.println("Procedimento 2 | Criacao do Cadastro em Modo Texto\n");        
        
        int opcao;
        
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            
            // Consumindo o caractere de quebra de linha.
            scanner.nextLine();
            
            processarOpcao(opcao);
        } while (opcao != 0);
        System.out.println("Programa encerrado.");
        
        scanner.close();
    }
    
    // Funções
    private static void exibirMenu() {
        System.out.println("========================");
        System.out.println("1 - Incluir Pessoa");
        System.out.println("2 - Alterar Pessoa");
        System.out.println("3 - Excluir Pessoa");
        System.out.println("4 - Buscar pelo Id");
        System.out.println("5 - Exibir Todos");
        System.out.println("6 - Persistir Dados");
        System.out.println("7 - Recuperar Dados");
        System.out.println("0 - Finalizar Programa");
        System.out.println("========================");
        System.out.print("Escolha uma opcao: ");
    }
    
    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 0 -> {
            }
            case 1 -> inserirPessoa();
            case 2 -> alterarPessoa();
            case 3 -> excluirPessoa();
            case 4 -> buscarPessoa();
            case 5 -> exibirTodos();
            case 6 -> persistirDados();
            case 7 -> recuperarDados();
        }
    }
    
    private static void inserirPessoa() {
        System.out.print("Pessoa fisica (F) ou juridica (J)? ");        
        char tipo = scanner.nextLine().toUpperCase().charAt(0);
        
        System.out.print("Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        switch (tipo) {
            case 'F' -> {
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                System.out.print("Idade: ");
                int idade = scanner.nextInt();
                scanner.nextLine();
                repoPF.inserir(new PessoaFisica(id, nome, cpf, idade));
            }
            case 'J' -> {
                System.out.print("CNPJ: ");
                String cnpj = scanner.nextLine();
                repoPJ.inserir(new PessoaJuridica(id, nome, cnpj));
            }
            default -> System.out.println("Tipo inválido!");
        }
    }
    
    private static void alterarPessoa() {
        System.out.print("Pessoa fisica (F) ou juridica (J)? ");        
        char tipo = scanner.nextLine().toUpperCase().charAt(0);
        
        System.out.print("Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        switch (tipo) {
            case 'F' -> {
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                System.out.print("Idade: ");
                int idade = scanner.nextInt();
                scanner.nextLine();
                repoPF.alterar(new PessoaFisica(id, nome, cpf, idade));
            }
            case 'J' -> {
                System.out.print("CNPJ: ");
                String cnpj = scanner.nextLine();
                repoPJ.alterar(new PessoaJuridica(id, nome, cnpj));
            }
            default -> System.out.println("Tipo inválido!");
        }
    }
    
    private static void excluirPessoa() {
        System.out.print("Pessoa fisica (F) ou juridica (J)? ");        
        char tipo = scanner.nextLine().toUpperCase().charAt(0);
        
        System.out.print("Id: ");
        int id = scanner.nextInt();
        
        switch (tipo) {
            case 'F' -> repoPF.excluir(id);
            case 'J' -> repoPJ.excluir(id);
            default -> System.out.println("Tipo inválido!");
        }
    }
    
    private static void buscarPessoa() {
        System.out.print("Pessoa fisica (F) ou juridica (J)? ");        
        char tipo = scanner.nextLine().toUpperCase().charAt(0);
        
        System.out.print("Id: ");
        int id = scanner.nextInt();
        
        switch (tipo) {
            case 'F' -> repoPF.obter(id);
            case 'J' -> repoPJ.obter(id);
            default -> System.out.println("Tipo inválido!");
        }
    }
    
    private static void exibirTodos() {
        System.out.print("Pessoa fisica (F) ou juridica (J)? ");        
        char tipo = scanner.nextLine().toUpperCase().charAt(0);
        
        switch (tipo) {
            case 'F' -> {
                List<PessoaFisica> pessoasFisicas = repoPF.obterTodos();
                for (PessoaFisica pessoa : pessoasFisicas){
                    pessoa.exibir();
                }
            }
            case 'J' -> {
                List<PessoaJuridica> pessoasJuridicas = repoPJ.obterTodos();
                for (PessoaJuridica pessoa : pessoasJuridicas) {
                    pessoa.exibir();
                }
            }
            default -> System.out.println("Tipo inválido!");
        }
    }
    
    private static void persistirDados() {
        System.out.print("Pessoa fisica (F) ou juridica (J)? ");        
        char tipo = scanner.nextLine().toUpperCase().charAt(0);
        
        System.out.print("Digite o prefixo do arquivo: ");
        String prefixo = scanner.nextLine();
                
        try {
            switch (tipo) {
                case 'F' -> repoPF.persistir(prefixo + ".fisica.bin");
                case 'J' -> repoPJ.persistir(prefixo + ".juridica.bin");
                default -> System.out.println("Tipo inválido!");
            }
        }
        catch (IOException e) {
            System.out.println("Erro ao persistir os dados: " + e.getMessage());
        }
    }
    
    private static void recuperarDados() {
        System.out.print("Pessoa fisica (F) ou juridica (J)? ");        
        char tipo = scanner.nextLine().toUpperCase().charAt(0);
        
        System.out.print("Digite o prefixo do arquivo: ");
        String prefixo = scanner.nextLine();
                
        try {
            switch (tipo) {
                case 'F' -> repoPF.recuperar(prefixo + ".fisica.bin");
                case 'J' -> repoPJ.recuperar(prefixo + ".juridica.bin");
                default -> System.out.println("Tipo inválido!");
            }
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar os dados: " + e.getMessage());
        }
    }
}
