package dev.tomco.a23a_10357_l6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import dev.tomco.a23a_10357_l6.interfaces.CallBack_userProtocol;
import dev.tomco.a23a_10357_l6.views.ListFragment;
import dev.tomco.a23a_10357_l6.views.MapFragment;

public class MainActivity extends AppCompatActivity {

    private ListFragment listFragment;
    private MapFragment mapFragment;

    CallBack_userProtocol callBack_userProtocol = new CallBack_userProtocol() {
        @Override
        public void user(String name) {
            showUserLocation(name);
        }
    };

    private void showUserLocation(String name) {
        double latitude = 32.4999;
        double longitude = 34.5599;
        mapFragment.zoom(latitude, longitude);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listFragment = new ListFragment();
        listFragment.setCallback(callBack_userProtocol);


        mapFragment = new MapFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.main_FRAME_list, listFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_FRAME_map, mapFragment).commit();
    }
}