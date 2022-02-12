package com.gildedrose;

public class NormalItem implements Item {

    private final String name;

    private int sellIn;

    private int quality;

    public static NormalItem createItem(String name, int sellIn, int quality) {
        return new NormalItem(name, sellIn, quality);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSellIn() {
        return sellIn;
    }

    @Override
    public int getQuality() {
        return quality;
    }

    private NormalItem(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public void updateQuality() {
        descQuality();

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            descQuality();
        }
    }

    private void descQuality() {
        if (quality > 0) {
            quality = quality - 1;
        }
    }

}
