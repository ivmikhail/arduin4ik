package ivmikhail.models;

public class User {
    //    id	Integer	Unique identifier for this user or bot
    private long id;
    //    first_name	String	User�s or bot�s first name
    private String firstName;
    //    last_name	String	Optional. User�s or bot�s last name
    private String lastName;
    //    username	String	Optional. User�s or bot�s username
    private String username;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
