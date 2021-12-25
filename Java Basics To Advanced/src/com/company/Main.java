package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Person p1 = new Person();
        Person p2 = new Person("rondavis@gmail.com",34,"American");
        Person p3 = new Person("Charlie","Roberston","crobersston@gmail.com",33,"Indian");
        System.out.println(p1.first_name+p1.last_name+p1.email+p1.age+p1.nationality);
        System.out.println(p2.first_name+p2.last_name+p2.email+p2.age+p2.nationality);
        System.out.println(p3.first_name+p3.last_name+p3.email+p3.age+p3.nationality);
    }
}
