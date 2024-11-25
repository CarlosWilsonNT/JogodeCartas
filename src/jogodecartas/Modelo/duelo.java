package jogodecartas.Modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import javax.swing.JFrame;


public class duelo extends JPanel implements KeyListener {

    private Image fundo;
    private Image deck;
    private Image cristal;
    
    private Image setaB;
    private Image setaC;
    
    private String[] deck1;
    private String[] deck2;
    
    private String[] monstros = new String[3];
    private String[] magiasefeiticos= new String[3];
    
    private String[] monstros2 = new String[3];
    private String[] magiasefeiticos2 = new String[3];
    
    private String[] maojogador1 = new String[8];
    private String[] maojogador2 = new String[8];
    
    private String[] cemiterio1 = new String[30];
    private String[] cemiterio2 = new String[30];
    
    private status status = new status();
    
    private Image efeitos;

    private boolean mostrarEfeitos = false;
    private boolean mostrarDicas = false;
    private JButton botaoEfeitos;
    private Image comojogar;
    private JButton botaoCompra;
    private JButton botaoBatalha;
    private JButton botaoFim;
    private JButton botaoComojogar;
    
    private int x = 222;
    private int y = 550;
    
    private int x2 = 222;
    private int y2 = 100;
    
    private int turno;
    
    int cartasExibidas = 5;
    int cartasExibidas2 = 5;
    
    int monstro = 0;
    int magia = 0;
    
    int monstro2 = 0;
    int magia2 = 0;
    
    int xDeck = 200, yDeck = 585;
    int xMonstros = 392, yMonstros = 360;
    int cartasExibidasDeck = 5;
    
    private int cristalInvocacao;
    int cristalInvocacao2 = 1;
    int pontosVidaJogador1 = 8000;
    int pontosVidaJogador2 = 8000;
    
    private boolean faseBatalha = false;
    private String monstroSelecionadoAtacante = null;
    private String monstroSelecionadoAlvo = null;
    private boolean selecionandoAtacante = true;
    
    private Image fim;
    private boolean vencedor1 = false;
    private boolean vencedor2 = false;
    private boolean aumentoAtivado = false;
    private boolean reducaoAtivada = false;
    private boolean espada = false;
    private boolean espada2 = false;
    private boolean camporaio = false;
    private boolean campofogo = false;
    private boolean campoagua = false;
    
    private boolean textoAtaque = false;
    private boolean textoDefesa = false;
    
    private boolean turnoInicial = true;
    private boolean turnoJogador1 = true;
    private boolean turnoJogador2 = true;
    
    public void iniciarJogo() {
        turno = (Math.random() < 0.5) ? 1 : 2;
        if(turno == 1) {
        	turnoJogador2 = false;
        }else {
        	turnoJogador1 = false;
        }
    }
    
