package com.qingzhenyun.autoconfig.wcs;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * HOHO
 * Created by guna on 2017/5/12.
 */
@ConfigurationProperties(prefix = "wcs.conf")
public class WcsProperties {
    private String ak;
    private String sk;
    private String mdomain;
    private String udomain;

    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public String getSk() {
        return sk;
    }

    public void setSk(String sk) {
        this.sk = sk;
    }

    public String getMdomain() {
        return mdomain;
    }

    public void setMdomain(String mdomain) {
        this.mdomain = mdomain;
    }

    public String getUdomain() {
        return udomain;
    }

    public void setUdomain(String udomain) {
        this.udomain = udomain;
    }
}
