package com.example.mynewsfragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TitleMainOne extends Fragment {

    //private
    private NewsAdapter adapter ;
    private boolean isTwoPage ;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.news_content_fragment) != null){
            isTwoPage = true;
        }else{
            isTwoPage = false;
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.title_frag_one,container,false);
        RecyclerView rv_onepage_main_news_title = v.findViewById(R.id.rv_onepage_main_news_title);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        List<News> list = new ArrayList<>();
        Myadd(list);
        adapter = new NewsAdapter(list);


        rv_onepage_main_news_title.setLayoutManager(manager);
        rv_onepage_main_news_title.setAdapter(adapter);
        return v;
    }


    public List<News> Myadd(List<News> l){
        for (int i = 0; i < 50; i++) {
            News n = new News();
            n.setTitle("title" + i);
            n.setContent("content" + i);
            l.add(n);
            //Log.d("haha", "Myadd: "+ list.get(i));
        }
        return l;
    }



    class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<News> mlist ;
        public NewsAdapter(List<News> li) {
            mlist = li;
        }

        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
            MyViewHolder vh = new MyViewHolder(v);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    News news = mlist.get(vh.getAdapterPosition());
                    if(isTwoPage){//panduan one two page
                        ContentMainTwo c = (ContentMainTwo) getFragmentManager().findFragmentById(R.id.news_content_fragment);
                        c.refresh(news.getTitle(),news.getContent());
                    }else{
                        NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent());
                    }
                }
            });
            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            MyViewHolder vh = (MyViewHolder) holder;
            News n = mlist.get(position);
            vh.t.setText(n.getTitle());
        }

        @Override
        public int getItemCount() {
            return mlist.size();
        }
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView t ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t = itemView.findViewById(R.id.tv_item);
        }
    }
}
