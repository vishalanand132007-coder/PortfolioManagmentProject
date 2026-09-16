package com.klu;

import java.util.ArrayList;
import java.util.List;

// Asset class
class Asset {
    private String symbol;

    public Asset(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}

// Holding class
class Holding {
    private Asset asset;
    private int quantity;
    private double purchasePrice;

    public Holding(Asset asset, int quantity, double purchasePrice) {
        this.asset = asset;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
    }

    public void displayHolding() {
        System.out.println(
            asset.getSymbol() +
            " | Quantity: " + quantity +
            " | Purchase Price: ₹" + purchasePrice
        );
    }
}

// User class
class User {
    private String userId;
    private String name;
    private String email;

    // One user can have multiple investments
    private List<Holding> holdings = new ArrayList<>();

    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    // Add investment
    public void addHolding(Holding holding) {
        holdings.add(holding);
    }

    // Display all investments
    public void displayInvestments() {
        System.out.println("User: " + name);
        System.out.println("Investments:");

        for (Holding holding : holdings) {
            holding.displayHolding();
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        User user = new User(
            "U101",
            "Ravi",
            "ravi@gmail.com"
        );

        Asset tcs = new Asset("TCS");
        Asset infosys = new Asset("INFOSYS");
        Asset reliance = new Asset("RELIANCE");

        Holding investment1 =
            new Holding(tcs, 10, 3500);

        Holding investment2 =
            new Holding(infosys, 5, 1500);

        Holding investment3 =
            new Holding(reliance, 8, 2800);

        // Add multiple investments to the same user
        user.addHolding(investment1);
        user.addHolding(investment2);
        user.addHolding(investment3);

        user.displayInvestments();
    }
}