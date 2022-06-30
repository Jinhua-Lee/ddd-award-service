package com.company.team.award.lottery.valobj;

import com.company.team.award.lottery.entity.Award;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 【奖池】
 *
 * @author Jinhua
 * @version 1.0
 * @date 2022/6/30 17:27
 */
public class AwardPool {
    private List<Integer> supportCityIds;
    private List<Integer> scores;
    private int userGroupType;
    private List<Award> awards;

    /**
     * 是否与【城市ID】匹配
     *
     * @param cityId 指定城市ID
     * @return 是否匹配
     */
    public boolean matchedCity(int cityId) {
        return supportCityIds.stream().anyMatch(cId -> Objects.equals(cId, cityId));
    }

    /**
     * 是否与【支持的得分】匹配
     *
     * @param score 指定得分
     * @return 是否匹配
     */
    public boolean matchedScore(int score) {
        return scores.stream().anyMatch(sId -> Objects.equals(sId, score));
    }

    /**
     * 随机概率选择【奖品】
     *
     * @return 选到的【奖品】
     */
    public Award randomAward() {
        int sumOfProbability = this.awards.stream().mapToInt(Award::getProbability).sum();
        int randomNumber = ThreadLocalRandom.current().nextInt(sumOfProbability);
        int range = 0;
        for (Award award : awards) {
            range += award.getProbability();
            if (randomNumber < range) {
                return award;
            }
        }
        return null;
    }
}
