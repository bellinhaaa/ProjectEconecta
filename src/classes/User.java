package classes;

import java.io.Serializable;

public class User implements Serializable { /*class whose objects can be serialized.
Serialization is the process of converting an object into a sequence of bytes,
so that is can be stored in a file, transmitted over the network or stored in a database*/

    //declaration with encapsulation
    private String email;
    private String password;
    private String name;
    private String cep;
    private String cpf;
    private String birthDate;
    private String genre;

    //constructor
    public User(String email, String password, String name, String cep, String cpf, String birthDate, String genre) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.cep = cep;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.genre = genre;
    }

    //method (getters) to access variables
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getInformations() {
        return "My information" +
                "\n" + "Name: " + name +
                "\n" + "Address: " + cep +
                "\n" + "CPF: " + cpf +
                "\n" + "Birth Date: " + birthDate +
                "\n" + "Genre: " + genre +
                "\n" + "E-mail: " + email;
    }
}
