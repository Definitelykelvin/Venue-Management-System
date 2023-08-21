/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User
 */
public class Admin extends User{
    
    private static int i = 1;

    public Admin() {
        super();
        this.id = generateID();
    }

    public Admin(String password) {
        this.id = generateID();
        this.password = password;
    }
    
    private String generateID(){
        return String.format("Admin%d", i++);
    }
    
}
