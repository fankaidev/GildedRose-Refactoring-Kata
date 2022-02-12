/**
 * @(#)Item.java, 2022/2/12.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * YUANFUDAO.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.gildedrose;

public interface Item {

    String AGED_BRIE = "Aged Brie";
    String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    String SULFURAS = "Sulfuras, Hand of Ragnaros";
    int MAX_QUALITY = 50;

    String getName();

    int getSellIn();

    int getQuality();

    default String getInfo() {
         return getName() + ", " + getSellIn() + ", " + getQuality();
     }

    static Item createItem(String name, int sellIn, int quality) {
        if (name.equals(SULFURAS)) {
            return SulfurasItem.createItem(sellIn, quality);
        } else if (name.equals(BACKSTAGE)) {
            return BackstageItem.createItem(sellIn, quality);
        } else if (name.equals(AGED_BRIE)) {
            return AgedBrieItem.createItem(sellIn, quality);
        } else {
            return NormalItem.createItem(name, sellIn, quality);
        }
    }

    void updateQuality();
}
