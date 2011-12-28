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

		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				return;
			}
		});

		button.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				final EditText costText = (EditText) findViewById(R.id.costText);
				final EditText sizeText = (EditText) findViewById(R.id.sizeText);

				if (costText.getText().toString().length() == 0
						|| sizeText.getText().toString().length() == 0) {
					alertDialog.setTitle("Dados inválidos");
					alertDialog.show();
					return;
				}

				double cost = 0;
				try {
					cost = new Double(costText.getText().toString());
				} catch (Exception e) {
					alertDialog.setTitle("Erro no double");
					alertDialog.show();
					return;
				}

				int numberOfPeople = (new Integer(sizeText.getText().toString()))
						.intValue();

				if (numberOfPeople == 0) {
					alertDialog.setTitle("Dados inválidos");
					alertDialog.show();
					return;
				}

				Integer result = (int) NFPCalc.calculateForToday(cost,
						numberOfPeople);

				alertDialog.setTitle("Resultado do Sorteio: "
						+ result.toString());
				alertDialog.show();
			}
		});
	}
}