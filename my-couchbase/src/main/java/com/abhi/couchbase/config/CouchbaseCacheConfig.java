package com.abhi.couchbase.config;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.spring.cache.CacheBuilder;
import com.couchbase.client.spring.cache.CouchbaseCacheManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Abhinav on 12/18/2018.
 */
@EnableCaching
@Configuration
@PropertySource(value = { "classpath:/application.properties" })
public class CouchbaseCacheConfig {

    public static final String CACHE_NAME = "VEHICLE";

    @Value("${couchbase.server}")
    private String couchbaseServer;

    @Value("${couchbase.bucket}")
    private String couchbaseBucket;

    @Value("${couchbase.password}")
    private String couchbasePassword;

    /**
     * Connects to the couchbase server running on your local machine
     * @return Cluster
     */
    @Bean(destroyMethod = "disconnect")
    public Cluster cluster(){
        return CouchbaseCluster.create(couchbaseServer);
    }

    /**
     * Connects to the bucket named 'Vehicle' (which must exist in your couchbase server)
     * Every cache related element used this bucket
     * @return Bucket
     */
    @Bean(destroyMethod = "close")
    public Bucket bucket(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@"+couchbaseBucket+"##################"+couchbasePassword);
        return cluster().openBucket(couchbaseBucket, couchbasePassword);
    }

    /**
     *
     * @return CacheManager
     */
    @Bean
    public CacheManager cacheManager(){
        CacheBuilder cacheBuilder = CacheBuilder.newInstance(bucket()).withExpirationInMillis(0);
        return new CouchbaseCacheManager(cacheBuilder, CACHE_NAME);
    }
}
