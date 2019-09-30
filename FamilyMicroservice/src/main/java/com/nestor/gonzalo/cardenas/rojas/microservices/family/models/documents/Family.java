package com.nestor.gonzalo.cardenas.rojas.microservices.family.models.documents;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("checkstyle:Indentation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "family")

public class Family implements Serializable {
    @SuppressWarnings("checkstyle:WhitespaceAround")
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    @NotEmpty
    private String fullName;
    @NotEmpty
    private String gender;
    @NotEmpty
    @JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
    private Date birthdate;
    @NotEmpty
    private String typeDocument;
    @NotEmpty
    @Size(min = 8, max = 8, message = "The document number contains 8 digits")
    private String numberDocument;
	public Family(String id, @NotEmpty String fullName, @NotEmpty String gender, @NotEmpty Date birthdate,
			@NotEmpty String typeDocument,
			@NotEmpty @Size(min = 8, max = 8, message = "The document number contains 8 digits") String numberDocument) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.gender = gender;
		this.birthdate = birthdate;
		this.typeDocument = typeDocument;
		this.numberDocument = numberDocument;
	}
	public Family() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getTypeDocument() {
		return typeDocument;
	}
	public void setTypeDocument(String typeDocument) {
		this.typeDocument = typeDocument;
	}
	public String getNumberDocument() {
		return numberDocument;
	}
	public void setNumberDocument(String numberDocument) {
		this.numberDocument = numberDocument;
	}
    
    
}
