import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 反射对象创建
 * -Jason
 * 执行时请选择只执行本文件
 */
/*
public class MainSeven {
    public static void main(String[] args) {
        try {
            Object my = Array.newInstance(int.class, 2);

            int n1 = Array.getInt(my, 0);
            int n2 = Array.getInt(my, 1);
            System.out.println("n1 = " + n1 + ", n2=" + n2);

            Array.set(my, 0, 11);
            Array.set(my, 1, 12);

            n1 = Array.getInt(my, 0);
            n2 = Array.getInt(my, 1);
            System.out.println("n1 = " + n1 + ", n2=" + n2);
        } catch (NegativeArraySizeException | IllegalArgumentException
                | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
*/

/**
 * 展开数组
 *
 public class MainSeven {
 public static void main(String[] args) {
 int[][][] intArray = new int[1][2][3];

 System.out.println("int[][][] dimension is " + getArrayDimension(intArray));
 }

 public static int getArrayDimension(Object array) {
 int dimension = 0;
 Class c = array.getClass();
 if (!c.isArray()) {
 throw new IllegalArgumentException("Object is not  an  array");
 }
 while (c.isArray()) {
 dimension++;
 c = c.getComponentType();
 }
 return dimension;
 }
 }
 */


public class MainSeven {
    public static void main(String[] args) {
        int[] ids = new int[2];
        System.out.println(ids.length);
        System.out.println(Arrays.toString(ids));

        ids = (int[]) expandBy(ids, 2);

        ids[2] = 3;
        System.out.println(ids.length);
        System.out.println(Arrays.toString(ids));
    }

    public static Object expandBy(Object oldArray, int increment) {
        Object newArray = null;
        int oldLength = Array.getLength(oldArray);
        int newLength = oldLength + increment;
        Class<?> c = oldArray.getClass();
        newArray = Array.newInstance(c.getComponentType(), newLength);
        System.arraycopy(oldArray, 0, newArray, 0, oldLength);
        return newArray;
    }
}