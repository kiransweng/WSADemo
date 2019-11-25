package com.dxc.restdemo.utils;

import com.dxc.restdemo.entity.GeoPlugin;
import io.restassured.response.Response;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Created by vkuma26 on 8/26/19.
 */
@Setter
@Getter
@Component
public class ScenarioContext {

  private Response response;
  private GeoPlugin geoPluginApi;
  private List<GeoPlugin> lst_geoPluginDataBase;


}
