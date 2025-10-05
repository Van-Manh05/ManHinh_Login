package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUser, edtPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();

                // Tài khoản 1: admin
                if (user.equals("admin") && pass.equals("1234")) {
                    // Tạo một Bundle để chứa thông tin của admin
                    Bundle adminInfo = new Bundle();
                    adminInfo.putString("USERNAME", "Admin");
                    adminInfo.putString("FRIENDS", "150");
                    adminInfo.putString("FOLLOWERS", "300");
                    adminInfo.putString("NOTIFICATIONS", "3");
                    adminInfo.putString("EMAIL", "admin@email.com");
                    adminInfo.putString("PHONE", "+84 123 456 789");
                    adminInfo.putString("SKYPE", "admin.skype");
                    adminInfo.putString("WEB", "admin-homepage.com");
                    loginSuccess(adminInfo);
                }
                // Tài khoản 2: user
                else if (user.equals("user") && pass.equals("12345")) {
                    // Tạo một Bundle để chứa thông tin của user
                    Bundle userInfo = new Bundle();
                    userInfo.putString("USERNAME", "Normal User");
                    userInfo.putString("FRIENDS", "55");
                    userInfo.putString("FOLLOWERS", "120");
                    userInfo.putString("NOTIFICATIONS", "12");
                    userInfo.putString("EMAIL", "user@email.com");
                    userInfo.putString("PHONE", "+84 987 654 321");
                    userInfo.putString("SKYPE", "user.skype");
                    userInfo.putString("WEB", "user-blog.com");
                    loginSuccess(userInfo);
                }
                // Đăng nhập thất bại
                else {
                    Toast.makeText(MainActivity.this, "Invalid username or password!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loginSuccess(Bundle userInfo) {
        Toast.makeText(MainActivity.this, "Login success!", Toast.LENGTH_SHORT).show();

        // Tạo Intent để chuyển sang màn hình Profile
        Intent intent = new Intent(MainActivity.this, profile.class);

        // Đóng gói toàn bộ Bundle dữ liệu để gửi đi
        intent.putExtra("USER_INFO_BUNDLE", userInfo);

        // Bắt đầu Activity mới
        startActivity(intent);
    }
}
