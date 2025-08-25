package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //exercicio01();
        //exercicio02();
        //exercicio03();
        //exercicio04();
        //exercicio05();
        //exercicio06();

        /*exercicio07:*/
/*

        System.out.println("Peso: ");
        double peso = Double.parseDouble(scanner.nextLine());
        System.out.println("Altura: ");
        double altura = Double.parseDouble(scanner.nextLine());

        double imc = calcularIMC(peso,altura);

        System.out.println("IMC: " + imc);
*/

        exercicio08();
        //exercicio09();
    }
    static void exercicio01() {
        System.out.println("Bem-vindo ao Sistema de Geração de Jogadores!");
    }

    static void exercicio02() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escreva o nome da pessoa: ");
        String nome = scanner.nextLine();
        System.out.println("Escreva o cargo: ");
        String cargo = scanner.nextLine();
        System.out.println("Escreva o salario: ");
        double salario = Double.parseDouble(scanner.nextLine());

        System.out.println("Nome: " + nome);
        System.out.println("Cargo: " + cargo);
        System.out.println("Sálario R$: " + salario);

        scanner.close();
    }

    static void exercicio03() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escreva o Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.println("Escreva o Código: ");
        int cod = Integer.parseInt(scanner.nextLine());
        System.out.println("Escreva o Preço: ");
        double preco = Double.parseDouble(scanner.nextLine());
        System.out.println("Escreva se esta na promoção(true/false): ");
        boolean promo = Boolean.parseBoolean(scanner.nextLine());

        System.out.println("Produto: " + nome);
        System.out.println("Código: " + cod);
        System.out.println("Preço: " + preco);
        if (promo == true) {
            System.out.println("Promoção: Sim");
        }else {
            System.out.println("Promoção: Não");
        }

        scanner.close();
    }

    static void exercicio04() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o valor total da compra: ");
        double total = Double.parseDouble(scanner.nextLine());

        double desc = (10*total)/100;

        if (total >= 100) {
            System.out.println("Valor da compra: " + total);
            System.out.println("Voce ganhou desconto de: " + desc);
            System.out.println("Total a pagar com desconto: "+ (total - desc));
        }else{
            System.out.println("Total a pagar sem desconto: " + total);
        }

        scanner.close();

    }

    static void exercicio05(){

        Scanner scanner = new Scanner(System.in);

        String cat = "";

        System.out.println("Qual sua idade: ");
        int idade = Integer.parseInt(scanner.nextLine());

        if (idade < 12){
            cat = "Infantil";
        } else if (idade >= 12 & idade <= 17) {
            cat = "Adolescente";
        } else if (idade >= 18) {
            cat = "Adulto";
        }

        System.out.println("Categoria: " + cat);

        scanner.close();
    }

    static void exercicio06(){

        Scanner scanner = new Scanner(System.in);

        int[] notas = new int[5];

        for (int i = 0; i < 5; i++){

            System.out.println("Escreva a nota do aluno: ");
            notas[i] = Integer.parseInt(scanner.nextLine());
        }

        System.out.println("Notas dos alunos: " + Arrays.toString(notas));

        System.out.println("Média das notas: "+ (((notas[0]+notas[1]+notas[2]+notas[3]+notas[4]) / 5.0)));
        scanner.close();
    }

    static double calcularIMC(double peso, double altura){
        return peso / Math.pow(altura, 2);
    }

    static void exercicio08() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Nome do cliente: ");
        String nome = scanner.nextLine();

        //Conta caracteres sem espaços
        String Sespaco = String.valueOf(nome.replace(" ","").length());

        //tudo maiusculo
        String maius = nome.toUpperCase();

        System.out.println("Numero de caracteres: " + Sespaco);
        System.out.println("Maicusulas: "+ maius);
        if ("Silva".contains(maius)) {
            System.out.println("Contem silva: " + false);
        } else {
            System.out.println("Contem silva: " + true);
        }

    }

}


