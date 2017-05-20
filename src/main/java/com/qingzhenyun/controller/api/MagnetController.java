package com.qingzhenyun.controller.api;

import com.qingzhenyun.entity.Magnet;
import com.qingzhenyun.service.OfflineTaskService;
import com.qingzhenyun.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.text.ParseException;

/**
 * HoHo
 * Created by guna on 2017/5/17.
 */
@RestController
@Slf4j
@RequestMapping("/api/magnet")
public class MagnetController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean add(String url, Integer userId) {
        userId = UserUtil.ensureUserIdNotNull(userId);
        url = UserUtil.ensureDataNotNull(url, "URL_COULD_NOT_BE_NULL");
        Magnet magnet = null;
        try {
            magnet = Magnet.parse(url);
        } catch (ParseException | UnsupportedEncodingException | URISyntaxException ex) {
            log.warn("{} parse error", url, ex);
            return false;
        }
        //
        if (magnet != null) {
            offlineTaskService.dispatchMagnetAdded(url, magnet.getInfoHash(), userId);
        }
        return true;
    }

    @Autowired
    public void setOfflineTaskService(OfflineTaskService offlineTaskService) {
        this.offlineTaskService = offlineTaskService;
    }

    private OfflineTaskService offlineTaskService;
}
