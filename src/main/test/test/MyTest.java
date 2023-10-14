package test;

import org.junit.Test;

import java.io.*;

public class MyTest {
    @Test
    public void test(){
        File file=new File("C:\\Users\\21960\\Desktop\\untitled\\src\\main\\webapp\\static\\images\\1.png");
        File file2=new File("C:\\Users\\21960\\Desktop\\untitled\\target\\物业管理系统\\static\\images\\1.png");
        try {
            InputStream in=new FileInputStream(file);
            int a;
            OutputStream out=new FileOutputStream(file2);
            while ((a=in.read())!=-1){
                out.write(a);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void test2(){
        String s="localhost:8585/wyglxt_war_exploded/static/images/20230803151117.png";
        String[] ss=s.split("/");
//        for (String s1:ss) {
//            System.out.println(s1);
//        }
        System.out.println(ss[ss.length - 1]);
    }
}
