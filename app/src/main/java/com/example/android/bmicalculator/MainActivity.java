package com.example.android.bmicalculator;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private  final String TAG = this.getClass().getSimpleName();
    String status,n_status,ex_status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calc() {
        EditText weight_kilo = (EditText) findViewById(R.id.weight_ip);
        String w = weight_kilo.getText().toString();
        double weight_kilos = Double.parseDouble(w);


        EditText h_cm = (EditText) findViewById(R.id.cm_ip);
        String i = h_cm.getText().toString();
        double cm = Integer.parseInt(i);


        double height_meters = cm/100;

        double bmi = weight_kilos / (height_meters * height_meters);
        display(bmi);

    }
    void display(double bmi){

        if (bmi < 18.5 ) {
            status="Underweight";
            n_status="1. Eat more frequently.\n2. Choose nutrient-rich foods.\n3. Try smoothies and shakes.\n4. Eat more dairy products such as nuts and nut butter,whole-grain breads,other starches.\n5. Have protein supplements.\n";
            ex_status="1. Push-Ups\n2. Low Intensity Aerobic Workout\n3. Swimming\n4. Jogging\n5. Lunges And Squats\n6. Bench Press\n7. Pull-Ups";
        }
        else if (bmi >= 18.5 && bmi < 25) {
            status="Normal";
            n_status="1. Eat whole grains.\n2. Vegetables(a colorful variety-not potatoes).\n3. Whole fruits(not fruit juices).\n4. Nuts, seeds, beans, and other healthful sources of protein.\n5. Consume plant oils.\n";
            ex_status="   Do normal exercises such as jogging, pushups, yoga, etc.\n   Well, you are all set!!";
        }
        else if (bmi >= 25 && bmi < 30) {
            status="Overweight";
            n_status="1. Ensure a Sufficient Intake of B Vitamins.\n2. Be Sure to Get Enough Vitamin D to Reduce Fat Accumulation in Winter.\n3. Consume Catechins to Boost Fat Burning.\n4. Eat Plenty of Foods Rich in Vitamin C.\n5. Consume Iodine-Rich Foods.\n6. Get Enough Calcium.\n";
            ex_status="1. Walking.\n2. Exercise Ball Workouts.\n3. Aqua Aerobics.\n4. Seated Stationary Bike.\n5. Group Exercise Classes.";
        }
        else if (bmi >= 30) {
            status="Obese";
            n_status="1. Eat Foods Rich in Zinc to Regulate Fat Storage and Appetite.\n2. Cut Down on Calories, Especially in the Evening.\n3. Limit Your Alcohol Consumption.\n4. Drink Plenty of Water.\n5. Go for Low-GI Carbs.\n6. Increase Your Fiber Intake.\n";
            ex_status="1. Lying Hip Extension.\n2. Marching.\n3. Cross Crawl.\n4. Stick-Up.\n5. Push ups.\n6. Chair Squat.";
        }

        // bmi=Math.round((bmi*100.0)/100.0);

        DecimalFormat df=new DecimalFormat("###.#");

        TextView bmi_text_view=(TextView)findViewById(R.id.bmi_text_view);
        String st=String.valueOf(df.format(bmi));
        bmi_text_view.setText(st);

        TextView status_text_view=(TextView)findViewById(R.id.status_text_view);
        status_text_view.setText(status);


        TextView n_status_text_view=(TextView)findViewById(R.id.n_status_text_view);
        n_status_text_view.setText(n_status);


        TextView ex_status_text_view=(TextView)findViewById(R.id.ex_status_text_view);
        ex_status_text_view.setText(ex_status);

    }
    public void order(View view)
    {
        calc();

    }
}
