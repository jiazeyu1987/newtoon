package com.example.administrator.dbs1.pager.timing;

import java.util.Calendar;
import java.util.Date;

public class PagerTimingItem {
    public int id;
    public String time_tar;
    public String time_cal;
    public String time_day;
    public boolean open;
    public Boolean b1=false,b2=false,b3=false,b4=false,b5=false,b6=false,b7=false;
    public Boolean repeat = false;

    public void cal2(){
        if(!b1&&!b2&&!b3&&!b4&&!b5&&!b6&&!b7){
            time_cal="未启用";
            return;
        }
        Calendar calendar=Calendar.getInstance();
        Boolean[] list2 = new Boolean[]{false,false,b1,b2,b3,b4,b5,b6,b7};
        int current_day = calendar.get(Calendar.DAY_OF_WEEK);
        if(current_day==1){
            current_day = 8;
        }

        int dayoffset = -1;
        {
            while(true) {
                dayoffset += 1;
                int index = current_day+dayoffset;
                if(index>8){
                    index = index-7;
                }
                if (list2[index]) {
                    break;
                }
                if(dayoffset>15){
                    dayoffset=-1;
                    break;
                }
            }
        }


        Date date1 = calendar.getTime();
        long long1 = date1.getTime();

        String[] sarray = time_tar.split(":");
        int hour = Integer.parseInt(sarray[0]);
        int min = Integer.parseInt(sarray[1]);
        Calendar calendar2=Calendar.getInstance();
        calendar2.setTime(calendar.getTime());
        calendar2.set(Calendar.HOUR_OF_DAY, hour);
        calendar2.set(Calendar.MINUTE, min);
        calendar2.add(5,dayoffset);
        Date date2=calendar2.getTime();
        long long2 = date2.getTime();

        long differ = (long2-long1)/1000;
        if(differ<0){
            differ=differ+3600*24*7;
        }

        if(dayoffset==-1||differ<0){
            time_cal = "已过期"+"";
            return;
        }


        int d_day = (int)(differ/3600/24);
        int d_hour = (int)((differ-d_day*3600*24)/3600);
        int d_min = (int)(differ%3600)/60;
        String s1 = "";
        if(d_day>0){
            s1 = s1+d_day+"天";
        }
        if(d_hour>0){
            s1 = s1+d_hour+"小时";
        }
        if(d_min>0){
            s1 = s1+d_min+"分钟";
        }
        time_cal = s1+"";

    }

    public void cal(){
        cal2();
        if(b1&&b2&&b3&&b4&&b5&&b6&&b7){
            time_day = "每天";
            return;
        }
        String s1 = "";
        if(b1){
            s1 = s1+"周一";
            s1 = s1+",";
        }
        if(b2){
            s1 = s1+"周二";
            s1 = s1+",";
        }
        if(b3){
            s1 = s1+"周三";
            s1 = s1+",";
        }
        if(b4){
            s1 = s1+"周四";
            s1 = s1+",";
        }
        if(b5){
            s1 = s1+"周五";
            s1 = s1+",";
        }
        if(b6){
            s1 = s1+"周六";
            s1 = s1+",";
        }
        if(b7){
            s1 = s1+"周日";
            s1 = s1+",";
        }
        if(s1.length()>1)
        s1 = s1.substring(0,s1.length()-1);
        time_day = s1;
    }
}
