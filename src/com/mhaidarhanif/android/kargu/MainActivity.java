package com.mhaidarhanif.android.kargu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

  // For complete title purpose. Will be used later.
  // String appEditionName = getString(R.string.app_name) + " " + getString(R.string.name_edition);

  public final static String EXTRA_NUMBER = "com.mhaidarhanif.android.kargu.NUMBER";
  private static Drawable sLogoKargu;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Avoid leaks by keep potential used image in a static field.
    if (sLogoKargu == null) {
      sLogoKargu = this.getResources().getDrawable(R.drawable.ic_launcher);
    }

    setContentView(R.layout.activity_main);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu. This adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  // Called when press getNumber
  public void getNumber(View view) {
    Intent intent = new Intent(this, DisplayNumberActivity.class);
    EditText editText = (EditText) findViewById(R.id.edit_inputNumber);
    String number = editText.getText().toString();
    intent.putExtra(EXTRA_NUMBER, number);
    startActivity(intent);
  }

  public void openDialog(View v) {
    Intent intent = new Intent(MainActivity.this, AboutDialogActivity.class);
    startActivity(intent);
  }

}
