package Calc;

import java.util.Scanner;

public class Calculator {
    private static boolean arabic_numbers = true;

    public static String[] pars(String input) {  // Создаем массив со всеми вводимыми символами
        String[] parsed_input = input.split(" "); // Убираем из массива " "
        if (parsed_input.length < 3) { // Проверка из скольки ячеек состоит массив, если более 3х, просим обновить вводимые данные
            throw new NumberFormatException("строка не является математической операцией");
//                        Scanner input_a_value_again = new Scanner(System.in);
//                        System.out.println("Неверный формат ввода данных. Введите выражение, разделяя каждый символ _пробелом_");
//                        input = input_a_value_again.nextLine();
//                        return pars(input);
        }
        if(parsed_input.length > 3){
            throw new NumberFormatException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }else {
            return parsed_input;  // Возвращаем массив содержащий символы без пробелов
        }
    }


    public static void main(String[] args) {

        Scanner input_a_value = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = input_a_value.nextLine(); // вводим пример
        while (!input.isEmpty()) {               // если вводимые данные не пустые, то делаем проверку
            String[] parsed_input = Calculator.pars(input); // Закидываем на проверку в метод String [] pars (String input)
            String operation = parsed_input[1]; // Выводим * / - +  в отдельный String
            Number values;
            int value1 = 0;
            int value2 = 0;
            // Переводим в int. Если введены римские, выкинет исключение
            try {
                value1 = Integer.parseInt(parsed_input[0]);
                value2 = Integer.parseInt(parsed_input[2]);
                //values = new Arabic(value1, value2, 0);
            } catch (NumberFormatException e) {
                arabic_numbers = false;
                if(parsed_input[0].contains("1") || parsed_input[0].contains("2") || parsed_input[0].contains("3") || parsed_input[0].contains("4") || parsed_input[0].contains("5") || parsed_input[0].contains("6") || parsed_input[0].contains("7") || parsed_input[0].contains("8") || parsed_input[0].contains("9") || parsed_input[0].contains("10") ||
                        parsed_input[2].contains("1") || parsed_input[2].contains("2") || parsed_input[2].contains("3") || parsed_input[2].contains("4") || parsed_input[2].contains("5") || parsed_input[2].contains("6") || parsed_input[2].contains("7") || parsed_input[2].contains("8") || parsed_input[2].contains("9") || parsed_input[2].contains("10")){
                    throw new NumberFormatException("Введены неверно данные");
                }
                System.out.println("Введены римские цифры");
                //values = new Romes(parsed_input[0], parsed_input[2], 0);
            }

            if (arabic_numbers) {
                if(value1 > 10 || value1 < 0 || value2 > 10 || value2 < 0){
                    throw new NumberFormatException("Введенные цифры мене 0 или более 10");
                }
                values = new Arabic(value1, value2);
            } else {
                values = new Romes(parsed_input[0], parsed_input[2]);
            }

            if (operation.equals("+")) {
                values.sum();
            } else if (operation.equals("-")) {
                values.sub();
            } else if (operation.equals("/") || operation.equals(":")) {
                values.div();
            } else if (operation.equals("*") || operation.equals("x")) {
                values.mul();
            }

            if (arabic_numbers) {
                System.out.println("Ответ: " + values.getResult());
            } else {
                System.out.println("Ответ: " + values.getStringResult());
            }
            System.out.println();
            System.out.print("Введите следующее выражение: ");
            input = input_a_value.nextLine();
        }
        System.out.println("Вы вышли из калькулятора");

    }
}
