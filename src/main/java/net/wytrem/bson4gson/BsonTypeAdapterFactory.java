package net.wytrem.bson4gson;

import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

public class BsonTypeAdapterFactory implements TypeAdapterFactory
{
    @SuppressWarnings("unchecked")
    @Override
    public <T> ImprovedTypeAdapter<T> create(Gson gson, TypeToken<T> type)
    {
        if (type.getRawType() == java.sql.Timestamp.class)
        {
            return (ImprovedTypeAdapter<T>) new TimestampAdapter(gson);
        }
        else if (type.getRawType() == java.util.Date.class)
        {
            return (ImprovedTypeAdapter<T>) new DateAdapter(gson);
        }
        else if (type.getRawType() == ObjectId.class)
        {
            return (ImprovedTypeAdapter<T>) new ObjectIdAdapter(gson);
        }
        return null;
    }
}
