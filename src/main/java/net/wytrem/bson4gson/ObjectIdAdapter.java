package net.wytrem.bson4gson;

import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ObjectIdAdapter extends ImprovedTypeAdapter<ObjectId>
{

    public ObjectIdAdapter(Gson context)
    {
        super(context);
    }

    @Override
    protected JsonElement objectToJsonTree(ObjectId src)
    {
        JsonObject element = new JsonObject();
        element.addProperty("$oid", src.toHexString());
        return element;
    }

    @Override
    protected ObjectId objectFromJsonTree(JsonElement json)
    {
        return new ObjectId(json.getAsJsonObject().get("$oid").getAsString());
    }
}
