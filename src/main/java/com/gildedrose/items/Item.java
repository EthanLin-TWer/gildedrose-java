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
                if (quality > 0) {
                    if (!isSulfuras()) {
                        quality = quality - 1;
                    }
                }
            } else {
                quality = 0;
            }
        } else {
            if (quality < 50) {
                quality = quality + 1;
            }
        }
    }

    private void updateSellIn() {
        if (!isSulfuras()) {
            sell_in = sell_in - 1;
        }
    }

    private void updateQuality() {
        if (!isAgedBrie() && !isBackstagePass()) {
            if (quality > 0) {
                if (!isSulfuras()) {
                    quality = quality - 1;
                }
            }
        } else {
            if (quality < 50) {
                quality = quality + 1;

                if (isBackstagePass()) {
                    if (sell_in < 11) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }

                    if (sell_in < 6) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }
                }
            }
        }
    }

    private boolean isExpired() {
        return sell_in < 0;
    }

    protected boolean isSulfuras() {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstagePass() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie() {
        return name.equals("Aged Brie");
    }
}
