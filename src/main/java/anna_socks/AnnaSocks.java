package anna_socks;

import java.util.HashMap;
import java.util.Map;

public class AnnaSocks {
    public static void main(String... args) {
        int noOfWashes = 10; //maximum  capacity of Anna's machine 2 + 1 + 1 + 1
        int[] cleanPile = {1, 2, 1, 1, 1, 3, 5, 4, 6, 6, 7, 3};
        int[] dirtyPile = {1, 4, 3};
        System.out.println(noOfPossibleSocks(noOfWashes, cleanPile, dirtyPile));
    }

    /**
     * Calculates the best number of possible socks that Anna can travel with
     *
     * @param noOfWashes ... capacity of Anna's machine
     * @param cleanPile  ... Anna's clean pile of socks
     * @param dirtyPile  ... Anna's dirty pile of socks
     * @return an integer representing number of possible socks Anna can travel with
     */
    static int noOfPossibleSocks(int noOfWashes, int[] cleanPile, int[] dirtyPile) {
        int noOfPossibleSocks = 0;
        int currentNumberOfWashes = 0;

        Map<Integer, Integer> washPairs = new HashMap<>();

        for (int i = 0; i < cleanPile.length; i++) {
            if (washPairs.containsKey(cleanPile[i])) {
                washPairs.replace(cleanPile[i], washPairs.get(cleanPile[i]) + 1);
            } else {
                washPairs.put(cleanPile[i], 1);
            }
            int pairCount = washPairs.get(cleanPile[i]);
            if (pairCount % 2 == 0) {
                noOfPossibleSocks++;
            }
        }


        for (int i = 0; i < dirtyPile.length; i++) {
            if (currentNumberOfWashes < noOfWashes) {
                if (washPairs.containsKey(dirtyPile[i])) {
                    washPairs.replace(dirtyPile[i], washPairs.get(dirtyPile[i]) + 1);
                    int pairCount = washPairs.get(dirtyPile[i]);
                    if (pairCount % 2 == 0) {
                        currentNumberOfWashes++;
                        noOfPossibleSocks++;
                    }
                } else {
                    washPairs.put(dirtyPile[i], 1);
                }
            } else {
                break;
            }
        }
        return noOfPossibleSocks;
    }
}