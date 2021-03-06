package com.bankapp.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.AccountType;
import com.bankapp.model.Customer;
import com.bankapp.service.ICustomerService;

@Controller
@RequestMapping(value = "/")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	@RequestMapping(value = "addCustomer", method = RequestMethod.GET)
	public String showBookForm(ModelMap map) {
		Customer customer = new Customer();
		map.addAttribute("customer", customer);
		map.addAttribute("customerTypes", AccountType.values());
		return "customerform";
	}

	@RequestMapping(value = "addCustomer", method = RequestMethod.POST)
	public String submittedBookForm(@Valid Customer customer,
			BindingResult result) {
		if (result.hasErrors()) {
			return "customerform";
		} else {
			customerService.addCustomer(customer);
			return "redirect:viewAll";
		}
	}

	@RequestMapping(value = "viewAll", method = RequestMethod.GET)
	public ModelAndView viewAll(Principal principal) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("showAllbooks");
		modelAndView.addObject("customers", customerService.getAllCustomer());
		return modelAndView;

	}

}
