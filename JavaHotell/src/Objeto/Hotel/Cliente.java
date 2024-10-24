package Objeto.Hotel;

public class Cliente {
    private String nomeCompleto;

    public Cliente(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String obterNome() {
        return nomeCompleto;
    }

    public void definirNome(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    @Override
    public String toString() {
        return "Cliente: " + nomeCompleto;
    }
}
