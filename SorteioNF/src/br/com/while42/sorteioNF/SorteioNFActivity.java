package br.com.while42.sorteioNF;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SorteioNFActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Spinner s = (Spinner) findViewById(R.id.sizeSpinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.sizes, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);	    
		s.setAdapter(adapter);

		final Button button = (Button) findViewById(R.id.calcButton);
		final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
		final AlertDialog errorDialog = new AlertDialog.Builder(this).create();

		errorDialog.setMessage("Dados invalidos");
		errorDialog.setButton("Voltar", new DialogInterface.OnClickListener() {  
			public void onClick(DialogInterface dialog, int which) {  
				return;  
			} });

		button.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				final EditText costText = (EditText) findViewById(R.id.costText);
				final EditText sizeText = (EditText) findViewById(R.id.sizeText); 

				if (costText.getText().toString().length() == 0 || sizeText.getText().toString().length() == 0) {
					errorDialog.show();
					return;
				}

				double cost = 0;
				try {
					cost = new Double(costText.getText().toString());
				} catch (Exception e) {
					errorDialog.setMessage("erro no double");
					errorDialog.show();
					return;
				}

				int numberOfPeople = (new Integer(sizeText.getText().toString())).intValue();

				if (numberOfPeople == 0) {
					errorDialog.show();
					return;
				}

				Integer result = (int)NFPCalc.calculateForToday(cost, numberOfPeople);

				alertDialog.setTitle("Resultado do Sorteio");  
				alertDialog.setMessage(result.toString());  
				alertDialog.setButton("OK", new DialogInterface.OnClickListener() {  
					public void onClick(DialogInterface dialog, int which) {  
						return;  
					} });

				alertDialog.show();
			}
		});
	}
}