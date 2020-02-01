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

    private void decreaseQuality() {
        if (quality > 0) {
            quality = quality - 1;
        }
    }

    protected void increaseQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    protected void updateSellIn() {
        sell_in = sell_in - 1;
    }

    protected void updateQualityAfterExpiration() {
        decreaseQuality();
    }

    protected void updateQuality() {
        decreaseQuality();
    }

    private boolean isExpired() {
        return sell_in < 0;
    }
}
