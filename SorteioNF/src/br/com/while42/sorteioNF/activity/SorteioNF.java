package br.com.while42.sorteioNF.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import br.com.while42.sorteioNF.NFPCalc;
import br.com.while42.sorteioNF.R;

public class SorteioNF extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		final Button button = (Button) findViewById(R.id.calcButton);
		final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
		final EditText costText = (EditText) findViewById(R.id.costText);
		final EditText sizeText = (EditText) findViewById(R.id.sizeText);

		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				return;
			}
		});

		button.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				double cost = 0;
				int numberOfPeople = 0;

				try {
					cost = Double.parseDouble(costText.getText().toString());
					numberOfPeople = Integer.parseInt(sizeText.getText()
							.toString());
				} catch (NumberFormatException e) {
					alertDialog.setTitle("Dados inválidos");
					alertDialog.setMessage("");
					alertDialog.show();
					return;
				}

				Integer result = (int) NFPCalc.calculateForToday(cost,
						numberOfPeople);

				alertDialog.setTitle("Resultado do Sorteio");
				alertDialog.setMessage(result.toString());
				alertDialog.show();
			}
		});
	}
}