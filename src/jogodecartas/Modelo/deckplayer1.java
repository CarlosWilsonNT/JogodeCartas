package jogodecartas.Modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jogodecartas.Conteiner;
import javax.swing.JButton;

public class deckplayer1 extends JPanel implements KeyListener {

    private Image fundo;
    private Image lobo;
    private Image abelha;
    private Image aguia;
    private Image aranha;
    private Image besouro;
    private Image cobraR;
    private Image enguia;
    private Image dragaoR;
    private Image tigreR;
    private Image guerreiroA;
    private Image gato;
    private Image cobraF;
    private Image coelho;
    private Image dragaoF;
    private Image fenix;
    private Image guerreiro;
    private Image leao;
    private Image raposa;
    private Image tigre;
    private Image cavalo;
    private Image cobraM;
    private Image golfinho;
    private Image peixeP;
    private Image peixe;
    private Image sapo;
    private Image sereia;
    private Image tartaruga;
    private Image tubarao;
    private Image dragaoM;
    private Image jacare;
    private Image compra;
    private Image cura;
    private Image destruir;
    private Image ataque;
    private Image defesa;
    private Image dano;
    private Image equipamento;
    private Image campoF;
    private Image campoR;
    private Image campoA;
    
    private Image setaB;
    
    private int x = 580;
    private int y = 55;
    
    private JButton Confirmar;
    private Image efeitos;

    private boolean mostrarEfeitos = false;
    private boolean deckcheio = false;
    
    private JButton botaoEfeitos;
    
    private final int coordX = 20;
    private final int coordY = 85;
    private final int coordY2 = 185;
    private final int coordY3 = 285;
    private final int coordY4 = 385;
    private final int coordY5 = 485;
    private final int coordY6 = 585;
    private final int multiplicacaoX = 98;
    
    private String[] deck1 = new String[30];
    
    public deckplayer1() {
    	
    	//setLayout(null);
    	
    	addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    	
        ImageIcon referencia = new ImageIcon("banco_i/deckjogador1.png");
        fundo = referencia.getImage();

        ImageIcon cartalobo = new ImageIcon("banco_i/lobo.png");
        lobo = cartalobo.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartaabelha = new ImageIcon("banco_i/abelha.png");
        abelha = cartaabelha.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartaaguia = new ImageIcon("banco_i/aguia.png");
        aguia = cartaaguia.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartaaranha = new ImageIcon("banco_i/aranha.png");
        aranha = cartaaranha.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartabesouro = new ImageIcon("banco_i/besouro.png");
        besouro = cartabesouro.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartacobraR = new ImageIcon("banco_i/cobra de raio.png");
        cobraR = cartacobraR.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartaenguia = new ImageIcon("banco_i/enguia.png");
        enguia = cartaenguia.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartadragaoR = new ImageIcon("banco_i/dragão relampago.png");
        dragaoR = cartadragaoR.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartatigreR = new ImageIcon("banco_i/tigre raio.png");
        tigreR = cartatigreR.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartaguerreiroA = new ImageIcon("banco_i/guerreiro alado.png");
        guerreiroA = cartaguerreiroA.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartagato = new ImageIcon("banco_i/gato.png");
        gato = cartagato.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartacobraF = new ImageIcon("banco_i/cobra de fogo.png");
        cobraF = cartacobraF.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartacoelho = new ImageIcon("banco_i/coelho.png");
        coelho = cartacoelho.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartadragaoF = new ImageIcon("banco_i/dragao de fogo.png");
        dragaoF = cartadragaoF.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartafenix = new ImageIcon("banco_i/fenix.png");
        fenix = cartafenix.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartaguerreiro = new ImageIcon("banco_i/guerreiro.png");
        guerreiro = cartaguerreiro.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartaleao = new ImageIcon("banco_i/leao.png");
        leao = cartaleao.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartaraposa = new ImageIcon("banco_i/raposa.png");
        raposa = cartaraposa.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartatigre = new ImageIcon("banco_i/tigre.png");
        tigre = cartatigre.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartacavalo = new ImageIcon("banco_i/cavalo.png");
        cavalo = cartacavalo.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartacobraM = new ImageIcon("banco_i/cobra marinha.png");
        cobraM = cartacobraM.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartagolfinho = new ImageIcon("banco_i/golfinho.png");
        golfinho = cartagolfinho.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartapeixeP = new ImageIcon("banco_i/peixe pequeno.png");
        peixeP = cartapeixeP.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartapeixe = new ImageIcon("banco_i/peixe.png");
        peixe = cartapeixe.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartasapo = new ImageIcon("banco_i/sapo.png");
        sapo = cartasapo.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartasereia = new ImageIcon("banco_i/sereia.png");
        sereia = cartasereia.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartatartaruga = new ImageIcon("banco_i/tartaruga.png");
        tartaruga = cartatartaruga.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartatubarao = new ImageIcon("banco_i/tubarao.png");
        tubarao = cartatubarao.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartadragaoM = new ImageIcon("banco_i/dragao.png");
        dragaoM = cartadragaoM.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartajacare = new ImageIcon("banco_i/jacare.png");
        jacare = cartajacare.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartacompra = new ImageIcon("banco_i/carta de magia compra.png");
        compra = cartacompra.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartacura = new ImageIcon("banco_i/carta de magia cura.png");
        cura = cartacura.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);

