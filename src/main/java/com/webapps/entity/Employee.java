package com.webapps.entity;

import com.webapps.validator.Profession;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employee_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private long id;
	@NotNull
	@NotEmpty(message = "Email field should not be empty")
	@Size(min = 3,max = 15,message = "Name should be more than 2 character and less than 16 character")
	private String name;

	@NotNull
	@NotEmpty(message = "Email field should not be empty")
	@Size(min = 8,message = "Enter proper email ID")
    private String email;
	@NotNull
	@NotEmpty(message = "City name should not be empty")
	@Size(min = 3,max = 15,message = "Enter proper city name")
    private String city;
	@Profession
    private String profession;

    @Override
    public String toString() {
        return super.toString();
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}
    
    
}
