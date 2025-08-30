import java.util.ArrayList;
import java.util.List;

public class Barco {
    private String nome;
    private int tamanho;

    public Barco(String nome, int tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public int getTamanho() {
        return tamanho;
    }
}

class BasePorto {
    protected String nome;
    protected List<Barco> barcosAtracados;

    public BasePorto(String nome) {
        this.nome = nome;
        this.barcosAtracados = new ArrayList<>();
    }

    public boolean atracarBarco(Barco barco) {
        barcosAtracados.add(barco);
        return true;
    }

    public void desatracarBarco(Barco barco) {
        barcosAtracados.remove(barco);
    }

    public String getNome() {
        return nome;
    }
}

class PortoPequeno extends BasePorto {

    public PortoPequeno(String nome) {
        super(nome);
    }

    @Override
    public boolean atracarBarco(Barco barco) {
        if (barco.getTamanho() <= 10) {
            super.atracarBarco(barco);
            return true;
        }
        return false;
    }
}

class PortoGrande extends BasePorto {

    public PortoGrande(String nome) {
        super(nome);
    }

    @Override
    public boolean atracarBarco(Barco barco) {
        if (barco.getTamanho() >= 10) {
            super.atracarBarco(barco);
            return true;
        }
        return false;
    }
}
