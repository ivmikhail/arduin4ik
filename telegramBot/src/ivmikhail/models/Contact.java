package ivmikhail.models;


public class Contact {
    //    phone_number	String	Contact's phone number
    private String phoneNumber;
    //    first_name	String	Contact's first name
    private String firstName;
    //    last_name	String	Optional. Contact's last name
    private String lastName;
    //    user_id	String	Optional. Contact's user identifier in Telegram
    private String userId;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
