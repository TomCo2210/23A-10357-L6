package dev.tomco.a23a_10357_l6.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import dev.tomco.a23a_10357_l6.R;
import dev.tomco.a23a_10357_l6.interfaces.CallBack_userProtocol;

public class ListFragment extends Fragment {

    private MaterialTextView list_LBL_title;
    private MaterialButton list_BTN_user1;
    private CallBack_userProtocol callback;

    public void setCallback(CallBack_userProtocol callback) {
        this.callback = callback;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        findViews(view);
        list_BTN_user1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user1Clicked();
            }
        });
        return view;
    }

    private void user1Clicked() {
        if (callback != null)
            callback.user("Tom");
    }

    private void findViews(View view) {
        list_BTN_user1 = view.findViewById(R.id.list_BTN_user1);
        list_LBL_title = view.findViewById(R.id.list_LBL_title);
    }
}
