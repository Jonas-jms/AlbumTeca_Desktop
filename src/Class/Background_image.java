package Class;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class Background_image extends JPanel
{
  private Image img;

  public Background_image(Image img) //Recebe como parâmetro uma imagem quando chamada
  {
    this.img = img;
    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null)); //O tamanho da tela é definido a partir da resolução da imagem
    setPreferredSize(size); //Definição do tamanho da janela pelo size recebido anteriormente pela resolução da imagem
    setSize(size); //Definição do tamanho da janela pelo size recebido anteriormente pela resolução da imagem
  }

  public void paintComponent(Graphics g)
  { g.drawImage(img, 0, 0, null); } //A imagem é desenhada na tela pela função paintComponent
}