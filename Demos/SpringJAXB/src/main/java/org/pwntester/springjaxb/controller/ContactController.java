package org.pwntester.springjaxb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contacts")
public class ContactController {

	@RequestMapping(value="/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
    @ResponseBody
	public String getContact(@PathVariable String name) {
		return name;
	}

   @RequestMapping( method = RequestMethod.POST, headers = "Accept=application/xml" )
   @ResponseStatus( HttpStatus.CREATED )
   @ResponseBody
   public Contact createContact ( @RequestBody Contact contact ){
   	  System.out.println("Contact " + contact.getName());
      return contact;
   }
	
}
