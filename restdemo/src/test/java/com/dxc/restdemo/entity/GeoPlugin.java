package com.dxc.restdemo.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@XmlRootElement(name="geoPlugin")
@XmlAccessorType(XmlAccessType.FIELD)
public class GeoPlugin {

        @Id
        private String geoplugin_request;
        private String geoplugin_status;
        private String geoplugin_delay;
        private String geoplugin_credit;
        private String geoplugin_city;
        private String geoplugin_region;
        private String geoplugin_regionCode;
        private String geoplugin_regionName;
        private String geoplugin_areaCode;
        private String geoplugin_dmaCode;
        private String geoplugin_countryCode;
        private String geoplugin_countryName;
        private String geoplugin_inEU;
        private String geoplugin_euVATrate;
        private String geoplugin_continentCode;
        private String geoplugin_continentName;
        private String geoplugin_latitude;
        private String geoplugin_longitude;
        private String geoplugin_locationAccuracyRadius;
        private String geoplugin_timezone;
        private String geoplugin_currencyCode;
        private String geoplugin_currencySymbol;
        private String geoplugin_currencySymbol_UTF8;
        private String geoplugin_currencyConverter;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GeoPlugin)) return false;
        GeoPlugin geoPlugin = (GeoPlugin) o;
        return Objects.equal(getGeoplugin_request(), geoPlugin.getGeoplugin_request()) &&
                Objects.equal(getGeoplugin_status(), geoPlugin.getGeoplugin_status()) &&
                Objects.equal(getGeoplugin_delay(), geoPlugin.getGeoplugin_delay()) &&
                Objects.equal(getGeoplugin_credit(), geoPlugin.getGeoplugin_credit()) &&
                Objects.equal(getGeoplugin_city(), geoPlugin.getGeoplugin_city()) &&
                Objects.equal(getGeoplugin_region(), geoPlugin.getGeoplugin_region()) &&
                Objects.equal(getGeoplugin_regionCode(), geoPlugin.getGeoplugin_regionCode()) &&
                Objects.equal(getGeoplugin_regionName(), geoPlugin.getGeoplugin_regionName()) &&
                Objects.equal(getGeoplugin_areaCode(), geoPlugin.getGeoplugin_areaCode()) &&
                Objects.equal(getGeoplugin_dmaCode(), geoPlugin.getGeoplugin_dmaCode()) &&
                Objects.equal(getGeoplugin_countryCode(), geoPlugin.getGeoplugin_countryCode()) &&
                Objects.equal(getGeoplugin_countryName(), geoPlugin.getGeoplugin_countryName()) &&
                Objects.equal(getGeoplugin_inEU(), geoPlugin.getGeoplugin_inEU()) &&
                Objects.equal(getGeoplugin_euVATrate(), geoPlugin.getGeoplugin_euVATrate()) &&
                Objects.equal(getGeoplugin_continentCode(), geoPlugin.getGeoplugin_continentCode()) &&
                Objects.equal(getGeoplugin_continentName(), geoPlugin.getGeoplugin_continentName()) &&
                Objects.equal(getGeoplugin_latitude(), geoPlugin.getGeoplugin_latitude()) &&
                Objects.equal(getGeoplugin_longitude(), geoPlugin.getGeoplugin_longitude()) &&
                Objects.equal(getGeoplugin_locationAccuracyRadius(), geoPlugin.getGeoplugin_locationAccuracyRadius()) &&
                Objects.equal(getGeoplugin_timezone(), geoPlugin.getGeoplugin_timezone()) &&
                Objects.equal(getGeoplugin_currencyCode(), geoPlugin.getGeoplugin_currencyCode()) &&
                Objects.equal(getGeoplugin_currencySymbol(), geoPlugin.getGeoplugin_currencySymbol()) &&
                Objects.equal(getGeoplugin_currencySymbol_UTF8(), geoPlugin.getGeoplugin_currencySymbol_UTF8()) &&
                Objects.equal(getGeoplugin_currencyConverter(), geoPlugin.getGeoplugin_currencyConverter());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getGeoplugin_request(), getGeoplugin_status(), getGeoplugin_delay(), getGeoplugin_credit(), getGeoplugin_city(), getGeoplugin_region(), getGeoplugin_regionCode(), getGeoplugin_regionName(), getGeoplugin_areaCode(), getGeoplugin_dmaCode(), getGeoplugin_countryCode(), getGeoplugin_countryName(), getGeoplugin_inEU(), getGeoplugin_euVATrate(), getGeoplugin_continentCode(), getGeoplugin_continentName(), getGeoplugin_latitude(), getGeoplugin_longitude(), getGeoplugin_locationAccuracyRadius(), getGeoplugin_timezone(), getGeoplugin_currencyCode(), getGeoplugin_currencySymbol(), getGeoplugin_currencySymbol_UTF8(), getGeoplugin_currencyConverter());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("geoplugin_request", geoplugin_request)
                .add("geoplugin_status", geoplugin_status)
                .add("geoplugin_delay", geoplugin_delay)
                .add("geoplugin_credit", geoplugin_credit)
                .add("geoplugin_city", geoplugin_city)
                .add("geoplugin_region", geoplugin_region)
                .add("geoplugin_regionCode", geoplugin_regionCode)
                .add("geoplugin_regionName", geoplugin_regionName)
                .add("geoplugin_areaCode", geoplugin_areaCode)
                .add("geoplugin_dmaCode", geoplugin_dmaCode)
                .add("geoplugin_countryCode", geoplugin_countryCode)
                .add("geoplugin_countryName", geoplugin_countryName)
                .add("geoplugin_inEU", geoplugin_inEU)
                .add("geoplugin_euVATrate", geoplugin_euVATrate)
                .add("geoplugin_continentCode", geoplugin_continentCode)
                .add("geoplugin_continentName", geoplugin_continentName)
                .add("geoplugin_latitude", geoplugin_latitude)
                .add("geoplugin_longitude", geoplugin_longitude)
                .add("geoplugin_locationAccuracyRadius", geoplugin_locationAccuracyRadius)
                .add("geoplugin_timezone", geoplugin_timezone)
                .add("geoplugin_currencyCode", geoplugin_currencyCode)
                .add("geoplugin_currencySymbol", geoplugin_currencySymbol)
                .add("geoplugin_currencySymbol_UTF8", geoplugin_currencySymbol_UTF8)
                .add("geoplugin_currencyConverter", geoplugin_currencyConverter)
                .toString();
    }
}
