package interview.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

//import jakarta.persistence.*;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//
//@Entity
//public class Candidate {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @NotBlank
//    private String name;
//
//    @Email
//    @Column(unique = true)
//    private String email;
//
//    private String phone;
//
//    private String qualification;
//
//    private String skills;
//
//    private String resumePath;
//
//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    public Candidate() {
//    }
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	public String getQualification() {
//		return qualification;
//	}
//
//	public void setQualification(String qualification) {
//		this.qualification = qualification;
//	}
//
//	public String getSkills() {
//		return skills;
//	}
//
//	public void setSkills(String skills) {
//		this.skills = skills;
//	}
//
//	public String getResumePath() {
//		return resumePath;
//	}
//
//	public void setResumePath(String resumePath) {
//		this.resumePath = resumePath;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//}






import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid Email")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10}$",
    message = "Phone number must be exactly 10 digits")
    private String phone;

    @NotBlank(message = "Qualification is required")
    private String qualification;

    @NotBlank(message = "Skills are required")
    private String skills;
    
    private String resumePath;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	public String getResumePath() {
	    return resumePath;
	}

	public void setResumePath(String resumePath) {
	    this.resumePath = resumePath;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
