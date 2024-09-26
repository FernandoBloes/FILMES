package exercicio_03_poo;
import java.util.Scanner;

public class Filme {
    private String titulo;
    private int duracao; // duração em minutos
    private String genero; // deve ser "Romance", "Terror" ou "Comédia"

    // Construtor
    public Filme(String titulo, int duracao, String genero) {
        setTitulo(titulo);
        setDuracao(duracao);
        setGenero(genero);
    }

    // Métodos de acesso e validação
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O título não pode estar vazio.");
        }
        this.titulo = titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        if (duracao <= 0) {
            throw new IllegalArgumentException("A duração deve ser maior que zero.");
        }
        this.duracao = duracao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        if (!genero.equalsIgnoreCase("Romance") && 
            !genero.equalsIgnoreCase("Terror") && 
            !genero.equalsIgnoreCase("Comédia")) {
            throw new IllegalArgumentException("O gênero deve ser 'Romance', 'Terror' ou 'Comédia'.");
        }
        this.genero = genero;
    }

    // Método para exibir os detalhes do filme
    public void exibirDetalhes() {
        System.out.println("Título: " + titulo);
        System.out.println("Duração: " + duracao + " minutos");
        System.out.println("Gênero: " + genero);
    }

    // Método main para capturar as informações do usuário
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Informe o título do filme:");
            String titulo = scanner.nextLine();

            System.out.println("Informe a duração do filme (em minutos):");
            int duracao = scanner.nextInt();
            scanner.nextLine();  // Limpa o buffer

            System.out.println("Informe o gênero do filme (Romance, Terror, Comédia):");
            String genero = scanner.nextLine();

            Filme filme = new Filme(titulo, duracao, genero);
            System.out.println("\nDetalhes do filme:");
            filme.exibirDetalhes();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
