package com.example.android.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button go;
    int loc_of_cor;
    TextView sumTextView;
    TextView result;
    TextView points;
    TextView timer;
    TextView textView3;
    Button b0;
    Button b1;
    Button b2;
    Button b3;
    Button playAgain;
    RelativeLayout rl1;
    GridLayout g;

    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    int score=0;
    int noq=0;

    public void playAgain(View view)
    {score=0;
     noq=0;
     result.setText("");
     rl1.setVisibility(View.VISIBLE);
        g.setVisibility(View.VISIBLE);
     points.setText("0/0");
     timer.setText("30s");
     updatequestion();
        new CountDownTimer(30100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(String.valueOf(millisUntilFinished/1000)+"s");
            }

            @Override
            public void onFinish() {
                timer.setText("0s");
                result.setText("Your score is:"+ Integer.toString(score)+ "/" + Integer.toString(noq));
                playAgain.setVisibility(View.VISIBLE);
                g.setVisibility(View.INVISIBLE);

            }
        }.start();

    }
    public void updatequestion()
    {
        Random r=new Random();
        int a=r.nextInt(21);
        int b=r.nextInt(21);
        sumTextView.setText(Integer.toString(a)+"+"+Integer.toString(b));
        loc_of_cor=r.nextInt(4);
        arrayList.clear();
        for(int i=0;i<4;i++)
        {
            if(i==loc_of_cor)
                arrayList.add(a+b);
            else
            {
                int x=r.nextInt(41);
                while(x==a+b)
                    x=x=r.nextInt(41);
                arrayList.add(x);
            }

        }
        b0.setText(Integer.toString(arrayList.get(0)));
        b1.setText(Integer.toString(arrayList.get(1)));
        b2.setText(Integer.toString(arrayList.get(2)));
        b3.setText(Integer.toString(arrayList.get(3)));

    }
    public void chooseAnswer(View view){
        if(view.getTag().toString().equals(Integer.toString(loc_of_cor))){
            score++;
            result.setText("    CORRECT!");

        }
        else
        {
            result.setText("  INCORRECT!");

        }
       noq++;
        points.setText(Integer.toString(score)+ "/" + Integer.toString(noq));
        updatequestion();
    }
    public void start(View view)
    {
        go.setVisibility(view.INVISIBLE);
        rl1.setVisibility(view.VISIBLE);
        playAgain(findViewById(R.id.playagain));
        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        go=(Button)findViewById(R.id.go);
        sumTextView=(TextView)findViewById(R.id.textView);
        result=(TextView)findViewById(R.id.textView2);
        points=(TextView)findViewById(R.id.score);
        timer=(TextView)findViewById(R.id.timer);
         b0=(Button)findViewById(R.id.button0);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        playAgain=(Button)findViewById(R.id.playagain);
        rl1=(RelativeLayout)findViewById(R.id.rl2);
        g=(GridLayout)findViewById(R.id.g);

    }
}
