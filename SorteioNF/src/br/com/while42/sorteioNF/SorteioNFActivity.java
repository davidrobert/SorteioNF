package br.com.while42.sorteioNF;

import java.util.Calendar;
import java.util.GregorianCalendar;

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
                
            	Calendar calendar = new GregorianCalendar();
            	int day = calendar.get(Calendar.DAY_OF_MONTH);
            	
            	final EditText costText = (EditText) findViewById(R.id.costText);
            	final EditText sizeText = (EditText) findViewById(R.id.sizeText); 
            	
            	Double cost = new Double(costText.getText().toString());
            	Integer sum = day + cost.intValue() + ((int) (cost - cost.intValue()) * 100);
            	
            	Integer result = sum % (new Integer(sizeText.getText().toString())).intValue();            	          
            	
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