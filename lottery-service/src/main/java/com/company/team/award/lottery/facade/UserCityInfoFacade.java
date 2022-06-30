package com.company.team.award.lottery.facade;

import com.company.team.award.lottery.other.LbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 【城市信息】门面
 *
 * @author Jinhua
 * @version 1.0
 * @date 2022/6/30 19:15
 */
@Component
public class UserCityInfoFacade {

    private LbsService lbsService;

    @Autowired
    public void setLbsService(LbsService lbsService) {
        this.lbsService = lbsService;
    }


}
