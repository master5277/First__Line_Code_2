package com.example.activitytest;

import static android.widget.Toast.makeText;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FirstActivity extends AppCompatActivity {

    public static final String TAG = "FirstActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                makeText(FirstActivity.this, "You clicked Button 1", Toast.LENGTH_SHORT).show();
              //显式Intent:
                /*
                 Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);
                 */

                //打开浏览器
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));
//                startActivity(intent);

                //调用系统拨号界面
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel.10086"));
//                startActivity(intent);

                //向下一个活动传递信息
//                String data = "Hello SecondActivity";
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                intent.putExtra("extra_data",data);
//                startActivity(intent);

                //接收来自SecondActivity的信息
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);

            }
        });
        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.activitytest.ACTION.START");
                intent.addCategory("com.example.activitytest.MY_CATEGORY");
                startActivity(intent);
            }
        });

    }
    //导入菜单布局
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //点击菜单项的触发事件
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.mune_enter) {
            makeText(this, "点击选项一", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.mune_setting) {
            makeText(this, "点击选项二", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.mune_out) {
            makeText(this, "点击选项三", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode)
        {
            case 1:
                if (resultCode==RESULT_OK)
                {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d(TAG, "onActivityResult: "+returnedData);
                }
                break;
            default:
                break;
        }
    }
}