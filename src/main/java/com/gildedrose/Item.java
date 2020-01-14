package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    static Item createAgedBrie(int sellIn, int quality) {
        return new Item("Aged Brie", sellIn, quality);
    }

    static Item createSulfuras(int sellIn, int quality) {
        return new Item("Sulfuras, Hand of Ragnaros", sellIn, quality);
    }

    void updateQuality() {
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
                    if (sellIn < 11) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }

                    if (sellIn < 6) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }
                }
            }
        }

        if (!isSulfuras()) {
            sellIn = sellIn - 1;
        }

        if (sellIn < 0) {
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
    }

    private boolean isSulfuras() {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstagePass() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie() {
        return name.equals("Aged Brie");
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
