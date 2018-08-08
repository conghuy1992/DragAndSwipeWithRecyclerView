package com.conghuy.DragAndSwipeWithRecyclerView;

public interface ItemTouchHelperAdapter {
    void onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
}
