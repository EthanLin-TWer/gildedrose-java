package com.gildedrose.items;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2020/2/1
 * Description:
 **/
public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    protected void updateQualityAfterExpiration() {
        increaseQuality();
    }

    @Override
    protected void updateQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    @Override
    protected boolean isAgedBrie() {
        return true;
    }
}
