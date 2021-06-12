package com.putao_seo.api.errors;

import java.util.Arrays;
import java.util.List;

public class Errors {

    List<ApplicationError> errors;

    private Errors(List<ApplicationError> errors) {
        this.errors = errors;
    }

    public List<ApplicationError> getErrors() {
        return errors;
    }

    public void setErrors(List<ApplicationError> errors) {
        this.errors = errors;
    }

    public static Errors endPointNotFound(){
        return new Errors(Arrays.asList(new ApplicationError("404", "End Point Not Found")));
    }

    public static Errors bookNotFound(){
        return new Errors(Arrays.asList(new ApplicationError("404", "book Not Found")));
    }

    public static Errors bookAlreadyCheckedOut() {
        return new Errors(Arrays.asList(new ApplicationError("422", "book cannot be checked out")));
    }

    public static Errors cannotAddBookException(){
        return new Errors(Arrays.asList(new ApplicationError("500", "book cannot be added")));
    }
    
    public static Errors paramsError(){
        return new Errors(Arrays.asList(new ApplicationError("400", "book Not Found")));
    }
}
