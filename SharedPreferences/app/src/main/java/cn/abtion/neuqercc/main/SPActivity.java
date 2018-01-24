package cn.abtion.neuqercc.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.abtion.neuqercc.R;
import cn.abtion.neuqercc.base.activities.NoBarActivity;
import cn.abtion.neuqercc.utils.ToastUtil;
import cn.abtion.neuqercc.weight.SharedHelper;

/**
 * Created by heaijia on 2018/1/24.
 */

public class SPActivity extends AppCompatActivity {

    private EditText editname;
    private EditText editpasswd;

    private Button btnlogin;
    private String strname;
    private String strpasswd;

    private SharedHelper sh;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sp);
        mContext = getApplicationContext();
        sh = new SharedHelper(mContext);
        bindViews();


        Button btnshow = (Button) findViewById(R.id.btnshow);

        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                //获得第一个应用的包名,从而获得对应的Context,需要对异常进行捕获
//                try {
//                    othercontext = createPackageContext("com.jay.sharedpreferencedemo", Context.CONTEXT_IGNORE_SECURITY);
//                } catch (PackageManager.NameNotFoundException e) {
//                    e.printStackTrace();
//                }
//                //根据Context取得对应的SharedPreferences
//                sp = othercontext.getSharedPreferences("mysp", Context.MODE_WORLD_READABLE);
//                String name = sp.getString("username", "");
//                String passwd = sp.getString("passwd", "");
//                Toast.makeText(getApplicationContext(), "Demo1的SharedPreference存的\n用户名为：" + name + "\n密码为：" + passwd, Toast.LENGTH_SHORT).show();

                ToastUtil.showToast("啦啦啦德玛西亚");

            }
        });
    }


    private void bindViews() {
        editname = (EditText)findViewById(R.id.editname);
        editpasswd = (EditText)findViewById(R.id.editpasswd);
        btnlogin = (Button)findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strname = editname.getText().toString();
                strpasswd = editpasswd.getText().toString();
                sh.save(strname,strpasswd);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Map<String,String> data = sh.read();
        editname.setText(data.get("username"));
        editpasswd.setText(data.get("passwd"));
    }




    private Context othercontext;
    private SharedPreferences sp;



}
