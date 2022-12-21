// package com.example.awtsample;

import java.util.Random;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class Game {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("test");

        // Game variables
        String[] enemies = { "Skeleton", "Zombie", "Giant Spider", "Witch" };
        int maxEnemyHealth = 100;
        int enemyAttackDamage = 30;

        int health = 100;
        int attackDmg = 20;
        int numHealthPots = 3;
        int healthPotionHealthAmt = 30;
        int healthPotionDropChance = 50; // %

        boolean running = true;

        System.out.println("Welcome to the Adventure..!");

        // Label
        Game: while (running) {
            System.out.println("*-------------------------------------*");

            int enemyHealth = maxEnemyHealth;
            // int myhealth = health;
            String enemy = enemies[rand.nextInt(enemies.length)];

            System.out.println("\t#" + enemy + " has appeared! #");

            while (enemyHealth > 0) {
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do ?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run");

                String input = in.nextLine();
                if (input.equals("1")) {
                    int DamageDealt = rand.nextInt(attackDmg);
                    int DAmageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= DamageDealt;
                    health -= DAmageTaken;

                    System.out.println("\t> You strike the " + enemy + "for " + DamageDealt + "damage");
                    System.out.println("\t You receive " + DAmageTaken + " in retaliation.");

                    if (health < 1) {
                        System.out.println("\t You have taken too much damage, you are too weak to continue");
                        break;
                    }
                } else if (input.equals("2")) {

                    if (numHealthPots > 0) {
                        int nhealth = health;
                        // int newhealth;
                        nhealth += healthPotionHealthAmt;

                        numHealthPots--;

                        if (nhealth <= 100) {
                            health = nhealth;

                        } else {
                            nhealth = health + 30 - (nhealth - 100);

                        }
                        health = nhealth;
                        // health += healthPotionHealthAmt;

                        System.out.println("\t> You drank a health potion, healed for " + healthPotionHealthAmt
                                + "\n\t> You now have " + nhealth + "HP."
                                + "\n\t> You now have " + numHealthPots + " health potions left. \n");
                    } else {
                        System.out
                                .println("\t> You have no health potions left, defeat enemies for chance to drop onr");
                    }
                } else if (input.equals("3")) {
                    System.out.println("\t> You run away from" + enemy);
                    continue Game;
                } else {
                    System.out.println("\tInvalid Input");
                }
            }
            if (health < 1) {
                System.out.println("You have out of the adventure, weak from battle.");
                break;
            }

            System.out.println("----------------------------------------------------");
            System.out.println(" # " + enemy + " Was defeated! # ");
            System.out.println(" #  you have " + health + "HP left #");

            if (rand.nextInt(100) > 10) {
                numHealthPots++;

                System.out.println(" # The " + enemy + " dropped a health potion. #");
                System.out.println(" # You now have " + numHealthPots + " health potion(s)");
            } else
                break;

            System.out.println("---------------------------------------------------");
            System.out.println("what would you like to do now ?");
            System.out.println("1.Continue fighting");
            System.out.println("2.Leave adventure");
            String input = in.nextLine();

            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid Command");
                input = in.nextLine();
            }

            if (input.equals("1")) {
                System.out.println("You continue your adventure.");
            } else if (input.equals("2")) {
                System.out.println("You exit the adventure.");
                break;
            }
        }
        System.out.println("** Thank you for playing **");
    }
}