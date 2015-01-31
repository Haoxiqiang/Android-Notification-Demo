package info.haoxiqiang.androidnotification;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private ListRecyclerAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private static final String[] ITEMS = {"Simple Notification","WithBehaviour","WithParentBehaviour","NewTask","BigViews","BigPictureStyle","InboxStyle","Determinate Progress","InDeterminate Progress"};
    private final ArrayList<String> dataSet = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mLayoutManager.setStackFromEnd(false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        dataSet.addAll(Arrays.asList(ITEMS));

        mAdapter = new ListRecyclerAdapter(dataSet);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemViewHolderClickLisenter(new ListRecyclerAdapter.OnItemViewHolderClickLisenter() {
            @Override
            public void onClick(View v, int position) {
                Log.i("MainActivity", "position is " + position);
                switch (position){
                    case 0:
                        SimpleNotification.showNotification(v.getContext(),position);
                        break;
                    case 1:
                        SimpleNotification.showNotificationWithBehaviour(v.getContext(),position);
                        break;
                    case 2:
                        SimpleNotification.showNotificationWithParentBehaviour(v.getContext(),position);
                        break;
                    case 3:
                        SimpleNotification.showNotificationWithNewTask(v.getContext(),position);
                        break;
                    case 4:
                        SimpleNotification.showNotificationWithBigViews(v.getContext(),position);
                        break;
                    case 5:
                        SimpleNotification.showNotificationWithBigPictureStyle(v.getContext(),position);
                        break;
                    case 6:
                        SimpleNotification.showNotificationWithInboxStyle(v.getContext(),position);
                        break;
                    case 7:
                        SimpleNotification.showNotificationWithDeterminate(v.getContext(),position);
                        break;
                    case 8:
                        SimpleNotification.showNotificationWithIndeterminate(v.getContext(),position);
                        break;
                }
            }
        });
    }

}
