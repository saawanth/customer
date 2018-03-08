/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import static java.lang.System.currentTimeMillis;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author revan
 */
public class Sample3 {

    public static void main(String args[]) {
        boolean booleanVar = 1 > 2;
        Boolean booleanObj = Boolean.valueOf("True");
        Boolean booleanObj2 = booleanVar;
        System.out.println("booleanVar = " + booleanVar);
        System.out.println("booleanObj = " + booleanObj);
        System.out.println("booleanObj2 = " + booleanObj2);
        //continued...

        System.out.println("compare 2 wrapper objects: " + booleanObj.equals(booleanObj2));
        /* object to primitive */
        booleanVar = booleanObj;
        System.out.println("booleanVar = " + booleanVar);
        System.out.println(Math.round(Math.PI));
        System.out.println(Math.random());
        System.out.println(Math.floor(2.3));
        System.out.println(Math.ceil(2.3));
        System.out.println(Math.abs(-9));
        System.out.println(Math.toDegrees(10));
        System.out.println(Math.sin(90));
        System.out.println(currentTimeMillis());
     
     

   // public static void main(String[] args) {
        Properties p1 = System.getProperties();
        p1.list(System.out);
        
        Scanner sc = new Scanner(System.in);
        
        int number = 0;
        
        while(number != 0){
            try{
                System.out.println("Enter the number or 0 to quit:");
                number = sc.nextInt();
            }
            catch(Exception e){
                System.out.println("Error!"+e);
            }
            
        }
    }

}

