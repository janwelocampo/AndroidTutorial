package dstudio.com.retrofitrxandroid.viewmodel;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.Gson;

import dstudio.com.retrofitrxandroid.model.colorresponse.Colors;
import dstudio.com.retrofitrxandroid.util.ApiUtils;
import dstudio.com.retrofitrxandroid.viewmodel.view.IUColorView;
import eu.inloop.viewmodel.AbstractViewModel;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by janwelcris on 8/3/2017.
 */


public class ColorsViewModel extends AbstractViewModel<IUColorView> {
    public static final String TAG = "AbstractViewModel";

    private Colors mColors;

    //Don't persist state variables
    private boolean mLoadingUsers;

    private float mCurrentLoadingProgress = 0;
    private Gson mGson;

    @Override
    public void onCreate(@Nullable Bundle arguments, @Nullable Bundle savedInstanceState) {
        super.onCreate(arguments, savedInstanceState);

        mGson = new Gson();

        //this will be only not null in case the application was killed due to low memory
        if (savedInstanceState != null) {
            String colorStr = savedInstanceState.getString(ApiUtils.SAVE_INSTANCE_COLORS);
            mColors = mGson.fromJson(colorStr, Colors.class);
        }
    }
    @Override
    public void onSaveInstanceState(@NonNull final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (mColors != null) {
            bundle.putString(ApiUtils.SAVE_INSTANCE_COLORS, mGson.toJson(mColors));
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //use this to cancel any planned requests
    }

    @Override
    public void onBindView(@NonNull IUColorView view) {
        super.onBindView(view);

        //downloading list of users
        if (mColors != null) {
            view.getColorsData(mColors);
        } else if (mLoadingUsers) {
            view.showloading(mCurrentLoadingProgress);
        } else {
            loadData(view);
        }
    }

    private void loadData(final IUColorView view){
        view.showloading(0);

        ApiUtils.getSOService().doGetColors().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Colors>() {

                    @Override
                    public void onCompleted() {
                        view.hideProgress();
                        Log.i(TAG, "COMPLETE");
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.hideProgress();
                        Log.i(TAG, e.getLocalizedMessage());
                    }

                    @Override
                    public void onNext(Colors colors) {
                        view.getColorsData(colors);
                    }
                });
    }

    public String getHexaCode(int id){
        return mColors.getColors().get(id).getCode().getHex();

    }
}
