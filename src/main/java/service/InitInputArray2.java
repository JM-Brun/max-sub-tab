package service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by JMBRUN on 30/11/2016.
 */
public class InitInputArray2 {

    public void onInit() throws Exception {

        String jsonPath = "input-array.json";

        File inputFile = new File("src/test/resources/"+jsonPath);

        //Integer[] inputArray = (Integer[]) jsonToObject(getStringFromInputStream(jsonPath), Arrays.class);


    }

    // convert InputStream to String
    protected String getStringFromInputStream(String resource) throws IOException {
        URL url = Resources.getResource(resource);
        return Resources.toString(url, Charsets.UTF_8);
    }
    protected <T> T jsonToObject(String json, TypeReference<T> typeReference) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        return mapper.readValue(json, typeReference);
    }
    protected <T> T jsonToObject(String json, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        return mapper.readValue(json, clazz);
    }


}
