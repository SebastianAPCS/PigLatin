import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PigLatin {
    static String[] lines = {"beast", "dough", "happy", "question", "star", "three", "eagle", "try"};

    public static void main(String[] args) {
        /* 

        List<String> fileLines = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("LowellHymn.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                fileLines.add(line);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String fileLine : fileLines) {
            System.out.println(fileLine);
        }

        System.out.println();

        */

        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i] + ": " + toPigLatin(lines[i]));
        }
    }

    public static String toPigLatin(String input) {
        if (!checkForVowels(input)) {
            input += "ay";
        } else if (checkForFirstVowel(input)) {
            input += "way";
        } else if (checkForQU(input)) {
            input = appendQU(input);
        } else if (checkForVowels(input) && !checkForFirstVowel(input)) {
            input = appendConsonantsAy(input);
        }

        return input;
    }

    public static boolean checkForVowels(String input) {
        String vowels = "aeiou";

        for (int i = 0; i < input.length(); i++) {
            if (vowels.indexOf(input.substring(i, i + 1)) != -1) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkForFirstVowel(String input) {
        String vowels = "aeiou";

        if (vowels.indexOf(input.substring(0, 1)) != -1) {
            return true;
        }

        return false;
    }

    public static boolean checkForQU(String input) {
        return input.substring(0, 2).equals("qu")
            || input.substring(0, 2).equals("Qu")
            || input.substring(0, 2).equals("qU")
            || input.substring(0, 2).equals("QU");
    }

    public static String appendQU(String input) {
        return input.substring(2, input.length()) + input.substring(0, 2) + "ay";
    }

    public static String appendConsonantsAy(String input) {
        String consonants = "";

        for (int i = 0; i < input.length(); i++) {
            if (!checkForVowels(input.substring(i, i + 1))) {
                consonants += input.substring(i, i + 1);
            } else {
                break;
            }
        }

        return input.substring(consonants.length()) + consonants + "ay";
    }
}