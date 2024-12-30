import java.util.Scanner;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Sistema de Biblioteca ===");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Registrar Empréstimo");
            System.out.println("4. Devolver Livro");
            System.out.println("5. Listar Empréstimos");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    biblioteca.adicionarLivro(new Livro(titulo, autor, isbn));
                    System.out.println("Livro adicionado com sucesso!");
                    break;

                case 2:
                    biblioteca.listarLivros();
                    break;

                case 3:
                    System.out.print("ISBN do Livro: ");
                    String isbnEmprestimo = scanner.nextLine();
                    Livro livro = biblioteca.buscarLivroPorIsbn(isbnEmprestimo);
                    if (livro != null && livro.isDisponivel()) {
                        System.out.print("Nome do Usuário: ");
                        String nomeUsuario = scanner.nextLine();
                        System.out.print("ID do Usuário: ");
                        String idUsuario = scanner.nextLine();
                        biblioteca.registrarEmprestimo(livro, new Usuario(nomeUsuario, idUsuario));
                    } else {
                        System.out.println("Livro não encontrado ou indisponível.");
                    }
                    break;

                case 4:
                    System.out.print("ISBN do Livro a devolver: ");
                    String isbnDevolucao = scanner.nextLine();
                    Livro livroDevolver = biblioteca.buscarLivroPorIsbn(isbnDevolucao);
                    if (livroDevolver != null && !livroDevolver.isDisponivel()) {
                        biblioteca.devolverLivro(livroDevolver);
                    } else {
                        System.out.println("Livro não encontrado ou já devolvido.");
                    }
                    break;

                case 5:
                    biblioteca.listarEmprestimos();
                    break;

                case 6:
                    System.out.println("Encerrando o sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
