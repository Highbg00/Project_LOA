package com.example.project_loa.loa;

import lombok.Data;

import java.util.List;

@Data
public class ProfileVO {
    private String CharacterImage, PvpGradeName, TownName, Title, GuildMemberGrade, GuildName, ServerName, CharacterName,
                    CharacterClassName, ItemAvgLevel, ItemMaxLevel;
    private int ExpeditionLevel, TownLevel, CharacterLevel;
    private List<StatVO> Stats;
    private List<TendencyVO> Tendencies;
}
