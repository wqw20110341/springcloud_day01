package com.toec;

import com.alibaba.fastjson.JSON;
import com.toec.dao.BookDao;
import com.toec.domain.Book;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@SpringBootTest
public class EsApplicationTest {
    private RestHighLevelClient client;
    private String esUrl = "http://192.168.200.1:9200";

    @Autowired
    private BookDao bookDao;

    @BeforeEach
    void setUp() {
        HttpHost httpHost = HttpHost.create(esUrl);
        RestClientBuilder builder = RestClient.builder(httpHost);
        client = new RestHighLevelClient(builder);
    }

    @AfterEach
    void tearDown() throws IOException {
        client.close();
    }

    @Test
    void testCreateIndexClient() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("books2");
        client.indices().create(request, RequestOptions.DEFAULT);
    }

    @Test
    void testCreateDocClient() throws IOException {
        Book book = bookDao.selectById(5);
        IndexRequest request = new IndexRequest("books").id(book.getId().toString());
        String json = JSON.toJSONString(book);
        request.source(json, XContentType.JSON);
        client.index(request,RequestOptions.DEFAULT);
    }

    @Test
    void testCreateDocAll() throws IOException {

        List<Book> books = bookDao.selectList(null);
        BulkRequest bulkRequest = new BulkRequest();
        for (Book book : books){
            IndexRequest request = new IndexRequest("books").id(UUID.randomUUID().toString());
            String json = JSON.toJSONString(book);
            request.source(json, XContentType.JSON);
            bulkRequest.add(request);
        }
        client.bulk(bulkRequest,RequestOptions.DEFAULT);
    }

    @Test
    void testGet() throws IOException {
        GetRequest request =new GetRequest("books","1");
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        String source = response.getSourceAsString();
        System.out.println(JSON.parseObject(source,Book.class));
    }

    @Test
    void testSearch() throws IOException {
        SearchRequest request = new SearchRequest("books");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(QueryBuilders.termsQuery("name","spring"));
        request.source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        for (SearchHit hit:hits){
            String source = hit.getSourceAsString();
            System.out.println(JSON.parse(source));
        }

    }


}
