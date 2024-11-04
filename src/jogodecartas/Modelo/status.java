package jogodecartas.Modelo;

public class status {
	//ataque,defesa,nivel,efeito
	int[] lobo = {2500, 2000, 5, 5};
	int[] abelha = {1000, 1000, 1,7};
	int[] aguia = {2000,1500, 4,4};
	int[] aranha = {1500,1200, 2,5};
	int[] besouro = {1200, 1200, 1,0};
	int[] cobra = {2000,1000, 3,1};
	int[] enguia = {2000,1500,4,6};
	int[] dragaoR = {3000,2500,8,2};
	int[] tigre = {2500,2000,7,3};
	int[] guerreiroA = {2000,2000,2,0};
	int[] gato = {1200,1200,1,0};
	int[] cobraF = {2000,1000,3,1};
	int[] coelho = {1000,1000,1,7};
	int[] dragaoF = {3000,2500,8,2};
	int[] fenix = {2000,1500,5,6};
	int[] guerreiro = {2000,2000,2,0};
	int[] leao = {2500,2000,7,3};
	int[] raposa = {1500,1200,2,4};
	int[] tigreF = {2500,2000,7,3};
	int[] cavalo = {1500,1500,3,5};
	int[] cobraM = {2000,1000,3,1};
	int[] golfinho = {2500,2000,6,3};
	int[] peixeP = {1000,1000,1,7};
	int[] peixe = {1500,1200,2,5};
	int[] sapo = {1200,1200,1,0};
	int[] sereia = {2000,2000,2,0};
	int[] tartaruga = {0,2000,1,4};
	int[] tubarao = {2500,2000,7,3};
	int[] dragaoM = {3000,2500,8,2};
	int[] jacare = {2000,2000,3,6};
	
	String[] compra = {"magia", "1"};
	String[] vida = {"magia", "2"};
	String[] destruicao = {"magia", "3"};
	String[] ataque = {"magia", "4"};
	String[] defesa = {"magia", "5"};
	String[] dano = {"magia", "6"};

	String[] equipamento = {"feitico", "1"};
	String[] campoF = {"feitico", "2"};
	String[] campoR = {"feitico", "3"};
	String[] campoA = {"feitico", "4"};
	
	public int[] getAtributosMonstro(String nomeMonstro) {
        switch (nomeMonstro) {
            case "lobo": return lobo;
            case "abelha": return abelha;
            case "aguia": return aguia;
            case "besouro": return besouro;
            case "cobra": return cobra;
            case "aranha": return aranha;
            case "enguia": return enguia;
            case "dragaoR": return dragaoR;
            case "tigre": return tigre;
            case "guerreiroA": return guerreiroA;
            case "gato": return gato;
            case "cobraF": return cobraF;
            case "coelho": return coelho;
            case "dragaoF": return dragaoF;
            case "fenix": return fenix;
            case "guerreiro": return guerreiro;
            case "leao": return leao;
            case "raposa": return raposa;
            case "tigreF": return tigreF;
            case "cavalo": return cavalo;
            case "cobraM": return cobraM;
            case "golfinho": return golfinho;
            case "peixeP": return peixeP;
            case "peixe": return peixe;
            case "sapo": return sapo;
            case "sereia": return sereia;
            case "tartaruga": return tartaruga;
            case "tubarao": return tubarao;
            case "dragaoM": return dragaoM;
            case "jacare": return jacare;

            default: return null;
        }
	}
	public String[] getEfeitoMagia(String nomeMagia) {
        switch (nomeMagia) {
            case "compra": return compra;
            case "vida": return vida;
            case "destruicao": return destruicao;
            case "ataque": return ataque;
            case "defesa": return defesa;
            case "dano": return dano;
            
            default: return null;
        }
    }

    public String[] getEfeitoFeitico(String nomeFeitico) {
        switch (nomeFeitico) {
            case "equipamento": return equipamento;
            case "campoF": return campoF;
            case "campoR": return campoR;
            case "campoA": return campoA;
            default: return null;
        }
    }

}
