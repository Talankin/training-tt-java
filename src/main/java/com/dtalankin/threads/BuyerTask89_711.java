/**
 *  03.12.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

public class BuyerTask89_711 {
    private BlackFridayGoodsTask89_711 goods;
    private String name;
    public Thread t;

    public BuyerTask89_711(BlackFridayGoodsTask89_711 goods, String name) {
        this.goods = goods;
        this.name = name;
        t = new Thread(runnable, this.name);
        t.start();
    }

    private Runnable runnable = () ->  {
        int n = 99999;
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            goods.getThing((int)(Math.random()*n));
        }
        long timeEnd = System.currentTimeMillis() - timeStart;
        System.out.println(name + " thread ============== time for : " + timeEnd);
    };

}

