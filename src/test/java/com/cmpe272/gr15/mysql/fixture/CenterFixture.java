package com.cmpe272.gr15.mysql.fixture;

import com.cmpe272.gr15.mysql.model.dto.Center;

import java.util.Random;

/**
 * Class that generates Center objects. Use this to avoid copy pasting test objects.
 */
public class CenterFixture {

    public static Center generateValidCenter(Integer centerId) {
        Center center = new Center();
        center.setCenterName("My Awesome Center");
        center.setCenterAddress("Somewhere there");
        center.setCenterId(centerId);
        center.setChapter("chapter 1");
        center.setFacilitatorId(123345);
        center.setSevika("Sevika name 1");
        center.setSevikaPhone("111223344");
        center.setType("Anganwadi");
        center.setPincode(123345);
        center.setDistrict("3");
        center.setGeoLocation("12.1234123,-97.1234123");
        return center;
    }

    public static Center generateValidCenter() {
        double randomNumber = Math.random();
        return generateValidCenter((int)randomNumber);
    }
}
