import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Калькулятор целых чисел от 1(I) до 10(X) включительно");
        String str;
        do {
            Scanner scanner = new Scanner(System.in);
            str = scanner.nextLine();
            str = str.replace(" ", "");
            Expression expression = new Expression(str);
            System.out.println(expression.getResult());
        } while (!str.equals("exit"));
    }
}
