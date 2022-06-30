package com.company.team.award.lottery.repo.cache;

import com.company.team.award.lottery.aggregate.DrawLottery;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jinhua
 * @version 1.0
 * @date 2022/6/30 19:41
 */
@Repository
public class DrawLotteryCacheAccessImpl implements DrawLotteryCacheAccess {

    private Map<Integer, DrawLottery> id2DrawLotteryCacheMap = new ConcurrentHashMap<>();

    @Override
    public DrawLottery get(int lotteryId) {
        return this.id2DrawLotteryCacheMap.get(lotteryId);
    }

    @Override
    public void add(int lotteryId, DrawLottery drawLottery) {
        this.id2DrawLotteryCacheMap.put(lotteryId, drawLottery);
    }

    @Override
    public void clear(int lotteryId) {
        this.id2DrawLotteryCacheMap.remove(lotteryId);
    }

    @Override
    public void clearAll() {
        this.id2DrawLotteryCacheMap.clear();
    }
}
