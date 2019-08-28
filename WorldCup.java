/*
 * Program takes 8 strings in an array. The values in this array (n and n+1) are
 * then, similar to a bracket system, randomly selected (50/50 chance) to be the 
 * winners of the round. The winners are then moved onto the next round where the
 * number of strings will be halfed to 4. This is repeated until there is only one
 * string left. 
 *
 * @author Stewart
 * @version JAVA 8, 7/23/2019
 */

import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

public class WorldCup {
    public static void main(String[] args){
        Random rand = new Random();

        /* Creates and populates 'arr' */
        ArrayList<String> arr = new ArrayList<>();
        arr.addAll(Arrays.asList("Belgium", "Germany", "Brazil", "Spain", "England", "Senegal", "Mexico", "France"));
        
        /* 
         * As long as there is more than 1 value in 'arr', there is no winner and
         * more rounds need to be calculated
         */
        for(int round = 1; arr.size() > 1; round++){
            /* Reports the round number and the teams still in the bracket/array */
            System.out.println("\nRound " + round + " teams: " + arr);
            System.out.println("| - - - | | | - - - | | | - - - |");
            /* Loops through 'arr' and randomly selects each team that wins */
            for(int i = 0; i < arr.size() - 1; i++){
                /* Generates a random value between 0 and 1 */
                int win = rand.nextInt(2);
                /*
                 * If the generated number is 0, the team matching the index of 'i' 
                 * is declared the winner and 'i + 1' is removed from 'arr'.
                 * If the generated number is 1, the opposite will happen.
                 */
                if(win == 0){
                    System.out.println(arr.get(i) + " beats " + arr.get(i + 1));
                    arr.remove(i + 1);
                } else {
                    System.out.println(arr.get(i + 1) + " beats " + arr.get(i));
                    arr.remove(i);
                }
            }
        }
        /*
         * Once there is only one index in 'arr' left, they are reported the winner
         * to the user
         */
        System.out.println("\nWinner: " + arr.get(0) + "!");
    }
}
