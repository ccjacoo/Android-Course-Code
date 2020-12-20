package com.example.calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;//引用按钮组件
import android.widget.TextView;
import android.widget.EditText;  //引用文本编辑框组件
import android.text.TextUtils;  //TextUtils类用于处理字符串
import java.math.BigDecimal;
import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity{
    private TextView txt;   //显示
    private Button zero,one,two,three,four,five,six,seven,eight,nine,clear,back,add,sub,mul,div,equ,dot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//显示activity_main.xml定义的用户界面
        this.txt = findViewById(R.id.txt);
        this.zero = (Button) findViewById(R.id.zero);
        this.one = (Button) findViewById(R.id.one);
        this.two = (Button) findViewById(R.id.two);
        this.three = (Button) findViewById(R.id.three);
        this.four = (Button) findViewById(R.id.four);
        this.five = (Button) findViewById(R.id.five);
        this.six = (Button) findViewById(R.id.six);
        this.seven = (Button) findViewById(R.id.seven);
        this.eight = (Button) findViewById(R.id.eight);
        this.nine = (Button) findViewById(R.id.nine);
        this.clear = (Button) findViewById(R.id.clear);
        this.back = (Button) findViewById(R.id.back);
        this.add = (Button) findViewById(R.id.add);
        this.sub = (Button) findViewById(R.id.sub);
        this.mul = (Button) findViewById(R.id.mul);
        this.div = (Button) findViewById(R.id.div);
        this.equ = (Button) findViewById(R.id.equ);
        this.dot = (Button) findViewById(R.id.dot);

        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txt.setText(null);
            }
        });
        zero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txt.append(zero.getText().toString());
            }
        });
        one.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txt.append(one.getText().toString());
            }
        });
        two.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txt.append(two.getText().toString());
            }
        });
        three.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txt.append(three.getText().toString());
            }
        });
        four.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txt.append(four.getText().toString());
            }
        });
        five.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txt.append(five.getText().toString());
            }
        });
        six.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txt.append(six.getText().toString());
            }
        });
        seven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txt.append(seven.getText().toString());
            }
        });
        eight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txt.append(eight.getText().toString());
            }
        });
        nine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txt.append(nine.getText().toString());
            }
        });
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txt.setText(txt.getText()+"+");
            }
        });
        sub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txt.setText(txt.getText()+"-");
            }
        });
        mul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txt.setText(txt.getText()+"*");
            }
        });
        div.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txt.setText(txt.getText()+"÷");
            }
        });
        dot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txt.setText(txt.getText()+".");
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=0;//记录覆盖的空格的个数
                String  s = txt.getText().toString();
                for(int i=0;i<s.length();i++)
                    if((s.substring(i,i+1)==""))
                        count++;
                if(count>=s.length()-1)
                    count = s.length()-1;
                s = (String) s.subSequence(0,s.length()-1-count);
                s = s.concat("");
                txt.setText(s);
            }
        });
        equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 0, j = 0, k = 0,count=1;//count 记录小数点后面有几位
                char b;
                String str=txt.getText().toString();
                double data[] = new double[100];//模拟数字栈
                String strr = "";//模拟字符栈
                //入栈
                for (i = 0; i < str.length(); i++) {
                    count=1;
                    data[j]=0;
                    while ((i < str.length()) && (str.substring(i, i + 1).equals("0") || str.substring(i, i + 1).equals("1") || str.substring(i, i + 1).equals("2") || str.substring(i, i + 1).equals("3") || str.substring(i, i + 1).equals("4") || str.substring(i, i + 1).equals("5") || str.substring(i, i + 1).equals("6") || str.substring(i, i + 1).equals("7") || str.substring(i, i + 1).equals("8") || str.substring(i, i + 1).equals("9")) && (j < 100)) {
                        data[j] = data[j] * 10 + Integer.parseInt(str.substring(i, i + 1));
                        i++;
                    }//取数字保存在data中
                    j++;
                    if((i < str.length()) &&(str.substring(i,i+1).equals(".")))
                    {
                        i++;
                        j--;
                        while ((i < str.length()) && (str.substring(i, i + 1).equals("0") || str.substring(i, i + 1).equals("1") || str.substring(i, i + 1).equals("2") || str.substring(i, i + 1).equals("3") || str.substring(i, i + 1).equals("4") || str.substring(i, i + 1).equals("5") || str.substring(i, i + 1).equals("6") || str.substring(i, i + 1).equals("7") || str.substring(i, i + 1).equals("8") || str.substring(i, i + 1).equals("9")) && (j < 100)) {
                            data[j] = data[j] * 10 + Integer.parseInt(str.substring(i, i + 1));
                            i++;
                            count=count*10;
                        }//取数字保存在data中

                        data[j]=data[j]*1.0/count;
                        j++;
                    }
                    if (i >= str.length()) break;
                    if ((k == 0)||(i<str.length())&&(pric(str.charAt(i)) >= pric(strr.charAt(k - 1)))) {
                        strr = strr.concat(str.substring(i, i + 1));
                        k++;
                    }
                    else {//还要考虑一直大于的情况，一直字符串出栈

                        while (k >= 1 && (pric(str.charAt(i)) < pric(strr.charAt(k - 1)))) {
                            j--;
                            k--;
                            b = strr.charAt(k);
                            if (b == '+') data[j - 1] = add(data[j - 1], data[j]);
                            else if (b == '-') data[j - 1] = sub(data[j - 1], data[j]);
                            else if (b == '*') data[j - 1] = mul(data[j - 1], data[j]);
                            else if (b == '÷') data[j - 1] = div(data[j - 1], data[j]);
                        }
                        strr = (String) strr.subSequence(0, k);
                        strr = strr.concat(str.substring(i, i + 1));
                        k++;
                    }
                }
                k--;
                //出栈
                while (k >= 0 && j >= 0) {
                    j--;
                    b = strr.charAt(k);
                    System.out.println("b:" + b);
                    if (b == '+') data[j - 1] = add(data[j - 1], data[j]);
                    else if (b == '-') data[j - 1] = sub(data[j - 1], data[j]);
                    else if (b == '*') data[j - 1] = mul(data[j - 1], data[j]);
                    else if (b == '÷') data[j - 1] = div(data[j - 1], data[j]);
                    k--;
                }
                //防止出现科学计数法
                BigDecimal bgnum = new BigDecimal(data[0]+"");
                txt.setText(txt.getText()+"= \n"+bgnum);
            }
            private  double  add(double a, double b)
            {return a+b; }
            private  double  sub(double a, double b)
            {return a-b; }
            private  double  mul(double a, double b)
            {return a*b; }
            private  double  div(double a, double b)
            {return (a*1.0)/b; }
            private  int  pric(char a)
            {
                if(a=='+')return 1;
                else if(a=='-')return 2;
                else if(a=='*')return 3;
                else if(a=='/')return 4;
                return 0;
            }
        });

    }

}
