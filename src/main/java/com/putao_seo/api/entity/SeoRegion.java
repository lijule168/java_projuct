package com.putao_seo.api.entity;

import java.io.Serializable;
import java.util.List;

public class SeoRegion implements Serializable {
    private static final long serialVersionUID = 1L;
    private String regionCode;

    private String regionName;

    private Integer regionLevel;

    private String pid;

    private String pidPath;

    private List<SeoRegion> subRegion;

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Integer getRegionLevel() {
        return regionLevel;
    }

    public void setRegionLevel(Integer regionLevel) {
        this.regionLevel = regionLevel;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPidPath() {
        return pidPath;
    }

    public void setPidPath(String pidPath) {
        this.pidPath = pidPath;
    }

    public List<SeoRegion> getSubRegion() {
        return subRegion;
    }

    public void setSubRegion(List<SeoRegion> subRegion) {
        this.subRegion = subRegion;
    }
}