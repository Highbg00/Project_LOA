package com.example.project_loa.loa;

import lombok.Data;

import java.util.List;

@Data
public class Cardset2VO {
    private List<CardVO> cards;
    private List<CardeffectVO> effects;
}
