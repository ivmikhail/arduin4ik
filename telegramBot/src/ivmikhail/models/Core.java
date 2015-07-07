package ivmikhail.models;

import ivmikhail.models.PhotoSize;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.nio.charset.Charset;

public class Core {
    public static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(PhotoSize.class, new PhotoSizeDeserializer())
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();
    public static final Charset UTF8 = Charset.forName("UTF-8");

    private static class PhotoSizeDeserializer implements JsonDeserializer<PhotoSize>{
        @Override
        public PhotoSize deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            final JsonObject jsonObject = json.getAsJsonObject();
            final PhotoSize photoSize = new PhotoSize();
            photoSize.setFileId(jsonObject.get("file_id").getAsString());
            photoSize.setFileSize(jsonObject.get("file_size").getAsLong());
            photoSize.setHeight(jsonObject.get("height").getAsInt());
            photoSize.setWidth(jsonObject.get("width").getAsInt());
            return photoSize;
        }
    }
}
