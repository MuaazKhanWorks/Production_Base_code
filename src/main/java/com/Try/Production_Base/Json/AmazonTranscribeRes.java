package com.Try.Production_Base.Json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AmazonTranscribeRes {
    private Results results;

    @Data
    public static class Results {
        private List<Transcript> transcripts;
    }

    @Data
    public static class Transcript {
        private String transcript;
    }
}
