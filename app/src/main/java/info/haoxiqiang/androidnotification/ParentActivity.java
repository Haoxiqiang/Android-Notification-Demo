package info.haoxiqiang.androidnotification;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by haoxiqiang on 15/1/30.
 */
public class ParentActivity extends ActionBarActivity {

    private TextView jump;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_result);

        jump = (TextView) findViewById(R.id.jump);
        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParentActivity.this,MainActivity.class);
                startActivity(intent);
                ParentActivity.this.finish();
            }
        });
    }
}
