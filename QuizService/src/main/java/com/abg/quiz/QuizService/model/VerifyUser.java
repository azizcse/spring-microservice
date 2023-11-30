package com.abg.quiz.QuizService.model;

public class VerifyUser {
    private String phone;
    private String device;
    private long timeStamp;
    public VerifyUser(){}
    public VerifyUser(String phone, String device, long timeStamp) {
        this.phone = phone;
        this.device = device;
        this.timeStamp = timeStamp;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
