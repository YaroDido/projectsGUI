package Gui6.Zadanie3;

import javax.swing.*;
import java.awt.*;

public class Main3 extends JFrame {
    public static void main(String[] args) {

        new Main3();
    }
    Main3() {
        super("BOMBA");
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JPanel panel = new JPanel(new GridLayout(3, 3, 5, 5));
        JPanel panel2 = new JPanel((new GridLayout(3, 1)));
        JPanel panel3 = new JPanel((new GridLayout(2, 1)));
        for(int i = 0; i <= 9; i++) {
            JButton guz = new JButton("B0" + i);
            panel.add(guz);
        }
        for(int i = 0; i <= 2; i++) {
            JTextField fars = new JTextField("Tekst Field" + i);
            panel2.add(fars);
        }
        for(int i = 0; i <=2; i++) {
            JTextPane guz2 = new JTextPane();
            panel3.add(guz2);
        }


        add(panel, BorderLayout.EAST);
        add(panel2, BorderLayout.NORTH);
        add(panel3, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);





    }

}
