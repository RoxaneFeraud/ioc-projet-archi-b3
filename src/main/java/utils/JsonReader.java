package utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class JsonReader {

    static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path.substring(1)));
        return new String(encoded, encoding);
    }

    public static <T> Optional<List<T>> readJsonFile(String path, Function<JSONObject, T> converter) {
        try {
            ClassLoader classLoader = JsonReader.class.getClassLoader();
            File file = new File(classLoader.getResource(path).getFile());

            JSONArray arr = new JSONArray(readFile(classLoader.getResource(path).getFile(), StandardCharsets.UTF_8));
            List<T> list = new ArrayList<>();
            for (int i = 0; i < arr.length(); i++) {
                list.add(converter.apply(arr.getJSONObject(i)));
            }
            return Optional.of(list);
        } catch (IOException e) {
            return Optional.empty();
        }
    }
}
