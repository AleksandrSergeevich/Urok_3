
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        chislo();
        slovo();
    }
        public static void chislo(){
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        char answer;

        guessGame();

        do {
            System.out.println("Повторить игру еще раз? y/n");
            while (!scanner.hasNext("[yn]")) {
                System.out.println("Не символ. Введите y/n:");
                scanner.next();
            }
            answer = scanner.next().charAt(0);

            if ('n' == answer) {
                isExit = true;
            } else if ('y' == answer) {
                guessGame();
            }
        } while (!isExit);
    }

    private static void guessGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int generate = random.nextInt(10);

        boolean isWin = false;
        int currentNum;

        for (int i = 0; i < 6; i++) {
            System.out.printf("Введите число от 0 до 9: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Не число. Введите число от 0 до 9:");
                scanner.next();
            }

            currentNum = scanner.nextInt();

            if (currentNum == generate) {
                isWin = true;
                break;
            } else if (currentNum > generate) {
                System.out.printf("%d > загаданное\n\n", currentNum);
            } else {
                System.out.printf("%d < загаданное\n\n", currentNum);
            }
        }

        if (isWin) System.out.println("Победа");
        else System.out.printf("GAME OVER. Ответ: %d\n", generate);
    }

    public static void slovo() {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        String word;
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println("Варианты ответа на вопрос программы! ");
        System.out.println(Arrays.toString(words));
        int n = rnd.nextInt(words.length);
//        System.out.println(words[n]);
        System.out.println("Программа загадала слово, попробуйте угадать");
        char[] chs = words[n].toCharArray();
        char[] chCmp = new char[chs.length];
        for (int i = 0; i < chs.length; i++) {
            chCmp[i] = '*';
        }

        while (true) {
            System.out.print("Введите слово (0 exit): ");
            word = sc.nextLine();
            if (word.equals("0")) {
                break;
            }
            if (word.equals(words[n])) {
                System.out.println("Вы угадали");
                break;
            } else {
                System.out.println("Вы не угадали");
                char[] chWord = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    if (i >= chWord.length) {
                        break;
                    }
                    if (chs[i] == chWord[i]) {
                        chCmp[i] = chs[i];
                    }
                }
                System.out.println(String.valueOf(chCmp));
            }
        }
    }
}
