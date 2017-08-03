package dstudio.com.retrofitrxandroid.activity;

import android.os.Bundle;

import dstudio.com.retrofitrxandroid.fragment.ColorFragment;
import dstudio.com.retrofitrxandroid.R;
import dstudio.com.retrofitrxandroid.util.ApiUtils;
import eu.inloop.viewmodel.base.ViewModelBaseEmptyActivity;

/**
 * Created by janwelcris on 7/12/2017.
 */

public class MainActivity  extends ViewModelBaseEmptyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.root_content, new ColorFragment(), ApiUtils.FRAGMENT_COLORS)
                    .commit();
        }
    }

}