package gyw.com.editdialogdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tv)
    TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.tv) void showDialog() {
        EditDialog editDialog = new EditDialog(this);
        editDialog.show();
        editDialog.setOnPosNegClickListener(new EditDialog.OnPosNegClickListener() {
            @Override
            public void posClickListener(String value) {
                Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
                mTv.setText(value);
            }

            @Override
            public void negCliclListener(String value) {
                Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
                mTv.setText(value);
            }
        });
    }
}
