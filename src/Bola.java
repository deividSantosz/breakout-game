import java.awt.*;

public class Bola {
    private int x, y, tamanho, dx, dy;

    public Bola(int x, int y, int tamanho, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.tamanho = tamanho;
        this.dx = dx;
        this.dy = dy;
    }

    public void atualizarPosicao() {
        x += dx;
        y += dy;
    }

    public void verificarColisaoParede(int largura, int altura) {
        if (x <= 0 || x >= largura - tamanho) dx = -dx;
        if (y <= 0) dy = -dy;
    }

    public boolean verificarColisaoComRetangulo(int rx, int ry, int largura, int altura) {
        return x + tamanho >= rx && x <= rx + largura && y + tamanho >= ry && y <= ry + altura;
    }

    public void inverterDirecaoY() {
        dy = -dy;
    }

    public void desenhar(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, tamanho, tamanho);
    }

    public int getY() {
        return y;
    }
}
