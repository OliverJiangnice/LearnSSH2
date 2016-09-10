package com.example.oliverjiang.dialog;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;
    private Button button3;
    private Button buttondp;
    private Button ProgressDialo;
    private Button button5;

    private int year;
    private int monthOfYear;
    private int dayOfYear;
    //1.声明charsequence数组
    private final CharSequence[] hello = {"北京","上海","广州"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        buttondp = (Button)findViewById(R.id.buttondp);
        button5 = (Button)findViewById(R.id.button5);
        //自定义
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Copy ddd= new Copy(MainActivity.this);

                ddd.show();
           }
        });
        //Datepickerdialog
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        monthOfYear = calendar.get(Calendar.MONTH);
        dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);

        buttondp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    }
                }, year, monthOfYear, dayOfYear);
                datePickerDialog.show();
            }
        });
        //多选带按钮
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
                ab.setTitle("请选择城市");

                ab.setMultiChoiceItems(hello, new boolean[]{false,false,false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                });
                ab.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       //dialog.dismiss();
                    }
                });
                ab.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog ad = ab.create();
                ad.show();

            }
        });
        //单选
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
                ab.setIcon(R.drawable.dog);
                ab.setTitle("请选择城市");

                ab.setSingleChoiceItems(hello, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    CharSequence xx = hello[which];//xx表示选中的城市
                        Toast.makeText(MainActivity.this,"--->"+xx,Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                AlertDialog ad = ab.create();
                ad.show();
            }
        });
        //最原始的对话框，没有确定或取消按钮
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ab= new AlertDialog.Builder(MainActivity.this);
                ab.setTitle("城市列表");
                ab.setIcon(R.drawable.dog);
                ab.setItems(hello, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        CharSequence xx = hello[which];
                        Toast.makeText(MainActivity.this,"--->"+xx,Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog ad = ab.create();
                ad.show();
            }
        });
        //带button按钮的dialog
        AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
        ab.setTitle("小提示");
        ab.setMessage("你确定要删除吗？");
        ab.setIcon(R.drawable.dog);
        ab.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        ab.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        ab.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        final AlertDialog dialog = ab.create();
        dialog.show();

        //ProgressDialo的用法
        ProgressDialo = (Button)findViewById(R.id.ProgressDialo);
        ProgressDialo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ProgressDialog dialog1 = new ProgressDialog(MainActivity.this);
//                dialog1.setIcon(R.drawable.dog);
                dialog1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                dialog1.setTitle("downing");
                dialog1.setMessage("please wait.....");
                dialog1.show();
            }
        });
    }

}
