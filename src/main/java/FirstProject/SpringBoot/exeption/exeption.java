package FirstProject.SpringBoot.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class exeption extends RuntimeException {
    private String name;
    private String email;
    private Object fieldValue;


    public exeption(String name, String email, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", name, email, fieldValue));
        this.name = name;
        this.email = email;
        this.fieldValue = fieldValue;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(Object fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
