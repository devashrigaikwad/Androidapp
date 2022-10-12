package z1913793.cs.niu.edu.math_tutor_kids_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenuOptions extends Activity {
    ImageView b1,b2,b3,b4,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_menu);


        b1 = (ImageView) findViewById(R.id.btnaddition);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuOptions.this, QuestionActivity.class);
                intent.putExtra("method", "plus");

                startActivity(intent);
            }//end onClick
        });//end setOnClickListener


        b2 = (ImageView) findViewById(R.id.btnsubtraction);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuOptions.this, QuestionActivity.class);
                intent.putExtra("method", "moins");

                startActivity(intent);
            }//end onClick
        });//end setOnClickListener


        b3 = (ImageView) findViewById(R.id.btnmultiplication);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuOptions.this, QuestionActivity.class);
                intent.putExtra("method", "fois");

                startActivity(intent);
            }//end onClick
        });//end setOnClickListener

        b4 = (ImageView) findViewById(R.id.btndivision);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuOptions.this, QuestionActivity.class);
                intent.putExtra("method", "sur");

                startActivity(intent);
            }//end onClick
        });//end setOnClickListener

        back = (ImageView) findViewById(R.id.back4);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuOptions.this, MainActivity.class);

                startActivity(intent);
            }//end onClick
        });//end setOnClickListener
    }//end onCreate
}//end Menu options
