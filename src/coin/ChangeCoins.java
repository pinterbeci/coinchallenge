package main.coin;

public class ChangeCoins {

    public int calculateCombo(int[] coins, int amount) {

        //ha elérjük az értékek kivonása után,
        // azt hogy az értékünk nulla legyen, akkor sikeresen meghatároztunk egy kombinációt.
        if (amount == 0)
            return 1;

        //ha az értékünk kisebb, mint nulla akkor nem sikerült jó kombinációt találnunk.
        if (amount < 0)
            return 0;

        int combos = 0;

        //a ciklus segítéségél, minden értékhez felépítünk egy fát, aminek gyerekei
        //a értékek tömbjében tárolt elemek lesznek.
        for (int i = 0; i < coins.length; i++) {

            combos += calculateCombo(coins, amount - coins[i]);
        }

        return combos;
    }


    public int calculateCombo(int[] coins, int amount, int currentIndex) {
        //egy kombinációt csak egyszer számol meg, így nem lesznek ismétlődő kombinációk.
        //ezért van szükség a 'currentIndex' értékre, mivel azt növelve lépünk a következő elemre
        //a ciklusban.

        if (amount == 0)
            return 1;

        if (amount < 0)
            return 0;

        int combos = 0;

        for (int i = currentIndex; i < coins.length; i++) {
            combos += calculateCombo(coins, amount - coins[i], i);
        }

        return combos;

        //a currentindex segítségével ki vannak szűrve az ismétlődőd esetek.
        /*
        * egy bináris fát reprenzentálunk, amely minden hívásnál bővül
        * 5 az alapmennyiség, az érmék pedig {1,2}
        *
                                * (5-1)
                                 /         \
                         (5 - 1) - 1       (5 - 1) - 2
                        /         \         /     \
                       3-1        3-2    2 - 1    2 - 2

             * .....
             * így tovább.
             * a kivonandó elemek az érmék, azok képzik az új ágakat.
             * mivel több kombináció is is létrejön ki kell szűrni az ismétlődőket.
             * Erre szolgál, hogy mindig a következő értékre lépünk egy új hívásnál.
             *
             * ha kiszűrjűk az ismétlődő elemeket, akkor így épűl fel a fánk:
             *
                                  ( 5 - 1 )
                                 /         \
                         (5 - 1)-1       (5 - 1)-2
                         /         \             \
                       3-1        3-2            2-2 => itt pedig már kapunk egy kombinációt is
                                 /   \
                                1-1  1-2


*
*                                   ( 5 - 2 ) másik ág
**                                           \
                                             3-2
                                                 \
                                                   1-2 => itt is lesz visszatérési értékünk!
 * * * */
    }


    //a legkisebb elemből álló kombináció, azaz a legkevesebb érmét igénybe vevő kombináció meghatározása.

    public int calculateMinOfCombo(int[] coins, int amount, int currentIndex) {

        if (amount == 0)
            return 0;

        int result = Integer.MAX_VALUE;

        for (int i = currentIndex; i < coins.length; i++) {

            if (coins[i] <= amount) {
                int subResult = calculateMinOfCombo(coins, amount - coins[i], i);

                if (subResult != Integer.MAX_VALUE && subResult + 1 < result)
                    result = subResult + 1;
            }
        }

        return result;
    }
}
