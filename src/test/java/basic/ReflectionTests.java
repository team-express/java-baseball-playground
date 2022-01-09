package basic;

import baseball.BallMaker;
import org.junit.jupiter.api.Test;
import util.MyMathUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public class ReflectionTests {
    @Test
    void test(){
        Class c = BallMaker.class;
        try{
            Constructor[] constructors = c.getDeclaredConstructors();
            Class[] paramTypes = {int.class,int.class,int.class};
            Constructor constructor = c.getDeclaredConstructor(paramTypes);
            //constructor.setAccessible(true);
            BallMaker b = (BallMaker) constructor.newInstance(1,9,3);
            Method m = c.getDeclaredMethod("test");
            m.setAccessible(true);
            m.invoke(b);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    Method[] ms = String.class.getDeclaredMethods();
    @Test
    void test2(){
        ms[0].getTypeParameters();

        String name="";
        int input = 1;

        invokePrivateMethod(name, input);
    }
    void invokePrivateMethod(String name,int input){
        for(Method method : ms){
            if(method.getName().equals(name)){
                Class[] params = method.getParameterTypes();
                try {
                    method.invoke(new Object(),input);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
