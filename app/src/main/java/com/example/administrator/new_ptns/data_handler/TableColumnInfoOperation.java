package com.example.administrator.new_ptns.data_handler;

import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;

@SmartTable(name = "图标1")
public class TableColumnInfoOperation {
    public TableColumnInfoOperation(String save_time1, String electrode_position1, String channel_position1, String impedance1, String para1) {
        this.save_time = save_time1;
        this.electrode_position = electrode_position1;
        this.channel_position = channel_position1;
        this.impedance = impedance1;
        this.para = para1;
    }

    //    name：版块名称，count：目标值，restaurant：餐饮数量，ka：KA数量，wholesale：流通批发数量，industry：工业加工数量，other：其它数量
    @SmartColumn(id = 0, name = "保存时间", autoMerge = true,width = 80)
    private String save_time;
    @SmartColumn(id = 1, name = "电极位置",width = 80)
    private String electrode_position;
    @SmartColumn(id = 2, name = "通道位置",width = 80)
    private String channel_position;
    @SmartColumn(id = 3, name = "阻抗",width = 80)
    private String impedance;
    @SmartColumn(id = 4, name = "刺激参数",width = 80)
    private String para;
}