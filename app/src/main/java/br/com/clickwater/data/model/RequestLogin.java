package br.com.clickwater.data.model;

public class RequestLogin {

    final String email, password;

    public RequestLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
