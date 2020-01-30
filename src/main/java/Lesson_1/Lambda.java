package Lesson_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lambda {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите первое число:");
        double num1 = Double.parseDouble(reader.readLine());
        System.out.println("Введите знак действия: +, -, *, /");
        String sign = reader.readLine();
        System.out.println("Введите второе число:");
        double num2 = Double.parseDouble(reader.readLine());
        reader.close();

        double result;
        Operationable operate = null;
        switch (sign){
            case ("+"):
                operate = (x,y) -> x+y;
                break;
            case ("-"):
                operate = (x,y) -> x-y;
                break;
            case ("*"):
                operate = (x,y) -> x*y;
                break;
            case ("/"):
                if (num2 != 0)
                    operate = (x, y) -> x / y;
                break;
        }
        try {
            result = operate.calculate(num1, num2);
            System.out.println(result);
        } catch (NullPointerException e) {
            System.out.println("деление на ноль!");
        }
    }
}
interface Operationable {
    double calculate (double x, double y);
}

