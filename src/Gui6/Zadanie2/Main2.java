package Gui6.Zadanie2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main2 extends JFrame {
    public static void main(String[] args) {

        new Main2();

    }
    Main2(){
        super("WORDS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton back = new JButton("Back");
        JButton show = new JButton("Show text");
        JTextArea arena = new JTextArea(10, 15);


        JPanel panel = new JPanel();
        panel.add(back);
        panel.add(show);

        show.addActionListener(new PoleText2(this, arena));
        back.addActionListener(new PoleSlave(this, arena));


        add(panel, BorderLayout.SOUTH);
        add(arena, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        pack();
        this.setVisible(true);

        back.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back.setEnabled(false);
                show.setEnabled(true);
            }
        }));

        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                show.setEnabled(false);
                back.setEnabled(true);
            }
        });
    }
}
