package com.gildedrose.items;

/**
 * Created with IntelliJ IDEA.
 * User: lai.yi
 * Date: 2020/2/1
 * Description:
 **/
public class BackstagePass extends Item {
    public BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    protected void updateQualityAfterExpiration() {
        quality = 0;
    }

    @Override
    protected void updateQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
        if (sell_in < 11) {
            increaseQuality();
        }
        if (sell_in < 6) {
            increaseQuality();
        }
    }

}
