package dstudio.com.retrofitrxandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dstudio.com.retrofitrxandroid.callback.PostItemListener;
import dstudio.com.retrofitrxandroid.model.userdataresponse.UserData;

/**
 * Created by janwelcris on 6/8/2017.
 */

public class AnswersAdapter extends RecyclerView.Adapter<AnswersAdapter.ViewHolder> {

    private List<UserData> mItems;
    private Context mContext;
    private PostItemListener mItemListener;


    public AnswersAdapter(Context context, List<UserData> posts, PostItemListener itemListener) {
        mItems = posts;
        mContext = context;
        mItemListener = itemListener;
    }

    @Override
    public AnswersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);

        ViewHolder viewHolder = new ViewHolder(postView, this.mItemListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AnswersAdapter.ViewHolder holder, int position) {
        UserData userData = mItems.get(position);
        TextView textView = holder.titleTv;
        textView.setText(userData.getData().getAttributes().getFirstName());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void updateAnswers(List<UserData> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    private UserData getItem(int adapterPosition) {
        return mItems.get(adapterPosition);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(android.R.id.text1)
        TextView titleTv;

        PostItemListener mItemListener;

        public ViewHolder(View itemView, PostItemListener postItemListener) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            this.mItemListener = postItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            UserData userData = getItem(getAdapterPosition());
            this.mItemListener.onPostClick(userData.getData().getId());
            notifyDataSetChanged();
        }
    }
}
