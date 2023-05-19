import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView iImageView;
    private ImageView lImageView;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iImageView = findViewById(R.id.iImageView);
        lImageView = findViewById(R.id.lImageView);

        iImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iImageView.setVisibility(View.INVISIBLE);
                lImageView.setVisibility(View.VISIBLE);
                handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        lImageView.setVisibility(View.INVISIBLE);
                        iImageView.setVisibility(View.VISIBLE);
                    }
                };
                handler.postDelayed(runnable, 2000);
            }
        });

        rahulImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lImageView.setVisibility(View.INVISIBLE);
                iImageView.setVisibility(View.VISIBLE);
                handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        iImageView.setVisibility(View.INVISIBLE);
                        lImageView.setVisibility(View.VISIBLE);
                    }
                };
                handler.postDelayed(runnable, 2000);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }
    }
}