package net.wytrem.bson4gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Bson4Gson
{
    public static void registerTypeAdapters(GsonBuilder builder)
    {
        builder.registerTypeAdapterFactory(new BsonTypeAdapterFactory());
    }

    public static Gson build()
    {
        GsonBuilder builder = new GsonBuilder();
        registerTypeAdapters(builder);
        return builder.create();
    }

    public static long getUnsignedInt(int x)
    {
        return x & 0x00000000ffffffffL;
    }
}
