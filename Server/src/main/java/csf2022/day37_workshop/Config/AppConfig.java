package csf2022.day37_workshop.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

// To establish AWS-S3 storage connection.
@Configuration
public class AppConfig {
    @Value("${DO_STORAGE_KEY}")
    private String accessKey;

    @Value("${DO_STORAGE_SECRETKEY}")
    private String secretKey;

    @Value("${DO_STORAGE_EDNPOINT}")
    private String endpoint;

    @Value("${DO_STORAGE_REGION}")
    private String endpointRegion; 

    @Bean
    public AmazonS3 createS3Client(){

        BasicAWSCredentials cred = new BasicAWSCredentials(accessKey, secretKey);
        EndpointConfiguration ep = new EndpointConfiguration(endpoint, endpointRegion);

        return AmazonS3ClientBuilder.standard().withEndpointConfiguration(ep)
                                    .withCredentials(new AWSStaticCredentialsProvider(cred))
                                    .build();

    }


}
