package org.practice.spitter.web;

import org.practice.spitter.Spittle;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class SpittleForm {

    @NotNull
    @Size(max = 300, min = 3, message = "{spittle.message.size}")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Spittle toSpittle() {
        return new Spittle(this.message, new Date());
    }

}
