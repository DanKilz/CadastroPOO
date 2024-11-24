package cadastropoo;

import java.io.IOException;
import java.util.List;
import model.entidades.PessoaFisica;
import model.entidades.PessoaJuridica;
import model.gerenciadores.PessoaFisicaRepo;
import model.gerenciadores.PessoaJuridicaRepo;

public class CadastroPOO {
    
    public static void main(String[] args) {
        try {
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
        }
        catch (Exception e) {
            System.out.println("ERRO. " + e.getMessage());
        }        
    }
    
}
