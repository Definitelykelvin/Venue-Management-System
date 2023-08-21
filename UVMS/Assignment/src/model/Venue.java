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
public class Venue {
    private static int i = 101;
    private String code;
    private String name;

    public Venue() {
        this.code = generateCode();
    }

    public Venue(String name) {
        this.code = generateCode();
        this.name = name;
    }
    
    public Venue(String code, String name) {
        this.code = code;
        i = Integer.parseInt(code.substring(2))+1;
        this.name = name;
    }
    
    private String generateCode(){
        return String.format("VE%03d", i);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
