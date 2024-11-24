package jogodecartas.Modelo;

public abstract class Carta {
    private String nome;
    private String categoria;

    public Carta(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getNome() {
        return nome;
    }
}
