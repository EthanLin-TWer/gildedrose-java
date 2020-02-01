package com.gildedrose;

import com.gildedrose.items.*;
import org.approvaltests.Approvals;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GildedRoseTest {

    @Test
    public void test() {
        System.out.println("OMGHAI!");

        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new AgedBrie(2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Elixir of the Mongoose", 1, 7), //
                new Sulfuras(0, 80), //
                new Sulfuras(-1, 80),
                new BackstagePass(15, 20),
                new BackstagePass(10, 49),
                new BackstagePass(5, 49),
                new BackstagePass(1, 20),
                // this conjured item does not work properly yet
                new Conjured(3, 6),
                new Conjured(1, 16)};

        GildedRose app = new GildedRose(items);
        ByteArrayOutputStream resultStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(resultStream));

        for (int i = 0; i < 3; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }

        Approvals.verify(resultStream.toString());
    }
}
