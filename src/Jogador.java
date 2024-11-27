import java.awt.*;

public class Jogador {
    private int x, y, largura, altura;

    public Jogador(int x, int y, int largura, int altura) {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
    }

    public void mover(int dx) {
        x += dx;
        if (x < 0) x = 0;
        if (x + largura > 800) x = 800 - largura; // Limite da tela
    }

    public void desenhar(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, largura, altura);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }
}
