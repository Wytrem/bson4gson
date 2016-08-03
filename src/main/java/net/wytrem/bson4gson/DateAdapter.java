package net.wytrem.bson4gson;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


public class DateAdapter extends ImprovedTypeAdapter<Date>
{
    public DateAdapter(Gson context)
    {
        super(context);
    }

    @Override
    protected JsonElement objectToJsonTree(Date src)
    {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("$date", ISO8601Utils.format(src));
        return jsonObject;
    }

    @Override
    protected Date objectFromJsonTree(JsonElement json)
    {
        try
        {
            return ISO8601Utils.parse(json.getAsJsonObject().get("$date").getAsString(), new ParsePosition(0));
        }
        catch (ParseException e)
        {
            return new Date();
        }
    }

}
