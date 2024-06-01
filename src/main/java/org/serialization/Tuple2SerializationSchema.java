package org.serialization;
import org.apache.flink.api.common.serialization.SerializationSchema;
import org.apache.flink.api.java.tuple.Tuple2;

import java.nio.charset.StandardCharsets;

public class Tuple2SerializationSchema implements SerializationSchema<Tuple2<String, String>> {

    private static final long serialVersionUID = 1L;

    @Override
    public void open(InitializationContext context) throws Exception {
       // nothing to do
    }

    @Override
    public byte[] serialize(Tuple2<String, String> element) {
        try {
            String value = element.f1;
            return value.getBytes(StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize", e);
        }
    }
}
