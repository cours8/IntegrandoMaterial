package example.tarea.integrando;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    public static String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t1 = findViewById(R.id.textView);
        t1.setText(loremIpsum);
        FloatingActionButton fab = findViewById(R.id.default_activity_button);
        fab.setOnClickListener(this::onFAB);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                onTabPositionUpdated(tab.getPosition(),true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                onTabPositionUpdated(tab.getPosition(),false);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                onTabPositionUpdated(tab.getPosition(),true);
            }
        });
    }

    protected void selectTab(int pos) {
        TabLayout tabs = findViewById(R.id.tabs);
        if(null==tabs) return;
        TabLayout.Tab tab = tabs.getTabAt(pos);
        if(null==tab) return;
        tabs.selectTab(tab,true);
    }
    public void onFAB(View v) {
        selectTab(1);
        TextView t1 = findViewById(R.id.textView);
        String texto = t1.getText().toString();
        texto += "\n" + loremIpsum;
        t1.setText(texto);
    }

    public void onTabPositionUpdated(int position, boolean selected) {
        View v = null;
        switch(position)
        {
            case 0: v = findViewById(R.id.imageView); break;
            case 1: v = findViewById(R.id.textView); break;
        }
        if(null == v) return;
        v.setVisibility(selected ? View.VISIBLE : View.GONE);
    }

}