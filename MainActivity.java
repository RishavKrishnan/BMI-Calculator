package com.example.bmitry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private Button calculate;
    private RadioButton male;
    private RadioButton female;
    private EditText age;
    private EditText feet;
    private EditText inches;
    private EditText weight;
    //private TextView Bmitext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviews();
        Buttononclicklistener();

    }
    private void findviews()
    {
        //Bmitext=findViewById(R.id.text);
        result=findViewById(R.id.result);

        male= findViewById(R.id.Male);
        female = findViewById(R.id.Female);

        age = findViewById(R.id.Age);
        feet = findViewById(R.id.Feet);
        inches = findViewById(R.id.Inches);
        weight = findViewById(R.id.Weight);

        calculate=findViewById(R.id.Calculate);

    }
    private void Buttononclicklistener()
    {
        calculate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
    String agetext=age.getText().toString();
    String weighttext=weight.getText().toString();
    String feettext=feet.getText().toString();
    String inchtext=inches.getText().toString();

   int age= Integer.parseInt(agetext);
   int feet= Integer.parseInt(feettext);
   int weight=Integer.parseInt(weighttext);
   int inch=Integer.parseInt(inchtext);

   int height=(feet*12) + inch;

   double heightm = height*0.0254;//converting to meters

    double bmi= weight/(heightm*heightm);

    DecimalFormat converting= new DecimalFormat("0.00");
    String bmiS= converting.format(bmi);
    //String bmiS=String.valueOf(bmi);// converting to string
        String results;
        if(bmi < 18.5)
        {
            results=bmiS+" - You are underweight";
        }
        else if (bmi> 25)
        {
            results=bmiS+" - You are overweight";
        }
        else
        {
            results=bmiS+ " - You are healthy";
        }

    result.setText(results);
    }


}

