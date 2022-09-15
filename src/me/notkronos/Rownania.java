package me.notkronos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.*;

public class Rownania extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    static int wynik; // procenty
    JButton button;
    JTextField firstQuestion, secondQuestion, thirdQuestion, fourthQuestion;

    JLabel textLabel, t1Label, t2Label, t3, t4, t1Label1, t1Label2;

    public Rownania() {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 550);
        setTitle("ROZWIAZYWANIE ROWNAN czesc I :)");
        setLayout(null);

        t1Label = new JLabel("Ktora z liczb : -3; 0; 2; 0,4; 1 jest rozwiazaniem rownania? :)");
        t1Label.setBounds(30, -10, 390, 80);
        this.add(t1Label);

        t1Label1 = new JLabel("W wyniku mozesz uzyskac taka liczbe, ktora nie jest podana w zbiorze powyzej.* ");
        t1Label1.setBounds(30, 5, 460, 80);
        this.add(t1Label1);

        textLabel = new JLabel("1. a:  --> 3a - 3(2a - 2) = 3(a - 2)");
        textLabel.setBounds(30, 30, 390, 80);
        this.add(textLabel);

        t2Label = new JLabel("1. b: --> 2b - (8 - b) = -2(b - 5)");
        t2Label.setBounds(30, 30, 390, 240);
        this.add(t2Label);

        t3 = new JLabel("1. c: --> -5c + 2(1 - c) = -c - 2(c + 1)");
        t3.setBounds(30, 100, 390, 240);
        this.add(t3);

        t4 = new JLabel("1. d: --> 2d(d - 5) - 4d(2 - d) = -3d(5 - 2d) + 9");
        t4.setBounds(30, 180, 390, 240); 
        this.add(t4);

        button = new JButton("Check");

        this.add(button);
        button.addActionListener(this);
        button.setActionCommand("cmdOK");
        button.setBounds(310, 420, 100, 40);

        firstQuestion = new JTextField();
        firstQuestion.setBounds(130, 90, 90, 30);
        this.add(firstQuestion);

        secondQuestion = new JTextField();
        secondQuestion.setBounds(130, 160, 90, 30);
        this.add(secondQuestion);

        thirdQuestion = new JTextField();
        thirdQuestion.setBounds(130, 240, 90, 30); // bylo 220
        this.add(thirdQuestion);

        fourthQuestion = new JTextField();
        fourthQuestion.setBounds(130, 320, 90, 30); // bylo 280
        this.add(fourthQuestion);

        t1Label2 = new JLabel("*zadna z liczb");
        t1Label2.setBounds(90, 270, 90, 240);
        this.add(t1Label2);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("cmdOK")) {
            try {
                wynik = 0;

                String firstAnswer = firstQuestion.getText();
                String secondAnswer = secondQuestion.getText();
                String thirdAnswer = thirdQuestion.getText();
                String fourthAnswer = fourthQuestion.getText();
                
                String result = "Zapisałeś/Zapisałaś \nrozwiazanie a: " + firstAnswer + "\nrozwiazanie b: " + secondAnswer
                        + "\nc = " + thirdAnswer + " oraz\n d = " + fourthAnswer + "\nTwoj rezultat, to ";
                
                if(Objects.equals(firstAnswer, "2")) { wynik += 25; }
                if(Objects.equals(secondAnswer, "zadna z liczb")) { wynik += 25; }
                if(Objects.equals(thirdAnswer, "1")) { wynik += 25; }
                if(Objects.equals(fourthAnswer, "-3")) { wynik += 25; }

                result += wynik + "%";

                JOptionPane.showMessageDialog(this, result, "INFO o rozwiazaniach rownan___",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException e1) {
                System.err.println("Błąd odczytu");
            }
        }
    }

    public static void main(String[] args) {
        new Rownania();
    }
}
