package fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by samsung on 2016/4/29.
 */
public class MenuFragment extends ListFragment{

    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter ;

    public interface ItemClickCallback{
        void itemClick(String s);
    }

    ItemClickCallback callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.callback = (ItemClickCallback) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        for (int i=0;i<5;i++){
            list.add("item "+i);
        }
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item,list);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
       callback.itemClick(list.get(position));
    }
}
