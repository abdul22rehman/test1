package com.pankaj.pr2.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employeedto {
    private Long id;


 @NotBlank
 @Size(min=3,message = "Atleast 3 chars should be")
    private String name;
@Email
    private String emailid;
   @Size(min=10,max = 10,message = "10 digits number should be")
    private String mobile;
}
