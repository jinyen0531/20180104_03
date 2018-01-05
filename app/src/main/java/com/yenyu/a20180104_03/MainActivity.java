package com.yenyu.a20180104_03;

import android.media.MediaDataSource;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner sp,sp2;
    ArrayList<String> data;
    TextView tv,tv2,tv3;
    Button bt;
    EditText ed;
    ArrayAdapter <String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp= (Spinner) findViewById(R.id.spinner);
        sp2= (Spinner) findViewById(R.id.spinner2);
        tv= (TextView) findViewById(R.id.textView);
        tv2= (TextView) findViewById(R.id.textView2);
        tv3= (TextView) findViewById(R.id.textView3);
        bt= (Button) findViewById(R.id.button);
        ed= (EditText) findViewById(R.id.editText);

        data = new ArrayList<>(); //先寫ArrayList
        data.add("head"); //新增資料
        data.add("toe");
        data.add("hand");



        adapter = new ArrayAdapter<String>(
                MainActivity.this,android.R.layout.simple_list_item_1,data
        );
        //利用Adapter連接 ArrayList 到 Spinner
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tv.setText(data.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str[] = getResources().getStringArray(R.array.cities);
                //從resources 取出 array.cities
                tv3.setText(str[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }

    public void click1(View v) //點擊後抓取到Spinner的內容顯示到TextView
    {
        int pos=sp.getSelectedItemPosition(); //標準做法
        tv2.setText(data.get(pos));
    }

    public void clickAdd(View v) //點擊後新增內容到 Spinner
    {
        data.add(ed.getText().toString());
        adapter.notifyDataSetChanged(); //提醒系統更動內容
    }

    public void clickDelete(View v) //點擊後刪除Spinner內部選項
    {
        data.remove(sp.getSelectedItemPosition());
        adapter.notifyDataSetChanged(); //提醒系統更動內容
    }
}
