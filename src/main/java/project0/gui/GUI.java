package project0.gui;

import project0.exec.ApacheExec;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    public GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton start = new JButton("Start");
        start.setSize(100, 50);
        start.addActionListener(e -> startProcess());
        add(start);

        JButton stop = new JButton("Stop");
        stop.setSize(100, 50);
        stop.addActionListener(e -> stopProcess());
        add(stop);

        setSize(100, 100);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void startProcess() {
        ApacheExec.startExec();
    }

    private void stopProcess() {
        ApacheExec.stopExec();
    }

    public static GUI initialize() {
        return new GUI();
    }
}
