package com.example.myapplication_calculator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
public  class MainActivity extends AppCompatActivity
{
    double firstnum;
    String operation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button num0=findViewById(R.id.num0);
        Button num1=findViewById(R.id.num1);
        Button num2=findViewById(R.id.num2);
        Button num3=findViewById(R.id.num3);
        Button num4=findViewById(R.id.num4);
        Button num5=findViewById(R.id.num5);
        Button num6=findViewById(R.id.num6);
        Button num7=findViewById(R.id.num7);
        Button num8=findViewById(R.id.num8);
        Button num9=findViewById(R.id.num9);
        Button on=findViewById(R.id.on);
        Button sc=findViewById(R.id.sc);
        Button ac=findViewById(R.id.ac);
        Button del=findViewById(R.id.del);
        Button point=findViewById(R.id.point);
        Button div=findViewById(R.id.div);
        Button plus=findViewById(R.id.plus);
        Button min=findViewById(R.id.min);
        Button equal=findViewById(R.id.equal);
        Button times=findViewById(R.id.times);
        TextView screen=findViewById(R.id.screen);
        TextView display = findViewById(R.id.display);
        ac.setOnClickListener(view->
        {
            firstnum=0;
            display.setText("");
            screen.setText("0");
        });
        sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("");
                Intent intent=new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        on.setOnClickListener(view->{
            display.setText("");
            screen.setVisibility(View.VISIBLE);
            screen.setText("0");
        });
        ArrayList<Button> nums=new ArrayList<>();
        nums.add(num0);
        nums.add(num1);
        nums.add(num2);
        nums.add(num3);
        nums.add(num4);
        nums.add(num5);
        nums.add(num6);
        nums.add(num7);
        nums.add(num8);
        nums.add(num9);
        for(Button b:nums){
            b.setOnClickListener(view ->{
                if(!screen.getText().toString().equals("0")){
                    screen.setText(screen.getText().toString()+b.getText().toString());
                }else{
                    screen.setText(b.getText().toString());
                }
            });
        }
        ArrayList <Button> opers=new ArrayList<>();
        opers.add(div);
        opers.add(times);
        opers.add(min);
        opers.add(plus);
        for(Button b:opers){
            b.setOnClickListener(view->{
                firstnum=Double.parseDouble(screen.getText().toString());
                operation=b.getText().toString();
                display.setText(operation);
                screen.setText("0");
            });
        }
        del.setOnClickListener(view->{
            String num=screen.getText().toString();
            display.setText("");
            if(num.length()>1){
                screen.setText(num.substring(0,num.length()-1));
            }else if(num.length()==1 && !num.equals("0")) {
                screen.setText("0");
            }
        });
        point.setOnClickListener(view->{
            if(!screen.getText().toString().contains(".")){
                screen.setText(screen.getText().toString()+".");
            }
        });
        equal.setOnClickListener(view ->{
            double secondNum=Double.parseDouble(screen.getText().toString());
            double result;
            switch (operation){
                case "/":
                    display.setText(firstnum+operation+secondNum);
                    result=firstnum/secondNum;
                    break;
                case "x":
                    display.setText(firstnum+operation+secondNum);
                    result=firstnum*secondNum;
                    break;
                case "-":
                    display.setText(firstnum+operation+secondNum);
                    result=firstnum-secondNum;
                    break;
                case "+":
                    display.setText(firstnum+operation+secondNum);
                    result=firstnum+secondNum;
                    break;
                default:
                    display.setText(firstnum+operation+secondNum);
                    result=firstnum+secondNum;

            }
            screen.setText(String.valueOf(result));
            firstnum=result;
        });
    }
}