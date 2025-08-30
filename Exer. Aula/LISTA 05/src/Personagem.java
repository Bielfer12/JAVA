public class Personagem {

    private String nome;
    private int vida;
    private int ataque;

    public Personagem(String nome, int vida, int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
    }

    public int getVida() {
        return vida;
    }

    public String getNome() {
        return nome;
    }

    public void receberDano(int dano) {
        if (vida <= 0) {
            // Personagem já está morto, não faz sentido receber mais dano
            return;
        }

        vida -= dano;
        if (vida <= 0) {
            vida = 0;
            System.out.println(nome + " foi derrotado!");
        } else {
            System.out.println(nome + " sobreviveu com " + vida + " de vida");
        }
    }

    public void atacar(Personagem alvo) {
        if (alvo.getVida() <= 0) {
            System.out.println("Ataque falhou! " + alvo.getNome() + " já está derrotado.");
            return;
        }

        alvo.receberDano(this.ataque);
    }
}
