import java.util.ArrayList;
import java.util.List;

public class Musica {
    private String titulo;
    private String artista;

    public Musica(String titulo, String artista) {
        this.titulo = titulo;
        this.artista = artista;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    @Override
    public String toString() {
        return titulo + " - " + artista;
    }
}

class Playlist {
    private String nome;
    private List<Musica> musicas;

    public Playlist(String nome) {
        this.nome = nome;
        this.musicas = new ArrayList<>();
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public void exibirPlaylist() {
        System.out.println("\nPlaylist: " + nome);
        for (Musica musica : musicas) {
            System.out.println("- " + musica.getTitulo());
        }
    }
}

class MusicCloud {
    private List<Musica> musicasDisponiveis;

    public MusicCloud() {
        musicasDisponiveis = new ArrayList<>();
        // Adicione músicas disponíveis
        musicasDisponiveis.add(new Musica("Hino do Real Paulista", "Banda RP"));
        musicasDisponiveis.add(new Musica("Macarena", "Los Del Rio"));
        musicasDisponiveis.add(new Musica("Evidências", "Chitãozinho & Xororó"));
        musicasDisponiveis.add(new Musica("Bohemian Rhapsody", "Queen"));
        musicasDisponiveis.add(new Musica("Thriller", "Michael Jackson"));
    }

    public Musica buscarMusica(String titulo) throws Exception {
        for (Musica musica : musicasDisponiveis) {
            if (musica.getTitulo().equalsIgnoreCase(titulo)) {
                return musica;
            }
        }
        throw new Exception("A música " + titulo + " não foi encontrada no sistema.");
    }
}
