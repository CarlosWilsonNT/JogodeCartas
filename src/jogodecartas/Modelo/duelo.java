package jogodecartas.Modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;


public class duelo extends JPanel implements KeyListener {

    private Image fundo;
    private Image deck;
    private Image deckmeio;
    private Image cristal;
    
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
    private Image setaC;
    
    private Image tela;
    
    private String[] deck1;
    private String[] deck2;
    
    private String[] monstros = new String[3];
    private String[] magiasefeiticos= new String[3];
    
    private String[] monstros2 = new String[3];
    private String[] magiasefeiticos2 = new String[3];
    
    private String[] maojogador1 = new String[8];
    private String[] maojogador2 = new String[8];
    
    private String[] cemiterio1 = new String[8];
    private String[] cemiterio2 = new String[8];
    
    private status status = new status();
    
    private Image efeitos;

    private boolean mostrarEfeitos = false;
    
    private JButton botaoEfeitos;
    
    private JButton botaoCompra;
    private JButton botaoBatalha;
    private JButton botaoFim;
    
    private int x = 222;
    private int y = 550;
    
    private int x2 = 222;
    private int y2 = 100;
    
    private int turno = 1;
    
    int cartasExibidas = 5;
    int cartasExibidas2 = 5;
    
    int monstro = 0;
    int magia = 0;
    
    int monstro2 = 0;
    int magia2 = 0;
    
    int xDeck = 200, yDeck = 585;
    int xMonstros = 392, yMonstros = 360;
    int cartasExibidasDeck = 5;
    
    int pontosVidaJogador1 = 8000;
    int pontosVidaJogador2 = 8000;
    
    private boolean faseBatalha = false;
    private String monstroSelecionadoAtacante = null;
    private String monstroSelecionadoAlvo = null;
    private boolean selecionandoAtacante = true;
    
    public duelo(String[] deck1, String[] deck2) {
    	
    	this.deck1 = deck1;
        this.deck2 = deck2;
        
        for (int i = 0; i < 5; i++) {
            maojogador1[i] = deck1[i];
            maojogador2[i] = deck2[i];
        }
        for (int i = 5; i < deck1.length; i++) {
            deck1[i - 5] = deck1[i];
        }
        for (int i = deck1.length - 5; i < deck1.length; i++) {
            deck1[i] = null;
        }

        for (int i = 5; i < deck2.length; i++) {
            deck2[i - 5] = deck2[i];
        }
        for (int i = deck2.length - 5; i < deck2.length; i++) {
            deck2[i] = null;
        }
    	
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        ImageIcon referencia = new ImageIcon("banco_i/campo.png");
        fundo = referencia.getImage();

        ImageIcon cartadeck = new ImageIcon("banco_i/deck.png");
        deck = cartadeck.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);

        ImageIcon cartadeckmeio = new ImageIcon("banco_i/deckmeio.png");
        deckmeio = cartadeckmeio.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        
        ImageIcon imagecristal = new ImageIcon("banco_i/cristal.png");
        cristal = imagecristal.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        
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
        
        ImageIcon cartaataque = new ImageIcon("banco_i/carta de magia reduz ataque.png");
        ataque = cartaataque.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartadefesa = new ImageIcon("banco_i/carta de magia reduz defesa.png");
        defesa = cartadefesa.getImage().getScaledInstance(90, 95, Image.SCALE_SMOOTH);
        
        ImageIcon cartadano= new ImageIcon("banco_i/carta de magia bola de fogo.png");
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
        
        ImageIcon cartasetaC = new ImageIcon("banco_i/setacima.png");
        setaC = cartasetaC.getImage();
        
        ImageIcon imagemEfeitos = new ImageIcon("banco_i/efeitos.png");
        efeitos = imagemEfeitos.getImage();
        
        ImageIcon imagemtela = new ImageIcon("banco_i/tela.png");
        tela = imagemtela.getImage().getScaledInstance(800, 95, Image.SCALE_SMOOTH);
        
