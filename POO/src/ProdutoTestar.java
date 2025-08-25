public class ProdutoTestar {

    public static void main(String[] args) {

        //construtor padrão
        Produto p1 = new Produto();
        p1.nome = "caneta Preta";
        p1.marca = "faber";
        p1.valor = 1.90f;

        //construtor que recebe 2 parametros
        Produto p2 = new Produto("Caneta Vermelha","Faber");
        p2.valor = 1.90f;

        //construtor que recebe 3 parametros
        Produto p3 = new Produto("Caneta Vermelha","Faber",1.89f);


        System.out.println(p1.nome + p1.marca + p1.valor);
        System.out.println(p2.nome + p2.marca + p2.valor);
        System.out.println(p3.nome + p3.marca + p3.valor);

    }
}
