package jogodecartas.Modelo;

public class Monstro extends Carta {
    private int ataque;
    private int defesa;
    private int nivel;
    private int efeito;
    private String Categoria;
    
    public Monstro(String nome) {
        super(nome, "Monstro");
        switch (nome) {
            case "lobo":
            	this.Categoria = "Monstro";
                this.ataque = 2500;
                this.defesa = 2000;
                this.nivel = 5;
                this.efeito = 5;
                break;
            case "abelha":
            	this.Categoria = "Monstro";
                this.ataque = 1000;
                this.defesa = 1000;
                this.nivel = 1;
                this.efeito = 7;
                break;
            case "aguia":
            	this.Categoria = "Monstro";
                this.ataque = 2000;
                this.defesa = 1500;
                this.nivel = 4;
                this.efeito = 4;
                break;
            case "aranha":
            	this.Categoria = "Monstro";
                this.ataque = 1500;
                this.defesa = 1200;
                this.nivel = 2;
                this.efeito = 5;
                break;
            case "besouro":
            	this.Categoria = "Monstro";
                this.ataque = 1200;
                this.defesa = 1200;
                this.nivel = 1;
                this.efeito = 0;
                break;
            case "cobra":
            	this.Categoria = "Monstro";
                this.ataque = 2000;
                this.defesa = 1000;
                this.nivel = 3;
                this.efeito = 1;
                break;
            case "enguia":
            	this.Categoria = "Monstro";
                this.ataque = 2000;
                this.defesa = 1500;
                this.nivel = 4;
                this.efeito = 6;
                break;
            case "dragao relampago":
            	this.Categoria = "Monstro";
                this.ataque = 3000;
                this.defesa = 2500;
                this.nivel = 8;
                this.efeito = 2;
                break;
            case "tigre":
            	this.Categoria = "Monstro";
                this.ataque = 2500;
                this.defesa = 2000;
                this.nivel = 7;
                this.efeito = 3;
                break;
            case "guerreiro alado":
            	this.Categoria = "Monstro";
                this.ataque = 2000;
                this.defesa = 2000;
                this.nivel = 2;
                this.efeito = 0;
                break;
            case "gato":
            	this.Categoria = "Monstro";
                this.ataque = 1200;
                this.defesa = 1200;
                this.nivel = 1;
                this.efeito = 0;
                break;
            case "cobra de fogo":
            	this.Categoria = "Monstro";
                this.ataque = 2000;
                this.defesa = 1000;
                this.nivel = 3;
                this.efeito = 1;
                break;
            case "coelho":
            	this.Categoria = "Monstro";
                this.ataque = 1000;
                this.defesa = 1000;
                this.nivel = 1;
                this.efeito = 7;
                break;
            case "dragao de fogo":
            	this.Categoria = "Monstro";
                this.ataque = 3000;
                this.defesa = 2500;
                this.nivel = 8;
                this.efeito = 2;
                break;
            case "fenix":
            	this.Categoria = "Monstro";
                this.ataque = 2000;
                this.defesa = 1500;
                this.nivel = 5;
                this.efeito = 6;
                break;
            case "guerreiro":
            	this.Categoria = "Monstro";
                this.ataque = 2000;
                this.defesa = 2000;
                this.nivel = 2;
                this.efeito = 0;
                break;
            case "leao":
            	this.Categoria = "Monstro";
                this.ataque = 2500;
                this.defesa = 2000;
                this.nivel = 7;
                this.efeito = 3;
                break;
            case "raposa":
            	this.Categoria = "Monstro";
                this.ataque = 1500;
                this.defesa = 1200;
                this.nivel = 2;
                this.efeito = 4;
                break;
            case "tigre de fogo":
            	this.Categoria = "Monstro";
                this.ataque = 2500;
                this.defesa = 2000;
                this.nivel = 7;
                this.efeito = 3;
                break;
            case "cavalo":
            	this.Categoria = "Monstro";
                this.ataque = 1500;
                this.defesa = 1500;
                this.nivel = 3;
                this.efeito = 5;
                break;
            case "cobra marinha":
            	this.Categoria = "Monstro";
                this.ataque = 2000;
                this.defesa = 1000;
                this.nivel = 3;
                this.efeito = 1;
                break;
            case "golfinho":
            	this.Categoria = "Monstro";
                this.ataque = 2500;
                this.defesa = 2000;
                this.nivel = 6;
                this.efeito = 3;
                break;
            case "peixe pequeno":
            	this.Categoria = "Monstro";
                this.ataque = 1000;
                this.defesa = 1000;
                this.nivel = 1;
                this.efeito = 7;
                break;
            case "peixe":
            	this.Categoria = "Monstro";
                this.ataque = 1500;
                this.defesa = 1200;
                this.nivel = 2;
                this.efeito = 5;
                break;
            case "sapo":
            	this.Categoria = "Monstro";
                this.ataque = 1200;
                this.defesa = 1200;
                this.nivel = 1;
                this.efeito = 0;
                break;
            case "sereia":
            	this.Categoria = "Monstro";
                this.ataque = 2000;
                this.defesa = 2000;
                this.nivel = 2;
                this.efeito = 0;
                break;
            case "tartaruga":
            	this.Categoria = "Monstro";
                this.ataque = 0;
                this.defesa = 2000;
                this.nivel = 1;
                this.efeito = 4;
                break;
            case "tubarao":
            	this.Categoria = "Monstro";
                this.ataque = 2500;
                this.defesa = 2000;
                this.nivel = 7;
                this.efeito = 3;
                break;
            case "dragao marinho":
            	this.Categoria = "Monstro";
                this.ataque = 3000;
                this.defesa = 2500;
                this.nivel = 8;
                this.efeito = 2;
                break;
            case "jacare":
            	this.Categoria = "Monstro";
                this.ataque = 2000;
                this.defesa = 2000;
                this.nivel = 3;
                this.efeito = 6;
                break;
            case "nulo":
            	this.Categoria = "Monstro";
                this.ataque = 0;
                this.defesa = 0;
                this.nivel = 0;
                this.efeito = 10;
                break;
        }
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getNivel() {
        return nivel;
    }

    public int getEfeito() {
        return efeito;
    }

	public String getCategoria() {
		return Categoria;
	}
}
