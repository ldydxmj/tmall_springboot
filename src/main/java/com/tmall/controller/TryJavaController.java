package com.tmall.controller;


import com.tmall.dto.Result;
import com.tmall.pojo.Property;
import org.springframework.web.bind.annotation.*;
import com.tmall.util.ObjUtil;
import com.tmall.util.Season;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

//RestController:对每个方法的返回值都会直接转换为json,不需在方法前面加@ResponseBody,但是不能返回jsp,html页面，视图解析器无法解析jsp,html页面
@RequestMapping("/tryJava")
@RestController
public class TryJavaController {

    //sting arrys相关
    @GetMapping("/string")
    public Result tryJava() throws Exception {
        String result = "hello";
        int[] a = {123, 100, 101, 102};
        ObjUtil obj = new ObjUtil("king", 24);

        Result result1 = Result.success(obj);
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }
//
//        for (int i = 2; i < a.length; i++) {
//            if (a[i] < a[1]) {
//                int temp = a[1];
//                a[1] = a[i];
//                a[i] = temp;
//            }
//
//        }
//        for (int each:a){
//            System.out.println(each);
//        }
//        int[]b=new int[4];
//        System.arraycopy(a,0,b,0,3);

        int[] b = Arrays.copyOfRange(a, 0, 3);
        Arrays.sort(b);
        System.out.println(Arrays.toString(b));
        return result1;
    }

    @GetMapping("/class")
    public Result handleClass() {
        ObjUtil obj = new ObjUtil("king-class", 24);
        Result result = Result.success(obj);
        Season season = Season.SUMMER;

        System.out.println(season);

        return result;
    }

    @GetMapping("/math")
    public Result handleMath() {
        ObjUtil obj = new ObjUtil("king-math", 24);
        Result result = Result.success(obj);
        Season season = Season.SUMMER;

        System.out.println(season);
        String s = "121 %d %s %n 33333";
        String s2 = "ok";
        int i = 5;
        Integer it = new Integer(i);
        int i2 = it.intValue();
        String st = it.toString();
//        i2 = Integer.parseInt(s,2);
        System.out.printf(s, i2, s2);

        Date now = new Date();

        //当前日期的毫秒数
        System.out.println("Date.getTime() \t\t\t返回值: " + now.getTime());
        //通过System.currentTimeMillis()获取当前日期的毫秒数
        System.out.println("System.currentTimeMillis() \t返回值: " + System.currentTimeMillis());
        return result;
    }

    @GetMapping("/io")
    public Result handleIo() throws IOException {
        ObjUtil obj = new ObjUtil("king-io", 24);
        File file = new File("d:/try.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] all = new byte[(int) file.length()];
        fis.read(all);
        for (byte b : all) {
            System.out.println(b);
        }
        obj.setName("设置的名字");
        Result result = Result.success(obj);
        return result;
    }
    @PostMapping("/file")
    public Result handleFile(@RequestBody File file) throws IOException {
        ObjUtil obj = new ObjUtil("king-file", 24);

        Result result = Result.success(obj);
        return result;

    }


}
