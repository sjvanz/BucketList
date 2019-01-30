package com.example.bucketlist;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class sampleData {

    private  static  final  String SampleTitle1 = "Skydive";
    private  static  final  String SampleTitle2 = "Bungeejumpen";

    private  static  final  String SampleText1 = "uit een vliegtuig springen ";
    private  static  final  String SampleText2 = "met een touw van een brug springen";

    private static Date getDate(int diff){
        GregorianCalendar cal = new GregorianCalendar();
        cal.add(Calendar.MILLISECOND, diff);
        return  cal.getTime();
    }

    public static List<BucketModel> getList() {
        List<BucketModel> Bucketlist = new ArrayList<>();
        Bucketlist.add(new BucketModel(1,false,SampleTitle1,SampleText1,getDate(0)));
        Bucketlist.add(new BucketModel(2,false,SampleTitle2,SampleText2,getDate(1)));
        return Bucketlist;
    }
}
