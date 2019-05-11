package io.qkits.testerint.postman.model.collection;

import io.qkits.common.utils.JSONHelper;
import org.aspectj.util.FileUtil;
import org.junit.Test;

import java.io.File;
import java.io.IOException;


public class CollectionManagerTest {

    @Test
    public void testPostmanCollection() throws IOException {
        File jsonFile=new File("collections/pilotrunner.collection.json");

        String collections = FileUtil.readAsString(jsonFile);

        CollectionManager manager = JSONHelper.toBean(collections,CollectionManager.class);
        System.out.println(manager);
    }
}