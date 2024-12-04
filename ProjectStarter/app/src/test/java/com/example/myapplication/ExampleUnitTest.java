package com.example.myapplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(MockitoJUnitRunner.class)


public class ExampleUnitTest {
    @Mock
    LoginActivity view;

    @Mock
    Model model;

    @Test
    public void test_handlelogin_emptyemail(){
        when(view.getEmail()).thenReturn(null);
        when(view.getPassword()).thenReturn("hello");
        Presenter presenter = new Presenter(view, model);
        presenter.handleLogIn();
        verify(view).displayMessage("Email or Password cannot be empty");
    }

    @Test
    public void test_handlelogin_emptypassword(){
        when(view.getEmail()).thenReturn("hello");
        when(view.getPassword()).thenReturn(null);
        Presenter presenter = new Presenter(view, model);
        presenter.handleLogIn();
        verify(view).displayMessage("Email or Password cannot be empty");
    }

    @Test
    public void test_handlelogin_noInputPassword(){
        when(view.getEmail()).thenReturn("hello");
        when(view.getPassword()).thenReturn("");
        Presenter presenter = new Presenter(view, model);
        presenter.handleLogIn();
        verify(view).displayMessage("Email or Password cannot be empty");
    }

    @Test
    public void test_handlelogin_noInputEmail(){
        when(view.getEmail()).thenReturn("");
        when(view.getPassword()).thenReturn("Hello");
        Presenter presenter = new Presenter(view, model);
        presenter.handleLogIn();
        verify(view).displayMessage("Email or Password cannot be empty");
    }



    @Test
    public void test_handlelogin_invalidpassword(){
        Presenter presenter = new Presenter(view, model);
        presenter.handleResult(-1);
        verify(view).displayMessage("Wrong Email/Password: ");
    }

    @Test
    public void test_handlelogin_unverifiedemail(){
        Presenter presenter = new Presenter(view, model);
        presenter.handleResult(0);
        verify(view).displayMessage("Please verify your email before logging in.");
    }

    @Test
    public void test_success_text(){
        Presenter presenter = new Presenter(view, model);
        presenter.handleResult(1);
        verify(view).displayMessage("Successfully Logged In");
    }

    @Test
    public void test_success_new(){
        Presenter presenter = new Presenter(view, model);
        presenter.handleResult(1);
        verify(view).startNew();
    }


    @Test
    public void test_invoke(){
       
        when(view.getEmail()).thenReturn("hello");
        when(view.getPassword()).thenReturn("hi");

        Presenter presenter = new Presenter(view, model);
    
        presenter.handleLogIn();

        verify(model).login("hello", "hi", presenter);
    }
    @Test
    public void test_reset(){
        Presenter presenter = new Presenter(view, model);
        presenter.resetPass();
        verify(view).forgerPassword();
    }

    @Test
    public void test_back(){
        Presenter presenter = new Presenter(view, model);
        presenter.back();
        verify(view).back();
    }




}
