package codepath.app.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setupSeekBarListeners();
		//getAmount(getCurrentFocus());
	}
	
	
	public String getAmount()
	{
		EditText etNewItem = (EditText)findViewById(R.id.tipText);
		String  amount =etNewItem.getText().toString();
		System.out.println("amount "+ amount);		
		return amount;
		
		
	}
	
	
	
	public void setupSeekBarListeners(){
		
		SeekBar sb = (SeekBar) findViewById(R.id.seekBar1);
        sb.setMax(100);
        sb.setProgress(5);
        final TextView tipPercent = (TextView)findViewById(R.id.tipPercent);
        sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                    boolean fromUser) {
            	
            	TextView tipAmount = (TextView)findViewById(R.id.tipAmount);
            	
            	
            	tipPercent.setText(String.valueOf(progress) +" percent");
            	
            	String input = getAmount();
				double amount =0.0;
				
				try{
				 amount = Double.parseDouble(input);
				}
				catch(NumberFormatException e){
					
					tipAmount.setText("Not a number");
					
				}
            	
              
                tipAmount.setText("Tip: "+Double.toString(+progress*amount*0.01) );
                
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

        });
        
        
        
	}
	
	
	
}
