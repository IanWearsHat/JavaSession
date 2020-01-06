/**
 * Project 4 -- BlackJack Simulator
 *
 * @author Ian Dai
 *
 * @date date of completion
 *
 */
import java.text.DecimalFormat;
import java.util.Random;

public class BlackJack
{
    /**
     * Determine if the dealer or player has won this game (round).
     *
     * @param dealerValue value of dealer’s hand
     * @param playerValue value of player’s hand
     * @return 1, 0, -1, indicated player wins, ties, or loses
     */
    public static int decideGame(int dealerValue, int playerValue) {
        if (dealerValue > playerValue || playerValue > 21) {
            return -1;
        }
        else if (playerValue > dealerValue || dealerValue > 21) {
            return 1;
        }
        return 0;
    }
    /**
     * Draw cards into the “hand”, calculating its value. Stop when the total
     * is at least 17 (handling Aces correctly to avoid “busting” if possible).
     *
     * @return integer value of the hand.
     */
    public static int getHand()
    {
        int handCount = 0;
        for (int i = 0; i < 4; i++) {
            int tempCard = getCard() + 2;
            if (handCount < 17) {
                if (handCount + tempCard > 21 && tempCard == 11) {
                    tempCard = 1;
                }
                handCount += tempCard;
            }
        }

        return handCount;
    }
    /**
     * Use a random number generator to select a card from the deck.
     *
     * @return an integer representing the value of the card
     */

    private static int getCard()
    {
        Random draw = new Random();
        return draw.nextInt(10);
    }

    public static void main(String[] args) {
        int dealerWins = 0;
        int selfWins = 0;
        int ties = 0;
        int rounds = 1000000;

        for (int i = 0; i < rounds; i++) {
            int round = decideGame(getHand(), getHand());

            if (round == 1) {
                selfWins++;
            }
            else if (round == -1) {
                dealerWins++;
            }
            else if (round == 0) {
                ties++;
            }
        }

        DecimalFormat format = new DecimalFormat("##.###");
        double selfPercentage = (100 * ((double) selfWins/rounds));
        double dealerPercentage = (100 * ((double) dealerWins/rounds));
        double tiePercentage = (100 * ((double) ties/rounds));

        System.out.println("Wins:\t" + format.format(selfPercentage) + "%");
        System.out.println("Losses:\t" + format.format(dealerPercentage) + "%");
        System.out.println("Ties:\t" + format.format(tiePercentage) + "%");


    }
}