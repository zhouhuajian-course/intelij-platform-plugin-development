package test;

/**
 * Java 默认禁止断言，需要加JVM选项启用断言
 * -enableassertions 或者 -ea
 *
 * 没启用断言，则assert语句会被忽略。
 * IDEA在调试运行时会添加-ea选项
 *
 * Disables assertions. By default, assertions are disabled in all packages and classes.
 */
public class TestAssert {
    public static void main(String[] args) {
        Object o =  null;
        // assert o != null;
        // Exception in thread "main" java.lang.AssertionError
        //	   at test.TestAssert.main(TestAssert.java:10)
        // assert o != null : "对象不能为空";
        // Exception in thread "main" java.lang.AssertionError: 对象不能为空
        //     at test.TestAssert.main(TestAssert.java:13)
        // if (o == null) {
        //     throw new AssertionError();
        // }
        // Exception in thread "main" java.lang.AssertionError
        //    at test.TestAssert.main(TestAssert.java:17)
    }
}
