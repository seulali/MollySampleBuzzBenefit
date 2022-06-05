package com.example.mollysamplebuzzbenefit;

import android.app.Application;

import com.buzzvil.buzzad.benefit.BuzzAdBenefit;
import com.buzzvil.buzzad.benefit.BuzzAdBenefitConfig;
import com.buzzvil.buzzad.benefit.presentation.feed.FeedConfig;
import com.buzzvil.buzzad.benefit.presentation.interstitial.BuzzAdInterstitial;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // BuzzAdBenefit 초기화
        final FeedConfig feedConfig = new FeedConfig.Builder("321776489787230")
                .build();

        final BuzzAdBenefitConfig buzzAdBenefitConfig = new BuzzAdBenefitConfig.Builder(getApplicationContext())
                .setDefaultFeedConfig(feedConfig)
                .build();

        BuzzAdBenefit.init(getApplicationContext(), buzzAdBenefitConfig);
    }
}