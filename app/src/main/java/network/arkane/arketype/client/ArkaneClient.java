package network.arkane.arketype.client;

import android.support.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import network.arkane.arketype.client.model.Wallet;
import okio.Okio;

public class ArkaneClient {


    public List<Wallet> getWallets(String accessToken) {
        try {
            URL walletsEndpoint = new URL("https://api-staging.arkane.network/api/wallets");
            HttpURLConnection conn =
                    (HttpURLConnection) walletsEndpoint.openConnection();
            conn.setRequestProperty("Authorization", "Bearer " + accessToken);
            conn.setInstanceFollowRedirects(false);
            String response = Okio.buffer(Okio.source(conn.getInputStream()))
                    .readString(Charset.forName("UTF-8"));
            return mapToWallets(response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    private List<Wallet> mapToWallets(String responseData) throws JSONException {
        JSONObject json = new JSONObject(responseData);
        JSONArray result = (JSONArray) json.get("result");
        List<Wallet> wallets = new ArrayList<>();
        for (int i = 0; i < result.length(); i++) {
            wallets.add(this.mapToWallet(result.getJSONObject(i)));
        }
        return wallets;
    }

    @NonNull
    private Wallet mapToWallet(JSONObject result) {
        try {
            Wallet wallet = new Wallet();
            wallet.setId((String) result.get("id"));
            wallet.setAddress((String) result.get("address"));
            wallet.setSecretType((String) result.get("secretType"));
            wallet.setDescription((String) result.get("description"));
            return wallet;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
