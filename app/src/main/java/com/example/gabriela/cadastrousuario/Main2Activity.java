package com.example.gabriela.cadastrousuario;

import android.annotation.SuppressLint;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Main2Activity extends AppCompatActivity {

    Spinner spnEstado;
    Spinner spnCidade;
    RadioGroup rg;
    CheckBox ingles;
    CheckBox espanhol;
    CheckBox italiano;
    CheckBox frances;
    Button btnSalvar;
    ToggleButton tg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spnEstado =  findViewById(R.id.spnEstado);
        spnCidade = findViewById(R.id.spnCidade);
        rg = findViewById(R.id.rg);
        ingles = findViewById(R.id.cbIngles);
        espanhol = findViewById(R.id.cbEspanhol);
        italiano = findViewById(R.id.cbItaliano);
        frances = findViewById(R.id.cbFrances);
        btnSalvar = findViewById(R.id.btnSalvar);
        tg = findViewById(R.id.tg);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dlg = new AlertDialog.Builder(Main2Activity.this);
                dlg.setMessage("Cadastro feito com sucesso!");
                dlg.setNeutralButton("OK!",null);
                dlg.show();

            }
        });

        tg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Log.i("Informações",  "Concorda com os termos");
                    }else{
                    Log.i("Informações", "Favor, concordar com os termos");
                }
            }
        });

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.estado_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnEstado.setAdapter(adapter1);
        spnEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String spEstado = spnEstado.getSelectedItem().toString();
                Log.i("Informações", "Estado:" + spEstado);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.cidade_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCidade.setAdapter(adapter2);

        spnCidade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String spCidade = spnCidade.getSelectedItem().toString();
                Log.i("Informações", "Cidade:" + spCidade);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void onRadioButtonClicked(View view) {

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb && checkedId > -1) {
                    Log.i("Informações", "Sexo:" + rb.getText().toString());

                }

            }
        });

    }

    public void onCheckBoxClicked(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.cbIngles:
                if (checked)
                    Log.i("Informações", "Idioma:"+ingles.getText().toString());
                break;
            case R.id.cbEspanhol:
                if (checked)
                    Log.i("Informações",  "Idioma:"+espanhol.getText().toString());
                break;
            case R.id.cbItaliano:
                if (checked)
                    Log.i("Informações",  "Idioma:"+italiano.getText().toString());
                break;
            case R.id.cbFrances:
                if (checked)
                    Log.i("Informações", "Idioma:"+frances.getText().toString());
                break;
        }

    }
    }




