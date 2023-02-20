package com.example.project_loa.loa;

import lombok.Data;

import java.util.List;

@Data
public class Gems2VO {
    private List<Gem2VO> gems;
    private List<GemEffect2VO> effects;
}
