/*
 * Ehsan KH. Motlagh
 * student ID: 2340457
 * */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Game game = new Game(new Player());


        try{
            game.start(keyboard);
        }catch (InputMismatchException ime) {
            System.out.println("Incorrect amount or invalid entry");
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println("Images are more than needed.");
        }

    }
}
