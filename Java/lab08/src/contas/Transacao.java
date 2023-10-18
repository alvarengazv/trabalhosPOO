package contas;

import java.util.Date;

public class Transacao {
    private double valor;
    private Date data;
    private String descricao;

    public Transacao(double valor, Date data, String descricao) {
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
    }

    public Transacao() {
        super();
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
