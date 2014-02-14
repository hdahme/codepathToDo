package codepath.apps.simpletodo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends Activity {
	
	int pos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_item);
		String itemText = getIntent().getStringExtra("item");
		pos = getIntent().getIntExtra("pos", 0);
		EditText etEditItem = (EditText) findViewById(R.id.etEditItem);
		etEditItem.setText(itemText);
		etEditItem.setSelection(itemText.length());
	}
	
	public void saveTodoItem(View v) {
		EditText etEditItem = (EditText) findViewById(R.id.etEditItem);
		String newItemText = etEditItem.getText().toString();
		Intent data = new Intent();
		data.putExtra("item", newItemText);
		data.putExtra("pos", pos);
		setResult(RESULT_OK, data);
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_item, menu);
		return true;
	}

}
