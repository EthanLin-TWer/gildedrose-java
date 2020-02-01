package com.gildedrose.items;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2020/2/1
 * Description:
 **/
public class Conjured extends Item {
    public Conjured(int sellIn, int quality) {
        super("Conjured Mana Cake", sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        decreaseQuality();
        decreaseQuality();
    }
}
