package com.example.administrator.new_ptns.data_handler;

import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;
import com.example.administrator.new_ptns.my_utils.TimeUtils;

@SmartTable(name = "")
public class TableColumnInfoStimReport implements Comparable {
    public TableColumnInfoStimReport(String save_time1, String mode1, String range1, String freq1, String pulse1, String solution1) {
        this.save_time = save_time1;
        this.range = range1;
        this.freq = freq1;
        this.pulse = pulse1;
        this.solution = solution1;
        this.mode = mode1;
    }

    //    name：版块名称，count：目标值，restaurant：餐饮数量，ka：KA数量，wholesale：流通批发数量，industry：工业加工数量，other：其它数量
    @SmartColumn(id = 0, name = "变更时间", autoMerge = true,width = 60)
    private String save_time;
    @SmartColumn(id = 1, name = "模式",width = 20)
    private String mode;
    @SmartColumn(id = 2, name = "幅度",width = 20)
    private String range;
    @SmartColumn(id = 3, name = "频率",width = 20)
    private String freq;
    @SmartColumn(id = 4, name = "脉宽",width = 20)
    private String pulse;
    @SmartColumn(id = 5, name = "方案",width = 60)
    private String solution;

    public String getDate(){
        return save_time;
    }

    @Override
    public int compareTo(Object o) {
        TableColumnInfoStimReport report = (TableColumnInfoStimReport) o;
        try {
            // TODO Auto-generated method stub
            long da1 = TimeUtils.dateToStampShort(this.getDate());
            long da2 = TimeUtils.dateToStampShort(report.getDate());
            if (da1 < da2)
                return 1;
                //注意！！返回值必须是一对相反数，否则无效。jdk1.7以后就是这样。
                //		else return 0; //无效
            else return -1;
        }
        catch (Exception e){
            return 1;
        }
    }
}