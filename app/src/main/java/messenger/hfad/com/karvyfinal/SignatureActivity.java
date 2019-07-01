package messenger.hfad.com.karvyfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.github.gcacace.signaturepad.views.SignaturePad;


public class SignatureActivity extends AppCompatActivity {
    SignaturePad signaturePad;
    Button saveButton,clearButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature_pad);
        signaturePad=findViewById(R.id.signaturePad);
        saveButton=findViewById(R.id.saveButton);
        clearButton=findViewById(R.id.clearButton);

        saveButton.setEnabled(false);
        clearButton.setEnabled(false);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        signaturePad.setOnSignedListener(new SignaturePad.OnSignedListener() {
            @Override
            public void onStartSigning() {

            }

            @Override
            public void onSigned() {
                saveButton.setEnabled(true);
                clearButton.setEnabled(true);

            }

            @Override
            public void onClear() {
                saveButton.setEnabled(false);
                saveButton.setEnabled(false);

            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //write code for saving the signature

                Toast.makeText(SignatureActivity.this,"Signature Saved",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SignatureActivity.this,DAPForm.class));

            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signaturePad.clear();
            }
        });

    }
}
