import java.sql.SQLOutput;

public class FaturaTeste {
    public static void main(String[] args) {

    Fatura f1 = new Fatura("001","Chcolate Branco",2,2);
    Fatura f2 = new Fatura("002","Chcolate Branco",2,4);

        System.out.println(f1.getAll());
        System.out.println(f2.getAll());

        System.out.println("Total da compra: " + f1.getTotalFatura());
        System.out.println("Total da compra: " + f2.getTotalFatura());
    }
}
