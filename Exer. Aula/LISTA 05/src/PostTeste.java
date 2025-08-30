import java.util.Scanner;

public class PostTeste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada do usuário
        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Tipo (texto, imagem ou video): ");
        String tipo = scanner.nextLine();

        Postagem postagem = new Postagem(titulo, descricao, tipo);

        // Instâncias das plataformas
        PlataformaSocial myBook = new MyBook();
        PlataformaSocial fotogram = new Fotogram();
        PlataformaSocial anyTube = new AnyTube();

        // MyBook
        try {
            if (tipo.equals("texto")) myBook.compartilharPostagem(postagem);
            else if (tipo.equals("imagem")) myBook.compartilharImagem(postagem);
            else if (tipo.equals("video")) myBook.compartilharVideo(postagem);
        } catch (Exception e) {
            System.out.println("Erro no MyBook: " + e.getMessage());
        }

        // Fotogram
        try {
            if (tipo.equals("texto")) fotogram.compartilharPostagem(postagem);
            else if (tipo.equals("imagem")) fotogram.compartilharImagem(postagem);
            else if (tipo.equals("video")) fotogram.compartilharVideo(postagem);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao compartilhar essa postagem no Fotogram.");
        }

        // AnyTube
        try {
            if (tipo.equals("texto")) anyTube.compartilharPostagem(postagem);
            else if (tipo.equals("imagem")) anyTube.compartilharImagem(postagem);
            else if (tipo.equals("video")) anyTube.compartilharVideo(postagem);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao compartilhar essa postagem no AnyTube.");
        }

        scanner.close();
    }
}
