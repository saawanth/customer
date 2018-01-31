/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import java.io.IOException;
import java.util.Date;

/**
 *
 * @author revan
 */
public class SampleProcess {


    public static void main(String args[]) {
        Runtime rt = Runtime.getRuntime();
        Process proc;
        try {
            proc = rt.exec("System.out.println(\"Hello!\")");
            proc.waitFor(); //try removing this line
        } 
        catch (Exception e) {
            System.out.println("regedit is an unknown command.");
        }
        Date date = new Date();
        System.out.println(date.getDate());
        SampleProcess renu = new SampleProcess();
        
        System.out.println(renu.getClass());
        System.out.println(renu.getClass().getName());
        
    }
}
