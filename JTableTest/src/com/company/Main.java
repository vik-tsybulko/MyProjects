package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("FRAME");
        frame.setSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());

        JButton addButton = new JButton("ADD");
        JButton delButton = new JButton("DEL");
        JButton clearButton = new JButton("CLEAR");

        ConnectionDB connect = new ConnectionDB();
        connect.init("src/com.company/4.3sdb");
        connect.sqlQuery("INSERT INTO USER VALUES (1, 'title1', 1245, 'descript1')");
        connect.sqlQuery("INSERT INTO USER VALUES (2, 'title2', 124543, 'descript2')");






        BookTableModel bookTableModel = new BookTableModel();

        JTable bookTable = new JTable(bookTableModel);
        JScrollPane bookTableScroll = new JScrollPane(bookTable);
        bookTableScroll.setPreferredSize(new Dimension(400, 400));

        bookTableModel.addData(connect);

        String[] str = new String[4];
        str[0] = "0";
        str[1] = "Nazvanie";
        str[2] = "55565";
        str[3] = "opisanie";

        for (int i = 0; i < 100; i++) {
            bookTableModel.addData(str);
        }



        frame.add(bookTableScroll, new GridBagConstraints(0, 0, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));

        frame.add(addButton, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 0, 0));

        frame.add(delButton, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 0, 0));

        frame.add(clearButton, new GridBagConstraints(2, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 0, 0));


        frame.setVisible(true);
        frame.pack();
    }
}
