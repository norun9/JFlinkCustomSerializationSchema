package org.serialization;
        import org.apache.flink.api.common.serialization.SerializationSchema;
        import com.fasterxml.jackson.databind.ObjectMapper;
        import com.fasterxml.jackson.databind.node.ObjectNode;
        import org.apache.flink.api.java.tuple.Tuple2;

public class Tuple2SerializationSchema implements SerializationSchema<Tuple2<String, String>> {

    private static final long serialVersionUID = 1L;
    private transient ObjectMapper objectMapper;

    @Override
    public void open(InitializationContext context) throws Exception {
        objectMapper = new ObjectMapper();
    }

    @Override
    public byte[] serialize(Tuple2<String, String> element) {
        try {
            ObjectNode node = objectMapper.createObjectNode();
            node.put("f0", element.f0);
            node.put("f1", element.f1);
            return objectMapper.writeValueAsBytes(node);
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize element", e);
        }
    }
}
