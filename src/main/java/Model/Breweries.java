/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

/**
 *
 * @author brend
 */
@Entity
@Table(name = "breweries")
@SecondaryTable(name="breweries_geocode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Breweries.findAll", query = "SELECT b FROM Breweries b"),
    @NamedQuery(name = "Breweries.findById", query = "SELECT b FROM Breweries b WHERE b.brewid = :id"),
    @NamedQuery(name = "Breweries.findMaxId", query = "SELECT MAX(b.brewid) as maxid FROM Breweries b"),
    @NamedQuery(name = "Breweries.findByName", query = "SELECT b FROM Breweries b WHERE b.name = :name"),
    @NamedQuery(name = "Breweries.findByAddress1", query = "SELECT b FROM Breweries b WHERE b.address1 = :address1"),
    @NamedQuery(name = "Breweries.findByAddress2", query = "SELECT b FROM Breweries b WHERE b.address2 = :address2"),
    @NamedQuery(name = "Breweries.findByCity", query = "SELECT b FROM Breweries b WHERE b.city = :city"),
    @NamedQuery(name = "Breweries.findByState", query = "SELECT b FROM Breweries b WHERE b.state = :state"),
    @NamedQuery(name = "Breweries.findByCode", query = "SELECT b FROM Breweries b WHERE b.code = :code"),
    @NamedQuery(name = "Breweries.findByCountry", query = "SELECT b FROM Breweries b WHERE b.country = :country"),
    @NamedQuery(name = "Breweries.findByPhone", query = "SELECT b FROM Breweries b WHERE b.phone = :phone"),
    @NamedQuery(name = "Breweries.findByWebsite", query = "SELECT b FROM Breweries b WHERE b.website = :website"),
    @NamedQuery(name = "Breweries.findByImage", query = "SELECT b FROM Breweries b WHERE b.image = :image"),
    @NamedQuery(name = "Breweries.findByAddUser", query = "SELECT b FROM Breweries b WHERE b.addUser = :addUser"),
    @NamedQuery(name = "Breweries.findByLastMod", query = "SELECT b FROM Breweries b WHERE b.lastMod = :lastMod"),
    @NamedQuery(name = "Breweries.findByCreditLimit", query = "SELECT b FROM Breweries b WHERE b.creditLimit = :creditLimit"),
    @NamedQuery(name = "Breweries.findByEmail", query = "SELECT b FROM Breweries b WHERE b.email = :email")})
public class Breweries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    @Column(name = "id", updatable = false, nullable = false)
    private Integer brewid;
    
    @Basic(optional = false)
    @NotNull (message="Must not be null")
    @Size(min = 1, max = 50, message="Enter at least 1 letter for name")
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @NotNull (message="Must not be null")
    @Size(min = 1, max = 50, message="Enter at least 1 letter for Address max is 50")
    @Column(name = "address1")
    private String address1;
    
    @Basic(optional = false)
    @NotNull (message="Must not be null")
    @Size(min = 1, max = 50, message="Enter at least 1 letter for Address max is 50")
    @Column(name = "address2")
    private String address2;
    
    @Basic(optional = false)
    @NotNull (message="Must not be null")
    @Size(min = 1, max = 30, message="Enter at least 1 letter max is 30")
    @Column(name = "city")
    private String city;
    
    @Basic(optional = false)
    @NotNull (message="Must not be null")
    @Size(min = 1, max = 20, message="Enter a state name between 1 and 20 characters allowed")
    @Column(name = "state")
    private String state;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "code")
    private String code;
    
    @Basic(optional = false)
    @NotNull (message="Must not be null")
    @Size(min = 1, max = 255)
    @Column(name = "country")
    private String country;
    
    @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull (message="Must not be null")
    @Size(min = 1, max = 50)
    @Column(name = "phone")
    private String phone;
    
    @Basic(optional = false)
    @NotNull (message="Must not be null")
    @Size(min = 1, max = 255)
    @URL (message="Please enter valid URL starting with http://")
    @Column(name = "website")
    private String website;
    
    @Basic(optional = false)
    @NotNull (message="Must not be null")
    @Size(min = 1, max = 255)
    @Column(name = "image")
    private String image;
    
    @Basic(optional = false)
    @NotNull (message="Must not be null")
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    
    @Basic(optional = false)
    @NotNull (message="Must not be null")
    @Column(name = "add_user")
    //@Size(min=0, max=2, message="must be 2 or less digits and not negative")
    private int addUser;
    
    @Basic(optional = false)
    @NotNull (message="Must not be null")
    @Column(name = "last_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastMod;
    
    @Basic(optional = false)
    @NotNull (message="Must not be null")
    @Column(name = "credit_limit")
    @DecimalMin("0.00") 
    @DecimalMax("999999.99") 
    private double creditLimit;
    
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull (message="Must not be null")
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    
    //GeoCode
  

//    @Column(table="breweries_geocode")
//    private Integer geoid;
//    
    @Column(table="breweries_geocode")
    private int brewery_id;
    
    @Column(table="breweries_geocode")
    @NotNull(message="enter number between -90 and 90")
    
    @Max(90)
    @Min(-90)
    private float latitude;
    
    @Column(table="breweries_geocode")
    @NotNull //(message="enter number between -180 and 180")
    @Max(180) 
    @Min(-180)
    private float longitude;


    
    
    
    
    
    public Breweries() {
    }

    public Breweries(Integer brewid) {
        this.brewid = brewid;
    }

    public Breweries(Integer brewid, String name, String address1, String address2, String city, String state, String code, String country, String phone, String website, String image, String description, int addUser, Date lastMod, double creditLimit, String email) {
        this.brewid = brewid;
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.code = code;
        this.country = country;
        this.phone = phone;
        this.website = website;
        this.image = image;
        this.description = description;
        this.addUser = addUser;
        this.lastMod = lastMod;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public Breweries(int brewery_id, float latitude, float longitude) {
       //this.geoid=geoid;
        this.brewery_id = brewery_id;
        this.latitude = latitude;
        this.longitude = longitude;
    }
//    public int getgeoid()
//    {
//    return geoid;
//    }        
//
//    public void setGeoid(int geoid) {
//        this.geoid = geoid;
//    }
    
    public int getBrewery_id() {
        return brewery_id;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setBrewery_id(int brewery_id) {
        this.brewery_id = brewery_id;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
    
    public Integer getbrewid() {
        return brewid;
    }

    public void setbrewid(Integer brewid) {
        this.brewid = brewid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAddUser() {
        return addUser;
    }

    public void setAddUser(int addUser) {
        this.addUser = addUser;
    }

    public Date getLastMod() {
        return lastMod;
    }

    public void setLastMod(Date lastMod) {
        this.lastMod = lastMod;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (brewid != null ? brewid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Breweries)) {
            return false;
        }
        Breweries other = (Breweries) object;
        if ((this.brewid == null && other.brewid != null) || (this.brewid != null && !this.brewid.equals(other.brewid))) {
            return false;
        }
        return true;
    }

    
    
    
    
    
    
    
//    @Override
//    public String toString() {
//        return "Model.Breweries[ id=" + brewid + " ]";
//    }

    @Override
    public String toString() {
        return "Breweries{" + "brewid=" + brewid + ", name=" + name + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state=" + state + ", code=" + code + ", country=" + country + ", phone=" + phone + ", website=" + website + ", image=" + image + ", description=" + description + ", addUser=" + addUser + ", lastMod=" + lastMod + ", creditLimit=" + creditLimit + ", email=" + email + ", brewery_id=" + brewery_id + ", latitude=" + latitude + ", longitude=" + longitude + '}';
    }
    
}
