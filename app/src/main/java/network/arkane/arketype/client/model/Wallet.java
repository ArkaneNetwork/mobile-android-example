package network.arkane.arketype.client.model;

import java.io.Serializable;

public class Wallet implements Serializable {
    private String id;
    private String address;
    private String secretType;
    private String description;
    private String symbol;
    private String gasSymbol;
    private Number balance;
    private Number gasBalance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSecretType() {
        return secretType;
    }

    public void setSecretType(String secretType) {
        this.secretType = secretType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getGasSymbol() {
        return gasSymbol;
    }

    public void setGasSymbol(String gasSymbol) {
        this.gasSymbol = gasSymbol;
    }

    public Number getBalance() {
        return balance;
    }

    public void setBalance(Number balance) {
        this.balance = balance;
    }

    public Number getGasBalance() {
        return gasBalance;
    }

    public void setGasBalance(Number gasBalance) {
        this.gasBalance = gasBalance;
    }
}
