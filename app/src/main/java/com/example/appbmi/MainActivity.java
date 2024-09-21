package com.example.appbmi;

import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.ImageView;
        import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextHeight;
    private EditText editTextWeight;
    private TextView textViewResult;
    //private ImageView imageViewbelly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        textViewResult = findViewById(R.id.textViewResult);
        //imageViewbelly = findViewById(R.id.);

        Button buttonCalculate = findViewById(R.id.buttonCalculate);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        try {
            double height = Double.parseDouble(editTextHeight.getText().toString());
            double weight = Double.parseDouble(editTextWeight.getText().toString());

            // Calculate BMI (BMI = weight / (height * height))
            double bmi = weight / ((height / 100) * (height / 100));

            // Display the result
            textViewResult.setText("Your BMI: " + String.format("%.2f", bmi));
            //imageView = imageViewbelly;

        } catch (NumberFormatException e) {
            // Handle invalid input
            textViewResult.setText("Invalid input. Please enter valid numbers.");
        }
    }
}
