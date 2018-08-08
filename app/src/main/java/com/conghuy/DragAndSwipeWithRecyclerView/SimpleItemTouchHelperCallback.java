package com.conghuy.DragAndSwipeWithRecyclerView;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class SimpleItemTouchHelperCallback extends ItemTouchHelper.Callback {

    private final RecyclerView.Adapter mAdapter;

    public SimpleItemTouchHelperCallback(RecyclerView.Adapter adapter) {
        mAdapter = adapter;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                          RecyclerView.ViewHolder target) {
       if(mAdapter instanceof MyAdapter){
           ((MyAdapter)mAdapter).onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
       }
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        if(mAdapter instanceof MyAdapter){
//            ((MyAdapter)mAdapter).onItemDismiss(viewHolder.getAdapterPosition());
        }
    }


}