package model;

public class Cliente {
    private String nome;
    private String telefone;
    private String endereco;
    private boolean vip;

    public Cliente(String nome, String telefone, String endereco, boolean vip) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.vip = vip;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s%s", nome, telefone, endereco, (vip ? " [VIP]" : ""));
    }
}
