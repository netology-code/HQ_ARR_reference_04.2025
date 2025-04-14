import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] products = {"Молоко (1 л)", "Хлеб (400 г)", "Гречневая крупа (800 г)", "Курица (1 кг)", "Томаты (1 кг)", "Картофель (1 кг)", "Салат (1 шт.)", "Бананы (1 кг)", "Яйца (10 шт.)", "Макароны (450 г)"};
        int[] prices = {85, 67, 80, 500, 440, 46, 70, 150, 110, 90};
        System.out.println("Список возможных товаров для покупки");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + ", " + prices[i] + " руб/шт.");
        }

        int[] basket = new int[products.length];

        int sumProducts = 0;

        while (true) {
            System.out.println("Выберите товар и его количество или введите end");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            if (input.equals("end") || (input.equals("утв"))) {
                break;
            }

            String[] parts = input.split(" ");
            int productNumber = Integer.parseInt(parts[0]) - 1; // Первое введенное число - номер продукта

            int productCount = Integer.parseInt(parts[1]); // Второе введенное число - кол-во продукта
            basket[productNumber] += productCount;

            int currentPrice = prices[productNumber];
            sumProducts += productCount * currentPrice;

        }

        System.out.println("Ваша корзина: ");
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] > 0) {
                System.out.println(products[i] + " " + basket[i] + " шт. " + prices[i] + " руб/шт. " + basket[i] * prices[i] + " в сумме");
            }
        }
        System.out.println("Итого: " + sumProducts + " руб.");
    }
}

