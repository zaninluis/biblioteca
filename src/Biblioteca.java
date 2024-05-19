import java.util.ArrayList;
import java.util.List;

    public class Biblioteca {
        private List<Livro> acervo;

        public Biblioteca() {
            this.acervo = new ArrayList<>();
        }

        public void adicionarLivro(Livro livro) throws Exception {
            if(livro == null){
                throw new Exception("Objeto não pode ser nulo!");
            }
            if(livro.getTitulo() == null || livro.getTitulo().isEmpty())
                throw new Exception("O título é um campo obrigatório!");
            if(livro.getAutor() == null || livro.getAutor().isEmpty())
                throw new Exception("O auto é um campo obrigatório!");

            acervo.add(livro);
        }

        public ArrayList<Livro> listarLivros() {
            return (ArrayList<Livro>) acervo;
        }

        public Livro pesquisarLivro(String titulo) {
            for (Livro livro : acervo) {
                if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                    return livro;
                }
            }
            return null;
        }

        public boolean removerLivro(String titulo) {
            for (Livro livro : acervo) {
                if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                    acervo.remove(livro);
                    return true;
                }
            }
            return false;
        }

    }
