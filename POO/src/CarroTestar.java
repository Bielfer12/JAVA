public class CarroTestar {

    public  static void main(String[] args) {

        Carro c1 = new Carro();

        c1.nome = "UNO";
        c1.marca = "FIAT";
        c1.ano = 2015;
        c1.vel = 60;

        c1.acelerar(10);
        System.out.println("Acelerando: " + c1.vel);

        c1.frear(10);
        System.out.println("Freiando: " + c1.vel);

        c1.buzinar();
    }
}
