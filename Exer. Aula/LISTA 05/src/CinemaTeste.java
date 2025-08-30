import java.util.Scanner;

public class CinemaTeste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cinema cinema = new Cinema();

        // Adiciona filmes disponíveis
        cinema.adicionarFilme(new Filme("Homem Aranha", 20.0, 10));
        cinema.adicionarFilme(new Filme("Deadpool", 25.0, 18));
        cinema.adicionarFilme(new Filme("Divertidamente 2", 18.0, 6));
        cinema.adicionarFilme(new Filme("Batman", 22.0, 14));
        cinema.adicionarFilme(new Filme("Oppenheimer", 30.0, 16));

        boolean continuar = true;

        while (continuar) {
            System.out.print("\nQue filme você deseja assistir? ");
            String nomeFilme = scanner.nextLine();
            Filme filme = cinema.buscarFilme(nomeFilme);

            if (filme == null) {
                System.out.println("Filme não encontrado.");
                continue;
            }

            System.out.print("Qual assento você deseja? ");
            String assento = scanner.nextLine();

            System.out.print("Qual o seu nome? ");
            String nome = scanner.nextLine();

            System.out.print("Qual a sua idade? ");
            int idade = Integer.parseInt(scanner.nextLine());

            Cliente cliente = new Cliente(nome, idade);
            Ingresso ingresso = new Ingresso(cliente, filme, assento);

            try {
                cinema.venderIngresso(ingresso);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.print("Deseja comprar outro ingresso? (s/n): ");
            String resposta = scanner.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        scanner.close();
    }
}
