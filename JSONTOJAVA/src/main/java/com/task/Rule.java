//POJO CLASSES

package com.task;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.task.Condition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Data
@ToString
public class Rule {

    @JsonProperty(value = "field_name")
    private String fieldName;
    @JsonProperty(value = "field_type")
    private String fieldType;
    @JsonProperty(value = "condition")
    private Condition condition;
}
