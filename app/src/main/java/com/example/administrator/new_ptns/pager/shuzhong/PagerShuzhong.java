package com.example.administrator.new_ptns.pager.shuzhong;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.new_ptns.MainActivity;
import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.pager.PagerBase;


public class PagerShuzhong extends PagerBase {

    TextView enter1,enter2;
    public PagerShuzhong(MainActivity context){
        super(context);
    }

    @Override
    public void init_view(View view,String type){
        super.init_view(view,type);
        enter1 = mView.findViewById(R.id.textView84);
        enter2 = mView.findViewById(R.id.textView85);
        enter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_enter1();
            }
        });

        enter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_enter2();
            }
        });
    }

    private void do_enter1(){
        Intent intent = new Intent(mContext,OperationActivity.class);
        mContext.startActivity(intent);
    }
    private void do_enter2(){
        Intent intent = new Intent(mContext,OperationActivity.class);
        mContext.startActivity(intent);
    }

    public void onResume(){

    }



}
