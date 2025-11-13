package model;

public class Pedido {
    private int numero;
    private String cliente;
    private String sabor;
    private char tamanho;
    private double valor;
    private int tempoPreparo;
    private boolean vip;

    public Pedido(int numero, String cliente, String sabor, char tamanho, double valor, int tempoPreparo, boolean vip) {
        this.numero = numero;
        this.cliente = cliente;
        this.sabor = sabor;
        this.tamanho = tamanho;
        this.valor = valor;
        this.tempoPreparo = tempoPreparo;
        this.vip = vip;
    }

    // Getters e Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public char getTamanho() {
        return tamanho;
    }

    public void setTamanho(char tamanho) {
        this.tamanho = tamanho;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
    public String toString() {
        return String.format("Pedido #%d | Cliente: %s | Sabor: %s | Tamanho: %c | Valor: R$ %.2f | Tempo: %dmin%s",
                numero, cliente, sabor, tamanho, valor, tempoPreparo, (vip ? " [VIP]" : ""));
    }
}
