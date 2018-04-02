package practicaltest01var07.eim.systems.cs.pub.ro.practicaltest01var07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var07MainActivity extends AppCompatActivity {

    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
    private EditText left_up_val;
    private EditText right_up_val;
    private EditText left_down_val;
    private EditText right_down_val;
    private Button btn;

    Button_Listener my_btn = new Button_Listener();
    private class Button_Listener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.left_button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var07SecondaryActivity.class);
                    if(TextUtils.isDigitsOnly(left_up_val.getText().toString()) == true && TextUtils.isDigitsOnly(right_up_val.getText().toString()) == true &&
                            TextUtils.isDigitsOnly(left_down_val.getText().toString()) == true && TextUtils.isDigitsOnly(right_down_val.getText().toString()) == true) {
                        intent.putExtra("left_up", Integer.parseInt(left_up_val.getText().toString()));
                        intent.putExtra("right_up", Integer.parseInt(right_up_val.getText().toString()));
                        intent.putExtra("left_down", Integer.parseInt(left_down_val.getText().toString()));
                        intent.putExtra("right_down", Integer.parseInt(right_down_val.getText().toString()));
                        startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                        break;
                    }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);

        left_up_val = findViewById(R.id.left_up);
        right_up_val = findViewById(R.id.right_up);
        left_down_val = findViewById(R.id.left_down);
        right_down_val = findViewById(R.id.right_down);

        btn = findViewById(R.id.left_button);
        btn.setOnClickListener(my_btn);
    }
}
