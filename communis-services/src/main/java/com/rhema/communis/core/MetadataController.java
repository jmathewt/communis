package com.rhema.communis.core;

import com.neovisionaries.i18n.CountryCode;
import com.rhema.communis.common.CommunisError;
import com.rhema.communis.common.CommunisResponse;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/core")
@Api(tags = "Core Apis")
public class MetadataController {

    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    @ResponseBody
    public CommunisResponse countries() {
        try {
            List<Map<String, String>> countries = new ArrayList<>();
            for (CountryCode code : CountryCode.values()) {
                if (code.getName() != null && !code.getName().equalsIgnoreCase("Undefined")) {
                    Map<String, String> country = new HashMap<>();
                    country.put("name", code.getName());
                    country.put("code", code.toString());
                    countries.add(country);
                }
            }
            return new CommunisResponse(countries);
        } catch (ResponseStatusException r) {
            return new CommunisResponse(new CommunisError(r.getMessage()));
        } catch (Exception e) {
            return new CommunisResponse(new CommunisError(e.getMessage()));
        }
    }
}
