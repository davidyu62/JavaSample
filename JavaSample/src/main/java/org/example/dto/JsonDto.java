package org.example.dto;

import java.util.Arrays;
import java.util.List;

public class JsonDto {
    int port;
    String name;
    List<Rule> rules;

    public JsonDto(int port,String name, List rules){
        this.port = port;
        this.name = name;
        this.rules = rules;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public int getPort() {
        return port;
    }

    public String getName() {
        return name;
    }

    public List<Rule> getRules() {
        return rules;
    }

    @Override
    public String toString() {
        return "JsonDto{" +
                "port=" + port +
                ", name='" + name + '\'' +
                ", rules=" + rules.get(1).toString() +
                '}';
    }


}

class Rule{
    String key;
    String value;

    public Rule(String key, String value){
        this.key = key;
        this.value = value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value){
        this.value = value;
    }

    public String getKey(){
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
