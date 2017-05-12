package com.qingzhenyun.autoconfig.wcs;

import com.qingzhenyun.wcs.entity.PutPolicy;
import com.qingzhenyun.wcs.util.TokenUtil;

/**
 * Wcs Api
 * Created by guna on 2017/5/12.
 */
public class WcsApi {
    private WcsProperties wcsProperties;

    public WcsApi(WcsProperties wcsProperties) {
        this.wcsProperties = wcsProperties;
    }

    public String getUploadToken(PutPolicy putPolicy) {
        return TokenUtil.getUploadToken(putPolicy, wcsProperties.getAk(),
                wcsProperties.getSk());
    }

    public String getUploadUrl() {
        return "http://" + this.wcsProperties.getUdomain() + "/file/upload";
    }
}
