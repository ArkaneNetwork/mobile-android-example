package network.arkane.arketype;

import java.io.Serializable;
import java.util.List;

import network.arkane.arketype.client.model.Wallet;

public class WalletListIntentData implements Serializable {
    private List<Wallet> wallets;

    public WalletListIntentData(List<Wallet> wallets) {
        this.wallets = wallets;
    }

    public List<Wallet> getWallets() {
        return wallets;
    }
}
