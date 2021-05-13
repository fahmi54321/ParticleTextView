package com.android.a74particletextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yasic.library.particletextview.MovingStrategy.BidiHorizontalStrategy;
import com.yasic.library.particletextview.MovingStrategy.BidiVerticalStrategy;
import com.yasic.library.particletextview.MovingStrategy.CornerStrategy;
import com.yasic.library.particletextview.MovingStrategy.HorizontalStrategy;
import com.yasic.library.particletextview.MovingStrategy.RandomMovingStrategy;
import com.yasic.library.particletextview.MovingStrategy.VerticalStrategy;
import com.yasic.library.particletextview.Object.ParticleTextViewConfig;
import com.yasic.library.particletextview.View.ParticleTextView;

public class MainActivity extends AppCompatActivity {

    ParticleTextView particleTextView;
    Button btnStart,btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        particleTextView = findViewById(R.id.particleTextView);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);

        ParticleTextViewConfig config = new ParticleTextViewConfig.Builder()
                .setRowStep(7)
                .setColumnStep(7)
                .setTargetText("Fahmi")
                .setReleasing(0.2)
                .setParticleRadius(4)
                .setMiniDistance(0.1)
                .setTextSize(120)
                .setMovingStrategy(new RandomMovingStrategy())
//                .setMovingStrategy(new BidiVerticalStrategy())
//                .setMovingStrategy(new VerticalStrategy())
//                .setMovingStrategy(new BidiHorizontalStrategy())
//                .setMovingStrategy(new HorizontalStrategy())
//                .setMovingStrategy(new CornerStrategy())
                .instance();
        particleTextView.setConfig(config);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                particleTextView.startAnimation();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                particleTextView.stopAnimation();
            }
        });

    }
}