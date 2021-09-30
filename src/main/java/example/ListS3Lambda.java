package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

import java.util.stream.Collectors;

public class ListS3Lambda implements RequestHandler< S3Event, String> {
    @Override
    public String handleRequest(S3Event event, Context ctx) {
        AmazonS3 s3Client = AmazonS3Client.builder().build();
        String str = s3Client.listBuckets().stream().map(Object::toString).collect(Collectors.joining(","));
        return str;
    }
}