        ImageIcon cartadestruir = new ImageIcon("banco_i/carta de magia destruir.png");
        destruir = cartadestruir.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartaataque = new ImageIcon("banco_i/carta de magia aumentar ataque.png");
        ataque = cartaataque.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartadefesa = new ImageIcon("banco_i/carta de magia reduz defesa.png");
        defesa = cartadefesa.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartadano = new ImageIcon("banco_i/carta de magia bola de fogo.png");
        dano = cartadano.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartaequipamento = new ImageIcon("banco_i/equipamento.png");
        equipamento = cartaequipamento.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartacampoF = new ImageIcon("banco_i/campo de fogo.png");
        campoF = cartacampoF.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartacampoR = new ImageIcon("banco_i/campo de raios.png");
        campoR = cartacampoR.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartacampoA = new ImageIcon("banco_i/campo de agua.png");
        campoA = cartacampoA.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartasetaB = new ImageIcon("banco_i/setabaixo.png");
        setaB = cartasetaB.getImage();
        
        ImageIcon imagemEfeitos = new ImageIcon("banco_i/efeitos.png");
        efeitos = imagemEfeitos.getImage();

        Confirmar = new JButton("Confirmar");
        Confirmar.setBounds(490, 0, 100, 40);
        add(Confirmar);

        Confirmar.setVisible(false); 

        Confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conteiner parentFrame = (Conteiner) getTopLevelAncestor();
              //embaralharDeck(deck1);
                parentFrame.irPraraDeck2();
            }
        });
        
        botaoEfeitos = new JButton("Efeitos");
        botaoEfeitos.setBounds(0, 0, 100, 30);
        botaoEfeitos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarEfeitos = !mostrarEfeitos;
                repaint();
            }
        });
        
        setLayout(null);
        botaoEfeitos.setFocusable(false);
        add(botaoEfeitos);
    }
    
    public void verificarDeckCheio() {
        int contador = 0;
        for (String carta : deck1) {
            if (carta != null) {
                contador++;
            }
        }
        deckcheio = (contador >= 6);
    }
    
   //public void embaralharDeck(String[] deck) {
       // for (int i = deck.length - 1; i > 0; i--) {
          //  int j = (int) (Math.random() * (i + 1));
          //  String temp = deck[i];
           // deck[i] = deck[j];
         //   deck[j] = temp;
        //}
  //  }
    
