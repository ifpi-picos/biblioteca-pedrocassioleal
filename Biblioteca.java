import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void listarLivros() {
        livros.forEach(System.out::println);
    }

    public Livro buscarLivroPorIsbn(String isbn) {
        return livros.stream()
                     .filter(livro -> livro.getIsbn().equals(isbn))
                     .findFirst()
                     .orElse(null);
    }

    public void registrarEmprestimo(Livro livro, Usuario usuario) {
        if (livro.isDisponivel()) {
            livro.setDisponivel(false);
            emprestimos.add(new Emprestimo(livro, usuario));
            System.out.println("Empréstimo registrado com sucesso!");
        } else {
            System.out.println("Livro indisponível para empréstimo.");
        }
    }

    public void devolverLivro(Livro livro) {
        emprestimos.removeIf(e -> e.getLivro().equals(livro));
        livro.setDisponivel(true);
        System.out.println("Livro devolvido com sucesso!");
    }

    public void listarEmprestimos() {
        emprestimos.forEach(System.out::println);
    }
}

