package com.digicoinexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digicoinexchange.model.Currency;
import com.digicoinexchange.model.Wallet;
import com.digicoinexchange.service.CurrencyService;


@CrossOrigin
@RestController
public class CurrencyController {

	@Autowired
	CurrencyService currencyService;
	
	@RequestMapping(method=RequestMethod.GET,value="/addCurrency/{walletId}/{userId}")
	String addCurrency(Currency currency,@PathVariable int walletId,@PathVariable int userId)
	{

		currency.setWallet(new Wallet(walletId,"","",0.00,0.00,null,userId));
		return currencyService.addCurrency(currency);
		
	}
	
}
