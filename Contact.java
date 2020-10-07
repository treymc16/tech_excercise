package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE employee (
  id INT NOT NULL AUTO_INCREMENT,    
  name VARCHAR(30) NOT NULL,   
  age INT NOT NULL,    
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "contacts")
public class Contact {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Integer id;

   @Column(name = "name")
   private String name;

   @Column(name = "cell_number")
   private String cellNumber;
   
   @Column(name ="home_number")
   private String homeNumber;
   
   @Column(name  = "email")
   private String email;
   
   @Column(name = "address")
   private String address;

   public Contact() {
   }

   public Contact(Integer id, String name, String cellNumber, 
		   String homeNumber, String email, String address) {
      this.id = id;
      this.name = name;
      this.cellNumber = cellNumber;
      this.homeNumber = homeNumber;
      this.email = email;
      this.address = address;
   }

   public Contact(String name, String cellNumber, 
		   String homeNumber, String email, String address) {
	   this.name = name;
	   this.cellNumber = cellNumber;
	   this.homeNumber = homeNumber;
	   this.email = email;
	   this.address = address;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
   
   public String getCellNumber() {
	   return cellNumber;
   }
   
   public void setCellNumber(String number) {
	   this.cellNumber = number;
   }
   
   public String getHomeNumber() {
	   return homeNumber;
   }
   
   public void setHomeNumber(String number) {
	   this.homeNumber = number;
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
   @Override
   public String toString() {
      return "Contact: " + this.id + ", " + this.name + ", "
    		  + this.cellNumber + ", " + this.homeNumber + ", " + this.email + ", " + this.address;
   }
}