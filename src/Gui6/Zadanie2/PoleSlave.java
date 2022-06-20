package Gui6.Zadanie2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PoleSlave implements ActionListener {

    JFrame f;
    JTextArea tekst;


    public PoleSlave(JFrame f, JTextArea tekst) {
        this.f = f;
        this.tekst = tekst;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        tekst.selectAll();
        tekst.replaceSelection("");
        tekst.setText(PoleText2.stary);

    }
}
