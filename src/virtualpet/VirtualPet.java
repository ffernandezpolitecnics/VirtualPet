/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtualpet;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author fran
 */
public class VirtualPet {

    static final int MINIMUM = 0;
    static final int MAXIMUN = 100;

    static final int MIN_RANDOM = 40;
    static final int MAX_RANDOM = 60;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int energy, fatigue, sleep, hygiene, weight, option;

        energy = initialValue();
        fatigue = initialValue();
        sleep = initialValue();
        hygiene = initialValue();
        weight = initialValue();

        do {                
            option = menu();
       
            switch (option) {
                case '0':
                    showState(energy, fatigue, sleep, hygiene, weight);
                    break;
                case '1':
                    sleep -= 25;
                    fatigue -= 20;
                    energy += 25;
                    hygiene -= 15;
                    weight -= 10;
                    break;
                case '2':
                    sleep -= 15;
                    fatigue += 20;
                    energy -= 25;
                    hygiene -= 15;
                    weight -= 15;
                    break;
                case '3':
                    sleep += 20;
                    fatigue -= 15;
                    energy -= 25;
                    hygiene -= 15;
                    weight -= 20;
                    break;
                case '4':
                    sleep += 15;
                    fatigue += 10;
                    energy -= 25;
                    hygiene += 20;
                    weight -= 10;
                    break;
                default:
                    System.out.println("Error option !!!!");
            }
        } while (option != 0);
        

        





       

        0.- The last option shows the actual state of each attribute just before exiting the application.

    }

    public static int initialValue() {
        Random r = new Random();

        int result = r.nextInt(MAX_RANDOM - MIN_RANDOM) + MIN_RANDOM;
        
        return result;
    }

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        char option;

        System.out.println("1.- Sleep");
        System.out.println("2.- Play");
        System.out.println("3.- Eat");
        System.out.println("4.- Shower");
        System.out.println("0.- Exit application");
        System.out.print("Option: ");
        option = sc.next().charAt(0);

        return option;
    }
   
    public static void showState(int energy, int fatigue, int sleep, int hygiene, int weight) {
        System.out.print("Sleep: " + sleep);
        System.out.print("Fatigue: " + fatigue);
        System.out.print("Energy: " + energy);
        System.out.print("Hygiene: " + hygiene);
        System.out.print("Weight: " + weight);
   
    }
     
}
