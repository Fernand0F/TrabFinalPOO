public class Funcionario {
    private String nome;
    private String CPF;
    private String RG;
    private String estadoCivil;
    private String endereco;
    private String carteiraTrabalho;
    private Data dataAdmissao;
    
    public Funcionario{
        nome = null;
        CPF = null;
        RG = null;
        estadoCivil = null;
        endereco = null;
        carteiraTrabalho = null;
        dataAdmissao;
    }
    
    public Funcionario(String nome, String CPF, String RG, String estadoCivil, String endereco, String carteiraTrabalho, Data dataAdmissao){
        this.nome = nome;
        this.CPF = CPF;
        this.RG = RG;
        this.estadoCivil = estadoCivil;
        this.endereco = endereco;
        this.carteiraTrabalho = carteiraTrabalho;
        this.dataAdmissao = new Data(dataAdmissaon);
    }
    
    //Métodos get e set
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        //Precisa validarrr!
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCarteiraTrabalho() {
        return carteiraTrabalho;
    }

    public void setCarteiraTrabalho(String carteiraTrabalho) {
        this.carteiraTrabalho = carteiraTrabalho;
    }

    public Data getData() {
        return new Data(this.dataAdmissao);
    }

    public void setDataAdmissao(int dia, int mes, int ano) {
        this.dataAdmissao = new Data(dia, mes, ano);
    }
 //Método calcula salario
    public abstract double calcSalario();   
}
