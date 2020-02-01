package com.gildedrose.items;

public class Item {

    public String name;

    public int sell_in;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sell_in = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sell_in + ", " + this.quality;
    }

    public void passOneDay() {
        updateQuality();

        updateSellIn();

        if (isExpired()) {
            updateQualityAfterExpiration();
        }
    }

    private void updateQualityAfterExpiration() {
        if (!isAgedBrie()) {
            if (!isBackstagePass()) {
                decreaseQuality();
            } else {
                quality = 0;
            }
        } else {
            increaseQuality();
        }
    }

    private void decreaseQuality() {
        if (quality > 0) {
            if (!isSulfuras()) {
                quality = quality - 1;
            }
        }
    }

    private void increaseQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    private void updateSellIn() {
        if (!isSulfuras()) {
            sell_in = sell_in - 1;
        }
    }

    private void updateQuality() {
        if (!isAgedBrie() && !isBackstagePass()) {
            decreaseQuality();
        } else {
            if (quality < 50) {
                quality = quality + 1;

                if (isBackstagePass()) {
                    if (sell_in < 11) {
                        increaseQuality();
                    }

                    if (sell_in < 6) {
                        increaseQuality();
                    }
                }
            }
        }
    }

    private boolean isExpired() {
        return sell_in < 0;
    }

    protected boolean isSulfuras() {
        return false;
    }

    protected boolean isBackstagePass() {
        return false;
    }

    protected boolean isAgedBrie() {
        return false;
    }
}
