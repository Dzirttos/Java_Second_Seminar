//Написать метод который приводит сторку к нормальному виду
// строка на вход
// Добрый    день  Как   дела Все    хорошо
//выход
// Добрый день. Как дела. Все хорошо.

public class HW_Task {
    public static void main(String[] args) {
        System.out.print("\033[H\033[J");
        System.out.println("Была введена изначальная фраза: ");
        String inputString = "Добрый    день  Как   дела Все    хорошо\n";
        System.out.printf("\u001B[33m" + inputString);
        System.out.println("\u001B[37mФраза была пробразована в следующую: ");
        System.out.printf("\u001B[32m" + makeStringBetter(inputString));

    }

    public static String clearSpace(String inputString) {
        inputString = inputString.replaceAll("\\s+", " ");
        return inputString;
    }

    public static StringBuilder makeStringBetter(String string) {
        string = clearSpace(string);
        StringBuilder inputPhrase = new StringBuilder(string);
        inputPhrase.insert(inputPhrase.length() - 1, '.');

        for (int i = 1; i < inputPhrase.length(); i++) {

            if (Character.isUpperCase(inputPhrase.charAt(i))) {
                inputPhrase.insert(i - 1, '.');
                i++;
            }
        }

        return inputPhrase;
    }
}