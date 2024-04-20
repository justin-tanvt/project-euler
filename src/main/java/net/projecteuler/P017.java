package net.projecteuler;

import java.util.ArrayList;
import java.util.HashMap;

public class P017 {
    public static void main(String[] args) {
        int letters = 0;
        for (int i = 1; i <= 1000; i++) {
            letters += numberToLetters(i);
        }
        System.out.println(letters);
    }

    public static ArrayList<String> numberToPhrase(int value) {
        HashMap<Integer, String> words = new HashMap<>();
        words.put(1, "one");
        words.put(2, "two");
        words.put(3, "three");
        words.put(4, "four");
        words.put(5, "five");
        words.put(6, "six");
        words.put(7, "seven");
        words.put(8, "eight");
        words.put(9, "nine");
        words.put(10, "ten");
        words.put(11, "eleven");
        words.put(12, "twelve");
        words.put(13, "thirteen");
        words.put(14, "fourteen");
        words.put(15, "fifteen");
        words.put(16, "sixteen");
        words.put(17, "seventeen");
        words.put(18, "eighteen");
        words.put(19, "nineteen");
        words.put(20, "twenty");
        words.put(30, "thirty");
        words.put(40, "forty");
        words.put(50, "fifty");
        words.put(60, "sixty");
        words.put(70, "seventy");
        words.put(80, "eighty");
        words.put(90, "ninety");
        words.put(100, "hundred");

        ArrayList<String> phrase = new ArrayList<>();

        if (value == 1000) {
            phrase.add("onethousand");
        } else if (value == 100) {
            phrase.add("onehundred");
        } else if (value > 100) {
            int multipleOfHundred = value / 100;
            phrase.add(words.get(multipleOfHundred));
            phrase.add(words.get(100));

            if (value % 100 != 0) {
                phrase.add("and");
            }
        }

        int lastTwoDigits = value % 100;
        if (lastTwoDigits != 0) {
            if (words.containsKey(lastTwoDigits)) {
                phrase.add(words.get(lastTwoDigits));
            } else {
                int multipleOfTen = lastTwoDigits / 10;
                phrase.add(words.get(multipleOfTen * 10));

                int lastDigit = lastTwoDigits % 10;
                phrase.add(words.get(lastDigit));
            }
        }

        return phrase;
    }

    public static int phraseToLetters(ArrayList<String> phrase) {
        int numberOfLetters = 0;
        for (String word : phrase) {
            numberOfLetters += word.length();
        }
        return numberOfLetters;
    }

    public static int numberToLetters(int number) {
        return phraseToLetters(numberToPhrase(number));
    }
}
