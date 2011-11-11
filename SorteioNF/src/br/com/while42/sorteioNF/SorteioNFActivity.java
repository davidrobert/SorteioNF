package br.com.while42.sorteioNF;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SorteioNFActivity extends Activity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Button button = (Button) findViewById(R.id.calcButton);
       	final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
       	
        button.setOnClickListener(new View.OnClickListener() {
        	
            public void onClick(View v) {
                
            	final EditText costText = (EditText) findViewById(R.id.costText);
            	final EditText sizeText = (EditText) findViewById(R.id.sizeText); 
            	
            	double cost = new Double(costText.getText().toString());
            	
            	long numberOfPeople = (new Integer(sizeText.getText().toString())).intValue();
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