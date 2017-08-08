package dstudio.com.retrofitrxandroid.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dstudio.com.retrofitrxandroid.R;
import dstudio.com.retrofitrxandroid.callback.PostItemListener;
import dstudio.com.retrofitrxandroid.model.colorresponse.Color_;

/**
 * Created by janwelcris on 6/8/2017.
 */

public class ColorsAdapter extends ArrayAdapter<Color_> {

    public ColorsAdapter(List<Color_> data, Context context) {
        super(context, R.layout.row_item, data);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        ViewHolder holder;
        Color_ color_ = getItem(position);
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = LayoutInflater.from(getContext()).inflate(R.layout.row_item, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        holder.data.setText(color_.getColor());


        return view;

    }

    static class ViewHolder {
        @BindView(R.id.textView)
        TextView data;


        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
