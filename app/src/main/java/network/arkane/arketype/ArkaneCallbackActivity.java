package network.arkane.arketype;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ArkaneCallbackActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);

        if (getIntent().getData() != null) {
            final String status = getIntent().getData().getQueryParameter("status");
            if ("success".equalsIgnoreCase(status)) {
                Toast.makeText(getApplicationContext(), "You successfully linked wallets to this application", Toast.LENGTH_LONG)
                        .show();
            } else if ("aborted".equalsIgnoreCase(status)) {
                Toast.makeText(getApplicationContext(), "You did not change the wallets linked to this application", Toast.LENGTH_LONG)
                        .show();
            }
        }

        Intent intent = new Intent(this, TokenActivity.class);
        startActivity(intent);
        finish();
    }

}