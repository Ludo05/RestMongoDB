package mongospring.demo.Stuff;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Test_Collection")
public class Customer {

    @Id
    public ObjectId id;

    public String firstName;
    public String lastName;

    public Customer() {}


    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId  id) {
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



}