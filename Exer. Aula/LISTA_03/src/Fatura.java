//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Fatura {

    private String num;
    private String descr;
    private int qtd;
    private float precoporitem;

    Fatura() {

    }
    //SETTER E GETTERS
    //numero
    public void setNum(String num){
        this.num = num;
    }

    public String getNum() {
        return num;
    }
    //descrição
    public void setDescr(String descr){
        this.descr = descr;
    }

    public String getDescr() {
        return descr;
    }

    //quantidade
    public void setQtd(int qtd){
        this.qtd = qtd;
    }

    public int getQtd(){
        return qtd;
    }
    //preo por item
    public void setPrecoporitem(float precoporitem){
        this.precoporitem = precoporitem;
    }

    public float getPrecoporitem(){
        return precoporitem;
    }
    //CONSTRUTOR

    public Fatura(String num, String Descr, int qtd, float precoporitem){
        this.num = num;
        this.descr = Descr;
        this.qtd = qtd;
        this.precoporitem = precoporitem;
    }

    public Object getAll(){
        return " Numero: "+ this.num +
                " Descrição: " + this.descr +
                " Quantidade: " + this.qtd +
                " Preco por item: " + this.precoporitem;
    }

    //metodo
    float getTotalFatura(){
        if (qtd < 0) qtd = 0;
        if (precoporitem < 0) precoporitem = 0;

        return qtd * precoporitem;
    }



}