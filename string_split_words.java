// Implement a program to split a string into words and print each word on a new line

import java.util.Scanner;

public class string_split_words {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
        sc.close();
    }
}
