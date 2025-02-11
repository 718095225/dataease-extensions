package io.dataease.plugins.datasource.mongo.service;

import io.dataease.plugins.common.constants.DatabaseClassification;
import io.dataease.plugins.common.constants.DatasourceCalculationMode;
import io.dataease.plugins.common.dto.datasource.DataSourceType;
import io.dataease.plugins.datasource.service.DatasourceService;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class MongoService extends DatasourceService {


    @Override
    public List<String> components() {
        List<String> result = new ArrayList<>();
        result.add("mongobi");
        return result;
    }
    @Override
    protected InputStream readContent(String s) {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("static/" + s);
        return resourceAsStream;
    }

    @Override
    public DataSourceType getDataSourceType() {
        DataSourceType dataSourceType =  new DataSourceType("mongobi", "Mongodb-BI" , true , "characterEncoding=UTF-8&connectTimeout=5000&useSSL=true&allowPublicKeyRetrieval=true&verifyServerCertificate=false", DatasourceCalculationMode.DIRECT, true);
        dataSourceType.setKeywordPrefix("`");
        dataSourceType.setKeywordSuffix("`");
        dataSourceType.setAliasPrefix("");
        dataSourceType.setAliasSuffix("");
        dataSourceType.setDatabaseClassification(DatabaseClassification.NORDBMS);
        return dataSourceType;
    }
}
