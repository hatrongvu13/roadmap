package com.jax.spring.data.requests.impl;

import com.jax.spring.api.services.DemoServices;
import com.jax.spring.data.entities.Demo;
import com.jax.spring.data.repositories.DemoRepository;
import com.jax.spring.data.requests.DemoRequest;
import com.jax.spring.data.responses.DemoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DemoServicesImpl implements DemoServices {

    @Autowired
    DemoRepository demoRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public String fake() {
        List<Demo> fakeList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            Demo demo = new Demo();
            demo.setName("Name_" + LocalDateTime.now() + "_" + i);
            if (i % 2 == 0) {
                demo.setType("CHAN");
            } else {
                demo.setType("LE");
            }
            fakeList.add(demo);
        }
        demoRepository.saveAll(fakeList);
        return "done !";
    }

    @Override
    public DemoResponse search(DemoRequest demo) {
        Criteria criteria = new Criteria();
        criteria.and("name").regex(".*" + demo.getName() + ".*");
        criteria.and("type").regex(demo.getType());

        long sk = demo.getPage() > 1 ? demo.getPageSize() * (demo.getPage() - 1) : demo.getPageSize();

        var match = Aggregation.match(criteria);
        var skip = Aggregation.skip(sk);
        var limit = Aggregation.limit(demo.getPageSize());
        var sort = Aggregation.sort(Sort.Direction.DESC, "createdDate");
//        var facet = Aggregation.facet(match, Aggregation.count()
//                .as("total"))
//                .as("total")
//                .and(match, skip, limit, sort).as("result");
//        var facet = Aggregation.facet(match, limit, skip, sort);
        var project = Aggregation.project();

//        var aggregation = Aggregation.newAggregation(facet,project);
        var aggregation = Aggregation.newAggregation(match, skip, limit);
        var result = mongoTemplate.aggregate(aggregation, Demo.class, Demo.class);

        DemoResponse response = new DemoResponse();
        response.setContent(result.getMappedResults());
        response.setCurrentPage(demo.getPage());
        response.setTotalRecord(result.getMappedResults().size());
        response.setPageSize(demo.getPageSize());
        return response;
    }
}
