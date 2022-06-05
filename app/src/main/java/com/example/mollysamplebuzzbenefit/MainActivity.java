package com.example.mollysamplebuzzbenefit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.buzzvil.buzzad.benefit.BuzzAdBenefit;
import com.buzzvil.buzzad.benefit.core.models.UserProfile;
import com.buzzvil.buzzad.benefit.presentation.feed.BuzzAdFeed;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 사용자 정보를 등록하는 코드입니다.
        final UserProfile.Builder builder = new UserProfile.Builder(BuzzAdBenefit.getUserProfile());
        final UserProfile userProfile = builder
                .userId("MOllY")
                .gender(UserProfile.Gender.MALE) //남성 사용자
                .birthYear(1993)
                .build();
        BuzzAdBenefit.setUserProfile(userProfile);

    Button feedOpenBtn = (Button) findViewById(R.id.feedOpenBtn);
    feedOpenBtn.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            new BuzzAdFeed.Builder().build().show(MainActivity.this);
        }
    });


    }

}

