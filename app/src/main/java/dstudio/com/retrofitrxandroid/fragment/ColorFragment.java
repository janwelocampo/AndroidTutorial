package dstudio.com.retrofitrxandroid.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dstudio.com.retrofitrxandroid.R;
import dstudio.com.retrofitrxandroid.adapter.ColorsAdapter;
import dstudio.com.retrofitrxandroid.callback.PostItemListener;
import dstudio.com.retrofitrxandroid.model.colorresponse.Color_;
import dstudio.com.retrofitrxandroid.model.colorresponse.Colors;
import dstudio.com.retrofitrxandroid.viewmodel.ColorsViewModel;
import dstudio.com.retrofitrxandroid.viewmodel.view.IUColorView;
import eu.inloop.viewmodel.base.ViewModelBaseFragment;

/**
 * Created by janwelcris on 8/3/2017.
 */

public class ColorFragment extends ViewModelBaseFragment<IUColorView, ColorsViewModel> implements IUColorView, PostItemListener {

    private ColorsAdapter mAdapter;

    private List<Color_> colorList;

    @BindView(R.id.rv_colors)
    RecyclerView recyclerView;

    @BindView(R.id.progress)
    LinearLayout linearProgress;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_color, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        colorList = new ArrayList<>();
        setModelView(this);
    }

    @Override
    public void getColorsData(Colors colors) {
        colorList = colors.getColors();
        mAdapter = new ColorsAdapter(getActivity(), colorList, this);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showloading(float progress) {
        linearProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        linearProgress.setVisibility(View.GONE);
    }

    @Override
    public void onPostClick(int id) {
        Toast.makeText(getActivity(), ""+ getViewModel().getHexaCode(id), Toast.LENGTH_SHORT).show();
    }
}
