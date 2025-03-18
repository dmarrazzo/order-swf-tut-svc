package com.redhat.example;

public class Item {
    private String itemId;
    private String name;
    private int quantity;

    public Item(String itemId, String name, int quantity) {
        this.itemId = itemId;
        this.name = name;
        this.quantity = quantity;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Item item = (Item) o;
        return itemId.equals(item.itemId);
    }

    @Override
    public int hashCode() {
        return itemId.hashCode();
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
