public class Data {

    private int mes;
    private int dia;
    private int ano;

    public Data(int mes, int dia, int ano) {
        this.mes = mes;
        this.dia = dia;
        this.ano = ano;
    }

    //getters e setter

    public void  setMes(int mes) {
        this.mes = mes;
    }
    public void setDia(int dia) {
        this.dia = dia;

    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public int getMes() {
        return mes;
    }
    public int getDia() {
        return dia;
    }
    public int getAno() {
        return ano;
    }

    //metodos
    void checkMes(){
        if (mes < 1 || mes > 12) System.out.println("não esta certo");

    }



}
