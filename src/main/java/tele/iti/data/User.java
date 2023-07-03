/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tele.iti.data;

/**
 *
 * @author omoor
 */
public class User {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
      private String username;
    private String email;
    private String password;
    private String phone;
//    private String address;
//    private String job;
//    private String interests;
    private String birthday;

    public User() {
    }

//    public String getAddress() {
//        return address;
//    }

    public String getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

//    public String getInterests() {
//        return interests;
//    }

//    public String getJob() {
//        return job;
//    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

//    public void setAddress(String address) {
//        this.address = address;
//    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public void setInterests(String interests) {
//        this.interests = interests;
//    }

//    public void setJob(String job) {
//        this.job = job;
//    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User(int id,String username, String email, String password, String phone, String birthday) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.birthday = birthday;
    }
      
   
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + username + ", email=" + email + ", password=" + password + "]";
	}
	
}

    

