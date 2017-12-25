/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gen.security;

/**
 *
 * @author VATSAL
 */
import org.jasypt.util.password.StrongPasswordEncryptor;

public class MyDigest {
 
    public String getEncryptedPassword(String userPassword)
    {
        String encryptedPassword = null;
        
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        encryptedPassword = passwordEncryptor.encryptPassword(userPassword);
        
        return encryptedPassword;
    }
    
    public boolean verifyPassword(String inputPassword, String encryptedPassword)
    {
        boolean result = false;
        
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        if (passwordEncryptor.checkPassword(inputPassword, encryptedPassword)) 
        {
            result = true;
        }
        
        return result;
    }
    
}
