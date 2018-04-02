package practicaltest01var07.eim.systems.cs.pub.ro.practicaltest01var07;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var07SecondaryActivity extends AppCompatActivity {

    private EditText left_up_val;
    private EditText right_up_val;
    private EditText left_down_val;
    private EditText right_down_val;
    private int val1;
    private int val2;
    private int val3;
    private int val4;

    Button sum_button;
    Button prod_button;

    MyListener my_listener = new MyListener();
    private class MyListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.sum:
                    int suma = val1 + val2 + val3 + val4;
                    Toast.makeText(getApplicationContext(), "The activity returned with result " + suma, Toast.LENGTH_LONG).show();
                    break;
                case R.id.product:
                    int produs = val1 * val2 * val3 * val4;
                    Toast.makeText(getApplicationContext(), "The activity returned with result " + produs, Toast.LENGTH_LONG).show();
                    break;
            }

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_secondary);

        left_up_val = findViewById(R.id.left_up_sec);
        right_up_val = findViewById(R.id.right_up_sec);
        left_down_val = findViewById(R.id.left_down_sec);
        right_down_val = findViewById(R.id.right_down_sec);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("left_up") && intent.getExtras().containsKey("right_up") &&
                intent.getExtras().containsKey("left_down") && intent.getExtras().containsKey("right_down")) {
            val1 = intent.getIntExtra("left_up", -1);
            val2 = intent.getIntExtra("right_up", -1);
            val3 = intent.getIntExtra("left_down", -1);
            val4 = intent.getIntExtra("right_down", -1);
            left_up_val.setText(String.valueOf(val1));
            right_up_val.setText(String.valueOf(val2));
            left_down_val.setText(String.valueOf(val3));
            right_down_val.setText(String.valueOf(val4));
        }

        sum_button = findViewById(R.id.sum);
        prod_button = findViewById(R.id.product);
        sum_button.setOnClickListener(my_listener);
        prod_button.setOnClickListener(my_listener);

    }

}
