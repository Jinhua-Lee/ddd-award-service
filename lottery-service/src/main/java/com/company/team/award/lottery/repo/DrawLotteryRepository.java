package com.company.team.award.lottery.repo;

import com.company.team.award.lottery.aggregate.DrawLottery;
import com.company.team.award.lottery.repo.cache.DrawLotteryCacheAccess;
import com.company.team.award.lottery.repo.dao.AwardDao;
import com.company.team.award.lottery.repo.dao.AwardPoolDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Jinhua
 * @version 1.0
 * @date 2022/6/30 18:57
 */
@Repository
public class DrawLotteryRepository {

    private AwardDao awardDao;
    private AwardPoolDao awardPoolDao;
    private DrawLotteryCacheAccess drawerCacheAccess;

    public DrawLottery getById(int lotteryId) {
        DrawLottery drawLottery = drawerCacheAccess.get(lotteryId);
        if (drawLottery != null) {
            return drawLottery;
        }
        drawLottery = getByIdFromDb(lotteryId);
        drawerCacheAccess.add(lotteryId, drawLottery);
        return drawLottery;
    }

    private DrawLottery getByIdFromDb(int lotteryId) {
        return null;
    }


    @Autowired
    public void setAwardDao(AwardDao awardDao) {
        this.awardDao = awardDao;
    }

    @Autowired
    public DrawLotteryRepository(AwardPoolDao awardPoolDao) {
        this.awardPoolDao = awardPoolDao;
    }

    @Autowired
    public void setDrawerCacheAccess(DrawLotteryCacheAccess drawerCacheAccess) {
        this.drawerCacheAccess = drawerCacheAccess;
    }
}
