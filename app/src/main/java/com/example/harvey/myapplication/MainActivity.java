package com.example.harvey.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    TextView txv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txv=(TextView)findViewById(R.id.textView2);

        int [] id={R.id.hamburger,R.id.coke,R.id.chips,R.id.soup};
        CheckBox chk;
        for (int i:id){
            chk=(CheckBox) findViewById(i);
            chk.setOnCheckedChangeListener(this);

        }
    }

    public void showOrder(View v){
       // txv.setText("order");
        String msg="";
        //int [] id={R.id.hamburger,R.id.coke,R.id.chips,R.id.soup};
       // CheckBox chk;
        /*
        for (int i:id){
            chk=(CheckBox) findViewById(i);
            if(chk.isChecked()){
                msg+="\n"+chk.getText();
            }

        }
        */
        for (CompoundButton chk:selected){
            msg+="\n"+chk.getText();
        }
        if (msg.length()>0)
            msg="你点购的是："+msg;
        else
            msg="请点餐";
        txv.setText(msg);
    }

    protected void show(){
        // txv.setText("order");
        String msg="";
        //int [] id={R.id.hamburger,R.id.coke,R.id.chips,R.id.soup};
        // CheckBox chk;
        /*
        for (int i:id){
            chk=(CheckBox) findViewById(i);
            if(chk.isChecked()){
                msg+="\n"+chk.getText();
            }

        }
        */
        for (CompoundButton chk:selected){
            msg+="\n"+chk.getText();
        }
        if (msg.length()>0)
            msg="你点购的是："+msg;
        else
            msg="请点餐";
        txv.setText(msg);
    }


    ArrayList<CompoundButton> selected=new ArrayList<>();
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(isChecked)
            selected.add(buttonView);
        else
            selected.remove(buttonView);

        show();
    }
}
