package src;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.NamedMethodGenerator;

import java.time.LocalDate;
import java.util.Queue;

public class Person {

    public enum Sex {
        MALE, FEMALE;
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;


    //nullary constructor
    public Person() {
        name = "";
        birthday = LocalDate.now();
        gender = Sex.FEMALE;
        gender = Sex.MALE;
        emailAddress = "";

    }

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthday.getDayOfYear();
    }

    public void printPerson() {
        System.out.println(
                "NAME:" + name + "\n"
               + "GENDER:" + gender.toString() + "\n"
               + "EMAIL:" + emailAddress + "\n"
               + "DOB:" + birthday.getMonth() + birthday.getDayOfYear() + birthday.getYear()
        );



    }


}
