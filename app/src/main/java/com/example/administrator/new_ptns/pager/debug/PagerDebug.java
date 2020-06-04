package com.example.administrator.new_ptns.pager.debug;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.administrator.new_ptns.G;
import com.example.administrator.new_ptns.MainActivity;
import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.pager.PagerBase;


public class PagerDebug extends PagerBase {

    Button enter;
    public PagerDebug(MainActivity context){
        super(context);
    }

    @Override
    public void init_view(View view,String type){
        super.init_view(view,type);
        enter = mView.findViewById(R.id.button35);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_enter();
            }
        });
        if(G.TEST){
            //enter.performClick();
        }
    }

    private void do_enter(){
        Intent intent = new Intent(mContext,DailyDebugActivity.class);
        mContext.startActivity(intent);
    }

    public void onResume(){

    }



}
