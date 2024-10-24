package Objeto.Hotel;

public class Quarto {
    private int numero;
    private String tipo;
    private double preco;
    private boolean disponivel;

    public Quarto(int numero, String tipo, double preco, boolean disponivel) {
        this.numero = numero;
        this.tipo = tipo;
        this.preco = preco;
        this.disponivel = disponivel;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return String.format("Quarto [Número=%d, Tipo=%s, Preço=%.2f, Disponível=%s]", numero, tipo, preco, disponivel);
    }
}
