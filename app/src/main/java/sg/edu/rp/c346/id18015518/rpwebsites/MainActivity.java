package sg.edu.rp.c346.id18015518.rpwebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1, spn2;
    Button btnGo;

    ArrayList<String> al;
    ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGo = findViewById(R.id.buttonGo);
        spn1 = findViewById(R.id.spinner);
        spn2 = findViewById(R.id.spinner2);

        al = new ArrayList<>();
        aa = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, al);
        spn2.setAdapter(aa);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = spn1.getSelectedItemPosition();
                al.clear();


                if (pos == 0) {
                    String[] strNumbers = getResources().getStringArray(R.array.rp_list);
                    al.addAll(Arrays.asList(strNumbers));
                } else {
                    String[] strNumbers = getResources().getStringArray(R.array.soi_list);
                    al.addAll(Arrays.asList(strNumbers));
                }

                aa.notifyDataSetChanged();
            }
        });

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                al.clear();

                if (position == 0) {
                    String[] strNumbers = getResources().getStringArray(R.array.rp_list);
                    al.addAll(Arrays.asList(strNumbers));
                } else {
                    String[] strNumbers = getResources().getStringArray(R.array.soi_list);
                    al.addAll(Arrays.asList(strNumbers));
                }
                aa.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = null;
                if (spn1.getSelectedItemPosition() == 0)
                {
                    if (spn2.getSelectedItemPosition() == 0)
                    {
                        url = "https://www.rp.edu.sg/";
                    } else if (spn2.getSelectedItemPosition() == 1)
                    {
                        url = "https://www.rp.edu.sg/student-life";
                    }
                } else if (spn1.getSelectedItemPosition() == 1)
                {
                        if (spn2.getSelectedItemPosition() == 0)
                        {
                            url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
                        } else if (spn2.getSelectedItemPosition() == 1)
                        {
                            url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
                        }
                }

                    Intent intent = new Intent(MainActivity.this,  SecondActivity.class);
                    intent.putExtra("url",url);
                    startActivity(intent);

                }
            });
    }
}