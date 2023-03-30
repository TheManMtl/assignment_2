/*
 * Ehsan KH. Motlagh
 * student ID: 2340457
 * */

import java.util.Scanner;

/*
*  ESP game
*  computer selects a randomly a color.
*  user tries to guess the color if the guess is correct 1 point adds to player's score.
*  Colors are stored in enum class.
*  Player Class stores a total score and the color selected.
*  Game Class Stores the selected color and has a Player.
*
* */

public class Demo {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Game game = new Game(new Player());
        game.setSets(10);

        try{
            game.start(keyboard, game.getSets());
            System.out.printf("Score:%d \n", game.getPlayer().getScore());

        }catch (GameAppException gae){
            System.out.println(gae.getMessage());
        }

        keyboard.close();
    }
}
