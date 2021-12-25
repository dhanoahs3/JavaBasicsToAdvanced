package com.packagescope;

public class Runner {

    /*Scope is simple
    * privateVar in this main method can be access directly
    * privateVar is class scopeCheck can be access by creating an object of scopeCheck and then using the getter method
    *      System.out.println("scopeCheck private var is "+ scopeCheck.getPrivateVar());
    *  we can even define the same privateVar variable inside a method in scopeCheck and then scope of that privateVar is
    * just inside that method
    * Please note that if we have a privateVar variable in a method and also the one at class level with same name
    * like we have in ScopeCheck class  and  we want to access the one at class level
    *  inside the method and not the one inside the method we can use this keyword
    *  System.out.println("Here we are printing the private var that exists at class level "+this.privateVar);
 */

    public static void main(String[] args)  {
     String privateVar = "This is private in main()";
     ScopeCheck scopeCheck = new ScopeCheck();
     System.out.println("scopeCheck private var is "+ scopeCheck.getPrivateVar());
     System.out.println("The main method private var is "+privateVar);
        System.out.println("The value of private var inside the method getPrivateVar  "+ scopeCheck.privateVarMethod());
          System.out.println("---------------------------------------------------------------------------------");

        String varFour = "private var four in main method";
        scopeCheck.userInner();
        System.out.println("The value of var four is "+varFour);

        System.out.println("---------------------------------------------------------------------------------");
         ScopeCheck.InnerClass innerClass = scopeCheck.new InnerClass();
         innerClass.innerPrintMethod();



    }
}