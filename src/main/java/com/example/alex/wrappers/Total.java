package com.example.alex.wrappers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Total {
    @JsonProperty("next_marker")
    private String nextMarker;
    @JsonProperty("results")
    private List<Result> results = null;
    @JsonProperty("presence_active_ids")
    private List<String> presenceActiveIds = null;
    @JsonProperty("ok")
    private Boolean ok;

//    public String getNextMarker() {
//        return nextMarker;
//    }
//
//    public List<Result> getResults() {
//        results = new ArrayList<>();
//        return results;
//    }
//
//    public List<String> getPresenceActiveIds() {
//        return presenceActiveIds;
//    }
//
//    public Boolean getOk() {
//        return ok;
//    }
}





