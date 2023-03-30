/*
 * Ehsan KH. Motlagh
 * student ID: 2340457
 * */

public class Player {

    private float bet; // amount money to bet every set

    private float totalBet; // total bet
    private float winAmount; //  win amount 1 hand

    private float totalWin; // total win

    public float getBet() {
        return bet;
    }

    public void setBet(float bet) {
        this.bet = bet;
        this.totalBet += bet;
    }

    public float getWinAmount() {
        return winAmount;
    }

    public void setWinAmount(float winAmount) {
        this.winAmount = winAmount;
        this.totalWin += this.winAmount;
    }

    public float getTotalBet() {
        return totalBet;
    }

    public void setTotalBet(float totalBet) {
        this.totalBet = totalBet;
    }

    public float getTotalWin() {
        return totalWin;
    }

    public void setTotalWin(float totalWin) {
        this.totalWin = totalWin;
    }
}
