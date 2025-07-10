package model;

public class VendingMachineImpl implements VendingMachine {

    private final Product[] products;
    private int depositPool;

    //Accepted denominations
    private final int[] validDenominations = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};

    //Constructor
    public VendingMachineImpl(Product[] products) {
        this.products = products;
        this.depositPool = 0;
    }

    @Override
    public void addCurrency(int amount) {
        if (isValidDenomination(amount)) {
            depositPool += amount;
        } else {
            System.out.println("Currency is invalid: " + amount + " SEK not accepted.");
        }
    }

    private boolean isValidDenomination(int amount) {
        for (int valid : validDenominations) {
            if (valid == amount) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public Product request(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                int roundedPrice = (int) Math.round(product.getPrice()); //Round up or down, please and thank you

                if (depositPool >= roundedPrice) {
                    depositPool -= roundedPrice;
                    return product;
                } else {
                    System.out.println("Not enough balance to buy: " + product.getProductName());
                    return null;
                }
            }
        }
        System.out.println("Product with ID " + id + " not found.");
        return null;
    }

    @Override
    public int endSession() {
        int change = depositPool;
        depositPool = 0;
        return change;
    }

    @Override
    public String getDescription(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product.examine();
            }
        }
        return "Product with ID " + id + " not found.";
    }

    @Override
    public String[] getProducts() {
        String[] result = new String[products.length];
        for (int i = 0; i < products.length; i++) {
            result[i] = String.format("ID: %d | Name: %s | Price: %.2f kr",
                    products[i].getId(),
                    products[i].getProductName(),
                    products[i].getPrice());
        }
        return result;
    }
}
