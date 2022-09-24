//POJO CLASSES

package com.task;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@ToString
@NoArgsConstructor
public class Condition {
    @JsonProperty(value = "type")
    private String type;
    @JsonProperty(value = "operator")
    private String operator;
    @JsonProperty(value = "value")
    private String value;

}
