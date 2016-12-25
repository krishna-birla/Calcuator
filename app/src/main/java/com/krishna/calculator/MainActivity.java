package com.krishna.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button_type;
    private Button button_0;
    private Button button_1;
    private Button button_2;
    private Button button_3;
    private Button button_4;
    private Button button_5;
    private Button button_6;
    private Button button_7;
    private Button button_8;
    private Button button_9;
    private Button button_dt;
    private Button button_clr;
    private Button button_eq;
    private Button button_e;
    private Button button_pi;
    private Button button_pow;
    private Button button_fact;
    private Button button_root;
    private Button button_mul;
    private Button button_sum;
    private Button button_sub;
    private Button button_div;
    private Button button_pm;
    private Button button_per;
    private TextView text_cur;
    private TextView text_buf;
    private float cur1=0,cur2=0,buf=0;
    private String text_c1="",text_c2="",text_b="",but="";
    private int bin_op_on=0,un_op_on=0,limit=0,dot=0,type=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_type = (Button) findViewById(R.id.button_type);
        button_type.setText("RAD");
        button_type.setOnClickListener(this);

        button_0 = (Button) findViewById(R.id.button_0);
        button_0.setOnClickListener(this);

        button_1 = (Button) findViewById(R.id.button_1);
        button_1.setOnClickListener(this);

        button_2 = (Button) findViewById(R.id.button_2);
        button_2.setOnClickListener(this);

        button_3 = (Button) findViewById(R.id.button_3);
        button_3.setOnClickListener(this);

        button_4 = (Button) findViewById(R.id.button_4);
        button_4.setOnClickListener(this);

        button_5 = (Button) findViewById(R.id.button_5);
        button_5.setOnClickListener(this);

        button_6 = (Button) findViewById(R.id.button_6);
        button_6.setOnClickListener(this);

        button_7 = (Button) findViewById(R.id.button_7);
        button_7.setOnClickListener(this);

        button_8 = (Button) findViewById(R.id.button_8);
        button_8.setOnClickListener(this);

        button_9 = (Button) findViewById(R.id.button_9);
        button_9.setOnClickListener(this);

        button_dt = (Button) findViewById(R.id.button_dt);
        button_dt.setOnClickListener(this);

        button_pm = (Button) findViewById(R.id.button_pm);
        button_pm.setOnClickListener(this);

        button_fact = (Button) findViewById(R.id.button_fact);
        button_fact.setOnClickListener(this);

        button_root = (Button) findViewById(R.id.button_root);
        button_root.setOnClickListener(this);

        button_pow = (Button) findViewById(R.id.button_pow);
        button_pow.setOnClickListener(this);

        button_mul = (Button) findViewById(R.id.button_mul);
        button_mul.setOnClickListener(this);

        button_div = (Button) findViewById(R.id.button_div);
        button_div.setOnClickListener(this);

        button_sum = (Button) findViewById(R.id.button_sum);
        button_sum.setOnClickListener(this);

        button_sub = (Button) findViewById(R.id.button_sub);
        button_sub.setOnClickListener(this);

        button_eq = (Button) findViewById(R.id.button_eq);
        button_eq.setOnClickListener(this);

        button_per = (Button) findViewById(R.id.button_per);
        button_per.setOnClickListener(this);

        button_clr = (Button) findViewById(R.id.button_clr);
        button_clr.setOnClickListener(this);

        button_pi = (Button) findViewById(R.id.button_pi);
        button_pi.setOnClickListener(this);

        button_e = (Button) findViewById(R.id.button_e);
        button_e.setOnClickListener(this);

        text_cur = (TextView) findViewById(R.id.text_cur);

        text_buf = (TextView) findViewById(R.id.text_buf);

        button_clr.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                cur1=0;
                cur2=0;
                buf=0;
                text_c1="";
                text_c2="";
                text_b="";
                but="";
                dot=0;
                limit=0;
                bin_op_on=0;
                un_op_on=0;
                text_cur.setText(text_c1+but+text_c2);
                text_buf.setText(text_b);
                Toast.makeText(getApplicationContext(), "Clear", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button_type: {
                if (type == 1) {
                    button_type.setText("DEG");
                } else {
                    button_type.setText("RAD");
                }
                type *= -1;
                break;
            }
            case R.id.button_0:{
                if(text_c1=="Undefined !" || text_c1=="Can't Divide By 0 :(" || text_c1=="Math Error :(" || text_c1=="Infinity"){
                    break;
                }
                if(limit<8){
                    if(bin_op_on==0){
                            text_c1 = text_c1 + "0";
                            limit++;
                            text_cur.setText(text_c1 + but + text_c2);
                            cur1 = Float.parseFloat(text_c1);
                    }
                    else{
                            text_c2 = text_c2 + "0";
                            limit++;
                            text_cur.setText(text_c1 + but + text_c2);
                            cur2 = Float.parseFloat(text_c2);
                        switch(but){
                            case "+":{
                                buf=cur1+cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "-":{
                                buf=cur1-cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "×":{
                                buf=cur1*cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "÷":{
                                if(cur2==0){
                                    if(cur1==0){
                                        text_b="Undefined !";
                                        text_buf.setText(text_b);
                                    }
                                    else{
                                        text_b="Can't Divide By 0 :(";
                                        text_buf.setText(text_b);
                                    }
                                }
                                else{
                                    buf=cur1/cur2;
                                    text_b=Float.toString(buf);
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "%":{
                                if(dot==0){
                                    buf=cur1%cur2;
                                    text_b=Float.toString(buf);
                                    text_buf.setText(text_b);
                                }
                                else{
                                    text_b="Math Error :(";
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "^":{
                                if(cur2==0 && cur1==0){
                                    text_b="Math Error :(";
                                    text_buf.setText(text_b);
                                }
                                else{
                                    if(cur1<0 && cur2==0){
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                    else if (cur1 < 0 && (int)cur2 == 0) {
                                        text_b = "Math Error :(";
                                        text_buf.setText(text_b);
                                    }
                                    else {
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                }
                                break;
                            }
                            default:{
                                break;
                            }
                        }
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Input Limit Exceeded", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.button_1:{
                if(text_c1=="Undefined !" || text_c1=="Can't Divide By 0 :(" || text_c1=="Math Error :(" || text_c1=="Infinity"){
                    break;
                }
                if(limit<8){
                    if(bin_op_on==0){
                            text_c1 = text_c1 + "1";
                            limit++;
                            text_cur.setText(text_c1 + but + text_c2);
                            cur1 = Float.parseFloat(text_c1);
                    }
                    else{
                            text_c2 = text_c2 + "1";
                            limit++;
                            text_cur.setText(text_c1 + but + text_c2);
                            cur2 = Float.parseFloat(text_c2);
                        switch(but){
                            case "+":{
                                buf=cur1+cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "-":{
                                buf=cur1-cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "×":{
                                buf=cur1*cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "÷":{
                                if(cur2==0){
                                    if(cur1==0){
                                        text_b="Undefined !";
                                        text_buf.setText(text_b);
                                    }
                                    else{
                                        text_b="Can't Divide By 0 :(";
                                        text_buf.setText(text_b);
                                    }
                                }
                                else{
                                    buf=cur1/cur2;
                                    text_b=Float.toString(buf);
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "%":{
                                if(dot==0){
                                    buf=cur1%cur2;
                                    text_b=Float.toString(buf);
                                    text_buf.setText(text_b);
                                }
                                else{
                                    text_b="Math Error :(";
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "^":{
                                if(cur2==0 && cur1==0){
                                    text_b="Math Error :(";
                                    text_buf.setText(text_b);
                                }
                                else{
                                    if(cur1<0 && cur2==0){
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                    else if (cur1 < 0 && (int)cur2 == 0) {
                                        text_b = "Math Error :(";
                                        text_buf.setText(text_b);
                                    }
                                    else {
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                }
                                break;
                            }
                            default:{
                                break;
                            }
                        }
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Input Limit Exceeded", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.button_2:{
                if(text_c1=="Undefined !" || text_c1=="Can't Divide By 0 :(" || text_c1=="Math Error :(" || text_c1=="Infinity"){
                    break;
                }
                if(limit<8){
                    if(bin_op_on==0){
                            text_c1 = text_c1 + "2";
                            limit++;
                            text_cur.setText(text_c1 + but + text_c2);
                            cur1 = Float.parseFloat(text_c1);
                    }
                    else{
                            text_c2 = text_c2 + "2";
                            limit++;
                            text_cur.setText(text_c1 + but + text_c2);
                            cur2 = Float.parseFloat(text_c2);
                        switch(but){
                            case "+":{
                                buf=cur1+cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "-":{
                                buf=cur1-cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "×":{
                                buf=cur1*cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "÷":{
                                if(cur2==0){
                                    if(cur1==0){
                                        text_b="Undefined !";
                                        text_buf.setText(text_b);
                                    }
                                    else{
                                        text_b="Can't Divide By 0 :(";
                                        text_buf.setText(text_b);
                                    }
                                }
                                else{
                                    buf=cur1/cur2;
                                    text_b=Float.toString(buf);
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "%":{
                                if(dot==0){
                                    buf=cur1%cur2;
                                    text_b=Float.toString(buf);
                                    text_buf.setText(text_b);
                                }
                                else{
                                    text_b="Math Error :(";
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "^":{
                                if(cur2==0 && cur1==0){
                                    text_b="Math Error :(";
                                    text_buf.setText(text_b);
                                }
                                else{
                                    if(cur1<0 && cur2==0){
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                    else if (cur1 < 0 && (int)cur2 == 0) {
                                        text_b = "Math Error :(";
                                        text_buf.setText(text_b);
                                    }
                                    else {
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                }
                                break;
                            }
                            default:{
                                break;
                            }
                        }
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Input Limit Exceeded", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.button_3:{
                if(text_c1=="Undefined !" || text_c1=="Can't Divide By 0 :(" || text_c1=="Math Error :(" || text_c1=="Infinity"){
                    break;
                }
                if(limit<8){
                    if(bin_op_on==0){
                            text_c1 = text_c1 + "3";
                            limit++;
                            text_cur.setText(text_c1 + but + text_c2);
                            cur1 = Float.parseFloat(text_c1);
                    }
                    else{
                            text_c2 = text_c2 + "3";
                            limit++;
                            text_cur.setText(text_c1 + but + text_c2);
                            cur2 = Float.parseFloat(text_c2);
                        switch(but){
                            case "+":{
                                buf=cur1+cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "-":{
                                buf=cur1-cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "×":{
                                buf=cur1*cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "÷":{
                                if(cur2==0){
                                    if(cur1==0){
                                        text_b="Undefined !";
                                        text_buf.setText(text_b);
                                    }
                                    else{
                                        text_b="Can't Divide By 0 :(";
                                        text_buf.setText(text_b);
                                    }
                                }
                                else{
                                    buf=cur1/cur2;
                                    text_b=Float.toString(buf);
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "%":{
                                if(dot==0){
                                    buf=cur1%cur2;
                                    text_b=Float.toString(buf);
                                    text_buf.setText(text_b);
                                }
                                else{
                                    text_b="Math Error :(";
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "^":{
                                if(cur2==0 && cur1==0){
                                    text_b="Math Error :(";
                                    text_buf.setText(text_b);
                                }
                                else{
                                    if(cur1<0 && cur2==0){
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                    else if (cur1 < 0 && (int)cur2 == 0) {
                                        text_b = "Math Error :(";
                                        text_buf.setText(text_b);
                                    }
                                    else {
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                }
                                break;
                            }
                            default:{
                                break;
                            }
                        }
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Input Limit Exceeded", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.button_4:{
                if(text_c1=="Undefined !" || text_c1=="Can't Divide By 0 :(" || text_c1=="Math Error :(" || text_c1=="Infinity"){
                    break;
                }
                if(limit<8){
                    if(bin_op_on==0){
                            text_c1 = text_c1 + "4";
                            limit++;
                            text_cur.setText(text_c1 + but + text_c2);
                            cur1 = Float.parseFloat(text_c1);
                    }
                    else{
                            text_c2 = text_c2 + "4";
                            limit++;
                            text_cur.setText(text_c1 + but + text_c2);
                            cur2 = Float.parseFloat(text_c2);
                        switch(but){
                            case "+":{
                                buf=cur1+cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "-":{
                                buf=cur1-cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "×":{
                                buf=cur1*cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "÷":{
                                if(cur2==0){
                                    if(cur1==0){
                                        text_b="Undefined !";
                                        text_buf.setText(text_b);
                                    }
                                    else{
                                        text_b="Can't Divide By 0 :(";
                                        text_buf.setText(text_b);
                                    }
                                }
                                else{
                                    buf=cur1/cur2;
                                    text_b=Float.toString(buf);
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "%":{
                                if(dot==0){
                                    buf=cur1%cur2;
                                    text_b=Float.toString(buf);
                                    text_buf.setText(text_b);
                                }
                                else{
                                    text_b="Math Error :(";
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "^":{
                                if(cur2==0 && cur1==0){
                                    text_b="Math Error :(";
                                    text_buf.setText(text_b);
                                }
                                else{
                                    if(cur1<0 && cur2==0){
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                    else if (cur1 < 0 && (int)cur2 == 0) {
                                        text_b = "Math Error :(";
                                        text_buf.setText(text_b);
                                    }
                                    else {
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                }
                                break;
                            }
                            default:{
                                break;
                            }
                        }
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Input Limit Exceeded", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.button_5:{
                if(text_c1=="Undefined !" || text_c1=="Can't Divide By 0 :(" || text_c1=="Math Error :(" || text_c1=="Infinity"){
                    break;
                }
                if(limit<8){
                    if(bin_op_on==0){
                            text_c1 = text_c1 + "5";
                            limit++;
                            text_cur.setText(text_c1 + but + text_c2);
                            cur1 = Float.parseFloat(text_c1);
                    }
                    else{
                            text_c2 = text_c2 + "5";
                            limit++;
                            text_cur.setText(text_c1 + but + text_c2);
                            cur2 = Float.parseFloat(text_c2);
                        switch(but){
                            case "+":{
                                buf=cur1+cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "-":{
                                buf=cur1-cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "×":{
                                buf=cur1*cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "÷":{
                                if(cur2==0){
                                    if(cur1==0){
                                        text_b="Undefined !";
                                        text_buf.setText(text_b);
                                    }
                                    else{
                                        text_b="Can't Divide By 0 :(";
                                        text_buf.setText(text_b);
                                    }
                                }
                                else{
                                    buf=cur1/cur2;
                                    text_b=Float.toString(buf);
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "%":{
                                if(dot==0){
                                    buf=cur1%cur2;
                                    text_b=Float.toString(buf);
                                    text_buf.setText(text_b);
                                }
                                else{
                                    text_b="Math Error :(";
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "^":{
                                if(cur2==0 && cur1==0){
                                    text_b="Math Error :(";
                                    text_buf.setText(text_b);
                                }
                                else{
                                    if(cur1<0 && cur2==0){
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                    else if (cur1 < 0 && (int)cur2 == 0) {
                                        text_b = "Math Error :(";
                                        text_buf.setText(text_b);
                                    }
                                    else {
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                }
                                break;
                            }
                            default:{
                                break;
                            }
                        }
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Input Limit Exceeded", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.button_6:{
                if(text_c1=="Undefined !" || text_c1=="Can't Divide By 0 :(" || text_c1=="Math Error :(" || text_c1=="Infinity"){
                    break;
                }
                if(limit<8){
                    if(bin_op_on==0){
                            text_c1 = text_c1 + "6";
                            limit++;
                            text_cur.setText(text_c1 + but + text_c2);
                            cur1 = Float.parseFloat(text_c1);
                    }
                    else{
                            text_c2 = text_c2 + "6";
                            limit++;
                            text_cur.setText(text_c1 + but + text_c2);
                            cur2 = Float.parseFloat(text_c2);
                        switch(but){
                            case "+":{
                                buf=cur1+cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "-":{
                                buf=cur1-cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "×":{
                                buf=cur1*cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "÷":{
                                if(cur2==0){
                                    if(cur1==0){
                                        text_b="Undefined !";
                                        text_buf.setText(text_b);
                                    }
                                    else{
                                        text_b="Can't Divide By 0 :(";
                                        text_buf.setText(text_b);
                                    }
                                }
                                else{
                                    buf=cur1/cur2;
                                    text_b=Float.toString(buf);
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "%":{
                                if(dot==0){
                                    buf=cur1%cur2;
                                    text_b=Float.toString(buf);
                                    text_buf.setText(text_b);
                                }
                                else{
                                    text_b="Math Error :(";
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "^":{
                                if(cur2==0 && cur1==0){
                                    text_b="Math Error :(";
                                    text_buf.setText(text_b);
                                }
                                else{
                                    if(cur1<0 && cur2==0){
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                    else if (cur1 < 0 && (int)cur2 == 0) {
                                        text_b = "Math Error :(";
                                        text_buf.setText(text_b);
                                    }
                                    else {
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                }
                                break;
                            }
                            default:{
                                break;
                            }
                        }
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Input Limit Exceeded", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.button_7:{
                if(text_c1=="Undefined !" || text_c1=="Can't Divide By 0 :(" || text_c1=="Math Error :(" || text_c1=="Infinity"){
                    break;
                }
                if(limit<8){
                    if(bin_op_on==0){
                            text_c1 = text_c1 + "7";
                            limit++;
                            text_cur.setText(text_c1 + but + text_c2);
                            cur1 = Float.parseFloat(text_c1);
                    }
                    else{
                            text_c2 = text_c2 + "7";
                            limit++;
                            text_cur.setText(text_c1 + but + text_c2);
                            cur2 = Float.parseFloat(text_c2);
                        switch(but){
                            case "+":{
                                buf=cur1+cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "-":{
                                buf=cur1-cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "×":{
                                buf=cur1*cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "÷":{
                                if(cur2==0){
                                    if(cur1==0){
                                        text_b="Undefined !";
                                        text_buf.setText(text_b);
                                    }
                                    else{
                                        text_b="Can't Divide By 0 :(";
                                        text_buf.setText(text_b);
                                    }
                                }
                                else{
                                    buf=cur1/cur2;
                                    text_b=Float.toString(buf);
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "%":{
                                if(dot==0){
                                    buf=cur1%cur2;
                                    text_b=Float.toString(buf);
                                    text_buf.setText(text_b);
                                }
                                else{
                                    text_b="Math Error :(";
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "^":{
                                if(cur2==0 && cur1==0){
                                    text_b="Math Error :(";
                                    text_buf.setText(text_b);
                                }
                                else{
                                    if(cur1<0 && cur2==0){
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                    else if (cur1 < 0 && (int)cur2 == 0) {
                                        text_b = "Math Error :(";
                                        text_buf.setText(text_b);
                                    }
                                    else {
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                }
                                break;
                            }
                            default:{
                                break;
                            }
                        }
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Input Limit Exceeded", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.button_8:{
                if(text_c1=="Undefined !" || text_c1=="Can't Divide By 0 :(" || text_c1=="Math Error :(" || text_c1=="Infinity"){
                    break;
                }
                if(limit<8){
                    if(bin_op_on==0){
                            text_c1 = text_c1 + "8";
                            limit++;
                            text_cur.setText(text_c1 + but + text_c2);
                            cur1 = Float.parseFloat(text_c1);
                    }
                    else{
                            text_c2 = text_c2 + "8";
                            limit++;
                            text_cur.setText(text_c1 + but + text_c2);
                            cur2 = Float.parseFloat(text_c2);
                        switch(but){
                            case "+":{
                                buf=cur1+cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "-":{
                                buf=cur1-cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "×":{
                                buf=cur1*cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "÷":{
                                if(cur2==0){
                                    if(cur1==0){
                                        text_b="Undefined !";
                                        text_buf.setText(text_b);
                                    }
                                    else{
                                        text_b="Can't Divide By 0 :(";
                                        text_buf.setText(text_b);
                                    }
                                }
                                else{
                                    buf=cur1/cur2;
                                    text_b=Float.toString(buf);
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "%":{
                                if(dot==0){
                                    buf=cur1%cur2;
                                    text_b=Float.toString(buf);
                                    text_buf.setText(text_b);
                                }
                                else{
                                    text_b="Math Error :(";
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "^":{
                                if(cur2==0 && cur1==0){
                                    text_b="Math Error :(";
                                    text_buf.setText(text_b);
                                }
                                else{
                                    if(cur1<0 && cur2==0){
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                    else if (cur1 < 0 && (int)cur2 == 0) {
                                        text_b = "Math Error :(";
                                        text_buf.setText(text_b);
                                    }
                                    else {
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                }
                                break;
                            }
                            default:{
                                break;
                            }
                        }
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Input Limit Exceeded", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.button_9:{
                if(text_c1=="Undefined !" || text_c1=="Can't Divide By 0 :(" || text_c1=="Math Error :(" || text_c1=="Infinity"){
                    break;
                }
                if(limit<8){
                    if(bin_op_on==0){
                            text_c1 = text_c1 + "9";
                            limit++;
                            text_cur.setText(text_c1 + but + text_c2);
                            cur1 = Float.parseFloat(text_c1);
                    }
                    else{
                            text_c2 = text_c2 + "9";
                            limit++;
                            text_cur.setText(text_c1 + but + text_c2);
                            cur2 = Float.parseFloat(text_c2);
                        switch(but){
                            case "+":{
                                buf=cur1+cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "-":{
                                buf=cur1-cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "×":{
                                buf=cur1*cur2;
                                text_b=Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "÷":{
                                if(cur2==0){
                                    if(cur1==0){
                                        text_b="Undefined !";
                                        text_buf.setText(text_b);
                                    }
                                    else{
                                        text_b="Can't Divide By 0 :(";
                                        text_buf.setText(text_b);
                                    }
                                }
                                else{
                                    buf=cur1/cur2;
                                    text_b=Float.toString(buf);
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "%":{
                                if(dot==0){
                                    buf=cur1%cur2;
                                    text_b=Float.toString(buf);
                                    text_buf.setText(text_b);
                                }
                                else{
                                    text_b="Math Error :(";
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "^":{
                                if(cur2==0 && cur1==0){
                                    text_b="Math Error :(";
                                    text_buf.setText(text_b);
                                }
                                else{
                                    if(cur1<0 && cur2==0){
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                    else if (cur1 < 0 && (int)cur2 == 0) {
                                        text_b = "Math Error :(";
                                        text_buf.setText(text_b);
                                    }
                                    else {
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                }
                                break;
                            }
                            default:{
                                break;
                            }
                        }
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Input Limit Exceeded", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.button_dt:{
                if(dot==1){
                    break;
                }
                if(text_c1=="Undefined !" || text_c1=="Can't Divide By 0 :(" || text_c1=="Math Error :(" || text_c1=="Infinity"){
                    break;
                }
                else{
                    if(bin_op_on==0){
                            text_c1 = text_c1 + ".";
                            text_cur.setText(text_c1 + but + text_c2);
                            cur1 = Float.parseFloat(text_c1 + "0");
                            dot = 1;
                    }
                    else{
                            text_c2 = text_c2 + ".";
                            text_cur.setText(text_c1 + but + text_c2);
                            cur2 = Float.parseFloat(text_c2 + "0");
                            dot = 1;
                        switch(but) {
                            case "+": {
                                buf = cur1 + cur2;
                                text_b = Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "-": {
                                buf = cur1 - cur2;
                                text_b = Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "×": {
                                buf = cur1 * cur2;
                                text_b = Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "÷": {
                                if (cur2 == 0) {
                                    if (cur1 == 0) {
                                        text_b = "Undefined !";
                                        text_buf.setText(text_b);
                                    } else {
                                        text_b = "Can't Divide By 0 :(";
                                        text_buf.setText(text_b);
                                    }
                                } else {
                                    buf = cur1 / cur2;
                                    text_b = Float.toString(buf);
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "%": {
                                if (dot == 0) {
                                    buf = cur1 % cur2;
                                    text_b = Float.toString(buf);
                                    text_buf.setText(text_b);
                                } else {
                                    text_b = "Math Error :(";
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "^": {
                                if (cur2 == 0 && cur1 == 0) {
                                    text_b = "Math Error :(";
                                    text_buf.setText(text_b);
                                } else {
                                    if(cur1<0 && cur2==0){
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                    else if (cur1 < 0 && (int)cur2 == 0) {
                                        text_b = "Math Error :(";
                                        text_buf.setText(text_b);
                                    }
                                    else {
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                }
                                break;
                            }
                            default: {
                                break;
                            }
                        }
                    }
                }
                break;
            }
            case R.id.button_pm:{
                if(text_c1=="Undefined !" || text_c1=="Can't Divide By 0 :(" || text_c1=="" || text_c1=="Math Error :(" || text_c1=="Infinity"){
                    break;
                }
                if(bin_op_on==0){
                    if(cur1==0){
                        break;
                    }
                    else if(cur1>0){
                        cur1=cur1*-1;
                        text_c1="(-"+text_c1+")";
                        //cur1=Float.parseFloat(text_c1.substring(1,text_c1.length()-1));
                        text_cur.setText(text_c1+but+text_c2);
                    }
                    else{
                        cur1 = cur1*-1;
                        text_c1=text_c1.substring(2,text_c1.length()-1);
                        //cur1=Float.parseFloat(text_c1);
                        text_cur.setText(text_c1+but+text_c2);
                    }
                }
                else{
                    if(cur2==0){
                        break;
                    }
                    else if(cur2>0){
                        cur2=cur2*-1;
                        text_c2="(-"+text_c2+")";
                        //cur2=Float.parseFloat(text_c2.substring(1,text_c1.length()-1));
                        text_cur.setText(text_c1+but+text_c2);
                        switch(but) {
                            case "+": {
                                buf = cur1 + cur2;
                                text_b = Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "-": {
                                buf = cur1 - cur2;
                                text_b = Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "×": {
                                buf = cur1 * cur2;
                                text_b = Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "÷": {
                                if (cur2 == 0) {
                                    if (cur1 == 0) {
                                        text_b = "Undefined !";
                                        text_buf.setText(text_b);
                                    } else {
                                        text_b = "Can't Divide By 0 :(";
                                        text_buf.setText(text_b);
                                    }
                                } else {
                                    buf = cur1 / cur2;
                                    text_b = Float.toString(buf);
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "%": {
                                if (dot == 0) {
                                    buf = cur1 % cur2;
                                    text_b = Float.toString(buf);
                                    text_buf.setText(text_b);
                                } else {
                                    text_b = "Math Error :(";
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "^": {
                                if (cur2 == 0 && cur1 == 0) {
                                    text_b = "Math Error :(";
                                    text_buf.setText(text_b);
                                } else {
                                    if(cur1<0 && cur2==0){
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                    else if (cur1 < 0 && (int)cur2 == 0) {
                                        text_b = "Math Error :(";
                                        text_buf.setText(text_b);
                                    }
                                    else {
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                }
                                break;
                            }
                            default: {
                                break;
                            }
                        }
                    }
                    else{
                        cur2 = cur2*-1;
                        text_c2=text_c2.substring(2,text_c2.length()-1);
                        //cur2=Float.parseFloat(text_c2);
                        text_cur.setText(text_c1+but+text_c2);
                        switch(but) {
                            case "+": {
                                buf = cur1 + cur2;
                                text_b = Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "-": {
                                buf = cur1 - cur2;
                                text_b = Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "×": {
                                buf = cur1 * cur2;
                                text_b = Float.toString(buf);
                                text_buf.setText(text_b);
                                break;
                            }
                            case "÷": {
                                if (cur2 == 0) {
                                    if (cur1 == 0) {
                                        text_b = "Undefined !";
                                        text_buf.setText(text_b);
                                    } else {
                                        text_b = "Can't Divide By 0 :(";
                                        text_buf.setText(text_b);
                                    }
                                } else {
                                    buf = cur1 / cur2;
                                    text_b = Float.toString(buf);
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "%": {
                                if (dot == 0) {
                                    buf = cur1 % cur2;
                                    text_b = Float.toString(buf);
                                    text_buf.setText(text_b);
                                } else {
                                    text_b = "Math Error :(";
                                    text_buf.setText(text_b);
                                }
                                break;
                            }
                            case "^": {
                                if (cur2 == 0 && cur1 == 0) {
                                    text_b = "Math Error :(";
                                    text_buf.setText(text_b);
                                } else {
                                    if(cur1<0 && cur2==0){
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                    else if (cur1 < 0 && (int)cur2 == 0) {
                                        text_b = "Math Error :(";
                                        text_buf.setText(text_b);
                                    }
                                    else {
                                        buf = (float) Math.pow((double) cur1, (double) cur2);
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                }
                                break;
                            }
                            default: {
                                break;
                            }
                        }
                    }
                }
                break;
            }
            case R.id.button_mul:{
                if(text_c1=="Undefined !" || text_c1=="Can't Divide By 0 :("  || text_c1=="Math Error :(" || text_c1=="Infinity"){
                    break;
                }
                if(bin_op_on==1){
                    Toast.makeText(getApplicationContext(), "Multiple Operations in single\n\t\t\tline not allowed", Toast.LENGTH_SHORT).show();
                    break;
                }
                else{
                    if(text_c1==""){
                        Toast.makeText(getApplicationContext(), "Binary Operation Requires\n\t\t\tTwo Operands", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    else {
                        bin_op_on = 1;
                        but = "×";
                        limit = 0;
                        dot=0;
                        text_cur.setText(text_c1 + but + text_c2);
                    }
                }
                break;
            }
            case R.id.button_div:{
                if(text_c1=="Undefined !" || text_c1=="Can't Divide By 0 :(" || text_c1=="Math Error :(" || text_c1=="Infinity"){
                    break;
                }
                if(bin_op_on==1){
                    Toast.makeText(getApplicationContext(), "Multiple Operations in single\n\t\t\tline not allowed", Toast.LENGTH_SHORT).show();
                    break;
                }
                else{
                    if(dot==1) {
                        if (text_c1.length() == 1 && text_c1.charAt(0) == '.') {
                            text_c1 = "0.0";
                        } else if (text_c1.length()>1 && text_c1.charAt(0)=='.'){
                            text_c1="0"+text_c1;
                        }
                    }
                    if(text_c1.length()==0){
                        Toast.makeText(getApplicationContext(), "Binary Operation Requires\n\t\t\tTwo Operands", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    else {
                        bin_op_on = 1;
                        but = "÷";
                        limit = 0;
                        dot=0;
                        text_cur.setText(text_c1 + but + text_c2);
                    }
                }
                break;
            }
            case R.id.button_sum:{
                if(text_c1=="Undefined !" || text_c1=="Can't Divide By 0 :(" || text_c1=="Math Error :(" || text_c1=="Infinity"){
                    break;
                }
                if(bin_op_on==1){
                    Toast.makeText(getApplicationContext(), "Multiple Operations in single\n\t\t\tline not allowed", Toast.LENGTH_SHORT).show();
                    break;
                }
                else{
                    if(dot==1) {
                        if (text_c1.length() == 1 && text_c1.charAt(0) == '.') {
                            text_c1 = "0.0";
                        } else if (text_c1.length()>1 && text_c1.charAt(0)=='.'){
                            text_c1="0"+text_c1;
                        }
                    }
                    if(text_c1.length()==0){
                        Toast.makeText(getApplicationContext(), "Binary Operation Requires\n\t\t\tTwo Operands", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    else {
                        bin_op_on = 1;
                        but = "+";
                        limit = 0;
                        dot=0;
                        text_cur.setText(text_c1 + but + text_c2);
                    }
                }
                break;
            }
            case R.id.button_sub:{
                if(text_c1=="Undefined !" || text_c1=="Can't Divide By 0 :(" || text_c1=="Math Error :(" || text_c1=="Infinity"){
                    break;
                }
                if(bin_op_on==1){
                    Toast.makeText(getApplicationContext(), "Multiple Operations in single\n\t\t\tline not allowed", Toast.LENGTH_SHORT).show();
                    break;
                }
                else{
                    if(dot==1) {
                        if (text_c1.length() == 1 && text_c1.charAt(0) == '.') {
                            text_c1 = "0.0";
                        } else if (text_c1.length()>1 && text_c1.charAt(0)=='.'){
                            text_c1="0"+text_c1;
                        }
                    }
                    if(text_c1.length()==0){
                        Toast.makeText(getApplicationContext(), "Binary Operation Requires\n\t\t\tTwo Operands", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    else {
                        bin_op_on = 1;
                        but = "-";
                        limit = 0;
                        dot=0;
                        text_cur.setText(text_c1 + but + text_c2);
                    }
                }
                break;
            }
            case R.id.button_per:{
                if(text_c1=="Undefined !" || text_c1=="Can't Divide By 0 :(" || text_c1=="Math Error :(" || text_c1=="Infinity"){
                    break;
                }
                if(bin_op_on==1){
                    Toast.makeText(getApplicationContext(), "Multiple Operations in single\n\t\t\tline not allowed", Toast.LENGTH_SHORT).show();
                    break;
                }
                else{
                    if(dot==1) {
                        if (text_c1.length() == 1 && text_c1.charAt(0) == '.') {
                            text_c1 = "0.0";
                        } else if (text_c1.length()>1 && text_c1.charAt(0)=='.'){
                            text_c1="0"+text_c1;
                        }
                    }
                    if(text_c1.length()==0){
                        Toast.makeText(getApplicationContext(), "Binary Operation Requires\n\t\t\tTwo Operands", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    else {
                        bin_op_on = 1;
                        but = "%";
                        limit = 0;
                        dot=0;
                        text_cur.setText(text_c1 + but + text_c2);
                    }
                }
                break;
            }
            case R.id.button_pow:{
                if(text_c1=="Undefined !" || text_c1=="Can't Divide By 0 :(" || text_c1=="Math Error :(" || text_c1=="Infinity"){
                    break;
                }
                if(bin_op_on==1){
                    Toast.makeText(getApplicationContext(), "Multiple Operations in single\n\t\t\tline not allowed", Toast.LENGTH_SHORT).show();
                    break;
                }
                else{
                    if(dot==1) {
                        if (text_c1.length() == 1 && text_c1.charAt(0) == '.') {
                            text_c1 = "0.0";
                        } else if (text_c1.length()>1 && text_c1.charAt(0)=='.'){
                            text_c1="0"+text_c1;
                        }
                    }
                    if(text_c1.length()==0){
                        Toast.makeText(getApplicationContext(), "Binary Operation Requires\n\t\t\tTwo Operands", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    else {
                        bin_op_on = 1;
                        but = "^";
                        limit = 0;
                        dot=0;
                        text_cur.setText(text_c1 + but + text_c2);
                    }
                }
                break;
            }
            case R.id.button_root:{
                break;
            }
            case R.id.button_fact:{
                break;
            }
            case R.id.button_clr:{
                if(text_c1=="Undefined !" || text_c1=="Can't Divide By 0 :(" || text_c1=="Math Error :(" || text_c1=="Infinity"){
                    cur1=0;
                    cur2=0;
                    buf=0;
                    text_c1="";
                    text_c2="";
                    text_b="";
                    but="";
                    dot=0;
                    limit=0;
                    bin_op_on=0;
                    un_op_on=0;
                    text_cur.setText(text_c1+but+text_c2);
                    text_buf.setText(text_b);
                }
                else if(bin_op_on==0){
                    if(text_c1.length()==0){
                        break;
                    }
                    else if(text_c1.length()==1) {
                        cur1=0;
                        cur2=0;
                        buf=0;
                        text_c1="";
                        text_c2="";
                        text_b="";
                        but="";
                        dot=0;
                        limit=0;
                        bin_op_on=0;
                        un_op_on=0;
                        text_cur.setText(text_c1+but+text_c2);
                        text_buf.setText(text_b);
                    }
                    else if(text_c1.length()>1) {
                        if(text_c1.charAt(text_c1.length() - 1) == '.'){
                            text_c1 = text_c1.substring(0, text_c1.length()-1);
                            text_cur.setText(text_c1 + but + text_c2);
                            cur1 = Float.parseFloat(text_c1);
                            dot=0;
                        }
                        else if (text_c1.charAt(text_c1.length() - 2) == '.') {
                            text_c1 = text_c1.substring(0, text_c1.length()-1);
                            text_cur.setText(text_c1 + but + text_c2);
                            cur1 = Float.parseFloat(text_c1 + "0");
                            limit--;
                        }
                        else {
                            text_c1 = text_c1.substring(0, text_c1.length()-1);
                            text_cur.setText(text_c1 + but + text_c2);
                            cur1 = Float.parseFloat(text_c1);
                            limit--;
                        }
                    }
                }
                else{
                    if(text_c2.length()==0){
                        text_cur.setText(text_c1);
                        bin_op_on=0;
                        but="";
                        if(dot==1){
                            limit=text_c1.length()-1;
                        }
                        else{
                            limit=text_c1.length();
                        }
                        text_buf.setText("");
                    }
                    else if(text_c2.length()==1) {
                        if (text_c2.charAt(0) == '.') {
                            text_c2 = "";
                            text_cur.setText(text_c1 + but + text_c2);
                            cur2 = Float.parseFloat(text_c2+"0");
                            dot = 0;
                            text_b="";
                            text_buf.setText(text_b);
                            switch (but) {
                                case "+": {
                                    buf = cur1 + cur2;
                                    text_b = Float.toString(buf);
                                    text_buf.setText(text_b);
                                    break;
                                }
                                case "-": {
                                    buf = cur1 - cur2;
                                    text_b = Float.toString(buf);
                                    text_buf.setText(text_b);
                                    break;
                                }
                                case "×": {
                                    buf = cur1 * cur2;
                                    text_b = Float.toString(buf);
                                    text_buf.setText(text_b);
                                    break;
                                }
                                case "÷": {
                                    if (cur2 == 0) {
                                        if (cur1 == 0) {
                                            text_b = "Undefined !";
                                            text_buf.setText(text_b);
                                        } else {
                                            text_b = "Can't Divide By 0 :(";
                                            text_buf.setText(text_b);
                                        }
                                    } else {
                                        buf = cur1 / cur2;
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                    break;
                                }
                                case "%": {
                                    if (dot == 0) {
                                        buf = cur1 % cur2;
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    } else {
                                        text_b = "Math Error :(";
                                        text_buf.setText(text_b);
                                    }
                                    break;
                                }
                                case "^": {
                                    if (cur2 == 0 && cur1 == 0) {
                                        text_b = "Math Error :(";
                                        text_buf.setText(text_b);
                                    } else {
                                        if(cur1<0 && cur2==0){
                                            buf = (float) Math.pow((double) cur1, (double) cur2);
                                            text_b = Float.toString(buf);
                                            text_buf.setText(text_b);
                                        }
                                        else if (cur1 < 0 && (int)cur2 == 0) {
                                            text_b = "Math Error :(";
                                            text_buf.setText(text_b);
                                        }
                                        else {
                                            buf = (float) Math.pow((double) cur1, (double) cur2);
                                            text_b = Float.toString(buf);
                                            text_buf.setText(text_b);
                                        }
                                    }
                                    break;
                                }
                                default: {
                                    break;
                                }
                            }
                        }
                        else {
                            text_c2 = "";
                            text_cur.setText(text_c1 + but + text_c2);
                            cur2 = Float.parseFloat(text_c2+"0");
                            text_b="";
                            text_buf.setText(text_b);
                            switch (but) {
                                case "+": {
                                    buf = cur1 + cur2;
                                    text_b = Float.toString(buf);
                                    text_buf.setText(text_b);
                                    break;
                                }
                                case "-": {
                                    buf = cur1 - cur2;
                                    text_b = Float.toString(buf);
                                    text_buf.setText(text_b);
                                    break;
                                }
                                case "×": {
                                    buf = cur1 * cur2;
                                    text_b = Float.toString(buf);
                                    text_buf.setText(text_b);
                                    break;
                                }
                                case "÷": {
                                    if (cur2 == 0) {
                                        if (cur1 == 0) {
                                            text_b = "Undefined !";
                                            text_buf.setText(text_b);
                                        } else {
                                            text_b = "Can't Divide By 0 :(";
                                            text_buf.setText(text_b);
                                        }
                                    } else {
                                        buf = cur1 / cur2;
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                    break;
                                }
                                case "%": {
                                    if (dot == 0) {
                                        buf = cur1 % cur2;
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    } else {
                                        text_b = "Math Error :(";
                                        text_buf.setText(text_b);
                                    }
                                    break;
                                }
                                case "^": {
                                    if (cur2 == 0 && cur1 == 0) {
                                        text_b = "Math Error :(";
                                        text_buf.setText(text_b);
                                    } else {
                                        if(cur1<0 && cur2==0){
                                            buf = (float) Math.pow((double) cur1, (double) cur2);
                                            text_b = Float.toString(buf);
                                            text_buf.setText(text_b);
                                        }
                                        else if (cur1 < 0 && (int)cur2 == 0) {
                                            text_b = "Math Error :(";
                                            text_buf.setText(text_b);
                                        }
                                        else {
                                            buf = (float) Math.pow((double) cur1, (double) cur2);
                                            text_b = Float.toString(buf);
                                            text_buf.setText(text_b);
                                        }
                                    }
                                    break;
                                }
                                default: {
                                    break;
                                }
                            }
                            limit--;
                        }
                        text_buf.setText("");
                    }
                    else if(text_c2.length()>1){
                        if(text_c2.charAt(text_c2.length()-1)=='.') {
                            text_c2 = text_c2.substring(0, text_c2.length() - 1);
                            text_cur.setText(text_c1 + but + text_c2);
                            cur2 = Float.parseFloat(text_c2);
                            switch (but) {
                                case "+": {
                                    buf = cur1 + cur2;
                                    text_b = Float.toString(buf);
                                    text_buf.setText(text_b);
                                    break;
                                }
                                case "-": {
                                    buf = cur1 - cur2;
                                    text_b = Float.toString(buf);
                                    text_buf.setText(text_b);
                                    break;
                                }
                                case "×": {
                                    buf = cur1 * cur2;
                                    text_b = Float.toString(buf);
                                    text_buf.setText(text_b);
                                    break;
                                }
                                case "÷": {
                                    if (cur2 == 0) {
                                        if (cur1 == 0) {
                                            text_b = "Undefined !";
                                            text_buf.setText(text_b);
                                        } else {
                                            text_b = "Can't Divide By 0 :(";
                                            text_buf.setText(text_b);
                                        }
                                    } else {
                                        buf = cur1 / cur2;
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                    break;
                                }
                                case "%": {
                                    if (dot == 0) {
                                        buf = cur1 % cur2;
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    } else {
                                        text_b = "Math Error :(";
                                        text_buf.setText(text_b);
                                    }
                                    break;
                                }
                                case "^": {
                                    if (cur2 == 0 && cur1 == 0) {
                                        text_b = "Math Error :(";
                                        text_buf.setText(text_b);
                                    }
                                    else {
                                        if(cur1<0 && cur2==0){
                                            buf = (float) Math.pow((double) cur1, (double) cur2);
                                            text_b = Float.toString(buf);
                                            text_buf.setText(text_b);
                                        }
                                        else if (cur1 < 0 && (int)cur2 == 0) {
                                            text_b = "Math Error :(";
                                            text_buf.setText(text_b);
                                        }
                                        else {
                                            buf = (float) Math.pow((double) cur1, (double) cur2);
                                            text_b = Float.toString(buf);
                                            text_buf.setText(text_b);
                                        }
                                    }
                                    break;
                                }
                                default: {
                                    break;
                                }
                            }
                            dot = 0;
                        }
                        else if(text_c2.charAt(text_c2.length()-2)=='.') {
                            text_c2 = text_c2.substring(0, text_c2.length()-1);
                            text_cur.setText(text_c1 + but + text_c2);
                            cur2 = Float.parseFloat(text_c2+"0");
                            limit--;
                            switch(but) {
                                case "+": {
                                    buf = cur1 + cur2;
                                    text_b = Float.toString(buf);
                                    text_buf.setText(text_b);
                                    break;
                                }
                                case "-": {
                                    buf = cur1 - cur2;
                                    text_b = Float.toString(buf);
                                    text_buf.setText(text_b);
                                    break;
                                }
                                case "×": {
                                    buf = cur1 * cur2;
                                    text_b = Float.toString(buf);
                                    text_buf.setText(text_b);
                                    break;
                                }
                                case "÷": {
                                    if (cur2 == 0) {
                                        if (cur1 == 0) {
                                            text_b = "Undefined !";
                                            text_buf.setText(text_b);
                                        } else {
                                            text_b = "Can't Divide By 0 :(";
                                            text_buf.setText(text_b);
                                        }
                                    } else {
                                        buf = cur1 / cur2;
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                    break;
                                }
                                case "%": {
                                    if (dot == 0) {
                                        buf = cur1 % cur2;
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    } else {
                                        text_b = "Math Error :(";
                                        text_buf.setText(text_b);
                                    }
                                    break;
                                }
                                case "^": {
                                    if (cur2 == 0 && cur1 == 0) {
                                        text_b = "Math Error :(";
                                        text_buf.setText(text_b);
                                    } else {
                                        if(cur1<0 && cur2==0){
                                            buf = (float) Math.pow((double) cur1, (double) cur2);
                                            text_b = Float.toString(buf);
                                            text_buf.setText(text_b);
                                        }
                                        else if (cur1 < 0 && (int)cur2 == 0) {
                                            text_b = "Math Error :(";
                                            text_buf.setText(text_b);
                                        }
                                        else {
                                            buf = (float) Math.pow((double) cur1, (double) cur2);
                                            text_b = Float.toString(buf);
                                            text_buf.setText(text_b);
                                        }
                                    }
                                    break;
                                }
                                default: {
                                    break;
                                }
                            }
                        }
                        else {
                            text_c2 = text_c2.substring(0, text_c2.length()-1);
                            text_cur.setText(text_c1 + but + text_c2);
                            cur2 = Float.parseFloat(text_c2);
                            switch (but) {
                                case "+": {
                                    buf = cur1 + cur2;
                                    text_b = Float.toString(buf);
                                    text_buf.setText(text_b);
                                    break;
                                }
                                case "-": {
                                    buf = cur1 - cur2;
                                    text_b = Float.toString(buf);
                                    text_buf.setText(text_b);
                                    break;
                                }
                                case "×": {
                                    buf = cur1 * cur2;
                                    text_b = Float.toString(buf);
                                    text_buf.setText(text_b);
                                    break;
                                }
                                case "÷": {
                                    if (cur2 == 0) {
                                        if (cur1 == 0) {
                                            text_b = "Undefined !";
                                            text_buf.setText(text_b);
                                        } else {
                                            text_b = "Can't Divide By 0 :(";
                                            text_buf.setText(text_b);
                                        }
                                    } else {
                                        buf = cur1 / cur2;
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    }
                                    break;
                                }
                                case "%": {
                                    if (dot == 0) {
                                        buf = cur1 % cur2;
                                        text_b = Float.toString(buf);
                                        text_buf.setText(text_b);
                                    } else {
                                        text_b = "Math Error :(";
                                        text_buf.setText(text_b);
                                    }
                                    break;
                                }
                                case "^": {
                                    if (cur2 == 0 && cur1 == 0) {
                                        text_b = "Math Error :(";
                                        text_buf.setText(text_b);
                                    } else {
                                        if(cur1<0 && cur2==0){
                                            buf = (float) Math.pow((double) cur1, (double) cur2);
                                            text_b = Float.toString(buf);
                                            text_buf.setText(text_b);
                                        }
                                        else if (cur1 < 0 && (int)cur2 == 0) {
                                            text_b = "Math Error :(";
                                            text_buf.setText(text_b);
                                        }
                                        else {
                                            buf = (float) Math.pow((double) cur1, (double) cur2);
                                            text_b = Float.toString(buf);
                                            text_buf.setText(text_b);
                                        }
                                    }
                                    break;
                                }
                                default: {
                                    break;
                                }
                            }
                            limit--;
                        }
                    }
                }
                break;
            }
            case R.id.button_pi:{
                break;
            }
            case R.id.button_e:{
                break;
            }
            case R.id.button_eq:{
                if(bin_op_on==0){
                    break;
                }
                else{
                    if(text_b=="Undefined !" || text_b=="Can't Divide By 0 :(" || text_b=="Math Error :("){
                        cur1=0;
                    }
                    else{
                        cur1 = Float.parseFloat(text_b);
                    }
                    cur2=0;
                    buf=0;
                    text_c1=text_b;
                    if(text_c1.length()>8){
                        limit=text_c1.length();
                    }
                    else {
                        int found=0,only_zero=1,index=text_c1.length();
                        for (int i = 0; i<text_c1.length(); i++){
                            if(found==1){
                                if(text_c1.charAt(i)!='0'){
                                    only_zero=0;
                                    break;
                                }
                            }
                            if(text_c1.charAt(i)=='.'){
                                found=1;
                                index=i;
                            }
                        }
                        if(found==1){
                            limit=text_c1.length()-1;
                        }
                        else{
                            limit=text_c1.length();
                        }
                        if(only_zero==1){
                            text_c1=text_c1.substring(0,index);
                        }
                    }
                    text_c2="";
                    text_b="";
                    but="";
                    dot=0;
                    if(!(text_c1=="Undefined !" || text_c1=="Can't Divide By 0 :(" || text_b=="Math Error :(")) {
                        bin_op_on = 0;
                    }
                    un_op_on=0;
                    text_cur.setText(text_c1);
                    text_buf.setText("");
                }
                break;
            }
            default:{
                break;
            }
        }
    }
}
