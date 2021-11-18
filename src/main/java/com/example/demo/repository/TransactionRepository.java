package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Transaction;

import java.util.ArrayList;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    public ArrayList<Transaction> findAll();
    public Transaction findById(int id);
}
