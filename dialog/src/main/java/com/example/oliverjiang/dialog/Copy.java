package com.example.oliverjiang.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/2/19.
 */
public class Copy {
    private Context context;
    private Dialog dialog;

    public  Copy(Context context){
        this.context = context;
        dialog = new Dialog(context);
    }
    public void show(){
        //在这对自定义对话框进行设置
        View view = LayoutInflater.from(context).inflate(R.layout.copy_main, null);
        dialog.setContentView(view);
        dialog.setTitle("我是自定义对话框");
        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText("hello2");
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.dog);
        dialog.show();
    }
}
