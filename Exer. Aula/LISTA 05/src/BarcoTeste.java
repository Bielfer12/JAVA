import java.util.ArrayList;
import java.util.List;

public class BarcoTeste {
    public static void main(String[] args) {
        // Criar barcos
        List<Barco> barcos = new ArrayList<>();
        barcos.add(new Barco("Barco 1", 2));
        barcos.add(new Barco("Barco 2", 5));
        barcos.add(new Barco("Barco 3", 7));
        barcos.add(new Barco("Barco 4", 12));
        barcos.add(new Barco("Barco 5", 20));

        // Criar portos
        BasePorto portoPequeno = new PortoPequeno("Porto Pequeno");
        BasePorto portoGrande = new PortoGrande("Porto Grande");

        // Atracar barcos
        for (Barco barco : barcos) {
            boolean atracado = portoPequeno.atracarBarco(barco);

            if (atracado) {
                System.out.println(barco.getNome() + " atracado no porto pequeno");
            } else if (portoGrande.atracarBarco(barco)) {
                System.out.println(barco.getNome() + " atracado no porto grande");
            } else {
                System.out.println(barco.getNome() + " não pôde ser atracado");
            }
        }
    }
}
