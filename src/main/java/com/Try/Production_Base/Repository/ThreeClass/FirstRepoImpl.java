package com.Try.Production_Base.Repository.ThreeClass;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "f1", "f2", "s1", "s2", "t1", "t2" })
public interface FirstRepoImpl {
    Long getId();
    String getF1();
    String getF2();
    String getS1();
    String getS2();
    String getT1();
    String getT2();
}
