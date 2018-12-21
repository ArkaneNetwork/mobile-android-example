package network.arkane.arketype;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ArkaneCallbackActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        Intent intent = new Intent(this, TokenActivity.class);
        startActivity(intent);
        finish();
    }

}