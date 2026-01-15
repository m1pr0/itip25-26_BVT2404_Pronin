import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataProcessor {
    String name() default "";
    int order() default 0;
}
