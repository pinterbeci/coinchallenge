package main.coin;

public class Main {
    public static void main(String[] args) {

        int [] coins = {1,2};
        int totalAmount = 4;

        ChangeCoins coinSample = new ChangeCoins();

        System.out.println("Ismétlődő kombinációkkal: ");
        System.out.println(coinSample.calculateCombo(coins, totalAmount));

        System.out.println("Nem ismétlődő kombinációkkal: ");
        System.out.println(coinSample.calculateCombo(coins, totalAmount,0));
    }
}