    public duelo(String[] deck1, String[] deck2) {
    	
    	iniciarJogo();
    	Imagens.carregarImagens();
    	
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

        ImageIcon telafinal = new ImageIcon("banco_i/vitoria.png");
        fim = telafinal.getImage();
        
        ImageIcon imagecristal = new ImageIcon("banco_i/cristal.png");
        cristal = imagecristal.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        ImageIcon cartasetaB = new ImageIcon("banco_i/setabaixo.png");
        setaB = cartasetaB.getImage();
        
        ImageIcon cartasetaC = new ImageIcon("banco_i/setacima.png");
        setaC = cartasetaC.getImage();
        
        ImageIcon imagemEfeitos = new ImageIcon("banco_i/efeitos.png");
        efeitos = imagemEfeitos.getImage();
        
        ImageIcon imagemcomojogar = new ImageIcon("banco_i/comojogar2.png");
        comojogar = imagemcomojogar.getImage();
        
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
                
                if (!turnoInicial) {
                	transferirPrimeiroTermo();
                }
                verificarVencedor();
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
            	textoAtaque = true;
            	textoDefesa = false;
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
            	if(turnoJogador1) {
            		turnoJogador1 = false;
            		turnoJogador2 = true;
            	}else {
            		turnoJogador1 = true;
            		turnoJogador2 = false;
            	}
            	turnoInicial = false;
            	proximoTurno();
            	resetarBooleansInvocados();
                turno++;
            	faseBatalha = false;
            	botaoBatalha.setVisible(false);
                botaoFim.setVisible(false);
                botaoCompra.setVisible(true);
                textoDefesa = false;
            	textoAtaque = false;
            	resetarSelecoes();
                repaint();
            }
        });
        botaoFim.setVisible(false);
        botaoFim.setFocusable(false);
        add(botaoFim);

        setLayout(null);
        
        botaoComojogar = new JButton("Como Jogar");
        botaoComojogar.setBounds(930, 30, 130, 30);
        botaoComojogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDicas = !mostrarDicas;
                repaint();
            }
        });
        
        setLayout(null);
        botaoComojogar.setFocusable(false);
        add(botaoComojogar);
    }
    
    
    private void moverTermoPorContador(int contador) {
        int indice = contador - 1;
        if (turnoJogador1) {
        if (indice >= 0 && indice < maojogador1.length && maojogador1[indice] != null) {
            String carta = maojogador1[indice];
            processarCarta(carta, maojogador1, indice, monstros, magiasefeiticos, cemiterio1);
        }
        }
        if (turnoJogador2) {
        if (indice >= 0 && indice < maojogador2.length && maojogador2[indice] != null) {
            String carta = maojogador2[indice];
            processarCarta(carta, maojogador2, indice, monstros2, magiasefeiticos2, cemiterio2);
        }
        }
    }
    
    private void atualizarBooleansInvocados(String[] listaMonstros, int posicaoInvocada) {
        if (listaMonstros == monstros) {
            if (posicaoInvocada == 0) invocadoAgora1 = true;
            else if (posicaoInvocada == 1) invocadoAgora2 = true;
            else if (posicaoInvocada == 2) invocadoAgora3 = true;
        } else if (listaMonstros == monstros2) {
            if (posicaoInvocada == 0) invocadoAgora4 = true;
            else if (posicaoInvocada == 1) invocadoAgora5 = true;
            else if (posicaoInvocada == 2) invocadoAgora6 = true;
        }
    }
    
    private void resetarBooleansInvocados() {
        invocadoAgora1 = false;
        invocadoAgora2 = false;
        invocadoAgora3 = false;
        invocadoAgora4 = false;
        invocadoAgora5 = false;
        invocadoAgora6 = false;
    }
    
    private boolean invocadoAgora1;
    private boolean invocadoAgora2;
    private boolean invocadoAgora3;
    private boolean invocadoAgora4;
    private boolean invocadoAgora5;
    private boolean invocadoAgora6;

    private void processarCarta(String carta, String[] mao, int indice, String[] listaMonstros, String[] listaMagiasFeiticos, String[] listaCemiterio) {
        int[] atributosMonstro = status.getAtributosMonstro(carta);

        if (atributosMonstro != null) {
            int custoInvocacao = atributosMonstro[2];

            if (custoInvocacao <= cristalInvocacao) { 
                if (temEspacoNaLista(listaMonstros)) {
                    int posicaoInvocada = adicionarNaLista(listaMonstros, carta);
                    moverCartasParaEsquerda(mao, indice);
                    cristalInvocacao -= custoInvocacao; 
                    System.out.println("Monstro invocado: " + carta + ". Cristais restantes: " + cristalInvocacao);

                    atualizarBooleansInvocados(listaMonstros, posicaoInvocada);

                    int efeitoMonstro = atributosMonstro[3];
                    if (efeitoMonstro > 0) {
                        aplicarEfeitoMonstro(efeitoMonstro, carta);
                    }
                } else {
                    System.out.println("Não há espaço para invocar mais monstros.");
                }
            } else {
                System.out.println("Cristais insuficientes para invocar " + carta + ". Necessário: " + custoInvocacao + ", disponível: " + cristalInvocacao);
            }
        }

        else if (status.getEfeitoMagia(carta) != null) {
            String[] magia = status.getEfeitoMagia(carta);
            int valorMagia = Integer.parseInt(magia[1]);
            int custoMagia = Integer.parseInt(magia[2]);

            if (custoMagia <= cristalInvocacao) {
                efeitoMagia(valorMagia);
                if (temEspacoNaLista(listaMagiasFeiticos)) {
                    adicionarNaLista(listaMagiasFeiticos, carta);
                    moverCartasParaEsquerda(mao, indice);
                    moverParaCemiterio(carta, listaMagiasFeiticos, listaCemiterio);
                    cristalInvocacao -= custoMagia;
                    System.out.println("Magia ativada: " + carta + ". Cristais restantes: " + cristalInvocacao);
                }
            } else {
                System.out.println("Cristais insuficientes para ativar magia " + carta + ". Necessário: " + custoMagia + ", disponível: " + cristalInvocacao);
            }
        } 
        else if (status.getEfeitoFeitico(carta) != null) {
            String[] feitico = status.getEfeitoFeitico(carta);
            int valorFeitico = Integer.parseInt(feitico[1]);
            int custoFeitico = Integer.parseInt(feitico[2]);

            if (custoFeitico <= cristalInvocacao) {
                efeitoFeitico(valorFeitico);
                if (temEspacoNaLista(listaMagiasFeiticos)) {
                    adicionarNaLista(listaMagiasFeiticos, carta);
                    moverCartasParaEsquerda(mao, indice);
                    cristalInvocacao -= custoFeitico;
                    System.out.println("Feitiço ativado: " + carta + ". Cristais restantes: " + cristalInvocacao);
                }
            } else {
                System.out.println("Cristais insuficientes para ativar feitiço " + carta + ". Necessário: " + custoFeitico + ", disponível: " + cristalInvocacao);
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
    }
    
    private void raigeki1() {
        todosParaCemiterio(monstros, cemiterio1, "Jogador 1");
    }

    private void raigeki2() {
        todosParaCemiterio(monstros2, cemiterio2, "Jogador 2");
    }

    private void todosParaCemiterio(String[] monstros, String[] cemiterio, String jogador) {
        for (int i = 0; i < monstros.length; i++) {
            String monstro = monstros[i];
            if (monstro != null) {
                if (temEspacoNaLista(cemiterio)) {
                    adicionarNaLista(cemiterio, monstro);
                    System.out.println("Monstro transferido para o cemitério de " + jogador + ": " + monstro);
                    monstros[i] = null;
                } else {
                    System.out.println("Não há espaço no cemitério de " + jogador + " para o monstro: " + monstro);
                }
            }
        }
    }
    
    private void destruirMagiaFeiticoOponente() {
    	if (turnoJogador1) {
        for (int i = 0; i < magiasefeiticos2.length; i++) {
            if (magiasefeiticos2[i] != null) {
                System.out.println("Magia/Feitiço do oponente destruída: " + magiasefeiticos2[i]);
                magiasefeiticos2[i] = null;
                break;
            }
        }
    	}
    	if (turnoJogador2) {
            for (int i = 0; i < magiasefeiticos.length; i++) {
                if (magiasefeiticos[i] != null) {
                    System.out.println("Feitiço do oponente destruído: " + magiasefeiticos[i]);
                    magiasefeiticos[i] = null;
                    break;
                }
            }
        	}
    }
    
    private void invocarMonstroDoCemiterio() {
        if (turnoJogador1) {
            invocarMonstro(cemiterio1, monstros, "Jogador 1");
        } else if (turnoJogador2) {
            invocarMonstro(cemiterio2, monstros2, "Jogador 2");
        }
    }

    private void invocarMonstro(String[] cemiterio, String[] monstros, String jogador) {
        for (int i = 0; i < cemiterio.length; i++) {
            String monstro = cemiterio[i];
            if (monstro != null) {
                if (monstro.trim().equalsIgnoreCase("nulo")) {
                    cemiterio[i] = null;
                    System.out.println("Termo 'nulo' removido do cemitério.");
                    invocarMonstro(cemiterio, monstros, jogador);
                    return;
                }
                if (temEspacoNaLista(monstros)) {
                    adicionarNaLista(monstros, monstro);
                    System.out.println("Monstro invocado do cemitério para " + jogador + ": " + monstro);
                    cemiterio[i] = null;
                    return;
                } else {
                    System.out.println("Não há espaço para invocar monstros do cemitério para " + jogador + ".");
                    return;
                }
            }
        }
        System.out.println("Nenhum monstro válido no cemitério para " + jogador + ".");
    }
    
    private void rapidez(String[] listaMonstros) {
        if (turnoJogador1) {
            for (int i = 0; i < listaMonstros.length; i++) {
                String monstroNome = listaMonstros[i];

                if (monstroNome != null) {
                    Monstro monstro = new Monstro(monstroNome);
                    int efeitoMonstro = monstro.getEfeito();

                    if (efeitoMonstro == 7) {
                        if (i == 0) { 
                            invocadoAgora1 = false;
                            System.out.println("Efeito 7 ativado para o monstro na posição 0: " + monstroNome);
                        } else if (i == 1) {
                            invocadoAgora2 = false;
                            System.out.println("Efeito 7 ativado para o monstro na posição 1: " + monstroNome);
                        } else if (i == 2) {
                            invocadoAgora3 = false;
                            System.out.println("Efeito 7 ativado para o monstro na posição 2: " + monstroNome);
                        }
                    }
                }
            }
        }
    
        if (turnoJogador2) {
            for (int i = 0; i < listaMonstros.length; i++) {
                String monstroNome = listaMonstros[i];
                if (monstroNome != null) {
                    Monstro monstro = new Monstro(monstroNome);
                    int efeitoMonstro = monstro.getEfeito();

                    if (efeitoMonstro == 7) {
                        if (i == 0) {
                            invocadoAgora4 = false;
                            System.out.println("Efeito 7 ativado para o monstro do jogador 2 na posição 0: " + monstroNome);
                        } else if (i == 1) {
                            invocadoAgora5 = false;
                            System.out.println("Efeito 7 ativado para o monstro do jogador 2 na posição 1: " + monstroNome);
                        } else if (i == 2) {
                            invocadoAgora6 = false;
                            System.out.println("Efeito 7 ativado para o monstro do jogador 2 na posição 2: " + monstroNome);
                        }
                    }
                }
            }
        }
       }
    
    
    private void aplicarEfeitoMonstro(int efeito, String carta) {
        switch (efeito) {
            case 1:
            	transferirPrimeiroTermo();
                System.out.println("O monstro " + carta + " aplica o efeito 1.");
                break;
            case 2:
            	invocarMonstroDoCemiterio();
                System.out.println("O monstro " + carta + " aplica o efeito 2.");
                break;
            case 3:
            	destruirMagiaFeiticoOponente();
            	verificarMagias();
                System.out.println("O monstro " + carta + " aplica o efeito 3.");
                break;
            case 4:
            	if (turnoJogador1) {
                	pontosVidaJogador1 += 1000;
                	}
                	if (turnoJogador2) {
                	pontosVidaJogador2 += 1000;
                	}
                System.out.println("O monstro " + carta + " aplica o efeito 4.");
                break;
            case 5:
            	if (turnoJogador1) {
                	pontosVidaJogador2 -= 500;
                	}
                	if (turnoJogador2) {
                	pontosVidaJogador1 -= 500;
                	}
                System.out.println("O monstro " + carta + " aplica o efeito 5.");
                break;
            case 6:
            	cristalInvocacao += 2;
                System.out.println("O monstro " + carta + " aplica o efeito 6.");
                break;
            case 7:
            	rapidez(monstros);
            	rapidez(monstros2);
                System.out.println("O monstro " + carta + " aplica o efeito 7.");
                break;
            default:
                System.out.println("O monstro " + carta + " tem um efeito desconhecido.");
                break;
        }
    }

    private void efeitoMagia(int valor) {
        switch (valor) {
            case 1:
            	transferirPrimeiroTermo();
            	transferirPrimeiroTermo();
                break;
            case 2:
            	if (turnoJogador1) {
            	pontosVidaJogador1 += 500;
            	}
            	if (turnoJogador2) {
            	pontosVidaJogador2 += 500;
            	}
                break;
            case 3:
            	if (turnoJogador1) {
            	pontosVidaJogador2 -= 300;
            	}
            	if (turnoJogador2) {
            	pontosVidaJogador1 -= 300;
            	}
            	break;
            case 4:
            	if (turnoJogador1) {
                raigeki2();
                	}
            	if (turnoJogador2) {
            	raigeki1();
            	}
                break;
            case 5:
            	aumentoAtivado = true;
                break;
            case 6:
            	reducaoAtivada = true;
                break;
        }
    }

    private void efeitoFeitico(int valor) {
        switch (valor) {
            case 1:
            	if (turnoJogador1) {
            	espada = true;
            	}
            	if (turnoJogador2) {
                espada2 = true;
                }
                break;
            case 2:
            	campofogo = true;
                break;
            case 3:
            	camporaio = true;
                break;
            case 4:
            	campoagua = true;
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
    private int adicionarNaLista(String[] lista, String carta) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == null) {
                lista[i] = carta;
                return i;
            }
        }
        return -1;
    }

    private void verificarMagias() {
        boolean equipExiste = verificarTermo(magiasefeiticos, magiasefeiticos2, "equipamento");
        boolean campoAExiste = verificarTermo(magiasefeiticos, magiasefeiticos2, "campoA");
        boolean campoFExiste = verificarTermo(magiasefeiticos, magiasefeiticos2, "campoF");
        boolean campoRExiste = verificarTermo(magiasefeiticos, magiasefeiticos2, "campoR");

        if (turnoJogador1) {
            if (!equipExiste) espada2 = false;	
        }
        if (turnoJogador2) {
            if (!equipExiste) espada = false;	
        }
        if (!campoAExiste) campoagua = false;
        if (!campoFExiste) campofogo = false;
        if (!campoRExiste) camporaio = false;
    }

    private boolean verificarTermo(String[] magiasefeiticos, String[] magiasefeiticos2, String termo) {
        for (String feitico : magiasefeiticos) {
            if (feitico.equals(termo)) {
                return true;
            }
        }
        for (String feitico : magiasefeiticos2) {
            if (feitico.equals(termo)) {
                return true;
            }
        }
        return false;
    }

    
    private void transferirPrimeiroTermo() {
    	if (turnoJogador1) {
        if (deck1[0] != null) {
            adicionarNaMao(maojogador1, deck1[0]);
            for (int i = 1; i < deck1.length; i++) {
                deck1[i - 1] = deck1[i];
            }
            deck1[deck1.length - 1] = null;
        }
    }if (turnoJogador2) {
        if (deck2[0] != null) {
            adicionarNaMao(maojogador2, deck2[0]);
            for (int i = 1; i < deck2.length; i++) {
                deck2[i - 1] = deck2[i];
            }
            deck2[deck2.length - 1] = null;
        }
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
        if (turnoJogador1) {
            if (monstroSelecionadoAtacante != null && monstroSelecionadoAlvo != null) {
                int[] atributosAtacante = status.getAtributosMonstro(monstroSelecionadoAtacante);
                int[] atributosAlvo = status.getAtributosMonstro(monstroSelecionadoAlvo);

                if (atributosAtacante != null && atributosAlvo != null) {
                    int ataqueAtacante = atributosAtacante[0];

                    if (aumentoAtivado) {
                        ataqueAtacante += 500;
                    }

                    if (camporaio && atributosAtacante[4] == 1) {
                        ataqueAtacante += 200;
                    }
                    if (campofogo && atributosAtacante[4] == 2) {
                        ataqueAtacante += 200;
                    }
                    if (campoagua && atributosAtacante[4] == 3) {
                        ataqueAtacante += 200;
                    }
                    if (espada) {
                        ataqueAtacante += 500;
                    }

                    int defesaAlvo = atributosAlvo[1];
                    if (reducaoAtivada) {
                        defesaAlvo -= 500;
                    }

                    int dano = ataqueAtacante - defesaAlvo;

                    if (dano > 0) {
                        pontosVidaJogador2 -= dano;
                        System.out.println("O monstro alvo sofreu " + dano + " de dano! Pontos de vida restantes do jogador 2: " + pontosVidaJogador2);
                        removerDaLista(monstros2, monstroSelecionadoAlvo);
                        adicionarNaLista(cemiterio2, monstroSelecionadoAlvo);
                        verificarVencedor();
                        resetarSelecoes();
                    } else if (dano < 0) {
                        pontosVidaJogador1 += dano;
                        System.out.println("O monstro alvo tinha mais poder: " + dano + ". Pontos de vida restantes do jogador 1: " + pontosVidaJogador1);
                        verificarVencedor();
                        resetarSelecoes();
                    }else if (dano == 0) {
                        removerDaLista(monstros2, monstroSelecionadoAlvo);
                        adicionarNaLista(cemiterio2, monstroSelecionadoAlvo);
                        removerDaLista(monstros, monstroSelecionadoAtacante);
                        adicionarNaLista(cemiterio1, monstroSelecionadoAtacante);
                        resetarSelecoes();
                    }
                }
            } 
        }

        if (turnoJogador2) {
            if (monstroSelecionadoAtacante != null && monstroSelecionadoAlvo != null) {
                int[] atributosAtacante = status.getAtributosMonstro(monstroSelecionadoAtacante);
                int[] atributosAlvo = status.getAtributosMonstro(monstroSelecionadoAlvo);

                if (atributosAtacante != null && atributosAlvo != null) {
                    int ataqueAtacante = atributosAtacante[0];
                    
                    if (aumentoAtivado) {
                        ataqueAtacante += 500;
                    }

                    if (camporaio && atributosAtacante[4] == 1) {
                        ataqueAtacante += 200;
                    }
                    if (campofogo && atributosAtacante[4] == 2) {
                        ataqueAtacante += 200;
                    }
                    if (campoagua && atributosAtacante[4] == 3) {
                        ataqueAtacante += 200;
                    }
                    if (espada2) {
                        ataqueAtacante += 500;
                    }

                    int defesaAlvo = atributosAlvo[1];
                    if (reducaoAtivada) {
                        defesaAlvo -= 500;
                    }

                    int dano = ataqueAtacante - defesaAlvo;

                    if (dano > 0) {
                        pontosVidaJogador1 -= dano;
                        System.out.println("O monstro alvo sofreu " + dano + " de dano! Pontos de vida restantes do jogador 1: " + pontosVidaJogador1);
                        removerDaLista(monstros, monstroSelecionadoAlvo);
                        adicionarNaLista(cemiterio1, monstroSelecionadoAlvo);
                        verificarVencedor();
                        resetarSelecoes();
                    } else if (dano < 0) {
                        pontosVidaJogador2 += dano;
                        System.out.println("O monstro alvo tinha mais poder: " + dano + ". Pontos de vida restantes do jogador 2: " + pontosVidaJogador2);
                        verificarVencedor();
                        resetarSelecoes();
                    }else if (dano == 0) {
                        removerDaLista(monstros, monstroSelecionadoAlvo);
                        adicionarNaLista(cemiterio1, monstroSelecionadoAlvo);
                        removerDaLista(monstros2, monstroSelecionadoAtacante);
                        adicionarNaLista(cemiterio2, monstroSelecionadoAtacante);
                        resetarSelecoes();
                    }
                } 
            } 
        }
    }

    private void resetarSelecoes() {
        monstroSelecionadoAtacante = null;
        monstroSelecionadoAlvo = null;
        selecionandoAtacante = true;
        aumentoAtivado = false;
        reducaoAtivada = false;
        System.out.println("Seleção de monstros reiniciada para nova batalha.");
    }
    
    public boolean deckOut(String[] deck) {
        for (String carta : deck) {
            if (carta != null) {
                return false;
            }
        }
        return true;
    }
    
    public void verificarVencedor() {
        if (pontosVidaJogador2 <= 0 || deckOut(deck2)) {
            vencedor1 = true;
        }
        if (pontosVidaJogador1 <= 0 || deckOut(deck1)) {
            vencedor2 = true;
            }
    }
   
    @Override
    public void addNotify() {
        super.addNotify();
        requestFocusInWindow();
    }
    private boolean turnoAtualizado = true;
    public void proximoTurno() {
        turnoAtualizado = true;
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

        graficos.drawString(String.valueOf(pontosVidaJogador1), 0, 540);
        graficos.drawString(String.valueOf(pontosVidaJogador2), 0, 140);
        graficos.setFont(new Font("Serif", Font.BOLD, 30));
        if(faseBatalha) {
        g.drawString("Fase de Batalha", 20, 300);
        graficos.setFont(new Font("Arial", Font.BOLD, 10));
        g.drawString("A                               S                               D", 430, 350);
        g.drawString("A                               S                               D", 430, 220);
        }
        if(!faseBatalha) {
            g.drawString("Fase Principal", 20, 300);
            }

        if (turnoJogador1 && !faseBatalha) {
            graficos.drawImage(setaB, x, y, this);

            if (turnoAtualizado) {
                cristalInvocacao = Math.min((turno - 1) / 2 + 1, 10);
                turnoAtualizado = false;
            }

            if (turno >= 1 && cristalInvocacao >= 1) graficos.drawImage(cristal, 340, 370, this);
            if (turno >= 2 && cristalInvocacao >= 2) graficos.drawImage(cristal, 310, 370, this);
            if (turno >= 3 && cristalInvocacao >= 3) graficos.drawImage(cristal, 340, 410, this);
            if (turno >= 4 && cristalInvocacao >= 4) graficos.drawImage(cristal, 310, 410, this);
            if (turno >= 5 && cristalInvocacao >= 5) graficos.drawImage(cristal, 340, 450, this);
            if (turno >= 6 && cristalInvocacao >= 6) graficos.drawImage(cristal, 310, 450, this);
            if (turno >= 7 && cristalInvocacao >= 7) graficos.drawImage(cristal, 340, 490, this);
            if (turno >= 8 && cristalInvocacao >= 8) graficos.drawImage(cristal, 310, 490, this);
            if (turno >= 9 && cristalInvocacao >= 9) graficos.drawImage(cristal, 340, 530, this);
            if (turno >= 10 && cristalInvocacao >= 10) graficos.drawImage(cristal, 310, 530, this);
        }

        if (turnoJogador2 && !faseBatalha) {
            graficos.drawImage(setaC, x2, y2, this);

            if (turnoAtualizado) {
                cristalInvocacao = Math.min((turno - 1) / 2 + 1, 10);
                turnoAtualizado = false;
            }

            if (turno >= 1 && cristalInvocacao >= 1) graficos.drawImage(cristal, 680, 120, this);
            if (turno >= 2 && cristalInvocacao >= 2) graficos.drawImage(cristal, 710, 120, this);
            if (turno >= 3 && cristalInvocacao >= 3) graficos.drawImage(cristal, 680, 160, this);
            if (turno >= 4 && cristalInvocacao >= 4) graficos.drawImage(cristal, 710, 160, this);
            if (turno >= 5 && cristalInvocacao >= 5) graficos.drawImage(cristal, 680, 200, this);
            if (turno >= 6 && cristalInvocacao >= 6) graficos.drawImage(cristal, 710, 200, this);
            if (turno >= 7 && cristalInvocacao >= 7) graficos.drawImage(cristal, 680, 240, this);
            if (turno >= 8 && cristalInvocacao >= 8) graficos.drawImage(cristal, 710, 240, this);
            if (turno >= 9 && cristalInvocacao >= 9) graficos.drawImage(cristal, 680, 280, this);
            if (turno >= 10 && cristalInvocacao >= 10) graficos.drawImage(cristal, 710, 280, this);
        }
        
        int x = 200, y = 585;    
        for (int i = 0; i < maojogador1.length; i++) {
            if (turnoJogador1) {
                String carta = maojogador1[i];
                if (carta != null) {
                    switch (carta) {
                        case "lobo":
                            graficos.drawImage(Imagens.lobo, x, y, this);
                            break;
                        case "abelha":
                            graficos.drawImage(Imagens.abelha, x, y, this);
                            break;
                        case "aguia":
                            graficos.drawImage(Imagens.aguia, x, y, this);
                            break;
                        case "aranha":
                            graficos.drawImage(Imagens.aranha, x, y, this);
                            break;
                        case "besouro":
                            graficos.drawImage(Imagens.besouro, x, y, this);
                            break;
                        case "cobra":
                            graficos.drawImage(Imagens.cobraR, x, y, this);
                            break;
                        case "enguia":
                            graficos.drawImage(Imagens.enguia, x, y, this);
                            break;
                        case "dragao relampago":
                            graficos.drawImage(Imagens.dragaoR, x, y, this);
                            break;
                        case "tigre":
                            graficos.drawImage(Imagens.tigreR, x, y, this);
                            break;
                        case "guerreiro alado":
                            graficos.drawImage(Imagens.guerreiroA, x, y, this);
                            break;
                        case "gato":
                            graficos.drawImage(Imagens.gato, x, y, this);
                            break;
                        case "cobra de fogo":
                            graficos.drawImage(Imagens.cobraF, x, y, this);
                            break;
                        case "coelho":
                            graficos.drawImage(Imagens.coelho, x, y, this);
                            break;
                        case "dragao de fogo":
                            graficos.drawImage(Imagens.dragaoF, x, y, this);
                            break;
                        case "fenix":
                            graficos.drawImage(Imagens.fenix, x, y, this);
                            break;
                        case "guerreiro":
                            graficos.drawImage(Imagens.guerreiro, x, y, this);
                            break;
                        case "leao":
                            graficos.drawImage(Imagens.leao, x, y, this);
                            break;
                        case "raposa":
                            graficos.drawImage(Imagens.raposa, x, y, this);
                            break;
                        case "tigre de fogo":
                            graficos.drawImage(Imagens.tigre, x, y, this);
                            break;
                        case "cavalo":
                            graficos.drawImage(Imagens.cavalo, x, y, this);
                            break;
                        case "cobra marinha":
                            graficos.drawImage(Imagens.cobraM, x, y, this);
                            break;
                        case "golfinho":
                            graficos.drawImage(Imagens.golfinho, x, y, this);
                            break;
                        case "peixe pequeno":
                            graficos.drawImage(Imagens.peixeP, x, y, this);
                            break;
                        case "peixe":
                            graficos.drawImage(Imagens.peixe, x, y, this);
                            break;
                        case "sapo":
                            graficos.drawImage(Imagens.sapo, x, y, this);
                            break;
                        case "sereia":
                            graficos.drawImage(Imagens.sereia, x, y, this);
                            break;
                        case "tartaruga":
                            graficos.drawImage(Imagens.tartaruga, x, y, this);
                            break;
                        case "tubarao":
                            graficos.drawImage(Imagens.tubarao, x, y, this);
                            break;
                        case "dragao marinho":
                            graficos.drawImage(Imagens.dragaoM, x, y, this);
                            break;
                        case "jacare":
                            graficos.drawImage(Imagens.jacare, x, y, this);
                            break;
                        case "compra":
                            graficos.drawImage(Imagens.compra, x, y, this);
                            break;
                        case "vida":
                            graficos.drawImage(Imagens.cura, x, y, this);
                            break;
                        case "destruicao":
                            graficos.drawImage(Imagens.destruir, x, y, this);
                            break;
                        case "ataque":
                            graficos.drawImage(Imagens.ataque, x, y, this);
                            break;
                        case "defesa":
                            graficos.drawImage(Imagens.defesa, x, y, this);
                            break;
                        case "dano":
                            graficos.drawImage(Imagens.dano, x, y, this);
                            break;
                        case "equipamento":
                            graficos.drawImage(Imagens.equipamento, x, y, this);
                            break;
                        case "campoF":
                            graficos.drawImage(Imagens.campoF, x, y, this);
                            break;
                        case "campoR":
                            graficos.drawImage(Imagens.campoR, x, y, this);
                            break;
                        case "campoA":
                            graficos.drawImage(Imagens.campoA, x, y, this);
                            break;
                        default:
                            System.out.println("Carta não reconhecida: " + carta);
                            break;
                    }
                    x += 100;
                }
            }
        }

        

        x = 200;
        y = 0;
        for (int i = 0; i < maojogador2.length; i++) {
        	if(turnoJogador2) {
            String carta = maojogador2[i];
            if (carta != null) {
                switch (carta) {
                case "lobo":
                    graficos.drawImage(Imagens.lobo, x, y, this);
                    break;
                case "abelha":
                    graficos.drawImage(Imagens.abelha, x, y, this);
                    break;
                case "aguia":
                    graficos.drawImage(Imagens.aguia, x, y, this);
                    break;
                case "aranha":
                    graficos.drawImage(Imagens.aranha, x, y, this);
                    break;
                case "besouro":
                    graficos.drawImage(Imagens.besouro, x, y, this);
                    break;
                case "cobra":
                    graficos.drawImage(Imagens.cobraR, x, y, this);
                    break;
                case "enguia":
                    graficos.drawImage(Imagens.enguia, x, y, this);
                    break;
                case "dragao relampago":
                    graficos.drawImage(Imagens.dragaoR, x, y, this);
                    break;
                case "tigre":
                    graficos.drawImage(Imagens.tigreR, x, y, this);
                    break;
                case "guerreiro alado":
                    graficos.drawImage(Imagens.guerreiroA, x, y, this);
                    break;
                case "gato":
                    graficos.drawImage(Imagens.gato, x, y, this);
                    break;
                case "cobra de fogo":
                    graficos.drawImage(Imagens.cobraF, x, y, this);
                    break;
                case "coelho":
                    graficos.drawImage(Imagens.coelho, x, y, this);
                    break;
                case "dragao de fogo":
                    graficos.drawImage(Imagens.dragaoF, x, y, this);
                    break;
                case "fenix":
                    graficos.drawImage(Imagens.fenix, x, y, this);
                    break;
                case "guerreiro":
                    graficos.drawImage(Imagens.guerreiro, x, y, this);
                    break;
                case "leao":
                    graficos.drawImage(Imagens.leao, x, y, this);
                    break;
                case "raposa":
                    graficos.drawImage(Imagens.raposa, x, y, this);
                    break;
                case "tigre de fogo":
                    graficos.drawImage(Imagens.tigre, x, y, this);
                    break;
                case "cavalo":
                    graficos.drawImage(Imagens.cavalo, x, y, this);
                    break;
                case "cobra marinha":
                    graficos.drawImage(Imagens.cobraM, x, y, this);
                    break;
                case "golfinho":
                    graficos.drawImage(Imagens.golfinho, x, y, this);
                    break;
                case "peixe pequeno":
                    graficos.drawImage(Imagens.peixeP, x, y, this);
                    break;
                case "peixe":
                    graficos.drawImage(Imagens.peixe, x, y, this);
                    break;
                case "sapo":
                    graficos.drawImage(Imagens.sapo, x, y, this);
                    break;
                case "sereia":
                    graficos.drawImage(Imagens.sereia, x, y, this);
                    break;
                case "tartaruga":
                    graficos.drawImage(Imagens.tartaruga, x, y, this);
                    break;
                case "tubarao":
                    graficos.drawImage(Imagens.tubarao, x, y, this);
                    break;
                case "dragao marinho":
                    graficos.drawImage(Imagens.dragaoM, x, y, this);
                    break;
                case "jacare":
                    graficos.drawImage(Imagens.jacare, x, y, this);
                    break;
                case "compra":
                    graficos.drawImage(Imagens.compra, x, y, this);
                    break;
                case "vida":
                    graficos.drawImage(Imagens.cura, x, y, this);
                    break;
                case "destruicao":
                    graficos.drawImage(Imagens.destruir, x, y, this);
                    break;
                case "ataque":
                    graficos.drawImage(Imagens.ataque, x, y, this);
                    break;
                case "defesa":
                    graficos.drawImage(Imagens.defesa, x, y, this);
                    break;
                case "dano":
                    graficos.drawImage(Imagens.dano, x, y, this);
                    break;
                case "equipamento":
                    graficos.drawImage(Imagens.equipamento, x, y, this);
                    break;
                case "campoF":
                    graficos.drawImage(Imagens.campoF, x, y, this);
                    break;
                case "campoR":
                    graficos.drawImage(Imagens.campoR, x, y, this);
                    break;
                case "campoA":
                    graficos.drawImage(Imagens.campoA, x, y, this);
                    break;
                default:
                    System.out.println("Carta não reconhecida: " + carta);
                    break;
                }
                x += 100;
            }}

            //System.out.println(Arrays.toString(monstros));
            //System.out.println(Arrays.toString(magiasefeiticos));
            //System.out.println(Arrays.toString(monstros));
            //System.out.println(Arrays.toString(monstros));
            //System.out.println(Arrays.toString(monstros2));

            yMonstros = 360;

            for (int iMonstro = 0; iMonstro < monstros.length; iMonstro++) {
                String cartaMonstro = monstros[iMonstro];
                int xMonstros = 392 + (iMonstro * 100);
                if (cartaMonstro != null) {
                    switch (cartaMonstro) {
                    case "lobo":
                        graficos.drawImage(Imagens.lobo, xMonstros, yMonstros, this);
                        break;
                    case "abelha":
                        graficos.drawImage(Imagens.abelha, xMonstros, yMonstros, this);
                        break;
                    case "aguia":
                        graficos.drawImage(Imagens.aguia, xMonstros, yMonstros, this);
                        break;
                    case "aranha":
                        graficos.drawImage(Imagens.aranha, xMonstros, yMonstros, this);
                        break;
                    case "besouro":
                        graficos.drawImage(Imagens.besouro, xMonstros, yMonstros, this);
                        break;
                    case "cobra":
                        graficos.drawImage(Imagens.cobraR, xMonstros, yMonstros, this);
                        break;
                    case "enguia":
                        graficos.drawImage(Imagens.enguia, xMonstros, yMonstros, this);
                        break;
                    case "dragao relampago":
                        graficos.drawImage(Imagens.dragaoR, xMonstros, yMonstros, this);
                        break;
                    case "tigre":
                        graficos.drawImage(Imagens.tigreR, xMonstros, yMonstros, this);
                        break;
                    case "guerreiro alado":
                        graficos.drawImage(Imagens.guerreiroA, xMonstros, yMonstros, this);
                        break;
                    case "gato":
                        graficos.drawImage(Imagens.gato, xMonstros, yMonstros, this);
                        break;
                    case "cobra de fogo":
                        graficos.drawImage(Imagens.cobraF, xMonstros, yMonstros, this);
                        break;
                    case "coelho":
                        graficos.drawImage(Imagens.coelho, xMonstros, yMonstros, this);
                        break;
                    case "dragao de fogo":
                        graficos.drawImage(Imagens.dragaoF, xMonstros, yMonstros, this);
                        break;
                    case "fenix":
                        graficos.drawImage(Imagens.fenix, xMonstros, yMonstros, this);
                        break;
                    case "guerreiro":
                        graficos.drawImage(Imagens.guerreiro, xMonstros, yMonstros, this);
                        break;
                    case "leao":
                        graficos.drawImage(Imagens.leao, xMonstros, yMonstros, this);
                        break;
                    case "raposa":
                        graficos.drawImage(Imagens.raposa, xMonstros, yMonstros, this);
                        break;
                    case "tigre de fogo":
                        graficos.drawImage(Imagens.tigre, xMonstros, yMonstros, this);
                        break;
                    case "cavalo":
                        graficos.drawImage(Imagens.cavalo, xMonstros, yMonstros, this);
                        break;
                    case "cobra marinha":
                        graficos.drawImage(Imagens.cobraM, xMonstros, yMonstros, this);
                        break;
                    case "golfinho":
                        graficos.drawImage(Imagens.golfinho, xMonstros, yMonstros, this);
                        break;
                    case "peixe pequeno":
                        graficos.drawImage(Imagens.peixeP, xMonstros, yMonstros, this);
                        break;
                    case "peixe":
                        graficos.drawImage(Imagens.peixe, xMonstros, yMonstros, this);
                        break;
                    case "sapo":
                        graficos.drawImage(Imagens.sapo, xMonstros, yMonstros, this);
                        break;
                    case "sereia":
                        graficos.drawImage(Imagens.sereia, xMonstros, yMonstros, this);
                        break;
                    case "tartaruga":
                        graficos.drawImage(Imagens.tartaruga, xMonstros, yMonstros, this);
                        break;
                    case "tubarao":
                        graficos.drawImage(Imagens.tubarao, xMonstros, yMonstros, this);
                        break;
                    case "dragao marinho":
                        graficos.drawImage(Imagens.dragaoM, xMonstros, yMonstros, this);
                        break;
                    case "jacare":
                        graficos.drawImage(Imagens.jacare, xMonstros, yMonstros, this);
                        break;
                    }
                }  
            }
            
            int xMagias = 392, yMagias = 475;
            for (int iMagia = 0; iMagia < magiasefeiticos.length; iMagia++) {
                String cartaMagia = magiasefeiticos[iMagia];
                if (cartaMagia != null) {
                    switch (cartaMagia) {
                    case "compra":
                        graficos.drawImage(Imagens.compra, xMagias, yMagias, this);
                        break;
                    case "vida":
                        graficos.drawImage(Imagens.cura, xMagias, yMagias, this);
                        break;
                    case "destruicao":
                        graficos.drawImage(Imagens.destruir, xMagias, yMagias, this);
                        break;
                    case "ataque":
                        graficos.drawImage(Imagens.ataque, xMagias, yMagias, this);
                        break;
                    case "defesa":
                        graficos.drawImage(Imagens.defesa, xMagias, yMagias, this);
                        break;
                    case "dano":
                        graficos.drawImage(Imagens.dano, xMagias, yMagias, this);
                        break;
                    case "equipamento":
                        graficos.drawImage(Imagens.equipamento, xMagias, yMagias, this);
                        break;
                    case "campoF":
                        graficos.drawImage(Imagens.campoF, xMagias, yMagias, this);
                        break;
                    case "campoR":
                        graficos.drawImage(Imagens.campoR, xMagias, yMagias, this);
                        break;
                    case "campoA":
                        graficos.drawImage(Imagens.campoA, xMagias, yMagias, this);
                        break;
                    }
                    xMagias += 100;
                }
            }
            int yMonstros2 = 230;

            for (int iMonstro = 0; iMonstro < monstros2.length; iMonstro++) {
                String cartaMonstro = monstros2[iMonstro];
                int xMonstros2 = 392 + (iMonstro * 100);
                if (cartaMonstro != null) {
                    switch (cartaMonstro) {
                        case "lobo":
                            graficos.drawImage(Imagens.lobo, xMonstros2, yMonstros2, this);
                            break;
                        case "abelha":
                            graficos.drawImage(Imagens.abelha, xMonstros2, yMonstros2, this);
                            break;
                        case "aguia":
                            graficos.drawImage(Imagens.aguia, xMonstros2, yMonstros2, this);
                            break;
                        case "aranha":
                            graficos.drawImage(Imagens.aranha, xMonstros2, yMonstros2, this);
                            break;
                        case "besouro":
                            graficos.drawImage(Imagens.besouro, xMonstros2, yMonstros2, this);
                            break;
                        case "cobra":
                            graficos.drawImage(Imagens.cobraR, xMonstros2, yMonstros2, this);
                            break;
                        case "enguia":
                            graficos.drawImage(Imagens.enguia, xMonstros2, yMonstros2, this);
                            break;
                        case "dragao relampago":
                            graficos.drawImage(Imagens.dragaoR, xMonstros2, yMonstros2, this);
                            break;
                        case "tigre":
                            graficos.drawImage(Imagens.tigreR, xMonstros2, yMonstros2, this);
                            break;
                        case "guerreiro alado":
                            graficos.drawImage(Imagens.guerreiroA, xMonstros2, yMonstros2, this);
                            break;
                        case "gato":
                            graficos.drawImage(Imagens.gato, xMonstros2, yMonstros2, this);
                            break;
                        case "cobra de fogo":
                            graficos.drawImage(Imagens.cobraF, xMonstros2, yMonstros2, this);
                            break;
                        case "coelho":
                            graficos.drawImage(Imagens.coelho, xMonstros2, yMonstros2, this);
                            break;
                        case "dragao de fogo":
                            graficos.drawImage(Imagens.dragaoF, xMonstros2, yMonstros2, this);
                            break;
                        case "fenix":
                            graficos.drawImage(Imagens.fenix, xMonstros2, yMonstros2, this);
                            break;
                        case "guerreiro":
                            graficos.drawImage(Imagens.guerreiro, xMonstros2, yMonstros2, this);
                            break;
                        case "leao":
                            graficos.drawImage(Imagens.leao, xMonstros2, yMonstros2, this);
                            break;
                        case "raposa":
                            graficos.drawImage(Imagens.raposa, xMonstros2, yMonstros2, this);
                            break;
                        case "tigre de fogo":
                            graficos.drawImage(Imagens.tigre, xMonstros2, yMonstros2, this);
                            break;
                        case "cavalo":
                            graficos.drawImage(Imagens.cavalo, xMonstros2, yMonstros2, this);
                            break;
                        case "cobra marinha":
                            graficos.drawImage(Imagens.cobraM, xMonstros2, yMonstros2, this);
                            break;
                        case "golfinho":
                            graficos.drawImage(Imagens.golfinho, xMonstros2, yMonstros2, this);
                            break;
                        case "peixe pequeno":
                            graficos.drawImage(Imagens.peixeP, xMonstros2, yMonstros2, this);
                            break;
                        case "peixe":
                            graficos.drawImage(Imagens.peixe, xMonstros2, yMonstros2, this);
                            break;
                        case "sapo":
                            graficos.drawImage(Imagens.sapo, xMonstros2, yMonstros2, this);
                            break;
                        case "sereia":
                            graficos.drawImage(Imagens.sereia, xMonstros2, yMonstros2, this);
                            break;
                        case "tartaruga":
                            graficos.drawImage(Imagens.tartaruga, xMonstros2, yMonstros2, this);
                            break;
                        case "tubarao":
                            graficos.drawImage(Imagens.tubarao, xMonstros2, yMonstros2, this);
                            break;
                        case "dragao marinho":
                            graficos.drawImage(Imagens.dragaoM, xMonstros2, yMonstros2, this);
                            break;
                        case "jacare":
                            graficos.drawImage(Imagens.jacare, xMonstros2, yMonstros2, this);
                            break;
                    }
                }  
            }
            
            int xMagias2 = 392, yMagias2 = 115;
            for (int iMagia = 0; iMagia < magiasefeiticos2.length; iMagia++) {
                String cartaMagia = magiasefeiticos2[iMagia];
                if (cartaMagia != null) {
                    switch (cartaMagia) {
                        case "compra":
                            graficos.drawImage(Imagens.compra, xMagias2, yMagias2, this);
                            break;
                        case "vida":
                            graficos.drawImage(Imagens.cura, xMagias2, yMagias2, this);
                            break;
                        case "destruicao":
                            graficos.drawImage(Imagens.destruir, xMagias2, yMagias2, this);
                            break;
                        case "ataque":
                            graficos.drawImage(Imagens.ataque, xMagias2, yMagias2, this);
                            break;
                        case "defesa":
                            graficos.drawImage(Imagens.defesa, xMagias2, yMagias2, this);
                            break;
                        case "dano":
                            graficos.drawImage(Imagens.dano, xMagias2, yMagias2, this);
                            break;
                        case "equipamento":
                            graficos.drawImage(Imagens.equipamento, xMagias2, yMagias2, this);
                            break;
                        case "campoF":
                            graficos.drawImage(Imagens.campoF, xMagias2, yMagias2, this);
                            break;
                        case "campoR":
                            graficos.drawImage(Imagens.campoR, xMagias2, yMagias2, this);
                            break;
                        case "campoA":
                            graficos.drawImage(Imagens.campoA, xMagias2, yMagias2, this);
                            break;
                    }
                    xMagias2 += 100;
                }
            }
            
        }
        
        if (mostrarEfeitos) {
            graficos.drawImage(efeitos, 620, 30, this);
        }
        if (mostrarDicas) {
            graficos.drawImage(comojogar, 650, 50, this);
        }
        graficos.setFont(new Font("Arial", Font.BOLD, 20));
        if(textoAtaque) {
        	g.drawString("Escolha o monstro ATACANTE", 20, 350);
        	g.drawString("A  S   D  + ENTER PARA SELECIONAR", 20, 370);
        }
        if(textoDefesa) {
        	g.drawString("Escolha o monstro DEFENSOR", 20, 350);
        	g.drawString("A  S   D  + ENTER PARA SELECIONAR", 20, 370);
        }
        
        if(vencedor1) {
        	graficos.setColor(Color.YELLOW);
            graficos.setFont(new Font("Arial", Font.BOLD, 48));
        	graficos.drawImage(fim, 0, 0, this);
        	g.drawString("Vencedor Jogador1", 330, 500);
        	fecharTela((JFrame) SwingUtilities.getWindowAncestor(this));
        }
        if(vencedor2) {
        	graficos.setColor(Color.YELLOW);
            graficos.setFont(new Font("Arial", Font.BOLD, 48));
        	graficos.drawImage(fim, 0, 0, this);
        	g.drawString("Vencedor Jogador2", 330, 500);
        	fecharTela((JFrame) SwingUtilities.getWindowAncestor(this));
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
        	if (turnoJogador1) {
            if (selecionandoAtacante) {
                if (key == KeyEvent.VK_A && monstros.length > 0 && invocadoAgora1 == false) {
                    monstroSelecionadoAtacante = monstros[0];
                    invocadoAgora1 = true;
                } else if (key == KeyEvent.VK_S && monstros.length > 1 && invocadoAgora2 == false) {
                    monstroSelecionadoAtacante = monstros[1];
                    invocadoAgora2 = true;
                } else if (key == KeyEvent.VK_D && monstros.length > 2 && invocadoAgora3 == false) {
                    monstroSelecionadoAtacante = monstros[2];
                    invocadoAgora3 = true;
                }
                if (monstroSelecionadoAtacante != null && key == KeyEvent.VK_ENTER) {
                    selecionandoAtacante = false;
                    System.out.println("Monstro atacante selecionado: " + monstroSelecionadoAtacante);
                    System.out.println("Selecione o monstro alvo.");
                    textoAtaque = false;
                	textoDefesa = true;
                    if(monstros2[0] == null && monstros2[1] == null && monstros2[2] == null) {
                    	monstroSelecionadoAlvo = "nulo";
                    	System.out.println("Monstro alvo selecionado: " + monstroSelecionadoAlvo);
                    	realizarCombate();
                    	textoDefesa = false;
                    	textoAtaque = true;
                    }
                }
            }
            
            else {
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
        	if (turnoJogador2) {
                if (selecionandoAtacante) {
                    if (key == KeyEvent.VK_A && monstros2.length > 0 && invocadoAgora4 == false) {
                        monstroSelecionadoAtacante = monstros2[0];
                        invocadoAgora4 = true;
                    } else if (key == KeyEvent.VK_S && monstros2.length > 1 && invocadoAgora5 == false) {
                        monstroSelecionadoAtacante = monstros2[1];
                        invocadoAgora5 = true;
                    } else if (key == KeyEvent.VK_D && monstros2.length > 2 && invocadoAgora6 == false) {
                        monstroSelecionadoAtacante = monstros2[2];
                        invocadoAgora6 = true;
                    }
                    if (monstroSelecionadoAtacante != null && key == KeyEvent.VK_ENTER) {
                        selecionandoAtacante = false;
                        System.out.println("Monstro atacante selecionado: " + monstroSelecionadoAtacante);
                        System.out.println("Selecione o monstro alvo.");
                        textoAtaque = false;
                    	textoDefesa = true;
                        if(monstros[0] == null && monstros[1] == null && monstros[2] == null) {
                        	
                        	monstroSelecionadoAlvo = "nulo";
                        	System.out.println("Monstro alvo selecionado: " + monstroSelecionadoAlvo);
                        	realizarCombate();
                        	textoDefesa = false;
                        }
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
                    	textoDefesa = false;
                    	textoAtaque = true;
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
    
    public void fecharTela(JFrame janela) {
        new Thread(() -> {
            try {
                Thread.sleep(5000);
                janela.dispose();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
