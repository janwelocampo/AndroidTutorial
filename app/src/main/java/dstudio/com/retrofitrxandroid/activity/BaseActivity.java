package dstudio.com.retrofitrxandroid.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import dstudio.com.retrofitrxandroid.apiurl.APIInterface;
import dstudio.com.retrofitrxandroid.util.ApiUtils;

/**
 * Created by janwelcris on 6/8/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected APIInterface mService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());

        ButterKnife.bind(this);

        mService = ApiUtils.getSOService();

        onActivityCreated(savedInstanceState);

    }

    protected abstract int getLayoutResourceId();

    protected abstract void onActivityCreated(Bundle savedInstanceState);
}
