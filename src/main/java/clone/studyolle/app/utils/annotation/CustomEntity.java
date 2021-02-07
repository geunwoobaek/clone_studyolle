package clone.studyolle.app.utils.annotation;

import lombok.*;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AliasFor;

import javax.persistence.Entity;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.CLASS;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.hibernate.validator.constraints.CompositionType.OR;


public @interface CustomEntity {
    String staticConstructor() default "";
}
