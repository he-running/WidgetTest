package com.example.widgettest.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.widgettest.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RecyclerViewActivity extends AppCompatActivity {


    List<Book> bookList = new ArrayList<>();
    BookAdapter bookAdapter;

    @BindView(R.id.rv_book)
    RecyclerView rv_book;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        unbinder=ButterKnife.bind(this);

        bookAdapter = new BookAdapter();
        LinearLayoutManager llManager = new LinearLayoutManager(this);
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rv_book.addItemDecoration(divider);
        rv_book.setLayoutManager(llManager);

        //瀑布流
//        StaggeredGridLayoutManager stagger=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
//        rv_book.setLayoutManager(stagger);

        bookAdapter.setOnItemClickListener(new BookAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                Toast.makeText(getApplicationContext(), "short: "+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getApplicationContext(), "long: "+position, Toast.LENGTH_SHORT).show();
            }
        });
        rv_book.setAdapter(bookAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        bookList.clear();
        for (int i = 0; i < 20; i++) {
            Book book = new Book();
            if (i % 2 != 0) {
                book.setImg(R.mipmap.ic_odd);
                book.setName("宇宙世界");
            } else {
                book.setImg(R.mipmap.ic_even);
                book.setName("海底世界");
            }
            bookList.add(book);
        }
        bookAdapter.updateList(bookList);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
