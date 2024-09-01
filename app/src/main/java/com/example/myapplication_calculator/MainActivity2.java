package com.example.myapplication_calculator;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
public class MainActivity2 extends AppCompatActivity {
    double firstnum;
    String operation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView display=findViewById(R.id.display);
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
        Button off=findViewById(R.id.off);
        Button ac=findViewById(R.id.ac);
        Button fact=findViewById(R.id.fact);
        Button del=findViewById(R.id.del);
        Button dot=findViewById(R.id.dot);
        Button plus=findViewById(R.id.plus);
        Button min=findViewById(R.id.min);
        Button equals=findViewById(R.id.equals);
        Button pow2x=findViewById(R.id.pow2x);
        Button sin=findViewById(R.id.sin);
        Button cos=findViewById(R.id.cos);
        Button tan=findViewById(R.id.tan);
        Button sqroot=findViewById(R.id.sqroot);
        Button cuberoot=findViewById(R.id.cuberoot);
        Button pi=findViewById(R.id.pi);
        Button ln=findViewById(R.id.ln);
        Button lg=findViewById(R.id.lg);
        Button div=findViewById(R.id.div);
        Button powx10=findViewById(R.id.powx10);
        Button mod=findViewById(R.id.mod);
        Button openpara=findViewById(R.id.openpara);
        Button closedpara=findViewById(R.id.closedpara);
        Button mul=findViewById(R.id.mul);
        Button epowx=findViewById(R.id.epowx);
        Button divby1=findViewById(R.id.divby1);
        Button xpowy=findViewById(R.id.xpowy);
        Button square=findViewById(R.id.square);
        Button cube=findViewById(R.id.cube);
        TextView screen=findViewById(R.id.screen);
        on.setOnClickListener(view->{
            screen.setVisibility(View.VISIBLE);
            screen.setText("0");
            display.setText("");
        });
        sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("");
                Intent intent=new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        ac.setOnClickListener(view->
        {
            firstnum=0;
            screen.setText("0");
            display.setText("");
        });
        off.setOnClickListener(view->{
            display.setText("");
            screen.setVisibility(View.GONE);
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
        opers.add(mul);
        opers.add(min);
        opers.add(plus);
        opers.add(mod);
        opers.add(fact);
        opers.add(sin);
        opers.add(cos);
        opers.add(tan);
        opers.add(square);
        opers.add(cube);
        opers.add(sqroot);
        opers.add(cuberoot);
        opers.add(pi);
        opers.add(ln);
        opers.add(powx10);
        opers.add(epowx);
        opers.add(pow2x);
        opers.add(divby1);
        opers.add(xpowy);
        for(Button b:opers){
            b.setOnClickListener(view->{
                firstnum  = Double.parseDouble(screen.getText().toString());
                operation=b.getText().toString();
                switch(operation){
                    case "e^x":
                        display.setText("e^");
                        break;
                    case "10^x":
                        display.setText("10^");
                        break;
                    case "1/x":
                        display.setText("1/");
                        break;
                    case "x!":
                        display.setText("!");
                        break;
                    case "2^x":
                        display.setText("2^");
                    default:
                        display.setText(operation);
                }
                screen.setText("0");
            });
        }
        del.setOnClickListener(view->{
            String num=screen.getText().toString();
            if(num.length()>1){
                screen.setText(num.substring(0,num.length()-1));
            }else if(num.length()==1 && !num.equals("0")) {
                screen.setText("0");
            }
            display.setText("");
        });
        dot.setOnClickListener(view->{
            if(!screen.getText().toString().contains(".")){
                screen.setText(screen.getText().toString()+".");
            }
        });
        openpara.setOnClickListener(view->{
                screen.setText(screen.getText().toString()+"(");
        });
        closedpara.setOnClickListener(view->{
            screen.setText(screen.getText().toString()+")");
        });
        equals.setOnClickListener(view ->{
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
                case "%":
                    display.setText(firstnum+operation+secondNum);
                    result=firstnum%secondNum;
                    break;
                case "x^2":
                    display.setText(firstnum+"^2");
                    result=firstnum*firstnum;
                    break;
                case "x^3":
                    display.setText(firstnum+"^3");
                    result=firstnum*firstnum*firstnum;
                    break;
                case "π":
                    display.setText(firstnum+"π");
                    secondNum=1;
                    result=Math.PI*firstnum;
                    break;
                case "lg":
                    display.setText("lg"+secondNum);
                    result=Math.log10(secondNum);
                    break;
                case "ln":
                    display.setText("ln"+secondNum);
                    result=Math.log(secondNum);
                    break;
                case "sin":
                    display.setText("sin"+secondNum);
                    result=Math.sin(Math.toRadians(secondNum));
                    break;
                case "cos":
                    display.setText("cos"+secondNum);
                    result=Math.cos(Math.toRadians(secondNum));
                    break;
                case "tan":
                    display.setText("tan"+secondNum);
                    result=Math.tan(Math.toRadians(secondNum));
                    break;
                case "√":
                    display.setText("√"+secondNum);
                    result=Math.sqrt(secondNum);
                    break;
                case "3√":
                    display.setText("3√"+secondNum);
                    result=Math.cbrt(secondNum);
                    break;
                case "^":
                    display.setText(firstnum+"^"+secondNum);
                    result=Math.pow(firstnum,secondNum);
                    break;
                case "e^x":
                    display.setText("e^"+secondNum);
                    result=Math.exp(secondNum);
                    break;
                case "1/x":
                    display.setText("1/"+secondNum);
                    result=1/secondNum;
                    break;
                case "10^x":
                    display.setText("10^"+secondNum);
                    result=Math.pow(10,secondNum);
                    break;
                case "x!":
                    display.setText(firstnum+"!");
                    result=factorial(firstnum);
                    break;
                case "2^x":
                    display.setText("2^"+secondNum);
                    result=Math.pow(2,secondNum);
                    break;
                default:
                    display.setText(firstnum+operation+secondNum);
                    result=firstnum+secondNum;
            }
           String first=String.valueOf(firstnum);
            String second=String.valueOf(secondNum);
            if(!first.contains(".") || !second.contains(".")) {
                String res = String.valueOf(result);
                int n=res.indexOf(".");
                screen.setText(String.valueOf(res.substring(0,n-1)));

            }else{
                screen.setText(String.valueOf(result));

            }



            firstnum=result;
        });
    }
    public double factorial(double n){
        if(n==1 || n==0){
            return 1;
        }else {
            return n * factorial(n-1);
        }
    }
}