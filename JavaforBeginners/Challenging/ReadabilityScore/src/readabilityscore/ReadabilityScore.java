/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package readabilityscore;

import java.util.Scanner;

/**
 *
 * @author josemaria
 */
public class ReadabilityScore {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        if (text.length() > 100) {
            System.out.println("HARD");
        } else {
            System.out.println("EASY");
        }

    }
    
}
