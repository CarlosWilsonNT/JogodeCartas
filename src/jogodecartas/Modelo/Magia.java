package jogodecartas.Modelo;

public class Magia extends Carta {

    private int efeito;
    private int nivel;
    private String Categoria;

    public Magia(String nome) {
        super(nome, "Magia");
        switch (nome) {
            case "compra":
            	this.Categoria = "Magia";
                this.efeito = 1;
                this.nivel = 3;
                break;
            case "vida":
            	this.Categoria = "Magia";
                this.efeito = 2;
                this.nivel = 3;
                break;
            case "dano":
            	this.Categoria = "Magia";
                this.efeito = 3;
                this.nivel = 3;
                break;
            case "destruicao":
            	this.Categoria = "Magia";
                this.efeito = 4;
                this.nivel = 8;
                break;
            case "ataque":
            	this.Categoria = "Magia";
                this.efeito = 5;
                this.nivel = 2;
                break;
            case "defesa":
            	this.Categoria = "Magia";
                this.efeito = 6;
                this.nivel = 2;
                break;
            default:
                throw new IllegalArgumentException("Nome de magia inválido: " + nome);
        }
    }

    public int getEfeito() {
        return efeito;
    }

    public int getNivel() {
        return nivel;
    }
    public String getCategoria() {
		return Categoria;
	}

    public static Magia fromString(String nome) {
        try {
            return new Magia(nome);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
