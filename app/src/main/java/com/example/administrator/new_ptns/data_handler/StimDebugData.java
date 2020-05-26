package com.example.administrator.new_ptns.data_handler;

import com.example.administrator.new_ptns.G;

public class StimDebugData extends AABaseData{
    public int id;
    public int patient_id = G.doctor_id;
    public String vc_mode = "";
    public String soft_boot = "";
    public String soft_stop = "";
    public SolutionBigData left_data = null;
    public SolutionBigData right_data = null;
    public String range_range = "";
    public String range_freq = "";
    public String range_pulse = "";
    public String range_lasttime = "";
}
