import java.util.Scanner;

public class MusicaTeste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicCloud cloud = new MusicCloud();

        System.out.print("Digite o nome da playlist: ");
        String nomePlaylist = scanner.nextLine();
        Playlist playlist = new Playlist(nomePlaylist);

        boolean continuar = true;

        while (continuar) {
            System.out.print("\nDigite o nome da música: ");
            String tituloMusica = scanner.nextLine();

            try {
                Musica musica = cloud.buscarMusica(tituloMusica);
                playlist.adicionarMusica(musica);
                System.out.println("Você adicionou a música " + musica.getTitulo() + " na playlist.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.print("Deseja adicionar outra música? (s/n): ");
            String resposta = scanner.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        playlist.exibirPlaylist();
        scanner.close();
    }
}
