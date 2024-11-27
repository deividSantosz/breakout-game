import javax.swing.*;

class JogoBreakout {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Breakout Game");
        Game tela = new Game();

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
        janela.add(tela);
        janela.pack();
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);

        // Executa o game loop
        tela.iniciarJogo();
    }
}
