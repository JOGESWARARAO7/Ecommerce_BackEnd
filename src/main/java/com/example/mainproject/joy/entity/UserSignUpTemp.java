package com.example.mainproject.joy.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_signup_Temp")
public class UserSignUpTemp {
	
	

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "userid", nullable = false, updatable = false, unique = true)
		private long userid;

	    private String username;

	    private long phonenumber;

	    private String gender;

	    private int pinCode;

	    private String address;

	    private String email;

	    private String password;
	    
	    private int otp;

}
