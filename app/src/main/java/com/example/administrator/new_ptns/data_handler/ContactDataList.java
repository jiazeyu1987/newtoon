package com.example.administrator.new_ptns.data_handler;

import com.blankj.utilcode.util.ToastUtils;

import java.util.ArrayList;

public class ContactDataList{
    public ArrayList<ContactData> list1;

    public String[] getContactNumberList(){
        ArrayList<String> mlist = new ArrayList<>();
        for(int i = 0 ; i < list1.size();i++){
            mlist.add(list1.get(i).contact_number);
        }
        return (String[]) mlist.toArray(new String[mlist.size()]);
    }
}
