package com.messenger;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public  class MessengerListAdapter extends ArrayAdapter<String> {

	private  Context context;
	private  List<String> values;
	int toggle;

	public MessengerListAdapter(Context context, List<String> values,int toggle) {
		super(context,R.layout.row_msg,values);
		this.context = context;
		this.values = values;
		this.toggle = toggle;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {


		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = null;
		if(toggle ==0){

			rowView = inflater.inflate(R.layout.row_msg, parent, false);
			TextView textView = (TextView) rowView.findViewById(R.id.TVLeftMsg);
			textView.setText(values.get(position));
		}else if (toggle == 1){

			rowView = inflater.inflate(R.layout.row_msg_right, parent, false);
			TextView textView = (TextView) rowView.findViewById(R.id.TVRightMsg);
			textView.setText(values.get(position));
		}


		return rowView;
	}
}
