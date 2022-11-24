package test;


import org.jetbrains.annotations.NotNull;

// D:\java\jdk-11.0.16\bin\javac.exe -classpath "D:\jetbrains\IntelliJ IDEA 2020.3.4\lib\annotations.jar" test\TestNotNullAnnotation.java
// D:\java\jdk-11.0.16\bin\java.exe -classpath "D:\jetbrains\IntelliJ IDEA 2020.3.4\lib\annotations.jar;." test.TestNotNullAnnotation
// test
// 手动使用javac.exe编译，并没有空指针的检查，说明JetBrainsRuntime在编译的时候，做了很多额外的编译工作
public class TestNotNullAnnotation {

    public static void main(String[] args) {
        test(null);
        // Exception in thread "main" java.lang.IllegalArgumentException: Argument for @NotNull parameter 'object' of test/TestNotNullAnnotation.test must not be null
        //     at test.TestNotNullAnnotation.$$$reportNull$$$0(TestNotNullAnnotation.java)
        //     at test.TestNotNullAnnotation.test(TestNotNullAnnotation.java)
        //     at test.TestNotNullAnnotation.main(TestNotNullAnnotation.java:8)
    }

    public static void test(@NotNull Object object) {
        System.out.println("test");
    }

}
