package org.torproject.android.mini.ui.onboarding;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;

import org.torproject.android.mini.R;
import org.torproject.android.mini.settings.LocaleHelper;

public class OnboardingActivity extends AppIntro {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Instead of fragments, you can also use our default slide
        // Just set a title, description, background and image. AppIntro will do the rest.
        CustomSlideBigText welcome = CustomSlideBigText.newInstance(R.layout.custom_slide_big_text);
        welcome.setTitle("The power of tor made simple for your life");
        welcome.setSubTitle("orbot mini");
        addSlide(welcome);

        CustomSlideBigText intro2 = CustomSlideBigText.newInstance(R.layout.custom_slide_big_text);
        intro2.setTitle("unblock any app with a few taps");
        intro2.setSubTitle("so easy");
        addSlide(intro2);

        // OPTIONAL METHODS
        // Override bar/separator color.
        setBarColor(getResources().getColor(R.color.dark_green));
        setSeparatorColor(getResources().getColor(R.color.panel_background_main));

        // Hide Skip/Done button.
        showSkipButton(false);
        setProgressButtonEnabled(true);
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.
        finish();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base));
    }
}