package com.accessmodifiers;
/*Thing to note here is we can over ride the StorePassword in parent class and define our own Store Password method
* But if we don't wan't it to be overriden we can define this method as final in parent class */
public class EncryptedPassword extends Password {
    private int decryptedPassword;

    public EncryptedPassword(int password) {
        super(password);
        this.decryptedPassword = password;
    }

/*    @Override
    public void StorePassword() {
        System.out.println("Saving password as "+this.decryptedPassword);
    }*/
}
