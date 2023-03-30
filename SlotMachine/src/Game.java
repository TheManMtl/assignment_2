/*
 * Ehsan KH. Motlagh
 * student ID: 2340457
 * */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player player;
    private ArrayList<String> images;

    /* A game starts with a player
     *  images are 3
     * */
    public Game(Player player) {
        this.player = player;
        images = new ArrayList<>(3);
    }

    //game starts here
    public void start(Scanner keyboard) {
        char toContinue;
        do {
            System.out.print("Place your bet: ");
            float bet = keyboard.nextFloat();
            while (!isBetValid(bet)) {
                System.out.println("Wrong bet! place it again");
                bet = keyboard.nextFloat();
            }
            player.setBet(bet);
            displayImages();
            int result=findMatch();
            if (result == 3) {
                System.out.println("You won 3 time your bet!");
                player.setWinAmount(bet * 3);
            } else if (result == 2) {
                System.out.println("You won 2 time your bet!");
                player.setWinAmount(bet * 2);
            } else if (result == 0) {
                System.out.println("You won $0 this time!");
                player.setWinAmount(0f);
            }
            images.removeAll(images); // clean the list for new game
            System.out.print("to continue press (y): ");
            toContinue = keyboard.next().charAt(0);
        } while (toContinue == 'y');

        System.out.printf("You totally bet: %.2f, you won: %.2f \n",
                player.getTotalBet(), player.getTotalWin());

    }

    /*
     *  Randomly setting an image to list
     * */
    public void getRandomImage() throws IndexOutOfBoundsException {
        Random randomColorInt = new Random();
        int color = randomColorInt.nextInt(5); // generate 0-4 representing color indexes in enum
        this.images.add(ImageNames.values()[color].name()); // adding images to list
    }

    /*
     *  validating the bet to be a positive number
     *  and should not be 0
     * */
    private boolean isBetValid(float bet) {
        return bet > 0;
    }

    public void displayImages() throws IndexOutOfBoundsException {
        for (int i = 0; i < 3; i++) {
            getRandomImage();
        }
        System.out.println(images);
    }

    /*
     * returns 3 if all the images are equal
     * returns 2 if 2 images are equal
     * returns 0 none of the images are equal
     * */

    public int findMatch() {
        if (images.stream().distinct().count() <= 1) return 3;
        for (int i = 0; i < images.size(); i++) {
            for (int j = i + 1; j < images.size() ; j++) {
                if (images.get(i).compareTo(images.get(j)) == 0)
                    return 2;
            }
        }
        return 0;
    }
}
