package np.com.hemshrestha.blog.model;

/**
 * Created by hereshem on 11/26/17.
 */

public class Student {

    int roll;
    String name, phone, email, address;



    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    public Student(int roll, String name, String phone, String email, String address) {
        this.roll = roll;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
