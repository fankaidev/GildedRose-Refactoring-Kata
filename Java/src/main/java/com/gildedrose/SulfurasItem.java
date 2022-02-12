package com.gildedrose;

public class SulfurasItem implements Item {

    private final int sellIn;

    private final int quality;

    public static SulfurasItem createItem(int sellIn, int quality) {
        return new SulfurasItem(sellIn, quality);
    }

    @Override
    public String getName() {
        return SULFURAS;
    }

    @Override
    public int getSellIn() {
        return sellIn;
    }

    @Override
    public int getQuality() {
        return quality;
    }

    private SulfurasItem(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public void updateQuality() {
        // do nothing
    }

}
