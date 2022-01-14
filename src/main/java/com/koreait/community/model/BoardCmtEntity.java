package com.koreait.community.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardCmtEntity {
    private int icmt;
    private int iboard;
    private int iuser;
    private String ctnt;
    private String rdt;
    private String mdt;
}
