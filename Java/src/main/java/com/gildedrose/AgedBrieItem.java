package com.gildedrose;

public class AgedBrieItem implements Item {

    private int sellIn;

    private int quality;

    public static AgedBrieItem createItem(int sellIn, int quality) {
        return new AgedBrieItem(sellIn, quality);
    }

    @Override
    public String getName() {
        return AGED_BRIE;
    }

    @Override
    public int getSellIn() {
        return sellIn;
    }

    @Override
    public int getQuality() {
        return quality;
    }

    private AgedBrieItem(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public void updateQuality() {
        incrQuality();

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            incrQuality();
        }
    }

    private void incrQuality() {
        if (quality < MAX_QUALITY) {
            quality = quality + 1;
        }
    }

}
