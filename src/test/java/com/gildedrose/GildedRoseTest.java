package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

//    @Test
//    void foo() {
//        Item[] items = new Item[] { new Item("foo", 0, 0) };
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        assertEquals("fixme", app.items[0].name);
//    }
@Test
void normalItem_qualityAndSellInDecrease() {
    Item[] items = {
            new Item("Elixir of the Mongoose", 10, 20)
    };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(9, items[0].sellIn);
    assertEquals(19, items[0].quality);
}


    @Test
    void normalItem_degradesTwiceAsFastAfterSellDate() {
        Item[] items = {
                new Item("Elixir of the Mongoose", 0, 10)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(8, items[0].quality);
    }
    @Test
    void quality_neverNegative() {
        Item[] items = {
                new Item("Elixir of the Mongoose", 5, 0)
        };

        new GildedRose(items).updateQuality();

        assertEquals(0, items[0].quality);
    }
//Special Cases
    @Test
    void agedBrie_increasesInQuality() {
        Item[] items = {
                new Item("Aged Brie", 2, 3)
        };

        new GildedRose(items).updateQuality();

        assertEquals(4, items[0].quality);
    }

    @Test
    void agedBrie_qualityNeverAbove50() {
        Item[] items = {
                new Item("Aged Brie", 2, 50)
        };

        new GildedRose(items).updateQuality();

        assertEquals(50, items[0].quality);
    }

    // Backstage passes to a TAFKAL80ETC concert
    @Test
    void backstagePasses_increaseBy2When10DaysLeft() {
        Item[] items = {
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)
        };

        new GildedRose(items).updateQuality();

        assertEquals(22, items[0].quality);
    }

    @Test
    void backstagePasses_qualityDropsToZeroAfterConcert() {
        Item[] items = {
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)
        };

        new GildedRose(items).updateQuality();

        assertEquals(0, items[0].quality);
    }














}
