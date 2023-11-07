package screens;

import classes.User;
import file.ReadWriteObjects;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class SignUp extends JFrame {
    //declaration of graphic components
    private JLabel emailjl, namejl, cepjl, genrejl, birthDatejl, cpfjl, passwordjl, checkPassjl;
    private JTextField emailjtf, namejtf;
    private JFormattedTextField cpfjft, birthDatejft, cepjft;
    private JPasswordField passwordjpf, checkPassjpf;
    private JComboBox<String> genreComboBox;
    private JButton signUpjb;
    private List<User> users;
    private Font customFont;

    //constructor
    public SignUp(String title, List<User> users) throws HeadlessException {
        super(title);
        this.users = users;
        setSize(360, 640);
        setLayout(null);
        getContentPane().setBackground(new Color(40,115,121));
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("src/img/icon.png");
        setIconImage(icon.getImage());

        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/font/Quicksand.ttf")).deriveFont(Font.BOLD, 13f);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            customFont = new Font("Arial", Font.PLAIN, 12);
        }

        startComponents();
        createEvents();
    }

    private void startComponents() {
        ImageIcon logoSign = new ImageIcon("src/img/logoSignUp.png");
        JLabel logoSignjl = new JLabel(logoSign);
        logoSignjl.setBounds(90, 20, 180, 65);
        add(logoSignjl);

        try {
            emailjl = new JLabel("E-mail:");
            emailjl.setBounds(50, 100, 100, 30);
            emailjl.setFont(customFont);
            emailjl.setForeground(new Color(247, 243, 234));

            emailjtf = new JTextField();
            emailjtf.setBounds(160, 100, 150, 30);
            emailjl.setForeground(new Color(247, 243, 234));

            namejl = new JLabel("Name:");
            namejl.setBounds(50, 150, 100, 30);
            namejl.setFont(customFont);
            namejl.setForeground(new Color(247, 243, 234));

            namejtf = new JTextField();
            namejtf.setBounds(160, 150, 150, 30);

            cepjl = new JLabel("CEP:");
            cepjl.setBounds(50, 200, 100, 30);
            cepjl.setFont(customFont);
            cepjl.setForeground(new Color(247, 243, 234));

            MaskFormatter maskcep = new MaskFormatter("#####-###");
            cepjft = new JFormattedTextField(maskcep);
            cepjft.setBounds(160, 200, 150, 30);

            genrejl = new JLabel("Genre:");
            genrejl.setBounds(50, 250, 100, 30);
            genrejl.setFont(customFont);
            genrejl.setForeground(new Color(247, 243, 234));

            String[] genreOptions = {"Male", "Female", "Others"};
            genreComboBox = new JComboBox<>(genreOptions);
            genreComboBox.setBounds(160, 250, 150, 30);
            genreComboBox.setFont(customFont);
            genreComboBox.setForeground(new Color(40, 115, 121));

            birthDatejl = new JLabel("Birth date:");
            birthDatejl.setBounds(50, 300, 150, 30);
            birthDatejl.setFont(customFont);
            birthDatejl.setForeground(new Color(247, 243, 234));


            MaskFormatter maskbirthDate = new MaskFormatter("##/##/####");
            birthDatejft = new JFormattedTextField(maskbirthDate);
            birthDatejft.setBounds(200, 300, 110, 30);

            cpfjl = new JLabel("CPF:");
            cpfjl.setBounds(50, 350, 100, 30);
            cpfjl.setFont(customFont);
            cpfjl.setForeground(new Color(247, 243, 234));

            MaskFormatter maskcpf = new MaskFormatter("###.###.###-##");
            cpfjft = new JFormattedTextField(maskcpf);
            cpfjft.setBounds(160, 350, 150, 30);

            passwordjl = new JLabel("Password:");
            passwordjl.setBounds(50, 400, 100, 30);
            passwordjl.setFont(customFont);
            passwordjl.setForeground(new Color(247, 243, 234));

            passwordjpf = new JPasswordField();
            passwordjpf.setBounds(160, 400, 150, 30);

            checkPassjl = new JLabel("Confirm Password:");
            checkPassjl.setBounds(50, 450, 150, 30);
            checkPassjl.setFont(customFont);
            checkPassjl.setForeground(new Color(247, 243, 234));

            checkPassjpf = new JPasswordField();
            checkPassjpf.setBounds(200, 450, 110, 30);

            signUpjb = new JButton("Register");
            signUpjb.setBounds(120, 510, 120, 40);
            signUpjb.setFont(customFont);
            signUpjb.setForeground(new Color(247, 243, 234));
            signUpjb.setBackground(new Color(151, 230, 51));
        } catch (ParseException e) {
            e.printStackTrace();
        }

            //add
            add(emailjl);
            add(emailjtf);
            add(namejl);
            add(namejtf);
            add(cepjl);
            add(cepjft);
            add(genrejl);
            add(genreComboBox);
            add(birthDatejl);
            add(birthDatejft);
            add(cpfjl);
            add(cpfjft);
            add(passwordjl);
            add(passwordjpf);
            add(checkPassjl);
            add(checkPassjpf);
            add(signUpjb);
    }

    private void createEvents() {
        signUpjb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get field information
                String email = emailjtf.getText();
                String name = namejtf.getText();
                String cep = cepjft.getText();
                String birthDate = birthDatejft.getText();
                String cpf = cpfjft.getText();
                String password = String.valueOf(passwordjpf.getPassword());
                String checkPass = String.valueOf(checkPassjpf.getPassword());
                String selectedGenre = (String) genreComboBox.getSelectedItem();

                //validations
                if (email.isEmpty() || name.isEmpty() || cep.isEmpty() ||
                        birthDate.isEmpty() || cpf.isEmpty() || password.isEmpty() ||
                        checkPass.isEmpty() || selectedGenre.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill in all fields",
                            "Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                //validation e-mail format
                if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(null, "Invalid email format",
                            "Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (!password.equals(checkPass)) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match",
                            "Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                cpf = cpf.replaceAll("[^0-9]", "");
                birthDate = birthDate.replaceAll("[^0-9]", "");

                //add user, save to file, etc...
                users.add(new User(email, password, name, cep, cpf, birthDate, selectedGenre));
                setVisible(false);
                ReadWriteObjects save = new ReadWriteObjects("User.bin");
                save.writeObject(users);

                //clear the fields
                emailjtf.setText("");
                namejtf.setText("");
                cepjft.setText("");
                cpfjft.setText("");
                birthDatejft.setText("");
            }

            private boolean isValidEmail(String email) {
                return email.contains("@") && email.contains(".");
            }
        });
    }
}
