package com.accessmodifiers;

public class Password {
    private static final int key = 123456789;
    private final int encryptedPassword;

    public Password(int password) {
        this.encryptedPassword = encryptDecrypt(password);
    }

    public int encryptDecrypt(int password){
        return password ^ key;
    }
     public final void  StorePassword(){
         System.out.println("Saving password as "+ this.encryptedPassword);
    }

    public boolean letMeIn(int password){
        if(encryptDecrypt(password)==this.encryptedPassword){
            System.out.println("Welcome in");
            return true;
        }
        else{System.out.println("Wrong password!Please try again");
        return false;}
    }


}
