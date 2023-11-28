public class Garcom extends Funcionario {
    
    private double salarioBase;
    public String diaFolga;
    
    public Garcom(String nome, String CPF, String RG, String estadoCivil, String endereco, String carteiraTrabalho, Data dataAdmissao, double salarioBase, String diaFolga){
        super(nome, CPF, RG, estadoCivil, endereco, carteiraTrabalho, dataAdmissao);
        this.salarioBase = salarioBase;
        this.diaFolga = diaFolga;
    }
    
    public void setDiaFolga(String diaFolga) {
        this.diaFolga = diaFolga;
    }

    public String getDiaFolga() {
        return diaFolga;
    }
    public double setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
    
     @Override
    public abstract double calcSalario(){
        //o calculo q eu n sei
    }
}
