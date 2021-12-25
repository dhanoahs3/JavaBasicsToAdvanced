package com.packagescope;

public class ScopeCheck {
    public int publicVar = 1;
    private int privateVar =0;
    private int varOne = 11;

    public ScopeCheck() {
        System.out.println("ScopeCheck created and the values of publicVar is : "+publicVar + " and  of privateVar is :"+privateVar);
    }

    public int getPrivateVar() {
        return privateVar;
    }

    public int privateVarMethod(){
        int privateVar = 10;
        System.out.println("Here we are printing the private var that exists at class level like this "+this.privateVar);
        System.out.println("Here we are printing the private var that exists inside this method privateVarMethod() "+ privateVar);
        return privateVar;
    }

    public void userInner(){
        InnerClass innerClass = new InnerClass();
        System.out.println("ValThree from outerclass  "+innerClass.varThree);


    }

    public class InnerClass{

        private int varThree = 3;

        public InnerClass() {
            System.out.println("InnerClass created and varOne is : "+varOne + " and  varThree :"+varThree);
        }

        public void innerPrintMethod(){
            System.out.println("The value of varOne in inner method is "+varOne+ " and value of varThree is "+varThree);
        }
    }
}
