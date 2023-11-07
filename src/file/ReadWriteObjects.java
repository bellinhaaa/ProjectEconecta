package file;

import classes.User;

import javax.swing.*;
import java.io.*;
import java.util.List;

public class ReadWriteObjects {
    //file name declaration
    private String fileName;

    //constructor
    public ReadWriteObjects(String listName) {
        super();
        this.fileName = listName;
    }

    //method for writing objects to a user list
    public void writeObject(List<User> users) {

        try {
            //creates an output stream for the file
            FileOutputStream flow = new FileOutputStream(fileName);
            //creates an object to write objects to the flow
            ObjectOutputStream object = new ObjectOutputStream(flow);
            //write the list of users to the file
            object.writeObject(users);
            //closes the write object
            object.close();
            //displays a success message
            JOptionPane.showMessageDialog(null, "Successfully saved",
                    "Sign Up", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    //method for reading objects from the file
    public List<User> rreadObjects() {
        List<User> user = null; //variable that will receive the file object
        FileInputStream flow;
        try {
            //creates an input stream for the file
            flow = new FileInputStream(fileName);
            //creates an object to read objects from the flow
            ObjectInputStream object = new ObjectInputStream(flow);
            //reads the list of users from the file
            user = (List<User>) object.readObject();
            //closes the read object
            object.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }
}
