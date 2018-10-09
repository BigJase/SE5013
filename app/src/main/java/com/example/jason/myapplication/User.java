package com.example.jason.myapplication;

public class User {
    public String id,userName, email, password;

    public User(){
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        //user Address
    }

<<<<<<< HEAD
    public User(String id, String userName, String email, String password ){
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


=======
    public User(String username, String password){
            this.username = username;
            this.password = password;
    }
>>>>>>> Refactor
}
