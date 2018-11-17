package uit.baodc.com.bubbleteastoremanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class OrderActivity extends AppCompatActivity {
    TextView user, quyen;
    SharedPreferences preferences;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_order);
        user = (TextView) findViewById(R.id.user);
        quyen = (TextView) findViewById(R.id.quyen);
        preferences = this.getSharedPreferences("MYFREFS", Context.MODE_PRIVATE);
        String mUser = preferences.getString("user", "Error getting user");
        String mQuyen = preferences.getString("quyen", "Error getting quyen");
        user.setText(mUser);
        quyen.setText(mQuyen);

    }
}
