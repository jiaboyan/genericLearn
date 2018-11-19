package com.jiaboyan.generic;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.jiaboyan.generic.entity.StudentEntity;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiaboyan on 2017/4/14.
 */
public class JacksonTest {

    private static ObjectMapper mapper = new ObjectMapper();
    static {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);//是否缩放排列输出，默认false，有些场合为了便于排版阅读则需要对输出做缩放排列
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);//转换成json时候，不输出对象中为null的属性.
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));//设置对象转成json时候的格式
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);//json中包含了 对象中没有的属性时候，不抛出异常，
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);//是否允许单引号来包住属性名称和字符串值 默认关闭
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);//是否允许非双引号属性名称  也就是不带双引号的属性
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);//json转换对象，json中包含的属性，在对象中没有set get方法，默认转换抛出异常，设置为false不抛出
    }

    public static void main(String[] agrs) throws IOException {
        Map<String,StudentEntity> map = new HashMap<String,StudentEntity>();
        StudentEntity studentEntity=new StudentEntity();
        studentEntity.setId("1");
        studentEntity.setName("hahaha");
        map.put("test1",studentEntity);
        String json = mapper.writeValueAsString(map);
        Map<String,StudentEntity> jsonToMap = mapper.readValue(json,
                new TypeReference<Map<String,StudentEntity>>(){});
        System.out.println(jsonToMap);
    }

}
