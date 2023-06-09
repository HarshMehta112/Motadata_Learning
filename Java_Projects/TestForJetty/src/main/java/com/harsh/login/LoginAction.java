package com.harsh.login;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport
{
    private String uname,password;

    public String getUname ()
    {

        return uname;
    }

    public String getPassword ()
    {

        return password;
    }

    public void setUname (String uname)
    {

        this.uname = uname;
    }

    public void setPassword (String password)
    {

        this.password = password;
    }

    public String execute()
    {
        if(uname.equals("harsh") && password.equals("Mind@123"))
        {
            return "SUCCESS";
        }
        else
        {
            return "ERROR";
        }
    }

}
