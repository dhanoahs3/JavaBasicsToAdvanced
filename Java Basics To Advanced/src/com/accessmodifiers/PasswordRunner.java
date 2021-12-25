package com.accessmodifiers;

public class PasswordRunner {

    public static void main(String[] args) {
        Password password = new Password(1234);
        password.StorePassword();
        password.letMeIn(1);
        password.letMeIn(5);
        password.letMeIn(1234);


        EncryptedPassword extendePassword = new EncryptedPassword(1234);
        extendePassword.StorePassword();
        extendePassword.letMeIn(1);
        extendePassword.letMeIn(5);
        extendePassword.letMeIn(1234);
    }
}