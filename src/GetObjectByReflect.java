import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class GetObjectByReflect {
    public static void main(String[] args) throws Exception{
        Properties pro=new Properties();
        //获取类加载器
        ClassLoader classLoader = GetObjectByReflect.class.getClassLoader();
        //加载配置文件获取字节流
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        pro.load(is);

        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        Class clazz = Class.forName(className);//获得Class对象
        Object o = clazz.newInstance();
        Method method = clazz.getMethod(methodName);
        method.invoke(o);
    }
}
