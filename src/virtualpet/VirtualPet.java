/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtualpet;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here

        int energy, fatigue, sleep, hygiene, weight;
        char option;

        energy = initialValue();
        fatigue = initialValue();
        sleep = initialValue();
        hygiene = initialValue();
        weight = initialValue();

        do {    
            limpiarAnt();
            showState(energy, fatigue, sleep, hygiene, weight);
            option = menu();
       
            switch (option) {
                case '0':
                    System.out.println();
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
        } while (option != '0' && !isDead(energy, fatigue, sleep, hygiene, weight));
        
        showState(energy, fatigue, sleep, hygiene, weight);
        System.exit(0);
    }

    public static int initialValue() {
        Random r = new Random();

        int result = r.nextInt(MAX_RANDOM - MIN_RANDOM) + MIN_RANDOM;
        
        return result;
    }

    public static void spaces(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print(' ');
        }
    }
    
    public static void lines(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print('-');
        }
        System.out.println();
    }
    
    
    public static char menu() {
        Scanner sc = new Scanner(System.in);
        char option;

        spaces(10);
        System.out.println("VirtualPET");
        spaces(10);
        System.out.println("----------");
        spaces(10);
        System.out.println("1.- Sleep");
        spaces(10);
        System.out.println("2.- Play");
        spaces(10);
        System.out.println("3.- Eat");
        spaces(10);
        System.out.println("4.- Shower");
        spaces(10);
        System.out.println("0.- Exit application");
        spaces(10);
        System.out.print("Option: ");
        option = sc.next().charAt(0);

        return option;
    }
   
    public static void showState(int energy, int fatigue, int sleep, int hygiene, int weight) {
        String totals = "";
     
        totals = "| Sleep: " + sleep + " | " + "Fatigue: " + fatigue + " | " + "Energy: " + energy + " | " + "Hygiene: " + hygiene + " | " + "Weight: " + weight + " |";
        System.out.println();
        spaces(10);
        lines(totals.length());
        spaces(10);
        System.out.println(totals);
        spaces(10);
        lines(totals.length());
        System.out.println();
        
    }
    
    public static Boolean isDead(int energy, int fatigue, int sleep, int hygiene, int weight) {
        Boolean dead = false;
     
        if (sleep < MINIMUM || fatigue < MINIMUM || energy < MINIMUM || hygiene < MINIMUM || weight < MINIMUM ||
            sleep > MAXIMUN || fatigue > MAXIMUN || energy > MAXIMUN || hygiene > MAXIMUN || weight > MAXIMUN) {
            dead = true;
        }
        
        return dead;        
    }
     
    public static void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
              
            if(operatingSystem.contains("Windows")){        
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            } 
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void limpiarAnt() {
        try {
           
            Robot pressbot = new Robot();
            pressbot.keyPress(KeyEvent.VK_CONTROL);
            pressbot.keyPress(KeyEvent.VK_L);
            pressbot.keyRelease(KeyEvent.VK_CONTROL);
            pressbot.keyRelease(KeyEvent.VK_L);
            TimeUnit.MILLISECONDS.sleep(20); // added another 1 second sleep
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
