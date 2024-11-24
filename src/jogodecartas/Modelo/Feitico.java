package jogodecartas.Modelo;

public class Feitico extends Carta {

    private int efeito;
    private int nivel;
    private String Categoria;

    public Feitico(String nome) {
        super(nome, "Feitico");
        switch (nome) {
            case "equipamento":
            	this.Categoria = "Feitico";
                this.efeito = 1;
                this.nivel = 1;
                break;
            case "campoF":
            	this.Categoria = "Feitico";
                this.efeito = 2;
                this.nivel = 1;
                break;
            case "campoR":
            	this.Categoria = "Feitico";
                this.efeito = 3;
                this.nivel = 1;
                break;
            case "campoA":
            	this.Categoria = "Feitico";
                this.efeito = 4;
                this.nivel = 1;
                break;
            default:
                throw new IllegalArgumentException("Nome de feitiço inválido: " + nome);
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

    public static Feitico fromString(String nome) {
        try {
            return new Feitico(nome);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
