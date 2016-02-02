package structural.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SecurityProxy implements InvocationHandler {

    private Object obj;

    private SecurityProxy(Object obj){
        this.obj = obj;
    }

    public static Object newInstance(Object obj){
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(), new SecurityProxy(obj));
    }

    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Object result;
        try{
            result = method.invoke(obj, objects);
        } catch(InvocationTargetException e){
            throw e.getTargetException();
        } catch (Exception e){
            throw new RuntimeException("unexpected invocation exception: " + e.getMessage());
        }
        return result;
    }
}
