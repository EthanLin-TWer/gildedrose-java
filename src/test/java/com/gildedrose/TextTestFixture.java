package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.Sulfuras;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TextTestFixture {
    public static void main(String[] args) {
        System.out.println(generateBaselineOutput());
    }

    public static String generateBaselineOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        printStream.println("OMGHAI!");

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new AgedBrie(2, 0),
                new Item("Elixir of the Mongoose", 5, 7), //
                new Sulfuras(0, 80),
                new Sulfuras(-1, 80),
                Item.createBackstagePass(15, 20),
                Item.createBackstagePass(10, 49),
                Item.createBackstagePass(5, 49),
                Item.createBackstagePass(1, 20),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        for (int i = 0; i < 3; i++) {
            printStream.println("-------- day " + i + " --------");
            printStream.println("name, sellIn, quality");
            for (Item item : items) {
                printStream.println(item);
            }
            printStream.println();
            app.updateQuality();
        }

        return outputStream.toString();
    }

}
