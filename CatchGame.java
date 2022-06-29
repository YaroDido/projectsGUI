package ZadanieDomowe6;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.*;

public class CatchGame extends JPanel implements ActionListener, Runnable, MouseListener {

    public static final int WINDOW_WIDTH = 400;
    public static final int WINDOW_HEIGHT = 500;
    private final double TIME_LIMIT = 30*1000; //MS
    private double time = 0;
    private JTextArea tekst;
    private int score = 0;

    private LinkedList<Squares> squreList = new LinkedList<>();

    public CatchGame() {

        for (int i = 0; i < 25; i++) {
            squreList.add(new Squares());
        }
    }

    public void paint(Graphics graphics) {

        graphics.setColor(new Color(0xFFD500));
        graphics.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        for (Squares SquareArray : squreList) {
            SquareArray.paint(graphics);
        }
    }

    public void update() {

        for (Squares SquareArray : squreList) SquareArray.update();
        tekst.setText(Integer.toString(score));
    }

    public static void main(String[] args) throws InterruptedException {

        CatchGame game = new CatchGame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("SCORE"));
        panel.setMinimumSize(new Dimension(10,10));
        game.tekst = new JTextArea("0");
        game.tekst.setEditable(false);
        game.addMouseListener(game);
        panel.add(game.tekst);

        JFrame frame = new JFrame();
        frame.setTitle("Click on Squares");
        frame.add(game);
        frame.add(panel, BorderLayout.PAGE_END);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        while (game.time <= game.TIME_LIMIT) {
            game.update();
            game.repaint();
            Thread.sleep(30);
            game.time += 30;
        }
        String info = new String();
        if (game.score >= 20) {
            info = "You WIN!";
        } else {
            info = "You LOOS!";
        }
        JOptionPane.showMessageDialog(game, info);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        for(int i=0; i<squreList.size(); i++) {
            Squares s = squreList.get(i);
            if ((mouseX >= s.getSquareX() ) && (mouseX <= s.getSquareX() + s.getSWidth() ) && (mouseY >= s.getSquareY()) && (mouseY <= s.getSquareY() + s.getSHeight())) {
                squreList.remove(s);
                score++;
            }
        }
        //System.out.println("X: " + mouseX + " Y: " + mouseY);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void run() {

    }
}

class Squares extends JPanel {

    private int XLocation;
    private int YLocation = -50;
    private int fallSpeed = 1;
    Random rand = new Random();


    public int getSquareX() {
        return XLocation;
    }
    public int getSquareY() {
        return YLocation;
    }
    public int getSWidth(){
        return 50;
    }
    public int getSHeight(){
        return 50;
    }

    public int generateRandomXLocation(){

        return XLocation = rand.nextInt(CatchGame.WINDOW_WIDTH - 45);
    }

    public int generateRandomFallSpeed(){
        return fallSpeed = rand.ints(1, 1, 10).findFirst().getAsInt();
    }

    public void paint(Graphics g){
        g.setColor(new Color(38, 38, 218));
        g.fillRect(XLocation, YLocation,50,50);
    }

    public Squares(){
        generateRandomXLocation();
        generateRandomFallSpeed();
    }

    public void update(){

        if(YLocation >= CatchGame.WINDOW_HEIGHT){
            generateRandomXLocation();
            generateRandomFallSpeed();
            YLocation = -55;
        }

        if(YLocation <= CatchGame.WINDOW_HEIGHT){
            YLocation += fallSpeed;
        }
    }


}
