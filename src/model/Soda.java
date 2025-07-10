package model;

public class Soda extends Product {
    private boolean isCarbonated;

    public Soda(int id, double price, String productName, boolean isCarbonated) {
        super(id, price, productName);
        this.isCarbonated = isCarbonated;
    }

    public boolean isCarbonated() {
        return isCarbonated;
    }

    public void setCarbonated(boolean carbonated) {
        isCarbonated = carbonated;
    }

    @Override
    public String examine() {
        return "Soda: " + getProductName() + " | Carbonated: " + isCarbonated + " | Price: $" + getPrice();
    }

    @Override
    public String use() {

        return "Drink up!";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-- Product Information --").append("\n");
        sb.append("Id: ").append(getId()).append("\n");
        sb.append("Price: ").append(getPrice()).append("\n");
        sb.append("Product Name: ").append(getProductName()).append("\n");
        sb.append("Sugar-free: ").append(isCarbonated).append("\n");
        sb.append("---------------------------").append("\n");
        return sb.toString();
    }

}
