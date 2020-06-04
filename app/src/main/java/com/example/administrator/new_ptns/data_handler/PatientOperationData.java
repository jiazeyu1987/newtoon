package com.example.administrator.new_ptns.data_handler;

import java.util.ArrayList;

public class PatientOperationData {
    public String contact_number;

    public ArrayList<String> operation_picture_path = new ArrayList<>();
    public ArrayList<String> operation_camera_path = new ArrayList<>();

    public  ElectrodeBundle electrodeBundle1=new ElectrodeBundle();
    public  ElectrodeBundle electrodeBundle2=new ElectrodeBundle();
    public  ElectrodeBundle position1 = null;
    public  ElectrodeBundle position2 = null;

    public String stim_number;
    public String stim_embedded_date;
    public String charging_percent;
}
