package com.example.tictactoe_game;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	Button a1,a2,a3,b1,b2,b3,c1,c2,c3 ,newGame;
	Button[]bArray ;
	boolean turn =true ;
	int turn_count =0;
	int h1,h2,h3,v1,v2,v3,d1,d2;
	ActionBar refresh ,remove ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		a1=(Button) findViewById(R.id.a1);
		a2=(Button) findViewById(R.id.a2);
		a3=(Button) findViewById(R.id.a3);
		b1=(Button) findViewById(R.id.b1);
		b2=(Button) findViewById(R.id.b2);
		b3=(Button) findViewById(R.id.b3);
		c1=(Button) findViewById(R.id.c1);
		c2=(Button) findViewById(R.id.c2);
		c3=(Button) findViewById(R.id.c3);
		newGame=(Button)findViewById(R.id.newGame);
		bArray=new Button[]{a1,a2,a3,b1,b2,b3,c1,c2,c3};
		
		for(Button b:bArray){
			b.setOnClickListener(this);
		}
		newGame.setOnClickListener(new OnClickListener(){
			
			public void onClick(View v){
				turn=true ;
				turn_count=0;
				EnableDisableAllButton(true);
			
			}
		});

		
	}
	public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_main_activity2, menu);
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_xml2, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_new:
                Intent intent = new android.content.Intent();
                intent.setClass(this, this.getClass());  //We will start the
                  finish();
                this.startActivity(intent);
            case R.id.action_exit:
               
            	System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Button b=(Button)v;
		buttonCliked(b);
			
	}
	public void buttonCliked(Button b){
		if(turn){
			b.setText("X");
			b.setBackgroundColor(Color.parseColor("#f16e8d"));
		}
		else {
			b.setText("O");
			b.setBackgroundColor(Color.parseColor("#4797d6"));
		}
		turn_count++;
		b.setClickable(false);
		turn=!turn;
		checkForWinner();
	}
	public void checkForWinner(){
		boolean win =false;
		
		// checking horizontally
		if(a1.getText()==a2.getText() && a2.getText()==a3.getText()&& !a1.isClickable()){
			win=true;
			 h1=1 ;}
		
		else if(b1.getText()==b2.getText() && b2.getText()==b3.getText()&& !b1.isClickable()){
			win=true;
			 h2=1;}
		else if(c1.getText()==c2.getText() && c2.getText()==c3.getText()&& !c1.isClickable()){
			win=true;
			 h3=1;}
		
		//vertical 
		else if(a1.getText()==b1.getText() && b1.getText()==c1.getText()&& !a1.isClickable()){
			win=true;
			 v1=1;}
		else if(a2.getText()==b2.getText() && b2.getText()==c2.getText()&& !b2.isClickable()){
			win=true;
			 v2=1;}
		else if(a3.getText()==b3.getText() && b3.getText()==c3.getText()&& !c3.isClickable()){
			win=true;
			 v3=1;}
		//diagonal
		else if(a1.getText()==b2.getText() && b2.getText()==c3.getText()&& !a1.isClickable()){
			win=true;
			 d1=1;}
		else if(a3.getText()==b2.getText() && b2.getText()==c1.getText()&& !b2.isClickable()){
			win=true;
			 d2=1 ;}
		
		if(win){
			if(!turn){
				toaste("X win");
			}
			else{
				toaste("O win");
				
			}
			if(h1==1){
				a1.setBackgroundColor(Color.parseColor("#2e8a06"));
				a2.setBackgroundColor(Color.parseColor("#2e8a06"));
				a3.setBackgroundColor(Color.parseColor("#2e8a06"));
			}
			else if(h2==1){
				b2.setBackgroundColor(Color.parseColor("#2e8a06"));
				b1.setBackgroundColor(Color.parseColor("#2e8a06"));
				b3.setBackgroundColor(Color.parseColor("#2e8a06"));
			}
			else if(h3==1){
				c1.setBackgroundColor(Color.parseColor("#2e8a06"));
				c2.setBackgroundColor(Color.parseColor("#2e8a06"));
				c3.setBackgroundColor(Color.parseColor("#2e8a06"));
			}
			else if(v1==1){
				a1.setBackgroundColor(Color.parseColor("#2e8a06"));
				b1.setBackgroundColor(Color.parseColor("#2e8a06"));
				c1.setBackgroundColor(Color.parseColor("#2e8a06"));
			}
			else if(v2==1){
				a2.setBackgroundColor(Color.parseColor("#2e8a06"));
				b2.setBackgroundColor(Color.parseColor("#2e8a06"));
				c2.setBackgroundColor(Color.parseColor("#2e8a06"));
			}
			else if(v3==1){
				a3.setBackgroundColor(Color.parseColor("#2e8a06"));
				b3.setBackgroundColor(Color.parseColor("#2e8a06"));
				c3.setBackgroundColor(Color.parseColor("#2e8a06"));
			}
			else if(d1==1){
				a1.setBackgroundColor(Color.parseColor("#2e8a06"));
				b2.setBackgroundColor(Color.parseColor("#2e8a06"));
				c3.setBackgroundColor(Color.parseColor("#2e8a06"));
			}
			else if(d2==1){
				a3.setBackgroundColor(Color.parseColor("#2e8a06"));
				b2.setBackgroundColor(Color.parseColor("#2e8a06"));
				c1.setBackgroundColor(Color.parseColor("#2e8a06"));
			}
			EnableDisableAllButton(false);
				
			
		}
		else if(turn_count==9)
			toaste("Draw");
			
			
	}
	
	private void EnableDisableAllButton(boolean enable) {
		for(Button b:bArray){
			b.setClickable(enable);
			if(enable){
				b.setBackgroundColor(Color.parseColor("#e6e6fa"));
				b.setText("");
				h1=0;h2=0;h3=0;v1=0;v2=0;v3=0;d1=0;d2=0;
				}
			else ;
		}
		
	}

	private void toaste(String massege){
		Toast.makeText(getApplicationContext(), massege, Toast.LENGTH_LONG).show();
	}
	
//	 public boolean onCreateOptionsMenu1(Menu menu) {
//		 MenuInflater inflater = getMenuInflater(); //read XML
//		 inflater.inflate(R.menu.main_xml2, menu);
//		 return super.onCreateOptionsMenu(menu);
//		 } 
//	
//	 public boolean onOptionsItemSelected(MenuItem menuItem) {
//	 // code to handle clicks on menu items goes here
//	 return super.onOptionsItemSelected (menuItem);
//	 int id = menuItem.getItemId();
//	 switch(id){
//	 case (R.id.action_remove):finish();
//	 case (R.id.refresh_icon):
//	 
//	 }
//	 } 
	
//	public boolean onCreateOptionMenue(Menu menu){
//		 MenuInflater inflater = getMenuInflater();
//		 inflater.inflate(R.menu.main_xml2, menu);
//		 return super.onCreateOptionsMenu(menu);
//	}

}
