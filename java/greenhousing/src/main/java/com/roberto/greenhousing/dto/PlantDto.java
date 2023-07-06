package com.roberto.greenhousing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlantDto {

    private Integer id;
    private String tag;
    private Integer speciesId;
    private Integer wateringFrequency;

}
