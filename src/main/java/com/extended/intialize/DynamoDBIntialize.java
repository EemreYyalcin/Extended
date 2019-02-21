package com.extended.intialize;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.extended.util.CoreUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class DynamoDBIntialize {

    private void initializeTables(AmazonDynamoDB amazonDynamoDB) {
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

        // Alternatively, you can scan your model package for the DynamoDBTable annotation
        List<Class> modelClasses = CoreUtil.getClasses("com.extended.model.noDB");
        if (Objects.isNull(modelClasses)){
            return;
        }

        for (Class cls : modelClasses) {
            log.info("Creating DynamoDB table for " + cls.getSimpleName());
            CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(cls);
            tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));

            boolean created = TableUtils.createTableIfNotExists(amazonDynamoDB, tableRequest);

            if (created) {
                log.info("Created DynamoDB table for " + cls.getSimpleName());
            } else {
                log.info("Table already exists for " + cls.getSimpleName());
            }
        }

        ListTablesResult tablesResult = amazonDynamoDB.listTables();

        log.info("Current DynamoDB tables are: ");
        for (String name : tablesResult.getTableNames()) {
            log.info("\t" + name);
        }

    }

}
