package ru.geekbrains.homework8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {

    public MyWindow() {
        setTitle("Form");
        setBounds(400, 100, 300,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Заголовок формы
        JLabel label = new JLabel("Заполните анкету");
        label.setFont(new Font("Serif", Font.BOLD, 20));

        // Заголовки полей
        JLabel fullName = new JLabel("ФИО: ");
        JLabel age = new JLabel("Возраст: ");
        JLabel workplace = new JLabel("Место работы: ");
        JLabel position = new JLabel("Должность: ");

        // Однострочное текстовое поле под каждый заголовок
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        JTextField field3 = new JTextField();
        JTextField field4 = new JTextField();


        // Создание формы
        JPanel formPanel = new JPanel(new GridLayout(9,1));
        formPanel.add(label);
        formPanel.add(fullName);
        formPanel.add(field1);
        formPanel.add(age);
        formPanel.add(field2);
        formPanel.add(workplace);
        formPanel.add(field3);
        formPanel.add(position);
        formPanel.add(field4);
        add(formPanel,BorderLayout.PAGE_START);

        JButton btn1 = new JButton("Create form");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewWindow(field1.getText(), field2.getText(), field3.getText(), field4.getText());
            }
        });
        JButton btn2 = new JButton("Exit");
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JPanel btnPanel = new JPanel(new GridLayout(1,2));
        btnPanel.add(btn1);
        btnPanel.add(btn2);
        add(btnPanel, BorderLayout.PAGE_END);
        setVisible(true);
    }
}