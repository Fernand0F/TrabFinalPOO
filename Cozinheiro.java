public class Cozinheiro extends Funcionario {
    
    public String pratosCozinheiro;
    
    public Cozinheiro(String nome, String CPF, String RG, String estadoCivil, String endereco, String carteiraTrabalho, Data dataAdmissao, String pratosCozinheiro){
        super(nome, CPF, RG, estadoCivil, endereco, carteiraTrabalho, dataAdmissao);
        this.pratosCozinheiro = pratosCozinheiro;
    }
    
    public void setPratosCozinheiro(String pratosCozinheiro) {
        this.pratosCozinheiro = pratosCozinheiro;
    }

    public String getPratosCozinheiro() {
        return pratosCozinheiro;
    }
    
    @Override
    public abstract double calcSalario(){
        //o calculo q eu n sei
    }
}
