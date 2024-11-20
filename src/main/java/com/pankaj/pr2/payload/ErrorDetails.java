package com.pankaj.pr2.payload;

import java.util.Date;

public class ErrorDetails {
    private Date date;
    private String message;
    private String request;

    public String getRequest() {
        return request;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public ErrorDetails(Date date, String message, String request) {
        this.date=date;
        this.message=message;
        this.request=request;
    }


}
