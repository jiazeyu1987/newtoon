package com.example.administrator.new_ptns.data_handler;

public class ElectrodeBundle {
    public int id=1;
    public String left_or_right="";
    public String guige;
    public String xuliehao;
    public String embeddedPosition=null;
    public ElectrodeBundle(int id1,String lor1,String g1,String x1){
        id = id1;
        left_or_right = lor1;
        guige = g1;
        xuliehao = x1;
    }

    public ElectrodeBundle(){}

    public String get_position(){
        if(left_or_right=="left" || left_or_right.equals("L")){
            String s1 = "L";
            if(embeddedPosition==null){
                return s1+"empty";
            }else{
                return s1+embeddedPosition;
            }
        }
        if(left_or_right=="right" || left_or_right.equals("R")){
            String s1 = "R";
            if(embeddedPosition==null){
                return s1+"empty";
            }else{
                return s1+embeddedPosition;
            }
        }
        return "|"+left_or_right+"|";
    }
}
