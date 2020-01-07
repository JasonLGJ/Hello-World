import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

/**
 * 方法反射
 * -Jason
 * 执行时请选择只执行本文件
 */

class MyClassFour<T> {

    public MyClassFour(int i, int j, String s) {

    }

    public MyClassFour(T t) {

    }

    public int getInt(String a) {
        return 0;
    }
}

public class MainFour {
    public static void main(String[] args) {
        Class<MyClassFour> c = MyClassFour.class;

        ArrayList<String> methodsDesciption = getDeclaredMethodsList(c);
        System.out.println("Declared Methods  for " + c.getName());
        for (String desc : methodsDesciption) {
            System.out.println(desc);
        }
        methodsDesciption = getMethodsList(c);
        System.out.println("\nMethods for  " + c.getName());
        for (String desc : methodsDesciption) {
            System.out.println(desc);
        }

    }

    public static ArrayList<String> getMethodsList(Class c) {
        Method[] methods = c.getMethods();
        ArrayList<String> methodsList = getMethodsDesciption(methods);
        return methodsList;
    }

    public static ArrayList<String> getDeclaredMethodsList(Class c) {
        Method[] methods = c.getDeclaredMethods();
        ArrayList<String> methodsList = getMethodsDesciption(methods);
        return methodsList;
    }

    public static ArrayList<String> getMethodsDesciption(Method[] methods) {
        ArrayList<String> methodList = new ArrayList<>();

        for (Method m : methods) {
            String modifiers = getModifiers(m);

            Class returnType = m.getReturnType();
            String returnTypeName = returnType.getSimpleName();

            String methodName = m.getName();

            String params = getParameters(m).toString();

            String throwsClause = getExceptionList(m).toString();

            methodList.add(modifiers + "  " + returnTypeName + "  " + methodName
                    + "(" + params + ") " + throwsClause);
        }

        return methodList;
    }

    public static ArrayList<String> getParameters(Executable exec) {
        Parameter[] parms = exec.getParameters();
        ArrayList<String> parmList = new ArrayList<>();
        for (int i = 0; i < parms.length; i++) {

            int mod = parms[i].getModifiers() & Modifier.parameterModifiers();
            String modifiers = Modifier.toString(mod);
            String parmType = parms[i].getType().getSimpleName();
            String parmName = parms[i].getName();
            String temp = modifiers + "  " + parmType + "  " + parmName;
            if (temp.trim().length() == 0) {
                continue;
            }
            parmList.add(temp.trim());
        }
        return parmList;
    }

    public static ArrayList<String> getExceptionList(Executable exec) {
        ArrayList<String> exceptionList = new ArrayList<>();
        for (Class<?> c : exec.getExceptionTypes()) {
            exceptionList.add(c.getSimpleName());
        }
        return exceptionList;
    }

    public static String getModifiers(Executable exec) {
        int mod = exec.getModifiers();
        if (exec instanceof Method) {
            mod = mod & Modifier.methodModifiers();
        } else if (exec instanceof Constructor) {
            mod = mod & Modifier.constructorModifiers();
        }
        return Modifier.toString(mod);
    }
}