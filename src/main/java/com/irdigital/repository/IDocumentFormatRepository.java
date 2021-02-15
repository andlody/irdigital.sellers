package com.irdigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.irdigital.jpa.DocumentFormat;

public interface IDocumentFormatRepository extends JpaRepository<DocumentFormat,Integer>{
	DocumentFormat findByName(String name);
}
