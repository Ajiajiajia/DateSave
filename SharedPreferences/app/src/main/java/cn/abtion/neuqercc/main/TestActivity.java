package cn.abtion.neuqercc.main;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.abtion.neuqercc.R;
import cn.abtion.neuqercc.account.activities.LoginActivity;
import cn.abtion.neuqercc.base.activities.NoBarActivity;
import cn.abtion.neuqercc.utils.RegexUtil;
import cn.abtion.neuqercc.utils.ToastUtil;
//import cn.abtion.neuqercc.weight.PreferencesUtils;
import cn.abtion.neuqercc.weight.RegexpUtil;

/**
 * Created by heaijia on 2018/1/22.
 */

public class TestActivity extends NoBarActivity {
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.login)
    Button login;
    private int sharePreInt;


    @Override
    protected int getLayoutId() {
        return R.layout.test;
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initView() {




    }

    @OnClick(R.id.login)
    public void check() {


        String phonenumber = phone.getText().toString().trim();

        if(RegexpUtil.checkMobile(phonenumber)) {

            ToastUtil.showToast("你成功了");

        }else{
            ToastUtil.showToast("不行，拒绝");
        }
//
//        String name = phone.getText().toString().trim();
//        int value=phone.getText().
//
//        PreferencesUtils.saveObject(TestActivity.this,name,);



    }


    @Override
    protected void loadData() {

    }

    static class ViewHolder {


        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}


