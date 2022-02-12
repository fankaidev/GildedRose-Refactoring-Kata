package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void basicTest() {
        CombinationApprovals.verifyAllCombinations(this::getGildedRose,
                new String[]{"foo", "+5 Dexterity Vest", "Aged Brie", "Elixir of the Mongoose", "Conjured Mana Cake",
                             "Sulfuras, Hand of Ragnaros", "Backstage passes to a TAFKAL80ETC concert"},
                new Integer[]{-1, 0, 1, 2, 3, 5, 6, 9, 10, 11, 12, 15},
                new Integer[]{0, 5, 7, 20, 49, 50, 80});
    }

    private String getGildedRose(String foo, int sellIn, int quality) {
        Item[] items = new Item[] {Item.createItem(foo, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app.items[0].getInfo();
    }

}
