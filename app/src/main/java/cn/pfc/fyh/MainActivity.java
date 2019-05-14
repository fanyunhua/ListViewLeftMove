package cn.pfc.fyh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.pfc.fyh.activity.DifficultActivity;
import cn.pfc.fyh.activity.EasyActivity;
/**
 * @author fyh by 2019.5.14 18:29
 *
 * */
public class MainActivity extends AppCompatActivity {
    private Button mMainBtn1;
    private Button mMainBtn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainBtn1 = (Button) findViewById(R.id.mMainBtn1);
        mMainBtn2 = (Button) findViewById(R.id.mMainBtn2);
        mMainBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EasyActivity.class));
            }
        });
        mMainBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DifficultActivity.class));
            }
        });
    }
}
