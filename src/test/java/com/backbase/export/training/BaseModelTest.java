package com.backbase.export.training;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Vladimir Raskin
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/META-INF/spring/model-context.xml", "classpath*:/META-INF/spring/test-model-datasource.xml"})
public abstract class BaseModelTest {


}
