package contas;

public class ContaInvestimento extends ContaCorrenteComum{
    private double taxaRetornoAnual;

    public ContaInvestimento() {
        super();
    }

    public ContaInvestimento(double taxaRetornoAnual) {
        this.taxaRetornoAnual = taxaRetornoAnual;
    }

    public ContaInvestimento(String nomeTitular, double taxaRetornoAnual) {
        super(nomeTitular);
        this.taxaRetornoAnual = taxaRetornoAnual;
    }


    public ContaInvestimento(String nomeTitular, double saldo, double taxaRetornoAnual) {
        super(nomeTitular, saldo);
        this.taxaRetornoAnual = taxaRetornoAnual;
    }

    @Override
    public void imprimirExtrato(){
        super.imprimirExtrato();
        System.out.println("Taxa de retorno anual: " + this.taxaRetornoAnual);
    }

    public double getTaxaRetornoAnual() {
        return taxaRetornoAnual;
    }

    public void setTaxaRetornoAnual(double taxaRetornoAnual) {
        this.taxaRetornoAnual = taxaRetornoAnual;
    }
}
