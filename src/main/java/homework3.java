import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class homework3 {
    public static void main(String[] args) {

        System.out.println(".................задание 1 .................");
        findNumber();

        System.out.println("..................задание 2.....................");
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        findWord(words);
    }

    public static void findWord(String[] words){


//        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
//                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
//                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random random = new Random();
        int number_of_hidden_word = random.nextInt(words.length-1);
        String hidden_word = words[number_of_hidden_word];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String quess_word=null;
        String rezult="";

        do {
            try {
                rezult="";
                System.out.println("Пытаемся угадать загаданное слово");
                quess_word = br.readLine().toLowerCase(Locale.ROOT);
            } catch (IOException e) {
                e.printStackTrace();
            }

            for(int i=0;i<Math.min(quess_word.length(),hidden_word.length());i++) {
                char qw,hw;

                qw=quess_word.charAt(i);
                hw=hidden_word.charAt(i);
                if (qw==hw) rezult+=qw;
                else rezult+="#";

            }
            if (hidden_word.equals(rezult)!=true) {
                for(int i=rezult.length();i<=15;i++) {
                    rezult+="#";
                }
                System.out.println("угаданы следующие символы:");
                System.out.println(rezult);
            } else System.out.println("Поздравляем,  Вы угадали!!!! ");


        } while (hidden_word.equals(rezult)!=true);



    }


    public static void findNumber() {
        Random random = new Random();

            int number = random.nextInt(10);



        System.out.println("Угадай число от 0 до 9");

        Scanner sc = new Scanner(System.in);


        int count = 3;
        boolean repeat = false;
        int quess = -1;
        int intrep;
        while (count > 0 && quess != number) {

                    quess = sc.nextInt(10);

                             if (quess < number) {
                                         System.out.println("загаданное число больше");
                             }
                             if (quess > number) {
                                         System.out.println("загаданное число меньше");
                            }
                             if (quess == number) {
                                          System.out.println("Вы выйграли, было загадано число " + number);
                             }

                     count--;
            if (count == 0 && quess != number)
                        System.out.println("вы проиграли, было загадано число " + number);

            if (count == 0 || quess == number) {
                         System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");

                do {
                    intrep = sc.nextInt();

                    switch (intrep) {
                        case 1: {
                            count = 3;
                            System.out.println("Угадай число от 0 до 9");
                            number = random.nextInt(10); quess=-1;
                            break;
                        }
                        case 0: {
                            System.out.println("game is exit");
                            break;
                        }
                        default: {
                            System.out.println("выбрано неверное число");
                        }
                    }

                } while (intrep < 0||intrep>1);

            }


        }


    }

}

