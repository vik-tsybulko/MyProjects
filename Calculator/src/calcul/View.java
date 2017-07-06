package calcul;

import javax.swing.*;
import java.awt.*;
import static java.awt.BorderLayout.*;

public class View extends JFrame {

    public static void main(String[] args) {
        new View();
    }

    private JFrame frame;
    public void gui(){

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation();
    }



    //делаем дисплей
    JTextArea display = new JTextArea();

    //делаем панельку по типу решетки
    JPanel buttonPanel = new JPanel(new GridLayout(3,5));

    //делаем кнопки
    JButton knopka0 = new JButton("0");
    JButton knopka1 = new JButton("1");
    JButton knopka2 = new JButton("2");
    JButton knopka3 = new JButton("3");
    JButton knopka4 = new JButton("4");
    JButton knopka5 = new JButton("5");
    JButton knopka6 = new JButton("6");
    JButton knopka7 = new JButton("7");
    JButton knopka8 = new JButton("8");
    JButton knopka9 = new JButton("9");
    JButton knopkaPlus = new JButton("+");
    JButton knopkaMinus = new JButton("-");
    JButton knopkaUmnozhit = new JButton("*");
    JButton knopkaPodelit = new JButton("/");
    JButton KnopkaRavno = new JButton("=");
    JButton KnopkaUbrat = new JButton("C");


    View() {
        setBounds(300,/*положение окна по горизонтали*/ 300,/*положение по вертикали, причем чем больше тем ниже*/ 300, 300/*размеры окна*/);
        frame.add(buttonPanel);
        setLayout(new BorderLayout());
        add(display, NORTH);
        add(buttonPanel, CENTER);
        buttonPanel.add(knopka7);
        buttonPanel.add(knopka8);
        buttonPanel.add(knopka9);
        buttonPanel.add(knopka4);
        buttonPanel.add(knopka5);
        buttonPanel.add(knopka6);
        buttonPanel.add(knopka1);
        buttonPanel.add(knopka2);
        buttonPanel.add(knopka3);
        buttonPanel.add(knopka0);
        buttonPanel.add(knopkaMinus);
        buttonPanel.add(knopkaPlus);
        buttonPanel.add(knopkaPodelit);
        buttonPanel.add(knopkaUmnozhit);
        buttonPanel.add(KnopkaUbrat);
        buttonPanel.add(KnopkaRavno);

        setVisible(true); //делаем что бы окно отображалось
    }
}




