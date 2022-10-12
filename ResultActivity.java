package z1913793.cs.niu.edu.math_tutor_kids_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        SharedPreferences b = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        TextView textResult = (TextView) findViewById(R.id.textResult);

        textResult.setText("Correct answers " + b.getInt("cscore",0));

        TextView textResult3 = (TextView) findViewById(R.id.textResult2);

        textResult3.setText("Incorrect answers " + b.getInt("iscore",0));

        Button b1 = (Button) findViewById(R.id.btn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, MenuOptions.class);
                startActivity(intent);
            }
        });


    }
}
