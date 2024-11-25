package jogodecartas.Modelo;

public class status {
	//ataque,defesa,nivel,efeito,tipo
	int[] lobo = {2500, 2000, 5, 5,1};
	int[] abelha = {1000, 1000, 1,7,1};
	int[] aguia = {2000,1500, 4,4,1};
	int[] aranha = {1500,1200, 2,5,1};
	int[] besouro = {1200, 1200, 1,0,1};
	int[] cobra = {2000,1000, 3,1,1};
	int[] enguia = {2000,1500,4,6,1};
	int[] dragaoR = {3000,2500,8,2,1};
	int[] tigre = {2500,2000,7,3,1};
	int[] guerreiroA = {2000,2000,2,0,1};
	int[] gato = {1200,1200,1,0,2};
	int[] cobraF = {2000,1000,3,1,2};
	int[] coelho = {1000,1000,1,7,2};
	int[] dragaoF = {3000,2500,8,2,2};
	int[] fenix = {2000,1500,5,6,2};
	int[] guerreiro = {2000,2000,2,0,2};
	int[] leao = {2500,2000,7,3,2};
	int[] raposa = {1500,1200,2,4,2};
	int[] tigreF = {2500,2000,7,3,2};
	int[] cavalo = {1500,1500,3,5,2};
	int[] cobraM = {2000,1000,3,1,3};
	int[] golfinho = {2500,2000,6,3,3};
	int[] peixeP = {1000,1000,1,7,3};
	int[] peixe = {1500,1200,2,5,3};
	int[] sapo = {1200,1200,1,0,3};
	int[] sereia = {2000,2000,2,0,3};
	int[] tartaruga = {0,2000,1,4,3};
	int[] tubarao = {2500,2000,7,3,3};
	int[] dragaoM = {3000,2500,8,2,3};
	int[] jacare = {2000,2000,3,6,3};
	int[] nulo = {0,0,0,10,0};
	
	String[] compra = {"magia", "1", "3"};
	String[] vida = {"magia", "2", "3"};
	String[] dano = {"magia", "3","3"};
	String[] destruicao = {"magia", "4", "8"};
	String[] ataque = {"magia", "5","2"};
	String[] defesa = {"magia", "6","2"};
	

	String[] equipamento = {"feitico", "1","3"};
	String[] campoF = {"feitico", "2","2"};
	String[] campoR = {"feitico", "3","2"};
	String[] campoA = {"feitico", "4","2"};
	
	public int[] getAtributosMonstro(String nomeMonstro) {
        switch (nomeMonstro) {
            case "lobo": return lobo;
            case "abelha": return abelha;
            case "aguia": return aguia;
            case "besouro": return besouro;
            case "cobra": return cobra;
            case "aranha": return aranha;
            case "enguia": return enguia;
            case "dragao relampago": return dragaoR;
            case "tigre": return tigre;
            case "guerreiro alado": return guerreiroA;
            case "gato": return gato;
            case "cobra de fogo": return cobraF;
            case "coelho": return coelho;
            case "dragao de fogo": return dragaoF;
            case "fenix": return fenix;
            case "guerreiro": return guerreiro;
            case "leao": return leao;
            case "raposa": return raposa;
            case "tigre de fogo": return tigreF;
            case "cavalo": return cavalo;
            case "cobra marinha": return cobraM;
            case "golfinho": return golfinho;
            case "peixe pequeno": return peixeP;
            case "peixe": return peixe;
            case "sapo": return sapo;
            case "sereia": return sereia;
            case "tartaruga": return tartaruga;
            case "tubarao": return tubarao;
            case "dragao marinho": return dragaoM;
            case "jacare": return jacare;
            case "nulo": return nulo;

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