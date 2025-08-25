//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Carro {

    //Atributos
    String nome;
    String marca;
    Integer ano;
    Integer vel;

    //metodos
    void acelerar(int aceleracao){
        vel+=aceleracao;
    }

    void frear(int frear){
        vel-=frear;
    }

    void buzinar(){
        System.out.println("BIBIBI");
    }

}