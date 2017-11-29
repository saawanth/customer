package org.doc.store.model;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "document")
@NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d")
public class Document {

	@Id
	@Column(name = "id")
	private String uuid;

	@Column(name = "doc_name")
	private String docName;

	@Column(name = "doc_type")
	private String docType;

	@Column(name = "doc_tag")
	private String docTag;

	@Column(name = "doc_size")
	private long docSize;

	@Column(name = "doc_url")
	private String docUrl;

	@Column(name = "content_type")
	private String contentType;

	@Transient
	private String presignedUrl;

	@Transient
	private byte[] fileData;

	public Document() {
	}

	public Document(byte[] fileData) {
		this.fileData = fileData;
	}
	
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getPresignedUrl() {
		return presignedUrl;
	}

	public void setPresignedUrl(String presignedUrl) {
		this.presignedUrl = presignedUrl;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getDocTag() {
		return docTag;
	}

	public void setDocTag(String docTag) {
		this.docTag = docTag;
	}

	public long getDocSize() {
		return docSize;
	}

	public void setDocSize(long docSize) {
		this.docSize = docSize;
	}

	public String getDocUrl() {
		return docUrl;
	}

	public void setDocUrl(String docUrl) {
		this.docUrl = docUrl;
	}

	public InputStream getInputStream() {
		return new ByteArrayInputStream(fileData);
	}

  public void setDocS3Url(String s3FileUrl) {
    
  }
}
