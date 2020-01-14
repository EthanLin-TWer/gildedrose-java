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

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void something() {
        if (!name.equals("Aged Brie")
                && !name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (quality > 0) {
                if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                    quality = quality - 1;
                }
            }
        } else {
            if (quality < 50) {
                quality = quality + 1;

                if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
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

        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
            sellIn = sellIn - 1;
        }

        if (sellIn < 0) {
            if (!name.equals("Aged Brie")) {
                if (!name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (quality > 0) {
                        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
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
}
