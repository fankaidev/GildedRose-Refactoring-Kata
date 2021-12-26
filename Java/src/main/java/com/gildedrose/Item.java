package com.gildedrose;

public class Item {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public static final int MAX_QUALITY = 50;
    public static final int BACKSTAGE_DOUBLE_SPEED_MAX_SELLIN = 10;
    public static final int BACKSTAGE_TRIPLE_SPEED_MAX_SELLIN = 5;

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void update() {
        switch (name) {
            case AGED_BRIE:
                updateForAgedBrie();
                break;
            case BACKSTAGE:
                updateForBackstage();
                break;
            case SULFURAS:
                // "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
                break;
            default:
                updateForDefault();
                break;
        }
    }

    /**
     * At the end of each day our system lowers both values for every item
     * Once the sell by date has passed, Quality degrades twice as fast
     */
    private void updateForDefault() {
        decreaseQuality();
        sellIn = sellIn - 1;
        if (sellIn < 0) {
            decreaseQuality();
        }
    }

    /**
     * "Backstage passes", like aged brie, increases in Quality as it's SellIn value approaches
     * Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but Quality drops to 0 after the concert
     */
    private void updateForBackstage() {
        increaseQuality();
        if (sellIn <= BACKSTAGE_DOUBLE_SPEED_MAX_SELLIN) {
            increaseQuality();
        }
        if (sellIn <= BACKSTAGE_TRIPLE_SPEED_MAX_SELLIN) {
            increaseQuality();
        }

        sellIn = sellIn - 1;
        if (sellIn < 0) {
            quality = 0;
        }
    }

    /** "Aged Brie" actually increases in Quality the older it gets */
    private void updateForAgedBrie() {
        increaseQuality();
        sellIn = sellIn - 1;
        if (sellIn < 0) {
            increaseQuality();
        }
    }

    /** The Quality of an item is never negative */
    private void decreaseQuality() {
        if (quality > 0) {
            quality = quality - 1;
        }
    }

    /** The Quality of an item is never more than 50 */
    private void increaseQuality() {
        if (quality < MAX_QUALITY) {
            quality = quality + 1;
        }
    }

}
