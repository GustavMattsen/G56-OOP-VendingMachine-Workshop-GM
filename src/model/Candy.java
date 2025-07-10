package model;

public class Candy extends Product {

    private boolean isSugarFree;

    //Constructor
    public Candy(int id, double price, String productName, boolean isSugarFree) {
        super(id, price, productName);
        this.isSugarFree = isSugarFree;
    }

    //Getter
    public boolean isSugarFree() {
        return isSugarFree;
    }

    //Setter
    public void setSugarFree(boolean sugarFree) {
        this.isSugarFree = sugarFree;
    }


    @Override
    public String examine() {
        return String.format("%s - %.2f kr (%s)",
                getProductName(),
                getPrice(),
                isSugarFree ? "Sugar-free" : "Has sugar");
    }

    @Override
    public String use() {

        return "Mild chance of giving sweet tooth when consumed!";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-- Product Information --").append("\n");
        sb.append("Id: ").append(getId()).append("\n");
        sb.append("Price: ").append(getPrice()).append("\n");
        sb.append("Product Name: ").append(getProductName()).append("\n");
        sb.append("Sugar-free: ").append(isSugarFree()).append("\n");
        sb.append("---------------------------").append("\n");
        return sb.toString();
    }
}
