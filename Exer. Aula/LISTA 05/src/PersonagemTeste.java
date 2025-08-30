import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonagemTeste {

    public static void main(String[] args) {
        List<Personagem> inimigos = new ArrayList<>();
        inimigos.add(new Personagem("Orc", 100, 10));
        inimigos.add(new Personagem("Goblin", 50, 5));
        inimigos.add(new Personagem("Lobo", 75, 15));
        inimigos.add(new Personagem("Cavaleiro", 200, 20));
        inimigos.add(new Personagem("Dragão", 500, 50));

        Personagem jogador = new Personagem("Steve", 100, 20);

        Random random = new Random();

        while (jogador.getVida() > 0 && inimigosVivos(inimigos)) {

            // Jogador ataca inimigo vivo aleatório
            Personagem alvo = escolherAlvoAleatorio(inimigos, random);
            if (alvo != null) {
                System.out.println("\nSteve está atacando " + alvo.getNome());
                jogador.atacar(alvo);
            }

            // Inimigos vivos atacam jogador
            for (Personagem inimigo : inimigos) {
                if (inimigo.getVida() > 0) {
                    System.out.println(inimigo.getNome() + " está atacando Steve");
                    inimigo.atacar(jogador);
                    if (jogador.getVida() <= 0) {
                        break;
                    }
                }
            }
        }

        // Resultado final
        System.out.println("\n--- Resultado Final ---");
        if (jogador.getVida() <= 0) {
            System.out.println("Steve foi derrotado!");
        } else {
            System.out.println("Steve venceu todos os inimigos!");
        }
    }

    private static boolean inimigosVivos(List<Personagem> inimigos) {
        for (Personagem inimigo : inimigos) {
            if (inimigo.getVida() > 0) {
                return true;
            }
        }
        return false;
    }

    private static Personagem escolherAlvoAleatorio(List<Personagem> inimigos, Random random) {
        List<Personagem> vivos = new ArrayList<>();
        for (Personagem inimigo : inimigos) {
            if (inimigo.getVida() > 0) {
                vivos.add(inimigo);
            }
        }
        if (vivos.isEmpty()) {
            return null;
        }
        int index = random.nextInt(vivos.size());
        return vivos.get(index);
    }
}
