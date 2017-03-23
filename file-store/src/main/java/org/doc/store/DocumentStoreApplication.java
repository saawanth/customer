package org.doc.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
// @EnableWebMvc
public class DocumentStoreApplication {
  public static void main(String[] args) {
    SpringApplication.run(DocumentStoreApplication.class, args);
  }

  // @Bean
  // public MultipartResolver multipartResolver() {
  // org.springframework.web.multipart.commons.CommonsMultipartResolver multipartResolver = new
  // org.springframework.web.multipart.commons.CommonsMultipartResolver();
  // multipartResolver.setMaxUploadSize(1000000);
  // return multipartResolver;
  // }
  
 /* @Bean
  public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
	PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
	ppc.setLocations(new Resource[] {
		new ClassPathResource("/amazon.properties")
       });
	return ppc;
  }
	
  @Bean
  public AWSCredentials credential() {
  	return new BasicAWSCredentials(awsId, awsKey);
  }
	
  @Bean
  public AmazonS3 s3client() {
	return new AmazonS3Client(credential()); 
  }*/
}
