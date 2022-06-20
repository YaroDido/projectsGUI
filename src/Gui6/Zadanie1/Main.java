package Gui6.Zadanie1;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main extends JFrame {
    public static void main(String[] args) {

        new Main();
    }
    Main(){
        super("Paris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton lewy = new JButton("Warsaw");
        JButton prawy = new JButton("Change title...");

        JTextField txt = new JTextField(10);

        JPanel panel = new JPanel();
        panel.add(lewy);
        panel.add(prawy);
        panel.add(txt);

        add(panel);
        setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);

        lewy.addActionListener(e ->txt.setText(lewy.getText()));
        prawy.addActionListener(e ->System.out.println("Tekst"));

        //prawy.addActionListener(e ->super.setTitle(txt.getText()));
        prawy.addActionListener(new PrzyciskPrawy(this, txt));


        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    lewy.setText(txt.getText());
                }
            }
        });
    }
}
