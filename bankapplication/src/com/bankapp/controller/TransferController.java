package com.bankapp.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bankapp.model.Account;
import com.bankapp.service.AccountFacade;
import com.bankapp.service.CustomException;

@Controller
@RequestMapping(value = "/")
public class TransferController {

	@Autowired
	private AccountFacade bankfacade;

	@RequestMapping(value = "transfer", method = RequestMethod.GET)
	public String showBookForm(ModelMap map, Principal principal) {
			System.out.println("Hiiii");
			Account account = new Account();
			map.addAttribute("account", account);
			return "transferAmount";
		} 
	

	@RequestMapping(value = "transferAction", method = RequestMethod.POST)
	public void amountTransfer(Account account, BindingResult result) {
		String fromAccount = account.getFrom_account();
		String toAccount = account.getTo_account();
		double amount = account.getAmount();
		try {
			bankfacade.transfer(fromAccount, toAccount, amount);
		} catch (CustomException e) {
			e.printStackTrace();
		}

	}
	/**/
}
