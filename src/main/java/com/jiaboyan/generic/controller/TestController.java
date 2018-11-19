package com.jiaboyan.generic.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.jiaboyan.generic.dfdfs.haha;
import com.jiaboyan.generic.dfdfs.hahaImpl;
import com.jiaboyan.generic.entity.StudentEntity;
import com.jiaboyan.generic.entity.Test1111;
import com.jiaboyan.generic.entity.FileEntity;
import com.jiaboyan.generic.json.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by jiaboyan on 2017/3/26.
 */
@Controller
@RequestMapping("/test")
public class TestController<T1> {

    @RequestMapping("/include")
    public String jsp(HttpServletRequest request, HttpServletResponse response){
        return "include";
    }


    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult uploadFileHandler(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            InputStream in = null;
            OutputStream out = null;
            try {
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();
                File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
                in = file.getInputStream();
                out = new FileOutputStream(serverFile);
                byte[] b = new byte[1024];
                int len = 0;
                while ((len = in.read(b)) > 0) {
                    out.write(b, 0, len);
                }
                out.close();
                in.close();
                JsonResult jsonResult = new JsonResult();
                jsonResult.setFlag(true);
                jsonResult.setMsg("File upload success");
                jsonResult.setData("http://172.17.106.197:8081/ucm/201701/925b01bfb08e464f9279e1cfe7e5ecd8.credit_code_img");
                return jsonResult;
            } catch (Exception e) {
                JsonResult jsonResult = new JsonResult();
                jsonResult.setFlag(false);
                jsonResult.setMsg("File upload faild");
                return jsonResult;
            } finally {
                if (out != null) {
                    out.close();
                    out = null;
                }

                if (in != null) {
                    in.close();
                    in = null;
                }
            }
        } else {
            JsonResult jsonResult = new JsonResult();
            jsonResult.setFlag(false);
            jsonResult.setMsg("File is empty");
            return jsonResult;
        }
    }

    /**
     * Upload multiple file using Spring Controller
     */
    @RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult uploadMultipleFileHandler(@RequestParam("files") MultipartFile[] files,String name,HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {

        JsonResult jsonResult = new JsonResult();
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];

            if (!file.isEmpty()) {
                InputStream in = null;
                OutputStream out = null;

                try {
                    String rootPath = System.getProperty("catalina.home");
                    File dir = new File(rootPath + File.separator + "tmpFiles");
                    if (!dir.exists())
                        dir.mkdirs();
                    File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
                    in = file.getInputStream();
                    out = new FileOutputStream(serverFile);
                    byte[] b = new byte[1024];
                    int len = 0;
                    while ((len = in.read(b)) > 0) {
                        out.write(b, 0, len);
                    }
                    out.close();
                    in.close();
                } catch (Exception e) {
                    arr.add(i);
                } finally {
                    if (out != null) {
                        out.close();
                        out = null;
                    }

                    if (in != null) {
                        in.close();
                        in = null;
                    }
                }
            } else {
                arr.add(i);
            }
        }
        if(arr.size() > 0) {
            jsonResult.setFlag(false);
            jsonResult.setMsg("Files upload fail");
        } else {
            jsonResult.setFlag(true);
            jsonResult.setMsg("Files upload success");
        }
        return jsonResult;
    }

    private static ObjectMapper mapper = new ObjectMapper();
    static {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);//是否缩放排列输出，默认false，有些场合为了便于排版阅读则需要对输出做缩放排列
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);//转换成json时候，不输出对象中为null的属性.
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));//设置对象转成json时候的格式
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);//json中包含了 对象中没有的属性时候，不抛出异常，
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);//是否允许单引号来包住属性名称和字符串值 默认关闭
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);//是否允许非双引号属性名称  也就是不带双引号的属性
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);//json转换对象，json中包含的属性，在对象中没有set get方法，默认转换抛出异常，设置为false不抛出
//        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);// 对于空的对象转json的时候不抛出错误  默认就不报错很奇怪
    }

    List<?> list = new ArrayList<String>();

    Test1111[] test1111 = new Test1111[]{};

    static Set<?> unknownSet = new HashSet<String>();

    public static <T> void addToSet(Set<T> s, T t) {

    }

    private T1[] tArray = null;

    public static void test() {
        TypeReference typeReference = new TypeReference<List<FileEntity>>(){
            @Override
            public Type getType() {
                return super.getType();
            }

            @Override
            public int compareTo(TypeReference<List<FileEntity>> o) {
                return super.compareTo(o);
            }
        };
        Type superClass = typeReference.getClass().getGenericSuperclass();
        Type _type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
    }

    public static void main(String[] agrs) throws IOException, NoSuchFieldException {


//        Map<String,StudentEntity> map = new HashMap<String,StudentEntity>();
//        StudentEntity studentEntity=new StudentEntity();
//        studentEntity.setId("1");
//        studentEntity.setName("hahaha");
//        map.put("test1",studentEntity);
//        String json = mapper.writeValueAsString(map);
//        Map<String,StudentEntity> jsonToMap = mapper.readValue(json,
//                new TypeReference<Map<String,StudentEntity>>(){});
//        System.out.println(jsonToMap);

//        Test<String> test = new Test<String>(){};
//        Type superClass = test.getClass().getGenericSuperclass();
//        Type _type = ((ParameterizedType) superClass).getActualTypeArguments()[0];

//        haha<String> hh = new haha<String>(){};
//        Type[] superClass = hh.getClass().getGenericInterfaces();
//        Type _type = ((ParameterizedType) superClass[0]).getActualTypeArguments()[0];


//        hahaImpl<String> hhimpl = new hahaImpl<String>();

        haha<String> hhimpl = new hahaImpl<String>();
        Type[] superClass22 = hhimpl.getClass().getGenericInterfaces();
        Type _type22 = ((ParameterizedType) superClass22[0]).getActualTypeArguments()[0];


        FileEntity<String> fileEntity1 = new FileEntity<String>();
        Type superClass1 = fileEntity1.getClass().getGenericSuperclass();
//        Type _type1 = ((ParameterizedType) superClass1).getActualTypeArguments()[0];
//
//        Test<String> test111 = new Test<String>();
//        TypeVariable[] typeVariables = test111.getClass().getTypeParameters();
//        for(TypeVariable typeVariable : typeVariables){
//            System.out.print(typeVariable.getName());
//        }

         mapper.readValue("", new TypeReference<Map<String, FileEntity>>(){});
    }

    public static String objectToString(Object object){
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T stringToObject(String json,Class<T> clazz) {
        try {
            return mapper.readValue(json,clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static List stringToList(String json, Class clazz){




        return null;
    }

}
