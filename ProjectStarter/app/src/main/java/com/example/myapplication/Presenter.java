package com.example.myapplication;

public class Presenter {
    LoginActivity view;
    Model model;

    Presenter(LoginActivity view, Model model){
        this.view = view;
        this.model = model;
    }

    public void handleLogIn(){
        String email = view.getEmail();
        String password = view.getPassword();
        if(email == null || password == null || email.isEmpty() || password.isEmpty()){
            view.displayMessage("Email or Password cannot be empty");
        }else{
            model.login(email,password, this);
        }
    }

    public void handleResult(int indicator){
        if(indicator == 1){
            view.displayMessage("Successfully Logged In");
            view.startNew();
            //view.startNext();
        }
        if(indicator == 0){
            view.displayMessage("Please verify your email before logging in.");
        }
        if(indicator == -1){
            view.displayMessage("Wrong Email/Password: ");
        }
    }

    public void resetPass(){
        view.forgerPassword();
    }

    public void back(){
        view.back();
    }
}
