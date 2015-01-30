package info.haoxiqiang.androidnotification;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

/**
 * Created by haoxiqiang on 15/1/30.
 */
public class ListRecyclerAdapter extends RecyclerView.Adapter<ListRecyclerAdapter.ViewHolder> {

    public interface OnItemViewHolderClickLisenter {
        public void onClick(View v, int position);
    }


    private final List<String> mDataSet;
    private OnItemViewHolderClickLisenter mLisenter;

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public ViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }

    public void setOnItemViewHolderClickLisenter(OnItemViewHolderClickLisenter lisenter){
        this.mLisenter = lisenter;
    }
    public ListRecyclerAdapter(List<String> _myDataSet) {
        mDataSet = _myDataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView v =
                (TextView) LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.vlist_item_recycler, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTextView.setText(mDataSet.get(position));
        holder.mTextView.setBackgroundColor(Color.argb(255, new Random().nextInt(255),
                new Random().nextInt(255), new Random().nextInt(255)));
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("onBindViewHolder", "holder.mTextView was clicked");
                if(mLisenter!=null) {
                    mLisenter.onClick(v, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
