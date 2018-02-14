/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

/**
 *
 * @author revan
 */
public class Sample2 {
    
public static void main(String args[]) {
 StringBuffer sb = new StringBuffer("Jonathan");
 System.out.println("sb = " + sb);
 /* initial capacity is 16 */
 System.out.println("capacity of sb: "+sb.capacity());
 System.out.println("append 'O' to sb: " +
 sb.append('O'));
 System.out.println("sb = " + sb);
 System.out.println("3rd character of sb: " +
 sb.charAt(2)); // n
 //continued...

//The StringBuffer Class: Example
 char charArr[] = "Hi XX".toCharArray();
 /* Need to add 1 to the endSrc index of getChars */
 sb.getChars(0, 2, charArr, 3);
 System.out.print("getChars method: ");
 System.out.println(charArr);
 System.out.println("Insert \'jo\' at the 3rd cell: " + sb.insert(2, "jo"));
 System.out.println("Delete \'jo\' at the 3rd cell: " + sb.delete(2,4));
 System.out.println("length of sb: " + sb.length());
 //continued

//The StringBuffer Class: Example
 System.out.println("replace: " + sb.replace(3, 9, " Ong"));
 /* Need to add 1 to the endIndex parameter of
substring*/
 System.out.println("substring (1st two characters): " + sb.substring(0, 3)); // Jon
 System.out.println("implicit toString(): " + sb);
 }
 }
