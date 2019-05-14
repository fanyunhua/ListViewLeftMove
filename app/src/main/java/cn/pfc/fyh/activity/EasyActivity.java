package cn.pfc.fyh.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.pfc.fyh.R;
import cn.pfc.fyh.adapter.EasyAdapter;

/**
 * @author fyh by 2019.5.14 18:29
 *
 * */
public class EasyActivity extends AppCompatActivity {
    private ListView mEaseLV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);
        mEaseLV = (ListView) findViewById(R.id.mEaseLV);
        List<String> list = new ArrayList<>();
        for (int i = 'A'; i <='Z' ; i++) {
            list.add((char)i+"");
        }
        EasyAdapter easyAdapter = new EasyAdapter(EasyActivity.this,list);
        mEaseLV.setAdapter(easyAdapter);
    }
}
