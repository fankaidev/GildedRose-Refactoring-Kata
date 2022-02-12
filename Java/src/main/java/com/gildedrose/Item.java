package com.gildedrose;

public class Item {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final int MAX_QUALITY = 50;
    public static final int SELLIN_THRESHOLD1 = 11;
    public static final int SELLIN_THRESHOLD2 = 6;

    private final String name;

    private int sellIn;

    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void updateQuality() {
        updateQualityBeforeUpdateSellin();

        updateSellin();

        updateQualityAfterUpdateSellin();
    }

    private void updateSellin() {
        if (!isSulfuras()) {
            sellIn = sellIn - 1;
        }
    }

    private void updateQualityAfterUpdateSellin() {
        if (sellIn < 0) {
            if (isAgedBrie()) {
                incrQuality();
            } else if (isBackstage()) {
                quality = 0;
            } else {
                descQuality();
            }
        }
    }

    private void descQuality() {
        if (quality > 0) {
            if (!isSulfuras()) {
                quality = quality - 1;
            }
        }
    }

    private void updateQualityBeforeUpdateSellin() {
        if (isAgedBrie() || isBackstage()) {
            incrQuality();

            if (isBackstage()) {
                if (sellIn < SELLIN_THRESHOLD1) {
                    incrQuality();
                }

                if (sellIn < SELLIN_THRESHOLD2) {
                    incrQuality();
                }
            }
        } else {
            descQuality();
        }
    }

    private void incrQuality() {
        if (quality < MAX_QUALITY) {
            quality = quality + 1;
        }
    }

    private boolean isSulfuras() {
        return name.equals(SULFURAS);
    }

    private boolean isBackstage() {
        return name.equals(BACKSTAGE);
    }

    private boolean isAgedBrie() {
        return name.equals(AGED_BRIE);
    }
}
