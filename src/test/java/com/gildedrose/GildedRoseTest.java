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
            new Item("Normal Item", 10, 20)
    };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(9, items[0].sellIn);
    assertEquals(19, items[0].quality);
}


    @Test
    void normalItem_degradesTwiceAsFastAfterSellDate() {
        Item[] items = {
                new Item("Normal Item", 0, 10)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(8, items[0].quality);
    }







}
