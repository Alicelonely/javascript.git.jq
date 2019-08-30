package bbs_demo.service;

import bbs_demo.dao.SummaryDao;
import bbs_demo.entity.Summary;

import java.util.List;

public class SummaryService {

    SummaryDao summaryDao = new SummaryDao();

    /**
     * 展示汇总信息
     */
    public void showSummary() {
        List<Summary> ls=  summaryDao.getAllTopic();
        for (Summary Summary : ls) {
            System.out.println(Summary.gettId()+"\t"+Summary.getTitle()+"\t"+Summary.getContext()+"\t"+Summary.getpTime()
                    +"\t"+Summary.getuName()+"\t"+Summary.getbId()+"\t"+Summary.getbName());
        }
    }
}
