package org.udg.pds.simpleapp_javaee.rest.serializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import org.udg.pds.simpleapp_javaee.model.Estacio;

import java.io.IOException;
import java.util.List;

/**
 * Created by Charry on 16/05/2017.
 */

public class CustomEstacioListSerializer extends StdSerializer<List<Estacio>> {

    public CustomEstacioListSerializer() {
        this(null);
    }

    public CustomEstacioListSerializer(Class<List<Estacio>> t) {
        super(t);
    }


    @Override
    public void serialize(List<Estacio> estacions, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
        jsonGenerator.writeStartArray();
        for (Estacio estacio : estacions) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", estacio.getId());
            jsonGenerator.writeStringField("nom", estacio.getNom());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
    }
}
