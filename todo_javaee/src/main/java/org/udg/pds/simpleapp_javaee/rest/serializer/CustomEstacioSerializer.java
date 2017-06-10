package org.udg.pds.simpleapp_javaee.rest.serializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import org.udg.pds.simpleapp_javaee.model.Estacio;

import java.io.IOException;

/**
 * Created by Charry on 16/05/2017.
 */

public class CustomEstacioSerializer extends JsonSerializer<Estacio> {

    @Override
    public void serialize(Estacio estacio, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", estacio.getId());
        jsonGenerator.writeStringField("nom", estacio.getNom());
        jsonGenerator.writeEndObject();
    }
}
