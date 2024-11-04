package jogodecartas.Modelo;

import java.awt.Image;

class ImagemPosicao {
    private Image imagem;
    private int posX;
    private int posY;

    public ImagemPosicao(Image imagem, int posX, int posY) {
        this.imagem = imagem;
        this.posX = posX;
        this.posY = posY;
    }

    public Image getImagem() {
        return imagem;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}