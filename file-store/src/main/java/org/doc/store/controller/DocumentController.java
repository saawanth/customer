package org.doc.store.controller;

import org.doc.store.dto.DocumentDto;
import org.doc.store.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/documents")
@Controller
public class DocumentController {

  @Autowired
  private DocumentService documentService;

  // consumes = MediaType.MULTIPART_FORM_DATA_VALUE
  @RequestMapping(method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<String> greeting() {
    return new ResponseEntity<String>("Welcom to document store", HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.POST)
  public @ResponseBody ResponseEntity<DocumentDto> create(
      @RequestParam(name = "docName", required = false) String docName,
      @RequestParam(name = "docType", required = false) String docType,
      @RequestParam(name = "docTag", required = false) String docTag,
      @RequestParam(name = "file", required = false) MultipartFile file) {
    DocumentDto docDto = new DocumentDto();
    docDto.setDocName(docName);
    docDto.setDocTag(docTag);
    docDto.setDocType(docType);
    docDto.setMultiPartfile(file);
    DocumentDto savedDoc = documentService.save(docDto);
    return new ResponseEntity<DocumentDto>(savedDoc, HttpStatus.OK);
  }
  
  
  @RequestMapping(path = "/download", method = RequestMethod.GET)
  public ResponseEntity<Resource> download(String param) throws IOException {

//      // ...
//
//      Path path = Paths.get(file.getAbsolutePath());
      ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

      return ResponseEntity.ok()
              .headers(headers)
              .contentLength(file.length())
              .contentType(MediaType.parseMediaType("application/octet-stream"))
              .body(resource);
  }

}
