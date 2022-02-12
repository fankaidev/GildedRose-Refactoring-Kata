package com.gildedrose;

public class BackstageItem implements Item {

    public static final int SELLIN_THRESHOLD_DOUBLE_PACE = 11;
    public static final int SELLIN_THRESHOLD_TRIPLE_PACE = 6;

    private int sellIn;

    private int quality;

    public static BackstageItem createItem(int sellIn, int quality) {
        return new BackstageItem(sellIn, quality);
    }

    @Override
    public String getName() {
        return BACKSTAGE;
    }

    @Override
    public int getSellIn() {
        return sellIn;
    }

    @Override
    public int getQuality() {
        return quality;
    }

    private BackstageItem(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public void updateQuality() {
        incrQuality();

        if (sellIn < SELLIN_THRESHOLD_DOUBLE_PACE) {
            incrQuality();
        }

        if (sellIn < SELLIN_THRESHOLD_TRIPLE_PACE) {
            incrQuality();
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            quality = 0;
        }
    }

    private void incrQuality() {
        if (quality < MAX_QUALITY) {
            quality = quality + 1;
        }
    }

}
