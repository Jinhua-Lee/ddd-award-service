package com.company.team.award.lottery.repo.cache;

import com.company.team.award.lottery.aggregate.DrawLottery;

/**
 * 【抽奖缓存】获取
 *
 * @author Jinhua
 * @version 1.0
 * @date 2022/6/30 19:41
 */
public interface DrawLotteryCacheAccess {

    /**
     * 【抽奖聚合】缓存获取
     *
     * @param lotteryId 抽奖ID
     * @return 【抽奖】聚合
     */
    DrawLottery get(int lotteryId);

    /**
     * 【抽奖聚合】缓存写入
     *
     * @param lotteryId   抽奖ID
     * @param drawLottery 【抽奖聚合】待写入缓存
     */
    void add(int lotteryId, DrawLottery drawLottery);

    /**
     * 清指定【抽奖ID】缓存
     *
     * @param lotteryId 抽奖ID
     */
    void clear(int lotteryId);

    /**
     * 清楚所有【抽奖ID】缓存
     */
    void clearAll();
}
