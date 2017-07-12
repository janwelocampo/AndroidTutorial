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
import dstudio.com.retrofitrxandroid.callback.PostItemListener;
import dstudio.com.retrofitrxandroid.model.userdataresponse.UserData;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by janwelcris on 7/12/2017.
 */

public class MainActivity extends BaseActivity implements PostItemListener{
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
        mService.doGetUserData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UserData>() {
                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "COMPLETE");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, e.getLocalizedMessage());
                        Toast.makeText(MainActivity.this,"Error : " + e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNext(UserData userData) {
                        list.add(userData);
                        mAdapter.updateAnswers(list);
                    }
                });
    }

    @Override
    public void onPostClick(String id) {
        Toast.makeText(this,"Id is : " + id, Toast.LENGTH_LONG).show();
    }
}
