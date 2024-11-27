import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel implements KeyListener {
    private final int LARGURA = 800;
    private final int ALTURA = 600;
    private boolean jogoRodando = true;

    private Jogador jogador;
    private Bola bola;
    private GerenciadorTijolos gerenciadorTijolos;

    public Game() {
        setPreferredSize(new Dimension(LARGURA, ALTURA));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        jogador = new Jogador(LARGURA / 2 - 50, ALTURA - 50, 100, 10);
        bola = new Bola(LARGURA / 2, ALTURA / 2, 15, -2, -3);
        gerenciadorTijolos = new GerenciadorTijolos(5, 10, 70, 20);
    }

    public void iniciarJogo() {
        Timer timer = new Timer(10, e -> gameLoop());
        timer.start();
    }

    private void gameLoop() {
        if (!jogoRodando) return;

        bola.atualizarPosicao();
        verificarColisoes();
        repaint();
    }

    private void verificarColisoes() {
        // Colisão com paredes
        bola.verificarColisaoParede(LARGURA, ALTURA);

        // Colisão com o jogador
        if (bola.verificarColisaoComRetangulo(jogador.getX(), jogador.getY(), jogador.getLargura(), jogador.getAltura())) {
            bola.inverterDirecaoY();
        }

        // Colisão com tijolos
        if (gerenciadorTijolos.verificarColisaoComBola(bola)) {
            bola.inverterDirecaoY();
        }

        // Verifica se o jogo acabou
        if (bola.getY() > ALTURA) {
            jogoRodando = false;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!jogoRodando) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Game Over", LARGURA / 2 - 90, ALTURA / 2);
            return;
        }

        jogador.desenhar(g);
        bola.desenhar(g);
        gerenciadorTijolos.desenhar(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            jogador.mover(-20);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            jogador.mover(20);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
