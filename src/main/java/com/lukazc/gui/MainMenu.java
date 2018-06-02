package com.lukazc.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.lukazc.Main.chessboard;
import static com.lukazc.Main.main;

public class MainMenu extends JFrame {

    private JButton playButton;
    private JLabel background;

    public MainMenu()

    {

        // Size and display

        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null); // Center window
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Window deleted from memory

        // Initialize Layout

        setLayout(new BorderLayout());

        // Insert image to the background

        setContentPane(new JLabel(new ImageIcon("./././././assets/mainMenu.jpg")));
        setLayout(new FlowLayout());

        // Push button vertically

        add(Box.createVerticalStrut(200));

        // Create background and button, center button

        background = new JLabel("");
        playButton = new JButton("PLAY");
        playButton.setAlignmentX(CENTER_ALIGNMENT);

        // Add ActionListener to change game state on click

        playButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

                // When play button is pressed hide main menu window and show game window

                main.setVisible(false);
                chessboard.setVisible(true);
            }
        });

        // Insert background and button

        add(background);
        add(playButton);

        // Glue the pushing boxes

        add(Box.createVerticalGlue());

        // For constant refresh of the screen

        setSize(499,499);
        setSize(500,500);
    }
}

