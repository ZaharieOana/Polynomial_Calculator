package org.example.View;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame{
    private final JPanel gridPol = new JPanel();
    private final JPanel gridB = new JPanel();
    private final JTextField pol1 = new JTextField();
    private final JTextField pol2 = new JTextField();
    private final JLabel rez = new JLabel();
    private final JPanel panel = new JPanel();
    private final SpringLayout layout = new SpringLayout();
    private final JButton Badd = new JButton("Add");
    private final JButton Bsub = new JButton("Substract");
    private final JButton Bmul = new JButton("Multiplicate");
    private final JButton Bdiv = new JButton("Divide");
    private final JButton Bmod = new JButton("Modulo");
    private final JButton Bder = new JButton("Derivate");
    private final JButton Bint = new JButton("Integrate");
    private final JLabel invalidIn = new JLabel("Invalid input!");
    public Calculator(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon("icon.png").getImage());
        setTitle("Polynomial Calculator");

        panel.setLayout(layout);

        pol1.setFont(new Font("Arial", Font.PLAIN, 15));
        pol2.setFont(new Font("Arial", Font.PLAIN, 15));
        rez.setFont(new Font("Arial", Font.PLAIN, 15));

        gridPol.setLayout(new GridLayout(3, 2, 5, 5));
        gridPol.add(new JLabel("First Polynomial:"));
        gridPol.add(pol1);
        gridPol.add(new JLabel("Second Polynomial:"));
        gridPol.add(pol2);
        gridPol.add(new JLabel("Result:"));
        gridPol.add(rez);
        rez.setBorder(BorderFactory.createLineBorder(Color.black));

        gridB.setLayout(new GridLayout(4, 2, 5, 5));
        gridB.add(Badd);
        gridB.add(Bsub);
        gridB.add(Bmul);
        gridB.add(Bdiv);
        gridB.add(Bmod);
        gridB.add(Bder);
        gridB.add(Bint);

        invalidIn.setFont(new Font("Arial", Font.PLAIN, 15));
        invalidIn.setForeground(Color.red);
        invalidIn.setVisible(false);

        layout.putConstraint(SpringLayout.NORTH, gridPol, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.SOUTH, gridPol, -20, SpringLayout.VERTICAL_CENTER, panel);
        layout.putConstraint(SpringLayout.NORTH, gridB, 20, SpringLayout.SOUTH, invalidIn);
        layout.putConstraint(SpringLayout.SOUTH, gridB, -10, SpringLayout.SOUTH, panel);
        layout.putConstraint(SpringLayout.WEST, gridPol, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, gridB, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.EAST, gridPol, -10, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.EAST, gridB, -10, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, invalidIn, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.NORTH, invalidIn, 20, SpringLayout.SOUTH, gridPol);

        panel.add(gridPol);
        panel.add(gridB);
        panel.add(invalidIn);
        add(panel);
        setVisible(true);
    }

    public JTextField getPol1() {return pol1;}
    public JTextField getPol2() {return pol2;}
    public JButton getBadd() {return Badd;}
    public JButton getBsub() {return Bsub;}
    public JButton getBmul() {return Bmul;}
    public JButton getBdiv() {return Bdiv;}
    public JButton getBmod() {return Bmod;}
    public JButton getBder() {return Bder;}
    public JButton getBint() {return Bint;}
    public JLabel getInvalidIn() {return invalidIn;}
    public void setRez(String r) {rez.setText(r);}
}
