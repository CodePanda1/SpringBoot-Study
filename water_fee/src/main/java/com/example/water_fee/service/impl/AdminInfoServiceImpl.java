package com.example.water_fee.service.impl;

import com.example.water_fee.entity.AdminInfo;
import com.example.water_fee.repository.AdminInfoRepository;
import com.example.water_fee.repository.UserInfoRepository;
import com.example.water_fee.repository.UserRechargeRepository;
import com.example.water_fee.service.AdminInfoService;
import com.example.water_fee.vo.AdminInfoVO;
import com.example.water_fee.vo.adminechartvo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
public class AdminInfoServiceImpl implements AdminInfoService {

    @Autowired
    private AdminInfoRepository adminInfoRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private UserRechargeRepository userRechargeRepository;

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
    public AdminChartVO findAdminChartVO() {
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

        List<XAxisVO> xAxisVOList = new ArrayList<>();
        XAxisVO xAxisVO = new XAxisVO();

        xAxisVOList.add(xAxisVO);
        adminChartVO.setXAxis(xAxisVOList);

        List<YAxisVO> yAxisVOList = new ArrayList<>();
        YAxisVO yAxisVO = new YAxisVO();
        yAxisVOList.add(yAxisVO);
        adminChartVO.setYAxis(yAxisVOList);

        List<SeriesVO> seriesVOList = new ArrayList<>();
        SeriesVO seriesVO = new SeriesVO();
        seriesVOList.add(seriesVO);
        adminChartVO.setSeries(seriesVOList);

        return adminChartVO;
    }
}
