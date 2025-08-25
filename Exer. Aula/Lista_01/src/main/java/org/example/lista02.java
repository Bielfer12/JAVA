package org.example;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class lista02 {
    public static void main(String[] args) {
       //   exercicio01();
        //exercicio02();
        //exercicio03();
    }

    static void exercicio01() {
        Random gera = new Random();

        char[] alfa = new char[36];
        int i = 0;

        for (char c = '0'; c <= '9'; c++) {
            alfa[i++] = c;
        }

        for (char c = 'a'; c <= 'z'; c++) {
            alfa[i++] = c;
        }

        int[] g = new int[8];
        String[] s = new String[8];
        for (int x = 0; x < 8; x++) {
            g[x] = gera.nextInt(alfa.length);
            s[x] = String.valueOf(alfa[g[x]]);
        }

        System.out.print("Senha Gerada: ");

        for (int l = 0; l < s.length; l++) {
            System.out.print(s[l]);
        }
    }

    static void exercicio02() {

        Random gera = new Random();

        String[] nomes = {"Carlos", "Guilherme", "Pitoco", "Gabriel", "Jhony", "Ronaldo", "Ricardo", "Daniel", "Lucas", "Patrick"};
        String[] sobrenomes = {"Silva", "Santos", "Oliveira", "Souza", "Ramos", "Costa", "Gomes", "Casagrande", "Carrer", "Fernandes"};
        String[] posicoes = {"Goleiro", "Zagueiro", "Lateral", "Meio-campo", "Atacante", "Volante", "Ponta"};
        String[] times = {"Corinthians", "Palmeiras", "São Paulo", "Flamengo", "Vasco", "Grêmio", "Internacional", "Cruzeiro", "Atlético-MG", "Santos"};

        int idade = gera.nextInt(100);

        String nmGera = nomes[gera.nextInt(nomes.length)];
        String snGera =  sobrenomes[gera.nextInt(sobrenomes.length)];
        String psGera =  posicoes[gera.nextInt(posicoes.length)];
        String tmGera =  times[gera.nextInt(times.length)];

        System.out.println(nmGera + " " + snGera +
                            " é um futebolista brasileiro de " + idade +
                            " anos que atua como " + psGera +
                            ". Atualmente defende o " + tmGera);
    }

    static void exercicio03() {

        Random gera = new Random();
        Scanner scanner = new Scanner(System.in);

        String[] pokemon = {"Pikachu", "Charmander", "Bulbasaur", "Squirtle", "Jigglypuff", "Meowth", "Psyduck", "Snorlax", "Gengar", "Eevee"};
        String[] tipos = {"Elétrico", "Fogo", "Planta", "Água", "Normal", "Psíquico", "Fantasma"};

        System.out.println("Quantos pokemons quer gerar?");
        int qtd = scanner.nextInt();

        for (int i = 0; i < qtd; i++) {

            int nivel = gera.nextInt(100) + 1;

            String pokeGera = pokemon[gera.nextInt(pokemon.length)];
            String tipoGera = tipos[gera.nextInt(tipos.length)];


            System.out.println(pokeGera + " é um Pokémon do tipo "
                             + tipoGera + " de nível " + nivel);
        }
        scanner.close();
        }

    }
