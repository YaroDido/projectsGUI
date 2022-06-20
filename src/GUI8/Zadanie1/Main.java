package GUI8.Zadanie1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main extends JFrame {
    public static void main(String[] args) {
        new Main();
    }

        Main() {
            super("FileViewer");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            JLabel label = new JLabel();
            JButton selectGuzik = new JButton("Select file");
            JButton ExitGuzik = new JButton("Exit");
            JTextArea area = new JTextArea();


            JPanel panel1 = new JPanel(new FlowLayout());
            panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
            JPanel panel2 = new JPanel();
            JPanel panel3 = new JPanel();
            JScrollPane scrollPane = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


            selectGuzik.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setAcceptAllFileFilterUsed(false);
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files (.txt)", "txt", ".txt");
                    fileChooser.addChoosableFileFilter(filter);

                    int checkInput = fileChooser.showOpenDialog(null);


                    if (checkInput == JFileChooser.APPROVE_OPTION) {
                        File openedFile = fileChooser.getSelectedFile();

                        BufferedReader bufferedReader = null;
                        try {
                            FileReader fileReader = new FileReader(openedFile);
                            bufferedReader = new BufferedReader(fileReader);
                            area.read(bufferedReader, openedFile);
                        } catch (IOException a) {
                            a.printStackTrace();
                        }
                        label.setText(openedFile.getName());

                    }

                    area.setCaretPosition(area.getDocument().getLength());


                }
            });
            ExitGuzik.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            panel1.add(scrollPane);
            panel2.add(selectGuzik);
            panel2.add(ExitGuzik);
            panel3.add(label);

            add(scrollPane, BorderLayout.CENTER);
            add(panel2, BorderLayout.SOUTH);
            add(panel3, BorderLayout.NORTH);
            pack();
            this.setSize(700, 500);
            this.setVisible(true);

        }
    }
//
//        JFrame jFrame = new JFrame();
//
//        JButton jButton = new JButton("Open Txt");
//        jButton.setBounds(200, 20, 100, 30);
//
//        JTextArea area = new JTextArea();
//
//        JLabel jLabel = new JLabel("File Viewer");
//        jLabel.setBounds(10, 60, 400, 400);
//
//        jButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JFileChooser jFileChooser = new JFileChooser();
//                jFileChooser.setAcceptAllFileFilterUsed(false);
//                FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("Txt", "txt", ".txt");
//                jFileChooser.addChoosableFileFilter(fileNameExtensionFilter);
//
//                int checkInput = jFileChooser.showOpenDialog(null);
//
//                if (checkInput == JFileChooser.APPROVE_OPTION) {
//                    File openedFile = jFileChooser.getSelectedFile();
//
//                    BufferedReader bufferedReader = null;
//                    try {
//                        FileReader fileReader = new FileReader(openedFile);
//                        bufferedReader = new BufferedReader(fileReader);
//                        area.read(bufferedReader, openedFile);
//                    } catch (IOException a) {
//                        a.printStackTrace();
//                    }
//                    jLabel.setText(openedFile.getName());
//
//                }
//
//            }
//        });
//
//        jFrame.add(jButton);
//        jFrame.add(jLabel);
//
//        jFrame.setSize(500, 500);
//        jFrame.setLayout(null);
//        jFrame.setVisible(true);
//
//    }
//
//}
