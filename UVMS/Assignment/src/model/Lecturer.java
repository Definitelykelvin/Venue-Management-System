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
public class Lecturer extends User{
    private static int i = 1;
    private String name;

    public Lecturer() {
        super();
        this.id = generateID();
    }

    public Lecturer(String id, String password, String name) {
        super();
        this.id = id;
        i = Integer.parseInt(id.substring(1))+1;
        this.password = password;
        this.name = name;
    }
    
    private String generateID(){
        return String.format("S%04d", i++);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
