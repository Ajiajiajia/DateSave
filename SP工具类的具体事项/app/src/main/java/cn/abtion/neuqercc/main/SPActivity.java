package cn.abtion.neuqercc.main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.abtion.neuqercc.R;
import cn.abtion.neuqercc.base.activities.NoBarActivity;
import cn.abtion.neuqercc.utils.ToastUtil;
import cn.abtion.neuqercc.weight.SharedHelper;

/**
 * Created by heaijia on 2018/1/24.
 */

public class SPActivity extends NoBarActivity {


    @BindView(R.id.editname)
    EditText editname;
    @BindView(R.id.editpasswd)
    EditText editpasswd;
    @BindView(R.id.btnput)
    Button btnput;
    @BindView(R.id.btnget)
    Button btnget;
    @BindView(R.id.btnremove)
    Button btnremove;
    @BindView(R.id.btnclear)
    Button btnclear;
    @BindView(R.id.btncontains)
    Button btncontains;

    @Override
    protected int getLayoutId() {
        return R.layout.sp;
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }




    @OnClick(R.id.btnput)
    public void onBtnputClicked() {

        String phonenumber = editname.getText().toString().trim();
        String phonepasswd = editpasswd.getText().toString().trim();

        SharedHelper.put(this,"phonenumber", phonenumber);
        ToastUtil.showToast(phonenumber);
    }

    @OnClick(R.id.btnget)
    public void onBtngetClicked() {

        String res = "";

//        res =  SharedHelper.get(SPActivity.this,"phonenumber",res);   错误操作

        res = (String) SharedHelper.get(SPActivity.this,"phonenumber",res);

// 方法二：       res = SharedHelper.get(SPActivity.this,"phonenumber",res).toString;

        ToastUtil.showToast(res);
    }

    @OnClick(R.id.btnremove)
    public void onBtnremoveClicked() {
    }

    @OnClick(R.id.btnclear)
    public void onBtnclearClicked() {
        SharedHelper.clear(this);

        ToastUtil.showToast("内存已经清空" );

    }

    @OnClick(R.id.btncontains)
    public void onBtncontainsClicked() {
    }
}