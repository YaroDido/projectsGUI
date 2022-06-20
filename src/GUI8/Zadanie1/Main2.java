package GUI8.Zadanie1;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main2 extends JFrame {
    public static void main(String[] args) {
        new Main2();
    }
    static boolean suspended = true;
    static boolean suspended2 = true;
    Object lock1 = new Object();
    Object lock2 = new Object();



    Main2() {

        super("BOMBA");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        final DateFormat dateFormat = new SimpleDateFormat("EEE MMM d -> HH:mm:ss");

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Zamknąć?", "Potwierdzenie", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                } else if (result == JOptionPane.NO_OPTION) {
                    System.out.println("Still Running");
                }

            }
        });

    JToggleButton guz1 = new JToggleButton("Go");
    JToggleButton guz2 = new JToggleButton("Go");
    JTextArea area1 = new JTextArea();
    JTextArea area2 = new JTextArea();

    JPanel panel1 = new JPanel(new GridLayout(1, 2, 5, 5));
    JPanel panel2 = new JPanel(new GridLayout(1, 2, 5, 5));
    JScrollPane scrollPane1 = new JScrollPane(area1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    JScrollPane scrollPane2 = new JScrollPane(area2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    panel1.setBorder(new EmptyBorder(5, 5, 5 ,5));
    panel2.setBorder(new EmptyBorder(5, 5, 5 ,5));
    panel1.setPreferredSize(new Dimension(700, 50));

    panel1.add(guz1);
    panel1.add(guz2);
    panel2.add(scrollPane1);
    panel2.add(scrollPane2);
    add(panel2, BorderLayout.CENTER);
    add(panel1, BorderLayout.SOUTH);
    pack();
    this.setSize(700, 500);
    this.setVisible(true);

    guz1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean selected = guz1.getModel().isSelected();
            if (selected) {
                suspended = false;
                guz1.setText("Suspend");
                synchronized (lock1) {
                    lock1.notify();
                    }
                } else {
                guz1.setText("GO");
                suspended = true;
            }

            }
    });

    guz2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean selected2 = guz2.getModel().isSelected();
            if (selected2) {
                System.out.println("Dupa");
                suspended2 = false;
                guz2.setText("Nani");
                synchronized (lock2) {
                    lock2.notify();
                }
            } else {
                guz2.setText("GO");
                suspended2 = true;
            }

        }
    });

    Thread czas1 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                Calendar now = Calendar.getInstance();
                int random = (int)(Math.random() * (1500 - 500) + 500);

                SwingUtilities.invokeLater(() -> area1.append(dateFormat.format(now.getTime()) + "\n"));

                try {
                    Thread.sleep(random);
                    synchronized (lock1) {
                        while (suspended) {
                            lock1.wait();
                        }
                    }
                } catch (InterruptedException e) {

                }
            }

        }
    });

    Thread czas2 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                Calendar now = Calendar.getInstance();
                int random = (int)(Math.random() * (1500 - 500) + 500);

                SwingUtilities.invokeLater(() -> area2.append(dateFormat.format(now.getTime()) + "\n"));

                try {
                    Thread.sleep(random);
                    synchronized (lock2) {
                        while (suspended2) {
                            lock2.wait();
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    czas1.start();
    czas2.start();

    }
}
