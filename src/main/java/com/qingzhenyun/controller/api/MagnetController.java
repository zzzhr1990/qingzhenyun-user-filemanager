package com.qingzhenyun.controller.api;

import com.qingzhenyun.service.OfflineTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HoHo
 * Created by guna on 2017/5/17.
 */
@RestController
@RequestMapping("/api/magnet")
public class MagnetController {

    @RequestMapping(value = "/add")
    public boolean add(String url, Integer userId) {
        offlineTaskService.dispatchMagnetAdded(url, userId);
        return true;
    }

    @Autowired
    public void setOfflineTaskService(OfflineTaskService offlineTaskService) {
        this.offlineTaskService = offlineTaskService;
    }

    private OfflineTaskService offlineTaskService;
}
