package com.example.project_loa.loa;

import lombok.Data;

import java.util.List;

@Data
public class GemsVO {
    private List<GemVO> Gems;
    private List<GemEffectVO> Effects;
}
