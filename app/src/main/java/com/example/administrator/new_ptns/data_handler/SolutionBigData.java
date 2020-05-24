package com.example.administrator.new_ptns.data_handler;

import com.example.administrator.new_ptns.custom_item.CustomItemA7;

public class SolutionBigData {
    public SolutionData solutionData1;
    public SolutionData solutionData2;
    public boolean realtime=false;
    public boolean complex = false;
    public String channel1 = "OFF";
    public String channel2 = "OFF";
    public String channel3 = "OFF";
    public String channel4 = "OFF";
    public String channel5 = "OFF";
    public String vc_mode = "current";
    public SolutionBigData(){
        solutionData1 = new SolutionData("08:00","12:00","0","0","0","5s",vc_mode);
        solutionData2 = new SolutionData("08:00","12:00","0","0","0","5s",vc_mode);
    }

    public void set_vcmode(String vc){
        vc_mode = vc;
        solutionData1.set_vcmode(vc);
        solutionData2.set_vcmode(vc);
    }

    public SolutionBigData(SolutionBigData solutionBigData){
        solutionData1 = new SolutionData(solutionBigData.solutionData1);
        solutionData2 = new SolutionData(solutionBigData.solutionData2);
        realtime = solutionBigData.realtime;
        complex = solutionBigData.complex;
        channel1 = solutionBigData.channel1;
        channel2 = solutionBigData.channel2;
        channel3 = solutionBigData.channel3;
        channel4 = solutionBigData.channel4;
        channel5 = solutionBigData.channel5;
        vc_mode = solutionBigData.vc_mode;
    }

}