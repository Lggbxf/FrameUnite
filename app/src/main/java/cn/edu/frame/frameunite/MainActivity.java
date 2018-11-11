package cn.edu.frame.frameunite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.edu.frame.frameunite.di.component.DaggerActivityComponent;
import cn.edu.frame.frameunite.di.moudle.ActivityMoudle;
import cn.edu.frame.frameunite.mvp.model.User;
import cn.edu.frame.frameunite.mvp.presenter.LoginPresenter;
import cn.edu.frame.frameunite.mvp.view.LoginView;


public class MainActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn)
    Button btn;

    //public LoginPresenter mLoginPresenter;
    @Inject
    LoginPresenter mLoginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        DaggerActivityComponent.builder().activityMoudle(new ActivityMoudle(MainActivity.this)).build().inject(this);
       // mLoginPresenter = new LoginPresenterImpl(this);
        mLoginPresenter.attachView(this);


    }

    @OnClick(R.id.btn)
    public void onViewClicked() {



        Map<String,String> map = new HashMap<>();
        map.put("uuid", "a4e0293f-1f09-45cb-9b58-37861c345bv9");
        map.put("username", etUsername.getText().toString());
        map.put("passwd", "343b1c4a3ea721b2d640fc8700db0f36");
        map.put("pkgname", "com.asd");
        map.put("vcode", "112");


        mLoginPresenter.login(map);

    }

    @Override
    public void loginSuccess() {
        showToast("注册成功！");
    }

    @Override
    public void loginFailed(String data) {

        showToast(data);


    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
