package com.example.water_fee.service.impl;

import com.example.water_fee.entity.AdminInfo;
import com.example.water_fee.repository.AdminInfoRepository;
import com.example.water_fee.repository.UserInfoRepository;
import com.example.water_fee.repository.UserRechargeRepository;
import com.example.water_fee.repository.UserStatisticsRepository;
import com.example.water_fee.service.AdminInfoService;
import com.example.water_fee.util.DateUtil;
import com.example.water_fee.vo.AdminInfoVO;
import com.example.water_fee.vo.adminechartvo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class AdminInfoServiceImpl implements AdminInfoService {

    @Autowired
    private AdminInfoRepository adminInfoRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private UserRechargeRepository userRechargeRepository;
    @Autowired
    private UserStatisticsRepository userStatisticsRepository;

    @Override
    public AdminInfoVO findAdminInfoVO() {
        AdminInfoVO adminInfoVO = new AdminInfoVO();
        AdminInfo adminInfo = adminInfoRepository.findAll().get(0);
        adminInfoVO.setUnitPrice(adminInfo.getUnitPrice());

        List<Integer[]> SumRegisterList = userInfoRepository.findSumRegister();
        for (Integer[] objs : SumRegisterList) {
            for (Integer obj : objs) {
                adminInfoVO.setSumRegister(obj);
            }
        }

        List<BigDecimal[]> MoneyLeftList = userInfoRepository.findSumMoneyLeft();
        for (BigDecimal[] objs : MoneyLeftList) {
            for (BigDecimal obj : objs) {
                adminInfoVO.setSumMoneyLeft(obj);
            }
        }

        List<BigDecimal[]> SumWaterLeftList = userInfoRepository.findSumWaterLeft();
        for (BigDecimal[] objs : SumWaterLeftList) {
            for (BigDecimal obj : objs) {
                adminInfoVO.setSumWaterLeft(obj);
            }
        }

        List<Integer[]> list = userRechargeRepository.findSumRecharge();
        for (Integer[] objs : list) {
            for (Integer obj : objs) {
                adminInfoVO.setSumRecharge(obj);
            }
        }

        return adminInfoVO;
    }

    @Override
    public AdminChartVO findAdminChartVO() throws Exception {
        AdminChartVO adminChartVO = new AdminChartVO();

        TitleVO titleVO = new TitleVO();
        adminChartVO.setTitle(titleVO);

        TooltipVO tooltipVO = new TooltipVO();
        adminChartVO.setTooltip(tooltipVO);

        LegendVO legendVO = new LegendVO();
        adminChartVO.setLegend(legendVO);

        ToolboxVO toolboxVO = new ToolboxVO();
        FeatureVO featureVO = new FeatureVO();
        MarkVO markVO = new MarkVO();
        featureVO.setMark(markVO);
        DataViewVO dataViewVO = new DataViewVO();
        featureVO.setDataView(dataViewVO);
        MagicTypeVO magicTypeVO = new MagicTypeVO();
        featureVO.setMagicType(magicTypeVO);
        RestoreVO restoreVO = new RestoreVO();
        featureVO.setRestore(restoreVO);
        SaveAsImageVO saveAsImageVO = new SaveAsImageVO();
        featureVO.setSaveAsImage(saveAsImageVO);
        toolboxVO.setFeature(featureVO);
        adminChartVO.setToolbox(toolboxVO);

        //SeriesVO
        List<SeriesVO> seriesVOList = new ArrayList<>();

        SeriesVO seriesVO1 = new SeriesVO();
        seriesVO1.setName("当月活跃");
        ItemStyleVO itemStyleVO = new ItemStyleVO();
        NormalVO normalVO = new NormalVO();
        itemStyleVO.setNormal(normalVO);
        Map<String, String> areaStyle = new HashMap<>();
        areaStyle.put("type","default");
        normalVO.setAreaStyle(areaStyle);
        seriesVO1.setItemStyle(itemStyleVO);
        List<String> dateUtil = DateUtil.getMonthBetween();
        List<BigDecimal> seriesVO1dateList = new ArrayList<>();
        for (Object time : dateUtil) {
            seriesVO1dateList.add(userStatisticsRepository.CountStatisticsUser((String) time));
        }
        seriesVO1.setData(seriesVO1dateList);
        seriesVOList.add(seriesVO1);

        SeriesVO seriesVO2 = new SeriesVO();
        seriesVO2.setName("总余额");
        List<BigDecimal> seriesVO2dateList = new ArrayList<>();
        for (Object time : dateUtil) {
            seriesVO2dateList.add(userRechargeRepository.SumRechargeAmount((String) time));
        }
        seriesVO2.setData(seriesVO2dateList);
        seriesVO2.setItemStyle(itemStyleVO);
        seriesVOList.add(seriesVO2);

        SeriesVO seriesVO3 = new SeriesVO();
        seriesVO3.setName("总用水量");
        List<BigDecimal> seriesVO3dateList = new ArrayList<>();
        for (Object time : dateUtil) {
            seriesVO3dateList.add(userStatisticsRepository.SumStatisticsAmount((String) time));
        }
        seriesVO3.setData(seriesVO3dateList);
        seriesVO3.setItemStyle(itemStyleVO);
        seriesVOList.add(seriesVO3);

        adminChartVO.setSeries(seriesVOList);

        //XAxisVO
        List<XAxisVO> xAxisVOList = new ArrayList<>();
        XAxisVO xAxisVO = new XAxisVO();
        xAxisVO.setData(DateUtil.getMonthBetween());
        xAxisVOList.add(xAxisVO);
        adminChartVO.setXAxis(xAxisVOList);

        //YAxisVO
        List<YAxisVO> yAxisVOList = new ArrayList<>();
        YAxisVO yAxisVO = new YAxisVO();
        yAxisVOList.add(yAxisVO);
        adminChartVO.setYAxis(yAxisVOList);

        return adminChartVO;
    }
}
