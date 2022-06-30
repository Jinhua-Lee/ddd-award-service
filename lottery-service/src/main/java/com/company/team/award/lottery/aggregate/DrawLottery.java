package com.company.team.award.lottery.aggregate;

import com.company.team.award.lottery.valobj.AwardPool;
import com.company.team.award.lottery.valobj.DrawLotteryContext;
import com.company.team.award.lottery.valobj.MtCityInfo;

import java.util.List;
import java.util.Optional;

/**
 * 【抽奖】聚合根
 *
 * @author Jinhua
 * @version 1.0
 * @date 2022/6/30 17:26
 */
public class DrawLottery {

    private int lotteryId;
    private List<AwardPool> awardPools;

    public void setLotteryId(int lotteryId) {
        // setter校验入参合法性
        if (lotteryId < 0) {
            throw new IllegalArgumentException("非法抽奖id!");
        }
        this.lotteryId = lotteryId;
    }

    public Optional<AwardPool> chooseAwardPool(DrawLotteryContext context) {
        return context.getMtCityInfo() == null
                ? chooseByCityInfo(this.awardPools, context.getMtCityInfo())
                : chooseByScore(this.awardPools, context.getGameScore());
    }

    private Optional<AwardPool> chooseByCityInfo(List<AwardPool> awardPools, MtCityInfo cityInfo) {
        return awardPools.stream().filter(aPool -> aPool.matchedCity(cityInfo.getCityId())).findFirst();
    }

    private Optional<AwardPool> chooseByScore(List<AwardPool> awardPools, int gameScore) {
        return awardPools.stream().filter(aPool -> aPool.matchedScore(gameScore)).findFirst();
    }
}
