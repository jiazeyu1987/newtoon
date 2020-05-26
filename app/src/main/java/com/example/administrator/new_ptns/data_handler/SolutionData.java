package com.example.administrator.new_ptns.data_handler;

public class SolutionData {
    public String start_time="08:00";
    public String end_time="08:00";
    public String range="0";
    public String freq="0";
    public String pulse="0";
    public String test_time="5s";

    public SolutionData(String start_time1,String end_time1,String range1,String freq1,String pulse1,String test_time1){
        start_time = start_time1;
        end_time = end_time1;
        range = range1;
        freq = freq1;
        pulse = pulse1;
        test_time = test_time1;
    }


    public SolutionData(SolutionData data){
        start_time = data.start_time;
        end_time = data.end_time;
        range = data.range;
        freq = data.freq;
        pulse = data.pulse;
        test_time = data.test_time;
    }


}
