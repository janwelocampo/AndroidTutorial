package dstudio.com.retrofitrxandroid.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import dstudio.com.retrofitrxandroid.R;
import dstudio.com.retrofitrxandroid.adapter.AnswersAdapter;
import dstudio.com.retrofitrxandroid.apiconnection.connectivity.NoNetworkException;
import dstudio.com.retrofitrxandroid.callback.PostItemListener;
import dstudio.com.retrofitrxandroid.model.userdataresponse.UserData;
import dstudio.com.retrofitrxandroid.apiconnection.RetrofitClient;
import dstudio.com.retrofitrxandroid.util.ApiUtils;
import dstudio.com.retrofitrxandroid.util.SharedPrefUtils;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by janwelcris on 7/12/2017.
 */

public class MainActivity extends BaseActivity implements PostItemListener, ApiUtils.SharedPrefKey{
    private AnswersAdapter mAdapter;
    private List<UserData> list;
    private String TAG = "MAIN ACTIVITY";

    @BindView(R.id.rv_answers)
    RecyclerView mRecyclerView;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onActivityCreated(Bundle savedInstanceState) {
        list = new ArrayList<>();
        mAdapter = new AnswersAdapter(this,list, this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);

        loadData();
    }

    private void loadData(){
        RetrofitClient.getSOService(this)
                .doGetUserData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UserData>() {
                    @Override
                    public void onCompleted(){
                            Log.i(TAG, "COMPLETE");
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof NoNetworkException) {
                            // handle 'no network'
                            String userDataResponseLocal = SharedPrefUtils.getString(USER_DATA);
                            if (userDataResponseLocal != null){
                                UserData userData = mGson.fromJson(userDataResponseLocal, UserData.class);
                                populateData(userData);
                                return;
                            }

                        }
                        Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT)
                                    .show();

                    }

                    @Override
                    public void onNext(UserData userData) {
                        SharedPrefUtils.setString(USER_DATA,  mGson.toJson(userData));
                        populateData(userData);
                    }
                });
    }

    private void populateData(UserData userData){
        list.add(userData);
        mAdapter.updateAnswers(list);
    }

    @Override
    public void onPostClick(String id) {
        Toast.makeText(this,"Id is : " + id, Toast.LENGTH_LONG).show();
    }
}
