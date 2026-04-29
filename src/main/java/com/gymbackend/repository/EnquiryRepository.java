package com.gymbackend.repository;
import com.gymbackend.model.Enquiry;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {}
