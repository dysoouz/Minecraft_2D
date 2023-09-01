import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Janela extends JFrame implements KeyListener {
    private final int size = 400;
    private final int cols = 20;
    private final int rows = 20;
    private  final String steve = "/Resource/steve.png";
    private  final String ceu = "/Resource/ceu.png";
    private  final String flor = "/Resource/flor.png";
    private  final String madeira = "/Resource/tronco.png";
    private  final String folha = "/Resource/folhas.png";
    private  final String terra = "/Resource/bloco_terra.png";
    private  final String grama = "/Resource/bloco_terra_com_grama.png";
    private final  String pedra = "/Resource/bloco_pedra.png";
    private final  String carvao = "/Resource/minerio_de_Carvao.png";
    private final String nuvem = "/Resource/nuvem.png";
    private final String mesa = "/Resource/crafting_table.png";


    private MyPanel myPanel[];
    private int[] tipoBloco;
    private ImageIcon personagem, fundo, bl1, bl2, bl3, bl4, bl5, bl6, bl7, bl8, bl9;
    private int posiPersonagem;
    private String message =" Ao iniciar  o progarma digite \"0\" para criar o mundo\n" +
            "Movimentação:\n-> w - move para cima\n" +
            "-> a - move para esquerda\n" +
            "-> d - move para direita\n" +
            "-> s - move para baixo\n" +
            "Blocos:\n" +
            "-> 1 - flor\n" +
            "-> 2 - madeira\n" +
            "-> 3 - folha\n" +
            "-> 4 - terra\n" +
            "-> 5 - terra com grama\n" +
            "-> 6 - pedra\n" +
            "-> 7 - carão\n" +
            "-> 8 - nuvem\n" +
            "-> 9 - mesa\n" +
            "-> espaço - quebra o bloco";

    public Janela(){
        this.setLayout(new GridLayout(rows, cols));


        personagem = new ImageIcon(getClass().getResource(steve));
        fundo = new ImageIcon(getClass().getResource(ceu));
        bl1 = new ImageIcon(getClass().getResource(flor));
        bl2 = new ImageIcon(getClass().getResource(madeira));
        bl3 = new ImageIcon(getClass().getResource(folha));
        bl4 = new ImageIcon(getClass().getResource(terra));
        bl5 = new ImageIcon(getClass().getResource(grama));
        bl6 = new ImageIcon(getClass().getResource(pedra));
        bl7 = new ImageIcon(getClass().getResource(carvao));
        bl8 = new ImageIcon(getClass().getResource(nuvem));
        bl9 = new ImageIcon(getClass().getResource(mesa));

        tipoBloco = new int[size];
        myPanel = new MyPanel[size];
        for(int i = 0; i < size; i++){
            myPanel[i] = new MyPanel(fundo);
            this.add(myPanel[i]);
        }

        //Posição inicial do Steve
        posiPersonagem = 333;
        myPanel[333].setIcon(personagem);



        this.addKeyListener(this);

        this.setTitle("[ M I N E C R A F T - 2 D ]");
        this.setExtendedState(2);
        this.setVisible(true);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(null,message);
    }

    public ImageIcon getIcon(int tipo){
        switch (tipoBloco[tipo]){
            case 1:
                return bl1;
            case 2:
                return bl2;
            case 3:
                return bl3;
            case 4:
                return bl4;
            case 5:
                return bl5;
            case 6:
                return bl6;
            case 7:
                return bl7;
            case 8:
                return bl8;
            case 9:
                return bl9;
            default:
                return fundo;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //Movimentação
        if ((e.getKeyCode() == KeyEvent.VK_D) || (e.getKeyCode() == KeyEvent.VK_RIGHT)){
            myPanel[posiPersonagem].setIcon(getIcon(posiPersonagem));
            posiPersonagem++;
            if(posiPersonagem > size-1) posiPersonagem = 0;
            myPanel[posiPersonagem].setIcon(personagem);
        }
        if ((e.getKeyCode() == KeyEvent.VK_A) || (e.getKeyCode() == KeyEvent.VK_LEFT)){
            myPanel[posiPersonagem].setIcon(getIcon(posiPersonagem));
            posiPersonagem--;
            if(posiPersonagem < 0) posiPersonagem = size - 1;
            myPanel[posiPersonagem].setIcon(personagem);
        }
        if ((e.getKeyCode() == KeyEvent.VK_S) || (e.getKeyCode() == KeyEvent.VK_DOWN)){
            myPanel[posiPersonagem].setIcon(getIcon(posiPersonagem));
            posiPersonagem+=20;
            if (posiPersonagem > 399) posiPersonagem = posiPersonagem - 399;
            myPanel[posiPersonagem].setIcon(personagem);
        }
        if ((e.getKeyCode() == KeyEvent.VK_W) || (e.getKeyCode() == KeyEvent.VK_UP)){
            myPanel[posiPersonagem].setIcon(getIcon(posiPersonagem));
            posiPersonagem-=20;
            if (posiPersonagem < 0) posiPersonagem = 399 - (Math.abs(posiPersonagem));
            myPanel[posiPersonagem].setIcon(personagem);
        }

        if ((e.getKeyCode() == KeyEvent.VK_NUMPAD0) || (e.getKeyCode() == KeyEvent.VK_0)){
            myPanel[posiPersonagem].setIcon(personagem);
        }

        //Blocos


        if((e.getKeyCode() == KeyEvent.VK_NUMPAD1) || (e.getKeyCode() == KeyEvent.VK_1)){
            myPanel[posiPersonagem].setIcon(bl1);
            tipoBloco[posiPersonagem] = 1;
            e.setKeyCode(KeyEvent.VK_RIGHT);
            keyPressed(e);
        }
        if((e.getKeyCode() == KeyEvent.VK_NUMPAD2) || (e.getKeyCode() == KeyEvent.VK_2)){
            myPanel[posiPersonagem].setIcon(bl2);
            tipoBloco[posiPersonagem] = 2;
            e.setKeyCode(KeyEvent.VK_RIGHT);
            keyPressed(e);
        }
        if((e.getKeyCode() == KeyEvent.VK_NUMPAD3) || (e.getKeyCode() == KeyEvent.VK_3)){
            myPanel[posiPersonagem].setIcon(bl3);
            tipoBloco[posiPersonagem] = 3;
            e.setKeyCode(KeyEvent.VK_RIGHT);
            keyPressed(e);
        }
        if((e.getKeyCode() == KeyEvent.VK_NUMPAD4) || (e.getKeyCode() == KeyEvent.VK_4)){
            myPanel[posiPersonagem].setIcon(bl4);
            tipoBloco[posiPersonagem] = 4;
            e.setKeyCode(KeyEvent.VK_RIGHT);
            keyPressed(e);
        }
        if((e.getKeyCode() == KeyEvent.VK_NUMPAD5) || (e.getKeyCode() == KeyEvent.VK_5)){
            myPanel[posiPersonagem].setIcon(bl5);
            tipoBloco[posiPersonagem] = 5;
            e.setKeyCode(KeyEvent.VK_RIGHT);
            keyPressed(e);
        }
        if((e.getKeyCode() == KeyEvent.VK_NUMPAD6) || (e.getKeyCode() == KeyEvent.VK_6)){
            myPanel[posiPersonagem].setIcon(bl6);
            tipoBloco[posiPersonagem] = 6;
            e.setKeyCode(KeyEvent.VK_RIGHT);
            keyPressed(e);
        }
        if((e.getKeyCode() == KeyEvent.VK_NUMPAD7) || (e.getKeyCode() == KeyEvent.VK_7)){
            myPanel[posiPersonagem].setIcon(bl7);
            tipoBloco[posiPersonagem] = 7;
            e.setKeyCode(KeyEvent.VK_RIGHT);
            keyPressed(e);
        }
        if((e.getKeyCode() == KeyEvent.VK_NUMPAD8) || (e.getKeyCode() == KeyEvent.VK_8)){
            myPanel[posiPersonagem].setIcon(bl8);
            tipoBloco[posiPersonagem] = 8;
            e.setKeyCode(KeyEvent.VK_RIGHT);
            keyPressed(e);
        }
        if((e.getKeyCode() == KeyEvent.VK_NUMPAD9) || (e.getKeyCode() == KeyEvent.VK_9)){
            myPanel[posiPersonagem].setIcon(bl9);
            tipoBloco[posiPersonagem] = 9;
            e.setKeyCode(KeyEvent.VK_RIGHT);
            keyPressed(e);
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            myPanel[posiPersonagem].setIcon(fundo);
            tipoBloco[posiPersonagem] = 0;
            e.setKeyCode(KeyEvent.VK_RIGHT);
            keyPressed(e);
        }

        if((e.getKeyCode() == KeyEvent.VK_NUMPAD0) || (e.getKeyCode() == KeyEvent.VK_0)){
            //Decoração
            //blocos de pedra
            for(int i = 380; i < size; i++){
                myPanel[i].setIcon(bl6);
                tipoBloco[i] = 6;
                myPanel[i].setIcon(getIcon(i));

            }
            //blocos de terra
            for(int i = 360; i < 380; i++){
                myPanel[i].setIcon(bl4);
                tipoBloco[i] = 4;
                myPanel[i].setIcon(getIcon(i));
            }
            //blocos de terra com grama
            for(int i = 340; i < 360; i++){
                myPanel[i].setIcon(bl5);
                tipoBloco[i] = 5;
                myPanel[i].setIcon(getIcon(i));
            }
            //blocos de carvão
            myPanel[395].setIcon(bl7);
            tipoBloco[395] = 7;
            myPanel[395].setIcon(getIcon(395));

            myPanel[396].setIcon(bl7);
            tipoBloco[396] = 7;
            myPanel[396].setIcon(getIcon(396));

            myPanel[375].setIcon(bl7);
            tipoBloco[375] = 7;
            myPanel[375].setIcon(getIcon(375));

            //Flores
            myPanel[334].setIcon(bl1);
            tipoBloco[334] = 1;
            myPanel[334].setIcon(getIcon(334));

            myPanel[322].setIcon(bl1);
            tipoBloco[322] = 1;
            myPanel[322].setIcon(getIcon(322));

            //crafting table
            myPanel[337].setIcon(bl9);
            tipoBloco[337] = 9;
            myPanel[337].setIcon(getIcon(337));

            //Árvore
            for(int i = 324; i > 220; i-=20){
                myPanel[i].setIcon(bl2);
                tipoBloco[i] = 2;
                myPanel[i].setIcon(getIcon(i));
            }
            for(int i = 222; i < 227; i++){
                myPanel[i].setIcon(bl3);
                tipoBloco[i] = 3;
                myPanel[i].setIcon(getIcon(i));

            }
            for(int i = 203; i < 206; i++){
                myPanel[i].setIcon(bl3);
                tipoBloco[i] = 3;
                myPanel[i].setIcon(getIcon(i));
            }
            myPanel[184].setIcon(bl3);
            tipoBloco[184] = 3;
            myPanel[184].setIcon(getIcon(184));

            //Nuvens
            for(int i = 43; i < 47; i++) {
                myPanel[i].setIcon(bl8);
                tipoBloco[i] = 8;
                myPanel[i].setIcon(getIcon(i));
            }
            for(int i = 67; i < 70; i++) {
                myPanel[i].setIcon(bl8);
                tipoBloco[i] = 8;
                myPanel[i].setIcon(getIcon(i));
            }
            for(int i = 53; i < 56; i++) {
                myPanel[i].setIcon(bl8);
                tipoBloco[i] = 8;
                myPanel[i].setIcon(getIcon(i));
            }
            for(int i = 72; i < 77; i++) {
                myPanel[i].setIcon(bl8);
                tipoBloco[i] = 8;
                myPanel[i].setIcon(getIcon(i));
            }
            for(int i = 93; i < 96; i++) {
                myPanel[i].setIcon(bl8);
                tipoBloco[i] = 8;
                myPanel[i].setIcon(getIcon(i));
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
