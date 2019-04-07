package io.qkits.jmeterplugins.api;

import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;

import java.util.function.Function;

/**
 * abstract fo JMETER REQUEST TEMPLATE SAMPLER
 */
public abstract class JMeterTemplateSample extends AbstractSampler {

    private SampleResult exec(String sampleLabel, Function<String, Object> function) {
        SampleResult sr = new SampleResult();
        sr.setSampleLabel(sampleLabel);
//        sr.getSamplerData();// to implement you own get sample data
        try {
            Object result = function.apply(sr.getSamplerData());
            sr.setResponseData(result.toString(), "utf-8");
            sr.setResponseMessageOK();
            sr.setResponseCodeOK();
        } catch (Exception e) {
            sr.setResponseMessage("FAIL");
        }
        sr.sampleEnd();
        return sr;

    }

    @Override
    public SampleResult sample(Entry entry) {
        String sampleLabel = this.getProperty("sampleLabel").toString();
        Function<String, Object> f = buildFunction(entry);
        return exec(sampleLabel, f);
    }

    public abstract Function<String, Object> buildFunction(Entry entry);

    @Override
    public void removed() {
//        fill you remove element logic here
//        System.out.println("fill you remove element logic here");
    }
}
