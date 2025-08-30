// Interface
public interface PlataformaSocial {
    void compartilharPostagem(Postagem postagem) throws Exception;
    void compartilharImagem(Postagem postagem) throws Exception;
    void compartilharVideo(Postagem postagem) throws Exception;
}

// Classe Postagem
class Postagem {
    private String titulo;
    private String descricao;
    private String tipo; // "texto", "imagem", "video"

    public Postagem(String titulo, String descricao, String tipo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo.toLowerCase();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTipo() {
        return tipo;
    }
}

// Classe MyBook
class MyBook implements PlataformaSocial {
    public void compartilharPostagem(Postagem postagem) {
        System.out.println("Você compartilhou essa postagem no MyBook.");
    }

    public void compartilharImagem(Postagem postagem) {
        System.out.println("Você compartilhou essa imagem no MyBook.");
    }

    public void compartilharVideo(Postagem postagem) {
        System.out.println("Você compartilhou esse vídeo no MyBook.");
    }
}

// Classe Fotogram
class Fotogram implements PlataformaSocial {
    public void compartilharPostagem(Postagem postagem) throws Exception {
        throw new Exception("Fotogram não permite compartilhamento de postagens de texto.");
    }

    public void compartilharImagem(Postagem postagem) {
        System.out.println("Você compartilhou essa postagem no Fotogram.");
    }

    public void compartilharVideo(Postagem postagem) {
        System.out.println("Você compartilhou esse vídeo no Fotogram.");
    }
}

// Classe AnyTube
class AnyTube implements PlataformaSocial {
    public void compartilharPostagem(Postagem postagem) {
        System.out.println("Você compartilhou essa postagem no AnyTube.");
    }

    public void compartilharImagem(Postagem postagem) throws Exception {
        throw new Exception("AnyTube não permite compartilhamento de imagens.");
    }

    public void compartilharVideo(Postagem postagem) {
        System.out.println("Você compartilhou esse vídeo no AnyTube.");
    }
}
