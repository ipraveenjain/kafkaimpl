/**
 * 
 */
package com.jain.kafka.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jain.kafka.pojo.Bank;
import com.jain.kafka.service.BankService;

/**
 * @author pravjain
 *
 */
@RestController
public class BankController {

	@Autowired
	BankService bankSvc;

	@RequestMapping(value = "/bank", method = RequestMethod.GET)
	public List<Bank> getAllBank() {
		List<Bank> bankList = bankSvc.getAllBank();
		return bankList;
	}

	@RequestMapping(value = "/bank/branchCode/{bcode}", method = RequestMethod.GET)
	public List<Bank> showWelcomePage(ModelMap model, @PathVariable(value="bcode") String bcode) {
		List<Bank> bank=bankSvc.getBankbyBranchCode(bcode);
		return bank;
	}
	@RequestMapping(value = "/bank/addbank", method = RequestMethod.POST)
	public int addBank(@RequestBody Bank bank) {
		int count=bankSvc.createBank(bank);
		return count;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		return "login";
	}
}
