package com.pokemon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class StatsDto {
    @JsonProperty("base_stat")
    private int baseStat;
    @JsonProperty("effort")
    private int effort;

    private String nameStat;
    private String urlStat;

    @SuppressWarnings("unchecked")
    @JsonProperty("stat")
    private void unpackNested(Map<String, Object> spec) {
        this.nameStat = (String) spec.get("name");
        this.urlStat = (String) spec.get("url");
    }

    public int getBaseStat() {
        return baseStat;
    }

    public void setBaseStat(int baseStat) {
        this.baseStat = baseStat;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public String getNameStat() {
        return nameStat;
    }

    public void setNameStat(String nameStat) {
        this.nameStat = nameStat;
    }

    public String getUrlStat() {
        return urlStat;
    }

    public void setUrlStat(String urlStat) {
        this.urlStat = urlStat;
    }



}
