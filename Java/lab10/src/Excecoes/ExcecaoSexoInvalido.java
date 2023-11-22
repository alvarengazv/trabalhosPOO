package Excecoes;

public class ExcecaoSexoInvalido extends Exception {
    public ExcecaoSexoInvalido() {
        super("Sexo inválido. Favor digitar M ou F");
    }
}
