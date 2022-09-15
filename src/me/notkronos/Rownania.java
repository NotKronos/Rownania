package me.notkronos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import java.util.Objects;


import javax.swing.*;

public class Rownania extends JFrame implements ActionListener {

    @Serial
    private static final long serialVersionUID = 1L;

    static int score; // procenty
    JButton button;
    JTextField firstQuestion, secondQuestion, thirdQuestion, fourthQuestion;

    JLabel fQuestionContent, task, sQuestionContent, tQuestionContent, foQuestionContent, noneOfTheNumbers, t1Label2;

    public Rownania() {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 550);
        setTitle("ROZWIAZYWANIE ROWNAN czesc I");
        setLayout(null);

        task = new JLabel("Ktora z liczb : -3; 0; 2; 0,4; 1 jest rozwiazaniem rownania?");
        task.setBounds(30, -10, 390, 80);
        this.add(task);

        noneOfTheNumbers = new JLabel("Jesli liczba nie nazlezy do zbioru nalezy wpisac \"Zadna z liczb\"");
        noneOfTheNumbers.setBounds(30, 5, 460, 80);
        this.add(noneOfTheNumbers);

        fQuestionContent = new JLabel("1. a:  --> 3a - 3(2a - 2) = 3(a - 2)");
        fQuestionContent.setBounds(30, 30, 390, 80);
        this.add(fQuestionContent);

        sQuestionContent = new JLabel("1. b: --> 2b - (8 - b) = -2(b - 5)");
        sQuestionContent.setBounds(30, 30, 390, 240);
        this.add(sQuestionContent);

        tQuestionContent = new JLabel("1. c: --> -5c + 2(1 - c) = -c - 2(c + 1)");
        tQuestionContent.setBounds(30, 100, 390, 240);
        this.add(tQuestionContent);

        foQuestionContent = new JLabel("1. d: --> 2d(d - 5) - 4d(2 - d) = -3d(5 - 2d) + 9");
        foQuestionContent.setBounds(30, 180, 390, 240);
        this.add(foQuestionContent);

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
                score = 0;

                String firstAnswer = firstQuestion.getText();
                String secondAnswer = secondQuestion.getText();
                String thirdAnswer = thirdQuestion.getText();
                String fourthAnswer = fourthQuestion.getText();
                
                String result = "Zapisałeś/Zapisałaś \nrozwiazanie a: " + firstAnswer + "\nrozwiazanie b: " + secondAnswer
                        + "\nc = " + thirdAnswer + " oraz\n d = " + fourthAnswer + "\nTwoj rezultat, to ";
                
                if(Objects.equals(Integer.parseInt(firstAnswer), 2)) { score += 25; }
                if(Objects.equals(secondAnswer.toUpperCase(), "ZADNA Z LICZB")) { score += 25; }
                if(Objects.equals(Integer.parseInt(thirdAnswer), 1)) { score += 25; }
                if(Objects.equals(Integer.parseInt(fourthAnswer), -3)) { score += 25; }

                result += score + "%";

                JOptionPane.showMessageDialog(this, result, "INFO o rozwiazaniach rownan___",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException exception) {
                System.err.println("Błąd odczytu");
            }
        }
    }
    public static void main(String[] args) { new Rownania(); }
}
