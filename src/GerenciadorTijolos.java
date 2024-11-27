import java.awt.*;

public class GerenciadorTijolos {
    private int[][] tijolos;
    private int largura, altura;

    public GerenciadorTijolos(int linhas, int colunas, int largura, int altura) {
        tijolos = new int[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                tijolos[i][j] = 1;
            }
        }
        this.largura = largura;
        this.altura = altura;
    }

    public boolean verificarColisaoComBola(Bola bola) {
        for (int i = 0; i < tijolos.length; i++) {
            for (int j = 0; j < tijolos[i].length; j++) {
                if (tijolos[i][j] > 0) {
                    int tijoloX = j * largura + 50;
                    int tijoloY = i * altura + 30;

                    if (bola.verificarColisaoComRetangulo(tijoloX, tijoloY, largura, altura)) {
                        tijolos[i][j] = 0;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void desenhar(Graphics g) {
        g.setColor(Color.GREEN);
        for (int i = 0; i < tijolos.length; i++) {
            for (int j = 0; j < tijolos[i].length; j++) {
                if (tijolos[i][j] > 0) {
                    int x = j * largura + 50;
                    int y = i * altura + 30;
                    g.fillRect(x, y, largura, altura);
                    g.setColor(Color.BLACK);
                    g.drawRect(x, y, largura, altura);
                    g.setColor(Color.GREEN);
                }
            }
        }
    }

    // Verifica se todos os tijolos foram destruídos
    public boolean todosTijolosDestruídos() {
        for (int i = 0; i < tijolos.length; i++) {
            for (int j = 0; j < tijolos[i].length; j++) {
                if (tijolos[i][j] > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
