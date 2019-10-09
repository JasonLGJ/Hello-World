/**
 * 反射对象创建
 * -Jason
 * 执行时请选择只执行本文件
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 无参数构造函数
 *
class MyClassSeven {
    public MyClassSeven() {
        System.out.println("called");
    }
}
public class MainSeven {
    public static void main(String[] args) throws InstantiationException {
        Class<MyClassSeven> personClass = MyClassSeven.class;
        try {
            MyClassSeven p = personClass.newInstance();
            System.out.println(p);
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }
}
 */

/**
 * 带参数构造函数
 *
class MyClassSeven {
    public MyClassSeven(int i, String s) {
        System.out.println("called");
        System.out.println(i);
        System.out.println(s);
    }
}
public class MainSeven {
    public static void main(String[] args) {
        Class<MyClassSeven> myClass = MyClassSeven.class;
        try {
            Constructor<MyClassSeven> cons = myClass.getConstructor(int.class,
                    String.class);
            MyClassSeven chris = cons.newInstance(1, "abc");
            System.out.println(chris);
        } catch (NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            System.out.println(e.getMessage());
        }
    }
}
*/

/**
 class MyClassSeven {
    public String name = "Unknown";
    public MyClassSeven() {
    }
    public String toString() {
        return "name=" + this.name;
    }
}
public class MainSeven {
    public static void main(String[] args) {
        Class<MyClassSeven> ppClass = MyClassSeven.class;
        try {
            MyClassSeven p = ppClass.newInstance();
            Field name = ppClass.getField("name");
            String nameValue = (String) name.get(p);
            System.out.println("Current name is " + nameValue);
            name.set(p, "abc");
            nameValue = (String) name.get(p);
            System.out.println("New  name is " + nameValue);
        } catch (InstantiationException | IllegalAccessException
                | NoSuchFieldException | SecurityException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
*/

/**
 * 方法的访问
 */
class MyClassSix {
    public MyClassSix() {
    }

    public void setName(String n) {
        System.out.println(n);
    }
}

public class MainSix {
    public static void main(String[] args) {
        Class<MyClassSix> myClass = MyClassSix.class;
        try {
            MyClassSix p = myClass.newInstance();
            Method setName = myClass.getMethod("setName", String.class);
            setName.invoke(p, "abc");
        } catch (InstantiationException | IllegalAccessException
                | NoSuchMethodException | SecurityException | IllegalArgumentException
                | InvocationTargetException e) {
            System.out.println(e.getMessage());
        }
    }
}