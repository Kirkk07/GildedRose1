package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String DexterityVest = "+5 Dexterity Vest";
    private static final String elixir = "Elixir of the Mongoose";
    //+5 Dexterity Vest - Elixir of the Mongoose are  or any other items are normal items.
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }



    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateItem(items[i]);
        }
    }
    private void updateItem(Item item) {
        if (isNormalItem(item)) {
            updateNormalItem(item);
        } else if (item.name.equals(AGED_BRIE)) {
            updateAgedBrie(item);
        } else if (item.name.equals(BACKSTAGE)) {
            updateBackstagePass(item);
        }

        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            updateExpiredItem(item);
        }
    }

    private boolean isNormalItem(Item item) {
        return item.name.equals(elixir)
                || item.name.equals(DexterityVest);

    }

    private void updateNormalItem(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
    private void updateAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void updateBackstagePass(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11 && item.quality < 50) {
                item.quality = item.quality + 1;
            }

            if (item.sellIn < 6 && item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }

    private void updateExpiredItem(Item item) {
        if (item.name.equals(AGED_BRIE)) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        } else if (item.name.equals(BACKSTAGE)) {
            item.quality = 0;
        } else {
            if (item.quality > 0 && !item.name.equals(SULFURAS)) {
                item.quality = item.quality - 1;
            }
        }
    }

}
//    public void updateQuality() {
//        for (int i = 0; i < items.length; i++) {
//            if (!items[i].name.equals("Aged Brie")
//                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                if (items[i].quality > 0) {
//                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                        items[i].quality = items[i].quality - 1;
//                    }
//                }
//            } else {
//                if (items[i].quality < 50) {
//                    items[i].quality = items[i].quality + 1;
//
//                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (items[i].sellIn < 11) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//
//                        if (items[i].sellIn < 6) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//                    }
//                }
//            }
//
//            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                items[i].sellIn = items[i].sellIn - 1;
//            }
//
//            if (items[i].sellIn < 0) {
//                if (!items[i].name.equals("Aged Brie")) {
//                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (items[i].quality > 0) {
//                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                                items[i].quality = items[i].quality - 1;
//                            }
//                        }
//                    } else {
//                        items[i].quality = items[i].quality - items[i].quality;
//                    }
//                } else {
//                    if (items[i].quality < 50) {
//                        items[i].quality = items[i].quality + 1;
//                    }
//                }
//            }
//        }
//    }
