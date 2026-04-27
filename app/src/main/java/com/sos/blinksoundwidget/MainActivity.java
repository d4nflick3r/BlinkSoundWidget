package com.sos.blinksoundwidget;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        int padding = dpToPx(24);
        layout.setPadding(padding, padding, padding, padding);

        TextView title = new TextView(this);
        title.setText(getString(R.string.app_name));
        title.setTextSize(24);
        title.setGravity(Gravity.CENTER);

        TextView instructions = new TextView(this);
        instructions.setText(getString(R.string.main_instructions));
        instructions.setTextSize(16);
        instructions.setGravity(Gravity.CENTER);
        instructions.setPadding(0, dpToPx(16), 0, dpToPx(16));

        Button playButton = new Button(this);
        playButton.setText(getString(R.string.widget_button_text));
        playButton.setOnClickListener(view -> SoundPlayer.play(this));

        layout.addView(title);
        layout.addView(instructions);
        layout.addView(playButton);

        setContentView(layout);
    }

    private int dpToPx(int dp) {
        return Math.round(dp * getResources().getDisplayMetrics().density);
    }
}
