package Calc;

public class Romes extends Number {
    private String romes_value1;
    private String romes_value2;
    private int romes_value1_int;
    private int romes_value2_int;
    private int result_int;
    private String sign = "";
    private String result_string;
    private final String[] roman_letters_9 = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    Romes(String value1, String value2) {
        this.romes_value1 = value1;
        this.romes_value2 = value2;
        this.romes_value1_int = convert_to_int(romes_value1);
        this.romes_value2_int = convert_to_int(romes_value2);
    }
    public String getRomes_value1() {
        return romes_value1;
    }
    public void setRomes_value1(String romes_value1) {
        this.romes_value1 = romes_value1;
    }
    public String getRomes_value2() {
        return romes_value2;
    }
    public void setRomes_value2(String romes_value2) {
        this.romes_value2 = romes_value2;
    }
    public int getRomes_value1_int() {
        return romes_value1_int;
    }
    public void setRomes_value1_int(int romes_value1_int) {
        this.romes_value1_int = romes_value1_int;
    }
    public int getRomes_value2_int() {
        return romes_value2_int;
    }
    public void setRomes_value2_int(int romes_value2_int) {
        this.romes_value2_int = romes_value2_int;
    }
    private int convert_to_int(String romes_value){
        if (romes_value.equals("I")) {
            return 1;
        } else if (romes_value.equals("II")) {
            return 2;
        } else if (romes_value.equals("III")) {
            return 3;
        } else if (romes_value.equals("IV")) {
            return 4;
        } else if (romes_value.equals("V")) {
            return 5;
        } else if (romes_value.equals("VI")) {
            return 6;
        } else if (romes_value.equals("VII")) {
            return 7;
        } else if (romes_value.equals("VIII")) {
            return 8;
        } else if (romes_value.equals("IX")) {
            return 9;
        } else if (romes_value.equals("X")) {
            return 10;
        } else {
            throw new NumberFormatException("Не верный формат введенных данных");
        }
    }
    private String convert_result_to_Romes(int result_int){
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[result_int];
        return s;
    }
    @Override
    public void sum() {
        result_int = romes_value1_int + romes_value2_int;
        result_string = convert_result_to_Romes(result_int);
    }
    @Override
    public void sub() {
        result_int = romes_value1_int - romes_value2_int;
        if (result_int <= 0){
            throw new ArithmeticException("В Римской системе нет отрицательных чисел и нуля");
        }
        result_string = convert_result_to_Romes(result_int);
    }
    @Override
    public void div() {
        result_int = romes_value1_int / romes_value2_int;
        result_string = convert_result_to_Romes(result_int);
    }
    @Override
    public void mul() {
        result_int = romes_value1_int * romes_value2_int;
        result_string = convert_result_to_Romes(result_int);
    }
    @Override
    public int getResult() {
        return result_int;
    }
    public String getStringResult() {
        return result_string;
    }
}
