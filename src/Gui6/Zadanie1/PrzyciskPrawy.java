package Gui6.Zadanie1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrzyciskPrawy implements ActionListener {

    JTextField tekst;
    JFrame f;

    public PrzyciskPrawy(JFrame f, JTextField t) {

        this.tekst = t;
        this.f = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        f.setTitle(tekst.getText());
    }
}