        botaoEfeitos = new JButton("Efeitos");
        botaoEfeitos.setBounds(960, 0, 100, 30);
        botaoEfeitos.setFocusable(false);
        botaoEfeitos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarEfeitos = !mostrarEfeitos;
                repaint();
                requestFocusInWindow();
            }
        });
        add(botaoEfeitos);

        botaoCompra = new JButton("Comprar Carta");
        botaoCompra.setBounds(920, 250, 150, 30);
        botaoCompra.setFocusable(false);
        botaoCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (turno >= 2) {
                	transferirPrimeiroTermo();
                }
                botaoBatalha.setVisible(true);
                botaoFim.setVisible(true);
                botaoCompra.setVisible(false);
                repaint();
                requestFocusInWindow();
            }
        });
        add(botaoCompra);

        botaoBatalha = new JButton("Fase de Batalha");
        botaoBatalha.setBounds(920, 300, 150, 30);
        botaoBatalha.setFocusable(false);
        botaoBatalha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	faseBatalha = true;
            	botaoBatalha.setVisible(false);
                repaint();
                requestFocusInWindow();
            }
        });
        botaoBatalha.setVisible(false);
        add(botaoBatalha);

        botaoFim = new JButton("Passar o Turno");
        botaoFim.setBounds(920, 350, 150, 30);
        botaoFim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	turno++;
            	faseBatalha = false;
            	botaoBatalha.setVisible(false);
                botaoFim.setVisible(false);
                botaoCompra.setVisible(true);
                repaint();
            }
        });
        botaoFim.setVisible(false);
        botaoFim.setFocusable(false);
        resetarSelecoes();
        add(botaoFim);

        setLayout(null);
    }
    
    private void moverTermoPorContador(int contador) {
        int indice = contador - 1;
        if (turno % 2 != 0) {
        if (indice >= 0 && indice < maojogador1.length && maojogador1[indice] != null) {
            String carta = maojogador1[indice];
            processarCarta(carta, maojogador1, indice, monstros, magiasefeiticos, cemiterio1);
        }
        }
        if (turno % 2 == 0) {
        if (indice >= 0 && indice < maojogador2.length && maojogador2[indice] != null) {
            String carta = maojogador2[indice];
            processarCarta(carta, maojogador2, indice, monstros2, magiasefeiticos2, cemiterio2);
        }
        }
    }
    
    private void processarCarta(String carta, String[] mao, int indice, String[] listaMonstros, String[] listaMagiasFeiticos, String[] listaCemiterio) {
        if (status.getAtributosMonstro(carta) != null) {
            if (temEspacoNaLista(listaMonstros)) {
                adicionarNaLista(listaMonstros, carta);
                moverCartasParaEsquerda(mao, indice);
            }
        } 
        else if (status.getEfeitoMagia(carta) != null) {
            int valorMagia = Integer.parseInt(status.getEfeitoMagia(carta)[1]);
            	efeitoMagia(valorMagia);
            if (temEspacoNaLista(listaMagiasFeiticos)) {
                adicionarNaLista(listaMagiasFeiticos, carta);
                moverCartasParaEsquerda(mao, indice);
                moverParaCemiterio(carta, listaMagiasFeiticos, listaCemiterio);
            }
        } 
        else if (status.getEfeitoFeitico(carta) != null) {
            int valorFeitico = Integer.parseInt(status.getEfeitoFeitico(carta)[1]);
            efeitoFeitico(valorFeitico);
            if (temEspacoNaLista(listaMagiasFeiticos)) {
                adicionarNaLista(listaMagiasFeiticos, carta);
                moverCartasParaEsquerda(mao, indice);
            }
        }
    }

    private void moverParaCemiterio(String carta, String[] listaMagiasFeiticos, String[] listaCemiterio) {
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            removerDaLista(listaMagiasFeiticos, carta);
            adicionarNaLista(listaCemiterio, carta);
        }).start();
    }
    
    private void removerDaLista(String[] lista, String carta) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].equals(carta)) {
                lista[i] = null;
                break;
            }
        }
        moverCartasParaEsquerda(lista, 0);
    }

    private void efeitoMagia(int valor) {
        switch (valor) {
            case 1:
            	transferirPrimeiroTermo();
            	transferirPrimeiroTermo();
                break;
            case 2:
            	if (turno % 2 != 0) {
            	pontosVidaJogador1 += 500;
            	}
            	if (turno % 2 == 0) {
            	pontosVidaJogador2 += 500;
            	}
                break;
            case 3:
            	if (turno % 2 != 0) {
            	pontosVidaJogador1 -= 300;
            	}
            	if (turno % 2 == 0) {
            	pontosVidaJogador2 -= 300;
            	}
                break;

        }
    }

    private void efeitoFeitico(int valor) {
        switch (valor) {
            case 1:
            	System.out.println("efeito1");
                break;
            case 2:
            	System.out.println("efeito2");
                break;

        }
    }
    private void moverCartasParaEsquerda(String[] mao, int indiceInicial) {
        for (int i = indiceInicial; i < mao.length - 1; i++) {
            mao[i] = mao[i + 1];
        }
        mao[mao.length - 1] = null;
    }
    private boolean temEspacoNaLista(String[] lista) {
        for (String item : lista) {
            if (item == null) {
                return true;
            }
        }
        return false;
    }
    private void adicionarNaLista(String[] lista, String carta) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == null) {
                lista[i] = carta;
                break;
            }
        }
    }

    private void transferirPrimeiroTermo() {
        if (deck1[0] != null) {
            adicionarNaMao(maojogador1, deck1[0]);
            for (int i = 1; i < deck1.length; i++) {
                deck1[i - 1] = deck1[i];
            }
            deck1[deck1.length - 1] = null;
        }
        if (deck2[0] != null) {
            adicionarNaMao(maojogador2, deck2[0]);
            for (int i = 1; i < deck2.length; i++) {
                deck2[i - 1] = deck2[i];
            }
            deck2[deck2.length - 1] = null;
        }
    }
    private void adicionarNaMao(String[] mao, String carta) {
        for (int i = 0; i < mao.length; i++) {
            if (mao[i] == null) {
                mao[i] = carta;
                break;
            }
        }
    }

    public void realizarCombate() {
    	if (turno % 2 != 0) {
        if (monstroSelecionadoAtacante != null && monstroSelecionadoAlvo != null) {
            int[] atributosAtacante = status.getAtributosMonstro(monstroSelecionadoAtacante);
            int[] atributosAlvo = status.getAtributosMonstro(monstroSelecionadoAlvo);

            if (atributosAtacante != null && atributosAlvo != null) {
                int ataqueAtacante = atributosAtacante[0];
                int defesaAlvo = atributosAlvo[1];

                int dano = ataqueAtacante - defesaAlvo;

                if (dano > 0) {
                    pontosVidaJogador1 -= dano;
                    System.out.println("O monstro alvo sofreu " + dano + " de dano! Pontos de vida restantes do jogador 2: " + pontosVidaJogador2);
                    removerDaLista(monstros2, monstroSelecionadoAlvo);
                    adicionarNaLista(cemiterio2, monstroSelecionadoAlvo);
                    resetarSelecoes();
                } if (dano < 0) {
                    pontosVidaJogador2 += dano;
                    System.out.println("O monstro alvo tinha mais poder" + dano + " Pontos de vida restantes do jogador 1: " + pontosVidaJogador1);
                    resetarSelecoes();
                }
            } else {
                System.out.println("Erro ao obter atributos de um ou ambos os monstros selecionados.");
            }
        } 
    }
    	if (turno % 2 == 0) {
            if (monstroSelecionadoAtacante != null && monstroSelecionadoAlvo != null) {
                int[] atributosAtacante = status.getAtributosMonstro(monstroSelecionadoAtacante);
                int[] atributosAlvo = status.getAtributosMonstro(monstroSelecionadoAlvo);

                if (atributosAtacante != null && atributosAlvo != null) {
                    int ataqueAtacante = atributosAtacante[0];
                    int defesaAlvo = atributosAlvo[1];

                    int dano = ataqueAtacante - defesaAlvo;

                    if (dano > 0) {
                        pontosVidaJogador2 -= dano;
                        System.out.println("O monstro alvo sofreu " + dano + " de dano! Pontos de vida restantes do jogador 1: " + pontosVidaJogador1);
                        removerDaLista(monstros, monstroSelecionadoAlvo);
                        adicionarNaLista(cemiterio1, monstroSelecionadoAlvo);
                        resetarSelecoes();
                    } if (dano < 0) {
                        pontosVidaJogador1 += dano;
                        System.out.println("O monstro alvo tinha mais poder" + dano + " Pontos de vida restantes do jogador 2: " + pontosVidaJogador2);
                        resetarSelecoes();
                    }
                } else {
                    System.out.println("Erro ao obter atributos de um ou ambos os monstros selecionados.");
                }
            } 
        }
    }

    private void resetarSelecoes() {
        monstroSelecionadoAtacante = null;
        monstroSelecionadoAlvo = null;
        selecionandoAtacante = true;
        System.out.println("Seleção de monstros reiniciada para nova batalha.");
    }
    
    
    @Override
    public void addNotify() {
        super.addNotify();
        requestFocusInWindow();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graficos = (Graphics2D) g;
        
        graficos.drawImage(fundo, 0, 0, this);
        graficos.drawImage(deck, 695, 470, this);
        graficos.drawImage(deck, 290, 120, this);

        graficos.setColor(Color.RED);
        graficos.setFont(new Font("Arial", Font.BOLD, 48));

        graficos.drawString(String.valueOf(pontosVidaJogador1), 0, 140);
        graficos.drawString(String.valueOf(pontosVidaJogador2), 950, 580);
        graficos.drawString(String.valueOf(contador), 0, 50);
        if(faseBatalha) {
        g.drawString("Fase de Batalha", 400, 50);
        }
        if(!faseBatalha) {
            g.drawString("Fase Principal", 400, 50);
            }
        if (turno % 2 != 0) {
        	graficos.drawImage(setaB, x, y, this);
        	if(turno >= 1) {
        		graficos.drawImage(cristal, 340, 370, this);
            }
            if(turno >= 3) {
            	graficos.drawImage(cristal, 310, 370, this);
            }
            if(turno >= 5) {
            	graficos.drawImage(cristal, 340, 410, this);
            }
            if(turno >= 7) {
            	graficos.drawImage(cristal, 310, 410, this);
            }
            if(turno >= 9) {
            	graficos.drawImage(cristal, 340, 450, this);
            }
            if(turno >= 11) {
            	graficos.drawImage(cristal, 310, 450, this);
            }
            if(turno >= 13) {
            	graficos.drawImage(cristal, 340, 490, this);
            }
            if(turno >= 15) {
            	graficos.drawImage(cristal, 310, 490, this);
            }
            if(turno >= 17) {
            	graficos.drawImage(cristal, 340, 530, this);
            }
            if(turno >= 19) {
            	graficos.drawImage(cristal, 310, 530, this);
            }
            
        } if (turno % 2 == 0) {
        	graficos.drawImage(setaC, x2, y2, this);
        	if(turno >= 1) {
        		graficos.drawImage(cristal, 680, 120, this);
            }
            if(turno >= 2) {
            	graficos.drawImage(cristal, 710, 120, this);
            }
            if(turno >= 4) {
            	graficos.drawImage(cristal, 680, 160, this);
            }
            if(turno >= 6) {
            	graficos.drawImage(cristal, 710, 160, this);
            }
            if(turno >= 8) {
            	graficos.drawImage(cristal, 680, 200, this);
            }
            if(turno >= 10) {
            	graficos.drawImage(cristal, 710, 200, this);
            }
            if(turno >= 12) {
            	graficos.drawImage(cristal, 680, 240, this);
            }
            if(turno >= 14) {
            	graficos.drawImage(cristal, 710, 240, this);
            }
            if(turno >= 16) {
            	graficos.drawImage(cristal, 680, 280, this);
            }
            if(turno >= 18) {
            	graficos.drawImage(cristal, 710, 280, this);
            }
            
        }
        
        int x = 200, y = 585;
        
        for (int i = 0; i < maojogador1.length; i++) {
            String carta = maojogador1[i];
            if (carta != null) {
                switch (carta) {
                    case "lobo":
                        graficos.drawImage(lobo, x, y, this);
                        break;
                    case "abelha":
                        graficos.drawImage(abelha, x, y, this);
                        break;                        
                    case "aguia":
                        graficos.drawImage(aguia, x, y, this);
                        break;
                    case "aranha":
                        graficos.drawImage(aranha, x, y, this);
                        break;
                    case "besouro":
                        graficos.drawImage(besouro, x, y, this);
                        break;
                    case "cobra":
                        graficos.drawImage(cobraR, x, y, this);
                        break;
                    case "enguia":
                        graficos.drawImage(enguia, x, y, this);
                        break;
                    case "dragao relampago":
                        graficos.drawImage(dragaoR, x, y, this);
                        break;
                    case "tigre":
                        graficos.drawImage(tigreR, x, y, this);
                        break;
                    case "guerreiro alado":
                        graficos.drawImage(guerreiroA, x, y, this);
                        break;
                    case "gato":
                        graficos.drawImage(gato, x, y, this);
                        break;
                    case "cobra de fogo":
                        graficos.drawImage(cobraF, x, y, this);
                        break;
                    case "coelho":
                        graficos.drawImage(coelho, x, y, this);
                        break;
                    case "dragao de fogo":
                        graficos.drawImage(dragaoF, x, y, this);
                        break;
                    case "fenix":
                        graficos.drawImage(fenix, x, y, this);
                        break;
                    case "guerreiro":
                        graficos.drawImage(guerreiro, x, y, this);
                        break;
                    case "leao":
                        graficos.drawImage(leao, x, y, this);
                        break;
                    case "raposa":
                        graficos.drawImage(raposa, x, y, this);
                        break;
                    case "tigre de fogo":
                        graficos.drawImage(tigre, x, y, this);
                        break;
                    case "cavalo":
                        graficos.drawImage(cavalo, x, y, this);
                        break;
                    case "cobra marinha":
                        graficos.drawImage(cobraM, x, y, this);
                        break;
                    case "golfinho":
                        graficos.drawImage(golfinho, x, y, this);
                        break;
                    case "peixe pequeno":
                        graficos.drawImage(peixeP, x, y, this);
                        break;
                    case "peixe":
                        graficos.drawImage(peixe, x, y, this);
                        break;
                    case "sapo":
                        graficos.drawImage(sapo, x, y, this);
                        break;
                    case "sereia":
                        graficos.drawImage(sereia, x, y, this);
                        break;
                    case "tartaruga":
                        graficos.drawImage(tartaruga, x, y, this);
                        break;
                    case "tubarao":
                        graficos.drawImage(tubarao, x, y, this);
                        break;
                    case "dragao marinho":
                        graficos.drawImage(dragaoM, x, y, this);
                        break;
                    case "jacare":
                        graficos.drawImage(jacare, x, y, this);
                        break;
                    case "compra":
                        graficos.drawImage(compra, x, y, this);
                        break;
                    case "vida":
                        graficos.drawImage(cura, x, y, this);
                        break;
                    case "destruicao":
                        graficos.drawImage(destruir, x, y, this);
                        break;
                    case "ataque":
                        graficos.drawImage(ataque, x, y, this);
                        break;
                    case "defesa":
                        graficos.drawImage(defesa, x, y, this);
                        break;
                    case "dano":
                        graficos.drawImage(dano, x, y, this);
                        break;
                    case "equipamento":
                        graficos.drawImage(equipamento, x, y, this);
                        break;
                    case "campoF":
                        graficos.drawImage(campoF, x, y, this);
                        break;
                    case "campoR":
                        graficos.drawImage(campoR, x, y, this);
                        break;   
                    case "campoA":
                        graficos.drawImage(campoA, x, y, this);
                        break;                       
                        
                }
                x += 100;
            }
        }

        x = 200;
        y = 0;

        for (int i = 0; i < maojogador2.length; i++) {
            String carta = maojogador2[i];
            if (carta != null) {
                switch (carta) {
                    case "lobo":
                        graficos.drawImage(lobo, x, y, this);
                        break;
                    case "abelha":
                        graficos.drawImage(abelha, x, y, this);
                        break;
                    case "aguia":
                        graficos.drawImage(aguia, x, y, this);
                        break;
                    case "aranha":
                        graficos.drawImage(aranha, x, y, this);
                        break;
                    case "besouro":
                        graficos.drawImage(besouro, x, y, this);
                        break;
                    case "cobra":
                        graficos.drawImage(cobraR, x, y, this);
                        break;
                    case "enguia":
                        graficos.drawImage(enguia, x, y, this);
                        break;
                    case "dragao relampago":
                        graficos.drawImage(dragaoR, x, y, this);
                        break;
                    case "tigre":
                        graficos.drawImage(tigreR, x, y, this);
                        break;
                    case "guerreiro alado":
                        graficos.drawImage(guerreiroA, x, y, this);
                        break;
                    case "gato":
                        graficos.drawImage(gato, x, y, this);
                        break;
                    case "cobra de fogo":
                        graficos.drawImage(cobraF, x, y, this);
                        break;
                    case "coelho":
                        graficos.drawImage(coelho, x, y, this);
                        break;
                    case "dragao de fogo":
                        graficos.drawImage(dragaoF, x, y, this);
                        break;
                    case "fenix":
                        graficos.drawImage(fenix, x, y, this);
                        break;
                    case "guerreiro":
                        graficos.drawImage(guerreiro, x, y, this);
                        break;
                    case "leao":
                        graficos.drawImage(leao, x, y, this);
                        break;
                    case "raposa":
                        graficos.drawImage(raposa, x, y, this);
                        break;
                    case "tigre de fogo":
                        graficos.drawImage(tigre, x, y, this);
                        break;
                    case "cavalo":
                        graficos.drawImage(cavalo, x, y, this);
                        break;
                    case "cobra marinha":
                        graficos.drawImage(cobraM, x, y, this);
                        break;
                    case "golfinho":
                        graficos.drawImage(golfinho, x, y, this);
                        break;
                    case "peixe pequeno":
                        graficos.drawImage(peixeP, x, y, this);
                        break;
                    case "peixe":
                        graficos.drawImage(peixe, x, y, this);
                        break;
                    case "sapo":
                        graficos.drawImage(sapo, x, y, this);
                        break;
                    case "sereia":
                        graficos.drawImage(sereia, x, y, this);
                        break;
                    case "tartaruga":
                        graficos.drawImage(tartaruga, x, y, this);
                        break;
                    case "tubarao":
                        graficos.drawImage(tubarao, x, y, this);
                        break;
                    case "dragao marinho":
                        graficos.drawImage(dragaoM, x, y, this);
                        break;
                    case "jacare":
                        graficos.drawImage(jacare, x, y, this);
                        break;
                    case "compra":
                        graficos.drawImage(compra, x, y, this);
                        break;
                    case "vida":
                        graficos.drawImage(cura, x, y, this);
                        break;
                    case "destruicao":
                        graficos.drawImage(destruir, x, y, this);
                        break;
                    case "ataque":
                        graficos.drawImage(ataque, x, y, this);
                        break;
                    case "defesa":
                        graficos.drawImage(defesa, x, y, this);
                        break;
                    case "dano":
                        graficos.drawImage(dano, x, y, this);
                        break;
                    case "equipamento":
                        graficos.drawImage(equipamento, x, y, this);
                        break;
                    case "campoF":
                        graficos.drawImage(campoF, x, y, this);
                        break;
                    case "campoR":
                        graficos.drawImage(campoR, x, y, this);
                        break;   
                    case "campoA":
                        graficos.drawImage(campoA, x, y, this);
                        break;
                }
                x += 100;
            }
            
            //System.out.println(Arrays.toString(monstros));
            //System.out.println(Arrays.toString(magiasefeiticos));
            //System.out.println(Arrays.toString(monstros2));
            //System.out.println(Arrays.toString(magiasefeiticos2));

            int xMonstros = 392, yMonstros = 360;

            for (int iMonstro = 0; iMonstro < monstros.length; iMonstro++) {
                String cartaMonstro = monstros[iMonstro];
                if (cartaMonstro != null) {
                    switch (cartaMonstro) {
                        case "lobo":
                            graficos.drawImage(lobo, xMonstros, yMonstros, this);
                            break;
                        case "abelha":
                            graficos.drawImage(abelha, xMonstros, yMonstros, this);
                            break;
                        case "aguia":
                            graficos.drawImage(aguia, xMonstros, yMonstros, this);
                            break;
                        case "aranha":
                            graficos.drawImage(aranha, xMonstros, yMonstros, this);
                            break;
                        case "besouro":
                            graficos.drawImage(besouro, xMonstros, yMonstros, this);
                            break;
                        case "cobra":
                            graficos.drawImage(cobraR, xMonstros, yMonstros, this);
                            break;
                        case "enguia":
                            graficos.drawImage(enguia, xMonstros, yMonstros, this);
                            break;
                        case "dragao relampago":
                            graficos.drawImage(dragaoR, xMonstros, yMonstros, this);
                            break;
                        case "tigre":
                            graficos.drawImage(tigreR, xMonstros, yMonstros, this);
                            break;
                        case "guerreiro alado":
                            graficos.drawImage(guerreiroA, xMonstros, yMonstros, this);
                            break;
                        case "gato":
                            graficos.drawImage(gato, xMonstros, yMonstros, this);
                            break;
                        case "cobra de fogo":
                            graficos.drawImage(cobraF, xMonstros, yMonstros, this);
                            break;
                        case "coelho":
                            graficos.drawImage(coelho, xMonstros, yMonstros, this);
                            break;
                        case "dragao de fogo":
                            graficos.drawImage(dragaoF, xMonstros, yMonstros, this);
                            break;
                        case "fenix":
                            graficos.drawImage(fenix, xMonstros, yMonstros, this);
                            break;
                        case "guerreiro":
                            graficos.drawImage(guerreiro, xMonstros, yMonstros, this);
                            break;
                        case "leao":
                            graficos.drawImage(leao, xMonstros, yMonstros, this);
                            break;
                        case "raposa":
                            graficos.drawImage(raposa, xMonstros, yMonstros, this);
                            break;
                        case "tigre de fogo":
                            graficos.drawImage(tigre, xMonstros, yMonstros, this);
                            break;
                        case "cavalo":
                            graficos.drawImage(cavalo, xMonstros, yMonstros, this);
                            break;
                        case "cobra marinha":
                            graficos.drawImage(cobraM, xMonstros, yMonstros, this);
                            break;
                        case "golfinho":
                            graficos.drawImage(golfinho, xMonstros, yMonstros, this);
                            break;
                        case "peixe pequeno":
                            graficos.drawImage(peixeP, xMonstros, yMonstros, this);
                            break;
                        case "peixe":
                            graficos.drawImage(peixe, xMonstros, yMonstros, this);
                            break;
                        case "sapo":
                            graficos.drawImage(sapo, xMonstros, yMonstros, this);
                            break;
                        case "sereia":
                            graficos.drawImage(sereia, xMonstros, yMonstros, this);
                            break;
                        case "tartaruga":
                            graficos.drawImage(tartaruga, xMonstros, yMonstros, this);
                            break;
                        case "tubarao":
                            graficos.drawImage(tubarao, xMonstros, yMonstros, this);
                            break;
                        case "dragao marinho":
                            graficos.drawImage(dragaoM, xMonstros, yMonstros, this);
                            break;
                        case "jacare":
                            graficos.drawImage(jacare, xMonstros, yMonstros, this);
                            break;
                    }
                    xMonstros += 100;
                }  
            }
            
            int xMagias = 392, yMagias = 475;
            for (int iMagia = 0; iMagia < magiasefeiticos.length; iMagia++) {
                String cartaMagia = magiasefeiticos[iMagia];
                if (cartaMagia != null) {
                    switch (cartaMagia) {
                        case "compra":
                            graficos.drawImage(compra, xMagias, yMagias, this);
                            break;
                        case "vida":
                            graficos.drawImage(cura, xMagias, yMagias, this);
                            break;
                        case "destruicao":
                            graficos.drawImage(destruir, xMagias, yMagias, this);
                            break;
                        case "ataque":
                            graficos.drawImage(ataque, xMagias, yMagias, this);
                            break;
                        case "defesa":
                            graficos.drawImage(defesa, xMagias, yMagias, this);
                            break;
                        case "dano":
                            graficos.drawImage(dano, xMagias, yMagias, this);
                            break;
                        case "equipamento":
                            graficos.drawImage(equipamento, xMagias, yMagias, this);
                            break;
                        case "campoF":
                            graficos.drawImage(campoF, xMagias, yMagias, this);
                            break;
                        case "campoR":
                            graficos.drawImage(campoR, xMagias, yMagias, this);
                            break;
                        case "campoA":
                            graficos.drawImage(campoA, xMagias, yMagias, this);
                            break;
                    }
                    xMagias += 100;
                }
            }
            int xMonstros2 = 392, yMonstros2 = 230;

            for (int iMonstro = 0; iMonstro < monstros2.length; iMonstro++) {
                String cartaMonstro = monstros2[iMonstro];
                if (cartaMonstro != null) {
                    switch (cartaMonstro) {
                        case "lobo":
                            graficos.drawImage(lobo, xMonstros2, yMonstros2, this);
                            break;
                        case "abelha":
                            graficos.drawImage(abelha, xMonstros2, yMonstros2, this);
                            break;
                        case "aguia":
                            graficos.drawImage(aguia, xMonstros2, yMonstros2, this);
                            break;
                        case "aranha":
                            graficos.drawImage(aranha, xMonstros2, yMonstros2, this);
                            break;
                        case "besouro":
                            graficos.drawImage(besouro, xMonstros2, yMonstros2, this);
                            break;
                        case "cobra":
                            graficos.drawImage(cobraR, xMonstros2, yMonstros2, this);
                            break;
                        case "enguia":
                            graficos.drawImage(enguia, xMonstros2, yMonstros2, this);
                            break;
                        case "dragao relampago":
                            graficos.drawImage(dragaoR, xMonstros2, yMonstros2, this);
                            break;
                        case "tigre":
                            graficos.drawImage(tigreR, xMonstros2, yMonstros2, this);
                            break;
                        case "guerreiro alado":
                            graficos.drawImage(guerreiroA, xMonstros2, yMonstros2, this);
                            break;
                        case "gato":
                            graficos.drawImage(gato, xMonstros2, yMonstros2, this);
                            break;
                        case "cobra de fogo":
                            graficos.drawImage(cobraF, xMonstros2, yMonstros2, this);
                            break;
                        case "coelho":
                            graficos.drawImage(coelho, xMonstros2, yMonstros2, this);
                            break;
                        case "dragao de fogo":
                            graficos.drawImage(dragaoF, xMonstros2, yMonstros2, this);
                            break;
                        case "fenix":
                            graficos.drawImage(fenix, xMonstros2, yMonstros2, this);
                            break;
                        case "guerreiro":
                            graficos.drawImage(guerreiro, xMonstros2, yMonstros2, this);
                            break;
                        case "leao":
                            graficos.drawImage(leao, xMonstros2, yMonstros2, this);
                            break;
                        case "raposa":
                            graficos.drawImage(raposa, xMonstros2, yMonstros2, this);
                            break;
                        case "tigre de fogo":
                            graficos.drawImage(tigre, xMonstros2, yMonstros2, this);
                            break;
                        case "cavalo":
                            graficos.drawImage(cavalo, xMonstros2, yMonstros2, this);
                            break;
                        case "cobra marinha":
                            graficos.drawImage(cobraM, xMonstros2, yMonstros2, this);
                            break;
                        case "golfinho":
                            graficos.drawImage(golfinho, xMonstros2, yMonstros2, this);
                            break;
                        case "peixe pequeno":
                            graficos.drawImage(peixeP, xMonstros2, yMonstros2, this);
                            break;
                        case "peixe":
                            graficos.drawImage(peixe, xMonstros2, yMonstros2, this);
                            break;
                        case "sapo":
                            graficos.drawImage(sapo, xMonstros2, yMonstros2, this);
                            break;
                        case "sereia":
                            graficos.drawImage(sereia, xMonstros2, yMonstros2, this);
                            break;
                        case "tartaruga":
                            graficos.drawImage(tartaruga, xMonstros2, yMonstros2, this);
                            break;
                        case "tubarao":
                            graficos.drawImage(tubarao, xMonstros2, yMonstros2, this);
                            break;
                        case "dragao marinho":
                            graficos.drawImage(dragaoM, xMonstros2, yMonstros2, this);
                            break;
                        case "jacare":
                            graficos.drawImage(jacare, xMonstros2, yMonstros2, this);
                            break;
                    }
                    xMonstros2 += 100;
                }  
            }
            
            int xMagias2 = 392, yMagias2 = 115;
            for (int iMagia = 0; iMagia < magiasefeiticos2.length; iMagia++) {
                String cartaMagia = magiasefeiticos2[iMagia];
                if (cartaMagia != null) {
                    switch (cartaMagia) {
                        case "compra":
                            graficos.drawImage(compra, xMagias2, yMagias2, this);
                            break;
                        case "vida":
                            graficos.drawImage(cura, xMagias2, yMagias2, this);
                            break;
                        case "destruicao":
                            graficos.drawImage(destruir, xMagias2, yMagias2, this);
                            break;
                        case "ataque":
                            graficos.drawImage(ataque, xMagias2, yMagias2, this);
                            break;
                        case "defesa":
                            graficos.drawImage(defesa, xMagias2, yMagias2, this);
                            break;
                        case "dano":
                            graficos.drawImage(dano, xMagias2, yMagias2, this);
                            break;
                        case "equipamento":
                            graficos.drawImage(equipamento, xMagias2, yMagias2, this);
                            break;
                        case "campoF":
                            graficos.drawImage(campoF, xMagias2, yMagias2, this);
                            break;
                        case "campoR":
                            graficos.drawImage(campoR, xMagias2, yMagias2, this);
                            break;
                        case "campoA":
                            graficos.drawImage(campoA, xMagias2, yMagias2, this);
                            break;
                    }
                    xMagias2 += 100;
                }
            }
            
        }
        if (turno % 2 ==8) {
        	graficos.drawImage(tela, 150, 0, this);
        }
        if (turno % 2 ==8) {
        	graficos.drawImage(tela, 140, 585, this);
        }
        
        if (mostrarEfeitos) {
            graficos.drawImage(efeitos, 620, 30, this);
        }
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    private int contador = 1;

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (!faseBatalha) {
        if (key == KeyEvent.VK_A) {
            contador = Math.max(1, contador - 1);
            x = Math.max(222, x - 100);
            x2 = Math.max(222, x2 - 100);
        }

        if (key == KeyEvent.VK_D) {
            contador = Math.min(8, contador + 1);
            x = Math.min(922, x + 100);
            x2 = Math.min(922, x2 + 100);
        }
        if (key == KeyEvent.VK_ENTER) {
        	moverTermoPorContador(contador);
        }

        repaint();
        requestFocusInWindow();
        }
        if (faseBatalha) {
        	if (turno % 2 != 0) {
            if (selecionandoAtacante) {
                if (key == KeyEvent.VK_A && monstros.length > 0) {
                    monstroSelecionadoAtacante = monstros[0];
                } else if (key == KeyEvent.VK_S && monstros.length > 1) {
                    monstroSelecionadoAtacante = monstros[1];
                } else if (key == KeyEvent.VK_D && monstros.length > 2) {
                    monstroSelecionadoAtacante = monstros[2];
                }
                if (monstroSelecionadoAtacante != null && key == KeyEvent.VK_ENTER) {
                    selecionandoAtacante = false;
                    System.out.println("Monstro atacante selecionado: " + monstroSelecionadoAtacante);
                    System.out.println("Selecione o monstro alvo.");
                }
            } else {
                if (key == KeyEvent.VK_A && monstros2.length > 0) {
                    monstroSelecionadoAlvo = monstros2[0];
                } else if (key == KeyEvent.VK_S && monstros2.length > 1) {
                    monstroSelecionadoAlvo = monstros2[1];
                } else if (key == KeyEvent.VK_D && monstros2.length > 2) {
                    monstroSelecionadoAlvo = monstros2[2];
                }
                if (monstroSelecionadoAlvo != null && key == KeyEvent.VK_ENTER) {
                    System.out.println("Monstro alvo selecionado: " + monstroSelecionadoAlvo);
                    realizarCombate();
                    selecionandoAtacante = true;
                }
            }
        }
        	if (turno % 2 == 0) {
                if (selecionandoAtacante) {
                    if (key == KeyEvent.VK_A && monstros2.length > 0) {
                        monstroSelecionadoAtacante = monstros2[0];
                    } else if (key == KeyEvent.VK_S && monstros2.length > 1) {
                        monstroSelecionadoAtacante = monstros2[1];
                    } else if (key == KeyEvent.VK_D && monstros2.length > 2) {
                        monstroSelecionadoAtacante = monstros2[2];
                    }
                    if (monstroSelecionadoAtacante != null && key == KeyEvent.VK_ENTER) {
                        selecionandoAtacante = false;
                        System.out.println("Monstro atacante selecionado: " + monstroSelecionadoAtacante);
                        System.out.println("Selecione o monstro alvo.");
                    }
                } else {
                    if (key == KeyEvent.VK_A && monstros.length > 0) {
                        monstroSelecionadoAlvo = monstros[0];
                    } else if (key == KeyEvent.VK_S && monstros.length > 1) {
                        monstroSelecionadoAlvo = monstros[1];
                    } else if (key == KeyEvent.VK_D && monstros.length > 2) {
                        monstroSelecionadoAlvo = monstros[2];
                    }
                    if (monstroSelecionadoAlvo != null && key == KeyEvent.VK_ENTER) {
                        System.out.println("Monstro alvo selecionado: " + monstroSelecionadoAlvo);
                        realizarCombate();
                        selecionandoAtacante = true;
                    }
                }
            }
       }
        repaint();
        requestFocusInWindow();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
