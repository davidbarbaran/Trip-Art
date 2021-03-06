package art.trip.com.tripart.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.List;

import art.trip.com.tripart.R;
import art.trip.com.tripart.model.Home;

/**
 * Created by David on 03/12/2017.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder> {
    private List<Home> list;
    private Activity activity;

    public HomeAdapter(List<Home> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @Override
    public HomeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home, parent, false));
    }

    @Override
    public void onBindViewHolder(HomeHolder holder, final int position) {
        holder.itemRecycler.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
        holder.itemRecycler.setAdapter(list.get(position).getAdapter());
        holder.titleText.setText(list.get(position).getTitle());
        holder.showMoreText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(activity, list.get(position).getActivity()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class HomeHolder extends RecyclerView.ViewHolder {

        public RecyclerView itemRecycler;
        public TextView titleText;
        TextView showMoreText;

        public HomeHolder(View itemView) {
            super(itemView);

            itemRecycler = itemView.findViewById(R.id.item_recycler);
            titleText = itemView.findViewById(R.id.title_text);
            showMoreText = itemView.findViewById(R.id.show_more_text);

        }
    }
}
