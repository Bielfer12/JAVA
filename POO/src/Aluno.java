public class Aluno {

    //Usado para questões de privilegio, para que não seja de facl acesso a variaveis,
    // e se realmente quiser dar acesso, sera necessario criar um metodo, como um tipo de validação

    private String nome;
    public Integer idade;

    //setting
    public void setNome(String nome){
        this.nome = nome;
    }
    //getting
    public String getNome(){
        return nome;
    }
}
