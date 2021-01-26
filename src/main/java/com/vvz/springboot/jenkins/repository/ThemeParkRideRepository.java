package com.vvz.springboot.jenkins.repository;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.vvz.springboot.jenkins.entity.ThemeParkRide;

@Repository
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public interface ThemeParkRideRepository extends CrudRepository<ThemeParkRide, Long>{
	List<ThemeParkRide> findByName(String name);

}
