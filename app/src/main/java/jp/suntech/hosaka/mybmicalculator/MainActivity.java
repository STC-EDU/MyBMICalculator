package jp.suntech.hosaka.mybmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btCalc);
        button.setOnClickListener(new BtOnClickListenere());
    }

    private class BtOnClickListenere implements View.OnClickListener {

        @SuppressLint("ResourceType")
        @Override
        public void onClick(View view) {
            EditText etHeight = findViewById(R.id.etHeight);
            EditText etWeight = findViewById(R.id.etWeight);

            double height = Double.parseDouble(etHeight.getText().toString());
            double weight = Double.parseDouble(etWeight.getText().toString());
            double bmi = weight*100.0*100.0/height/height;
            double appropriate_weight = 22*height*height/100.0/100.0;   //適正体重 bmi=22
            String bmi_str = String.format("%.3f",bmi);
            TextView tvResult = findViewById(R.id.tvResult);
            TextView tvAppropriateWeight = findViewById(R.id.tvAppropriateWeight);
            //tvResult.setText(bmi_str);

            String result = "";
            if(bmi>=40.0)
                result = getString(R.string.level6);
            else if(bmi>=35.0)
                result = getString(R.string.level5);
            else if(bmi>=30)
                result = getString(R.string.level4);
            else if(bmi>=25)
                result = getString(R.string.level3);
            else if(bmi>=18.5)
                result = getString(R.string.level2);
            else
                result = getString(R.string.level1);

            tvResult.setBackgroundColor(getColor(R.color.level4));
            tvResult.setText(result);

            tvAppropriateWeight.setText(String.format("%.3f",appropriate_weight));
        }
    }
}