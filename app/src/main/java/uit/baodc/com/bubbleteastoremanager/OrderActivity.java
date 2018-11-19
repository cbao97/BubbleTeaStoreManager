package uit.baodc.com.bubbleteastoremanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class OrderActivity extends AppCompatActivity {
    TextView user, quyen;
    SharedPreferences preferences;
    int intScene = 0;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        user = (TextView) findViewById(R.id.user);
        quyen = (TextView) findViewById(R.id.quyen);
        preferences = this.getSharedPreferences("MYPREFS", Context.MODE_PRIVATE);

        String mUser = preferences.getString("user", "Error getting user");
        Log.d("Orderactivi", preferences.getString("user", "t"));
        String mQuyen = preferences.getString("quyen", "Error getting quyen");
        user.setText(mUser);
        quyen.setText(mQuyen);

    }

    @Override
    public void onBackPressed() {
        if (intScene == 0) {
            Toast.makeText(getApplicationContext(), "M", Toast.LENGTH_SHORT).show();
        }
    }
}