//movimentação e adição a lista
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            y = Math.max(55, y - 100);
        }

        if (key == KeyEvent.VK_S) {
            y = Math.min(755, y + 100);
        }

        if (key == KeyEvent.VK_A) {
            x = Math.max(580, x - 100);
        }

        if (key == KeyEvent.VK_D) {
            x = Math.min(980, x + 100);
        }
        
        if (key == KeyEvent.VK_ENTER) {
            if (x == 580 && y == 55) {
                for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "lobo";
                        break;
                    }
                }
                printDeck();
            }
            else if (x == 680 && y == 55) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "abelha";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 780 && y == 55) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "aguia";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 880 && y == 55) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "aranha";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 980 && y == 55) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "besouro";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 580 && y == 155) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "cobra";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 680 && y == 155) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "enguia";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 780 && y == 155) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "dragao relampago";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 880 && y == 155) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "tigre";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 980 && y == 155) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "guerreiro alado";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 580 && y == 255) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "gato";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 680 && y == 255) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "cobra de fogo";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 780 && y == 255) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "coelho";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 880 && y == 255) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "dragao de fogo";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 980 && y == 255) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "fenix";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 580 && y == 355) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "guerreiro";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 680 && y == 355) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "leao";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 780 && y == 355) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "raposa";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 880 && y == 355) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "tigre de fogo";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 980 && y == 355) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "cavalo";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 580 && y == 455) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "cobra marinha";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 680 && y == 455) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "golfinho";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 780 && y == 455) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "peixe pequeno";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 880 && y == 455) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "peixe";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 980 && y == 455) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "sapo";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 580 && y == 555) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "sereia";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 680 && y == 555) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "tartaruga";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 780 && y == 555) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "tubarao";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 880 && y == 555) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "dragao marinho";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 980 && y == 555) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "jacare";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 580 && y == 655) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "compra";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 680 && y == 655) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "vida";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 780 && y == 655) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "destruicao";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 880 && y == 655) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "ataque";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 980 && y == 655) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "defesa";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 580 && y == 755) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "dano";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 680 && y == 755) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "equipamento";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 780 && y == 755) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "campoF";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 880 && y == 755) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "campoR";
                        break;
                    }
            	}
            	printDeck();
            }
            else if (x == 980 && y == 755) {
            	for (int i = 0; i < getDeck1().length; i++) {
                    if (getDeck1()[i] == null) {
                        getDeck1()[i] = "campoA";
                        break;
                    }
            	}
            	printDeck();
            }
        }

        repaint();
    }
    public void printDeck() {
        for (int i = 0; i < getDeck1().length; i++) {
            if (getDeck1()[i] != null) {
                System.out.println("Deck[" + i + "] = " + getDeck1()[i]);
                verificarDeckCheio();
                Confirmar.setVisible(deckcheio);
            }
        }

    }
    	@Override
        public void keyReleased(KeyEvent e) {
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, this);

        graficos.drawImage(lobo, 570, 85, this);
        graficos.drawImage(abelha, 670, 85, this);
        graficos.drawImage(aguia, 765, 85, this);
        graficos.drawImage(aranha, 863, 85, this);
        graficos.drawImage(besouro, 963, 85, this);
        
        graficos.drawImage(cobraR, 570, 185, this);
        graficos.drawImage(enguia, 670, 185, this);
        graficos.drawImage(dragaoR, 765, 185, this);
        graficos.drawImage(tigreR, 863, 185, this);
        graficos.drawImage(guerreiroA, 963, 185, this);
        
        graficos.drawImage(gato, 570, 285, this);
        graficos.drawImage(cobraF, 670, 285, this);
        graficos.drawImage(coelho, 765, 285, this);
        graficos.drawImage(dragaoF, 863, 285, this);
        graficos.drawImage(fenix, 963, 285, this);
        
        graficos.drawImage(guerreiro, 570, 385, this);
        graficos.drawImage(leao, 670, 385, this);
        graficos.drawImage(raposa, 765, 385, this);
        graficos.drawImage(tigre, 863, 385, this);
        graficos.drawImage(cavalo, 963, 385, this);
        
        graficos.drawImage(cobraM, 570, 485, this);
        graficos.drawImage(golfinho, 673, 485, this);
        graficos.drawImage(peixeP, 765, 485, this);
        graficos.drawImage(peixe, 863, 485, this);
        graficos.drawImage(sapo, 963, 485, this);
        
        graficos.drawImage(sereia, 570, 585, this);
        graficos.drawImage(tartaruga, 670, 585, this);
        graficos.drawImage(tubarao, 765, 585, this);
        graficos.drawImage(dragaoM, 863, 585, this);
        graficos.drawImage(jacare, 963, 585, this);
        
        graficos.drawImage(compra, 570, 685, this);
        graficos.drawImage(cura, 670, 685, this);
        graficos.drawImage(destruir, 765, 685, this);
        graficos.drawImage(ataque, 863, 685, this);
        graficos.drawImage(defesa, 963, 685, this);
        
        graficos.drawImage(dano, 570, 785, this);
        graficos.drawImage(equipamento, 670, 785, this);
        graficos.drawImage(campoF, 765, 785, this);
        graficos.drawImage(campoR, 863, 785, this);
        graficos.drawImage(campoA, 963, 785, this);

        graficos.drawImage(setaB, x, y, this);
        
        if (mostrarEfeitos) {
            graficos.drawImage(efeitos, 20, 30, this);
        }
    
        
        for (int i = 0; i < getDeck1().length; i++) {
            if (getDeck1()[i] != null) {
            	int posX = coordX + ((i % 5) * multiplicacaoX); 

                int posY;
                if (i < 5) {
                    posY = coordY;
                } else if (i < 10) {
                    posY = coordY2;
                } else if (i < 15) {
                    posY = coordY3;
                } else if (i < 20) {
                    posY = coordY4;
                } else if (i < 25) {
                    posY = coordY5;
                }else {
                    posY = coordY6;
                }

                if (getDeck1()[i].equals("lobo")) {
                    graficos.drawImage(lobo, posX, posY, this);
                } else if (getDeck1()[i].equals("abelha")) {
                    graficos.drawImage(abelha, posX, posY, this);
                }else if (getDeck1()[i].equals("aguia")) {
                    graficos.drawImage(aguia, posX, posY, this);
                }else if (getDeck1()[i].equals("aranha")) {
                    graficos.drawImage(aranha, posX, posY, this);
                }else if (getDeck1()[i].equals("besouro")) {
                    graficos.drawImage(besouro, posX, posY, this);
                }
                else if (getDeck1()[i].equals("cobra")) {
                    graficos.drawImage(cobraR, posX, posY, this);
                }else if (getDeck1()[i].equals("enguia")) {
                    graficos.drawImage(enguia, posX, posY, this);
                }else if (getDeck1()[i].equals("dragao relampago")) {
                    graficos.drawImage(dragaoR, posX, posY, this);
                }else if (getDeck1()[i].equals("tigre")) {
                    graficos.drawImage(tigreR, posX, posY, this);
                }else if (getDeck1()[i].equals("guerreiro alado")) {
                    graficos.drawImage(guerreiroA, posX, posY, this);
                }
                else if (getDeck1()[i].equals("gato")) {
                    graficos.drawImage(gato, posX, posY, this);
                }else if (getDeck1()[i].equals("cobra de fogo")) {
                    graficos.drawImage(cobraF, posX, posY, this);
                }else if (getDeck1()[i].equals("coelho")) {
                    graficos.drawImage(coelho, posX, posY, this);
                }else if (getDeck1()[i].equals("dragao de fogo")) {
                    graficos.drawImage(dragaoF, posX, posY, this);
                }else if (getDeck1()[i].equals("fenix")) {
                    graficos.drawImage(fenix, posX, posY, this);
                }
                else if (getDeck1()[i].equals("guerreiro")) {
                    graficos.drawImage(guerreiro, posX, posY, this);
                }else if (getDeck1()[i].equals("leao")) {
                    graficos.drawImage(leao, posX, posY, this);
                }else if (getDeck1()[i].equals("raposa")) {
                    graficos.drawImage(raposa, posX, posY, this);
                }else if (getDeck1()[i].equals("tigre de fogo")) {
                    graficos.drawImage(tigre, posX, posY, this);
                }else if (getDeck1()[i].equals("cavalo")) {
                    graficos.drawImage(cavalo, posX, posY, this);
                }
                else if (getDeck1()[i].equals("cobra marinha")) {
                    graficos.drawImage(cobraM, posX, posY, this);
                }else if (getDeck1()[i].equals("golfinho")) {
                    graficos.drawImage(golfinho, posX, posY, this);
                }else if (getDeck1()[i].equals("peixe pequeno")) {
                    graficos.drawImage(peixeP, posX, posY, this);
                }else if (getDeck1()[i].equals("peixe")) {
                    graficos.drawImage(peixe, posX, posY, this);
                }else if (getDeck1()[i].equals("sapo")) {
                    graficos.drawImage(sapo, posX, posY, this);
                }
                else if (getDeck1()[i].equals("sereia")) {
                    graficos.drawImage(sereia, posX, posY, this);
                }else if (getDeck1()[i].equals("tartaruga")) {
                    graficos.drawImage(tartaruga, posX, posY, this);
                }else if (getDeck1()[i].equals("tubarao")) {
                    graficos.drawImage(tubarao, posX, posY, this);
                }else if (getDeck1()[i].equals("dragao marinho")) {
                    graficos.drawImage(dragaoM, posX, posY, this);
                }else if (getDeck1()[i].equals("jacare")) {
                    graficos.drawImage(jacare, posX, posY, this);
                }
                else if (getDeck1()[i].equals("compra")) {
                    graficos.drawImage(compra, posX, posY, this);
                }else if (getDeck1()[i].equals("vida")) {
                    graficos.drawImage(cura, posX, posY, this);
                }else if (getDeck1()[i].equals("destruicao")) {
                    graficos.drawImage(destruir, posX, posY, this);
                }else if (getDeck1()[i].equals("ataque")) {
                    graficos.drawImage(ataque, posX, posY, this);
                }else if (getDeck1()[i].equals("defesa")) {
                    graficos.drawImage(defesa, posX, posY, this);
                }
                else if (getDeck1()[i].equals("dano")) {
                    graficos.drawImage(dano, posX, posY, this);
                }else if (getDeck1()[i].equals("equipamento")) {
                    graficos.drawImage(equipamento, posX, posY, this);
                }else if (getDeck1()[i].equals("campoF")) {
                    graficos.drawImage(campoF, posX, posY, this);
                }else if (getDeck1()[i].equals("campoR")) {
                    graficos.drawImage(campoR, posX, posY, this);
                }else if (getDeck1()[i].equals("campoA")) {
                    graficos.drawImage(campoA, posX, posY, this);
                }
            }
        }
    
        
    }
    
    @Override
    public java.awt.Dimension getPreferredSize() {
        return new java.awt.Dimension(1060, 890);
    }

	public String[] getDeck1() {
		return deck1;
	}

	public void setDeck1(String[] deck1) {
		this.deck1 = deck1;
	}
    
}