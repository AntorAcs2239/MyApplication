package com.example.numbergame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,playagain;
    TextView calculation,score,time,result;
    int tag;
    int scor;
    int i;
    int idx;
    boolean click=false;
    int timer=30;
    int totaltry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        playagain=(Button)findViewById(R.id.playagain);
        time=(TextView) findViewById(R.id.time);
        result=(TextView) findViewById(R.id.result);
        calculation=(TextView)findViewById(R.id.calculation);
        score=(TextView)findViewById(R.id.score);
        playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createMath();
                score.setText(""+"0");
                btn1.setEnabled(true);
                btn2.setEnabled(true);
                btn3.setEnabled(true);
                btn4.setEnabled(true);
                playagain.setText(""+"Play Again");
                run();
            }
        });
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                i=1;
//                check();
//                createMath();
//            }
//        });
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                i=2;
//                check();
//                createMath();
//            }
//        });
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                i=3;
//                check();
//                createMath();
//            }
//        });
//        btn4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                i=4;
//                check();
//                createMath();
//            }
//        });
//        new CountDownTimer(5000,1000)
//        {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                btn1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        i=1;
//                        check();
//                        createMath();
//                    }
//                });
//                btn2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        i=2;
//                        check();
//                        createMath();
//                    }
//                });
//                btn3.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        i=3;
//                        check();
//                        createMath();
//                    }
//                });
//                btn4.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        i=4;
//                        check();
//                        createMath();
//                    }
//                });
//            }
//            @Override
//            public void onFinish() {
//                calculation.setText(""+"finished");
//                scor=0;
//                //score.setText(""+scor);
//              btn1.setEnabled(false);
//              btn2.setEnabled(false);
//              btn3.setEnabled(false);
//              btn4.setEnabled(false);
//            }
//        }.start();
    }
    public void run()
    {
        new CountDownTimer(30000,1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {
                result.setText("");
                playagain.setVisibility(View.INVISIBLE);
                time.setText(""+timer);
                timer--;
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        i=1;
                        totaltry++;
                        check();
                        createMath();
                    }
                });
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        i=2;
                        totaltry++;
                        check();
                        createMath();
                    }
                });
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        i=3;
                        totaltry++;
                        check();
                        createMath();
                    }
                });
                btn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        i=4;
                        totaltry++;
                        check();
                        createMath();
                    }
                });
            }
            @Override
            public void onFinish() {
                calculation.setText(""+"finished");
                //score.setText(""+scor);
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
                playagain.setVisibility(View.VISIBLE);
                time.setText(""+"0");
                timer=30;
                double res=(double)(scor*100)/totaltry;
                totaltry=0;
                scor=0;
                result.setText("Percentage is : "+ String.format("%.2f",res)+"%");
            }
        }.start();
    }
    public void createMath()
    {
        int num1=(int)(Math.random()*20)+1;
        int num2=(int)(Math.random()*20)+1;
        calculation.setText(num1+"+"+num2);
        idx=(int)(Math.random()*4)+1;
        if(idx==1)
        {
            btn1.setText(""+(num1+num2));
            int a=(int)(Math.random()*40)+1;
            int b=(int)(Math.random()*40)+1;
            int c=(int)(Math.random()*40)+1;
            if(a==b||a==c)a+=(int)Math.random()*10;
            if(b==c)b+=(int)(Math.random()*10);
            btn2.setText(""+a);
            btn3.setText(""+b);
            btn4.setText(""+c);
        }
        if(idx==2)
        {
            btn2.setText(""+(num1+num2));
            int a=(int)(Math.random()*40)+1;
            int b=(int)(Math.random()*40)+1;
            int c=(int)(Math.random()*40)+1;
            if(a==b||a==c)a+=(int)Math.random()*10;
            if(b==c)b+=(int)(Math.random()*10);
            btn3.setText(""+a);
            btn1.setText(""+b);
            btn4.setText(""+c);
        }
        if(idx==3)
        {
            btn3.setText(""+(num1+num2));
            int a=(int)(Math.random()*40)+1;
            int b=(int)(Math.random()*40)+1;
            int c=(int)(Math.random()*40)+1;
            if(a==b||a==c)a+=(int)Math.random()*10;
            if(b==c)b+=(int)(Math.random()*10);
            btn2.setText(""+a);
            btn1.setText(""+b);
            btn4.setText(""+c);
        }
        if(idx==4)
        {
            btn4.setText(""+(num1+num2));
            int a=(int)(Math.random()*40)+1;
            int b=(int)(Math.random()*40)+1;
            int c=(int)(Math.random()*40)+1;
            if(a==b||a==c)a+=(int)Math.random()*10;
            if(b==c)b+=(int)(Math.random()*10);
            btn2.setText(""+a);
            btn1.setText(""+b);
            btn3.setText(""+c);
        }
    }
    void check()
    {
        if(idx==i)scor++;
        score.setText(""+scor+"/"+totaltry);
    }
}