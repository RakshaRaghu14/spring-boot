package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Transaction;
import com.example.demo.repository.TransactionRepository;

@Service
public class TransactionService  {

  @Autowired
  private TransactionRepository transactionRepository;

  public ArrayList<Transaction> getAllTransactions(){
    ArrayList<Transaction> transactionList=new ArrayList<>();
		transactionList=(ArrayList<Transaction>) transactionRepository.findAll();
		return transactionList;
  }

public Transaction getTransactionById(int id) {
    Transaction transaction = new Transaction();
    transaction = transactionRepository.findById(id);
    return transaction;
}

public Transaction updateTransaction(int id, Double amount, String desc) {
  Transaction transaction = new Transaction();
  transaction.setId(id);
  transaction.setAmount(amount);
  transaction.setDescription(desc);
  transaction = transactionRepository.save(transaction);
  return transaction;
}

public String createTransaction(Transaction transaction) {
	 Transaction createdTransaction = new Transaction();
      createdTransaction = transactionRepository.save(transaction);
      if(createdTransaction!=null) return "Created successfully";
      else return "Could not create";
}
	
}