package com.backend.PDFConverter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import com.cloudmersive.client.ConvertDocumentApi;
import com.cloudmersive.client.invoker.ApiException;


@Service
public class FileServiceImpl implements FileService {

    @Autowired
    public ConvertDocumentApi apiInstance;

    @Override
    public File saveToTemp(MultipartFile file) {
        File tempFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        saveToFile(file, tempFile);
        return tempFile;
    }

    private void saveToFile(MultipartFile input, File output) {
        try (OutputStream outputStream = new FileOutputStream(output)) {
            outputStream.write(input.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveToFile(byte[] bytes, File fileOutput) {
        try (OutputStream outputStream = new FileOutputStream(fileOutput)) {
            outputStream.write(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public byte[] convertDocumentDocxToPdf(File file) {
        try {
            return apiInstance.convertDocumentDocxToPdf(file);
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

}
