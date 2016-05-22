package com.java.jdbc;

import java.util.Date;

public class Employee {

    private Long id;

    private String firstname;

    private String lastName;

    private String emailId;

    private String mobileNumber;

    private Date creationDate;

    public Employee() {

    }

    public Employee(String firstname, String lastName, String emailId, String mobileNumber) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String laString) {
        this.lastName = laString;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Employee [id=").append(id).append(", firstname=").append(firstname).append(", lastName=")
                .append(lastName).append(", emailId=").append(emailId).append(", mobileNumber=").append(mobileNumber)
                .append(", creationDate=").append(creationDate).append("]");
        return builder.toString();
    }

}
