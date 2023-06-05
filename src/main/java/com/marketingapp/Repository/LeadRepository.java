package com.marketingapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketingapp.Entites.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
