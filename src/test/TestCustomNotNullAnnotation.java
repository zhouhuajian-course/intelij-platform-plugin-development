package test;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
@interface NotNull {
    String value() default "";

    Class<? extends Exception> exception() default Exception.class;
}

public class TestCustomNotNullAnnotation {

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
