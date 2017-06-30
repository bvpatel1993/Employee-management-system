package Services;
import model.register;

public class Validation {
 public String Validate(register temp_rg){
	 if(temp_rg.getFirstname().isEmpty() || temp_rg.getLastname().isEmpty() || temp_rg.getAddress().isEmpty()||temp_rg.getPhonenumber().isEmpty()|| temp_rg.getEmail().isEmpty() || temp_rg.getUsername().isEmpty() || temp_rg.getPassword().isEmpty() 
		    	||	(temp_rg.getFirstname().trim().length() <= 0) || (temp_rg.getLastname().trim().length() <= 0) ||(temp_rg.getEmail().trim().length() <= 0)
		    	|| (temp_rg.getUsername().trim().length() <= 0)|| (temp_rg.getPassword().trim().length() <= 0)	)
		   
	 { return "all fields are mandatory";
	 }
	 
//	 else if (temp_rg.getUsername().matches("[0-9]+") && temp_rg.getPassword().matches("[a-zA-Z]+")  && 
//			 temp_rg.getEmail().matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$")) 
//	 
	 {
		 return "sucess";

	 }
		
// else{
//		 return "invalid Credentials";
//	 }
// 
}
 }

 

