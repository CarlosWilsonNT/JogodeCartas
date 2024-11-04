package jogodecartas;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import jogodecartas.Modelo.deckplayer1;
import jogodecartas.Modelo.deckplayer2;
import jogodecartas.Modelo.duelo;

public class Conteiner extends JFrame {

    private deckplayer1 deck1Panel;
    private deckplayer2 deck2Panel;
    private duelo dueloPanel;
    private JScrollPane scrollPane;

    public Conteiner() {
        deck1Panel = new deckplayer1();

        scrollPane = new JScrollPane(deck1Panel);
        add(scrollPane);

        setTitle("Arcana");
        setSize(1080, 728);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        setVisible(true);
    }

    public void irPraraDeck2() {
        remove(scrollPane);
        deck2Panel = new deckplayer2();
        scrollPane = new JScrollPane(deck2Panel);
        add(scrollPane);
        revalidate();
        repaint();

        deck2Panel.requestFocusInWindow();
    }
    
    public void irPraraDuelo() {
        remove(scrollPane);
        dueloPanel = new duelo(deck1Panel.getDeck1(), deck2Panel.getDeck2());
        scrollPane = new JScrollPane(dueloPanel);
        add(scrollPane);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        new Conteiner();
    }
}
