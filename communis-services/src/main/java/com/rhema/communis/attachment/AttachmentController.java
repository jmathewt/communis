package com.rhema.communis.attachment;

import com.rhema.communis.repository.FileUploadTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    @Autowired
    FileUploadTemplate fileUploadTemplate;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    Map upload(@RequestParam("file") MultipartFile file, Principal principal) {
        Map<String, Object> metadata = new HashMap<>();
        String name = file.getOriginalFilename();
        try {

            metadata.put("uploadedBy", principal.getName());
            String id = this.fileUploadTemplate.upload(file.getInputStream(), file.getName(), file.getContentType(), "public", metadata);
            metadata.put("id", id);
            return metadata;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/file/{id}")
    public HttpEntity<byte[]> getUploadedFile(@PathVariable String id) {

        GridFsResource file = this.fileUploadTemplate.findOne(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, file.getContentType());
        return new HttpEntity(file, headers);
    }
}
