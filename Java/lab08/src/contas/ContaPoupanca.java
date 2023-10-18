package contas;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContaPoupanca extends ContaCorrenteComum{
    private Date dataCredito;

    public ContaPoupanca() {
    }

    public ContaPoupanca(Date dataCredito) {
        this.dataCredito = dataCredito;
    }

    public ContaPoupanca(String nomeTitular, Date dataCredito) {
        super(nomeTitular);
        this.dataCredito = dataCredito;
    }

    public ContaPoupanca(String nomeTitular, double saldo, Date dataCredito) {
        super(nomeTitular, saldo);
        this.dataCredito = dataCredito;
    }

    @Override
    public void imprimirExtrato(){
        super.imprimirExtrato();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM");
        String formattedDate = formatter.format(this.dataCredito);

        System.out.println("Dia do aniversário para creditar: " + formattedDate);
    }

    public Date getDataCredito() {
        return dataCredito;
    }

    public void setDataCredito(Date dataCredito) {
        this.dataCredito = dataCredito;
    }
}
