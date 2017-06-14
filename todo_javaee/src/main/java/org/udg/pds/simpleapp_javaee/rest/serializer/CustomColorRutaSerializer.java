package org.udg.pds.simpleapp_javaee.rest.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.udg.pds.simpleapp_javaee.model.Color;

import java.io.IOException;

/**
 * Created by Charry on 14/06/2017.
 */
public class CustomColorRutaSerializer extends JsonSerializer<Color> {

    @Override
    public void serialize(Color c, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException, JsonProcessingException {
        jsonGenerator.writeObject(c.getNom());
    }
}
