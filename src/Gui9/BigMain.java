package Gui9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BigMain extends JFrame {
    public static void main(String[] args) {

        new BigMain();
    }

    BigMain() {
        super("PERSON");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();

        JSlider slidarHeight = new JSlider(JSlider.HORIZONTAL, 10, 200, 10);
        slidarHeight.setMinimum(100);
        slidarHeight.setMajorTickSpacing(10);
        slidarHeight.setMinorTickSpacing(40);
        slidarHeight.setPaintTicks(true);
        slidarHeight.setPaintLabels(true);
        slidarHeight.setBorder(BorderFactory.createTitledBorder("Height [cm]"));

        JSlider slidarWeight = new JSlider(JSlider.HORIZONTAL, 10, 120, 10);
        slidarWeight.setMinimum(40);
        slidarWeight.setMajorTickSpacing(10);
        slidarWeight.setMinorTickSpacing(70);
        slidarWeight.setPaintTicks(true);
        slidarWeight.setPaintLabels(true);
        slidarWeight.setBorder(BorderFactory.createTitledBorder("Weight [kg]"));

        DefaultListModel<Person> listModel = new DefaultListModel<>();
        JList<Person> list = new JList<>(listModel);
        list.setCellRenderer(new RedAndGreen());

        JTextField nameFild = new JTextField();

        //String[] tab = {"XS", "S", "M", "XL"};
        JComboBox cmb = new JComboBox(Size.values());

        JLabel name = new JLabel("name:");
        JLabel size = new JLabel("size:");

        JButton guzExit = new JButton("Exit");
        guzExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JButton addPerson = new JButton("Add person");
        addPerson.addActionListener(e -> {
            String namePerson = nameFild.getText();
            String sizePerson = cmb.getSelectedItem().toString();
            int height = slidarHeight.getValue();
            int weight = slidarWeight.getValue();

            Person person = new Person(namePerson, sizePerson, height, weight);
            if (namePerson.isEmpty()){
                JOptionPane.showMessageDialog(null, "Wpisz imię");
        } else {
                listModel.addElement(person);
            }

        });

        JPanel panel1 = new JPanel(new GridLayout());

        JPanel onlySlidars = new JPanel(new GridLayout());
        onlySlidars.setLayout((new BoxLayout(onlySlidars, BoxLayout.PAGE_AXIS)));

        onlySlidars.add(slidarHeight);
        onlySlidars.add(slidarWeight);

        panel1.add(name);
        panel1.add(nameFild);
        panel1.add(size);
        panel1.add(cmb);
        panel1.add(addPerson);
        panel1.add(guzExit);


        add(onlySlidars, BorderLayout.CENTER);
        add(panel1, BorderLayout.SOUTH);
        this.setSize(700, 500);

        JScrollPane scrollPane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        add(scrollPane, BorderLayout.NORTH);

    }

}

class Person {
    private String name;
    private String size;
    private int height;
    private int weight;

    public Person(String name, String size, int height, int weight) {
        this.name = name;
        this.size = size;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    @Override
    public String toString() {
        return name + " (h=" + height + ", w=" + weight + ", size=" + size + ")";
    }
}

enum Size {
    XS,
    S,
    M,
    XL
}

class RedAndGreen extends JPanel implements ListCellRenderer<Person> {

    JLabel colors = new JLabel();

    public RedAndGreen() {
        setLayout(new BorderLayout());
        add(colors, BorderLayout.WEST);
    }

    public Dimension getMinimumSize() {
        return new Dimension(100, 20);
    }

    public Dimension getPreferredSize() {
        return getMinimumSize();
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Person> list, Person value, int index, boolean isSelected, boolean cellHasFocus) {
        setComponentOrientation(list.getComponentOrientation());

        if ( value.getSize() == "XS") {
            setBackground(Color.GREEN);
            setOpaque(true);

        } else if(value.getSize() == "XL") {
            setBackground(Color.RED);
            setOpaque(true);
        } else {

            setBackground(Color.WHITE);
        }

        colors.setText(value.toString());
        return this;
    }
}
