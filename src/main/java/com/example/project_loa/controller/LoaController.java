package com.example.project_loa.controller;


import com.example.project_loa.loa.*;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import lombok.extern.log4j.Log4j2;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Log4j2
public class LoaController {

    @Autowired private LoaServiceImpl service;

    @RequestMapping("/search")
    public String search(String userid, Model model) {
        System.out.println(userid);
        Profile2VO profile2 = new Profile2VO();
        List<Stat2VO> statlist = new ArrayList<Stat2VO>();
        List<Tendency2VO> tendencyList = new ArrayList<Tendency2VO>();
        List<EquipmentVO> equipmentList = new ArrayList<EquipmentVO>();
        List<Card2VO> cardlist = new ArrayList<Card2VO>();
        List<Cardeffect2VO> cardeffectlist = new ArrayList<Cardeffect2VO>();
        String str = null;
        ProfileVO profile = service.Profile(userid);
        JSONArray array = service.Equipment(userid);
        CardsetVO cards = service.Cards(userid);

        profile2.setCharacterName(profile.getCharacterName());
        profile2.setCharacterImage(profile.getCharacterImage());
        profile2.setPvpGradeName(profile.getPvpGradeName());
        profile2.setTownName(profile.getTownName());
        profile2.setTitle(profile.getTitle());
        profile2.setGuildMemberGrade(profile.getGuildMemberGrade());
        profile2.setGuildName(profile.getGuildName());
        profile2.setServerName(profile.getServerName());
        profile2.setCharacterClassName(profile.getCharacterClassName());
        profile2.setItemAvgLevel(profile.getItemAvgLevel());
        profile2.setCharacterLevel(profile.getCharacterLevel());
        profile2.setTownLevel(profile.getTownLevel());
        profile2.setExpeditionLevel(profile.getExpeditionLevel());

        for(int i = 1; i <= profile.getStats().size(); i++){
            StatVO stat2;
            Stat2VO stat = new Stat2VO();
            stat2 = profile.getStats().get(i-1);
            stat.setType(stat2.getType());
            stat.setValue(stat2.getValue());
            statlist.add(i-1, stat);
        }

        for(int i = 1; i <= profile.getTendencies().size(); i++){
            TendencyVO tendency2;
            Tendency2VO tendency = new Tendency2VO();
            tendency2 = profile.getTendencies().get(i-1);
            tendency.setType(tendency2.getType());
            tendency.setPoint(tendency2.getPoint());
            tendencyList.add(i-1, tendency);
        }

        for(int i = 0; i < array.length(); i++) {
            EquipmentVO eq = new Gson().fromJson(array.get(i).toString(),EquipmentVO.class);
            equipmentList.add(i,eq);
        }

        for(int i = 1; i <= cards.getCards().size(); i++){
            CardVO card2;
            Card2VO card = new Card2VO();
            card2 = cards.getCards().get(i-1);
            card.setSlot(card2.getSlot());
            card.setName(card2.getName());
            card.setIcon(card2.getIcon());
            card.setGrade(card2.getGrade());
            card.setAwakeTotal(card2.getAwakeTotal());
            card.setAwakeCount(card2.getAwakeCount());
            card.setSlot(card2.getSlot());
            cardlist.add(i-1, card);
        }

        for(int i = 1; i <= cards.getEffects().size(); i++){

            CardeffectVO cardeffect2;
            Cardeffect2VO cardeffect = new Cardeffect2VO();
            cardeffect2 = cards.getEffects().get(i-1);
            cardeffect.setIndex(cardeffect2.getIndex());

            for (int y = 1; y <= 6; /*cards.getEffects().get(y).getItems().size();*/ y++){
                List<Item2VO> items = new ArrayList<Item2VO>();
                String qq = cardeffect2.getItems().get(y-1).getName();
                cardeffect.setItems(items);
                cardeffect.getItems().get(y-1).setName(qq);
                cardeffect.getItems().get(y-1).setDescription(cardeffect2.getItems().get(y-1).getDescription());
            }
            cardeffectlist.add(i-1,cardeffect);
        }

        model.addAttribute("profile", profile2);
        model.addAttribute("statlist",statlist);
        model.addAttribute("tendencylist", tendencyList);
        model.addAttribute("equipment",equipmentList);

        return "main/search";
    }
}
