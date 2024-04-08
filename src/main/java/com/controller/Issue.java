package com.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.OptionalLong;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

public class Issue {

    public static void main(String[] args) throws Exception {
        Model model = new Model();
        model.setId(OptionalLong.empty());
        model.setOrder(null);
        model.setName(Optional.ofNullable(null));
        model.setType(null);


        Model1 model1 = new Model1();
       // model1.setOrder(2l);
        model1.setType("test");
        Optional<Model1> m = Optional.of(model1);
        JavaTimeModule module = new JavaTimeModule();
        String DATETIME_FORMAT = "dd-MM-yyyy HH:mm";
        LocalDateTimeSerializer LOCAL_DATETIME_SERIALIZER = new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATETIME_FORMAT));
        module.addSerializer(LOCAL_DATETIME_SERIALIZER);
        ObjectMapper mapper =  new ObjectMapper()
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
                .configure( SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false )
                .configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false )
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .registerModule(new Jdk8Module())
                .registerModule(module);
        mapper.configOverride(Optional.class)
                .setIncludeAsProperty(JsonInclude.Value.construct(JsonInclude.Include.NON_EMPTY, null));

        mapper.configOverride(OptionalLong.class)
                .setIncludeAsProperty(JsonInclude.Value.construct(JsonInclude.Include.NON_EMPTY, null));

       /*
        ObjectMapper mapper = new ObjectMapper()
                .registerModule(new Jdk8Module())
                .setSerializationInclusion(NON_NULL);


                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .registerModule(module);


        mapper.configOverride(Optional.class)
                .setIncludeAsProperty(JsonInclude.Value.construct(JsonInclude.Include.NON_EMPTY, null));

        mapper.configOverride(OptionalLong.class)
                .setIncludeAsProperty(JsonInclude.Value.construct(JsonInclude.Include.NON_EMPTY, null));
                mapper.writeValue(System.out, model); // prints {"id":null,"name":null}
                */


        mapper.writeValue(System.out, m); // prints {"id":null,"name":null}
    }

    @Data
    static class Model1 {
        private Long order;
        private String type;
    }
    static class Model {
        private OptionalLong id;
        private Long order;
        private Optional<String> name;
        private String type;

        public OptionalLong getId() {
            return id;
        }

        public void setId(OptionalLong id) {
            this.id = id;
        }

        public Long getOrder() {
            return order;
        }

        public void setOrder(Long order) {
            this.order = order;
        }

        public Optional<String> getName() {
            return name;
        }

        public void setName(Optional<String> name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

}