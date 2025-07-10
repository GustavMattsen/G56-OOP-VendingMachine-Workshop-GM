package model;

public class Chips extends Product {
    private String flavor;

    public Chips(int id, double price, String productName, String flavor) {
        super(id, price, productName);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public String examine() {
        return "Chips: " + getProductName() + " | Flavor: " + flavor + " | Price: $" + getPrice();
    }

    @Override
    public String use() {

        return "Watch out for chips-fingers!";
    }
}
