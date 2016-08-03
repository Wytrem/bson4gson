package net.wytrem.bson4gson;

import java.sql.Timestamp;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class TimestampAdapter extends ImprovedTypeAdapter<Timestamp>
{
    public TimestampAdapter(Gson context)
    {
        super(context);
    }

    @Override
    protected JsonElement objectToJsonTree(Timestamp src)
    {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("$ts", src.getTime());
        jsonObject.addProperty("$inc", 1);
        return jsonObject;
    }

    @Override
    protected Timestamp objectFromJsonTree(JsonElement json)
    {
        return new Timestamp(Bson4Gson.getUnsignedInt(json.getAsJsonObject().get("$ts").getAsInt()) * 1000l);
    }
}
