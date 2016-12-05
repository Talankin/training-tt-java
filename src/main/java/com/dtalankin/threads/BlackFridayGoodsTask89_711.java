/**
 *  03.12.2016
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.util.List;

public class BlackFridayGoodsTask89_711 {
    private List<Integer> stock;
    private int goodsAmount = 100000;

    public BlackFridayGoodsTask89_711(List<Integer> stock) {
        this.stock = stock;
        addGoods();
    }

    public int getThing(int index) {
        return stock.get(index);
    }

    private void addGoods() {
        for (int i=0; i<goodsAmount; i++){
            stock.add(i);
        }
    }
}

