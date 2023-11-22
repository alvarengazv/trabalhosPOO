package Excecoes;

public class ExcecaoMedicoInexistente extends Exception {
    public ExcecaoMedicoInexistente() {
        super("Impossível remover médico. CRM não existe.");
    }
}
