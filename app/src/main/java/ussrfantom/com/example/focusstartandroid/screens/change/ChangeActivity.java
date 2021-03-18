package ussrfantom.com.example.focusstartandroid.screens.change;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.math.RoundingMode;

import ussrfantom.com.example.focusstartandroid.R;

public class ChangeActivity extends AppCompatActivity {

    public int nominal;
    public String name;
    public Double value;
    public Double previous;
    TextView textViewNominal;
    TextView textViewName;
    TextView textViewValue;
    TextView textViewPrevios;
    Button buttonConvert;
    EditText editTextSumma;
    TextView textViewFinish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        textViewName = findViewById(R.id.textViewName);
        textViewNominal = findViewById(R.id.textViewNominal);
        textViewValue = findViewById(R.id.textViewValue);
        textViewPrevios = findViewById(R.id.textViewPrevios);
        buttonConvert = findViewById(R.id.button_convert);
        editTextSumma = findViewById(R.id.EditTextSumma);
        textViewFinish = findViewById(R.id.textViewFinish);

        Intent intent = getIntent();
        nominal = intent.getIntExtra("Nominal", 0);
        name = intent.getStringExtra("Name");
        value = intent.getDoubleExtra("Value", 0);
        previous = intent.getDoubleExtra("Previous", 0);

        textViewName.setText(name);
        textViewNominal.setText(String.valueOf(nominal));
        textViewValue.setText(String.valueOf(value));
        textViewPrevios.setText(String.valueOf(previous));

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double doubleSumma = Double.parseDouble(String.valueOf(editTextSumma.getText()));
                doubleSumma = doubleSumma / value;
                doubleSumma = new BigDecimal(doubleSumma).setScale(3, RoundingMode.DOWN).doubleValue();

                if (doubleSumma != null) {
                    textViewFinish.setText(String.valueOf(doubleSumma));
                } else {
                    Toast.makeText(ChangeActivity.this, "Значение введена неверно!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}