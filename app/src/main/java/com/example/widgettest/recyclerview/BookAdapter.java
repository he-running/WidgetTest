package com.example.widgettest.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.widgettest.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hesh on 2018/4/17.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Book> bookList = new ArrayList<>();

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_lv_item, parent,false);

        BookViewHolder viewHolder = new BookViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, final int position) {
        if (bookList != null && bookList.size() > position) {
            Book book = bookList.get(position);
            if (book != null) {
                holder.tvName.setText(book.getName());
                holder.ivBook.setImageResource(book.getImg());

                if (mOnItemClickListener != null) {
                    holder.llItem.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mOnItemClickListener.onClick(v, position);
                        }
                    });

                    holder.llItem.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            mOnItemClickListener.onLongClick(v, position);
                            return true;
                        }
                    });
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public void updateList(List<Book> bookList) {
        this.bookList = bookList;
        notifyDataSetChanged();
    }

    @OnClick(R.id.ll_item)
    public void onViewClicked() {
    }


    class BookViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_book)
        ImageView ivBook;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.ll_item)
        LinearLayout llItem;

        public BookViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }

    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onClick(View v, int position);

        void onLongClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

}
