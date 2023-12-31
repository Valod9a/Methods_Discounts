package app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter your purchase price: ");
        double sum = getSum();
        output(sum, calcDiscount(sum), calcPayment(sum, calcDiscount(sum)));
    }

    public static double getSum(){
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);
        double sum = sc.nextDouble();
        sc.close();
        return new BigDecimal(sum).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public static double calcDiscount(double sum){
        double discount;
        if (sum != 0 && sum <= 5000) discount = sum / 100 * 5;
        else if (sum <= 10000) discount = sum / 100 * 10;
        else  discount = sum / 100 * 15;
        return new BigDecimal(discount).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public static double calcPayment(double sum, double discount){
        return sum - discount;
    }

    public static void output(double sum, double discount, double payment){
        if (sum <= 0){
            System.out.println("Wrong Data.");
            return;
        }
        System.out.println("\nPrice without discount: " + sum + " USD." +
                "\n=-=-=-=-=-=-=-=-=-=-=-=-=-=" +
                "\nYour discount: " + discount +
                " USD.\nYour payment: " + payment + " USD.");
    }
}
