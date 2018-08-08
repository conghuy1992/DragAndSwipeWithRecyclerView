package com.conghuy.DragAndSwipeWithRecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements ItemTouchHelperAdapter {
    private String TAG = "MyAdapter";
    private List<MenuDto> menuDtoList;
    private Context context;

    public MyAdapter(Context context, List<MenuDto> groupDtoList) {
        this.context = context;
        this.menuDtoList = groupDtoList;
    }

    public List<MenuDto> getList() {
        return menuDtoList;
    }


    public void updateList(List<MenuDto> menuDtoList) {
        if (menuDtoList == null) return;
        this.menuDtoList = menuDtoList;
        this.notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private FrameLayout item;
        public MyViewHolder(View view) {
            super(view);
            tvName = (TextView) view.findViewById(R.id.tvMsg);
            item = (FrameLayout) view.findViewById(R.id.item);
        }

        public void handler(final MenuDto dto, final int position) {
            if (dto == null) return;
            tvName.setText(dto.msg);
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_main, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final MenuDto dto = menuDtoList.get(position);
        holder.handler(dto, position);
    }

    @Override
    public int getItemCount() {
        return menuDtoList.size();
    }
    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(menuDtoList, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(menuDtoList, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {

    }
}
