package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void basicTest() {
        CombinationApprovals.verifyAllCombinations(this::getGildedRose,
                new String[]{"foo", "+5 Dexterity Vest", "Aged Brie", "Elixir of the Mongoose", "Conjured Mana Cake",
                             "Sulfuras, Hand of Ragnaros", "Backstage passes to a TAFKAL80ETC concert"},
                new Integer[]{-1, 0, 2, 3, 5, 10, 15},
                new Integer[]{0, 5, 7, 20, 49, 80});
    }

    private String getGildedRose(String foo, int sellIn, int quality) {
        Item[] items = new Item[] {new Item(foo, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app.items[0].toString();
    }

}
