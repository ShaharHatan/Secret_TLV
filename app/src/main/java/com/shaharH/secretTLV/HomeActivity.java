package com.shaharH.secretTLV;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.google.android.material.button.MaterialButton;

public class HomeActivity extends AppCompatActivity {
    private FrameLayout frame1;
    private MaterialButton BTN_Sort;
    private MaterialButton BTN_Filter;
    private MaterialButton BTN_Map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViews();
    }

    private void findViews() {
        frame1 = findViewById(R.id.frame1);
        BTN_Sort = findViewById(R.id.BTN_Sort);
        BTN_Filter = findViewById(R.id.BTN_Filter);
        BTN_Map = findViewById(R.id.BTN_Map);
    }
}