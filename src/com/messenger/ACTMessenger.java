package com.messenger;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ACTMessenger extends ListActivity{

	List<String> msgList,msgList1;
	EditText editText;
	Button button;
	MessengerListAdapter listAdapter;
	int toggle=0;
	String emptyMsg = "";


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_msg);

		msgList  = new ArrayList<String>();
		getHandles();

		if(msgList.size()!=0){
			listAdapter = new MessengerListAdapter(getBaseContext(), msgList,toggle);	
			setListAdapter(listAdapter);
		}else{

			msgList.add(emptyMsg);
			listAdapter = new MessengerListAdapter(getBaseContext(), msgList,toggle);	
			setListAdapter(listAdapter);
		}

	}

	private void getHandles() {

		editText = (EditText)findViewById(R.id.EDMsgInput);
		editText.addTextChangedListener(textChange);
		button = (Button)findViewById(R.id.BTSend);
		button.setOnClickListener(send);
		button.setBackgroundResource(R.drawable.sendno);
		button.setEnabled(false);
	}

	OnClickListener send = new OnClickListener() {

		@Override
		public void onClick(View v) {

			if(toggle ==0){

				if(msgList.get(0).toString() == emptyMsg){

					msgList.clear();
					msgList.add(editText.getText().toString());

					listAdapter.notifyDataSetChanged();
					//					setListAdapter( new MessengerListAdapter(getBaseContext(), msgList,toggle));
					editText.setText("");

				}else {
					toggle++;
					msgList.add(editText.getText().toString());
					listAdapter = new MessengerListAdapter(getBaseContext(), msgList,toggle);
					listAdapter.notifyDataSetChanged();
					//					setListAdapter( new MessengerListAdapter(getBaseContext(), msgList,toggle));
					editText.setText("");

				}
			}else if(toggle ==1){



				if(msgList.get(0).toString() == emptyMsg){

					msgList.clear();
					msgList.add(editText.getText().toString());
					listAdapter.notifyDataSetChanged();
					//					setListAdapter( new MessengerListAdapter(getBaseContext(), msgList,toggle));
					editText.setText("");

				}else {
					toggle--;
					msgList.add(editText.getText().toString());
					listAdapter = new MessengerListAdapter(getBaseContext(), msgList,toggle);
					listAdapter.notifyDataSetChanged();
					//					setListAdapter( new MessengerListAdapter(getBaseContext(), msgList,toggle));
					editText.setText("");

				}
			}
		}
	};

	TextWatcher textChange = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {

			if(editText.length() == 0){

				button.setEnabled(false);
				button.setBackgroundResource(R.drawable.sendno);
			}else{
				button.setEnabled(true);
				button.setBackgroundResource(R.drawable.send);
			}

		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub

		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub

		}
	};

}