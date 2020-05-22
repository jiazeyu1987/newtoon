package com.example.administrator.new_ptns.data_handler;

public class DailyStimBundle {
    public static final int morning_left = 0;
    public static final int morning_right = 1;
    public static final int night_left = 2;
    public static final int night_right = 3;

    public static final int normal_left = 0;
    public static final int normal_right = 1;

    public static final int StateComplex = 1;
    public static final int StateSimple = 0;

    public String[] rangeArray;
    public String[] freqArray;
    public String[] pulseArray;
    public int state = StateSimple;
    public String soft_boot = "";
    public String soft_stop = "";

    public String range_range_left = "";
    public String range_freq_left = "";
    public String range_pulse_left = "";
    public String range_time_left = "";
    public String range_range_right = "";
    public String range_freq_right = "";
    public String range_pulse_right = "";
    public String range_time_right = "";

    public String run_state="";
    public String battery="";
    public String inner_clock="";


    public static  DailyStimBundle getNormalTestData(){
        DailyStimBundle bundle = new DailyStimBundle();
        bundle.state = DailyStimBundle.StateSimple;
        bundle.rangeArray = new String[]{"1.5mA","0.5mA"};
        bundle.freqArray  = new String[]{"130Hz","130Hz"};
        bundle.pulseArray = new String[]{"60uS","90uS"};

        bundle.soft_boot = "15s";
        bundle.soft_stop = "禁止";

        bundle.range_range_left = "加减0.5mA";
        bundle.range_freq_left = "禁止";
        bundle.range_time_left = "允许";
        bundle.range_pulse_left = "允许";
        bundle.range_range_right = "加减1.5mA";
        bundle.range_freq_right = "允许";
        bundle.range_time_right = "禁止";
        bundle.range_pulse_right = "禁止";

        bundle.run_state = "正常";
        bundle.battery = "91%";
        bundle.inner_clock = "12:00:00";

        return bundle;
    }


    public static  DailyStimBundle getComplexTestData(){
        DailyStimBundle bundle = new DailyStimBundle();
        bundle.state = DailyStimBundle.StateComplex;
        bundle.rangeArray = new String[]{"1.5mA","0.5mA","2.5mA","3.5mA"};
        bundle.freqArray  = new String[]{"130Hz","230Hz","330Hz","430Hz"};
        bundle.pulseArray = new String[]{"60uS","90uS","190uS","290uS"};

        bundle.soft_boot = "25s";
        bundle.soft_stop = "禁止";

        bundle.range_range_left = "加减0.5mA";
        bundle.range_freq_left = "禁止";
        bundle.range_time_left = "允许";
        bundle.range_pulse_left = "允许";
        bundle.range_range_right = "加减1.5mA";
        bundle.range_freq_right = "允许";
        bundle.range_time_right = "禁止";
        bundle.range_pulse_right = "禁止";

        bundle.run_state = "正常";
        bundle.battery = "10%";
        bundle.inner_clock = "12:10:00";

        return bundle;
    }
}
