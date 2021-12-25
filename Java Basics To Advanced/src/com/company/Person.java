package com.company;

public class Person {
    String first_name;
    String last_name;
    String email;
    int age;
    String nationality;


    public Person() {
        this("Bob","Mcd","bobmcd@gmail.com",22,"Canadian");
        System.out.println("In the first constructor.Call to another constructor should be the first line so thats why this line is afterwards");
    }

    public Person(String email, int age, String nationality) {
        this("ron","davis",email,age,nationality);
        System.out.println("In the second constructor.Call to another constructor should be the first line so thats why this line is afterwards");

    }

    public Person(String first_name, String last_name, String email, int age, String nationality) {
        System.out.println("In the third constructor finally");
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.age = age;
        this.nationality = nationality;
    }


}
