/*
 * Ehsan KH. Motlagh
 * student ID: 2340457
 * */

import java.util.Random;
import java.util.Scanner;

public class Game {

    private String color;
    private Player player;

    private int sets;

    //game must have with a player
    public Game(Player player) {
        this.player = player;
    }

    //getters setters


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    /*
     * getting an input obj as arg to deal with user
     * sets arg decides the game sets
     * start method generates the game
     * */
    public void start(Scanner keyboard, int sets) throws GameAppException {

        for (int set = 0; set < sets; set++) {
            getRandomColors(); // computer chooses the color

            System.out.print("Enter your color:");

            String playerColor = keyboard.nextLine();

            while (!isValidateColor(playerColor)) {
                System.out.println("Be careful Your choice NOT AVAILABLE!");

                for (Colors c : Colors.values()) // presenting player the colors available
                    System.out.printf("%s - ", c);

                System.out.print("Enter your color:");
                playerColor = keyboard.nextLine();
            }
            this.player.setColor(playerColor);// getting color name from user

            System.out.println("computer chose: " + this.color);// show user the computers selection

            //if the user's color and computer's match 1 score for user
            if (this.player.getColor().equalsIgnoreCase(this.color)) {
                this.player.sumScore(1); // adds-up score
            }
        }
    }

    /*
     * Helper methods
     * */
    public void getRandomColors() {
        Random randomColorInt = new Random();
        int color = randomColorInt.nextInt(5); // generate 0-4 representing color indexes in enum
        this.color = Colors.values()[color].name();
    }

    public boolean isValidateColor(String color) {
        boolean check = false;
        for (Colors c : Colors.values())
            if (c.name().equalsIgnoreCase(color)) {
                return true;
            }
        return check;
    }
}
