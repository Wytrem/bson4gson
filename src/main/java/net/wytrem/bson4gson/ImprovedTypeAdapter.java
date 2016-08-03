package net.wytrem.bson4gson;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;


public abstract class ImprovedTypeAdapter<T> extends TypeAdapter<T>
{
    final TypeAdapter<JsonElement> elementAdapter;

    public ImprovedTypeAdapter(Gson context)
    {
        elementAdapter = context.getAdapter(JsonElement.class);
    }
    
    @Override
    public void write(JsonWriter out, T value) throws IOException
    {
        elementAdapter.write(out, objectToJsonTree(value));
    }

    @Override
    public T read(JsonReader in) throws IOException
    {
        return objectFromJsonTree(elementAdapter.read(in));
    }

    protected abstract JsonElement objectToJsonTree(T src);

    protected abstract T objectFromJsonTree(JsonElement json);
}
