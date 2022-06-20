package Gui6.Zadanie2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PoleText2 implements ActionListener {

    JTextArea tekst;

    JFrame j;

    static String stary;

    public PoleText2(JFrame j, JTextArea tekst){
        this.j = j;
        this.tekst = tekst;



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        List<String> Taras = Arrays.stream(tekst.getText().split("\\P{L}+")).distinct().map(String::toLowerCase).collect(Collectors.toList());
        stary = tekst.getText();
        tekst.selectAll();
        tekst.replaceSelection("");
        for (int i = 0; i < Taras.size(); i++) {
            tekst.append(Taras.get(i));
            tekst.append("\n");
        }

    }
}
