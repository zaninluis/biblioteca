import java.util.Scanner;

public class Main {
    private static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            mostrarMenu();
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    adicionarLivro(sc);
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    pesquisarLivro(sc);
                    break;
                case 4:
                    removerLivro(sc);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void mostrarMenu() {
        System.out.println("Biblioteca Atitus");
        System.out.println("Opções:");
        System.out.println("1  Adicionar um livro novo ao acervo");
        System.out.println("2  Listar todos os livros do acervo");
        System.out.println("3  Pesquisar um livro no acervo pelo título");
        System.out.println("4  Remover um livro do acervo");
        System.out.println("0  Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarLivro(Scanner sc) {
        System.out.println("Digite o título: ");
        String titulo = sc.nextLine();
        System.out.println("Digite o autor: ");
        String autor = sc.nextLine();
        System.out.println("Digite o ano de publicação: ");
        int ano = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o número de páginas: ");
        int paginas = sc.nextInt();
        sc.nextLine();

        Livro novoLivro = new Livro();
        novoLivro.setTitulo(titulo);
        novoLivro.setAutor(autor);
        novoLivro.setAno(ano);
        novoLivro.setNumpag(paginas);

        try {
            biblioteca.adicionarLivro(novoLivro);
            System.out.println("Livro adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar livro: " + e.getMessage());
        }
    }

    private static void listarLivros() {
        if (biblioteca.listarLivros().isEmpty()) {
            System.out.println("O acervo está vazio.");
        } else {
            System.out.println("Lista de livros no acervo:");
            for (Livro livro : biblioteca.listarLivros()) {
                System.out.println(livro);
            }
        }
    }

    private static void pesquisarLivro(Scanner sc) {
        System.out.print("Digite o título do livro que deseja pesquisar: ");
        String titulo = sc.nextLine();
        Livro livro = biblioteca.pesquisarLivro(titulo);
        if (livro != null) {
            System.out.println("Livro encontrado: " + livro);
        } else {
            System.out.println("Livro não encontrado no acervo.");
        }
    }

    private static void removerLivro(Scanner sc) {
        System.out.print("Digite o título do livro que deseja remover: ");
        String titulo = sc.nextLine();
        if (biblioteca.removerLivro(titulo)) {
            System.out.println("Livro removido com sucesso!");
        } else {
            System.out.println("Livro não encontrado no acervo.");
        }
    }
}
