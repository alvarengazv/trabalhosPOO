package contas;

public class ContaCorrentePremium extends ContaCorrenteComum{
    private double limiteCredito;

    public ContaCorrentePremium() {
    }

    public ContaCorrentePremium(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public ContaCorrentePremium(String nomeTitular, double limiteCredito) {
        super(nomeTitular);
        this.limiteCredito = limiteCredito;
    }

    public ContaCorrentePremium(String nomeTitular, double saldo, double limiteCredito) {
        super(nomeTitular, saldo);
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void imprimirExtrato(){
        super.imprimirExtrato();
        System.out.println("Valor do limite de crédito: " + this.limiteCredito);
    }

    @Override
    public void saque(double valor){
        if(valor > 0) {
            double valorDisponivel = this.limiteCredito + this.saldo;

            if (valorDisponivel >= valor) {
                realizarTransacao("Saque", -valor);
                this.saldo -= valor;
                System.out.println("Saque realizado!");
            } else {
                System.out.println("Saldo insuficiente!");
            }
        } else {
            System.out.println("Digite um valor maior que zero!");
        }
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }
}
