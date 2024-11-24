package jogodecartas.Modelo;

import javax.swing.ImageIcon;
import java.awt.Image;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Imagens {

	public static Image lobo, abelha, aguia, aranha, besouro, cobraR, enguia, dragaoR, tigreR, guerreiroA;
	public static Image gato, cobraF, coelho, dragaoF, fenix, guerreiro, leao, raposa, tigre, cavalo;
	public static Image cobraM, golfinho, peixeP, peixe, sapo, sereia, tartaruga, tubarao, dragaoM, jacare;
	public static Image compra, cura, destruir, ataque, defesa, dano, equipamento, campoF, campoR, campoA;

	public static void carregarImagens() {

        lobo = new ImageIcon("banco_i/lobo.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        abelha = new ImageIcon("banco_i/abelha.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        aguia = new ImageIcon("banco_i/aguia.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        aranha = new ImageIcon("banco_i/aranha.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        besouro = new ImageIcon("banco_i/besouro.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        cobraR = new ImageIcon("banco_i/cobra de raio.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        enguia = new ImageIcon("banco_i/enguia.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        dragaoR = new ImageIcon("banco_i/dragão relampago.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        tigreR = new ImageIcon("banco_i/tigre raio.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        guerreiroA = new ImageIcon("banco_i/guerreiro alado.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);

        gato = new ImageIcon("banco_i/gato.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        cobraF = new ImageIcon("banco_i/cobra de fogo.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        coelho = new ImageIcon("banco_i/coelho.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        dragaoF = new ImageIcon("banco_i/dragao de fogo.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        fenix = new ImageIcon("banco_i/fenix.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        guerreiro = new ImageIcon("banco_i/guerreiro.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        leao = new ImageIcon("banco_i/leao.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        raposa = new ImageIcon("banco_i/raposa.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        tigre = new ImageIcon("banco_i/tigre.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        cavalo = new ImageIcon("banco_i/cavalo.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);

        cobraM = new ImageIcon("banco_i/cobra marinha.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        golfinho = new ImageIcon("banco_i/golfinho.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        peixeP = new ImageIcon("banco_i/peixe pequeno.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        peixe = new ImageIcon("banco_i/peixe.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        sapo = new ImageIcon("banco_i/sapo.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        sereia = new ImageIcon("banco_i/sereia.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        tartaruga = new ImageIcon("banco_i/tartaruga.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        tubarao = new ImageIcon("banco_i/tubarao.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        dragaoM = new ImageIcon("banco_i/dragao.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        jacare = new ImageIcon("banco_i/jacare.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);

        compra = new ImageIcon("banco_i/carta de magia compra.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        cura = new ImageIcon("banco_i/carta de magia cura.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        destruir = new ImageIcon("banco_i/carta de magia destruir.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        ataque = new ImageIcon("banco_i/carta de magia aumentar ataque.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        defesa = new ImageIcon("banco_i/carta de magia reduz defesa.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        dano = new ImageIcon("banco_i/carta de magia bola de fogo.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        equipamento = new ImageIcon("banco_i/equipamento.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        campoF = new ImageIcon("banco_i/campo de fogo.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        campoR = new ImageIcon("banco_i/campo de raios.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        campoA = new ImageIcon("banco_i/campo de agua.png").getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
    }

    private Image carregarImagem(String caminho) {
        ImageIcon icone = new ImageIcon(caminho);
        return icone.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
    }
}
