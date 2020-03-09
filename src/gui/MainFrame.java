package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JTabbedPane jTab;

    public MainFrame() {
        super("Muhammad Pajar Kharisma Putra");
        setLayout(new FlowLayout());

        jTab = new JTabbedPane();
        add(jTab);
        jTab.add("Encrypt", new EncryptPanel());
        jTab.add("Decrypt", new DecryptPanel());

        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
