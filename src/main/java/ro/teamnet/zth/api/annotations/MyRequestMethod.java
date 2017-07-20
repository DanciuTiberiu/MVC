package ro.teamnet.zth.api.annotations;

import java.lang.annotation.*;
import java.lang.reflect.Type;

/**
 * Created by Tiberiu.Danciu on 7/20/2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented

public @interface MyRequestMethod {
    String urlPath();
    String methodType();
}
