import java.util.HashSet;
import java.util.Set;

public class MinimumDeletionsToMakeCharFreqUnique {
    public static void main(String[] args) {
        if(minDeletions("") == 0) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        if(minDeletions("a") == 0) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        if(minDeletions("abb") == 0) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        if(minDeletions("bbb") == 0) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        if(minDeletions("aba") == 0) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        if(minDeletions("abc") == 0) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        if(minDeletions("abbccc") == 0) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        if(minDeletions("ab") == 1) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }

    public static int minDeletions(String s) {
        int[] matrixArray = new int[26];
        Set<Integer> set = new HashSet<>();
        int deletions = 0;

        if(s.length() <= 1 )
            return 0;
        if(s.length() == 2)
            return s.charAt(0)==s.charAt(1)? 0:1;

        //data creation phase
        for(int i=0; i<s.length(); i++) {
            matrixArray[(s.charAt(i)-97)] = matrixArray[s.charAt(i)-97]++;
        }

        // validation phase
        for(int i=0; i<26;i++) {
            int frequency = matrixArray[i];

            while(!isZeroFrequency(frequency) && !set.add(frequency)) {
               deletions++;
               frequency--;
            }
        }
        return deletions;
    }

    private static boolean isZeroFrequency(int freq) {
        return 0==freq;
    }
}
