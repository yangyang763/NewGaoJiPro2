package fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by samsung on 2016/4/29.
 */
public class ContentFragment extends Fragment{

    private TextView tv;

    public interface TextClickCallback{
        void textClick();
    }

    TextClickCallback callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (TextClickCallback) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return new TextView(getActivity());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        tv = (TextView) view;
        tv.setTextSize(40);

        tv.setTextColor(Color.DKGRAY);
//        tv.setBackgroundColor(Color.MAGENTA);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.textClick();
            }
        });
    }

    public void changeText(String s) {
        tv.setText(s);
    }
}
