package com.cqupt.laboratorysystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GPU {

    private long id;

    private String name;

    private String detail;

    private boolean isFree;

}
