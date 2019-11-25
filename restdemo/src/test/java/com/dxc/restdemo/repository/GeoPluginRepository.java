package com.dxc.restdemo.repository;

import com.dxc.restdemo.entity.GeoPlugin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoPluginRepository extends JpaRepository <GeoPlugin,String> {

}
