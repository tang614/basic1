package JVM.ClassLoader;

public class Test1 {
    public static void main(String[] args) {

        // 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);  // sun.misc.Launcher$AppClassLoader@18b4aac2

        // 获取扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);     //sun.misc.Launcher$ExtClassLoader@677327b6

        // 获取引导类加载器
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);// null

        // test1的加载器
        ClassLoader classLoader = Test1.class.getClassLoader();
        System.out.println(classLoader);        // sun.misc.Launcher$AppClassLoader@18b4aac2

        // String类的加载器
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);       // null

    }
}
