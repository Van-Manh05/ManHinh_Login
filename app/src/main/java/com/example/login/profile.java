package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class profile extends AppCompatActivity {

    // Khai báo tất cả các View cần cập nhật
    TextView tvProfileName, tvFriendsCount, tvFollowersCount, tvNotificationBadge;
    TextView tvEmail, tvPhone, tvSkype, tvWeb;
    TextView tvBack;
    ImageButton ibSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Ánh xạ toàn bộ View từ layout XML
        tvProfileName = findViewById(R.id.tvProfileName);
        tvFriendsCount = findViewById(R.id.tvFriendsCount);
        tvFollowersCount = findViewById(R.id.tvFollowersCount);
        tvNotificationBadge = findViewById(R.id.tvNotificationBadge);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvSkype = findViewById(R.id.tvSkype);
        tvWeb = findViewById(R.id.tvWeb); // Đã sửa từ tvSkype2 thành tvWeb

        tvBack = findViewById(R.id.tvBack);
        ibSettings = findViewById(R.id.ibSettings);

        // Lấy Intent và Bundle dữ liệu
        Intent intent = getIntent();
        Bundle userInfo = intent.getBundleExtra("USER_INFO_BUNDLE");

        if (userInfo != null) {
            // Hiển thị dữ liệu lên các View
            tvProfileName.setText(userInfo.getString("USERNAME", "Profile Name"));
            tvFriendsCount.setText(userInfo.getString("FRIENDS", "0"));
            tvFollowersCount.setText(userInfo.getString("FOLLOWERS", "0"));
            tvNotificationBadge.setText(userInfo.getString("NOTIFICATIONS", "0"));

            // Cập nhật thông tin chi tiết
            tvEmail.setText("email : " + userInfo.getString("EMAIL", "N/A"));
            tvPhone.setText("Phone : " + userInfo.getString("PHONE", "N/A"));
            tvSkype.setText("Skype : " + userInfo.getString("SKYPE", "N/A"));
            tvWeb.setText("Web : " + userInfo.getString("WEB", "N/A"));
        }

        // --- XỬ LÝ SỰ KIỆN CLICK ---

        // 1. Khi nhấn nút "Back"
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kết thúc Activity hiện tại và quay về màn hình trước đó (MainActivity)
                finish();
            }
        });

        // 2. Khi nhấn nút "Settings"
        ibSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tương tự, kết thúc Activity hiện tại
                finish();
            }
        });
    }
}
