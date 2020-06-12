package com.example.bmnseats.model;

public class user {
    private String Fname;
    private String Lname;
    private String Email;
    private String password;

   public user()
   {

   }
    public user(String Fname_Constructor, String Lname_Constructor, String Email_Constructor, String Password_Constructor)
    {
        Email=Email_Constructor;
        password=Password_Constructor;
        Fname=Fname_Constructor;
        Lname=Lname_Constructor;
    }

    public String getEmail()
    {
        return Email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setEmail(String email)
    {
        Email = email;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getFname()
    {
        return Fname;
    }
    public String getLname()
    {
        return Lname;
    }
    public void setFname(String Fname)
    {
        this.Fname=Fname;
    }
    public void setLname(String Lname)
    {

        this.Lname=Lname;
    }
}
