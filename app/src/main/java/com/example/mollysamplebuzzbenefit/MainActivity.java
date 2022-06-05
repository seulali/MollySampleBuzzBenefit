package com.example.mollysamplebuzzbenefit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.buzzvil.buzzad.benefit.BuzzAdBenefit;
import com.buzzvil.buzzad.benefit.core.ad.AdError;
import com.buzzvil.buzzad.benefit.core.models.UserProfile;
import com.buzzvil.buzzad.benefit.presentation.feed.BuzzAdFeed;
import com.buzzvil.buzzad.benefit.presentation.interstitial.BuzzAdInterstitial;
import com.buzzvil.buzzad.benefit.presentation.interstitial.InterstitialAdListener;

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

        // 피드 버튼 클릭 이벤트 처리(지면 오픈)
    Button feedOpenBtn = (Button) findViewById(R.id.feedOpenBtn);
    feedOpenBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            new BuzzAdFeed.Builder().build().show(MainActivity.this);
        }
    });

    // 인터스티셜 버튼 클릭 이벤트 처리(지면 오픈)
        Button interstitialOpenBtn = (Button) findViewById(R.id.interstitialOpenBtn);
        interstitialOpenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BuzzAdInterstitial buzzAdInterstitial = new BuzzAdInterstitial.Builder("247945489902974").buildBottomSheet();
                buzzAdInterstitial.load(new InterstitialAdListener() {
                    @Override
                    public void onAdLoaded() {
                        // 할당된 광고가 있으면 호출됩니다.
                        // Interstitial 광고를 화면에 표시합니다.
                        buzzAdInterstitial.show(MainActivity.this);
                    }

                    @Override
                    public void onAdLoadFailed(@Nullable AdError adError) {
                        // 할당된 광고가 없으면 호출됩니다.
                        Log.e("에러 메시지", "Failed to load a interstitial ad.", adError);
                    }

                    @Override
                    public void onAdClosed() {
                        super.onAdClosed();
                        // Interstitial 지면이 종료되면 호출됩니다.
                        // 필요에 따라 추가 기능을 구현하세요.
                    }
                });
            }
        });


    }

}

