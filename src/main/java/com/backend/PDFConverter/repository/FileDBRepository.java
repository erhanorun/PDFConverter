package com.backend.PDFConverter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.PDFConverter.model.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
