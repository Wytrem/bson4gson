package net.wytrem.bson4gson;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class Tests
{
    public static void main(String[] args)
    {
        String json = "{\"huhu\":\"tototo\",\"theDate\" : { \"$ts\" : 12525339221822537 , \"$inc\" : 1} }";
        Aze aze = Bson4Gson.build().fromJson(json, Aze.class);
        System.out.println("aze.date = " + aze.theDate + aze.huhu);
    }
    
    static class Aze
    {
        String huhu;
        @SerializedName("theDate")
        Date theDate;
    }
}
