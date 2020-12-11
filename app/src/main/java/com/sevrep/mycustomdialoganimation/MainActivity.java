package com.sevrep.mycustomdialoganimation;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button positiveDialog;
    Button negativeDialog;
    AlertDialog.Builder dialogBuilder;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        positiveDialog = findViewById(R.id.btnPositiveDialog);
        positiveDialog.setOnClickListener(view -> showAlertDialog(R.layout.dialog_positive_layout));

        negativeDialog = findViewById(R.id.btnNegativeDialog);
        negativeDialog.setOnClickListener(view -> showAlertDialog(R.layout.dialog_negative_layout));

    }

    private void showAlertDialog(int layout) {
        dialogBuilder = new AlertDialog.Builder(MainActivity.this);
        View layoutView = getLayoutInflater().inflate(layout, null);
        Button dialogButton = layoutView.findViewById(R.id.btnDialog);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        dialogButton.setOnClickListener(view -> alertDialog.dismiss());
    }
}