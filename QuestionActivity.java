package z1913793.cs.niu.edu.math_tutor_kids_app;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.TimeUnit;

import z1913793.cs.niu.edu.math_tutor_kids_app.utils.Constant;
import z1913793.cs.niu.edu.math_tutor_kids_app.utils.CustomDialogClass;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class QuestionActivity extends Activity implements RewardedVideoAdListener{
    List<Question> quesList;
    ImageView backbutton;
    static int s=0;
    static int correct = 0;
    int qid = 0;
    SharedPreferences sharedpreferences;


    Question currentQ;
    TextView txtQuestion, times;
    Button button1, button2, button3;
    private RewardedVideoAd mAd;
    public static Context contextstat;
    public static ProgressDialog pDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        String method = getIntent().getStringExtra("method");

        sqlitdatabase db = new sqlitdatabase(this);
        db.deleteTable();
        quesList = db.getAllQuestions(method);
        currentQ = quesList.get(qid);

        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);




        backbutton = (ImageView) findViewById(R.id.back5);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAlertDailoge();

            }
        });

        sharedpreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);


        times = (TextView) findViewById(R.id.dailogshow);


        setQuestionView();
        times.setText("");

//
//        CounterClass timer = new CounterClass(Constant.time_inseconds*1000, 1000);
//        timer.start();
//        getSharedPreferences("PREFERENCE", MODE_PRIVATE)
//                .edit()
//                .putBoolean("firstrun", true)
//                .apply();
//



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                getAnswer(button1.getText().toString());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button2.getText().toString());
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button3.getText().toString());
            }
        });



        contextstat=QuestionActivity.this;
        pDialog= new ProgressDialog(QuestionActivity.this);
        pDialog.setCanceledOnTouchOutside(false);
        pDialog.setCancelable(false);

    }//oncreate

    private void CreateAlertDailoge() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Are You Sure want to Exit");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(QuestionActivity.this, MenuOptions.class);

                startActivity(intent);

            }
        });
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(QuestionActivity.this, "", Toast.LENGTH_SHORT).show();

            }
        });

        builder.create();
        builder.show();

    }


    public static int getMyValue(){return correct;}



    public void getAnswer(String AnswerString) {
        if (currentQ.getANSWER().equals(AnswerString)) {


            correct++;

        } else {
            s++;



        }
        if (qid < Constant.questions_number) {


            currentQ = quesList.get(qid);
            setQuestionView();
        } else {

            CustomDialogClass cdd=new CustomDialogClass(QuestionActivity.this);
            cdd.setCanceledOnTouchOutside(false);
            cdd.setCancelable(false);
            if(!((Activity) QuestionActivity.this).isFinishing())
                cdd.show();
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putInt("cscore", correct);
            editor.putInt("iscore", s);
            editor.apply();
//            Intent intent = new Intent(QuestionActivity.this,ResultActivity.class);
//            Bundle b = new Bundle();
//            b.putInt("cscore", correct);
//            b.putInt("iscore", s);
//            intent.putExtras(b);
//            startActivity(intent);
//            finish();
            correct = 0;
            s=0;
        }


    }





    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }


        @Override
        public void onFinish() {

            if (Constant.show_banner_ad
                    && ((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null) {
                boolean firstrun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("firstrun", true);
                if (firstrun){
                    getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                            .edit()
                            .putBoolean("firstrun", false)
                            .apply();
                    pDialog.setMessage(getString(R.string.loading));


                    CustomDialogClass cdd=new CustomDialogClass(QuestionActivity.this);
                    cdd.setCanceledOnTouchOutside(false);
                    cdd.setCancelable(false);
                    //if(!((Activity) QuestionActivity.this).isFinishing())
                    //cdd.show();
                }
                else{
                    Intent intent = new Intent(QuestionActivity.this,ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score", correct);
                    intent.putExtras(b);
                    startActivity(intent);
                    finish();

                }
            }
            else{
                Intent intent = new Intent(QuestionActivity.this,ResultActivity.class);
                Bundle b = new Bundle();
                b.putInt("score", correct);
                intent.putExtras(b);
                startActivity(intent);
                finish();

            }
        }//onfinish

        @Override
        public void onTick(long millisUntilFinished) {
            // TODO Auto-generated method stub

            long millis = millisUntilFinished;
            String hms = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            System.out.println(hms);
            times.setText(hms);






        }


    }

    private void setQuestionView() {

        // the method which will put all things together
        txtQuestion.setText(currentQ.getQUESTION());
        button1.setText(currentQ.getOPTA());
        button2.setText(currentQ.getOPTB());
        button3.setText(currentQ.getOPTC());

        qid++;
    }








    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoCompleted() {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

    }

    @Override
    public void onRewardedVideoAdClosed() {
        CounterClass timer = new CounterClass(Constant.reward_time_inseconds*1000, 1000);
        timer.start();
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
    }




}

