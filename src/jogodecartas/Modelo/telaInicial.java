package jogodecartas.Modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class telaInicial extends JPanel {

    private Image fundo;
    private Image borda;
    private JButton iniciar;
    private boolean duelo = false;

    public telaInicial() {
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setLayout(null);
        
        ImageIcon referencia = new ImageIcon("banco_i/telainicial.png");
        fundo = referencia.getImage();
        
        ImageIcon bordarefe= new ImageIcon("banco_i/borda.png");
        borda = bordarefe.getImage();
        
        iniciar = new JButton("");
        iniciar.setBounds(440, 375, 200, 140);
        iniciar.setOpaque(false);
        iniciar.setContentAreaFilled(false);
        iniciar.setBorderPainted(false);

        add(iniciar);

        iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	duelo = !duelo;
            }
        });
    }
    public JButton getIniciarButton() {
        return iniciar;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, getWidth(), getHeight(), this);
        if(duelo = true) {
        graficos.drawImage(borda, 420, 335, this);
        }
    }
}
