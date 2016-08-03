package net.wytrem.bson4gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class LongAdapter extends ImprovedTypeAdapter<Long>
{

    public LongAdapter(Gson context)
    {
        super(context);
    }

    @Override
    protected JsonElement objectToJsonTree(Long src)
    {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("$numberLong", src.longValue());
        return jsonObject;
    }

    @Override
    protected Long objectFromJsonTree(JsonElement json)
    {
        return Long.valueOf(json.getAsJsonObject().get("$numberLong").getAsLong());
    }

}
