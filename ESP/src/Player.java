/*
 * Ehsan KH. Motlagh
 * student ID: 2340457
 * */

public class Player {
    private int score; // times players guessed correctly
    private String color;


    //getters - setters
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void sumScore(int score) {
        this.score += score;
    }
}
