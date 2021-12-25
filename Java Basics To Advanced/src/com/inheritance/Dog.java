package com.inheritance;

public class Dog extends Animal {
    int eyes;
    int legs;
    int teeth;
/*Inheritance things to note
* 1.if there is a constructor with arguments for parent class then we have to make a constructor for child class
* which calls that parametrised constructor of parent class
* 2. If there is a function with same name in parent class(function overriding if we just use move() it will call t
* the method of child class itself.To call method of parent class we use super.move()
* 3. if there is a method just in parent class but not there in child class we can call it like eat() or move.eat() .It
* doesn't matter
* 4. And if we have a animal reference like this Dog d1 = new Dog();
* and then we use methods like d1.eat() it will call eat method in child class if there is one over riden otherwise it
* will simply call eat in parent class.
* this and super .this is used to call another constructor from a constructor.this should be the first line in another
* constructor
* same way we can use super to call constructor of parent class ,but again it should be first line in defination of
* child constructor defination.
* And a constructor can call either this or super in its defination but nit both as it has to be first line in constructor
* and both can't be on first line.
*
* method overiding vs method overloading
* method overloading ------------------------
* methods must have same name and different paramaters
* they may or may not have same return type/access modifiers and may or may not throw same/different exceptions.
* method overriding-----------------------------------
* must have same name and arguments
* cant have lower access modifier For example if method in parent class has access modifier protected than method
* over riden in child class can have access modifier protected or public but cant be private
* must not throw new or broader exceptions
* must have same return type or covariant return type.
*
* example of covariant return type
* Class Burgerfactory{
* public Burger createBurger{
* reurn new Burger();} //this returns an object of class burger
* }
*
* Class HealthyBurgerFactory extends Burgerfactory{
 * public HealthyBurger createBurger{
 * return new HealthyBurger();} //this returns an object of class healthyBurger.
 * where healthy burger is an child of class burger .So when we overide the createBurger method in child class
 * Healthy Burger factor it can either have same return type i.e Burger or a child return type of Burger that is Healthy
 * burger.please also note the difference between healthyburgerfactory and healthyburger class
 * and same way difference between burger and burgerfactory class.
 *
 *
 * static and instance variables and methods
 * static variables have class level functionality and instance variables have method level functionality
 * static variables can't access non-static variables but non-static variables can access both static and
 * non-static variables.
 * }
*
* */
    static String nickname;

    public Dog(int eyes,int legs,int teeth,String name, int brain, int body,String nickname) {
        super(name, brain, body);
        Dog.nickname = nickname; //note we cant use this with static variables.We have to use the class name i.e Dog
    }
    public void chew(){
        eat();
        System.out.println("dog chewing");
    }
     public void run(){
         System.out.println("Dog running");
         super.move();
         move();
     }

    public void move(){
        System.out.println("Dog moving");
    }
}
