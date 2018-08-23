package com.xhe.qrcode;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        final EditText etStr = findViewById(R.id.et_str);
        Button btnBuild = findViewById(R.id.btn_build);
        final ImageView ivCode = findViewById(R.id.iv_code);

        btnBuild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = etStr.getText().toString();
                if (str.trim().length() == 0) {
                    Toast.makeText(context, "请输入字符串", Toast.LENGTH_SHORT).show();
                    return;
                }

                Bitmap bitmap = ORCodeUtil.createQRCodeImage(str, DensityUtils.dp2px(context, 100), DensityUtils.dp2px(context, 100));
                if (bitmap != null) {
                    ivCode.setImageBitmap(bitmap);
                }
            }
        });
    }

}
