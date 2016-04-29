package myapp.com.newgaojipro2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import fragment.ContentFragment;
import fragment.MenuFragment;

public class MainActivity extends AppCompatActivity implements MenuFragment.ItemClickCallback, ContentFragment.TextClickCallback{

    ContentFragment contentFrag;
    Fragment menuFrag;
    private SlidingPaneLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initFragment();

        //??设置ViewLeft的衰变颜色。可以理解为从open状态到close状态时候渐变的颜色，从自身的颜色渐变到衰变颜色
        layout.setCoveredFadeColor(Color.RED);
        //设置滑动比例
        layout.setParallaxDistance(10);
        //设置左侧阴影图片

        layout.setShadowResourceLeft(R.mipmap.ic_launcher);
        //??
        layout.setShadowResourceRight(R.mipmap.pic0);
        //??设置ViewContent的衰变颜色。可以理解为从close状态到open状态时候渐变的颜色，从自身的颜色渐变到衰变颜色
        layout.setSliderFadeColor(Color.BLUE);
        layout.setPanelSlideListener(new SlidingPaneLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                Log.i("","=======  onpanelslide  "+slideOffset);
            }

            @Override
            public void onPanelOpened(View panel) {
                Log.i("","=====  on opened");
            }

            @Override
            public void onPanelClosed(View panel) {
                Log.i("","=====  on closed");
            }
        });

    }

    private void initView() {
        layout = (SlidingPaneLayout)findViewById(R.id.slidingpanelayout);
    }

    private void initFragment() {
        contentFrag = new ContentFragment();
        menuFrag = new MenuFragment();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.sliding_menu,menuFrag);
        ft.add(R.id.sliding_content,contentFrag);

        ft.commit();
    }

    @Override
    public void itemClick(String s) {
        contentFrag.changeText(s);
    }

    @Override
    public void textClick() {
        if (layout.isOpen()) {
            layout.closePane();
        } else {
            layout.openPane();
        }
    }
}
