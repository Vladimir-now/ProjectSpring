package ru.geekbrains.homework8;

import javax.swing.*;
import java.awt.*;

public class NewWindow extends JFrame {
    private String fullName;
    private String age;
    private String workplace;
    private String position;

    public NewWindow(String fullName, String age, String workplace, String position ) {
        this.fullName = fullName;
        this.age = age;
        this.workplace = workplace;
        this.position = position;

        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setBounds(450, 150, 300, 400);
        setVisible(true);
        JLabel label = new JLabel("Анкета пользователя.");
        label.setFont(new Font("Serif", Font.BOLD, 20));
        JLabel label1 = new JLabel("Фамилия Имя Отчество");
        JLabel label2 = new JLabel(fullName);
        label2.setFont(new Font("", Font.PLAIN, 12));
        JLabel label3 = new JLabel("Возраст: ");
        JLabel label4 = new JLabel(age);
        label4.setFont(new Font("", Font.PLAIN, 12));
        JLabel label5 = new JLabel("Место работы: ");
        JLabel label6 = new JLabel(workplace);
        label6.setFont(new Font("", Font.PLAIN, 12));
        JLabel label7 = new JLabel("Должность: ");
        JLabel label8 = new JLabel(position);
        label8.setFont(new Font("", Font.PLAIN, 12));

        //Добавляем полученные данные в окно
        JPanel panel = new JPanel(new GridLayout(9,1));
        panel.add(label);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);
        add(panel,BorderLayout.PAGE_START);

    }
}
