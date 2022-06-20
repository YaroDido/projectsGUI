package GUI8.Zadanie2;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        new Main();

    }

    Main() {
        super("LIST");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextField pole = new JTextField(15);
        JList<String> list = new JList<>();
        JTextArea arena = new JTextArea(10, 15);
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new BorderLayout());
        JScrollPane scrollPane2 = new JScrollPane(arena, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


        panel1.add(scrollPane2, BorderLayout.CENTER);
        panel2.add(pole, BorderLayout.SOUTH);
        add(panel1, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);
        this.setVisible(true);
        pack();

    }
}
