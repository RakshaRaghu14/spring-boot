package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.model.Transaction;
import com.example.demo.service.TransactionService;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping
public class TransactionController {

  @Autowired
	private TransactionService transactionService;

  @RequestMapping(value="/transaction",method=RequestMethod.GET)
  public ResponseEntity<ArrayList<Transaction>> getAllTransactions(){
    ResponseEntity<ArrayList<Transaction>> res=null;
    ArrayList<Transaction> temp=transactionService.getAllTransactions();
    if(temp!=null) res=new ResponseEntity<ArrayList<Transaction>>(temp, HttpStatus.OK);
		return res;
  }

  @RequestMapping(value="/transaction/{id}",method=RequestMethod.GET)
	public ResponseEntity<Transaction> getTransactionById(@PathVariable int id)
	{
		ResponseEntity<Transaction> res=null;
		Transaction transaction=transactionService.getTransactionById(id);
		if(transaction!=null) res=new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
		return res;
  }

  @RequestMapping(value="/transaction/{id}/{amount}/{description}",method=RequestMethod.PUT)
	public ResponseEntity<Transaction> updateTransaction(@PathVariable int id,@PathVariable Double amount,@PathVariable String desc)
	{
		ResponseEntity<Transaction> res=null;
		Transaction transaction=transactionService.updateTransaction(id,amount,desc);
		if(transaction!=null) res=new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
		return res;
  }

  @RequestMapping(value="/transaction/{amount}/{category}/{description}",method=RequestMethod.POST) 
  public ResponseEntity<String> createTrans(@PathVariable Double amount,@PathVariable String category,@PathVariable String desc){
		ResponseEntity<String> res=null;
		String result=null;
	    Transaction transaction =  new Transaction();
	    Category categoryObj = new Category();
	    categoryObj.setCategoryName(category);
	    transaction.setAmount(amount);
	    transaction.setDescription(desc);
	    transaction.setCategory(categoryObj);
		result = transactionService.createTransaction(transaction);
		res=new ResponseEntity<String>(result, HttpStatus.OK);
		return res;
	} 
  
  @RequestMapping(value="/createTransaction",method=RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> createTransaction(@RequestBody Transaction transaction){
		
	  ResponseEntity<String> res=null;
		String result=null;
		result=transactionService.createTransaction(transaction);	
		res=new ResponseEntity<String>(result, HttpStatus.OK);		
		return res;
	}
	
}	
