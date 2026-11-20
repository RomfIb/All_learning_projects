import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import Enum.*;
@Target(ElementType.METHOD)
public @interface Role {
    RoleType value() default RoleType.USER;
}
