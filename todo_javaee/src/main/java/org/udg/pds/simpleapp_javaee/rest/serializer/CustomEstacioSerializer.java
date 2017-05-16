package org.udg.pds.simpleapp_javaee.rest.serializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import javafx.util.Pair;
import org.udg.pds.simpleapp_javaee.model.Estacio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charry on 16/05/2017.
 */

public class CustomEstacioSerializer extends StdSerializer<List<Estacio>> {

    public CustomEstacioSerializer() {
        this(null);
    }

    public CustomEstacioSerializer(Class<List<Estacio>> t) {
        super(t);
    }


    @Override
    public void serialize(List<Estacio> estacions, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
        /*List<Long> estacionsjson = new ArrayList<Long>();
        for (Estacio estacio : estacions) {
            estacionsjson.add(estacio.getId());
        }
        jsonGenerator.writeObject(estacionsjson);*/

        jsonGenerator.writeStartArray();
        for (Estacio estacio : estacions) {
            jsonGenerator.writeStartObject();
            /*jsonGenerator.writeObjectField("id", estacio.getId());
            jsonGenerator.writeObjectField("nom", estacio.getNom());*/
            jsonGenerator.writeNumberField("id", estacio.getId());
            jsonGenerator.writeStringField("nom", estacio.getNom());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
    }
}
