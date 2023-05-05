package com.backend.PDFConverter.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface FileService {
    File saveToTemp(MultipartFile file);

    byte[] convertDocumentDocxToPdf(File file);

}
