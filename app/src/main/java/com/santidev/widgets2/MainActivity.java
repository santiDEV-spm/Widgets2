package com.santidev.widgets2;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView myTextView;
    EditText myEditTex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        //ACTIVITY_RADIO_BUTTONS
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);

       /* RadioButton rb1 = (RadioButton) findViewById(R.id.rb1);
        RadioButton rb2 = (RadioButton) findViewById(R.id.rb2);
        RadioButton rb3 = (RadioButton) findViewById(R.id.rb3); */

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int chekedID) {
                Log.d("RADIO BUTTON", "onCheckedChanged: " + chekedID);

                RadioButton rb = (RadioButton) radioGroup.findViewById(chekedID);
                Log.d("RADIO BUTTON", "onCheckedChanged: " + rb.getId());

                switch (rb.getId()){
                    case R.id.rb1:
                            Toast.makeText(radioGroup.getContext(), "Eres un hombre", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb2:
                        Toast.makeText(radioGroup.getContext(), "Eres una mujer", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb3:
                        Toast.makeText(radioGroup.getContext(), "LGBT+", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });

        //switch
        SwitchCompat switchCompat = (SwitchCompat) findViewById(R.id.sw1);

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isCheked) {
                if (isCheked){
                    compoundButton.setText("Ahora estoy activo :)");
                    radioGroup.setVisibility(View.VISIBLE);
                }else{
                    compoundButton.setText("Ahora no estoy activo :(");
                    radioGroup.setVisibility(View.INVISIBLE);
                }

            }
        });

        CheckBox cb1 = (CheckBox) findViewById(R.id.cb1);
        cb1.setText(getString(R.string.terms));
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isCheked) {
                if(isCheked){
                    compoundButton.setText("Ahora si acepto los terminos");
                }else{
                    compoundButton.setText("No acepto los terminos");
                }
            }
        });

        WebView webView = (WebView) findViewById(R.id.webview);
        webView.loadUrl("http://google.com");

        //Main Activity
      /*  myTextView = (TextView) findViewById(R.id.tv_hello);
        myEditTex = (EditText)findViewById(R.id.editText);
        Button myButton = (Button) findViewById(R.id.button);

        String editTextContent = myEditTex.getText().toString();
        myTextView.setVisibility(View.GONE);

        ImageView myImageView = (ImageView) findViewById(R.id.imgView);
        myImageView.setAlpha(0.7f);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextContent.length() == 0 || editTextContent == null){
                    openDialog();
                }
            }
        });

        myTextView.setText(editTextContent); */

    }

    public void openDialog(){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_demo);
        Button btnAgree = (Button) dialog.findViewById(R.id.btnAgree);
        Button btnCancel = (Button) dialog.findViewById(R.id.btnCancel);
        dialog.show();
        btnAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                myEditTex.setError("Ingresa tu nombre");
                myEditTex.requestFocus();
                Toast.makeText(getApplicationContext(),"Agree",Toast.LENGTH_SHORT).show();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                myTextView.setText("");
                myEditTex.setText("");
                Toast.makeText(getApplicationContext(),"Cancel",Toast.LENGTH_SHORT).show();
            }
        });

    }
}