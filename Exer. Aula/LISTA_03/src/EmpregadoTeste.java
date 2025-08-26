public class EmpregadoTeste {
    public static void main(String[] args) {

        Empregado func1 = new Empregado("Gabriel", "Casagrande", 1000f);
        Empregado func2 = new Empregado("Guilherme", "Carrer", 2000f);

        System.out.println("Salario anual: " + func1.salarioAno());
        System.out.println("Salario anual: " + func2.salarioAno());

        //aumento

        System.out.println("Salario anual mais 10%: " + func1.salarioAno10());
        System.out.println("Salario anual mais 10%: " + func2.salarioAno10());

    }
}
