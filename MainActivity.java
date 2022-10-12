package z1913793.cs.niu.edu.math_tutor_kids_app;
//Name: Varun Naraharisetti, Zid: Z1913793
//Name: Devashri Gaikwad, Zid: Z1904619

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    public static String PACKAGE_NAME;
    private Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        PACKAGE_NAME = getApplicationContext().getPackageName();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.btn_play);
        b1.setOnClickListener(v -> {

            Intent intentnew = new Intent(this, MenuOptions.class);
            startActivity(intentnew);
        });
        b2 = findViewById(R.id.btn_options);
        b2.setOnClickListener(v -> {

            Intent intentnew = new Intent(this, VideoActivityguide.class);
            startActivity(intentnew);
        });

    }//end oncreate


    // onClick
    public void onClick(View v) {
        switch (v.getId()) {


            case R.id.btn_quit:
                finish();


                break;


        }//end switch
    }//end onClick
}//end Main Activity
