package com.company.team.award.lottery.valobj;

import lombok.Data;

/**
 * 【抽奖上下文】
 *
 * @author Jinhua
 * @version 1.0
 * @date 2022/6/30 17:41
 */
@Data
public class DrawLotteryContext {

    private MtCityInfo mtCityInfo;
    private Integer gameScore;
}
