package com.example.mynewsfragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ContentMainTwo extends Fragment {
    private TextView tv_title_specific;
    private TextView tv_content_specific;
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_frag_two,container,false);
        view = v;
        return v;
    }

    public void refresh(String title,String content){
        /*View a = view.findViewById(R.id.ll_vv);
        a.setVisibility(View.VISIBLE);//这错了，不是view可见是view加载的子布局可见*/
        view.setVisibility(View.VISIBLE);
        tv_title_specific = view.findViewById(R.id.tv_title_specific);
        tv_content_specific = view.findViewById(R.id.tv_content_specific);

        tv_title_specific.setText(title);
        tv_content_specific.setText(content);
    }
}
