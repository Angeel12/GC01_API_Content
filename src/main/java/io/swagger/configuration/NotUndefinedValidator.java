package io.swagger.configuration;

import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class NotUndefinedValidator implements ConstraintValidator<NotUndefined, Object>{

        @Override
        public void initialize(NotUndefined constraintAnnotation) {
            // This method is intentionally left empty because
            // the NotUndefined constraint does not require any specific initialization logic.
        }


        @Override
        public boolean isValid(Object addressInformation, ConstraintValidatorContext context) {
            Class<?> objClass = addressInformation.getClass();
            Field[] fields = objClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.getType().equals(JsonNullable.class)){
                    field.setAccessible(true);
                    try {
                        Object value = field.get(addressInformation);
                        if(value.equals(JsonNullable.undefined())){
                            context.disableDefaultConstraintViolation();
                            context.buildConstraintViolationWithTemplate(field.getName() + " cannot be undefined")
                                    .addConstraintViolation();
                            return false;
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            return true;
        }
}