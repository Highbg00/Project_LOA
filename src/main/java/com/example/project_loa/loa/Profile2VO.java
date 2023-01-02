package com.example.project_loa.loa;

import lombok.Data;

import java.util.List;

@Data
public class Profile2VO {
    private String characterImage, pvpGradeName, townName, title, guildMemberGrade, guildName, serverName, characterName,
            characterClassName, itemAvgLevel, itemMaxLevel;
    private int expeditionLevel, townLevel, characterLevel;
    private List<StatVO> stats;
    private List<TendencyVO> tendencies;
}
