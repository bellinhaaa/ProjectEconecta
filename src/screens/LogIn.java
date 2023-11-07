package screens;

import classes.User;
import file.ReadWriteObjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogIn extends JFrame {
    private JLabel emailjl, passwordjl;
    private JTextField emailjtf;
    private JPasswordField passwordjpf;
    private JButton logInjb, signjb;
    private List<User> users = new ArrayList<User>();
    private Font customFont;

    //constructor
    public LogIn(String title) throws HeadlessException {
        super(title);
        setSize(360, 640);
        setLayout(null);
        getContentPane().setBackground(new Color(247, 243, 234));
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("src/img/icon.png");
        setIconImage(icon.getImage());
        fileReading();
        startComponents();
        createEvents();

        try {
            //upload a font
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/font/Quicksand.ttf")).deriveFont(Font.BOLD, 20f);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            //in case of an error when loading the font, use a standard font
            customFont = new Font("Arial", Font.PLAIN, 12);
        }
    }

    //method to read the file
    private void fileReading() {
        File file = new File("User.bin");
        if (!file.exists() || file.length() == 0) {
            users = new ArrayList<>();
            return;
        }
        ReadWriteObjects reading = new ReadWriteObjects("User.bin");
        users = reading.rreadObjects();
    }

    //method to initialize components
    private void startComponents() {
        emailjl = new JLabel("Login:");
        emailjl.setFont(customFont);
        emailjl.setForeground(new Color(40,115,121));
        emailjl.setBounds(80, 140, 200, 30);

        emailjtf = new JTextField();
        emailjtf.setBounds(80, 180, 200, 30);
        emailjtf.setToolTipText("Enter your e-mail");

        passwordjl = new JLabel("Password:");
        passwordjl.setFont(customFont);
        passwordjl.setForeground(new Color(40,115,121));
        passwordjl.setBounds(80, 220, 200, 30);

        passwordjpf = new JPasswordField();
        passwordjpf.setBounds(80, 260, 200, 30);
        passwordjpf.setToolTipText("Enter your password");

        logInjb = new JButton("Log In");
        logInjb.setFont(customFont);
        logInjb.setForeground(new Color(247, 243, 234));
        logInjb.setBackground(new Color(255,151,0));
        logInjb.setBounds(120, 320, 120, 40);

        signjb = new JButton("Sign Up");
        signjb.setFont(customFont);
        signjb.setForeground(new Color(247, 243, 234));
        signjb.setBackground(new Color(255,151,0));
        signjb.setBounds(120, 390, 120, 40);

        //add
        add(emailjl);
        add(emailjtf);
        add(passwordjl);
        add(passwordjpf);
        add(logInjb);
        add(signjb);
    }

    //method for crating events
    private void createEvents() {
        //define the event for the Sign-Up button (registration)
        signjb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUp signUp = new SignUp("Sign Up", users);
                signUp.setVisible(true);
            }
        });

        //define the event for the Log-In button (login)
        logInjb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredEmail = emailjtf.getText();
                String enteredPassword = String.valueOf(passwordjpf.getPassword());

                if (enteredEmail.isEmpty() || enteredPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter both email and password",
                            "Error", JOptionPane.WARNING_MESSAGE);
                    return;  //early return if the fields are not filled
                }

                boolean loggedIn = false;

                for (User user : users) {
                    if (user.getEmail().equals(enteredEmail) && user.getPassword().equals(enteredPassword)) {
                        Home home = new Home("Home", user);
                        home.setVisible(true);
                        setVisible(false);
                        loggedIn = true;
                        break;
                    }
                }

                if (!loggedIn) {
                    JOptionPane.showMessageDialog(null, "Invalid email or password",
                            "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    //method main
    public static void main(String[] args) {
        LogIn logIn = new LogIn("Log In");
        logIn.setVisible(true);
    }
}
